
public class StringToArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String a="I love you more than I can say";
		String[] myArray=a.split("\\s+"); 
		//Regular Expression: 2 single back slash used. One for eclipse and one for regular expression. if intellij is used than one \ will be needed
		//s is used for whitespace
		//+ is used for s is 0 or one time
		
		//display all array values using for each loop
		for(String v:myArray){
			System.out.println(v);
		}
		
		//display all array values using for loop
		for(int i=0;i<myArray.length;i++){
			System.out.println(myArray[i]);
		}
		
		//display 2 elements value by hard coding
		System.out.println(myArray[3]);
		System.out.println(myArray[2]);

	}

}
