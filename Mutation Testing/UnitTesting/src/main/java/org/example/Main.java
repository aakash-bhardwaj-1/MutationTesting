package org.example;

class MathUtils {

    // Method to check if a number is prime
    public boolean isPrime(int n) {
        if (n <= 1) return false; // 0, 1, and negatives are not prime
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // Method to check if a number is a Fibonacci number
    public boolean isFibonacci(int n) {
        if (n < 0) return false;
        int x1 = 5 * n * n + 4;
        int x2 = 5 * n * n - 4;
        return isPerfectSquare(x1) || isPerfectSquare(x2);
    }

    private boolean isPerfectSquare(int x) {
        int s = (int) Math.sqrt(x);
        return s * s == x;
    }

    // Method to calculate the factorial of a number
    public int factorial(int n) {
        if (n < 0) return -1; // Undefined for negative numbers
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Method to check if a number is an Armstrong number
    public boolean isArmstrong(int n) {
        if (n < 0) return false; // Negative numbers are not Armstrong
        int sum = 0, temp = n, digits = String.valueOf(n).length();
        while (temp > 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, digits);
            temp /= 10;
        }
        return sum == n;
    }

    // Method to check if a number is a perfect number
    public boolean isPerfectNumber(int n) {
        if (n <= 0) return false;
        int sum = 0;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) sum += i;
        }
        return sum == n;
    }

    // Method to check if a number is a Harshad number
    public boolean isHarshad(int n) {
        if (n <= 0) return false;
        int sumOfDigits = sumOfDigits(n);
        return n % sumOfDigits == 0;
    }

    private int sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    // Method to check if a number is a triangular number
    public boolean isTriangularNumber(int n) {
        if (n < 0) return false;
        int x = (int) Math.sqrt(2 * n);
        return x * (x + 1) / 2 == n;
    }

    // Method to check if a number is square-free
    public boolean isSquareFree(int n) {
        if (n <= 0) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % (i * i) == 0) return false;
        }
        return true;
    }

    // Method to check if a number is a palindrome
    public boolean isPalindrome(int n) {
        String str = String.valueOf(n);
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    // Method to check if a number is a strong number
    public boolean isStrongNumber(int n) {
        if (n < 0) return false;
        int sum = 0, temp = n;
        while (temp > 0) {
            int digit = temp % 10;
            sum += factorial(digit);
            temp /= 10;
        }
        return sum == n;
    }

    // Method to check if a number is a Disarium number
    public boolean isDisarium(int n) {
        if (n < 0) return false;
        int sum = 0, temp = n, length = String.valueOf(n).length();
        while (temp > 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, length--);
            temp /= 10;
        }
        return sum == n;
    }

    // Method to classify a number based on certain categories
    public String classifyNumber(int n) {
        if (n < 0) {
            return "Negative numbers are not classified";
        } else if (n == 0) {
            return "Zero is neither prime, perfect, nor anything else.";
        } else if (isPrime(n)) {
            return "Prime";
        } else if (isPerfectNumber(n)) {
            return "Perfect";
        } else if (isArmstrong(n)) {
            return "Armstrong";
        } else if (isStrongNumber(n)) {
            return "Strong";
        } else if (isDisarium(n)) {
            return "Disarium";
        }
        return "Other";
    }
}


class BitwiseUtils {

    // Function to check if a number is odd
    public boolean isOdd(int n) {
        if (n < 0) {
            System.out.println("Negative numbers are not allowed.");
            return false;
        }
        return (n & 1) == 1;
    }

    // Function to check if a number is even
    public boolean isEven(int n) {
        if (n < 0) {
            System.out.println("Negative numbers are not allowed.");
            return false;
        }
        return (n & 1) == 0;
    }

    // Function to swap two numbers using bitwise XOR
    public int[] swapUsingXOR(int a, int b) {
        if (a == b) {
            System.out.println("Numbers are identical, no swap needed.");
            return new int[]{a, b};
        }
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        return new int[]{a, b};
    }

