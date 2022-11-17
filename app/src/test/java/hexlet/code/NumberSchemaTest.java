package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberSchemaTest {
    private final Integer number10 = 10;
    private final Integer number8 = 8;
    private final Integer numberMinus10 = -10;
    private final Integer number5 = 5;
    private final Integer number4 = 4;
    private final Integer number11 = 11;

    @Test
    public void numberSchemaTest() {
        Validator v = new Validator();
        NumberSchema schema = v.number();
        Assertions.assertTrue(schema.isValid(null));
        Assertions.assertTrue(schema.isValid(""));
        Assertions.assertFalse(schema.positive().isValid("2"));

        schema.required();

        Assertions.assertFalse(schema.isValid(null));
        Assertions.assertTrue(schema.isValid(number10));
        Assertions.assertFalse(schema.isValid("5"));

        Assertions.assertTrue(schema.positive().isValid(number10));
        Assertions.assertFalse(schema.positive().isValid(numberMinus10));

        schema.range(number5, number10);

        Assertions.assertTrue(schema.positive().isValid(number5));
        Assertions.assertTrue(schema.isValid(number8));
        Assertions.assertTrue(schema.isValid(number10));
        Assertions.assertFalse(schema.isValid(number4));
        Assertions.assertFalse(schema.isValid(number11));
    }
}
