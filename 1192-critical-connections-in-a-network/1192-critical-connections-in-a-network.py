class Solution:
    def criticalConnections(self, n: int, connections: List[List[int]]) -> List[List[int]]:
        graph = [[] for _ in range(n)]
        for a, b in connections:
            graph[a].append(b)
            graph[b].append(a)

        disc = [-1] * n
        low = [0] * n
        timer = [0]  # mutable counter (list trick, since Python closures can't rebind ints)
        result = []

        def dfs(u, parent):
            disc[u] = low[u] = timer[0]
            timer[0] += 1

            for v in graph[u]:
                if v == parent:
                    continue
                if disc[v] == -1:
                    dfs(v, u)
                    low[u] = min(low[u], low[v])

                    if low[v] > disc[u]:
                        result.append([u, v])
                else:
                    low[u] = min(low[u], disc[v])

        for i in range(n):
            if disc[i] == -1:
                dfs(i, -1)

        return result