# OOP_2021_Ex2
Third Assignment in OOP course in Python @Ariel_University_2021

# Authors :
* Souffir Ilan Meir : 342615648
* Cohen Ben : 207029786  

# Topic of the Assignment number 3 :
This assignment 3 is dedicated to the design and implementation of data structures and algorithms on graphs (directed and weighted)

# Libraries usded in this assignment :
 * gson-2.8.6.jar

# Analysis of the performance of our algorithms on size graphs :
 * 1 000 :
 * 10 000 :
 * 100 000 :
 * 1 000 000 :

# Explanation of how to download, run and use the graphical interface :

 
# Ex2 Contains 5 Interfaces :
1) DirectedWeightedGraph
2) DirectedWeightedGraphAlgorithms
3) EdgeData
4) GeoLocation
5) NodeData
  
# Ex2 Contains 5 implementations :
 1) DirectedWeigtet
 2) Algo
 3) EdgeDatas
 4) MyLoc
 5) ND
 
# 1) DirectedWeigtet
  This class is a directed graph with implementation of DirectedWeightedGraph.
  The JUNIT test of this class is DirectedWeigtetTest.
 
 Objects of this class :
 * HashMap<Integer, NodeData> node
 * int w
 * int MC
 * HashMap<NodeData, HashMap<NodeData, EdgeData>> edge
 * HashMap<NodeData, HashMap<NodeData, EdgeData>> edgein
 * int edgeSize
 
 We are going to explains each methods of MyDirectedWeightedGraph :
  * Constructor and copy constructor.
  * getNode(int key)  --> Returns the node_data by the node_id(key).
  * getEdge(int src, int dest)  --> Returns the data of the edge (src,dest), null if none. In O(1).
  * addNode(NodeData n)  --> Adds a new node to the graph with the given node_data in O(1).
  * connect(int src, int dest, double w)  --> Connects an edge with weight w between node src to node dest in O(1).
  * Iterator<NodeData> nodeIter()  --> Returns an Iterator for the collection representing all the nodes in the graph.
  * Iterator<EdgeData> edgeIter()  --> Returns an Iterator for all the edges in this graph.
  * Iterator<EdgeData> edgeIter(int node_id)  --> Returns an Iterator for edges getting out of the given node (all the edges starting (source) at the given node).
  * removeNode(int key)  --> Deletes the node (with the given ID) from the graph and removes all edges which starts or ends at this node in O(k).
  * removeEdge(int src, int dest)  --> Deletes the edge from the graph in O(1).
  * nodeSize()  --> Returns the number of vertices (nodes) in the graph in O(1).
  * edgeSize()  --> Returns the number of edges (assume directional graph) in O(1).
  * getMC()  --> Returns the Mode Count - for testing changes in the graph.
 
# 2) Algo
 This class is an implementation of DirectedWeightedGraphAlgorithms.
 The JUNIT test of this class is AlgoTest
 
 Objects of this class :
 * DirectedWeightedGraph e

 We are going to explains each methods of MyDirectedWeightedGraph :
 * Constructor and copy constructor.
 * init(DirectedWeightedGraph g) --> Inits the graph on which this set of algorithms operates on.
 * getGraph() --> Returns the underlying graph of which this class works.
 * copy() --> Computes a deep copy of this weighted graph.
 * isConnected() -->  Returns true if and only if (iff) there is a valid path from each node to each other node. 
   * We are using the class DFS (algorithm).
 * shortestPathDist(int src, int dest) --> Computes the length of the shortest path between src to dest.
   * We are using the class MyShortedPath with the function minDist().
 * shortestPath(int src, int dest) --> Computes the the shortest path between src to dest - as an ordered List of nodes: src--> n1-->n2-->...dest
   * We are using the class MyShortedPath with the function path().
 * center() --> Finds the NodeData which minimizes the max distance to all the other nodes.
 * tsp(List<NodeData> cities) --> Computes a list of consecutive nodes which go over all the nodes in cities.
   * We are using the class Mytsp with the function checktsp(). 
 * save(String file) -->  Saves this weighted (directed) graph to the given file name - in JSON format
 * load(String file) --> This method loads a graph to this graph algorithm.
 
 # 3) EdgeDatas
   This class is an edge in directed graph with implementation of EdgeData.
 
 Objects of this class :
 * int src;
 * int dest;
 * double weight;
 * String info;
 * int tag;
 
 We are going to explains each methods of MyDirectedWeightedGraph :
 * Constructor and copy constructor.
 * getSrc() --> The id of the source node of this edge.
 * getDest() --> The id of the destination node of this edge
 * getWeight() --> Returns the weight of this edge (positive value).
 * getInfo() --> Returns the remark (meta data) associated with this edge.
 * setInfo(String s) --> Allows changing the remark (meta data) associated with this edge.
 * getTag() --> Temporal data (aka color: e,g, white, gray, black) which can be used be algorithms
 * setTag(int t) --> This method allows setting the "tag" value for temporal marking an edge - common practice for marking by algorithms.
 
 # 4) MyLoc
   This class is a location in the space (x,y,z) with implementation of GeoLocation.
 
 Objects of this class :
 * double x;
 * double y;
 * double z;
 
 We are going to explains each methods of MyDirectedWeightedGraph :
 * Constructor and copy constructor.
 * x()
 * y()
 * z()
 * distance(GeoLocation g)
 
 # 5) ND
   This class is an implementation of NodeData.
 
 Objects of this class :
 * double id;
 * double weight;
 * GeoLocation loc;
 * String info;
 * int tag;
 
 We are going to explains each methods of MyDirectedWeightedGraph :
 * Constructor and copy constructor.
 * getKey() --> Returns the key (id) associated with this node.
 * getLocation() --> Returns the location of this node, if none return null.
 * setLocation(GeoLocation p) --> Allows changing this node's location.
 * getWeight() --> Returns the weight associated with this node.
 * setWeight(double w) --> Allows changing this node's weight.
 * getInfo() --> Returns the remark (meta data) associated with this node.
 * setInfo(String s) --> Allows changing the remark (meta data) associated with this node.
 * getTag() -->Temporal data (aka color: e,g, white, gray, black) which can be used be algorithms.
 * setTag(int t) --> Allows setting the "tag" value for temporal marking an node - common practice for marking by algorithms.
  

# Ex2 Contains also these classes :
  * DFS -->
  * Ex2 -->
  * MenuExample -->
  * MyShortedPath -->
  * Mytsp -->
  * StdDraw -->
  * ijframe -->
  
# There is a folder "Tests" that we are running with JUnit :
  * MyDirectedWeightedGraphAlgorithmsTest
  * MyDirectedWeightedGraphTest
  * MyEdgeDataTest
  * MyGeoLocationTest
  * MyNodeDataTest
  
 
 
 

  

