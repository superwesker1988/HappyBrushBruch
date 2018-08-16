/**
 * 
Count the number of prime numbers less than a non-negative number, n.

Example:

Input: 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 */

class Solution {
    private boolean isPrime(int n, List<Integer> primes) {
        for (int prime : primes) {
            if (prime > Math.sqrt(n)) {
                return true;
            }
            if (n % prime == 0) {
                return false;
            }
        }
        return true;
    }
    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }
        int count = 0;
        List<Integer> primes = new ArrayList<Integer>();
        for (int i = 2; i < n; i++) {
            if (isPrime(i, primes)) {
                primes.add(i);
            }
        }
        return primes.size();
    }
}