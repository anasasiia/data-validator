package hexlet.code.schemas;

import java.util.Objects;

public final class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema() {
    }

    public NumberSchema positive() {
        addInValidations(num -> num == null || (Integer) num > 0);
        return this;
    }

    public NumberSchema required() {
        setRequired();
        addInValidations(Objects::nonNull);
        addInValidations(Integer.class::isInstance);
        return this;
    }

    public void range(Integer min, Integer max) {
        addInValidations(num -> (Integer) num >= min && (Integer) num <= max);
    }
}
