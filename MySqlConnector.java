package sample;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.*;

class MySqlConnector {
    static Connection conn = null;
    public static final String url ="jdbc:mysql://localhost:3306/";
    public static final String db = "mobiledb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String user="root";
    public static final String pass="";


    public static void getconnection(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Connected");
            conn = DriverManager.getConnection(url+db,user,pass);
            System.out.println("Connection Established");
        }

        catch (ClassNotFoundException e)
        { System.out.println("Driver not Loaded. ERROR: "+e); }
        catch (SQLException e)
        { System.out.println("Link Not Established. ERROR: "+e); }

    }

    public static void closeconnection()
    {
        try {
        conn.close();
        System.out.println("Connection Closed");
    }
    catch (SQLException e)
    {System.out.println("Connection Cannot be Closed. ERROR: "+e);}}

    //Function to Insert,Delete and Update
    public static String  dbExecuteQuery(String sqlStmt) throws SQLException,ClassNotFoundException
    {
        Statement stmt = null;

        try {
            getconnection();
            stmt = conn.createStatement();
            stmt.executeUpdate(sqlStmt);

            }
        catch (SQLException e)
             {return "Error occurred";
                 // System.out.println("Error in Executing Query: " +e);
             }

        finally {
            if (stmt != null)
                stmt.close();
            closeconnection();
                }
        return null;
    }

    //Funtion to Retrive Data

    public static ResultSet dbRetreiveQuery(String sqlQuery) throws ClassNotFoundException,SQLException
    {
        Statement stmt = null;
        ResultSet resultset = null;
        CachedRowSetImpl crs = null;

        try {
            getconnection();
            stmt = conn.createStatement();
            resultset = stmt.executeQuery(sqlQuery);
            crs = new CachedRowSetImpl();
            crs.populate(resultset);
             }

        catch (SQLException e)
                { System.out.println("Error in Retrieving Database: "+e); }

        finally {
                if(stmt!=null) stmt.close();
                if (resultset!=null) resultset.close();
                closeconnection();
                }
        return crs;
    }
}

