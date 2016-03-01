package Exceptions.batiment;

public class NoColonieDispoException extends NoBatimentDispoException {

	@Override
	public String getMessage() {
		return "Vous n'avez plus de colonie disponible";
	}
}
