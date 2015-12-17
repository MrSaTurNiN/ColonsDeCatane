import Model.Des;
import junit.framework.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Random;

/**
 * Created by jpabegg on 17/12/15.
 */
public class DesUnitTest {
    @Test
    public void testLancerDes(){
        Random r = Mockito.mock(Random.class);
        Mockito.when(r.nextInt(Mockito.anyInt())).thenReturn(4);
        Des d = new Des(r);
        Assert.assertEquals(d.lancerDes(),6);
    }
}
