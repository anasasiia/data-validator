package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
//    private Object input;
    private final List<Predicate<Object>> validations = new ArrayList<>();
    private final List<Predicate<Object>> validationsDataType = new ArrayList<>();

    public final List<Predicate<Object>> getValidationsDataType() {
        return validationsDataType;
    }

    private boolean required = false;

    public final boolean isRequired() {
        return required;
    }

    public final void setRequired() {
        this.required = true;
    }
/*
    public final void addInValidationsDataType(Predicate<Object> predicate) {
        validationsDataType.add(predicate);
    }

 */

    public final void addInValidations(Predicate<Object> predicate) {
        validations.add(predicate);
    }

    public final List<Predicate<Object>> getValidations() {
        return validations;
    }

    public abstract BaseSchema<T> required();

    public final boolean isValid(Object object) {
 //       this.input = object;
        if (isRequired()) {
            if (!getValidationsDataType().stream().allMatch(validation -> validation.test(object))) {
                return false;
            }
        }
        return getValidations().stream().allMatch(validation -> validation.test(object));
    }
}
