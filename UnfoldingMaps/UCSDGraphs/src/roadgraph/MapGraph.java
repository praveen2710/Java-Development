/**
 * @author UCSD MOOC development team and YOU
 * 
 * A class which reprsents a graph of geographic locations
 * Nodes in the graph are intersections between 
 *
 */
package roadgraph;


import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

import geography.GeographicPoint;
import util.GraphLoader;
import week2example.MazeNode;

/**
 * @author UCSD MOOC development team and YOU
 * 
 * A class which represents a graph of geographic locations
 * Nodes in the graph are intersections between 
 *
 */
public class MapGraph {
	//TODO: Add your member variables here in WEEK 2
	
	HashSet<IntersectionNode> nodeSet;
	
	private final static Logger LOGGER = Logger.getLogger(MapGraph.class.getName()); 
	
	/** 
	 * Create a new empty MapGraph 
	 */
	public MapGraph()
	{
		// TODO: Implement in this constructor in WEEK 2
		nodeSet = new HashSet<IntersectionNode>();
	}
	
	/**
	 * Get the number of vertices (road intersections) in the graph
	 * @return The number of vertices in the graph.
	 */
	public int getNumVertices()
	{
		//TODO: Implement this method in WEEK 2
		return nodeSet.size();
	}
	
	/**
	 * Return the intersections, which are the vertices in this graph.
	 * @return The vertices in this graph as GeographicPoints
	 */
	public Set<GeographicPoint> getVertices()
	{	
		Set<GeographicPoint> intersections = new HashSet<GeographicPoint>();
		//TODO: Implement this method in WEEK 2
		for(IntersectionNode node:nodeSet){
			GeographicPoint ge = new GeographicPoint(node.getXCordinate(), node.getYCordinate());
			intersections.add(ge);
		}
		return intersections;
	}
	
	/**
	 * Get the number of road segments in the graph
	 * @return The number of edges in the graph.
	 */
	public int getNumEdges()
	{
		int totalEdges= 0;
		//TODO: Implement this method in WEEK 2
		for(IntersectionNode node:nodeSet){
			totalEdges += node.getEdges().size();
		}
		return totalEdges;
	}

	
	
	/** Add a node corresponding to an intersection at a Geographic Point
	 * If the location is already in the graph or null, this method does 
	 * not change the graph.
	 * @param location  The location of the intersection
	 * @return true if a node was added, false if it was not (the node
	 * was already in the graph, or the parameter is null).
	 */
	public boolean addVertex(GeographicPoint location)
	{
		// TODO: Implement this method in WEEK 2
		try{
			IntersectionNode findNode = findIntersection(location);
			if(findNode!=null){
				return false;
			}else{
				IntersectionNode newNode = new IntersectionNode(location.x, location.y);
				nodeSet.add(newNode);
				return true;
			}
		}
		catch(NullPointerException ne){
			LOGGER.log(Level.SEVERE,"addVertex",ne);
			return false;
		}
	}
	
	/**
	 * Adds a directed edge to the graph from pt1 to pt2.  
	 * Precondition: Both GeographicPoints have already been added to the graph
	 * @param from The starting point of the edge
	 * @param to The ending point of the edge
	 * @param roadName The name of the road
	 * @param roadType The type of the road
	 * @param length The length of the road, in km
	 * @throws IllegalArgumentException If the points have not already been
	 *   added as nodes to the graph, if any of the arguments is null,
	 *   or if the length is less than 0.
	 */
	public void addEdge(GeographicPoint from, GeographicPoint to, String roadName,
			String roadType, double length) throws IllegalArgumentException {

		//TODO: Implement this method in WEEK 2
		IntersectionNode toNode = findIntersection(to);
		IntersectionNode fromNode = findIntersection(from);
		if(from==null||to==null||length<0||toNode==null||fromNode==null){
			throw new IllegalArgumentException();
		}
		
		toNode.addEdge(fromNode, roadName, roadType, length);
		
	}
	
	
	/**
	 * Method to determine if node is added to hash map and retrieve it
	 * @param loc  : the location to be verified
	 * @return {@link IntersectionNode} if found {@code null} otherwise
	 * @throws NullPointerException if location or {@link IntersectionNode} is null
	 */
	protected IntersectionNode findIntersection(GeographicPoint loc) {
		// TODO Auto-generated method stub
		try{
			for(IntersectionNode node:nodeSet){
				if(node.getXCordinate()==loc.x&&node.getYCordinate()==loc.y){
					return node;
				}
			}
			return null;
		}catch(NullPointerException ne){
			LOGGER.log(Level.SEVERE,"findIntersection",ne);
			throw ne;
		}
	}

