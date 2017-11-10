	package parsing;
	import java.io.IOException;
	public class TestEvaluaor {
		public static void main(String[] args) throws IOException {
				 InfixToPostfix infix;
				 String input, output;
					 System.out.println(" Please enter the infix notation");
					 System.out.flush();
					  input=InfixToPostfix.getInfix(); /// we call get infix
					  infix=new InfixToPostfix(input);  // we call our constructor
					   infix.getInput();;  
					  output= infix.doParsing(); /// we do our parsing
					  System.out.println(" The infix notation is   "+input+" covert  to  postfix is "+output);
						infix.evaluatePostfix(output); /// we evaluate the value
						System.out.println();
			 System.out.println(" Thank you ");
			}	
		
		}
