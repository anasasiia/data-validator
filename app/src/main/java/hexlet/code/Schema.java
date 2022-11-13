package hexlet.code;

public interface Schema {
    BaseSchema required();
    boolean isValid(Object object);
}
