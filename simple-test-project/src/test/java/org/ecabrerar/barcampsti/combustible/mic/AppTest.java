package org.ecabrerar.barcampsti.combustible.mic;

import java.io.InputStream;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase
{
	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     * @throws Exception 
     */
    public void testApp() throws Exception
    {
    	InputStream nyData =
                getClass().getClassLoader().getResourceAsStream("combustible.xml");
            Combustible comb = new CombustibleParser().parse( nyData );
            
            assertEquals( "247.40", comb.getGasolinaPremium() );
            assertEquals( "232.80", comb.getGasolinaRegular() );
            assertEquals( "219.70", comb.getGasoilPremium() );
            assertEquals( "213.00", comb.getGasoilRegular() );
            assertEquals( "194.20", comb.getKerosene() );
            assertEquals( "108.50", comb.getGlp() );
            assertEquals( "30.50", comb.getGnv() );
    }
}
