package hexlet.code.schemas;

import java.util.Objects;

public final class StringSchema extends BaseSchema<String> {
    public StringSchema required() {
        addInValidations("notNull", Objects::nonNull);
        addInValidations("isString", String.class::isInstance);
        addInValidations("notEmpty", input -> !Objects.equals(input, ""));
        return this;
    }

    public StringSchema contains(String str) {
        addInValidations("contains", content -> String.valueOf(content).contains(str));
        return this;
    }

    public StringSchema minLength(int length) {
        addInValidations("minLength", content -> String.valueOf(content).length() >= length);
        return this;
    }
}
