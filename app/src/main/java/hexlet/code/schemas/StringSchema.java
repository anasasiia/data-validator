package hexlet.code.schemas;

import java.util.Objects;

public final class StringSchema extends BaseSchema<String> {

    public StringSchema() {
    }

    public StringSchema required() {
        addInValidations(Objects::nonNull);
        addInValidations(String.class::isInstance);
        addInValidations(input -> !Objects.equals(input, ""));
        return this;
    }

    public StringSchema contains(String str) {
        if (getInput() instanceof String && !Objects.equals(getInput(), "")) {
            addInValidations(content -> String.valueOf(content).contains(str));
        }
        return this;
    }

    public StringSchema minLength(int length) {
        if (getInput() instanceof String) {
            addInValidations(content -> String.valueOf(content).length() >= length);
        }
        return this;
    }
}
