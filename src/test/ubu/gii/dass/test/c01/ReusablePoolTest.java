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
 * @author Diego Garcia Munoz
 * @author Oscar Valverde Escobar
 *
 */
public class ReusablePoolTest {

	ReusablePool pool, pool2 = null;
	Reusable resource, resource2,resource3 = null;
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
		// test that adquiere all resources from the pool
		try {
			resource = pool.acquireReusable();
			assertNotNull(resource);
			resource2 = pool.acquireReusable();
			assertNotNull(resource2);
			assertNotEquals(resource, resource2);
		}
		catch(NotFreeInstanceException e){
			fail();
		}
		// test that try adquiere one extra resource from the empty pool
		try {
			resource3 = pool.acquireReusable();
			fail();
		}
		catch(NotFreeInstanceException e){
			assertNull(resource3);
		}
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#releaseReusable(ubu.gii.dass.c01.Reusable)}.
	 */
	@Test
	public void testReleaseReusable() {
		try {
			//empty the pool
			resource = pool.acquireReusable();
			resource2 = pool.acquireReusable();
			
			//test that if you release one reusable back into the pool,
			//when you obtain it again it is the same
			pool.releaseReusable(resource);
			resource3 = pool.acquireReusable();
			assertEquals(resource,resource3);
		}
		catch(Exception e){
			fail();
		}
		
		try {
			//test that you can't release the same reusable into the pool twice
			pool.releaseReusable(resource);
			pool.releaseReusable(resource3);
			fail();
		}
		catch(DuplicatedInstanceException e) {
			try {
				//test that you can release multiple different reusables
				pool.releaseReusable(resource2);
			}
			catch(DuplicatedInstanceException e2) {
				fail();
			}
			
		}
		
	}

}
