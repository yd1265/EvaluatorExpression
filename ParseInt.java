package parsing;
public class ParseInt {
		private int  taille;
		private int top;
		private int []data;
		/// constructor
		public ParseInt(int taille) {
			this.taille=taille;
			data=new int[taille];
			top=-1;
		}
	
		 // increment top and insert item
		 
		public void push(int j) {
			data[++top]=j; 
		}
		
		
		 // test if the stack is empty
		 
		public boolean isEmpty() {
			return (top==-1);
		}
	

		public int peekN(int n) {
			return data[n];
		}
		
		public int popValue(){
			return data[top--];
			
		}
		
		 // display the values inside the stack
		 
		
		public void display() {	
			while(!isEmpty()) {
				int temp=popValue();
				System.out.println(temp);
			}	
		}
		
	
		  // return the top 
		 
		public int peek() {
			 return data[top];
		
		}
		

	 // test if the stack if full
	 
		public boolean isFull() {
			return top==taille-1;
			
		}
		
		


	
}
