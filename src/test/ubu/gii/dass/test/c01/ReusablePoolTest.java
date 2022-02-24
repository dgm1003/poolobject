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
		//Generación de una instancia de pool
		pool = ReusablePool.getInstance();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		//reseteo de valores
		pool = null;
		pool2 = null;
		resource = null;
		resource2 = null;
		resource3 = null;
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#getInstance()}.
	 */
	@Test
	public void testGetInstance() {
		// testeo de la instancia obtenida en la inicialización del test
		assertNotNull(pool);
		
		// testeo de que el método getInstance() siempre devuelve 
		pool2 = ReusablePool.getInstance();
		assertEquals(pool, pool2);
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#acquireReusable()}.
	 */
	@Test
	public void testAcquireReusable() {
		// testeo de adquirir todos los recursos del pool
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
		// testeo de intentar adquirir un nuevo recurso extra del pool vacio
		try {
			resource3 = pool.acquireReusable();
			fail();
		}
		catch(NotFreeInstanceException e){
			assertNull(resource3);
		}
		
		try {
			pool.releaseReusable(resource);
			pool.releaseReusable(resource2);
		}	
		catch(DuplicatedInstanceException e) {
			fail();
		}		
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#releaseReusable(ubu.gii.dass.c01.Reusable)}.
	 */
	@Test
	public void testReleaseReusable() {
		try {
			//vaciamos el pool
			resource = pool.acquireReusable();
			resource2 = pool.acquireReusable();		
			//testeo de que al devolver un recurso al pool,
			//cuando le obtienes de nuevo es igual
			pool.releaseReusable(resource);
			resource3 = pool.acquireReusable();
			assertEquals(resource,resource3);
			//testeo de que no puedes devolver dos veces el mismo recurso al pool
			pool.releaseReusable(resource);
			pool.releaseReusable(resource3);
			fail();
		}
		catch(DuplicatedInstanceException e) {
			try {
				//testeo de que se pueden devolver recursos diferentes
				pool.releaseReusable(resource2);
			}
			catch(DuplicatedInstanceException e2) {
				fail();
			}			
		}
		catch(NotFreeInstanceException e) {
			fail();
		}
	}


	/**
	 * Test method for {@link ubu.gii.dass.c01.Reusable#util()}.
	 */
	@Test
	public void testUseReusableUtil() {
		try {
			//testeo del metodo util del objeto reusable para comprobar que dos recursos distintos, devulven dos cadenas distintas
			resource = pool.acquireReusable();
			assertEquals(resource.util(), resource.hashCode() + "  :Uso del objeto Reutilizable");
			resource2 = pool.acquireReusable();
			assertEquals(resource2.util(), resource2.hashCode() + "  :Uso del objeto Reutilizable");
			assertNotEquals(resource.util(), resource2.util());
			pool.releaseReusable(resource);
			pool.releaseReusable(resource2);
		}catch(NotFreeInstanceException e) {
			fail();
		}
		catch(DuplicatedInstanceException e) {
			fail();
		}	
	}
	
	/**
	 * Test method for {@link ubu.gii.dass.c01.Client#main()}.
	 */
	@Test
	public void testMain() {
		try {
			//Prueba de instanciacion de la clase cliente
			Client client = new Client();
			
			//Obtenemos los dos recursos del pool para poder devolverles despues de la ejecución del main y evitar problemas con el resto de test
			//porque este método no devolvía los recursos.
			resource = pool.acquireReusable();
			resource2 = pool.acquireReusable();
			pool.releaseReusable(resource);
			pool.releaseReusable(resource2);
			
			//Ejecución del metodo main
			Client.main(null);
			
			//devolvemos los recursos al pool para que se pueda ejecutar el siguiente test
			pool.releaseReusable(resource);
			pool.releaseReusable(resource2);
		}catch(Exception e) {
			fail();
		}
	}
}
