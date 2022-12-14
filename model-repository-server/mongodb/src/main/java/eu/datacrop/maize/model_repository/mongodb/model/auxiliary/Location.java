package eu.datacrop.maize.model_repository.mongodb.model.auxiliary;

import lombok.Builder;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

/**********************************************************************************************************************
 * This class defines the data model of Locations (Geographical or Virtual ones) for persistence in a MongoDB.
 * Note: Locations are auxiliary entities and are not stored in a Document of their own.
 *
 * @author Angela-Maria Despotopoulou [Athens, Greece]
 * @since version 0.3.0
 *********************************************************************************************************************/
public class Location implements Serializable {

    @Serial
    private static final long serialVersionUID = -7797102348398353735L;

    /******************************************************************************************************************
     * Αn object representing a Geographical Location (a pair of  coordinates).
     *****************************************************************************************************************/
    private GeoLocation geoLocation;

    /******************************************************************************************************************
     * A string representing a Virtual Location (a URL or the identifier of a resource/subsystem).
     *****************************************************************************************************************/
    private String virtualLocation;

    /******************************************************************************************************************
     * Constructor of the Location class.
     *****************************************************************************************************************/
    public Location(double latitude, double longitude, String virtualLocation) {

        this.virtualLocation = virtualLocation;

        if (!StringUtils.isBlank(virtualLocation)) {
            this.geoLocation = GeoLocation.builder()
                    .latitude(0.0)
                    .longitude(0.0)
                    .build();
        } else {
            this.geoLocation = GeoLocation.builder()
                    .latitude(latitude)
                    .longitude(longitude)
                    .build();
        }

    }

    /******************************************************************************************************************
     * Empty constructor of the Location class.
     *****************************************************************************************************************/
    public Location() {
        this.virtualLocation = "";
        this.geoLocation = GeoLocation.builder()
                .latitude(0.0)
                .longitude(0.0)
                .build();
    }

    /******************************************************************************************************************
     * "Getter" method for "geoLocation" attribute.
     *
     * @return The current value of the object's "geoLocation" attribute.
     *****************************************************************************************************************/
    public GeoLocation getGeoLocation() {
        return geoLocation;
    }

    /**************************************************************************************************************
     * "Getter" function for "latitude" attribute.
     *
     * @return The current value of the object's "latitude" attribute.
     *************************************************************************************************************/
    public double getLatitude() {
        return geoLocation.getLatitude();
    }


    /**************************************************************************************************************
     * "Getter" function for "longitude" attribute.
     *
     * @return The current value of the object's "longitude" attribute.
     *************************************************************************************************************/
    public double getLongitude() {
        return geoLocation.getLongitude();
    }

    /******************************************************************************************************************
     * "Setter" method for "geoLocation" attribute. If the Virtual Location is null, then the Geographical Location
     * must have a value and vice versa.
     *
     * @param latitude The latitude of the Geographical Location, not null if virtualLocation is null.
     * @param longitude The longitude of the Geographical Location, not null if virtualLocation is null.
     * @param virtualLocation A string representing a Virtual Location, not null if coordinates are null.
     *****************************************************************************************************************/
    public void setGeoLocation(double latitude, double longitude, String virtualLocation) {

        this.virtualLocation = virtualLocation;

        if (!StringUtils.isBlank(virtualLocation)) {
            this.geoLocation = GeoLocation.builder()
                    .latitude(0.0)
                    .longitude(0.0)
                    .build();
        } else {
            this.geoLocation = GeoLocation.builder()
                    .latitude(latitude)
                    .longitude(longitude)
                    .build();
        }

    }

    /******************************************************************************************************************
     * "Getter" method for "virtualLocation" attribute.
     *
     * @return The current value of the object's "virtualLocation" attribute.
     *****************************************************************************************************************/
    public String getVirtualLocation() {
        return virtualLocation;
    }

    /******************************************************************************************************************
     * "Setter" method for "virtualLocation" attribute.
     *
     * @param virtualLocation A value to assign to the object's "virtualLocation" attribute, not null.
     *****************************************************************************************************************/
    public void setVirtualLocation(String virtualLocation) {
        this.virtualLocation = virtualLocation;
        if (!StringUtils.isBlank(virtualLocation)) {
            this.geoLocation = GeoLocation.builder()
                    .latitude(0.0)
                    .longitude(0.0)
                    .build();
        }
    }