	/** Find the path from start to goal using breadth first search
	 * 
	 * @param start The starting location
	 * @param goal The goal location
	 * @return The list of intersections that form the shortest (unweighted)
	 *   path from start to goal (including both start and goal).
	 */
	public List<GeographicPoint> bfs(GeographicPoint start, GeographicPoint goal) {
		// Dummy variable for calling the search algorithms
        Consumer<GeographicPoint> temp = (x) -> {};
        return bfs(start, goal, temp);
	}
	
	/** Find the path from start to goal using breadth first search
	 * 
	 * @param start The starting location
	 * @param goal The goal location
	 * @param nodeSearched A hook for visualization.  See assignment instructions for how to use it.
	 * @return The list of intersections that form the shortest (unweighted)
	 *   path from start to goal (including both start and goal).
	 */
	public List<GeographicPoint> bfs(GeographicPoint start, 
			 					     GeographicPoint goal, Consumer<GeographicPoint> nodeSearched)
	{
		// TODO: Implement this method in WEEK 2
		
		// Hook for visualization.  See writeup.
//		nodeSearched.accept(next.getLocation());
		
		Queue<IntersectionNode> queue = new LinkedList<IntersectionNode>();
		Set<IntersectionNode> visited = new HashSet<IntersectionNode>();
		HashMap<IntersectionNode, IntersectionNode> parentMap = new HashMap<IntersectionNode, IntersectionNode>();
	
		IntersectionNode startNode = findIntersection(start);
		IntersectionNode goalNode = findIntersection(goal);
		queue.add(startNode);
		
		while(!queue.isEmpty()){
			IntersectionNode currNode = queue.remove();
			if(currNode == goalNode){
				System.out.println("Found Goal Yipee");
				break;
			}
			for(Edge edge:currNode.getEdges()){
				if(!visited.contains(edge.getDestNode())){
					queue.add(edge.getDestNode());
					visited.add(edge.getDestNode());
					parentMap.put(edge.getDestNode(),currNode);
				}
			}
		}
		
		return retracePath(startNode,goalNode,parentMap);

	}
	

	private List<GeographicPoint> retracePath(IntersectionNode startNode, IntersectionNode goalNode, HashMap<IntersectionNode, IntersectionNode> parentMap) {
		// TODO Auto-generated method stub
		List<GeographicPoint> path = new LinkedList<GeographicPoint>();
		IntersectionNode currNode = goalNode;
		path.add(new GeographicPoint(currNode.getXCordinate(), currNode.getYCordinate()));
		while(currNode!=startNode){
			IntersectionNode parentNode = parentMap.get(currNode);
			path.add(new GeographicPoint(parentNode.getXCordinate(), parentNode.getYCordinate()));
			currNode = parentNode;
		}
		return path;
	}

	/** Find the path from start to goal using Dijkstra's algorithm
	 * 
	 * @param start The starting location
	 * @param goal The goal location
	 * @return The list of intersections that form the shortest path from 
	 *   start to goal (including both start and goal).
	 */
	public List<GeographicPoint> dijkstra(GeographicPoint start, GeographicPoint goal) {
		// Dummy variable for calling the search algorithms
		// You do not need to change this method.
        Consumer<GeographicPoint> temp = (x) -> {};
        return dijkstra(start, goal, temp);
	}
	
