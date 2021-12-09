# OOP_2021_Ex2
Third Assignment in OOP course in Python @Ariel_University_2021

# Authors :
* Souffir Ilan Meir : 342615648
* Cohen Ben : 207029786  

# Topic of the Assignment number 3 :
This assignment 3 is dedicated to the design and implementation of data structures and algorithms on graphs (directed and weighted)

# Ex2 Contain 5 Interfaces :
* DirectedWeightedGraph
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
 
* DirectedWeightedGraphAlgorithms
  * init(DirectedWeightedGraph g) --> Inits the graph on which this set of algorithms operates on.
  * getGraph() --> Returns the underlying graph of which this class works.
  * copy() --> Computes a deep copy of this weighted graph.
  * isConnected() -->  Returns true if and only if (iff) there is a valid path from each node to each other node.
  * shortestPathDist(int src, int dest) --> Computes the length of the shortest path between src to dest.
  * shortestPath(int src, int dest) --> Computes the the shortest path between src to dest - as an ordered List of nodes: src--> n1-->n2-->...dest
  * center() --> Finds the NodeData which minimizes the max distance to all the other nodes.
  * tsp(List<NodeData> cities) --> Computes a list of consecutive nodes which go over all the nodes in cities.
  * save(String file) -->  Saves this weighted (directed) graph to the given file name - in JSON format
  * load(String file) --> This method loads a graph to this graph algorithm.
 
* EdgeData
  * getSrc() --> The id of the source node of this edge.
  * getDest() --> The id of the destination node of this edge
  * getWeight() --> Returns the weight of this edge (positive value).
  * getInfo() --> Returns the remark (meta data) associated with this edge.
  * setInfo(String s) --> Allows changing the remark (meta data) associated with this edge.
  * getTag() --> Temporal data (aka color: e,g, white, gray, black) which can be used be algorithms
  * setTag(int t) --> This method allows setting the "tag" value for temporal marking an edge - common practice for marking by algorithms.
 
* GeoLocation
  * x()
  * y()
  * z()
  * distance(GeoLocation g)
 
* NodeData
  * getKey() --> Returns the key (id) associated with this node.
  * getLocation() --> Returns the location of this node, if none return null.
  * setLocation(GeoLocation p) --> Allows changing this node's location.
  * getWeight() --> Returns the weight associated with this node.
  * setWeight(double w) --> Allows changing this node's weight.
  * getInfo() --> Returns the remark (meta data) associated with this node.
  * setInfo(String s) --> Allows changing the remark (meta data) associated with this node.
  * getTag() -->Temporal data (aka color: e,g, white, gray, black) which can be used be algorithms.
  * setTag(int t) --> Allows setting the "tag" value for temporal marking an node - common practice for marking by algorithms.
 
# Ex2 Contain 5 implementations :
 
# UML :
<p align="center">
  <img align="center" width=100% src = "https://user-images.githubusercontent.com/55143087/142608757-f5ebc791-2c3a-41b4-92ee-df11e5b28db8.png"/>
</p>
  

