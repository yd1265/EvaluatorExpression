package parsing;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
public class InfixToPostfix {
		private ParsingChar expression;
		private  String input;
		private String output="";
		private SymTab symbole;
		static Scanner scanner=new Scanner(System.in);

		// this is the constructor
	public InfixToPostfix(String infix) {
		  input=infix;
		  int taille=input.length();
		  expression=new ParsingChar(taille);
		  symbole=new SymTab(taille);
		 
}
	/// get the infix from user
		
	public  static String getInfix() throws IOException {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			String s = br.readLine();
			return s;
	}
	
	

		/// get the Symbol and values from users and parse it
		public  void getInput() throws IOException {
          String q="no";
	        while (true) {
	        
	        	System.out.println("Enter a symbol equal to a value somthing like this a=2  ");
	        	System.out.println("Please enter no when  you finished entering the values ");
		        String data =scanner.next();
	        	if(!data.equalsIgnoreCase(q)) {
	        		if(data.length() > 2) {
	   			 int equal=data.indexOf("=");
	   			  String v=data.substring(0, equal);
	   			char infix=v.charAt(0);
	   			String post=data.substring(equal+1, data.length());
	   			int value=Integer.parseInt(post);
	   			symbole.add(infix, value);
	   			  
	        		}else {
	        			System.out.println("wrong input");
	        		}
	   			}else {
	   				 break;
	   				
	            
	   			}
	        }
	        symbole.display();
		}
		
	/// in this function we transform infix to postFix notation
		public String doParsing() {
			for( int i=0; i< input.length(); i++) {
				char ch=input.charAt(i);
				switch (ch) {
				case '+': 
				case '-':
				gotOperation(ch, 1); 
				break; 
				case '*': 
				case '/':
				gotOperation(ch, 2); 
				break; 
				case '(': 
				expression.push(ch); 
				break;
				case ')':
					gotParenthese(ch); 
				break;
				default: 
				output = output + ch; 
				break;
				} 
				} 
				while( !expression.isEmpty()) {
				
				output = output + expression.popValue(); 
				}
				
				return output; 
	} 
		

             /// this function evaluate the postFix notation		
		public void evaluatePostfix(String postfix) {
			 ParseInt parse=new ParseInt(postfix.length());
			  for(int i=0; i<postfix.length();i++) {
				    char a=postfix.charAt(i);
				    	if(Character.isLetter(a)) {  /// if it is a letter
				    		int value=symbole.lokup(a); /// we ask the value 
				    		
				    		if( value!=-1) {   //// we test if the value exist
				              parse.push(value);
				    		}else {
				    			System.out.println(" we do not have value for  " +a);
				    		}
				    }else if(isOperator(a)) {
				    			
				      int op1=parse.popValue();
				      int op2=parse.popValue();
				      int res=performedOperation(a, op1, op2); /// we call performed operation
				      if(res!=-1) {
				      parse.push(res);
				      }else {
				    	  System.out.println(" we are unable do calculation invalid argument");
				      }
				      
			  }else if(Character.isDigit(a)){
			      parse.push(Character.getNumericValue(a));
			      
			  }else {
				   System.out.println(" wrong expression");
			  }	
		  }
		int answer=parse.popValue();
	 System.out.println("the value of the expression is " +answer) ;
		}
		
	// this function test if it is a operation
public void gotOperation(char op, int prec1){ 
		 while( !expression.isEmpty() ){
		  char top = expression.popValue();
		if( top == '(') {
		  expression.push(top); 
		break;
		
		}else {
		int prec2; 
		if(top=='+' || top=='-') 
		prec2 = 1;
		else
		prec2 = 2;
		if(prec2 < prec1) { 
		expression.push(top); 
		break;
		}
		else 
		output = output + top; 
		} 
	} 
		expression.push(op); 
} 
				
		public void gotParenthese(char ch){ 
			while( !expression.isEmpty() ){
				char chx = expression.popValue();
				if( chx ==  '(' ) 
				break; 
				else 
				output = output + chx;           // output it
				} 
		} 
				
    /// this function test if it is operator
		public boolean isOperator(char c) {
			if(c=='+' || c=='-' || c=='*' || c=='/') {
				return true;
			}
			return false;
		}

		/// this performed operation
		public int performedOperation(char operation, int operand1,int operand2) {
			if(operation=='+') 
				return operand1 + operand2;
			else if(operation=='-')
				return operand2- operand1;
			else if(operation=='*')
				return operand1 * operand2;
			else if(operation=='/')
				return operand1/operand2;
			else 
				System.out.println(" impossible expression");
			return -1;
			
		}

		
		
		public ParsingChar getExpression() {
			return expression;
		}
		
		
		public void setExpression(ParsingChar expression) {
			this.expression = expression;
		}
		
		
		public String getOutput() {
			return output;
		}
		
		
		public void setOutput(String output) {
			this.output = output;
		}
		
		
		
		}
