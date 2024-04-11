# Factorial Calculation with Tail Call Optimization (Using an Auxiliary Function):

    To achieve a similar effect to TCO in Java, you can use an auxiliary function
    and pass accumulated values along with the recursive call. While it's not true TCO,
    it avoids deep recursion by accumulating intermediate results in function parameters.

    In this refactored version, the factorial function takes two parameters: n and accumulator.
    The actual recursive logic is moved to the factorialTailRecursion function, which accumulates
    the factorial value as it makes its way down the recursive calls. This approach avoids deep
    recursion and reduces the chance of a stack overflow error for large input values.
