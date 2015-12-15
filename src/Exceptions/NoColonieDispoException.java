package Exceptions;

public class NoColonieDispoException extends Exception {

	@Override
	public String getMessage() {
		return "Vous n'avez plus de colonie disponible";
	}
}
