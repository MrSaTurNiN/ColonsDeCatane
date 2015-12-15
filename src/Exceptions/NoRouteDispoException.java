package Exceptions;

public class NoRouteDispoException extends Exception {
	
	@Override
	public String getMessage() {
		return "Vous n'avez plus de route disponible";

	}
}
