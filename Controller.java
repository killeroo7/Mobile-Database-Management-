package sample;

import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.sql.SQLException;

public class Controller {

    @FXML private Label status;
    @FXML TextField mobilename_field;
    @FXML TextField model_field;
    @FXML TextField brand_field;
    @FXML TextField price_field;
    @FXML TextField primary_camera_field;
    @FXML TextField secondary_camera_field;
    @FXML TextField ram_field;
    @FXML TextField processor_field;
    @FXML TextField storage_field;
    @FXML TextField battery_field;

    @FXML TextArea console;
    @FXML TextField searchfield;

    @FXML private TableView phonetable;

    @FXML private TableColumn<PopulateTable,String> col_name;
    @FXML private TableColumn<PopulateTable,String> col_model;
    @FXML private TableColumn<PopulateTable,String> col_brand;
    @FXML private TableColumn<PopulateTable,Integer> col_price;
    @FXML private TableColumn<PopulateTable,String> col_pcamera;
    @FXML private TableColumn<PopulateTable,String> col_scamera;
    @FXML private TableColumn<PopulateTable,String> col_ram;
    @FXML private TableColumn<PopulateTable,String> col_processor;
    @FXML private TableColumn<PopulateTable,String> col_storage;
    @FXML private TableColumn<PopulateTable,String> col_battery;

    @FXML
    private void addDataBtn(ActionEvent event) throws SQLException,ClassNotFoundException
        {
        try {
            Phones.insertphones(mobilename_field.getText(), model_field.getText(), brand_field.getText(), Integer.parseInt(price_field.getText()), primary_camera_field.getText(), secondary_camera_field.getText(), ram_field.getText(), processor_field.getText(), storage_field.getText(),battery_field.getText());
            console.setText("One Row Added");
            ObservableList<PopulateTable> phonelist = Phones.getAllRecords();  //To refresh the Table
            populateTable(phonelist);                                         //To refresh the Table
            }
        catch (SQLException e)
            {console.setText("Error Adding Data: "+e);}
        }

    @FXML
    public void deleteDataBtn(ActionEvent event) throws SQLException,ClassNotFoundException
        {
         try {
             Phones.deletephones(searchfield.getText());
             console.setText("Row Deleted");
             ObservableList<PopulateTable> phonelist = Phones.getAllRecords();    //To refresh the Table
             populateTable(phonelist);                                           //To refresh the Table
            }
         catch (SQLException e)
            {console.setText("Error Deleting the Data: "+e);}
        }


    public void initialize() throws Exception{

            col_name.setCellValueFactory(cellData ->cellData.getValue().getNameProp());
            col_model.setCellValueFactory(cellData ->cellData.getValue().getModelProp());
            col_brand.setCellValueFactory(cellData ->cellData.getValue().getBrandProp());
            col_price.setCellValueFactory(cellData ->cellData.getValue().getPriceProp().asObject());
            col_pcamera.setCellValueFactory(cellData ->cellData.getValue().getPcameraProp());
            col_scamera.setCellValueFactory(cellData ->cellData.getValue().getScameraProp());
            col_ram.setCellValueFactory(cellData ->cellData.getValue().getRamProp());
            col_processor.setCellValueFactory(cellData ->cellData.getValue().getProcessorProp());
            col_storage.setCellValueFactory(cellData ->cellData.getValue().getStorageProp());
            col_battery.setCellValueFactory(cellData ->cellData.getValue().getBatteryProp());
            ObservableList<PopulateTable> phonelist = Phones.getAllRecords();                    //To refresh the Table
            populateTable(phonelist);                                                           //To refresh the Table

    }

    private void populateTable(ObservableList<PopulateTable> phonelist)
    {
    phonetable.setItems(phonelist);
    }

    @FXML
    private void searchPhone(ActionEvent event) throws ClassNotFoundException,SQLException
    {
    ObservableList<PopulateTable> list = Phones.searchForPhone(searchfield.getText());     //Taking model from the textfield
        populateTable(list);
    }

    @FXML
    private void refreshTable(ActionEvent event) throws ClassNotFoundException,SQLException
    {
     ObservableList<PopulateTable> phonelist = Phones.getAllRecords();
     populateTable(phonelist);
    }
}
