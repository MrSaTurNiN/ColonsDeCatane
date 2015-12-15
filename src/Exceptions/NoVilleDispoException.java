package Exceptions;

public class NoVilleDispoException extends Exception{
	@Override
	public String getMessage() {
		return "Vous n'avez plus de Route disponible";
	}
}
