// Maddie Ostergaard
// APCS1 pd9
// HW39 -- Array of Steel
// 2015-12-01



/*****************************
 * SKELETON for
 * class SuperArray --  A wrapper class for an array. 
 * Maintains functionality:
 *  access value at index
 *  overwrite value at index
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

		
		//~~~~~METHODS~~~~~
    //default constructor – initializes 10-item array
    public SuperArray() {
	_data = new int[10];
	_lastPos = -1;
	_size = 0;
    }

		
    //output array in [a,b,c] format, eg
    // {1,2,3}.toString() -> "[1,2,3]"
    public String toString() {
	String retStr = "[";
	for (int i = 0; i < _size - 1; i++){
	    retStr += _data[i];
	    retStr += ",";
	}
	retStr += _data[_size - 1];
	retStr += "]";
	return retStr;
    }

		
    //double capacity of this SuperArray
    private void expand() {
	int doub_size = _size * 2;
	int[] doub_data = new int[doub_size];
	for(int i = 0; i < _size; i++){
	    doub_data[i] = _data[i];
	}
	_data = doub_data;
    }

		
    //accessor -- return value at specified index
    public int get( int index ) {
	return _data[index];
    }

		
    //mutator -- set value at index to newVal, 
    //           return old value at index
    public int set( int index, int newVal ) {
	// needs to have at least the same number of meaningful positions
	int oldVal = _data[index];
	_data[index] = newVal;
	return oldVal;
    }


		//main method for testing
		public static void main( String[] args ) {
		    SuperArray pow = new SuperArray();
		    System.out.println(pow);
		    pow.expand();
		    System.out.println(pow);
		    pow._data[5] = 41;
		    System.out.println(pow.get(5));
		    pow.set(4, 31);
		    System.out.println(pow);
		}//end main
		
}//end class
