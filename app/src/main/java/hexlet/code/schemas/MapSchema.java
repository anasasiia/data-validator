package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;

public final class MapSchema extends BaseSchema<Map<Object, Object>> {
    public MapSchema() {
    }

    public void sizeof(Integer size) {
        addInValidations(map -> {
            Map<?, ?> inputMap = (Map<?, ?>) map;
            return inputMap.size() == size;
        });
    }

    public MapSchema required() {
        setRequired();
        addInValidationsDataType(Objects::nonNull);
        addInValidationsDataType(Map.class::isInstance);
        return this;
    }

    public void shape(Map<String, BaseSchema> newShape) {
        addInValidations(map -> checkShape((Map<?, ?>) map, newShape));
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
