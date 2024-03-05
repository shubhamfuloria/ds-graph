# Search Algorithms

## Breadth First Search

Breadth First Search is an fundamental search algorithms used to explore nodes and edges of a graph. It is often used as a building block in other algorithms.

`Time Complexity: O(V + E)`

It's mainly useful for finding shortest path .

The algorithm for BFS goes like this

```
bfs(graph):
  queue = # a queue data structure

  # add an arbitrary node to the queue
  # this will be the point from where we initiate search
  queue.offer(0) 

  # a boolean array equal with length equal to total no of nodes in graph
  # initialized with false
  visited = [false, false, ....]

  while(queue is not empty):

    # poll element from queue
    node = queue.poll()

    # if node is already visited, then continue
    if(visited[node] == true):
      continue

    # mark the node as visited
    visited[node] = true

    print(node)

    # add all neighbours of node to the queue
    for(nbr : graph.node):
      if visited[nbr] == false:
        queue.offer(nbr)
```

## Graph theory on grids
1. Convert grid to a adjacency list / matrix
2. #### Direction Vectors
    If we are allowed to move top, bottom, left and right

3. To be continued


## Breadth First Search Techniques

1. While traversing graph / tree, we can get levels / steps by calculating current size of queue and running the loop that many times. See 02_shortest-path


