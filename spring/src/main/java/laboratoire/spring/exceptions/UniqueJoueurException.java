package laboratoire.spring.exceptions;

public class UniqueJoueurException extends RuntimeException{

    public UniqueJoueurException() {
        super("L'utilisateur existe déjà");
    }

    public UniqueJoueurException(String message) {
        super(message);
    }
}
