package roadgraph;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import geography.GeographicPoint;

public class MapGraphTest {
	
	 @Rule
	 public final ExpectedException exception = ExpectedException.none();
	
	private MapGraph mp;
	
	@Before
	public void setUp(){
		mp= new MapGraph();
	}
	
	@Test
	public void testAddVertex() {
		GeographicPoint gp1 = new GeographicPoint(1,1);
		mp.addVertex(gp1);
		assertEquals("1 Vertex should be present", 1, mp.getNumVertices(), 0);
		
		GeographicPoint gp2 = new GeographicPoint(1,1);
		assertEquals("should return false",false,mp.addVertex(gp2));
		assertEquals("1 Vertex should be present still", 1, mp.getNumVertices(), 0);
		
		GeographicPoint gp3 = new GeographicPoint(1,-1);
		mp.addVertex(gp3);
		assertEquals("2 Vertex should be present ", 2, mp.getNumVertices(), 0);
		
		GeographicPoint gp4 = new GeographicPoint(-1,1);
		mp.addVertex(gp4);
		assertEquals("3 Vertex should be present ", 3, mp.getNumVertices(), 0);
		
		GeographicPoint gp5 = new GeographicPoint(2,1);
		mp.addVertex(gp5);
		assertEquals("4 Vertex should be present ", 4, mp.getNumVertices(), 0);
		
//		exception.expect(NullPointerException.class);
		assertEquals("should return false", false,mp.addVertex(null));
		
	}
	
	@Test
	public void testFindVertes(){
		GeographicPoint gp2 = new GeographicPoint(1,1);
		mp.findIntersection(gp2);
	}

}
