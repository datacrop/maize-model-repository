package eu.datacrop.maize.model_repository.commons.wrappers.collection;

import eu.datacrop.maize.model_repository.commons.dtos.responses.entities.AssetCategoryResponseDto;
import eu.datacrop.maize.model_repository.commons.enums.ResponseCode;
import eu.datacrop.maize.model_repository.commons.error.messages.AssetCategoryErrorMessages;
import eu.datacrop.maize.model_repository.commons.wrappers.PaginationInfo;
import eu.datacrop.maize.model_repository.commons.wrappers.ResponseWrapper;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**********************************************************************************************************************
 * This class wraps the responses travelling from the persistence layer back to the API for a more complete
 * reporting of problems / unsuccessful requests on Asset Categories. Used for Collections (as opposed to a Single Object).
 *
 * @author Angela-Maria Despotopoulou [Athens, Greece]
 * @since version 0.4.0
 *********************************************************************************************************************/
public class AssetCategoryResponsesWrapper extends ResponseWrapper implements Serializable {

    /******************************************************************************************************************
     * A unique identifier for the AssetCategoryResponsesWrapper class.
     *****************************************************************************************************************/
    @Serial
    private static final long serialVersionUID = 8589571224686950171L;


    /******************************************************************************************************************
     * A data transfer object representing a collection of Asset Categories to be wrapped while returned as a response
     * to an HTTP request.
     *****************************************************************************************************************/
    private List<AssetCategoryResponseDto> listOfResponses;

    /******************************************************************************************************************
     * An auxiliary data transfer object containing pagination information.
     *****************************************************************************************************************/
    private PaginationInfo paginationInfo;

    /******************************************************************************************************************
     * An error code in case the wrapper is used to report error.
     *****************************************************************************************************************/
    private AssetCategoryErrorMessages errorCode;

    /******************************************************************************************************************
     * Constructor of the AssetCategoryResponseWrapper class, both for Builder pattern and instantiation with "new".
     *
     * @param code A value from the ResponseCode enumeration to be included in responses.
     * @param message A message to be included in responses.
     * @param paginationInfo An object containing information regarding Pagination.
     * @param errorCode A small string identifying a particular error.
     *****************************************************************************************************************/
    public AssetCategoryResponsesWrapper(ResponseCode code, String message, PaginationInfo paginationInfo, AssetCategoryErrorMessages errorCode) {
        this.setCode(code);
        if (code.equals(ResponseCode.SUCCESS)) {
            this.setMessage("Request has been successful.");
        } else {
            this.setMessage(message);
        }
        if (paginationInfo == null) {
            this.paginationInfo = new PaginationInfo(0, 0, 0);
        } else {
            this.paginationInfo = paginationInfo;
        }
        this.listOfResponses = new ArrayList<>();
        this.errorCode = errorCode;
    }

    /******************************************************************************************************************
     * Empty constructor of the AssetCategoryResponseWrapper class.
     *****************************************************************************************************************/
    public AssetCategoryResponsesWrapper() {
        this.setCode(ResponseCode.UNDEFINED);
        this.setMessage(null);
        this.listOfResponses = new ArrayList<>();
        this.paginationInfo = new PaginationInfo(0, 0, 0);
        this.errorCode = null;
    }

    /******************************************************************************************************************
     * "Getter" function for "paginationInfo" attribute.
     *
     * @return The current value of the object's "paginationInfo" attribute.
     *****************************************************************************************************************/
    public PaginationInfo getPaginationInfo() {
        return paginationInfo;
    }

    /******************************************************************************************************************
     * "Setter" function for "paginationInfo" attribute.
     *
     * @param paginationInfo A value to assign to the object's "paginationInfo" attribute.
     *****************************************************************************************************************/
    public void setPaginationInfo(PaginationInfo paginationInfo) {
        this.paginationInfo = paginationInfo;
    }

    /******************************************************************************************************************
     * "Getter" function for "listOfResponses" attribute.
     *
     * @return The current value of the object's "listOfResponses" attribute.
     *****************************************************************************************************************/
    public List<AssetCategoryResponseDto> getListOfResponses() {
        if (listOfResponses == null) {
            listOfResponses = new ArrayList<>();
        }
        return listOfResponses;
    }

    /******************************************************************************************************************
     * "Setter" function for "listOfResponses" attribute.
     *
     * @param listOfResponses A value to assign to the object's "listOfResponses" attribute.
     *****************************************************************************************************************/
    public void setListOfResponses(List<AssetCategoryResponseDto> listOfResponses) {
        if (listOfResponses == null) {
            this.listOfResponses = new ArrayList<>();
        } else {
            this.listOfResponses = listOfResponses;
        }
    }

    /******************************************************************************************************************
     * Method for gracefully adding AssetCategoryResponseDto objects to the list.
     *
     * @param responseDto A data transfer object to be returned as a result of an HTTP request.
     *****************************************************************************************************************/
    public void addResponse(AssetCategoryResponseDto responseDto) {
        if (this.listOfResponses == null) {
            this.listOfResponses = new ArrayList<>();
        }
        if (responseDto == null) {
            return;
        }
        this.listOfResponses.add(responseDto);
    }

    /******************************************************************************************************************
     * Method for gracefully removing AssetCategoryResponseDto objects from the list.
     *
     * @param responseDto A data transfer object to be returned as a result of an HTTP request.
     *****************************************************************************************************************/
    public void removeResponse(AssetCategoryResponseDto responseDto) {
        if (this.listOfResponses == null) {
            this.listOfResponses = new ArrayList<>();
            return;
        }
        this.listOfResponses.remove(responseDto);
    }

    /******************************************************************************************************************
     * Method for gracefully removing all AssetCategoryResponseDto objects from the list.
     *****************************************************************************************************************/
    public void removeAllResponses() {
        if (this.listOfResponses == null) {
            this.listOfResponses = new ArrayList<>();
            return;
        }
        this.listOfResponses.clear();
    }

    /******************************************************************************************************************
     * "Getter" function for "errorCode" attribute.
     *
     * @return The current value of the object's "errorCode" attribute.
     *****************************************************************************************************************/
    public AssetCategoryErrorMessages getErrorCode() {
        return errorCode;
    }

    /******************************************************************************************************************
     * "Setter" function for "errorCode" attribute.
     *
     * @param errorCode A value to assign to the object's "errorCode" attribute, not null.
     *****************************************************************************************************************/
    public void setErrorCode(AssetCategoryErrorMessages errorCode) {
        this.errorCode = errorCode;
    }

    /******************************************************************************************************************
     * Transforms an AssetCategoryResponseWrapper object to String.
     *
     * @return A string representation of the Object.
     *****************************************************************************************************************/
    @Override
    public String toString() {
        return "{" +
                "code=" + super.getCode() +
                ", message='" + super.getMessage() + '\'' +
                ", listOfResponses='" + listOfResponses + '\'' +
                ", paginationInfo='" + paginationInfo + '\'' +
                ", errorCode='" + errorCode + '\'' +
                '}';
    }
}