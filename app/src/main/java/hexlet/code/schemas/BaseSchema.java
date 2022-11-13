package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    private boolean required = false;
    private final List<Predicate<T>> validations = new ArrayList<>();
    private final List<Predicate<Object>> validationsDataType = new ArrayList<>();

    public final void addInValidationsDataType(Predicate<Object> predicate) {
        validationsDataType.add(predicate);
    }

    public final List<Predicate<Object>> getValidationsDataType() {
        return validationsDataType;
    }

    public abstract void isCorrectType();

    public final void addInValidations(Predicate<T> predicate) {
        validations.add(predicate);
    }

    public final List<Predicate<T>> getValidations() {
        return validations;
    }

    public final boolean isRequired() {
        return required;
    }

    public final void setRequired() {
        this.required = true;
    }

    public abstract BaseSchema<T> required();

    public final boolean isValid(Object object) {
        if (isRequired()) {
            isCorrectType();
            if (!getValidationsDataType().stream().allMatch(v -> v.test(object))) {
                return false;
            }
        }
        return getValidations().stream().allMatch(validation -> validation.test((T) object));
    }
}
