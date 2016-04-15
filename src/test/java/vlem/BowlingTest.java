package vlem;

import org.junit.Test;

import static org.junit.Assert.*;

public class BowlingTest {

    @Test
    public void testCorrectLength() throws Exception {
        InterfaceBowling interfaceBowling = new Bowling();

        String inf = "123456789";
        String good = "12345678912345";
        String sup = "12345678901234567890123";


        assertTrue("String de taille inferieure",!interfaceBowling.correctLength(inf));
        assertTrue("String dans la bonne taille",interfaceBowling.correctLength(good));
        assertTrue("String de taille superieure", !interfaceBowling.correctLength(sup));    }

    @Test
    public void testCorrectRound() throws Exception {

        InterfaceBowling interfaceBowling= new Bowling();



        String test21="XX4";
        String test22="XXa";
        String test23="XXX";

        String test61="X2/";
        String test63="X2a";
        String test62="X//";


        String test41="1/X";
        String test42="1/5";
        String test43="1/a";

        String test51 = "1X1";
        String test52 = "1a1";



        String test71="999";
        String test72="X99";
        String test73="X23";

        String test1 ="abcd";

        assertTrue("test conditions",!interfaceBowling.correctRound(test1,0));
        assertTrue("test conditions",interfaceBowling.correctRound(test21,0));
        assertTrue("test conditions",!interfaceBowling.correctRound(test22,0));
        assertTrue("test conditions",interfaceBowling.correctRound(test23,0));
        assertTrue("test conditions",interfaceBowling.correctRound(test41,0));
        assertTrue("test conditions",interfaceBowling.correctRound(test42,0));
        assertTrue("test conditions",!interfaceBowling.correctRound(test43,0));
        assertTrue("test conditions",!interfaceBowling.correctRound(test51,0));
        assertTrue("test conditions",!interfaceBowling.correctRound(test52,0));
        assertTrue("test conditions",interfaceBowling.correctRound(test61,0));
        assertTrue("test conditions",!interfaceBowling.correctRound(test62,0));
        assertTrue("test conditions",!interfaceBowling.correctRound(test63,0));
        assertTrue("test conditions",!interfaceBowling.correctRound(test71,0));
        assertTrue("test conditions",!interfaceBowling.correctRound(test72,0));
        assertTrue("test conditions",interfaceBowling.correctRound(test73,0));
    }





    @Test
    public void testCorrectGame() throws Exception {
        InterfaceBowling interfaceBowling= new Bowling();
        String erreur1 ="24546/XXX716/XX12/XX716";
        String erreur2 = "24546";
        String good ="24546/XXX716/XX12";
        String bad="24586/XXX716/XX12";
        assertTrue("test précedent ok",interfaceBowling.correctLength(good));
        assertTrue("test précedent ko",interfaceBowling.correctLength(bad));
        assertTrue("test précedent ko",!interfaceBowling.correctLength(erreur1));
        assertTrue("test précedent ko",!interfaceBowling.correctLength(erreur2));

        assertTrue("une partie bien formée",interfaceBowling.correctGame(good));
        assertTrue("une partie mal formée",!interfaceBowling.correctGame(bad));
        assertTrue("une partie trop longue",!interfaceBowling.correctGame(erreur1));

        assertTrue("une partie trop courte",!interfaceBowling.correctGame(erreur2));

    }

    @Test
    public void testScore() throws Exception {

        InterfaceBowling interfaceBowling= new Bowling();

        String good ="24546/XXX716/XX12";
        String bad="24586/XXX716/XX12";
        String good2="24546/XXX716/71812";
        String good3="24546/XXX7/6/71812";

        assertEquals("cette partie a 172 points",172,interfaceBowling.score(good));
        assertEquals("une partie mal formée",0,interfaceBowling.score(bad));
        assertEquals("cette partie a 152 points",152,interfaceBowling.score(good2));
        assertEquals("cette partie a 152 points",162,interfaceBowling.score(good3));
    }
}