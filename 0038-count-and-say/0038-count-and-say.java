class Solution {
    public String countAndSay(int n) {
        // Base case: the first term is "1"
        if (n == 1) {
            return "1";
        }

        // Start with the first term
        StringBuilder currentTerm = new StringBuilder("1");

        // Iterate from the second term up to the nth term
        for (int i = 2; i <= n; i++) {
            StringBuilder nextTerm = new StringBuilder();
            int count = 1;
            char currentChar = currentTerm.charAt(0);

            // Traverse the current term to generate the next term
            for (int j = 1; j < currentTerm.length(); j++) {
                if (currentTerm.charAt(j) == currentChar) {
                    count++;
                } else {
                    nextTerm.append(count).append(currentChar);
                    currentChar = currentTerm.charAt(j);
                    count = 1;
                }
            }
            // Append the last group of characters
            nextTerm.append(count).append(currentChar);
            currentTerm = nextTerm; // Update for the next iteration
        }
        return currentTerm.toString();
    }
}
