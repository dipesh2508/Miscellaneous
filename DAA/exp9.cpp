// Djistra's Algorithm
#include <bits/stdc++.h>
using namespace std;

class Graph
{
    int V;                     // Number of vertices
    list<pair<int, int>> *adj; // Pointer to an array containing adjacency lists

public:
    Graph(int V);
    void addEdge(int v, int w, int weight);
    void shortestPath(int s);
};

Graph::Graph(int V)
{
    this->V = V;
    adj = new list<pair<int, int>>[V];
}

void Graph::addEdge(int v, int w, int weight)
{
    // Add w to v's list
    adj[v].push_back(make_pair(w, weight));
}

void Graph::shortestPath(int s)
{
    // Create a priority queue to store vertices that are being preprocessed.
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;

    // Create a vector for distances and initialize all distances as infinite (INF)
    vector<int> dist(V, INT_MAX);

    // Insert source itself in priority queue and initialize its distance as 0.
    pq.push(make_pair(0, s));
    dist[s] = 0;

    // Looping till priority queue becomes empty (or all distances are not finalized)
    while (!pq.empty())
    {
        // The first vertex in pair is the minimum distance vertex, extract it from priority queue.
        // vertex label is stored in second of pair (it has to be done this way to keep the vertices
        // sorted distance (distance must be first item in pair)
        int u = pq.top().second;
        pq.pop();

        // Get all adjacent of u.
        list<pair<int, int>>::iterator i;
        for (i = adj[u].begin(); i != adj[u].end(); ++i)
        {
            // Get vertex label and weight of current adjacent of u.
            int v = (*i).first;
            int weight = (*i).second;

            // If there is shorted path to v through u.
            if (dist[v] > dist[u] + weight)
            {
                // Updating distance of v
                dist[v] = dist[u] + weight;
                pq.push(make_pair(dist[v], v));
            }
        }
    }

    // Print shortest distances stored in dist[]
    cout << "Vertex   Distance from Source" << endl;
    for (int i = 0; i < V; ++i)
    {
        cout << i << "\t\t" << dist[i] << endl;
    }
}

int main(void)
{
    // Create a graph given in the above diagram
    Graph g(9);
    g.addEdge(0, 1, 4);
    g.addEdge(0, 7, 8);
    g.addEdge(1, 2, 8);
    g.addEdge(1, 7, 11);
    g.addEdge(2, 3, 7);
    g.addEdge(2, 8, 2);
    g.addEdge(2, 5, 4);
    g.addEdge(3, 4, 9);
    g.addEdge(3, 5, 14);
    g.addEdge(4, 5, 10);
    g.addEdge(5, 6, 2);
    g.addEdge(6, 7, 1);
    g.addEdge(6, 8, 6);
    g.addEdge(7, 8, 7);

    g.shortestPath(0);

    return 0;
}