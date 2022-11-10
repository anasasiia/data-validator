package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    protected T object;
    protected boolean requiredMode = false;
    protected final List<Predicate<Object>> validations = new ArrayList<>();

    public List<Predicate<Object>> getValidations() {
        return validations;
    }

    public boolean isRequiredMode() {
        return requiredMode;
    }

    public void setRequiredMode(boolean newRequiredMode) {
        this.requiredMode = newRequiredMode;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public void required() {
        setRequiredMode(true);
    }

    public boolean isValid(Object object) {
        setObject((T) object);
        for (Predicate<Object> validation : getValidations()) {
            if (!validation.test(getObject())) {
                return false;
            }
        }
        return true;
    }

}
