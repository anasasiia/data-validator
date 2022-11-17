package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    private Object input;
    private final List<Predicate<Object>> validations = new ArrayList<>();

    public final Object getInput() {
        return input;
    }

    private boolean required = false;

    public final boolean isRequired() {
        return required;
    }

    public final void setRequired() {
        this.required = true;
    }

    public final void addInValidations(Predicate<Object> predicate) {
        validations.add(predicate);
    }

    public final List<Predicate<Object>> getValidations() {
        return validations;
    }

    public abstract BaseSchema<T> required();

    public final boolean isValid(Object object) {
        this.input = object;
        return getValidations().stream().allMatch(validation -> validation.test(object));
    }
}
