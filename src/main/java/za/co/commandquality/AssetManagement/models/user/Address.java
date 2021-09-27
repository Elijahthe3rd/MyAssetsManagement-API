package za.co.commandquality.AssetManagement.models.user;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.lang.NonNull;
import za.co.commandquality.AssetManagement.models.ComponentsCategories;
import za.co.commandquality.AssetManagement.models.Model;

import java.util.UUID;

public class Address extends Model< T > {

    private final int streetNo;
    private final int houseNo;
    private final String streetName;
    private final String suburb;
    private final String city;
    private final String province;
    private final String country;
    private final String continent;
    private final int ZipCode;
    private  UUID id;
    private  String name;


    public Address(int streetNo, int houseNo, String streetName, String suburb, String city, String province, String country, String continent, int zipCode ) {
        this.streetNo = streetNo;
        this.houseNo = houseNo;
        this.streetName = streetName;
        this.suburb = suburb;
        this.city = city;
        this.province = province;
        this.country = country;
        this.continent = continent;
        ZipCode = zipCode;
    }

    @Override
    public void setId( UUID id ) {
        this.id = id;
    }

    @Override
    public void setName( String name ) {
        this.name = name;
    }


    @Override
    public UUID getUserId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }


    @Override
    public int compareTo( T o ) {
        return Integer.compare( this.houseNo,o.hashCode() );
    }
}
