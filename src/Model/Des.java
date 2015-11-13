package Model;

import java.util.Random;

/**
 * Created by jpabegg on 13/11/15.
 */
public class Des
{
    private static Random random = new Random();
    public Des()
    {
    	//A remplir
    }

    public int lancerDes()
    {
        return 2+random.nextInt(11);
    }
}
