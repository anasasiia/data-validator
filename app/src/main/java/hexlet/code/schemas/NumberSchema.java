package hexlet.code.schemas;

import java.util.Objects;

public final class NumberSchema extends BaseSchema<Integer> {
    private boolean isPositive = false;

    public boolean isPositive() {
        return isPositive;
    }

    public void setPositive() {
        this.isPositive = true;
    }

    public NumberSchema() {
    }

    public NumberSchema positive() {
        setPositive();
        addInValidations(num -> num == null || num > 0);
        return this;
    }

    public NumberSchema required() {
        setRequired();
        addInValidations(Objects::nonNull);
        return this;
    }

    public void isCorrectType() {
        addInValidationsDataType(Integer.class::isInstance);
        if (isPositive()) {
            addInValidations(obj -> obj > 0);
        }
    }

    public void range(Integer min, Integer max) {
        addInValidations(num -> num >= min && num <= max);
    }
}
