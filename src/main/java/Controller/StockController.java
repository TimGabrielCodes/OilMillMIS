package Controller;

import DAO.*;
import Model.Batch;
import Model.MillingProduct;
import Model.StockItem;
import Model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(value = "/stocks")
public class StockController extends HttpServlet {
    private final UserDAO userDAO;
    BatchDAO batchDAO;

    StockItemDAO stockItemDAO;
    private RequestDispatcher dispatcher;

    MillingProductDAO millingProductDAO;

    public StockController() {
        batchDAO = new BatchDAOImpl();
        userDAO = new UserDAOImpl();
        stockItemDAO = new StockItemDAOImpl();
        millingProductDAO = new MillingProductDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "STOCKS";
        }
        switch (action) {
            case "STOCKS":
                listStock(request, response);
                break;

            case "NEW":
                newStock(request, response);
                break;
            case "DELETE":
                deleteBatch(request, response);
                break;
            case "EDIT":
                editBatch(request, response);

            default:
                listStock(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Date batchDate = Date.valueOf(request.getParameter("batchDate"));

        User logger = userDAO.getLogger((String) request.getSession().getAttribute("email"));
        String batchId = request.getParameter("batchId");
        String batchName = request.getParameter("batchName");
        LocalDate localDate = batchDate.toLocalDate();

        Batch batch = new Batch();
        batch.setBatchName(batchName);
        batch.setBatchMonth(localDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH) +"-"+localDate.getYear());
        batch.setLogger(logger);
        batch.setBatchDate(Date.valueOf(localDate));
        batch.setHarvested(false);

        if (batchId.isEmpty()) {
            //save if
            if (batchDAO.saveBatch(batch)) {
                request.setAttribute("message", "batch saved Successfully");
            }
        } else {
            //update
            batch.setId(Integer.parseInt(batchId));

            if (batchDAO.updateBatch(batch)) {
                request.setAttribute("message", "Batch updated Successfully");
            }
        }
        listStock(request, response);


    }

    public void listStock(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            List<StockItem> list = stockItemDAO.get();
            MillingProduct millingProduct = millingProductDAO.get();
            request.setAttribute("prod", millingProduct);
            request.setAttribute("list", list);
            request.setAttribute("title", "Stock List");
            dispatcher = request.getRequestDispatcher("/Views/Admin/Stock.jsp");
            dispatcher.forward(request, response);
        } catch (IOException ex) {
            Logger.getLogger(StockController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void newStock(HttpServletRequest request, HttpServletResponse response) {

        try {
            User user = userDAO.getLogger((String) request.getSession().getAttribute("email"));
            user.setFullName();
            request.setAttribute("user", user);
            request.setAttribute("title", "Add new Stock Item");
            dispatcher = request.getRequestDispatcher("/Views/Admin/AddStock.jsp");

            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    public void deleteBatch(HttpServletRequest request, HttpServletResponse response) throws ServletException {


        String id = request.getParameter("id");


        if (batchDAO.delete(Integer.parseInt(id))) {
            request.setAttribute("title", "Delete Batch");
            request.setAttribute("message", "Batch Deleted!");

        }
        listStock(request, response);

    }

    public void editBatch(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Batch batch = batchDAO.get(Integer.parseInt(id));
        request.setAttribute("title", "Edit Batch");
        request.setAttribute("batch", batch);
        dispatcher = request.getRequestDispatcher("/Views/Admin/AddBatch.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

}
