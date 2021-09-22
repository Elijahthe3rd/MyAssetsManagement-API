package za.co.commandquality.AssetManagement.models;

public enum ComponentsCategories {
    USER("USER"),
    ELECTRONICS("electronics"),
    FURNITURE("furniture"),
    PROPERTIES("properties"),
    HOUSE_APPLIANCES("house_appliances");

    private final String result;

    ComponentsCategories( String value ) {
        this.result=value;
    }

    public String getResult() {
        return result;
    }
}
