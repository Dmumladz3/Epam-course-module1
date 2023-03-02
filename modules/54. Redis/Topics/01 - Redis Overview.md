# Redis Overview

## Read following resources

1. [Redis overview](https://redis.io/docs/about/)
2. [Redis threading model](https://developpaper.com/redis-thread-model/)
3. [Latency numbers every programmer should know](https://gist.github.com/hellerbarde/2843375)
4. [Atomic Operation](https://en.wikipedia.org/wiki/Atomicity_(database_systems))
5. [4 Rate Limit Algorithms Every Developer Should Know](https://betterprogramming.pub/4-rate-limit-algorithms-every-developer-should-know-7472cb482f48)
6. [How to Create a Rate Limiter using Bucket4J and Redis](https://www.freecodecamp.org/news/rate-limiting-with-bucket4j-and-redis/)

## Optional
1. Compare Redis approach with different transaction isolation levels in RDMS.

## Summary

1. Redis is the Key-Value in-memory data store
2. Redis provides sub-milliseconds latency when performing read / write operations.
3. Redis serves all data from RAM, but supports persistence for **backup / restore purposes**.
4. Keys in Redis are of string data type.
5. Values in Redis can have different types, each type has it own list of supported operations
6. Redis is "fast", because:
  * Serve data from RAM
  * Use non-blocking IO for networking
  * Has single thread for reading and manipulating data, which allow to avoid penalties due to thread synchronization
7. Each Redis command is atomic.
8. Redis commands from multiple clients are executed sequentially, one by one.
