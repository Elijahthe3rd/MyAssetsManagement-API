package za.co.commandquality.AssetManagement.models.user;

import org.apache.poi.ss.formula.functions.T;
import za.co.commandquality.AssetManagement.models.Model;

import java.util.UUID;

public class Contacts extends Model< T > {
    private final int cellContactNo;
    private final UUID id;
    private final String name;
    private final int workContactNo;
    private final String email;
    private final String instagramLink;
    private final String twitterLink;
    private final String LinkerInLink;

    public Contacts( UUID id,int cellContactNo,
                     String name, int workContactNo,
                     String email, String instagramLink,
                     String twitterLink, String linkerInLink ) {

        this.cellContactNo = cellContactNo;
        this.id = id;
        this.name = name;
        this.workContactNo = workContactNo;
        this.email = email;
        this.instagramLink = instagramLink;
        this.twitterLink = twitterLink;
        this.LinkerInLink = linkerInLink;
    }

    public int getCellContactNo() {
        return cellContactNo;
    }
    public int getWorkContactNo() {
        return workContactNo;
    }

    public String getEmail() {
        return email;
    }

    public String getInstagramLink() {
        return instagramLink;
    }

    public String getTwitterLink() {
        return twitterLink;
    }

    public String getLinkerInLink() {
        return LinkerInLink;
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
    public boolean equals( Object obj ) {
        return (obj == this) && (this.hashCode()==( obj.hashCode()) ) || ((obj != null) && (obj.getClass() == this.getClass()));
    }
    @Override
    public int hashCode() {
        return 1;
    }
    @Override
    public int compareTo( T o ) {
        return Integer.compare( this.hashCode(),o.hashCode() );
    }
}
