'''
Created on Oct 12, 2016

@author: mwitt_000
'''
import queue
import threading


## wrapper class for a queue of packets
class Interface:
    ## @param maxsize - the maximum size of the queue storing packets
    def __init__(self, maxsize=0):
        self.queue = queue.Queue(maxsize);
        self.mtu = None

    ##get packet from the queue interface
    def get(self):
        try:
            return self.queue.get(False)
        except queue.Empty:
            return None

    ##put the packet into the interface queue
    # @param pkt - Packet to be inserted into the queue
    # @param block - if True, block until room in queue, if False may throw queue.Full exception
    def put(self, pkt, block=False):
        self.queue.put(pkt, block)

## Implements a network layer packet (different from the RDT packet
# from programming assignment 2).
# NOTE: This class will need to be extended to for the packet to include
# the fields necessary for the completion of this assignment.
class NetworkPacket:
    ## packet encoding lengths


    #PACKET HEADER
    #dst_addr:frag_flag:packetid:msg

    src_addr_S_length = 3
    dst_addr_S_length = 2
    frag_flag_S_length = 1
    ident_S_length = 5
    ##@param dst_addr: address of the destination host
    # @param data_S: packet payload
    # @param frag_flag: if the packet is part of a segmentation
    # @param offset: where the offset is
    def __init__(self, src_addr, dst_addr, frag_flag, ident, data_S):
        self.src_addr = src_addr
        self.dst_addr = dst_addr
        self.data_S = data_S
        self.frag_flag = frag_flag
        self.ident = ident
    ## called when printing the object
    def __str__(self):
        return self.to_byte_S()

    ## convert packet to a byte string for transmission over links
    def to_byte_S(self):
        byte_S = str(self.src_addr).zfill(self.src_addr_S_length)
        byte_S += str(self.dst_addr).zfill(self.dst_addr_S_length)
        byte_S += str(self.frag_flag).zfill(self.frag_flag_S_length)
        byte_S += str(self.ident).zfill(self.ident_S_length)
        byte_S += self.data_S
        return byte_S

    ## extract a packet object from a byte string
    # @param byte_S: byte string representation of the packet
    @classmethod
    def from_byte_S(self, byte_S):
        src_addr = int(byte_S[0 : NetworkPacket.src_addr_S_length])
        dst_addr = int(byte_S[NetworkPacket.src_addr_S_length :NetworkPacket.src_addr_S_length + NetworkPacket.dst_addr_S_length])
        frag_flag = int(byte_S[NetworkPacket.src_addr_S_length + NetworkPacket.dst_addr_S_length :NetworkPacket.src_addr_S_length + NetworkPacket.dst_addr_S_length + NetworkPacket.frag_flag_S_length])
        ident = int(byte_S[NetworkPacket.src_addr_S_length + NetworkPacket.dst_addr_S_length + NetworkPacket.frag_flag_S_length : NetworkPacket.src_addr_S_length +NetworkPacket.dst_addr_S_length + NetworkPacket.frag_flag_S_length + NetworkPacket.ident_S_length ])
        data_S = byte_S[NetworkPacket.src_addr_S_length + NetworkPacket.dst_addr_S_length + NetworkPacket.frag_flag_S_length + NetworkPacket.ident_S_length:]
        return self(src_addr, dst_addr, frag_flag, ident, data_S)


    def segment(self, mtu):
        segments = [self.data_S[i:i+mtu] for i in range(0,len(self.data_S), mtu)] #break packet into segments of mtu length
        return segments

