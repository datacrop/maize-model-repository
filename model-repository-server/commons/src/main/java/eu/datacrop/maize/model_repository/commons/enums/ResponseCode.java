package eu.datacrop.maize.model_repository.commons.enums;

/**********************************************************************************************************************
 * This enumeration contains Response Codes to be used in Response Wrappers.
 *
 * @author Angela-Maria Despotopoulou [Athens, Greece]
 * @since version 0.3.0
 *********************************************************************************************************************/
public enum ResponseCode {

    /******************************************************************************************************************
     * Indicates that the API Request has been concluded successfully.
     *****************************************************************************************************************/
    SUCCESS("SUCCESS"),

    /******************************************************************************************************************
     * Indicates that the API Request has not been concluded successfully due to Internal Server Error.
     *****************************************************************************************************************/
    ERROR("ERROR"),

    /******************************************************************************************************************
     * Indicates that the API Request did not produce error, however no result was available to return.
     *****************************************************************************************************************/
    NOT_FOUND("NOT_FOUND"),

    /******************************************************************************************************************
     * Indicates that the API Request did not produce error, however it was aborted due to conflict.
     *****************************************************************************************************************/
    CONFLICT("CONFLICT"),

    /******************************************************************************************************************
     * Indicates that the API Request was problematic due to the client's fault.
     *****************************************************************************************************************/
    BAD_REQUEST("BAD_REQUEST"),

    /******************************************************************************************************************
     * Default value of the Response Wrapper. Not meant to reach end-users.
     *****************************************************************************************************************/
    UNDEFINED("UNDEFINED");

    /******************************************************************************************************************
     * The text representing the ResponseCode enumeration values.
     *****************************************************************************************************************/
    private final String text;

    /******************************************************************************************************************
     * Constructor of the ResponseCode enumeration.
     *
     * @param text The text representing the enumeration values.
     *****************************************************************************************************************/
    ResponseCode(String text) {
        this.text = text;
    }

    /******************************************************************************************************************
     * Transforms a ResponseCode enumeration object to String.
     *
     *  @return A string representation of the Object.
     *****************************************************************************************************************/
    @Override
    public String toString() {
        return text;
    }

}
