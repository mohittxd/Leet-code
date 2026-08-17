/**
 * The rand7() API is already defined for you.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        int val;
        do {
            int row = rand7();
            int col = rand7();
            val = (row - 1) * 7 + col; // uniform in [1, 49]
        } while (val > 40);

        return (val - 1) % 10 + 1;
    }
}