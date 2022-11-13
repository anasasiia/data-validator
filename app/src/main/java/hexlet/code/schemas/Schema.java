package hexlet.code.schemas;

public interface Schema {
    BaseSchema required();
    boolean isValid(Object object);
}
