package Exceptions.batiment;

import Exceptions.batiment.NoBatimentDispoException;

public class NoRouteDispoException extends NoBatimentDispoException {
	
	@Override
	public String getMessage() {
		return "Vous n'avez plus de route disponible";

	}
}
