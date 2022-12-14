package eu.datacrop.maize.model_repository.commons.dtos.requests.templates;

import com.fasterxml.jackson.annotation.JsonIgnore;
import eu.datacrop.maize.model_repository.commons.validators.Validator;
import eu.datacrop.maize.model_repository.commons.wrappers.ResponseWrapper;
import lombok.extern.slf4j.Slf4j;

/**********************************************************************************************************************
 * This class is a data transfer object used as body in incoming HTTP requests (POST and UPDATE).
 *
 * @author Angela-Maria Despotopoulou [Athens, Greece]
 * @since version 0.3.0
 *********************************************************************************************************************/
@Slf4j
public abstract class RequestDto {

    /******************************************************************************************************************
     * A validator offers methods to validate whether an incoming HTTP Request body contains attributes that are
     * valid according to the business rules.
     *****************************************************************************************************************/
    @JsonIgnore
    Validator validator;

    /******************************************************************************************************************
     * Empty constructor for the abstract class.
     *****************************************************************************************************************/
    protected RequestDto() {

    }

    /******************************************************************************************************************
     * "Getter" method for "validator" attribute.
     *
     * @return The current value of the object's "validator" attribute.
     *****************************************************************************************************************/
    public Validator getValidator() {
        return validator;
    }

    /******************************************************************************************************************
     * "Setter" function for "validator" attribute.
     *
     * @param validator A value to assign to the object's "validator" attribute, not null.
     *****************************************************************************************************************/
    public void setValidator(Validator validator) {
        this.validator = validator;
    }

    /******************************************************************************************************************
     * This method triggers validation of the data transfer object's attributes and external relationships.
     * Note: this mechanism exists following the "Strategy Design Pattern".
     *
     * @return An abstract ResponseWrapper (the user will receive a more elaborate one, here it is used only for
     * internal intra-module communication).
     *****************************************************************************************************************/
    public abstract ResponseWrapper performValidation();
}
