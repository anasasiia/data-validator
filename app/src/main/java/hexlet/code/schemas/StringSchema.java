package hexlet.code.schemas;

import java.util.Objects;

public final class StringSchema extends BaseSchema<String> {

    public StringSchema() {
    }

    public StringSchema required() {
        setRequired();
        addInValidations(Objects::nonNull);
        return this;
    }

    public void isCorrectType() {
        addInValidationsDataType(String.class::isInstance);
        addInValidationsDataType(obj -> !Objects.equals(obj, ""));
    }

    public StringSchema contains(String str) {
        addInValidations(content -> String.valueOf(content).contains(str));
        return this;
    }

    public StringSchema minLength(int length) {
        addInValidations(content -> String.valueOf(content).length() >= length);
        return this;
    }

}
