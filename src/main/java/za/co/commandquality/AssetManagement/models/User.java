package za.co.commandquality.AssetManagement.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;

import java.util.UUID;

public record User(UUID userId, @NonNull String name, @NonNull String lastname) {

    public User( @JsonProperty( "userId" ) UUID userId, @JsonProperty( "name" ) String name, @JsonProperty( "lastname" ) String lastname ) {
        this.userId = UUID.randomUUID();
        this.name = name;
        this.lastname = lastname;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    @Override
    public String toString() {
        return "User:\n" +
                "userId=" + userId +
                ",\n name='" + name + '\'' +
                ",\n lastname='" + lastname + '\'' +
                '}';
    }
}
