from collections import deque

import mazes


class Search:
    def __init__(self, maze):
        self.px = 0
        self.py = 0
        self.fx = 0
        self.fy = 0
        self.maze = maze
        #figure out pacmans start and end places
        for i, row in enumerate(self.maze):
            for j, element in enumerate(row):
                if element.value is 'P':
                    self.px = i
                    self.py = j
                    print("pacman starts at {},{}".format(self.px,self.py))
                elif element.value is '*':
                    self.fx = i
                    self.fy = j
                    print("finish is at {},{}".format(self.fx, self.fy))

    def depth_first_search(self,curr_node,finish,visited_nodes, moves):
        #print("x= {} y= {}".format(curr_node.x,curr_node.y))

        #if current node is end, save solution and cost
        if curr_node.value is finish:
            self.print_results("Depth First Search: ", curr_node, moves)
            return True

        #else, continue searching, adding '.' and counting along the way
        moves += 1
        visited_nodes.append(curr_node)
        for neighbor in curr_node.neighbors:
            if neighbor not in visited_nodes and neighbor.value is not '%':
                neighbor.previous = curr_node
                if self.depth_first_search(neighbor, '*', visited_nodes, moves):
                    return True

        return False

    def breadth_first_search(self,curr_node,finish,visited_nodes, moves):
        pass

    def greedy_search(self):
        pass

    def a_search(self):
        pass

    def print_results(self, search, curr_node, cost):
        print("{} \nCoord: {},{} \nCost: {}".format(search, curr_node.x, curr_node.y, cost))
        print("Solution:")
        node = curr_node
        while node.previous is not None:
            if node.value is not 'P' and node.value is not '*':
                node.value = '.'

            node = node.previous
        mazes.print_maze(self.maze)


if __name__=='__main__':
    #create mazes
    large_maze = mazes.read_maze("large maze.txt")
    medium_maze = mazes.read_maze("medium maze.txt")
    open_maze = mazes.read_maze("open maze.txt")

    visited_nodes = []
    moves = 0

    open_search = Search(open_maze)
    open_search.depth_first_search(open_search.maze[open_search.px][open_search.py],'*',visited_nodes, moves)
    #open_search.breadth_first_search(open_search.maze[open_search.px][open_search.py],'*',visited_nodes, moves)

    medium_search = Search(medium_maze)
    medium_search.depth_first_search(medium_search.maze[medium_search.px][medium_search.py],'*',visited_nodes, moves)

    large_search = Search(large_maze)
    large_search.depth_first_search(large_search.maze[large_search.px][large_search.py],'*',visited_nodes, moves)
