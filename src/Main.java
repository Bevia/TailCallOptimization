public class Main {

    public static void main(String[] args) {
        int number = 5;
        int result = factorial(number);
        System.out.println("Factorial of " + number + " = " + result);

        int tcoResult = tcoFactorial(number);
        System.out.println("TCO Factorial of " + number + " = " + result);
    }
    /*
    Tail Call Optimization (TCO) is a compiler optimization technique that helps reduce the stack space used by recursive
    function calls. In a traditional recursive function, each recursive call adds a new frame to the call stack,
    potentially leading to stack overflow errors for deeply nested calls. However, with TCO, the compiler optimizes
    tail-recursive calls by reusing the same stack frame for each recursive call, eliminating the need
    for additional stack space. This optimization improves the efficiency and performance of recursive functions
    by avoiding unnecessary stack operations.
     */

    //In this example, the factorial function is recursive, but Java does not
    // optimize tail calls, so it can potentially lead to a stack overflow error
    // for large values of n.

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    /*
    Factorial Calculation with Tail Call Optimization (Using an Auxiliary Function):

    To achieve a similar effect to TCO in Java, you can use an auxiliary function
    and pass accumulated values along with the recursive call. While it's not true TCO,
    it avoids deep recursion by accumulating intermediate results in function parameters.

    In this refactored version, the factorial function takes two parameters: n and accumulator.
    The actual recursive logic is moved to the factorialTailRecursion function, which accumulates
    the factorial value as it makes its way down the recursive calls. This approach avoids deep
    recursion and reduces the chance of a stack overflow error for large input values.
     */

    public static int tcoFactorial(int n) {
        return factorialTailRecursion(n, 1);
    }

    private static int factorialTailRecursion(int n, int accumulator) {
        if (n == 0) {
            return accumulator;
        } else {
            return factorialTailRecursion(n - 1, n * accumulator);
        }
    }

    /*
    A **stack overflow** occurs when a program's call stack (a region of a computer's memory) runs out of space due
    to excessive function call nesting. Let me break down this concept further:

1. **Function Calls and the Call Stack:**
   - When a function is called in a program, the computer's memory allocates a **stack frame** for that function.
   This stack frame contains information about the function's local variables, parameters, and the address to return
   to after the function completes.
   - Each time a new function is called, a new stack frame is created and added to the top of the call stack.

2. **Recursion and Deep Function Nesting:**
   - Recursion is a programming technique where a function calls itself.
   - If a recursive function is not properly controlled or if it's called with a large number of iterations,
   it can lead to a deep nesting of function calls.
   - If the depth of function calls becomes too large, the call stack can run out of space.

3. **Limited Stack Size:**
   - Most programming languages and operating systems define a maximum stack size for each running program.
   - If a program exceeds this stack size due to excessive function call nesting, it will trigger a stack overflow error.

For example, consider the following recursive function in Java that calculates the factorial of a number:

```java
public int factorial(int n) {
    if (n == 0) {
        return 1;
    } else {
        return n * factorial(n - 1);
    }
}
```

If you call this function with a large value, say `factorial(10000)`, it will attempt to create a deep recursion
with 10,000 nested function calls, and it will likely cause a stack overflow because the call stack cannot handle such depth.

To prevent stack overflow errors, it's essential to optimize algorithms, especially recursive ones, and to consider
iterative or tail-recursive approaches. Additionally, understanding the limitations of the programming language
and environment you are working with can help you design your algorithms effectively.

 */
}
