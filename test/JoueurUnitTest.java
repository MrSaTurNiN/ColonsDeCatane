import Model.Joueur;
import Model.ressource.Ressource;
import junit.framework.Assert;
import org.junit.Test;

import java.awt.*;

/**
 * Created by jpabegg on 17/12/15.
 */
public class JoueurUnitTest {
    @Test
    public void retirerCarteFail(){
        Joueur j = new Joueur("toto",Color.black);
        Ressource r = j.retirerCarte(Ressource.Argile.name());
        Assert.assertEquals(r,null);
    }
    @Test
    public void testObtenirRessource()
    {
        Joueur j = new Joueur("toto", Color.black);
        j.obtenirCarte(Ressource.Argile);
        Ressource r = j.retirerCarte(Ressource.Argile.name());
        Assert.assertTrue(r.name().equals(Ressource.Argile.name()));
    }
}
