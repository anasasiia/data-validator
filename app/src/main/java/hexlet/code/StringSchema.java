package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public final class StringSchema extends BaseSchema<String> {
    private final List<Predicate<Object>> validationsString = new ArrayList<>();

    public List<Predicate<Object>> getValidationsString() {
        return validationsString;
    }

    public StringSchema() {
    }

    @Override
    public boolean isValid(Object string) {
        if (isRequiredMode()) {
            buildValidationsString();
            for (Predicate<Object> validationString : getValidationsString()) {
                if (!validationString.test(string)) {
                    return false;
                }
            }
            return super.isValid(string);
        }
        return true;
    }

    public StringSchema contains(String str) {
        Predicate<Object> containsStr = content -> String.valueOf(content).contains(str);
        validations.add(containsStr);
        return this;
    }

    public StringSchema minLength(int length) {
        Predicate<Object> minLength = content -> String.valueOf(content).length() >= length;
        validations.add(minLength);
        return this;
    }

    public void buildValidationsString() {
        Predicate<Object> notNull = Objects::nonNull;
        Predicate<Object> notEmpty = content -> !Objects.equals(content, "");
        Predicate<Object> isString = content -> content instanceof String;
        validationsString.add(notNull);
        validationsString.add(notEmpty);
        validationsString.add(isString);
    }

}
