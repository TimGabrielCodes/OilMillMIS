package Controller;

import DAO.UserDAO;
import DAO.UserDAOImpl;
import Model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/dashboard")
public class Dashboard extends HttpServlet {


    UserDAO userDAO;
    private User loggedIn;
    private RequestDispatcher dispatcher;

    public Dashboard() {
        userDAO = new UserDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        loggedIn = userDAO.getLogger(request.getSession().getAttribute("email").toString());
        loggedIn = (User) request.getSession().getAttribute("loggedIn");
        request.setAttribute("loggedIn", loggedIn);
//        System.out.println("Logged in is" + loggedIn.toString());
        if (loggedIn.isAdmin()) {
            adminDashboard(request, response);
        } else {
            clerkDashboard(request, response);
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        adminDashboard(request, response);

    }

    private void adminDashboard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", "Dashboard");

        dispatcher = getServletContext().getRequestDispatcher("/admin");
        dispatcher.forward(request, response);
    }

    private void managerDashboard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dispatcher = getServletContext().getRequestDispatcher("/ManagerController");
        dispatcher.forward(request, response);
    }

    private void warehouseDashboard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dispatcher = getServletContext().getRequestDispatcher("/WarehouseManager");
        dispatcher.forward(request, response);
    }

    private void clerkDashboard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dispatcher = getServletContext().getRequestDispatcher("/ClerkController");
        dispatcher.forward(request, response);

    }


}
