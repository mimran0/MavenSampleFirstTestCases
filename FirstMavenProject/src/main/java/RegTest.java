import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String line = "This order was placed for QT3000! OK? lhvu";
	      
	   String pattern = ".*";	      
	   // Create a Pattern object
	   Pattern r = Pattern.compile(pattern);	      
	   // Now create matcher object.
	   Matcher m = r.matcher(line);
	   //  System.out.println(m);	     
	    if (m.find( )) {
	         System.out.println("Found value: " + m.group(0) );	         
	      }
	}

}
