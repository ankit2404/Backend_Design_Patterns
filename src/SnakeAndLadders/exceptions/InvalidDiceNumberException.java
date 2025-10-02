package SnakeAndLadders.exceptions;

public class InvalidDiceNumberException extends RuntimeException {
    public InvalidDiceNumberException(String message) {
        super(message);
    }
}