    /******************************************************************************************************************
     * Method that checks whether two Location objects are equal.
     *
     * @param o The second Object to compare with the current Object, not null.
     *****************************************************************************************************************/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location that = (Location) o;
        return Objects.equals(geoLocation, that.geoLocation) && Objects.equals(virtualLocation, that.virtualLocation);
    }

    /******************************************************************************************************************
     * Method that returns the integer hash code value of the Location object.
     *****************************************************************************************************************/
    @Override
    public int hashCode() {
        return Objects.hash(geoLocation, virtualLocation);
    }

    /******************************************************************************************************************
     * Transforms a Location object to String.
     *
     * @return A string representation of the Object.
     *****************************************************************************************************************/
    @Override
    public String toString() {
        return "{" +
                "geoLocation=" + geoLocation +
                ", virtualLocation='" + virtualLocation + '\'' +
                '}';
    }

    /**************************************************************************************************************
     * Transforms a Location object to JSONObject.
     *
     * @return A JSON representation of the Object.
     *************************************************************************************************************/
    public JSONObject toJSON() {
        JSONObject jo = new JSONObject();
        jo.put("geoLocation", geoLocation.toJSON());
        jo.put("virtualLocation", virtualLocation);
        return jo;
    }

    /******************************************************************************************************************
     * This inner class defines the data model of Geographical Locations for persistence in a MongoDB.
     *
     * @author Angela-Maria Despotopoulou [Athens, Greece]
     * @since version 0.3.0
     *****************************************************************************************************************/
    @Builder
    public static class GeoLocation implements Serializable {

        @Serial
        private static final long serialVersionUID = -1754719913405025278L;


        /**************************************************************************************************************
         * The latitude of the Geographical Location.
         *************************************************************************************************************/
        private double latitude;

        /**************************************************************************************************************
         * The longitude of the Geographical Location.
         *************************************************************************************************************/
        private double longitude;

        /**************************************************************************************************************
         * Constructor of the GeoLocation class, both for Builder pattern and instantiation with "new".
         *
         * @param latitude  The latitude of the new Geographical Location, not null.
         * @param longitude The longitude of the new Geographical Location, not null.
         *************************************************************************************************************/
        private GeoLocation(double latitude, double longitude) {
            this.latitude = latitude;
            this.longitude = longitude;
        }

        /**************************************************************************************************************
         * Empty constructor of the GeoLocation class.
         *************************************************************************************************************/
        private GeoLocation() {
            this(0.0, 0.0);
        }

        /**************************************************************************************************************
         * "Getter" function for "latitude" attribute.
         *
         * @return The current value of the object's "latitude" attribute.
         *************************************************************************************************************/
        private double getLatitude() {
            return latitude;
        }

        /**************************************************************************************************************
         * "Setter" function for "latitude" attribute.
         *
         * @param latitude A value to assign to the object's "latitude" attribute, not null.
         *************************************************************************************************************/
        private void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        /**************************************************************************************************************
         * "Getter" function for "longitude" attribute.
         *
         * @return The current value of the object's "longitude" attribute.
         *************************************************************************************************************/
        private double getLongitude() {
            return longitude;
        }

        /**************************************************************************************************************
         * "Setter" function for "longitude" attribute.
         *
         * @param longitude A value to assign to the object's "longitude" attribute, not null.
         *************************************************************************************************************/
        private void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        /**************************************************************************************************************
         * Method that checks whether two GeoLocation objects are equal.
         *
         * @param o The second Object to compare with the current Object, not null.
         *************************************************************************************************************/
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            GeoLocation that = (GeoLocation) o;
            return Double.compare(that.latitude, latitude) == 0 && Double.compare(that.longitude, longitude) == 0;
        }

        /**************************************************************************************************************
         * Method that returns the integer hash code value of the GeoLocation object.
         *************************************************************************************************************/
        @Override
        public int hashCode() {
            return Objects.hash(latitude, longitude);
        }

        /**************************************************************************************************************
         * Transforms a GeoLocation object to String.
         *
         * @return A string representation of the Object.
         *************************************************************************************************************/
        @Override
        public String toString() {
            return "{" +
                    "latitude=" + latitude +
                    ", longitude=" + longitude +
                    '}';
        }

        /**************************************************************************************************************
         * Transforms a GeoLocation object to JSONObject.
         *
         * @return A JSON representation of the Object.
         *************************************************************************************************************/
        public JSONObject toJSON() {
            JSONObject jo = new JSONObject();
            jo.put("latitude", latitude);
            jo.put("longitude", longitude);
            return jo;
        }
    }
}
