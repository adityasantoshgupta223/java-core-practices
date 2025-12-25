Multithreading in Java (Core Concepts)

This folder demonstrates core Java multithreading concepts using small, focused examples.
Each class is designed to explain one concept clearly, following good design practices.

# 1️) Thread vs Runnable (ThreadVsRunnableDemo.java)

a) Why Runnable is preferred over extending Thread ?
<b>Ans.</b> <br>
Java supports single inheritance, so extending Thread blocks extending other classes.
Runnable separates task (what to do) from thread (how to run it).
Same Runnable instance can be reused by multiple threads.
More flexible and aligned with real-world frameworks (Executors, Thread pools).

b) When extending Thread can still make sense ?
<b>Ans.</b> <br>
For simple demos or learning
When thread behavior itself must be customized (rare in production)

# 2️) join() Method (JoinDemo.java)
a) What join() does ?
<b>Ans.</b> <br>
Makes the current thread wait until another thread finishes execution.
Commonly used to make the main thread wait for worker threads.

b) Why join() is important ?
<b>Ans.</b> <br>
Without join(), main thread may finish before child threads complete
Ensures correct execution order
Useful when final result depends on thread completion

c) What this demo shows ?
--> Two threads running concurrently
join() ensures "Ended" prints only after both threads finish

# 3️) Synchronization & Race Condition (SynchronizedCounterDemo.java)

 a) What is a race condition ?
<b>Ans.</b> <br>
When multiple threads access and modify shared data simultaneously
Leads to incorrect or inconsistent results

 b) How synchronized solves it ?
<b>Ans.</b> <br>
Ensures only one thread can execute the method at a time
Protects shared mutable state
Guarantees thread safety

c) What this demo shows ?
<b>Ans.</b> <br>
Two threads incrementing the same counter
synchronized ensures correct final count
Demonstrates safe concurrent access
