class Solution 
{
    public String fractionToDecimal(int numerator, int denominator) 
    {
        if (numerator == 0) 
        {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        boolean isNegative = (numerator > 0) ^ (denominator > 0);
        if (isNegative) 
        {
            result.append("-");
        }
        long dividend = Math.abs((long) numerator);
        long divisor = Math.abs((long) denominator);
        result.append(dividend / divisor);
        dividend %= divisor;
        if (dividend == 0) 
        {
            return result.toString();
        }
        result.append(".");
        Map<Long, Integer> remainderToPosition = new HashMap<>();
        while (dividend != 0) {
            remainderToPosition.put(dividend, result.length());
            dividend *= 10;
            result.append(dividend / divisor);
            dividend %= divisor;
            if (remainderToPosition.containsKey(dividend)) 
            {
                int repeatStartPosition = remainderToPosition.get(dividend);
                result.insert(repeatStartPosition, "(");
                result.append(")");
                break;
            }
        }
        return result.toString();
    }
}