package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema<Integer> {
    private final List<Predicate<Object>> validationsInteger = new ArrayList<>();

    public List<Predicate<Object>> getValidationsInteger() {
        return validationsInteger;
    }

    public NumberSchema() {
    }

    public NumberSchema positive() {
        Predicate<Object> isPositive = num -> (Integer) num > 0;
        addInValidations(isPositive);
        return this;
    }

    public boolean isValid(Object integer) {
        if (isRequiredMode()) {
            buildValidationsInteger();
            for (Predicate<Object> validation: getValidationsInteger()) {
                if (!validation.test(integer)) {
                    return false;
                }
            }
            return super.isValid(integer);
        }
        return true;
    }


    public void range(Integer firstNumber, Integer secondNumber) {
        Predicate<Object> isBetweenNumber = num -> (Integer) num >= firstNumber && (Integer) num <= secondNumber;
        addInValidations(isBetweenNumber);
    }

    public void buildValidationsInteger() {
        Predicate<Object> notNull = Objects::nonNull;
        Predicate<Object> isInteger = num -> num instanceof Integer;
        validationsInteger.add(notNull);
        validationsInteger.add(isInteger);
    }
}
