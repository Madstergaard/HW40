
/* Shaumik Ashraf
 * HW#39 - Array of Steel
 * APCS - pd9
 * 2015-12-1 
 */


/*****************************
 * class SuperArray --  A wrapper class for an array. 
 *
 * Maintains functionality:
 *  access value at index
 *  overwrite value at index
 *
 * Adds functionality to std Java array:
 *  resizability
 *  ability to print meaningfully
 *****************************/

public class SuperArray {

		//~~~~~INSTANCE VARS~~~~~
		//underlying container, or "core" of this data structure:
    private int[] _data;

		//position of last meaningful value
    private int _lastPos;

		//size of this instance of SuperArray
	private int _size;

	/*
		//An array of length _size where if _data[n] is meaningful then _alllocated[n] = true, else false
		//Wouldn't this be alot more effective? ...
	private boolean[] _allocated;
	*/
		
		//~~~~~METHODS~~~~~
    //default constructor - initializes 10-item array
    public SuperArray() { 
    	
    	_data = new int[10];
    	_lastPos = 0;
    	_size = 10;
    	
    }

	//custom constructor - initialize n-item array
	public SuperArray(int n) {
		_data = new int[n];
		_lastPos = 0;
		_size = n;
		
	}
		
    //output array in [a,b,c] format, eg
    // {1,2,3}.toString() -> "[1,2,3]"
    public String toString() { 
    	
    	String rs = "[";
    	
    	for(int i : _data) {
    		rs += i + ",";
    	}
    	
    	rs = rs.substring(0, rs.length()-1);
    	rs += "]";
    	
    	return(rs);
    	
    }

		
    //double capacity of this SuperArray
    private void expand() {
    	
    	int[] new_data = new int[ _size*2 ];
    	
    	for(int i=0; i<_size; i++) {
    		new_data[i] = _data[i];
    	}
    	
    	_size *= 2;
    	
    	_data = new_data;
    	
    }

		
    //accessor -- return value at specified index
    //No ArrayIndexOutOfBoundsException catch!!!!
	public int get( int index ) { 
    	
    	return( _data[index] );
    	
    }

		
    //mutator -- set value at index to newVal, 
    //           return old value at index
    //No ArrayIndexOutOfBoundsException catch!!!!
	public int set( int index, int newVal ) {
    	
		int temp = _data[index];
    	
    	if( index > _lastPos ) {
    		_lastPos = index;
    	}
    	
    	_data[index] = newVal;
    	
    	return(temp);
    	
    }


	//main method for testing
	public static void main( String[] args ) {
		
		SuperArray sarr1 = new SuperArray();
		SuperArray sarr2 = new SuperArray(3);
		
		System.out.println("Initializing super arrays:");
		System.out.println(sarr1);
		System.out.println(sarr2);
		
		System.out.println("\nsetting sarr1[5] to -3; was: " + sarr1.set(5,-3));
		System.out.println("setting sarr1[2] to -3; was: " + sarr1.set(2,-3));
		System.out.println("setting sarr2[1] to 743; was: " + sarr2.set(1,743));
		System.out.println("sarr1: " + sarr1);
		System.out.println("sarr2: " + sarr2);
		
		System.out.println("getting sarr1[2]: " + sarr1.get(2));
		System.out.println("expanding sarr2");
		sarr2.expand();
		System.out.println("sarr2: " + sarr2);
		
		System.out.println("\nDone.");
		
	}//end main
		
}//end class

