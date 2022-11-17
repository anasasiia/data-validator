package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    private final Map<String, Predicate<Object>> validations = new HashMap<>();

    public final void addInValidations(String name, Predicate<Object> predicate) {
        validations.put(name, predicate);
    }

    public final Map<String, Predicate<Object>> getValidations() {
        return validations;
    }

    public abstract BaseSchema<T> required();

    public final boolean isValid(Object object) {
        return getValidations().values().stream().allMatch(validation -> validation.test(object));
    }
}
