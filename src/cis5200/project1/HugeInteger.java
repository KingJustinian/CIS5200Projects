package cis5200.project1;

/**
 * CIS5200-W01
 * Project 1 , Problem 8.17 pg. 371
 * Justin Burden
 *
 * @author Justin Burden
 */
public class HugeInteger
{
    public final static int MAX_SIZE = 40;
    
    private int[] intArray;
    private int numDigits;  // stores the number of digits in intArray
    
    public HugeInteger(String s)
    {
        this();
        parse(s);
    }
    
    public HugeInteger()
    {
        intArray = new int[MAX_SIZE];
        numDigits = 0;
    }
    
    public void parse(String s)
    {
        if (s.length() > MAX_SIZE)
        {
            throw new IllegalArgumentException(String.format("The string "
                    + "argument contains %d digits which is more than the max "
                    + "size of %d", s.length(), MAX_SIZE));
        }
        
        intArray = new int[MAX_SIZE];
        
        for (int i=0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            // We can assume all are valid numeric numbers
            int intChar = c - '0';
            
            intArray[MAX_SIZE - s.length() + i] = intChar;
        }
        
        numDigits = s.length();
    }
    
    public static HugeInteger add(HugeInteger hugeInt1, HugeInteger 
        hugeInt2)
    {
        HugeInteger hugeInt3 = new HugeInteger();
        
        int carry = 0;
        
        for (int i=MAX_SIZE-1; i >= 0; i--)
        {
            int summedVal = hugeInt1.intArray[i] + hugeInt2.intArray[i] + carry;
            
            if (summedVal < 10)
            {
                carry = 0;
            } else
            {
                summedVal -= 10;
                carry = 1;
            }
            
            hugeInt3.intArray[i] = summedVal;
        }
        
        hugeInt3.numDigits = hugeInt3.intArray.length - getFirstNonZeroIndex(hugeInt3);
        
        if (carry > 0)
        {
            throw new IllegalArgumentException("The summed numbers exceeded the "
                    + "maximum array size due to carrying over of numbers");
        }
        
        return hugeInt3;
    }
    
    public static HugeInteger subtract(HugeInteger hugeInt1, HugeInteger 
        hugeInt2)
    {
        HugeInteger hugeInt3 = new HugeInteger();
        
        int borrow = 0;
        
        for (int i=MAX_SIZE-1; i >= 0; i--)
        {
            int subtractedVal = hugeInt1.intArray[i] - hugeInt2.intArray[i] - borrow;
            
            if (subtractedVal >= 0)
            {
                borrow = 0;
            } else
            {
                subtractedVal += 10;
                borrow = 1;
            }
            
            hugeInt3.intArray[i] = subtractedVal;
        }
        
        hugeInt3.numDigits = hugeInt3.intArray.length - getFirstNonZeroIndex(hugeInt3);
        
        return hugeInt3;
    }
    
    public static boolean isEqualTo(HugeInteger hugeInt1, HugeInteger 
        hugeInt2)
    {               
        for (int i=0; i < MAX_SIZE; i++)
        {
            if (hugeInt1.intArray[i] != hugeInt2.intArray[i])
            {
                return false;
            }
        }
        
        return true;
    }
    
    public static boolean isNotEqualTo(HugeInteger hugeInt1, HugeInteger 
        hugeInt2)
    {
        return !isEqualTo(hugeInt1, hugeInt2);
    }
    
    public static boolean isGreaterThan(HugeInteger hugeInt1, HugeInteger 
        hugeInt2)
    {
        for (int i=0; i < MAX_SIZE; i++)
        {
           if (hugeInt1.intArray[i] > hugeInt2.intArray[i])
           {
               return true;
           } else if (hugeInt1.intArray[i] < hugeInt2.intArray[i])
           {
               return false;
           }
           // Do nothing if equal, keep checking
        }
        
        return false;
    }
    
    public static boolean isLessThan(HugeInteger hugeInt1, HugeInteger 
        hugeInt2)
    {
        return !isGreaterThan(hugeInt1, hugeInt2);
    }
    
    public static boolean isGreaterThanOrEqualTo(HugeInteger hugeInt1, 
        HugeInteger hugeInt2)
    {
        return isEqualTo(hugeInt1, hugeInt2) || isGreaterThan(hugeInt1, hugeInt2);
    }
    
    public static boolean isZero(HugeInteger hugeInt1)
    {
        for (int i=0; i < MAX_SIZE; i++)
        {
           if (hugeInt1.intArray[i] != 0)
           {
               return false;
           } 
        }
        
        return true;
    }

    @Override
    public String toString( )
    {
        StringBuilder sb = new StringBuilder();
        
        if (isZero(this))
        {
            sb.append("0");
        } else
        {
            for (int i=MAX_SIZE - numDigits; i < MAX_SIZE; i++)
            {
                sb.append(intArray[i]);
            }
        }
        
        return sb.toString();
    }
    
        
    private static int getFirstNonZeroIndex(HugeInteger hugeInt)
    {
        for (int i=0; i < hugeInt.intArray.length; i++)
        {
            if (hugeInt.intArray[i] != 0)
            {
                return i;
            }
        }
        
        return hugeInt.intArray.length;
    }
}
