/**
 * 
 */
package ubu.gii.dass.test.c01;

import static org.junit.Assert.*;
import ubu.gii.dass.c01.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Diego García Muñoz
 * @author Óscar Valverde Escobar
 *
 */
public class ReusablePoolTest {

	ReusablePool pool, pool2;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		//a pool will be used on every test
		pool = ReusablePool.getInstance();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		//reset values
		pool = null;
		pool2 = null;
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#getInstance()}.
	 */
	@Test
	public void testGetInstance() {
		// test that the GetInstance method returns an object
		assertNotNull(pool);
		
		// test that the method always returns the same object
		pool2 = ReusablePool.getInstance();
		assertEquals(pool, pool2);
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#acquireReusable()}.
	 */
	@Test
	public void testAcquireReusable() {
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#releaseReusable(ubu.gii.dass.c01.Reusable)}.
	 */
	@Test
	public void testReleaseReusable() {
		
	}

}
