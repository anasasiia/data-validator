package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema<Map<Object, Object>> {
    public MapSchema() {
    }

    public void isCorrectType() {
        addInValidationsDataType(Map.class::isInstance);
    }

    public void sizeof(Integer size) {
        addInValidations(map -> map.size() == size);
    }

    public MapSchema required() {
        setRequired();
        return this;
    }

    public void shape(Map<String, BaseSchema> newShape) {
        addInValidations(map -> checkShape(map, newShape));
    }

    private boolean checkShape(Map<?, ?> map, Map<String, BaseSchema> newShape) {
        for (Map.Entry<String, BaseSchema> entry: newShape.entrySet()) {
            BaseSchema schema = entry.getValue();
            Object value = map.get(entry.getKey());
            if (!schema.isValid(value)) {
                return false;
            }
        }
        return true;
    }
}
