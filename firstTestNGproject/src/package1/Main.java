package package1;

import org.junit.Assert;
import org.junit.Before;
import org.testng.annotations.Test;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
        test();
        test2();
		
	}
	
	@Before
	public void testbefore(){
		System.out.println("Test started");
	}
    
	@Test 
	public static void test(){
		MyCalculator obj1=new MyCalculator();
		int vOutput=obj1.addition(2, 3);
		System.out.println(vOutput);	
		try{
			Assert.assertEquals(5, vOutput);
			System.out.println("Passed");
		}catch(AssertionError e){
			System.out.println("Failed because of "+e);			
		}		
		
	}
	
	@Test
	public static void test2(){
		MyCalculator obj1=new MyCalculator();
		int vOutput=obj1.addition(2, 3);
		System.out.println(vOutput);	
		try{
			Assert.assertEquals(54, vOutput);
			System.out.println("Passed");
		}catch(AssertionError e){
			System.out.println("Failed because of "+e);			
		}		
		
	}
	
	
	public void testAfter(){
		System.out.println("Test ended");
	}
}
