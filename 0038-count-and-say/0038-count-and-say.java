class Solution {
    public String countAndSay(int n) 
    {
        if (n == 1) 
        {
            return "1";
        }
        StringBuilder currentTerm = new StringBuilder("1");
        for (int i = 2; i <= n; i++) {
            StringBuilder nextTerm = new StringBuilder();
            int count = 1;
            char currentChar = currentTerm.charAt(0);
            for (int j = 1; j < currentTerm.length(); j++) 
            {
                if (currentTerm.charAt(j) == currentChar) 
                {
                    count++;
                } 
                else 
                {
                    nextTerm.append(count).append(currentChar);
                    currentChar = currentTerm.charAt(j);
                    count = 1;
                }
            }
            nextTerm.append(count).append(currentChar);
            currentTerm = nextTerm; 
        }
        return currentTerm.toString();
    }
}
