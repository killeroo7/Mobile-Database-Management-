package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PopulateTable {

    private StringProperty nameProperty,modelProperty,brandProperty,pcameraProperty,scameraProperty,ramProperty,processorProperty,storageProperty,batteryProperty;
    private IntegerProperty priceProperty;


    public PopulateTable() {
        this.nameProperty = new SimpleStringProperty();
        this.modelProperty = new SimpleStringProperty();
        this.brandProperty = new SimpleStringProperty();
        this.priceProperty = new SimpleIntegerProperty();
        this.pcameraProperty = new SimpleStringProperty();
        this.scameraProperty = new SimpleStringProperty();
        this.ramProperty = new SimpleStringProperty();
        this.processorProperty = new SimpleStringProperty();
        this.storageProperty = new SimpleStringProperty();
        this.batteryProperty = new SimpleStringProperty();
    }

    public String getName()          { return nameProperty.get(); }
    public void setName(String name) { this.nameProperty.set(name);}
    public StringProperty getNameProp()  {return nameProperty;}

    public String getModel()          { return modelProperty.get(); }
    public void setModel(String model) { this.modelProperty.set(model);}
    public StringProperty getModelProp()  {return modelProperty;}

    public String getBrand()          { return brandProperty.get(); }
    public void setBrand(String brand) { this.brandProperty.set(brand);}
    public StringProperty getBrandProp()  {return brandProperty;}

    public Integer getPrice()          { return priceProperty.get(); }
    public void setPrice(Integer price) { this.priceProperty.set(price);}
    public IntegerProperty getPriceProp()  {return priceProperty;}

    public String getPcamera()          { return pcameraProperty.get(); }
    public void setPcamera(String pcamera) { this.pcameraProperty.set(pcamera);}
    public StringProperty getPcameraProp()  {return pcameraProperty;}

    public String getScamera()          { return scameraProperty.get(); }
    public void setScamera(String scamera) { this.scameraProperty.set(scamera);}
    public StringProperty getScameraProp()  {return scameraProperty;}

    public String getRam()          { return ramProperty.get(); }
    public void setRam(String ram) { this.ramProperty.set(ram);}
    public StringProperty getRamProp()  {return ramProperty;}

    public String getProcessor()          { return processorProperty.get(); }
    public void setProcessor(String processor) { this.processorProperty.set(processor);}
    public StringProperty getProcessorProp()  {return processorProperty;}

    public String getStorage()          { return storageProperty.get(); }
    public void setStorage(String storage) { this.storageProperty.set(storage);}
    public StringProperty getStorageProp()  {return storageProperty;}

    public String getBattery()          { return batteryProperty.get(); }
    public void setBattery(String battery) { this.batteryProperty.set(battery);}
    public StringProperty getBatteryProp()  {return batteryProperty;}

}
