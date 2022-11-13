package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public abstract class BaseSchema<T> implements Schema {
    private boolean required = false;
    private final List<Predicate<T>> validations = new ArrayList<>();
    private final List<Predicate<Object>> validationsDataType = new ArrayList<>();

    public void addInValidationsDataType(Predicate<Object> predicate) {
        validationsDataType.add(predicate);
    }

    public List<Predicate<Object>> getValidationsDataType() {
        return validationsDataType;
    }

    public abstract void isCorrectType();

    public void addInValidations(Predicate<T> predicate) {
        validations.add(predicate);
    }

    public List<Predicate<T>> getValidations() {
        return validations;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired() {
        this.required = true;
    }

    public BaseSchema<T> required() {
        setRequired();
        addInValidations(Objects::nonNull);
        return this;
    }

    public boolean isValid(Object object) {
        if (isRequired()) {
            isCorrectType();
            if (!getValidationsDataType().stream().allMatch(v -> v.test(object))) {
                return false;
            }
        }
        return getValidations().stream().allMatch(validation -> validation.test((T) object));
    }
}
