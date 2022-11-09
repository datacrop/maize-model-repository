package eu.datacrop.maize.model_repository.persistence.validators;

import eu.datacrop.maize.model_repository.commons.dtos.requests.auxiliaries.ParameterRequestDto;
import eu.datacrop.maize.model_repository.commons.dtos.requests.templates.RequestDto;
import eu.datacrop.maize.model_repository.commons.enums.ResponseCode;
import eu.datacrop.maize.model_repository.commons.error.messages.ParameterErrorMessages;
import eu.datacrop.maize.model_repository.commons.validators.Validator;
import eu.datacrop.maize.model_repository.commons.wrappers.single.auxiliaries.ParameterResponseWrapper;

import java.util.Vector;

/**********************************************************************************************************************
 * This class implements methods to validate whether an incoming HTTP Request body contains attributes that are
 * valid according to the business rules for a Parameter entity.
 *
 * @author Angela-Maria Despotopoulou [Athens, Greece]
 * @since version 0.4.0
 *********************************************************************************************************************/
public class ParameterValidator implements Validator {

    /******************************************************************************************************************
     * This method triggers validation of the data transfer object's attributes.
     *
     * @param requestDto A data transfer object to validate, not null.
     * @return A ResponseWrapper (the user will receive a more elaborate one, here it is used only for
     * internal intra-module communication).
     *
     * throws IllegalArgumentException, if requestDto is null.
     *****************************************************************************************************************/
    @Override
    public ParameterResponseWrapper validateAttributes(RequestDto requestDto) throws IllegalArgumentException {

        // Checking input parameters.
        if (requestDto == null) {
            throw new IllegalArgumentException("Invalid parameter detected for method ParameterValidator.validate().");
        }

        ParameterRequestDto parameterRequestDto = (ParameterRequestDto) requestDto;

        String message;
        try {
            // Checking the request for mandatory fields that were erroneously provided without content.
            Vector<String> fields = getNamesOfFieldsThatAreErroneouslyNull(parameterRequestDto);
            if (!fields.isEmpty()) {
                message = ParameterErrorMessages.MANDATORY_FIELDS_MISSING.toString().concat(" Field(s): ").concat(fields.toString());
                return new ParameterResponseWrapper(ResponseCode.BAD_REQUEST, message, null, ParameterErrorMessages.MANDATORY_FIELDS_MISSING);
            }
        } catch (IllegalArgumentException e) {
            // Reporting internal server error.
            throw new IllegalArgumentException(e.getMessage());
        }

        // Reporting that attribute validation found no issues.
        return new ParameterResponseWrapper(ResponseCode.SUCCESS, "Validation success.", null, null);
    }

    /******************************************************************************************************************
     * This method triggers validation of the data transfer object's external relationships.
     *
     * @param requestDto A data transfer object to validate, not null.
     * @return A ResponseWrapper (the user will receive a more elaborate one, here it is used only for
     * internal intra-module communication).
     *
     * throws IllegalArgumentException, if requestDto is null.
     *****************************************************************************************************************/
    @Override
    public ParameterResponseWrapper validateRelationships(RequestDto requestDto) throws IllegalArgumentException {

        if (requestDto == null) {
            throw new IllegalArgumentException("Invalid parameter detected for method ParameterValidator.validate().");
        }

        // Always returns SUCCESS according to business logic Parameter do not refer to other entities.
        return new ParameterResponseWrapper(ResponseCode.SUCCESS, "Validation success.", null, null);
    }

    /******************************************************************************************************************
     * This method parses a Parameter Request Data Transfer Object for fields that should have not been left
     * null according to business logic. Returns empty Vector if no erroneous fields have been located.
     *
     * @param   requestDto The data transfer object to be parsed, not null.
     * @return A collection of fields that have been marked as erroneous.
     *
     * @throws IllegalArgumentException if the method parameter is null.
     *****************************************************************************************************************/
    private Vector<String> getNamesOfFieldsThatAreErroneouslyNull(ParameterRequestDto requestDto) throws IllegalArgumentException {

        // Checking input parameters.
        if (requestDto == null) {
            throw new IllegalArgumentException("Invalid parameter detected for method ParameterValidator.getNamesOfFieldsThatAreErroneouslyNull().");
        }

        Vector<String> fields = new Vector<String>();

        // Checking mandatory fields "Name" and "Description".
        if (requestDto.getName() == null || requestDto.getName().isBlank()) fields.add("name");
        if (requestDto.getDescription() == null) fields.add("description");
        if (requestDto.getType() == null) fields.add("type");

        // Logging and returning result.
        return fields;
    }
}
