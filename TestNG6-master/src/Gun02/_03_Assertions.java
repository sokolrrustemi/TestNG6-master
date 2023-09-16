package Gun02;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _03_Assertions {

    @Test
    public void equalsOrnek(){
        String s1="Merhaba";
        String s2="Merhaba1";

        // Actul (oluşan), Expected (beklenen), Mesaj (Opsiyonel)
        //Assert.assertEquals(s1,s2);
        Assert.assertEquals(s1,s2,"oluşan la beklenen aynı değil");
    }

    @Test
    public void notEqualsOrnek(){
        String s1="Merhaba";
        String s2="Merhaba1";

        Assert.assertNotEquals(s1,s2,"oluşan la beklenen aynı değil");
    }

    @Test
    public void trueOrnek(){
        String s1="Merhaba";
        String s2="Merhaba";

        Assert.assertTrue(s1.equals(s2),"oluşan la beklenen aynı değil");
    }

    @Test
    public void nullOrnek(){
        String s1=null;

        Assert.assertNull(s1,"oluşan NULL olmadı");
    }

    @Test
    public void direkFail(){
        int a=55;

        if (a != 55)
            Assert.fail();
    }


}