## Implements a network host for receiving and transmitting data
class Host:
    segment_list = []
    ##@param addr: address of this node represented as an integer
    def __init__(self, addr):
        self.addr = addr
        self.in_intf_L = [Interface()]
        self.out_intf_L = [Interface()]
        self.stop = False #for thread termination

    ## called when printing the object
    def __str__(self):
        return 'Host_%s' % (self.addr)

    ## create a packet and enqueue for transmission
    # @param dst_addr: destination address for the packet
    # @param data_S: data being transmitted to the network layer
    def multiPackets(self, data_S, mtu):
        packets = [data_S[i:i+mtu] for i in range(0,len(data_S), mtu)]
        return packets


    def udt_send(self, dst_addr, data_S):
        if (len(data_S) > self.out_intf_L[0].mtu): #string bigger than mtu, send multiple packets
            string_mtu =  self.out_intf_L[0].mtu - 11 #7 is the bit addr length
            packets = self.multiPackets(data_S, string_mtu)
            p_id = 10000 #packet id
            for packet in packets:
                p = NetworkPacket(self.addr, dst_addr, 0, p_id, packet)
                self.out_intf_L[0].put(p.to_byte_S())
                print('\n%s: sending packet "%s" out interface with mtu=%d\n' % (self, p, self.out_intf_L[0].mtu))
                p_id+= 10000
        else:
            p = NetworkPacket(self.addr, dst_addr, 0, p_id, data_S)
            self.out_intf_L[0].put(p.to_byte_S()) #send packets always enqueued successfully
            print('\n%s: sending packet "%s" out interface with mtu=%d\n' % (self, p, self.out_intf_L[0].mtu))

    def reconstruct(self, segments, pkt_id):
        og_pkt = ''
        for segment in segments:
            if segment[6] == pkt_id: #for all segments that share the same id
                og_pkt += segment[11:] #add all segments into return string
        return og_pkt

    ## receive packet from the network layer
    def udt_receive(self):
        pkt_S = self.in_intf_L[0].get()
        if pkt_S is not None:
            print('\n%s: received packet "%s"\n' % (self, pkt_S))
            if pkt_S[5] == '1': #if a packet is actually a segment
                self.segment_list.append(pkt_S) #add to list of all segmented packets
                if pkt_S[7] == pkt_S[9] and pkt_S[8] == pkt_S[10]: #if the total segments equals the latest packet part of the id
                    og_data = self.reconstruct(self.segment_list, pkt_S[6]) #reconstruct original string
                    p = NetworkPacket(pkt_S[:3],pkt_S[3:5], 0, pkt_S[6] + '0000', og_data) #reconstruct original packet
                    print('\n' + 'Host_' + str(self.addr) + ' CONSTRUCTED PACKET: ' + p.to_byte_S() + '\n')



    ## thread target for the host to keep receiving data
    def run(self):
        print (threading.currentThread().getName() + ': Starting ')
        while True:
            #receive data arriving to the in interface
            self.udt_receive()
            #terminate
            if(self.stop):
                print (threading.currentThread().getName() + ': Ending ')
                return



## Implements a multi-interface router described in class
class Router:

    ##@param name: friendly router name for debugging
    # @param intf_count: the number of input and output interfaces
    # @param max_queue_size: max queue length (passed to Interface)
    def __init__(self, name, intf_count, max_queue_size, rtable):
        self.stop = False #for thread termination
        self.name = name
        self.rtable = rtable
        #create a list of interfaces
        self.in_intf_L = [Interface(max_queue_size) for _ in range(intf_count)]
        self.out_intf_L = [Interface(max_queue_size) for _ in range(intf_count)]

    ## called when printing the object
    def __str__(self):
        return 'Router_%s' % (self.name)

    def forward(self, pkt_S, interface):
        i = interface
        p = NetworkPacket.from_byte_S(pkt_S) #parse a packet out
        if (len(pkt_S) > self.out_intf_L[i].mtu):
            string_mtu =  self.out_intf_L[i].mtu - 11 #11 is the bit addr length
            segments = p.segment(string_mtu) #segment packet into segments
            seg_total = len(segments) * 100 #total amount of segments
            seg_count = 1
            for seg in segments:
                seg_p = NetworkPacket(p.src_addr, p.dst_addr, 1, p.ident + seg_total + seg_count, seg) #segment packet
                self.out_intf_L[i].put(seg_p.to_byte_S(), True) #send seg_p
                print('\n%s: forwarding segmented packet "%s" from interface %d to %d with mtu %d\n' \
                    % (self, seg_p, i, i, self.out_intf_L[i].mtu))
                seg_count += 1

        else:
            self.out_intf_L[i].put(p.to_byte_S(), True)
            print('\n%s: forwarding packet "%s" from interface %d to %d with mtu %d\n' \
                % (self, p, i, i, self.out_intf_L[i].mtu))






    def route(self, pkt_S):
        if (len(self.in_intf_L) is 1):
            self.forward(pkt_S, 0)
        else:
            interface = 0
            for route in self.rtable:
                if self.name == 'A':
                    if pkt_S[2] == '1'and route == 'B':
                        self.forward(pkt_S, 0)
                        break
                    elif pkt_S[2] == '2'and route == 'C':
                        self.forward(pkt_S, 1)
                        break
                elif route == pkt_S[4]:
                    self.forward(pkt_S, interface)
                    break
                interface += 1

    ## look through the content of incoming interfaces and forward to
    # appropriate outgoing interfaces
    def recieve(self):
        for i in range(len(self.in_intf_L)):
            pkt_S = None
            try:
                #get packet from interface i
                pkt_S = self.in_intf_L[i].get()
                #if packet exists make a forwarding decision
                if pkt_S is not None:
                    self.route(pkt_S)
            except queue.Full:
                print('\n%s: packet "%s" lost on interface %d\n' % (self, p, i))
                pass

    ## thread target for the host to keep forwarding data
    def run(self):
        print (threading.currentThread().getName() + ': Starting ')
        while True:
            self.recieve()
            if self.stop:
                print (threading.currentThread().getName() + ': Ending ')
                return
