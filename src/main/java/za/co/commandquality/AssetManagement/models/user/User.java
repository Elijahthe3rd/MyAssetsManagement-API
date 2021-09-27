package za.co.commandquality.AssetManagement.models.user;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.lang.NonNull;
import za.co.commandquality.AssetManagement.models.ComponentsCategories;
import za.co.commandquality.AssetManagement.models.Model;

import java.util.Objects;
import java.util.UUID;

public final class User extends Model < T > {
    private  UUID userId;
    @NonNull
    private String name;
    @NonNull
    private  final String lastname;
    @NonNull
    private final Gender gender;
    private final Address address;
    private final Contacts contacts;
    private ComponentsCategories category;

    public User( UUID userId,
                 @NonNull String name,
                 @NonNull String lastname,
                 @NonNull Gender gender,
                 @NonNull Address address,
                 @NonNull Contacts contacts ) {
        super();
        this.userId = userId;
        this.name = name;
        this.lastname = lastname;
        this.gender=gender;
        this.address=address;
        this.contacts=contacts;
        setCategory( ComponentsCategories.USER );
        setId( getUserId() );
        setName( getName() );
        setType(  getCategory().getResult());
    }

    public UUID getUserId() {
        return userId;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @NonNull
    public String getLastname() {
        return lastname;
    }

    public Address getAddress() {
        return address;
    }

    public Contacts getContacts() {
        return contacts;
    }

    @Override
    public void setId( @NonNull UUID id ) {
       this.userId=( id );
    }
    @Override
    public void setName( @NonNull String name ) {
        this.name=( name );
    }
    @Override
    public void setType( @NonNull String type ) {
        super.setType( type=getCategory().getResult() );
    }

    public ComponentsCategories getCategory() {
        return category;
    }

    public void setCategory( @NonNull ComponentsCategories category ) {
        this.category = category;
    }

    public Gender getGender() {
        return Objects.requireNonNull( this.gender );
    }

    @Override
    public String toString() {
        return "User:\n" +
                "userId=" + userId +
                ",\n name='" + name + '\'' +
                ",\n lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public boolean equals( Object obj ) {
        return (obj == this) && (this.userId.equals( ((( User ) obj).userId) )) || ((obj != null) && (obj.getClass() == this.getClass()));
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public int compareTo( @NonNull T o ) {
       return  Integer.compare( o.hashCode(), this.hashCode() );
    }
}
