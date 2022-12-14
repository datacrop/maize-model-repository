package eu.datacrop.maize.model_repository.mongodb.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import eu.datacrop.maize.model_repository.commons.util.DateFormatter;
import eu.datacrop.maize.model_repository.mongodb.listeners.SystemListener;
import eu.datacrop.maize.model_repository.mongodb.model.auxiliary.Location;
import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.EntityListeners;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

/**********************************************************************************************************************
 * This class defines the data model of IoT Systems for persistence in a MongoDB.
 *
 * @author Angela-Maria Despotopoulou [Athens, Greece]
 * @since version 0.3.0
 *********************************************************************************************************************/
@Builder
@Document(collection = "System")
@EntityListeners(SystemListener.class)
public class System implements Serializable {

    @Serial
    private static final long serialVersionUID = -2593715007779118066L;

    /******************************************************************************************************************
     * A UUID representing a unique identifier for the IoT System. Mandatory field.
     *****************************************************************************************************************/
    @Id
    private String id;

    /******************************************************************************************************************
     * A human readable string representing a unique identifier for the IoT System. Mandatory field.
     *****************************************************************************************************************/
    private String name;

    /******************************************************************************************************************
     * A textual description of the IoT System. Mandatory field.
     *****************************************************************************************************************/
    private String description;

    /******************************************************************************************************************
     * The virtual or physical Location of the IoT System. Optional field.
     *****************************************************************************************************************/
    private Location location;

    /******************************************************************************************************************
     * A human readable string representing the organization owning the IoT System. Optional field.
     *****************************************************************************************************************/
    private String organization;

    /******************************************************************************************************************
     * A collection of versatile variables hosting additional information on the IoT System. Optional field.
     *****************************************************************************************************************/
    private transient Set<Object> additionalInformation;

    /******************************************************************************************************************
     * Timestamp of first persistence regarding the IoT System in the database.
     *****************************************************************************************************************/
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime creationDate;

    /******************************************************************************************************************
     * Timestamp of latest persistence regarding the IoT System in the database.
     *****************************************************************************************************************/
    @LastModifiedDate
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime latestUpdateDate;

    /******************************************************************************************************************
     * Constructor of the System class, used for the Builder pattern.
     *****************************************************************************************************************/
    public System(String id, String name, String description, Location location,
                  String organization, Set<Object> additionalInformation,
                  LocalDateTime creationDate, LocalDateTime latestUpdateDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.organization = organization;
        this.creationDate = creationDate;
        this.latestUpdateDate = latestUpdateDate;

        if (location == null) {
            this.location = new Location();
        } else {
            this.location = location;
        }
        if (additionalInformation == null) {
            this.additionalInformation = new HashSet<>();
        } else {
            this.additionalInformation = additionalInformation;
        }
    }

