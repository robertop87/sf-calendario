package calendariows;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sofunA
 */
public class CalendarioWSTest {
    
    public CalendarioWSTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class CalendarioWS.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        CalendarioWS.main(args);
        // TODO review the generated test code and remove the default call to fail.
        
        //El test no esta haciendo mas que probar una clase vacia pero
        //la funcion "fail("");" es la que hacia fallar el test forzadamente.
    }
    
}
