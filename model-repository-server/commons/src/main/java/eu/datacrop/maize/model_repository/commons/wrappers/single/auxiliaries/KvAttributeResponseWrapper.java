package eu.datacrop.maize.model_repository.commons.wrappers.single.auxiliaries;

import eu.datacrop.maize.model_repository.commons.dtos.responses.auxiliaries.KvAttributeResponseDto;
import eu.datacrop.maize.model_repository.commons.enums.ResponseCode;
import eu.datacrop.maize.model_repository.commons.error.messages.KvAttributeErrorMessages;
import eu.datacrop.maize.model_repository.commons.wrappers.ResponseWrapper;

import java.io.Serial;
import java.io.Serializable;

/**********************************************************************************************************************
 * This class wraps the responses travelling from the persistence layer back to the API for a more complete
 * reporting of problems / unsuccessful requests on KvAttributes. Used for Single Objects (as opposed to a Collection).
 *
 * @author Angela-Maria Despotopoulou [Athens, Greece]
 * @since version 0.4.0
 *********************************************************************************************************************/
public class KvAttributeResponseWrapper extends ResponseWrapper implements Serializable {

    /******************************************************************************************************************
     * A unique identifier for the KvAttributeResponseWrapper class.
     *****************************************************************************************************************/
    @Serial
    private static final long serialVersionUID = -1257206859791546955L;

    /******************************************************************************************************************
     * A data transfer object representing a KvAttribute to be wrapped while returned as a response to an HTTP request.
     *****************************************************************************************************************/
    private KvAttributeResponseDto response;

    /******************************************************************************************************************
     * An error code in case the wrapper is used to report error.
     *****************************************************************************************************************/
    private KvAttributeErrorMessages errorCode;

    /******************************************************************************************************************
     * Constructor of the KvAttributeResponseWrapper class, both for Builder pattern and instantiation with "new".
     *
     * @param code A value from the ResponseCode enumeration to be included in responses.
     * @param message A message to be included in responses.
     * @param response The actual object to be used as a body in API responses.
     * @param errorCode A small string identifying a particular error.
     *****************************************************************************************************************/
    public KvAttributeResponseWrapper(ResponseCode code, String message, KvAttributeResponseDto response, KvAttributeErrorMessages errorCode) {
        this.setCode(code);
        if (code.equals(ResponseCode.SUCCESS)) {
            this.setMessage("Request has been successful.");
        } else {
            this.setMessage(message);
        }
        this.response = response;
        this.errorCode = errorCode;
    }

    /******************************************************************************************************************
     * Empty constructor of the KvAttributeResponseWrapper class.
     *****************************************************************************************************************/
    public KvAttributeResponseWrapper() {
        this.setCode(ResponseCode.UNDEFINED);
        this.setMessage(null);
        this.response = null;
        this.errorCode = null;
    }

    /******************************************************************************************************************
     * "Getter" function for "response" attribute.
     *
     * @return The current value of the object's "response" attribute.
     *****************************************************************************************************************/
    public KvAttributeResponseDto getResponse() {
        return response;
    }

    /******************************************************************************************************************
     * "Setter" function for "response" attribute.
     *
     * @param response A value to assign to the object's "response" attribute, not null.
     *****************************************************************************************************************/
    public void setResponse(KvAttributeResponseDto response) {
        this.response = response;
    }

    /******************************************************************************************************************
     * "Getter" function for "errorCode" attribute.
     *
     * @return The current value of the object's "errorCode" attribute.
     *****************************************************************************************************************/
    public KvAttributeErrorMessages getErrorCode() {
        return errorCode;
    }

    /******************************************************************************************************************
     * "Setter" function for "errorCode" attribute.
     *
     * @param errorCode A value to assign to the object's "errorCode" attribute, not null.
     *****************************************************************************************************************/
    public void setErrorCode(KvAttributeErrorMessages errorCode) {
        this.errorCode = errorCode;
    }

    /******************************************************************************************************************
     * Transforms a KvAttributeResponseWrapper object to String.
     *
     * @return A string representation of the Object.
     *****************************************************************************************************************/
    @Override
    public String toString() {
        return "{" +
                "code=" + super.getCode() +
                ", message='" + super.getMessage() + '\'' +
                ", response='" + response + '\'' +
                ", response='" + response + '\'' +
                ", errorCode='" + errorCode + '\'' +
                '}';
    }
}
