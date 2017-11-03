'''
Created on Oct 12, 2016

@author: mwitt_000
'''
import network_3
import link_3
import threading
from time import sleep

##configuration parameters
router_queue_size = 0 #0 means unlimited
simulation_time = 50 #give the network sufficient time to transfer all packets before quitting




if __name__ == '__main__':

    routing_table_A = ['B' , 'C']
    routing_table_B = ['D']
    routing_table_C = ['D']
    routing_table_D = ['3','4']

    object_L = [] #keeps track of objects, so we can kill their threads

    #create network nodes
    host_1 = network_3.Host(1) #Host 1
    object_L.append(host_1)

    host_2 = network_3.Host(2) #Host 2
    object_L.append(host_2)

    host_3 = network_3.Host(3) #Host 3
    object_L.append(host_3)

    host_4 = network_3.Host(4) #Host 4
    object_L.append(host_4)

    router_a = network_3.Router(name='A', intf_count=2, max_queue_size=router_queue_size, rtable=routing_table_A) #Router A
    object_L.append(router_a)

    router_b = network_3.Router(name='B', intf_count=1, max_queue_size=router_queue_size, rtable=routing_table_B) #Router B
    object_L.append(router_b)

    router_c = network_3.Router(name='C', intf_count=1, max_queue_size=router_queue_size, rtable=routing_table_C) #Router C
    object_L.append(router_c)

    router_d = network_3.Router(name='D', intf_count=2, max_queue_size=router_queue_size, rtable=routing_table_D) #Router D
    object_L.append(router_d)


    #create a Link Layer to keep track of links between network nodes
    link_layer = link_3.LinkLayer()
    object_L.append(link_layer)

    #add all the links
    link_layer.add_link(link_3.Link(host_1, 0, router_a, 0, 50)) #Host 1 -> Router A
    link_layer.add_link(link_3.Link(host_2, 0, router_a, 1, 50)) #Host 2 -> Router A

    link_layer.add_link(link_3.Link(router_a, 0, router_b, 0, 30)) #Router A -> Router B
    link_layer.add_link(link_3.Link(router_a, 1, router_c, 0, 30)) #Router A -> Router C

    link_layer.add_link(link_3.Link(router_b, 0, router_d, 0, 30)) #Router B -> Router D

    link_layer.add_link(link_3.Link(router_c, 0, router_d, 1, 30)) #Router C -> Router D

    link_layer.add_link(link_3.Link(router_d, 0, host_3, 0, 30)) #Router D -> Host 3
    link_layer.add_link(link_3.Link(router_d, 1, host_4, 0, 30)) #Router D -> Host 4

    #start all the objects
    thread_L = []
    thread_L.append(threading.Thread(name=host_1.__str__(), target=host_1.run))
    thread_L.append(threading.Thread(name=host_2.__str__(), target=host_2.run))
    thread_L.append(threading.Thread(name=host_3.__str__(), target=host_3.run))
    thread_L.append(threading.Thread(name=host_4.__str__(), target=host_4.run))

    thread_L.append(threading.Thread(name=router_a.__str__(), target=router_a.run))
    thread_L.append(threading.Thread(name=router_b.__str__(), target=router_b.run))
    thread_L.append(threading.Thread(name=router_c.__str__(), target=router_c.run))
    thread_L.append(threading.Thread(name=router_d.__str__(), target=router_d.run))

    thread_L.append(threading.Thread(name="Network", target=link_layer.run))

    for t in thread_L:
        t.start()


    #create some send events
    kanye_data = 'The plan was to drink until the pain over but whats worse the pain or the hangover' #yeezy yeezy keep it wavy
    host_2.udt_send(3, kanye_data) #send a fire bar


    #give the network sufficient time to transfer all packets before quitting
    sleep(simulation_time)

    #join all threads
    for o in object_L:
        o.stop = True
    for t in thread_L:
        t.join()

    print("All simulation threads joined")



# writes to host periodically
