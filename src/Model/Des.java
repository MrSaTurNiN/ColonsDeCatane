package Model;

import java.io.Serializable;
import java.util.Random;

/**
 * Created by jpabegg on 13/11/15.
 */
public class Des implements Serializable
{
    private static Random random = new Random();
    public Des()
    {
    }
    public Des(Random random){
        this.random = random;
    }

    public int lancerDes()
    {
        return 2+random.nextInt(11);
    }
}
