package hexlet.code;

public interface Schema {
    void required();
    boolean isValid(Object object);
}
