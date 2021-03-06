package DAO;

import Util.DBConnectionUtil;
import com.google.gson.Gson;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChartsDAOImpl implements  ChartsDAO {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    private final BatchDAO batchDAO;

    public ChartsDAOImpl() {
        batchDAO = new BatchDAOImpl();
    }

    @Override
    public String getCurrentMonth() {

        return null;
    }

    @Override
    public int getUnmilledBatches() {
        int count = 0;
        try {

            String sql = "SELECT COUNT(*) as prod FROM harvest group by milled having  milled = 0";
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
//SELECT COUNT(*) as manager FROM user GROUP BY role HAVING role like '%Manager'
            while (resultSet.next()) {
                count = resultSet.getInt("prod");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ChartsDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    @Override
    public int getMilledBatches() {
        int count = 0;
        try {

            String sql = "SELECT COUNT(*) as prod FROM harvest group by milled having  milled = 1";
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
//SELECT COUNT(*) as manager FROM user GROUP BY role HAVING role like '%Manager'
            while (resultSet.next()) {
                count = resultSet.getInt("prod");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ChartsDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    @Override
    public String getIncomeCostPlot() {
        Map<Object, Object> map = null;
        List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
        String dataPoints = null;
        String sql = "SELECT incomeType, SUM(amount) as sum " +
                "FROM income " +
                "GROUP BY incomeType";
        String xVal;
        Double yVal;
        Gson gson = new Gson();
        try {
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                xVal = resultSet.getString("incomeType");
                yVal = (resultSet.getDouble("sum"));
                map = new HashMap<Object, Object>();
                map.put("x", xVal );
                map.put("y", yVal);
                list.add(map);
                dataPoints = gson.toJson(list);
                   }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return dataPoints;
    }

    @Override
    public String getIncomeDatePlot() {
        Map<Object, Object> map = null;
        List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
        String dataPoints = null;
        String sql = "SELECT incomeDate, sum(amount) as sum " +
                "FROM income " +
                "GROUP BY incomeDate";
        String xVal;
        Double yVal;
        Gson gson = new Gson();
        try {
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                xVal = resultSet.getString("incomeDate");
                yVal = (resultSet.getDouble("sum"));
                map = new HashMap<Object, Object>();
                map.put("x", xVal );
                map.put("y", yVal);
                list.add(map);
                dataPoints = gson.toJson(list);
                   }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return dataPoints;
    }
    @Override
    public String getExpenseCategoryCost() {
        Map<Object, Object> map = null;
        List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
        String dataPoints = null;
        String sql = "SELECT expenseCategory, SUM(amount) as sum " +
                "FROM expense " +
                "GROUP BY expenseCategory";
        String xVal;
        Double yVal;
        Gson gson = new Gson();
        try {
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                xVal = resultSet.getString("expenseCategory");
                yVal = (resultSet.getDouble("sum"));
                map = new HashMap<Object, Object>();
                map.put("x", xVal );
                map.put("y", yVal);
                list.add(map);
                dataPoints = gson.toJson(list);
                   }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return dataPoints;
    }
    @Override
    public String getHarvestAndStockPlot() {
        Map<Object, Object> map = null;
        List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
        String dataPoints = null;
        String sql = "SELECT batch, SUM(stockInBunches) as sum " +
                "FROM harvest " +
                "GROUP BY batch";
        String xVal;
        Double yVal;
        Gson gson = new Gson();
        try {
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                xVal = batchDAO.get(Integer.parseInt(resultSet.getString("batch"))).getBatchMonth();
                yVal = (resultSet.getDouble("sum"));
                map = new HashMap<Object, Object>();
                map.put("x", xVal );
                map.put("y", yVal);
                list.add(map);
                dataPoints = gson.toJson(list);
                   }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return dataPoints;
    }

    @Override
    public Double getTotalIncome() {

        Double val = null;
        String sql = "SELECT  SUM(amount) as sum " +
                "FROM income " ;

        try {
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                val = (resultSet.getDouble("sum"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return val;
    }

    @Override
    public Double getTotalHarvestStockCost() {
        Double val = null;
        String sql = "SELECT  SUM(harvestStockCost) as sum " +
                "FROM millingExpense " ;

        try {
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                val = (resultSet.getDouble("sum"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return val;
    }

    @Override
    public Double getTotalExpenseAmount() {
        Double val = null;
        String sql = "SELECT  SUM(amount) as sum " +
                "FROM expense " ;

        try {
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                val = (resultSet.getDouble("sum"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return val;
    }

    @Override
    public Double getTotalOtherCosts() {
        Double val = null;
        String sql = "SELECT  SUM(otherCosts) as sum " +
                "FROM harvest " ;

        try {
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                val = (resultSet.getDouble("sum"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return val;
    }

    @Override
    public Double getTotalHonorarium() {
        Double val = null;
        String sql = "SELECT  SUM(honorarium) as sum " +
                "FROM harvest " ;

        try {
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                val = (resultSet.getDouble("sum"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return val;
    }

    @Override
    public Double getTotalFuel() {
        Double val = null;
        String sql = "SELECT  SUM(fuel) as sum " +
                "FROM millingExpense " ;

        try {
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                val = (resultSet.getDouble("sum"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return val;
    }

    @Override
    public Double getTotalStorage() {
        Double val = null;
        String sql = "SELECT  SUM(storage) as sum " +
                "FROM millingExpense " ;

        try {
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                val = (resultSet.getDouble("sum"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return val;
    }

    @Override
    public Double getTotalAdhoc() {
        Double val = null;
        String sql = "SELECT  SUM(adhocLabour) as sum " +
                "FROM millingExpense " ;

        try {
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                val = (resultSet.getDouble("sum"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return val;
    }

    @Override
    public Double getTotalFirewood() {
        Double val = null;
        String sql = "SELECT  SUM(firewood) as sum " +
                "FROM millingExpense " ;

        try {
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                val = (resultSet.getDouble("sum"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return val;
    }

    @Override
    public Double getTotalPlantParts() {
        Double val = null;
        String sql = "SELECT  SUM(plantParts) as sum " +
                "FROM millingExpense " ;

        try {
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                val = (resultSet.getDouble("sum"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return val;
    }

    public Double getTotalExpenses(){
       return(getTotalExpenseAmount()  + getTotalOtherCosts() + getTotalHonorarium() + getTotalFuel()  + getTotalStorage() +getTotalAdhoc() + getTotalFirewood() + getTotalPlantParts());
    }
}