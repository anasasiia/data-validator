package hexlet.code.schemas;

import java.util.Objects;

public final class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema() {
    }

    public NumberSchema positive() {
        if (getInput() == null) {
            addInValidations(Objects::isNull);
        }
        if (getInput() instanceof Integer) {
            addInValidations(num -> (Integer) num > 0);
        }
        return this;
    }

    public NumberSchema required() {
        setRequired();
        addInValidations(Objects::nonNull);
        addInValidations(Integer.class::isInstance);
        return this;
    }

    public void range(Integer min, Integer max) {
        if (getInput() instanceof Integer) {
            addInValidations(num -> (Integer) num >= min && (Integer) num <= max);
        }
    }
}
