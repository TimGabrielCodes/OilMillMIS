package Controller;

import DAO.LoginDAO;
import DAO.LoginDAOImpl;
import DAO.UserDAO;
import DAO.UserDAOImpl;
import Model.Login;
import Model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/loginprocess")
public class LoginController extends HttpServlet {
    LoginDAO loginDAO = null;
    User user;
    UserDAO userDAO;
    private RequestDispatcher dispatcher;

    public LoginController() {
        loginDAO = new LoginDAOImpl();
        userDAO = new UserDAOImpl();
        user = new User();
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        Login login = new Login();
        login.setEmail(request.getParameter("email"));
        login.setPassword(request.getParameter("password"));
        String status = loginDAO.authenticate(login);
        if (status.equals("true")) {
            user = userDAO.getLogger(login.getEmail());
            session.setAttribute("email", login.getEmail() );
            System.out.println("Setting this user for thhe session " + user.toString());
            session.setAttribute("loggedIn", user);
            response.sendRedirect("dashboard");
        }
        if (status.equals("false")) {
            request.setAttribute("message", "Invalid Credentials");
//            response.sendRedirect("index.jsp?status=false");
            dispatcher = request.getRequestDispatcher("/index.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            }
        }
        if (status.equals("error")) {

            try {
                request.setAttribute("message", "AN Error occured");
//            response.sendRedirect("index.jsp?status=error");
                dispatcher = request.getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
            } catch (ServletException e) {

                throw new RuntimeException(e);

            }
        }
    }
}
