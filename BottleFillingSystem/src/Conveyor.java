import java.util.LinkedList;
import java.util.Queue;

public class Conveyor {
	Queue<Bottle> queue = new LinkedList<Bottle>();
 public Bottle Checkqueue(){
	 System.out.println("check queue:"+queue.size());
	Bottle first=((LinkedList<Bottle>) queue).get(queue.size()-1);
	return first;	 
 }
 public boolean putNewBottle(){
	 Bottle b = new Bottle();
	 return queue.add(b);
 }
 public void putBottle(Bottle bot){
	 queue.add(bot);
 }
 public Bottle popBottle(){
	 return queue.poll();//if it does not anything,return false
 }
 
}
