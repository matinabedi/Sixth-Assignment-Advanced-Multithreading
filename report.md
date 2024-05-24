## Calculating π
There are many algorithm exist to compute π that every of them has some advantage and some disadvantage.I used two of them that explained below:

1. ### Middle Ages
Further progress was not made for nearly a millennium, until the 14th century, when Indian mathematician and astronomer Madhava of Sangamagrama, founder of the Kerala school of astronomy and mathematics, found the Maclaurin series for arctangent, and then two infinite series for π.[22][23][24] One of them is now known as the Madhava–Leibniz series, based on
𝜋
=
4
arctan
⁡
(
1
)
:
{\displaystyle \pi =4\arctan(1):}

![img.png](img.png)

This formula is fast and simple, but not very accurate.


2. ### Bailey–Borwein–Plouffe formula  (BBP formula)
The Bailey–Borwein–Plouffe formula (BBP formula) is a formula for π. It was discovered in 1995 by Simon Plouffe and is named after the authors of the article in which it was published, David H. Bailey, Peter Borwein, and Plouffe. Before that, it had been published by Plouffe on his own site. The formula is:

![image](BBP%20Formula.svg)

The BBP formula gives rise to a spigot algorithm for computing the nth base-16 (hexadecimal) digit of π (and therefore also the 4nth binary digit of π) without computing the preceding digits. This does not compute the nth decimal digit of π (i.e., in base 10).
But another formula discovered by Plouffe in 2022 allows extracting the nth digit of π in decimal. BBP and BBP-inspired algorithms have been used in projects such as PiHex for calculating many digits of π using distributed computing. The existence of this formula came as a surprise. It had been widely believed that computing the nth digit of π is just as hard as computing the first n digits.
#### BBP compared to other methods of computing π
This algorithm computes π without requiring custom data types having thousands or even millions of digits. The method calculates the nth digit without calculating the first n − 1 digits and can use small, efficient data types. Fabrice Bellard found a variant of BBP, Bellard's formula, which is faster.
Though the BBP formula can directly calculate the value of any given digit of π with less computational effort than formulas that must calculate all intervening digits, BBP remains linearithmic `(𝑂(𝑛 log 𝑛))`
, whereby successively larger values of n require increasingly more time to calculate; that is, the "further out" a digit is, the longer it takes BBP to calculate it, just like the standard π-computing algorithms.
2. ### Chudnovsky algorithm
The Chudnovsky algorithm is a fast method for calculating the digits of π, based on Ramanujan's π formulae. Published by the Chudnovsky brothers in 1988, it was used to calculate π to a billion decimal places.

It was used in the world record calculations of 2.7 trillion digits of π in December 2009, 10 trillion digits in October 2011, 22.4 trillion digits in November 2016, 31.4 trillion digits in September 2018–January 2019, 50 trillion digits on January 29, 2020, 62.8 trillion digits on August 14, 2021, 100 trillion digits on March 21, 2022, and 105 trillion digits on March 14, 2024.
The algorithm is based on the negated Heegner number 𝑑 =−163 , the j-function
𝑗((1 +𝑖 * sqrt(163) )/ 2)= − 640320 ^ 3 , and on the following rapidly convergent generalized hypergeometric series:

![image](Chudnovsky%20Algorithm.svg)

This identity is similar to some of Ramanujan's formulas involving π, and is an example of a Ramanujan–Sato series.

The time complexity of the algorithm is `𝑂(𝑛(log 𝑛)^3)`.

### Why do I use BBP formula?

It is preferable that each processor manipulates small-precision values, as opposed to very high precision ones. For example, if you want one billion decimals, and you use some of the expressions used here, like the Chudnovsky algorithm, each of your processor will need to manipulate a billion long number. That's simply not the appropriate method for a GPU.

So, all in all, the BBP formula will allow you to compute the digits of pi separately (the algorithm is very cool), and with "low precision" processors! Read the "BBP digit-extraction algorithm for π"

Advantages of the BBP algorithm for computing π This algorithm computes π without requiring custom data types having thousands or even millions of digits. The method calculates the nth digit without calculating the first n − 1 digits, and can use small, efficient data types. The algorithm is the fastest way to compute the nth digit (or a few digits in a neighborhood of the nth), but π-computing algorithms using large data types remain faster when the goal is to compute all the digits from 1 to n.


## Semaphore
A semaphore is a synchronization mechanism used in computer science to manage access to a shared resource by multiple processes or threads in a concurrent system.
It is a simple yet powerful tool for controlling concurrency, preventing race conditions, and ensuring that critical sections of code are executed in a controlled manner.

### Types of Semaphores
1. Binary Semaphore (Mutex):

- This semaphore can have only two values: 0 and 1. It is used to implement mutual exclusion, ensuring that only one thread can access a critical section at a time.
- When a thread acquires a binary semaphore, its value changes from 1 to 0. When the thread releases the semaphore, the value changes back to 1.
2. Counting Semaphore:

- This semaphore can have a value ranging from 0 to some maximum value. It is used to manage access to a resource that has a limited number of instances.
- The semaphore’s value represents the number of available resources. When a thread acquires the semaphore, the value is decremented. When the thread releases the semaphore, the value is incremented.
### Operations
The two primary operations on a semaphore are:

1. Wait (P or Down operation):

- Decrements the value of the semaphore. If the semaphore’s value is greater than zero, the operation proceeds and the thread continues. If the value is zero, the thread is blocked until the semaphore’s value becomes greater than zero.
2. Signal (V or Up operation):

- Increments the value of the semaphore. If there are any threads waiting for the semaphore, one of them is unblocked.
### Use Cases of Semaphores
1. Mutual Exclusion (Mutex):

- Protects critical sections of code from being executed by more than one thread at a time. This is essential in preventing race conditions in scenarios like updating a shared counter or modifying shared data structures.
2. Managing Resource Access:

- Controls access to a pool of resources, such as database connections, memory buffers, or I/O channels. A counting semaphore initialized to the number of available resources ensures that no more than that many threads can use the resource simultaneously.
3. Synchronization:

- Coordinates the order of execution among threads. For example, ensuring that a producer thread signals the completion of a task before a consumer thread processes it.
4. Preventing Deadlock:

- Helps in preventing deadlocks by controlling the order in which threads acquire locks or access resources.

## References

https://en.wikipedia.org/wiki/Chudnovsky_algorithm
https://en.wikipedia.org/wiki/Bailey%E2%80%93Borwein%E2%80%93Plouffe_formula
https://stackoverflow.com/questions/10890613/fast-algorithm-to-calculate-pi-in-parallel
https://chat.openai.com/