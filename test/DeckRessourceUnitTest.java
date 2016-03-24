import Exceptions.ressource.OutOfCardException;
import Exceptions.ressource.UnKnownRessource;
import Model.ressource.DeckRessource;
import Model.ressource.Ressource;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jpabegg on 17/12/15.
 */
public class DeckRessourceUnitTest {
    @Test
    public void testPiocherRessource(){
        DeckRessource deck = new DeckRessource();
        Ressource r;
        try {
            r = deck.piocherRessource(Ressource.Argile.name());
        } catch (OutOfCardException e) {
            r = Ressource.Minerai;
            Assert.fail();
        } catch (UnKnownRessource unKnownRessource) {
            r = Ressource.Argile;
           Assert.fail();
        }
        Assert.assertTrue(r.name().equals(Ressource.Argile.name()));
    }

}
