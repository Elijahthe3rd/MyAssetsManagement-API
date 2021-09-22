package za.co.commandquality.AssetManagement.models;

import org.springframework.lang.NonNull;
import za.co.commandquality.AssetManagement.models.user.Gender;

import java.io.Serializable;
import java.util.UUID;

public abstract class Model<T>  implements Serializable,  Comparable<T> {
    @NonNull
    private  UUID id;
    @NonNull
    private  String name;
    @NonNull
    private  String type;

//    public Model(@NonNull UUID id, @NonNull String name) {
//        this.id=id;
//        this.name=name;
//        this.type=this.getCategory().getResult();
//        this.category=getCategory();
//    }


    public void setId( @NonNull UUID id ) {
        this.id = id;
    }

    public void setName( @NonNull String name ) {
        this.name = name;
    }
    public void setType( @NonNull String type ){
        this.type=type;
    }


    public abstract UUID getUserId() ;
    public abstract String getName();


}
