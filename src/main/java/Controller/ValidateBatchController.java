package Controller;

import DAO.HarvestDAO;
import DAO.HarvestDAOImpl;
import Model.Harvest;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/validateBatch")
public class ValidateBatchController extends HttpServlet {
    HarvestDAO harvestDAO;
    private RequestDispatcher dispatcher;

    public ValidateBatchController() {
        harvestDAO = new HarvestDAOImpl();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Harvest harvestToMill = harvestDAO.getHarvestForMill(Integer.parseInt(request.getParameter("batch")));
        if (harvestToMill.getId() != 0) {
            request.setAttribute("harvest", harvestToMill);
            request.setAttribute("message", "Harvest is ready to be milled");
        } else {
            request.setAttribute("message", "Harvest not available for milling");
        }


        request.setAttribute("title", "Mill a Harvest");
        dispatcher = request.getRequestDispatcher("/Views/Admin/AddMill.jsp");
        dispatcher.forward(request, response);


    }
}
