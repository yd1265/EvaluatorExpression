package parsing;

public class ParsingChar{
	private int  taille;
	private int top;
	private char []data;
	
	/// constructor 
	public ParsingChar(int taille) {
		this.taille=taille;
		data=new char[taille];
		top=-1;
	}
	
	/*
	 * increment top and insert item
	 */
	public void push(char j) {
		data[++top]=j; 
	}
	
	/*
	 * test if the stack is empty
	 */
	public boolean isEmpty() {
		return (top==-1);
	}
	/*
	 * pop the values
	 */
	
	
	public int peekN(int n) {
		return data[n];
	}
	
	public char popValue(){
		return data[top--];
		
	}
	/// display the values inside the stack
	 
	
	public void display() {	
		while(!isEmpty()) {
			char temp=popValue();
			System.out.println(temp);
		}	
	}
	
	///  return the top 
	 
	public int peek() {
		 return data[top];
	
	}
	
///  test if the stack if full
 
	public boolean isFull() {
		return top==taille-1;
		
	}
	
	
	

}
