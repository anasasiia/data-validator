package hexlet.code;

final class NumberSchema extends BaseSchema<Integer> {
    private boolean isPositive = false;

    public boolean isPositive() {
        return isPositive;
    }

    public void setPositive() {
        this.isPositive = true;
    }

    NumberSchema() {
    }

    public NumberSchema positive() {
        setPositive();
        addInValidations(num -> num == null || num > 0);
        return this;
    }

    public NumberSchema required() {
        setRequired();
        return this;
    }

    public void isCorrectType() {
        addInValidationsDataType(Integer.class::isInstance);
        if (isPositive()) {
            addInValidations(obj -> obj % 2 == 0);
        }
    }

    public void range(Integer min, Integer max) {
        addInValidations(num -> num >= min && num <= max);
    }
}
