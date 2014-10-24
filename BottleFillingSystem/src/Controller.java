import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {
  public String getSignal() throws IOException{
	  String signal=null;
	  while(signal==null){
		  BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		  System.out.print("waiting for starting the system");
		  System.out.flush();
	      signal= r.readLine();
	  }
	  return signal;
 }
}
