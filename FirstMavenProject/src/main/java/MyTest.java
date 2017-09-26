
public class MyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		boolean vOutput=isContainNewMeric(";vjon876evouw");
		if (vOutput==true){
			System.out.println("The String contains newmeric number");		
		}else{
			System.out.println("The string doesn't contain any newmeric number");
		}
			
		

	}
    
	public static boolean isContainNewMeric(String a){
		boolean result = false;
	  // String a="fjwne;uoe5847iavwnij";
		for(int i=0;i<=a.length()-1;i++){			
		  char b=a.charAt(i);
		  boolean isNM=Character.isDigit(b);
		 // System.out.println(isNM);			  
		  //System.out.println(b);
		  if(isNM==true){
			  result=true;
			  break;
		  }		  
		}		
		return result;
	}
}
