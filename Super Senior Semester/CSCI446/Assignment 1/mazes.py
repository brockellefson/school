
def read_maze(filename):
    #read in file
    maze = []
    file = open(filename, "r")
    columns = file.readlines()
    for i, column in enumerate(columns):
        column = column.strip()
        row_nodes = []
        for j, row in enumerate(column):
            for element in row:
                #make each element a node
                newnode = Node(element, i, j)
                row_nodes.append(newnode)
        maze.append(row_nodes)
    #give each node knowledge on its neighbors
    for i, row in enumerate(maze):
        for j, element in enumerate(row):
            if j+1 <= len(row)-1:
                element.neighbors.append(maze[i][j+1])
            if j-1 >= 0:
                element.neighbors.append(maze[i][j-1])
            if i-1 >= 0:
                element.neighbors.append(maze[i-1][j])
            if i+1 <= len(maze)-1:
                element.neighbors.append(maze[i+1][j])
    return maze

def print_maze(maze):
    for row in maze:
        for element in row:
            print(element.value, end='')
        print('')


class Node:
    def __init__(self, val, x, y):
        self.visited = False
        self.value = val
        self.x = x
        self.y = y
        self.neighbors = []
        self.previous = None
        #if this node is a wall, treat as visited
        if val is '%':
            self.visited = True

    def is_visited(self):
        self.visited = True