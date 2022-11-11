package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class BaseSchema<T> implements Schema {
    private boolean requiredMode = false;
    private final List<Predicate<Object>> validations = new ArrayList<>();

    public void addInValidations(Predicate<Object> predicate) {
        validations.add(predicate);
    }

    public List<Predicate<Object>> getValidations() {
        return validations;
    }

    public boolean isRequiredMode() {
        return requiredMode;
    }

    public void setRequiredMode(boolean newRequiredMode) {
        requiredMode = newRequiredMode;
    }

    public void required() {
        setRequiredMode(true);
    }

    public boolean isValid(Object object) {
        for (Predicate<Object> validation : getValidations()) {
            if (!validation.test(object)) {
                return false;
            }
        }
        return true;
    }

}
