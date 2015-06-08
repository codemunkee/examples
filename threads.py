#!/usr/bin/python
from multiprocessing.dummy import Pool

# number of hello worlds to print
count = 30

# number of threads to run with
threads = 40

def hello_world(count):
    """ print hello world"""
    print('hello world: %s' % count)

# Create thread pool
pool = Pool(threads)

output = pool.map(hello_world, range(count))
pool.close()
pool.join()
