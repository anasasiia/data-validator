package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public final class StringSchema {
    private String string;

    private boolean requiredMode = false;
    private final List<Predicate<String>> validations = new ArrayList<>();

    public StringSchema() {
    }

    public String getString() {
        return string;
    }

    public void setString(String newString) {
        this.string = newString;
    }

    public boolean isRequiredMode() {
        return requiredMode;
    }

    public void setRequiredMode(boolean newRequiredMode) {
        this.requiredMode = newRequiredMode;
    }

    public List<Predicate<String>> getValidations() {
        return validations;
    }

    public boolean isValid(String content) {
        setString(content);
        if (!isRequiredMode()) {
            return true;
        }
        isNullOrEmpty();
        for (Predicate<String> validation : getValidations()) {
            if (!validation.test(getString())) {
                return false;
            }
        }
        return true;
    }

    public StringSchema contains(String str) {
        Predicate<String> containsStr = content -> content.contains(str);
        validations.add(containsStr);
        return this;
    }

    public void required() {
        setRequiredMode(true);
    }

    public void minLength(int length) {
        Predicate<String> minLength = content -> content.length() >= length;
        validations.add(minLength);
    }

    private void isNullOrEmpty() {
        Predicate<String> notNull = Objects::nonNull;
        Predicate<String> notEmpty = content -> !content.equals("");
        validations.add(notNull);
        validations.add(notEmpty);
    }
}