	/** Find the path from start to goal using Dijkstra's algorithm
	 * 
	 * @param start The starting location
	 * @param goal The goal location
	 * @param nodeSearched A hook for visualization.  See assignment instructions for how to use it.
	 * @return The list of intersections that form the shortest path from 
	 *   start to goal (including both start and goal).
	 */
	public List<GeographicPoint> dijkstra(GeographicPoint start, 
										  GeographicPoint goal, Consumer<GeographicPoint> nodeSearched)
	{
		// TODO: Implement this method in WEEK 3

		// Hook for visualization.  See writeup.
		//nodeSearched.accept(next.getLocation());
		
		return null;
	}

	/** Find the path from start to goal using A-Star search
	 * 
	 * @param start The starting location
	 * @param goal The goal location
	 * @return The list of intersections that form the shortest path from 
	 *   start to goal (including both start and goal).
	 */
	public List<GeographicPoint> aStarSearch(GeographicPoint start, GeographicPoint goal) {
		// Dummy variable for calling the search algorithms
        Consumer<GeographicPoint> temp = (x) -> {};
        return aStarSearch(start, goal, temp);
	}
	
	/** Find the path from start to goal using A-Star search
	 * 
	 * @param start The starting location
	 * @param goal The goal location
	 * @param nodeSearched A hook for visualization.  See assignment instructions for how to use it.
	 * @return The list of intersections that form the shortest path from 
	 *   start to goal (including both start and goal).
	 */
	public List<GeographicPoint> aStarSearch(GeographicPoint start, 
											 GeographicPoint goal, Consumer<GeographicPoint> nodeSearched)
	{
		// TODO: Implement this method in WEEK 3
		
		// Hook for visualization.  See writeup.
		//nodeSearched.accept(next.getLocation());
		
		return null;
	}
	
	@Override
	public String toString(){
		
	
		for(IntersectionNode node:nodeSet){
			System.out.println("//**");
			System.out.println("["+node.getXCordinate()+","+node.getYCordinate()+"]");
			System.out.println("//*****//");
			for(Edge edge:node.getEdges()){
				System.out.println("["+edge.getDestNode().getXCordinate()+","+edge.getDestNode().getYCordinate()+"]");
			}
		}
		
		return null;
	}

	
	
	public static void main(String[] args)
	{
		System.out.print("Making a new map...");
		MapGraph theMap = new MapGraph();
		System.out.print("DONE. \nLoading the map...");
		GraphLoader.loadRoadMap("data/testdata/simpletest.map", theMap);
		System.out.println(theMap.getNumEdges());
		System.out.println(theMap.getNumVertices());
		
		GeographicPoint start = new GeographicPoint(1,1);
		GeographicPoint goal = new GeographicPoint(8,-1);
		
		
		List<GeographicPoint> thePath =theMap.bfs(start, goal);
		
		for(GeographicPoint node:thePath){
			System.out.println("["+node.x+","+node.y+"]");
		}
		
//		theMap.toString();
		
		System.out.println("DONE.");
		
		// You can use this method for testing.  
		
		/* Use this code in Week 3 End of Week Quiz
		MapGraph theMap = new MapGraph();
		System.out.print("DONE. \nLoading the map...");
		GraphLoader.loadRoadMap("data/maps/utc.map", theMap);
		System.out.println("DONE.");

		GeographicPoint start = new GeographicPoint(32.8648772, -117.2254046);
		GeographicPoint end = new GeographicPoint(32.8660691, -117.217393);
		
		
		List<GeographicPoint> route = theMap.dijkstra(start,end);
		List<GeographicPoint> route2 = theMap.aStarSearch(start,end);

		*/
		
	}
	
}
