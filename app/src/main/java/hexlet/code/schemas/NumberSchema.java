package hexlet.code.schemas;

import java.util.Objects;

public final class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema() {
    }

    public NumberSchema positive() {
        addInValidations("notString", num -> num == null || num instanceof Integer);
        addInValidations("positive", num -> num == null || (Integer) num > 0);
        return this;
    }

    public NumberSchema required() {
        addInValidations("notNull", Objects::nonNull);
        addInValidations("isInteger", Integer.class::isInstance);
        return this;
    }

    public void range(Integer min, Integer max) {
        addInValidations("range", num -> (Integer) num >= min && (Integer) num <= max);
    }
}
