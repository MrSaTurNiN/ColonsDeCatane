package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by jpabegg on 13/11/15.
 */
public class DeckDeveloppement
{
    private static Random random = new Random();

    private List<Developpement> cartDeveloppement;

    public DeckDeveloppement()
    {
        cartDeveloppement=new ArrayList<Developpement>();
    }

    public Developpement piocherDeveloppement()
    {
        return null;
    }

    public void initDeveloppement()
    {

    }

	public List<Developpement> getCartDeveloppement() {
		return cartDeveloppement;
	}

	public void setCartDeveloppement(List<Developpement> cartDeveloppement) {
		this.cartDeveloppement = cartDeveloppement;
	}
}
