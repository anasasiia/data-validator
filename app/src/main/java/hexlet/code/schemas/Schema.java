package hexlet.code.schemas;

import hexlet.code.schemas.BaseSchema;

public interface Schema {
    BaseSchema required();
    boolean isValid(Object object);
}
