class Solution 
{
    public int countNumbersWithUniqueDigits(int n) 
    {   
        if(n==0) 
        {
            return 1;
        }
        int total=10;
        int unique=9;  
        int available=9;
        
        for (int i=2; i<=n && available>0; i++) 
        {
            unique=unique*available;
            total=total+unique;
            available--;
        }
        return total;
    }
}