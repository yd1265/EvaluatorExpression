package parsing;
public class SymTab {
private char [] name;           // this array hold the symbol
private int  [] value;           /// this array hold the value 
private int index;                /// this index is the number of element inside
private int size;

// this is the default constructor

public SymTab() {
	
}

/// overloaded constructor
public SymTab(int a) {
	  value=new int[a];
	   name=new char [a];
	   index=-1;
	   size=a;
}

//  this function test if is empty or not

public boolean isEmpty() {
	   return (index==-1);             // index=-1 does the same thing
}

// check if it is full
public boolean isFull() {
	return (index==size);
}


// this is the display function
 
public void display() {
	System.out.print("the values inside the Symbole table are ");
	for( int i=0; i <=index; i++) {
		    System.out.print( "( "+name[i] + " , "+ value[i]+")");
		    
	
	}
}

/// this is the add function 
public void add(char key, int number ) {
	 if(lokup(key)==-1) {                 /// test if key does not exist then  add
		  index++;
	       name[index]=key;
	        value[index]=number;
  }else {
	     changeValue(key, number);        /// if key exist then change the value of the current key
}
		   
}
/// this function update the value of an existing key without duplicating
 
public void changeValue(char key,int num) {
	 for(int i=0; i<=index; i++) {
		 if(name[i]==key) {
			 value[i]=num;
		 }
	 }
}
//  this function take a key and return the value for that key if not found return -1
 
public int lokup(char key) {
	  int myvalue=-1;
	for(int i=0; i<=index; i++) {
		 if( name[i]==key && value[i]!=-1) {
			 myvalue= value[i];
		 }
	}
	return myvalue;
	
}

public int getIndex() {
	return index;
}

public void setIndex(int index) {
	this.index = index;
}

public char[] getName() {
	return name;
}

public void setName(char[] name) {
	this.name = name;
}

public int[] getValue() {
	return value;
}

public void setValue(int[] value) {
	this.value = value;
}

}
