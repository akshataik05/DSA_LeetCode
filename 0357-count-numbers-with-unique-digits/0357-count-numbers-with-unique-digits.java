class Solution 
{
    public int countNumbersWithUniqueDigits(int n) 
    {   
        if(n==0) 
        {
            return 1;
        }
        int total=10;  // for n = 1
        int unique=9;  // first digit (1-9)
        int available=9; // remaining digits
        
        for (int i=2; i<=n && available>0; i++) 
        {
            unique=unique*available;
            total=total+unique;
            available--;
        }
        return total;
    }
}