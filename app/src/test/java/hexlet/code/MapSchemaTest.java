package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class MapSchemaTest {
    private final Integer age1 = 100;
    private final Integer age2 = -5;
    @Test
    public void mapSchemaTest() {
        Validator v = new Validator();
        MapSchema schema = v.map();
        Assertions.assertTrue(schema.isValid(null));

        schema.required();

        Assertions.assertFalse(schema.isValid(null));
        Assertions.assertTrue(schema.isValid(new HashMap<>()));
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        Map<String, Integer> data2 = new HashMap<>();
        data2.put("key", 2);
        Assertions.assertTrue(schema.isValid(data));
        Assertions.assertTrue(schema.isValid(data2));

        schema.sizeof(2);

        Assertions.assertFalse(schema.isValid(data));
        data.put("key2", "value2");
        Assertions.assertTrue(schema.isValid(data));
    }

    @Test
    public void mapSchemaTestWithShape() {
        Validator v = new Validator();
        MapSchema schema = v.map();

        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("name", v.string().required());
        schemas.put("age", v.number().positive());
        schema.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", age1);
        Assertions.assertTrue(schema.isValid(human1));

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", null);
        Assertions.assertTrue(schema.isValid(human2));

        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);
        Assertions.assertFalse(schema.isValid(human3));

        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Valya");
        human4.put("age", age2);
        Assertions.assertFalse(schema.isValid(human4));

        Map<String, Object> human5 = new HashMap<>();
        human4.put("name", "Valya");
        human4.put("age", "valya");
        Assertions.assertFalse(schema.isValid(human5));
    }
}
