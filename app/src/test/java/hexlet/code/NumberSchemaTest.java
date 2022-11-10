package hexlet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberSchemaTest {

    @Test
    public void numberSchemaTest() {
        Validator v = new Validator();
        NumberSchema schema = v.number();
        Assertions.assertTrue(schema.isValid(null));

        schema.required();

        Assertions.assertFalse(schema.isValid(null));
        Integer number_10 = 10;
        Assertions.assertTrue(schema.isValid(number_10));
        Assertions.assertFalse(schema.isValid("5"));

        Assertions.assertTrue(schema.positive().isValid(number_10));
        Integer number__10 = -10;
        Assertions.assertFalse(schema.isValid(number__10));

        Integer number_5 = 5;
        schema.range(number_5, number_10);

        Integer number_6 = 6;
        Assertions.assertTrue(schema.positive().isValid(number_6));
        Assertions.assertTrue(schema.isValid(number_5));
        Assertions.assertTrue(schema.isValid(number_10));
        Integer number_4 = 4;
        Assertions.assertFalse(schema.isValid(number_4));
        Integer number_11 = 11;
        Assertions.assertFalse(schema.isValid(number_11));
    }
}
