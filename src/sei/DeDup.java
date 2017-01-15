package sei;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class DeDup {

    public static int[] randomIntegers = {1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,18,4,9,3,
                                   20,17,8,15,6,2,5,10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,
                                   13,5,11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,14,13,2,11};   
    /*public synchronized void setArr(int[] arr) {
        	randomIntegers = new int[arr.length];
    		randomIntegers = arr;			
	}*/

    public static void main(String [] args) {
    	String arg = args[0];
    	int[] elmnts={};
    	try{
    		Integer argumnt = Integer.valueOf(arg);
    		if(argumnt == 1){
    			elmnts = removeDuplicates(randomIntegers, true);
    		}
    		if(argumnt == 2){
    			elmnts = removeDuplicates(randomIntegers, false);
    		}
    		if(argumnt == 3){
    			elmnts = removeDuplicates2(randomIntegers);
    		}
    		if(argumnt == 4){
    			elmnts = removeDuplicatesNew(randomIntegers);
    		}

    	}
    	catch(NumberFormatException e){
    		System.out.println("Please provide an integer value");
    	}
    	System.out.println("Array with no duplicates");
    	for(Object in : elmnts){
    		System.out.println(in);
    	}
    }
    /**
     * Takes the random integers with an option to retain the initial oder
     * @param rand
     * @param retainOrder
     * @return
     */
    public static int[] removeDuplicates(int[] rand, boolean retainOrder){
    	Set<Integer> lnkdSt = null;
    	Set<Integer> cllctn = null;
    	Object[] arr = null;
    	
    	if(retainOrder){
    		lnkdSt = new LinkedHashSet<Integer>();
	    	for(int randV : rand){
	    		lnkdSt.add(randV);
	    	}
	    	arr = lnkdSt.toArray();    		
    	}
    	else{
	    	cllctn = new HashSet<Integer>();
	    	for(int randV : rand){
	    		cllctn.add(randV);
	    	}
	    	arr =  cllctn.toArray();
    	}
    	int[] retrnVal = new int[arr.length];
    	for(int i = 0; i<arr.length; i++){
    		retrnVal[i] = (int)arr[i];
    	}
    	return retrnVal;
    }
    /**
     * Gets the random value and iterates to remove the duplicates
     * @param rand
     * @return
     */
    public static int[] removeDuplicates2(int[] rand){
	    int last = rand.length;

	    for (int i = 0; i < last; i++) {
	        for (int j = i + 1; j < last; j++) {
	            if (rand[i] == rand[j]) {                  
	                rand[j] = rand[last-1];
	                last--;
	                j--;
	            }
	        }
	    }

	    int[] items = new int[last];
	    System.arraycopy(rand, 0, items, 0, last);
	    return items;
    }

    /**
     * Takes the random value and sort and then remove the duplicates
     * @param rand
     * @return
     */
    public static int[] removeDuplicatesNew(int[] rand){
    	Arrays.sort(randomIntegers);
    	return Arrays.stream(rand).distinct().toArray();
    }
}
