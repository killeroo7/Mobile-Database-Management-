package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Phones
{
    public static void insertphones(String m_name,String m_model, String m_brand,int m_price,String m_pcamera,String m_scamera,String m_ram,String m_processor,String m_storage,String m_battery) throws ClassNotFoundException,SQLException
    {
        String sql = "Insert into mobile(name,model,brand,price,pcamera,scamera,ram,processor,storage,battery) values('"+m_name+"','"+m_model+"','"+m_brand+"','"+m_price+"','"+m_pcamera+"','"+m_scamera+"','"+m_ram+"','"+m_processor+"','"+m_storage+"','"+m_battery+"');";
        try {                                                                                               //SingleInvertedComma so that the items shld be in Invertedcommas
            MySqlConnector.dbExecuteQuery(sql);
            System.out.println("Data Inserted");
            }

        catch(SQLException e)
            {System.out.println("Exception occurred while Inserting Data: "+e);}
    }

    public static void deletephones(String id) throws SQLException,ClassNotFoundException
    {
        String sql = "delete from mobile where model = '"+id+"'";
        try {
            MySqlConnector.dbExecuteQuery(sql);
            System.out.println("Data Deleted");
        }
        catch (SQLException e)
            {System.out.println("Error While Deleting the data: "+e);}
    }

    //Search Query
    public static ObservableList<PopulateTable> searchForPhone(String model) throws ClassNotFoundException,SQLException
    {
        String sqlQuery = "select * from mobile where model='"+model+"';";
        try {
            ResultSet resultSet = MySqlConnector.dbRetreiveQuery(sqlQuery);
            ObservableList<PopulateTable> list = getPhonesObjects(resultSet);
            return list;
        }
        catch (SQLException e)
        {System.out.println("Error Searching Database: "+e);}

        return null;
    }

    //Retreive Data Function
    public static ObservableList<PopulateTable> getAllRecords() throws SQLException,ClassNotFoundException
    {
        String sql = "select * from mobile;"  ;
         try{
             ResultSet resultset = MySqlConnector.dbRetreiveQuery(sql);
             ObservableList<PopulateTable> phonelist = getPhonesObjects(resultset);
             return phonelist;
         }
         catch (SQLException e)
            {System.out.println("Error Fetching Records from DB: "+e);}
        return null;
    }

    private static ObservableList<PopulateTable> getPhonesObjects(ResultSet resultset) throws ClassNotFoundException,SQLException
        {
            try {
                ObservableList<PopulateTable> phonelist = FXCollections.observableArrayList();
                while (resultset.next())
                    {
                    PopulateTable phone = new PopulateTable();
                    phone.setName(resultset.getString("name"));
                    phone.setBrand(resultset.getString("brand"));
                    phone.setModel(resultset.getString("model"));
                    phone.setPrice(resultset.getInt("price"));
                    phone.setRam(resultset.getString("ram"));
                    phone.setProcessor(resultset.getString("processor"));
                    phone.setStorage(resultset.getString("storage"));
                    phone.setScamera(resultset.getString("scamera"));
                    phone.setPcamera(resultset.getString("pcamera"));
                    phone.setBattery(resultset.getString("battery"));
                    phonelist.add(phone);
                    }
                    return phonelist;
                }
            catch (SQLException e)
                {System.out.println("Error Occurred Fetching Data"+e);}

        return null;
        }
    //Retrieve Data Function END


    //For Login
    public static int accountsearch(String user,String pass) throws ClassNotFoundException,SQLException
    {
        String sqlQuery = "select * from accounts where username='"+user+"' and password='"+pass+"';";
        try {
            ResultSet resultSet = MySqlConnector.dbRetreiveQuery(sqlQuery);
            while (resultSet.next())
            {
               String uname = resultSet.getString(1);
                String upass = resultSet.getString(2);
                int isadmin = resultSet.getInt(3);

                if(uname.equals(user) && upass.equals(pass) && isadmin==1) return 2;
                else if(uname.equals(user) && upass.equals(pass)) return 1;
                else return 0;
            }
        }
        catch (SQLException e)
        {System.out.println("Error Searching Database: "+e);}

        return 0;
    }
}