    /******************************************************************************************************************
     * Constructor of the System class, used for instantiation with "new".
     *****************************************************************************************************************/
    public System(String name, String description, String organization) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.organization = organization;
        this.location = new Location();
        this.additionalInformation = new HashSet<>();
        this.creationDate = LocalDateTime.now();
    }

    /******************************************************************************************************************
     * Empty constructor of the System class.
     *****************************************************************************************************************/
    public System() {
        this("", "", "");
    }

    /******************************************************************************************************************
     * "Getter" method for "id" attribute.
     *
     * @return The current value of the object's "id" attribute.
     *****************************************************************************************************************/
    public String getId() {
        return id;
    }

    /******************************************************************************************************************
     * "Setter" function for "id" attribute.
     *
     * @param id A value to assign to the object's "id" attribute, not null.
     *****************************************************************************************************************/
    public void setId(String id) {
        this.id = id;
    }

    /******************************************************************************************************************
     * "Getter" method for "name" attribute.
     *
     * @return The current value of the object's "name" attribute.
     *****************************************************************************************************************/
    public String getName() {
        return name;
    }

    /******************************************************************************************************************
     * "Setter" function for "name" attribute.
     *
     * @param name A value to assign to the object's "name" attribute, not null.
     *****************************************************************************************************************/
    public void setName(String name) {
        this.name = name;
    }

    /******************************************************************************************************************
     * "Getter" method for "description" attribute.
     *
     * @return The current value of the object's "description" attribute.
     *****************************************************************************************************************/
    public String getDescription() {
        return description;
    }

    /******************************************************************************************************************
     * "Setter" function for "description" attribute.
     *
     * @param description A value to assign to the object's "description" attribute, not null.
     *****************************************************************************************************************/
    public void setDescription(String description) {
        this.description = description;
    }

    /******************************************************************************************************************
     * "Getter" method for "location" attribute.
     *
     * @return The current value of the object's "location" attribute.
     *****************************************************************************************************************/
    public Location getLocation() {
        if (this.location == null) {
            this.location = new Location();
        }
        return this.location;
    }

    /******************************************************************************************************************
     * "Setter" function for "location" attribute.
     *
     * @param location A value to assign to the object's "location" attribute, not null.
     *****************************************************************************************************************/
    public void setLocation(Location location) {
        if (location == null) {
            this.location = new Location();
        } else {
            this.location = location;
        }
    }

    /******************************************************************************************************************
     * "Getter" method for "organization" attribute.
     *
     * @return The current value of the object's "organization" attribute.
     *****************************************************************************************************************/
    public String getOrganization() {
        return organization;
    }

    /******************************************************************************************************************
     * "Setter" function for "organization" attribute.
     *
     * @param organization A value to assign to the object's "organization" attribute, not null.
     *****************************************************************************************************************/
    public void setOrganization(String organization) {
        this.organization = organization;
    }

    /******************************************************************************************************************
     * "Getter" method for "additionalInformation" attribute.
     *
     * @return The current value of the object's "additionalInformation" attribute.
     *****************************************************************************************************************/
    public Set<Object> getAdditionalInformation() {
        if (this.additionalInformation == null) {
            this.additionalInformation = new HashSet<>();
        }
        return additionalInformation;
    }

    /******************************************************************************************************************
     * "Setter" function for "additionalInformation" attribute.
     *
     * @param additionalInformation A value to assign to the object's "additionalInformation" attribute, not null.
     *****************************************************************************************************************/
    public void setAdditionalInformation(Set<Object> additionalInformation) {
        if (additionalInformation == null) {
            this.additionalInformation = new HashSet<>();
        } else {
            this.additionalInformation = additionalInformation;
        }
    }

    /******************************************************************************************************************
     * "Getter" method for "creationDate" attribute.
     *
     * @return The current value of the object's "creationDate" attribute.
     *****************************************************************************************************************/
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    /******************************************************************************************************************
     * "Setter" function for "creationDate" attribute.
     *
     * @param creationDate A value to assign to the object's "creationDate" attribute, not null.
     *****************************************************************************************************************/
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    /******************************************************************************************************************
     * "Getter" method for "latestUpdateDate" attribute.
     *
     * @return The current value of the object's "latestUpdateDate" attribute.
     *****************************************************************************************************************/
    public LocalDateTime getLatestUpdateDate() {
        return latestUpdateDate;
    }

    /******************************************************************************************************************
     * "Setter" function for "latestUpdateDate" attribute.
     *
     * @param latestUpdateDate A value to assign to the object's "latestUpdateDate" attribute, not null.
     *****************************************************************************************************************/
    public void setLatestUpdateDate(LocalDateTime latestUpdateDate) {
        this.latestUpdateDate = latestUpdateDate;
    }

    /******************************************************************************************************************
     * Method for gracefully adding AdditionalInformation objects to the IoT System object. Duplicates are removed.
     *
     * @param additionalInformation An object (free generic Object) with additional information on the IoT System.
     *****************************************************************************************************************/
    public void addAdditionalInformation(Object additionalInformation) {
        if (this.additionalInformation == null) {
            this.additionalInformation = new HashSet<>();
        }
        if (additionalInformation == null) {
            return;
        }
        this.additionalInformation.add(additionalInformation);
    }

    /******************************************************************************************************************
     * Method for gracefully removing AdditionalInformation objects from the IoT System object.
     *
     * @param additionalInformation An object (free generic Object) with additional information on the IoT System.
     *****************************************************************************************************************/
    public void removeAdditionalInformation(Object additionalInformation) {
        if (this.additionalInformation == null) {
            this.additionalInformation = new HashSet<>();
            return;
        }
        this.additionalInformation.remove(additionalInformation);
    }

    /******************************************************************************************************************
     * Method for gracefully removing all AdditionalInformation objects from the IoT System object.
     *****************************************************************************************************************/
    public void removeAllAdditionalInformation() {
        if (this.additionalInformation == null) {
            this.additionalInformation = new HashSet<>();
            return;
        }
        this.additionalInformation.clear();
    }

    /******************************************************************************************************************
     * Method that checks whether two System objects are equal.
     *
     * @param o The second Object to compare with the current Object, not null.
     *****************************************************************************************************************/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        System that = (System) o;
        return id.equals(that.id) && name.equals(that.name);
    }

    /******************************************************************************************************************
     * Method that returns the integer hash code value of the System object.
     *****************************************************************************************************************/
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    /******************************************************************************************************************
     * Transforms a System object to String.
     *
     * @return A string representation of the Object.
     *****************************************************************************************************************/
    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", location=" + location +
                ", organization='" + organization + '\'' +
                ", additionalInformation=" + additionalInformation +
                ", creationDate=" + ((creationDate != null) ? creationDate.format(DateFormatter.formatter) : "") +
                ", latestUpdateDate=" + ((latestUpdateDate != null) ? latestUpdateDate.format(DateFormatter.formatter) : "") +
                '}';
    }
}
