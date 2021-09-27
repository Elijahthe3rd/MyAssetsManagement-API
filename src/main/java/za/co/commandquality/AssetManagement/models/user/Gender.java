package za.co.commandquality.AssetManagement.models.user;

public enum Gender {
    MALE("male"),FEMALE("female");
    private final String value;

    Gender( String val ) {
        this.value = val;
    }

    public String getValue() {
        return value;
    }
}