    // Function to find the only non-repeating element in an array
    public int findSingleNonRepeating(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("Array is null or empty.");
            return -1;
        }
        int result = 0;
        for (int num : arr) {
            result ^= num;
        }
        return result;
    }

    // Function to check if a number is a power of two
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            System.out.println("Number must be positive.");
            return false;
        }
        return (n & (n - 1)) == 0;
    }

    // Function to count the number of set bits in a number
    public int countSetBits(int n) {
        if (n < 0) {
            System.out.println("Negative numbers are not allowed.");
            return -1;
        }
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

    // Function to check if two numbers have opposite signs
    public boolean haveOppositeSigns(int x, int y) {
        if (x == 0 || y == 0) {
            System.out.println("One or both numbers are zero; signs cannot be determined.");
            return false;
        }
        return (x ^ y) < 0;
    }

    // Function to get the nth bit of a number
    public int getNthBit(int num, int n) {
        if (n < 0) {
            System.out.println("Bit position cannot be negative.");
            return -1;
        }
        return (num >> n) & 1;
    }

    // Function to set the nth bit of a number
    public int setNthBit(int num, int n) {
        if (n < 0) {
            System.out.println("Bit position cannot be negative.");
            return num;
        }
        return num | (1 << n);
    }

    // Function to clear the nth bit of a number
    public int clearNthBit(int num, int n) {
        if (n < 0) {
            System.out.println("Bit position cannot be negative.");
            return num;
        }
        return num & ~(1 << n);
    }

    // Function to toggle the nth bit of a number
    public int toggleNthBit(int num, int n) {
        if (n < 0) {
            System.out.println("Bit position cannot be negative.");
            return num;
        }
        return num ^ (1 << n);
    }

    // Function to check if a number is a palindrome in binary form
    public boolean isBinaryPalindrome(int num) {
        if (num < 0) {
            System.out.println("Negative numbers are not allowed.");
            return false;
        }
        int reversed = 0, original = num;
        while (num > 0) {
            reversed = (reversed << 1) | (num & 1);
            num >>= 1;
        }
        return original == reversed;
    }

    // Function to reverse the bits of a number
    public int reverseBits(int num) {
        if (num < 0) {
            System.out.println("Negative numbers are not allowed.");
            return -1;
        }
        int result = 0;
        while (num != 0) {
            result = (result << 1) | (num & 1);
            num >>= 1;
        }
        return result;
    }

    // Function to find the next power of two greater than or equal to a number
    public int nextPowerOfTwo(int n) {
        if (n <= 0) {
            System.out.println("Number must be positive.");
            return 1;
        }
        n--;
        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8;
        n |= n >> 16;
        return n + 1;
    }

    // Function to determine the position of the rightmost set bit
    public int rightmostSetBitPosition(int n) {
        if (n <= 0) {
            System.out.println("Number must be positive.");
            return -1;
        }
        return (int) (Math.log(n & -n) / Math.log(2)) + 1;
    }

    // Function to calculate XOR from 1 to n
    public int xorFrom1ToN(int n) {
        if (n < 0) {
            System.out.println("Number must be non-negative.");
            return -1;
        }
        switch (n % 4) {
            case 0: return n;
            case 1: return 1;
            case 2: return n + 1;
            case 3: return 0;
        }
        return 0; // Won't reach here
    }

    // Function to determine if a number has alternating bits
    public boolean hasAlternatingBits(int n) {
        if (n <= 0) {
            System.out.println("Number must be positive.");
            return false;
        }
        int xor = n ^ (n >> 1);
        return (xor & (xor + 1)) == 0;
    }

    // Function to find the parity of a number
    public boolean isEvenParity(int n) {
        if (n < 0) {
            System.out.println("Negative numbers are not allowed.");
            return false;
        }
        boolean parity = false;
        while (n != 0) {
            parity = !parity;
            n &= (n - 1);
        }
        return !parity;
    }

    // Function to clear all bits from the most significant bit through the nth bit
    public int clearBitsFromMSB(int num, int n) {
        if (n < 0) {
            System.out.println("Bit position cannot be negative.");
            return num;
        }
        int mask = (1 << n) - 1;
        return num & mask;
    }

    // Function to clear all bits from 0th to nth bit
    public int clearBitsFromLSB(int num, int n) {
        if (n < 0) {
            System.out.println("Bit position cannot be negative.");
            return num;
        }
        int mask = ~((1 << (n + 1)) - 1);
        return num & mask;
    }
}
class LogicalBitwiseUtils {

    // Method for AND (&&) operator with boundary checks
    public boolean andOperator(boolean a, boolean b) {
        if (a == true && b == true) {
            return true;
        } else {
            return false;
        }
    }

    // Method for OR (||) operator with boundary checks
    public boolean orOperator(boolean a, boolean b) {
        if (a == true || b == true) {
            return true;
        } else {
            return false;
        }
    }

    // Method for XOR (exclusive OR) operator with boundary checks
    public boolean xorOperator(boolean a, boolean b) {
        if (a != b) {
            return true;
        } else {
            return false;
        }
    }

    // Method for NOT (!) operator with boundary checks
    public boolean notOperator(boolean a) {
        return !a;
    }

    // Method for ternary conditional operator with boundary conditions
    public String conditionalOperator(int a) {
        if (a > 0) {
            return "Positive";
        } else if (a < 0) {
            return "Negative";
        } else {
            return "Zero";
        }
    }

    // Method for left shift (<<) operation with boundary check
    public int leftShift(int a, int positions) {
        if (positions < 0 || positions > 31) {
            throw new IllegalArgumentException("Shift positions must be between 0 and 31.");
        }
        return a << positions;
    }

    // Method for right shift (>>) operation with boundary check
    public int rightShift(int a, int positions) {
        if (positions < 0 || positions > 31) {
            throw new IllegalArgumentException("Shift positions must be between 0 and 31.");
        }
        return a >> positions;
    }

    // Method for unsigned right shift (>>>) operation with boundary check
    public int unsignedRightShift(int a, int positions) {
        if (positions < 0 || positions > 31) {
            throw new IllegalArgumentException("Shift positions must be between 0 and 31.");
        }
        return a >>> positions;
    }

    // Method for bitwise AND (&) operation
    public int bitwiseAnd(int a, int b) {
        return a & b;
    }

    // Method for bitwise OR (|) operation
    public int bitwiseOr(int a, int b) {
        return a | b;
    }

    // Method for bitwise XOR (^) operation
    public int bitwiseXor(int a, int b) {
        return a ^ b;
    }

    // Method for bitwise NOT (~) operation
    public int bitwiseNot(int a) {
        return ~a;
    }

    // Method to clear the least significant bit (LSB) of an integer
    public int clearLeastSignificantBit(int n) {
        if (n == 0) return 0;
        return n & (n - 1);
    }
}

class UnaryOperator {

    // Function to negate a number (unary minus)
    public int negate(int num) {
        return -num;
    }

    // Function to perform bitwise negation (~)
    public int bitwiseNegate(int num) {
        return ~num;
    }

    // Function to increment a number by 1
    public int increment(int num) {
        return num + 1;
    }

    // Function to decrement a number by 1
    public int decrement(int num) {
        return num - 1;
    }

    // Function to compute the absolute value of a number
    public int absoluteValue(int num) {
        return (num < 0) ? -num : num;
    }

    // Function to calculate the square of a number (another unary operation)
    public int square(int num) {
        return num * num;
    }
}



