# Concurrency and Multi-threading Architecture
---

## Quiz
#### Prepare answers to following questions

##### Base part
* What are differences between `wait` and `sleep` methods in Java?
* What is an atomic operation? What are atomic operations in Java?
* What is a `volatile` keyword in Java? How do you use it? How is it different from the synchronized method in Java?
* What is a race condition? How will you find and solve race condition?
* Why do we call `start()` method which in turns calls `run()` method, why not we directly call `run()` method?
* What is an immutable object? How does it help in writing a concurrent application?

##### Necessary part
* Which granularity size uses `java.util.Arrays` in its parallelSort set of methods to decide to parallelize or not?
* You have thread T1, T2, and T3. How will you ensure that thread T2 is run after T1 and thread T3 after T2?
* What is the advantage of the `Lock` interface over a synchronized block in Java? You need to implement a high-performance cache, which allows multiple readers, but how will you implement the single writer to keep the integrity?
* What is the difference between `CyclicBarrier` and `CountdownLatch` in Java?
* What is "Work Stealing" algorithm?

---
## 1.1 Object, thread and monitor.

First of all, we should check class object and what we can see.
1. Native `notify()` method. Wakes up a single thread that is waiting on this object's monitor. If any threads are waiting on this object, one of them is chosen to be awakened. The choice is arbitrary and occurs at the discretion of the implementation. A thread waits on an object's monitor by calling one of the wait methods.
    ```
    public final native void notify();
    ```    
2. Native `notifyAll()` method. Wakes up all threads that are waiting on this object's monitor. A thread waits on an object's monitor by calling one of the wait methods.
    ```
    public final native void notifyAll();
    ```    
3. Three versions of `wait()` method. Causes the current thread to wait until it is awakened, typically by being notified or interrupted.  
    ```
        public final void wait() throws InterruptedException {
            wait(0L);
        }

        public final native void wait(long timeoutMillis) throws InterruptedException;

        public final void wait(long timeoutMillis, int nanos) throws InterruptedException {
            ...
        }
    ```

> More information is available here: [Class Object Java Oracle Docs](https://docs.oracle.com/javase/10/docs/api/java/lang/Object.html).

Firstly, we can use all of those method in a special block of code or can mention an additional keyword for some methods.
```
...
    synchronized(LOCK) {
        LOCK.wait(); // LOCK is not held
    }
...
```
Where `LOCK` is class Object (for example: Object LOCK = new Object()). 
The second one condition for the keyword `synchronized` is a way to use with case:
```
...
    public int counter;

    public synchronized int getCounter() {
            return counter;
        }
...
```

Where can we see a `sleep()` method? Of course, the Object class doesn't have this one. Just open `Thread` class and check this method: 
```
public static native void sleep(long millis) throws InterruptedException
```
#### Description:   
"Causes the currently executing thread to sleep (temporarily cease execution) for the specified number of milliseconds, subject to the precision and accuracy of system timers and schedulers. The thread does not lose ownership of any monitors..."
> More information is available here: [Class Thread Java Oracle Docs](https://docs.oracle.com/javase/10/docs/api/java/lang/Thread.html). 
> [Sleep method](https://docs.oracle.com/javase/10/docs/api/java/lang/Thread.html#sleep(long))

#### Extra:
> Q: What the differed between `wait()` and `sleep()`?  
> A: `sleep()` is a method that is used to suspend the process for a few seconds or for the time we need. But in the case of the `wait()` method, the thread goes into a waiting state and will not return automatically until we call the `notify()` or `notifyAll()` function.

## 1.1 Practice part.
1. Create a new class and use wait(), notify(), notifyAll() methods with synchronized block.
2. Create a new class and use Thread.sleep() in method, in synchronized block.

---
## 2.1 One more time about `Threads` with `start()` and `run()`.
// TODO
## 2.2 Practice part.
// TODO

## 3.1 Immutable object.
// TODO
## 3.2 Practice part.
// TODO

## 4.1 `volatile` and `Atomic` variables.
// TODO
## 4.2 Practice part.
// TODO

## 5.1 Locks, `DeadLock`, Semaphore.
// TODO
## 5.2 Practice task.
// TODO

## 6.1 RecursiveTask, RecursiveAction
// TODO
## 6.2 Practice task.
// TODO

## 7.1 CompletableFuture
// TODO
## 7.2 Practice task.
// TODO

## 8.1 Blurring for Clarity ? (Join pool, ForkPool and etc)
// TODO 
## 8.2 Practice part.
// TODO