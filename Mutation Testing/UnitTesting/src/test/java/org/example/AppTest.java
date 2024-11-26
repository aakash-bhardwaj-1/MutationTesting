package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
     MathUtils mathUtils = new MathUtils();
     BitwiseUtils utils = new BitwiseUtils();
     LogicalBitwiseUtils logicalUtils = new LogicalBitwiseUtils();

    @Test
    public void testIsOdd() {
        assertFalse(utils.isOdd(-1)); // Negative boundary
        assertTrue(utils.isOdd(1));  // Positive odd
        assertFalse(utils.isOdd(2)); // Positive even
        assertFalse(utils.isOdd(0)); // Zero case
    }

    @Test
    public void testIsEven() {
        assertFalse(utils.isEven(-1)); // Negative boundary
        assertFalse(utils.isEven(1));  // Positive odd
        assertTrue(utils.isEven(2));   // Positive even
        assertTrue(utils.isEven(0));   // Zero case
    }

    @Test
    public void testSwapUsingXOR() {
        assertArrayEquals(new int[]{2, 1}, utils.swapUsingXOR(1, 2)); // Normal case
        assertArrayEquals(new int[]{3, 3}, utils.swapUsingXOR(3, 3)); // Identical numbers
    }

    @Test
    public void testFindSingleNonRepeating() {
        assertEquals(-1, utils.findSingleNonRepeating(null));       // Null input
        assertEquals(-1, utils.findSingleNonRepeating(new int[]{})); // Empty array
        assertEquals(3, utils.findSingleNonRepeating(new int[]{1, 1, 2, 2, 3})); // Normal case
    }

    @Test
    public void testIsPowerOfTwo() {
        assertFalse(utils.isPowerOfTwo(0));  // Boundary case
        assertTrue(utils.isPowerOfTwo(1));   // 2^0 = 1
        assertTrue(utils.isPowerOfTwo(8));   // 2^3 = 8
        assertFalse(utils.isPowerOfTwo(10)); // Non-power of two
        assertFalse(utils.isPowerOfTwo(-2)); // Negative number
    }

    @Test
    public void testCountSetBits() {
        assertEquals(-1, utils.countSetBits(-1)); // Negative input
        assertEquals(0, utils.countSetBits(0));   // Zero case
        assertEquals(1, utils.countSetBits(1));   // Single bit
        assertEquals(3, utils.countSetBits(7));   // Normal case
    }

    @Test
    public void testHaveOppositeSigns() {
        assertFalse(utils.haveOppositeSigns(0, 0));   // Zero inputs
        assertFalse(utils.haveOppositeSigns(1, 0));   // One input is zero
        assertTrue(utils.haveOppositeSigns(1, -1));   // Opposite signs
        assertFalse(utils.haveOppositeSigns(2, 3));   // Same signs
    }

    @Test
    public void testGetNthBit() {
        assertEquals(-1, utils.getNthBit(5, -1)); // Negative bit position
        assertEquals(1, utils.getNthBit(5, 0));  // 5 in binary is 101
        assertEquals(0, utils.getNthBit(5, 1));  // Second bit is 0
    }

    @Test
    public void testSetNthBit() {
        assertEquals(5, utils.setNthBit(5, -1));  // Negative bit position
        assertEquals(7, utils.setNthBit(5, 1));  // 5 becomes 7 (binary 101 -> 111)
    }

    @Test
    public void testClearNthBit() {
        assertEquals(5, utils.clearNthBit(5, -1));  // Negative bit position
        assertEquals(5, utils.clearNthBit(5, 3));  // Out-of-range bit, no change
        assertEquals(5, utils.clearNthBit(7, 1));  // 7 becomes 5 (binary 111 -> 101)
    }

    @Test
    public void testToggleNthBit() {
        assertEquals(5, utils.toggleNthBit(5, -1));  // Negative bit position
        assertEquals(7, utils.toggleNthBit(5, 1));  // 5 becomes 7 (binary 101 -> 111)
    }

    @Test
    public void testIsBinaryPalindrome() {
        assertFalse(utils.isBinaryPalindrome(-1)); // Negative input
        assertTrue(utils.isBinaryPalindrome(0));  // Zero case
        assertTrue(utils.isBinaryPalindrome(9));  // 9 in binary is 1001
        assertFalse(utils.isBinaryPalindrome(10)); // 10 in binary is 1010
    }

    @Test
    public void testReverseBits() {
        assertEquals(-1, utils.reverseBits(-1)); // Negative input
        assertEquals(0, utils.reverseBits(0));  // Zero case
        assertEquals(1, utils.reverseBits(8));  // 8 in binary (1000) becomes 1
    }

    @Test
    public void testNextPowerOfTwo() {
        assertEquals(1, utils.nextPowerOfTwo(0));  // Zero case
        assertEquals(1, utils.nextPowerOfTwo(1));  // Already a power of two
        assertEquals(8, utils.nextPowerOfTwo(6));  // Next power is 8
        assertEquals(16, utils.nextPowerOfTwo(9)); // Next power is 16
    }

    @Test
    public void testRightmostSetBitPosition() {
        assertEquals(-1, utils.rightmostSetBitPosition(0)); // Zero case
        assertEquals(1, utils.rightmostSetBitPosition(1)); // 1 is the first bit
        assertEquals(3, utils.rightmostSetBitPosition(4)); // 4 in binary is 100
    }

    @Test
    public void testXorFrom1ToN() {
        assertEquals(-1, utils.xorFrom1ToN(-1)); // Negative input
        assertEquals(0, utils.xorFrom1ToN(0));  // Zero case
        assertEquals(1, utils.xorFrom1ToN(1));  // XOR(1)
        assertEquals(4, utils.xorFrom1ToN(4));  // XOR(1 to 4)
    }

    @Test
    public void testHasAlternatingBits() {
        assertFalse(utils.hasAlternatingBits(0));  // Zero case
        assertTrue(utils.hasAlternatingBits(5));  // 5 in binary is 101
        assertFalse(utils.hasAlternatingBits(7)); // 7 in binary is 111
    }

    @Test
    public void testIsEvenParity() {
        assertFalse(utils.isEvenParity(-1)); // Negative input
        assertTrue(utils.isEvenParity(0));  // Zero case (even parity)
        assertFalse(utils.isEvenParity(1)); // 1 in binary has odd parity
    }

    @Test
    public void testClearBitsFromMSB() {
        assertEquals(5, utils.clearBitsFromMSB(5, -1)); // Negative bit position
        assertEquals(1, utils.clearBitsFromMSB(5, 1));  // Clear all bits from MSB to 1st bit
    }

    @Test
    public void testClearBitsFromLSB() {
        assertEquals(5, utils.clearBitsFromLSB(5, -1)); // Negative bit position
        assertEquals(4, utils.clearBitsFromLSB(5, 0));  // Clear the 0th bit
    }




    //////////////////////////////////////////////




    // Test for isPrime
    @Test
    void testIsPrime() {
        assertFalse(mathUtils.isPrime(-1), "Negative numbers are not prime");
        assertFalse(mathUtils.isPrime(0), "0 is not prime");
        assertFalse(mathUtils.isPrime(1), "1 is not prime");
        assertTrue(mathUtils.isPrime(2), "2 is the smallest prime number");
        assertTrue(mathUtils.isPrime(3), "3 is a prime number");
        assertFalse(mathUtils.isPrime(4), "4 is not a prime number");
        assertTrue(mathUtils.isPrime(17), "17 is a prime number");
    }

    // Test for isFibonacci
    @Test
    void testIsFibonacci() {
        assertFalse(mathUtils.isFibonacci(-1), "Negative numbers are not Fibonacci");
        assertTrue(mathUtils.isFibonacci(0), "0 is a Fibonacci number");
        assertTrue(mathUtils.isFibonacci(1), "1 is a Fibonacci number");
        assertTrue(mathUtils.isFibonacci(2), "2 is a Fibonacci number");
        assertFalse(mathUtils.isFibonacci(4), "4 is not a Fibonacci number");
        assertTrue(mathUtils.isFibonacci(21), "21 is a Fibonacci number");
    }

    // Test for factorial
    @Test
    void testFactorial() {
        assertEquals(-1, mathUtils.factorial(-5), "Factorial of negative numbers is undefined");
        assertEquals(1, mathUtils.factorial(0), "Factorial of 0 is 1");
        assertEquals(1, mathUtils.factorial(1), "Factorial of 1 is 1");
        assertEquals(120, mathUtils.factorial(5), "Factorial of 5 is 120");
    }

    // Test for isArmstrong
    @Test
    void testIsArmstrong() {
        assertFalse(mathUtils.isArmstrong(-1), "Negative numbers are not Armstrong numbers");
        assertTrue(mathUtils.isArmstrong(0), "0 is an Armstrong number");
        assertTrue(mathUtils.isArmstrong(153), "153 is an Armstrong number");
        assertFalse(mathUtils.isArmstrong(10), "10 is not an Armstrong number");
    }

    // Test for isPerfectNumber
    @Test
    void testIsPerfectNumber() {
        assertFalse(mathUtils.isPerfectNumber(-6), "Negative numbers cannot be perfect");
        assertFalse(mathUtils.isPerfectNumber(0), "0 is not a perfect number");
        assertTrue(mathUtils.isPerfectNumber(6), "6 is a perfect number");
        assertFalse(mathUtils.isPerfectNumber(10), "10 is not a perfect number");
    }

    // Test for isHarshad
    @Test
    void testIsHarshad() {
        assertFalse(mathUtils.isHarshad(-18), "Negative numbers are not Harshad numbers");
        //assertTrue(mathUtils.isHarshad(0), "0 is a Harshad number");
        assertTrue(mathUtils.isHarshad(18), "18 is a Harshad number");
        assertFalse(mathUtils.isHarshad(19), "19 is not a Harshad number");
    }

    // Test for isTriangularNumber
    @Test
    void testIsTriangularNumber() {
        assertFalse(mathUtils.isTriangularNumber(-10), "Negative numbers are not triangular");
        assertTrue(mathUtils.isTriangularNumber(0), "0 is a triangular number");
        assertTrue(mathUtils.isTriangularNumber(1), "1 is a triangular number");
        assertTrue(mathUtils.isTriangularNumber(6), "6 is a triangular number");
        assertFalse(mathUtils.isTriangularNumber(7), "7 is not a triangular number");
    }

    // Test for isSquareFree
    @Test
    void testIsSquareFree() {
        assertFalse(mathUtils.isSquareFree(-4), "Negative numbers are not square-free");
        assertTrue(mathUtils.isSquareFree(1), "1 is square-free");
        assertTrue(mathUtils.isSquareFree(10), "10 is square-free");
        assertFalse(mathUtils.isSquareFree(12), "12 is not square-free");
    }

    // Test for isPalindrome
    @Test
    void testIsPalindrome() {
        assertTrue(mathUtils.isPalindrome(0), "0 is a palindrome");
        assertTrue(mathUtils.isPalindrome(121), "121 is a palindrome");
        assertFalse(mathUtils.isPalindrome(123), "123 is not a palindrome");
        assertTrue(mathUtils.isPalindrome(1221), "1221 is a palindrome");
    }

    // Test for isStrongNumber
    @Test
    void testIsStrongNumber() {
        assertFalse(mathUtils.isStrongNumber(-145), "Negative numbers are not strong numbers");
        assertTrue(mathUtils.isStrongNumber(0), "0 is a strong number");
        assertTrue(mathUtils.isStrongNumber(145), "145 is a strong number");
        assertFalse(mathUtils.isStrongNumber(10), "10 is not a strong number");
    }

    // Test for isDisarium
    @Test
    void testIsDisarium() {
        assertFalse(mathUtils.isDisarium(-89), "Negative numbers are not Disarium numbers");
        assertTrue(mathUtils.isDisarium(0), "0 is a Disarium number");
        assertTrue(mathUtils.isDisarium(89), "89 is a Disarium number");
        assertFalse(mathUtils.isDisarium(100), "100 is not a Disarium number");
    }

    // Test for classifyNumber
    @Test
    void testClassifyNumber() {
        assertEquals("Negative numbers are not classified", mathUtils.classifyNumber(-1));
        assertEquals("Zero is neither prime, perfect, nor anything else.", mathUtils.classifyNumber(0));
        assertEquals("Prime", mathUtils.classifyNumber(2));
        assertEquals("Perfect", mathUtils.classifyNumber(6));
        assertEquals("Armstrong", mathUtils.classifyNumber(153));
        assertEquals("Strong", mathUtils.classifyNumber(145));
       // assertEquals("Disarium", mathUtils.classifyNumber(89));
    }


    // Test for AND (&&) operator
    @Test
    void testAndOperator() {
        assertTrue(logicalUtils.andOperator(true, true));
        assertFalse(logicalUtils.andOperator(true, false));
        assertFalse(logicalUtils.andOperator(false, true));
        assertFalse(logicalUtils.andOperator(false, false));

        // Boundary condition tests
        assertTrue(logicalUtils.andOperator(true, true));  // Boundary: Both true
        assertFalse(logicalUtils.andOperator(false, false));  // Boundary: Both false
    }

    // Test for OR (||) operator
    @Test
    void testOrOperator() {
        assertTrue(logicalUtils.orOperator(true, true));
        assertTrue(logicalUtils.orOperator(true, false));
        assertTrue(logicalUtils.orOperator(false, true));
        assertFalse(logicalUtils.orOperator(false, false));

        // Boundary condition tests
        assertTrue(logicalUtils.orOperator(true, true));  // Boundary: Both true
        assertFalse(logicalUtils.orOperator(false, false));  // Boundary: Both false
    }

    // Test for XOR (exclusive OR) operator
    @Test
    void testXorOperator() {
        assertFalse(logicalUtils.xorOperator(true, true));
        assertTrue(logicalUtils.xorOperator(true, false));
        assertTrue(logicalUtils.xorOperator(false, true));
        assertFalse(logicalUtils.xorOperator(false, false));

        // Boundary condition tests
        assertFalse(logicalUtils.xorOperator(true, true));  // Boundary: Both true
        assertTrue(logicalUtils.xorOperator(false, true));  // Boundary: One false, one true
    }

    // Test for NOT (!) operator
    @Test
    void testNotOperator() {
        assertFalse(logicalUtils.notOperator(true));
        assertTrue(logicalUtils.notOperator(false));
    }

    // Test for conditional ternary operator
    @Test
    void testConditionalOperator() {
        assertEquals("Positive", logicalUtils.conditionalOperator(5));
        assertEquals("Negative", logicalUtils.conditionalOperator(-3));
        assertEquals("Zero", logicalUtils.conditionalOperator(0));

        // Boundary condition tests
        assertEquals("Zero", logicalUtils.conditionalOperator(0)); // Boundary: Zero input
    }

    // Test for left shift (<<)
    @Test
    void testLeftShift() {
        assertEquals(16, logicalUtils.leftShift(4, 2));  // 4 << 2 = 16
     //   assertEquals(0, logicalUtils.leftShift(1, 32));  // Edge case: Shift positions > 31 should throw exception

        // Boundary condition tests
        assertThrows(IllegalArgumentException.class, () -> logicalUtils.leftShift(1, -1)); // Boundary: negative shift
        assertThrows(IllegalArgumentException.class, () -> logicalUtils.leftShift(1, 32)); // Boundary: shift > 31
    }

    // Test for right shift (>>)
    @Test
    void testRightShift() {
        assertEquals(1, logicalUtils.rightShift(4, 2));  // 4 >> 2 = 1
        assertEquals(0, logicalUtils.rightShift(4, 3));  // 4 >> 3 = 0

        // Boundary condition tests
        assertThrows(IllegalArgumentException.class, () -> logicalUtils.rightShift(4, -1)); // Boundary: negative shift
        assertThrows(IllegalArgumentException.class, () -> logicalUtils.rightShift(4, 32)); // Boundary: shift > 31
    }

    // Test for unsigned right shift (>>>)
    @Test
    void testUnsignedRightShift() {
        assertEquals(2, logicalUtils.unsignedRightShift(4, 1));  // 4 >>> 1 = 2
        assertEquals(0, logicalUtils.unsignedRightShift(4, 3));  // 4 >>> 3 = 0

        // Boundary condition tests
        assertThrows(IllegalArgumentException.class, () -> logicalUtils.unsignedRightShift(4, -1)); // Boundary: negative shift
        assertThrows(IllegalArgumentException.class, () -> logicalUtils.unsignedRightShift(4, 32)); // Boundary: shift > 31
    }

    // Test for bitwise AND (&)
    @Test
    void testBitwiseAnd() {
        assertEquals(4, logicalUtils.bitwiseAnd(5, 4));  // 0101 & 0100 = 0100 (4)
        //assertEquals(0, logicalUtils.bitwiseAnd(5, 3));  // 0101 & 0011 = 0000 (0)

        // Boundary condition tests
        assertEquals(0, logicalUtils.bitwiseAnd(0, 0));  // Boundary: both operands are 0
        assertEquals(Integer.MAX_VALUE, logicalUtils.bitwiseAnd(Integer.MAX_VALUE, Integer.MAX_VALUE)); // Boundary: max integer value
    }

    // Test for bitwise OR (|)
    @Test
    void testBitwiseOr() {
        assertEquals(5, logicalUtils.bitwiseOr(5, 4));  // 0101 | 0100 = 0101 (5)
        assertEquals(7, logicalUtils.bitwiseOr(5, 3));  // 0101 | 0011 = 0111 (7)

        // Boundary condition tests
        assertEquals(Integer.MAX_VALUE, logicalUtils.bitwiseOr(Integer.MAX_VALUE, Integer.MAX_VALUE)); // Boundary: max integer value
    }

    // Test for bitwise XOR (^)
    @Test
    void testBitwiseXor() {
        assertEquals(1, logicalUtils.bitwiseXor(5, 4));  // 0101 ^ 0100 = 0001 (1)
        assertEquals(6, logicalUtils.bitwiseXor(5, 3));  // 0101 ^ 0011 = 0110 (6)

        // Boundary condition tests
        assertEquals(Integer.MAX_VALUE, logicalUtils.bitwiseXor(Integer.MAX_VALUE, 0)); // Boundary: XOR with 0 should return the number
    }

    // Test for bitwise NOT (~)
    @Test
    void testBitwiseNot() {
        assertEquals(-6, logicalUtils.bitwiseNot(5));  // ~5 = -6
        assertEquals(-1, logicalUtils.bitwiseNot(0));  // ~0 = -1

        // Boundary condition tests
        assertEquals(-1, logicalUtils.bitwiseNot(0));  // Boundary: NOT of zero
    }

    @Test
    void testClearLeastSignificantBit() {
        assertEquals(4, logicalUtils.clearLeastSignificantBit(5)); // 5 -> 0101, LSB cleared -> 0100 = 4
        assertEquals(0, logicalUtils.clearLeastSignificantBit(0)); // Boundary: clearing LSB of 0 should return 0
    }

    UnaryOperator operator = new UnaryOperator();

    // Test for negate operation
    @Test
    public void testNegate() {
        assertEquals(-5, operator.negate(5), "Negation of 5 should be -5");
        assertEquals(5, operator.negate(-5), "Negation of -5 should be 5");
        assertEquals(0, operator.negate(0), "Negation of 0 should be 0");
    }

    // Test for bitwise negation
    @Test
    public void testBitwiseNegate() {
        assertEquals(-6, operator.bitwiseNegate(5), "Bitwise negation of 5 should be -6");
        assertEquals(4, operator.bitwiseNegate(-5), "Bitwise negation of -5 should be 4");
    }

    // Test for increment operation
    @Test
    public void testIncrement() {
        assertEquals(6, operator.increment(5), "Increment of 5 should be 6");
        assertEquals(0, operator.increment(-1), "Increment of -1 should be 0");
        assertEquals(1, operator.increment(0), "Increment of 0 should be 1");
    }

    // Test for decrement operation
    @Test
    public void testDecrement() {
        assertEquals(4, operator.decrement(5), "Decrement of 5 should be 4");
        assertEquals(-2, operator.decrement(-1), "Decrement of -1 should be -2");
        assertEquals(-1, operator.decrement(0), "Decrement of 0 should be -1");
    }

    // Test for absolute value
    @Test
    public void testAbsoluteValue() {
        assertEquals(5, operator.absoluteValue(-5), "Absolute value of -5 should be 5");
        assertEquals(0, operator.absoluteValue(0), "Absolute value of 0 should be 0");
        assertEquals(5, operator.absoluteValue(5), "Absolute value of 5 should be 5");
    }

    // Test for square operation
    @Test
    public void testSquare() {
        assertEquals(25, operator.square(5), "Square of 5 should be 25");
        assertEquals(25, operator.square(-5), "Square of -5 should be 25");
        assertEquals(0, operator.square(0), "Square of 0 should be 0");
    }
}
