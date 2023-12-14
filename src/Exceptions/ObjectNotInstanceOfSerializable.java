package Exceptions;

public class ObjectNotInstanceOfSerializable extends RuntimeException{
    public ObjectNotInstanceOfSerializable(String message) {
        super(message);
    }
}
