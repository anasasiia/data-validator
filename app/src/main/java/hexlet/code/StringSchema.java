package hexlet.code;

import java.util.Objects;

final class StringSchema extends BaseSchema<String> {

    StringSchema() {
    }

    public void isCorrectType() {
        addInValidationsDataType(String.class::isInstance);
        addInValidationsDataType(obj -> !Objects.equals(obj, ""));
    }

    public StringSchema contains(String str) {
        addInValidations(content -> String.valueOf(content).contains(str));
        return this;
    }

    public StringSchema required() {
        setRequired();
        return this;
    }

    public StringSchema minLength(int length) {
        addInValidations(content -> String.valueOf(content).length() >= length);
        return this;
    }

}
