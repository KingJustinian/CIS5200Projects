/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cis5200.project1;

/**
 *
 * @author Justin Burden
 */
public class HugeIntegerTest {
    
    public static void main(String[] args)
    {
        HugeInteger test1 = new HugeInteger();
        
        System.out.println(test1.toString());
        
        test1.parse("321");
        
        System.out.println(test1.toString());
        
        test1.parse("54673");
        
        System.out.println(test1.toString());  
        
        
        HugeInteger test2 = new HugeInteger("6000");
        HugeInteger test3 = HugeInteger.add(test1, test2);
        
        System.out.println(test3.toString());
        
        HugeInteger test4 = HugeInteger.subtract(test1, test2);
        System.out.println(test4.toString());
        
        
        HugeInteger test5 = new HugeInteger("50000");
        HugeInteger test6 = HugeInteger.add(test1, test5);
        
        System.out.println(test6.toString());
        
        HugeInteger test7 = HugeInteger.subtract(test1, test5);
        System.out.println(test7.toString());
        
        HugeInteger test8 = new HugeInteger("50000");
        System.out.println(HugeInteger.isEqualTo(test1, test8));
        System.out.println(HugeInteger.isEqualTo(test5, test8));       
        System.out.println(HugeInteger.isNotEqualTo(test1, test8));
        System.out.println(HugeInteger.isNotEqualTo(test5, test8)); 
        
        System.out.println(HugeInteger.isGreaterThan(test1, test8));
        System.out.println(HugeInteger.isGreaterThan(test8, test1));
        System.out.println(HugeInteger.isGreaterThan(test8, test5));
        System.out.println(HugeInteger.isLessThan(test1, test8));
        System.out.println(HugeInteger.isLessThan(test8, test1));
        System.out.println(HugeInteger.isLessThan(test8, test5));
        
        System.out.println(HugeInteger.isGreaterThanOrEqualTo(test1, test8));
        System.out.println(HugeInteger.isGreaterThanOrEqualTo(test8, test1));
        System.out.println(HugeInteger.isGreaterThanOrEqualTo(test8, test5));
        
        System.out.println(HugeInteger.isZero(test1));
        System.out.println(HugeInteger.isZero(new HugeInteger("000")));       
    }
}
