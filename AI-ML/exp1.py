class Node:
    def __init__(self, name, heuristic):
        self.name = name
        self.heuristic = heuristic
        self.g = float('inf')
        self.parent = None
    
    def __lt__(self, other):
        return self.g + self.heuristic < other.g + other.heuristic

def a_star(graph, start, goal):
    open_list = []
    
    start_node = Node(start, graph[start]['heuristic'])
    start_node.g = 0
    open_list.append(start_node)
    
    while open_list:
        current_node = min(open_list)
        open_list.remove(current_node)
        
        if current_node.name == goal:
            path = []
            while current_node:
                path.insert(0, current_node.name)
                current_node = current_node.parent
            return path
        
        for neighbor, cost in graph[current_node.name]['neighbors'].items():
            neighbor_node = Node(neighbor, graph[neighbor]['heuristic'])
            tentative_g = current_node.g + cost
            
            if tentative_g < neighbor_node.g:
                neighbor_node.g = tentative_g
                neighbor_node.parent = current_node
                open_list.append(neighbor_node)

# Sample graph data
graph_data = {
    'A': {'heuristic': 10, 'neighbors': {'B': 2, 'C': 3}},
    'B': {'heuristic': 8, 'neighbors': {'A': 2, 'C': 1, 'D': 4}},
    'C': {'heuristic': 6, 'neighbors': {'A': 3, 'B': 1, 'E': 5}},
    'D': {'heuristic': 4, 'neighbors': {'B': 4, 'E': 1}},
    'E': {'heuristic': 0, 'neighbors': {'C': 5, 'D': 1}}
}

start_node = 'A'
goal_node = 'E'

path = a_star(graph_data, start_node, goal_node)
print(f"Shortest path found: {' -> '.join(path)}")
