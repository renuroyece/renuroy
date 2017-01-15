package test;

import junit.framework.Assert;
import junit.framework.TestCase;
import sei.DeDup;

public class DeDupTest extends TestCase{
	public static void testDuplicates() throws Exception{
		int[] comp = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,10000,16,17,18,19,20,85,86,25,26,34,43,45};
		int[] result = DeDup.removeDuplicates(DeDup.randomIntegers, false);
		for(int i =0; i<comp.length; i++){
			Assert.assertEquals(comp[i], result[i]);
		}
	}
	public static void testDuplicatesWithOrder(){
		int[] comp = {1,2,34,25,45,3,26,85,4,86,43,10000,11,16,19,18,9,20,17,8,15,6,5,10,14,12,13,7};
		int[] result = DeDup.removeDuplicates(DeDup.randomIntegers, true);
		for(int i =0; i<comp.length; i++){
			Assert.assertEquals(comp[i], result[i]);
		}
	}
	
	//Providing Values
	public static void testDuplicates2(){
		int[] sample = {1,2,3,4,2,3,4,8};
		int[] comp = {1,2,3,4,8};
		int[] result = DeDup.removeDuplicates(sample, false);
		for(int i =0; i<comp.length; i++){
			Assert.assertEquals(comp[i], result[i]);
		}
	}
	
	//Providing Values
	public static void testDuplicatesWithOrder2(){
		int[] sample = {1,2,8,3,5,10,6,7,8};
		int[] comp = {1,2,8,3,5,10,6,7};
		int[] result = DeDup.removeDuplicates(sample, true);
		for(int i =0; i<comp.length; i++){
			Assert.assertEquals(comp[i], result[i]);
		}
	}
	
	
}
