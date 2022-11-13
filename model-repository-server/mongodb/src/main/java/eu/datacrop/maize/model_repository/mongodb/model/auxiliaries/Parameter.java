package eu.datacrop.maize.model_repository.mongodb.model.auxiliaries;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

/**********************************************************************************************************************
 * This class defines the data model of Parameters for persistence in a MongoDB.
 * Note: Parameters are auxiliary entities and are not stored in a Document of their own.
 *
 * @author Angela-Maria Despotopoulou [Athens, Greece]
 * @since version 0.4.0
 *********************************************************************************************************************/
public class Parameter implements Serializable {

    /******************************************************************************************************************
     * A unique identifier for the Parameter class.
     *****************************************************************************************************************/
    @Serial
    private static final long serialVersionUID = 2714104902496501748L;

    /******************************************************************************************************************
     * A human-readable identifier for the Parameter, not null.
     *****************************************************************************************************************/
    private String name;

    /******************************************************************************************************************
     * A textual elucidation of the value of the Parameter, not null.
     *****************************************************************************************************************/
    private String description;

    /******************************************************************************************************************
     * A classification of data; i.e. the data type of the value of the Parameter, not null.
     *****************************************************************************************************************/
    private String type;

    /******************************************************************************************************************
     * A predefined default value for the Parameter.
     *****************************************************************************************************************/
    private Object defaultValue;

    /******************************************************************************************************************
     * Constructor of the Parameter class.
     *
     * @param name A human-readable identifier for the Parameter, not null.
     * @param description A textual elucidation of the value of the Parameter, not null.
     * @param type A classification of data; i.e. the data type of the value of the Parameter, not null.
     * @param defaultValue A predefined default value for the Parameter.
     *****************************************************************************************************************/
    public Parameter(String name, String description, String type, Object defaultValue) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.defaultValue = defaultValue;
    }

    /******************************************************************************************************************
     * Empty constructor of the Parameter class.
     *****************************************************************************************************************/
    public Parameter() {
        this("", "", "", null);
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
     * "Setter" method for "name" attribute.
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
     * "Setter" method for "description" attribute.
     *
     * @param description A value to assign to the object's "description" attribute, not null.
     *****************************************************************************************************************/
    public void setDescription(String description) {
        this.description = description;
    }

    /******************************************************************************************************************
     * "Getter" method for "type" attribute.
     *
     * @return The current value of the object's "type" attribute.
     *****************************************************************************************************************/
    public String getType() {
        return type;
    }

    /******************************************************************************************************************
     * "Setter" method for "type" attribute.
     *
     * @param type A value to assign to the object's "type" attribute, not null.
     *****************************************************************************************************************/
    public void setType(String type) {
        this.type = type;
    }

    /******************************************************************************************************************
     * "Getter" method for "defaultValue" attribute.
     *
     * @return The current value of the object's "defaultValue" attribute.
     *****************************************************************************************************************/
    public Object getDefaultValue() {
        return defaultValue;
    }

    /******************************************************************************************************************
     * "Setter" method for "defaultValue" attribute.
     *
     * @param defaultValue A value to assign to the object's "defaultValue" attribute, not null.
     *****************************************************************************************************************/
    public void setDefaultValue(Object defaultValue) {
        this.defaultValue = defaultValue;
    }

    /******************************************************************************************************************
     * Method that checks whether two Parameter objects are equal. Two Parameters are considered
     * equal if they have the same "name".
     *
     * @param o The second Object to compare with the current Object, not null.
     *****************************************************************************************************************/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parameter that = (Parameter) o;
        return name.equals(that.name);
    }

    /******************************************************************************************************************
     * Method that returns the integer hash code value of the Parameter object.
     *****************************************************************************************************************/
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    /******************************************************************************************************************
     * Transforms a Parameter object to String.
     *
     * @return A string representation of the Object.
     *****************************************************************************************************************/
    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", defaultValue=" + defaultValue +
                '}';
    }
}
