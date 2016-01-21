package Exceptions.batiment;

import Exceptions.batiment.NoBatimentDispoException;

public class NoVilleDispoException extends NoBatimentDispoException {
	@Override
	public String getMessage() {
		return "Vous n'avez plus de Route disponible";
	}
}
