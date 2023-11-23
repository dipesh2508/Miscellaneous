# Defining the graph using adjacency list representation
graph = {
    'A': ['B', 'C'],
    'B': ['D', 'E', 'A'],
    'C': ['F', 'A'],
    'D': ['B'],
    'E': ['B'],
    'F': ['C']
}

# Depth-First Search (DFS) function
def dfs(node, visited):
    if node not in visited:
        print(node, end=' ')
        visited.add(node)
        for neighbor in graph[node]:
            dfs(neighbor, visited)

# Main function
def main():
    start_node = 'A'
    visited_nodes = set()
    print("DFS traversal starting from node", start_node)
    dfs(start_node, visited_nodes)

if __name__ == "__main__":
    main()
