'''
Created on Oct 12, 2016

@author: mwitt_000
'''
import network
import link
import threading
from time import sleep
import sys
import random
##configuration parameters
router_queue_size = 0 #0 means unlimited
simulation_time = 15 #give the network sufficient time to transfer all packets before quitting

if __name__ == '__main__':
    object_L = [] #keeps track of objects, so we can kill their threads

    #create network hosts
    host1 = network.Host(1)
    object_L.append(host1)
    host2 = network.Host(2)
    object_L.append(host2)
    host3 = network.Host(3)
    object_L.append(host3)

    #create routers and routing tables for connected clients (subnets)

    router_a_rt_tbl_D = {'1': {0: random.randint(1, 9)}, '2': {1: random.randint(1, 9)}, 'B': {2: 5}, 'C': {3: 3}}
    router_a = network.Router(name='A',
                              num_intf = 4,
                              rt_tbl_D = router_a_rt_tbl_D,
                              max_queue_size=router_queue_size)
    object_L.append(router_a)
    router_b_rt_tbl_D = {'A': {0: 5}, 'D': {1: 2}}
    router_b = network.Router(name='B',
                              num_intf = 2,
                              rt_tbl_D = router_b_rt_tbl_D,
                              max_queue_size=router_queue_size)
    object_L.append(router_b)
    router_c_rt_tbl_D = {'A': {0: 3}, 'D': {1: 4}}
    router_c = network.Router(name='C',
                              num_intf = 2,
                              rt_tbl_D = router_c_rt_tbl_D,
                              max_queue_size=router_queue_size)
    object_L.append(router_c)
    router_d_rt_tbl_D = {'B': {1: 2}, 'C': {0: 4}, '3': {2: random.randint(1, 9)}}
    router_d = network.Router(name='D',
                              num_intf = 3,
                              rt_tbl_D = router_d_rt_tbl_D,
                              max_queue_size=router_queue_size)
    object_L.append(router_d)


    #create a Link Layer to keep track of links between network nodes
    link_layer = link.LinkLayer()
    object_L.append(link_layer)

    #add all the links
    link_layer.add_link(link.Link(host1, 0, router_a, 0)) #host 1 -> A
    link_layer.add_link(link.Link(host2, 0, router_a, 1)) #host 2 -> B
    link_layer.add_link(link.Link(router_a, 2, router_b, 0)) #A -> B
    link_layer.add_link(link.Link(router_a, 3, router_c, 0)) #A -> C
    link_layer.add_link(link.Link(router_c, 1, router_d, 0)) #C -> D
    link_layer.add_link(link.Link(router_b, 1, router_d, 1)) #B -> D
    link_layer.add_link(link.Link(router_d, 2, host3, 0)) #D -> host 3

    #start all the objects
    thread_L = []
    for obj in object_L:
        thread_L.append(threading.Thread(name=obj.__str__(), target=obj.run))

    for t in thread_L:
        t.start()

    #send out routing information from router A to router B interface 0
    router_a.send_routes(3)
    sleep(5)
    #create some send events
    for i in range(1):
        host1.udt_send(3, 'Put your hands to the constellations %d' % i) #send a fire bar

    #give the network sufficient time to transfer all packets before quitting
    sleep(simulation_time)

    #print the final routing tables
    for obj in object_L:
        if str(type(obj)) == "<class 'network.Router'>":
            obj.print_routes()

    #join all threads
    for o in object_L:
        o.stop = True
    for t in thread_L:
        t.join()

    print("All simulation threads joined")



# writes to host periodically
