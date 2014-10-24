
public class RoundC implements Runnable{

	private Conveyor Ltwo = new Conveyor();
	
  Bottle bo[]=new Bottle[6];
  public Bottle checkRoundCanRecieve(){
	  System.out.println("checkRoundCanRecieve bo[0]="+bo[0]);
	  return bo[0];//null means bo[0] does not have bottle
  }
  public void getBottlefromLConveyor(Bottle b){
	  bo[0]=b;

	  System.out.println("getBottlefromLConveyor bo[0]="+bo[0]);
  }
  public Bottle checkFillingWaterBottle(){
	  return bo[1];
  }
  
  public Boolean checkBottleWaterState(){
	  return bo[1].hasWater;
  }
  public void putWatertoBottle(){
	  bo[1].hasWater=true;
  }
  public Bottle checkPutCapBottle(){
	  return bo[2];
  }
  
  public Boolean checkBottleCapState(){
	  return bo[2].hasCap;
  }
  public void putCaptoBottle(){
	  bo[2].hasCap=true;
  }
  public Bottle checkGripperBottle(){
	  return bo[3];
  }
  
  public Boolean checkBottleGripperState(){
	  return bo[3].hasGripper;
  }
  public void putGrippertoBottle(){
	  bo[2].hasGripper=true;
  }
  public Boolean checkCanMove(){
	  
	  System.out.println("bo[0]="+bo[0]+";bo[1]="+bo[1]+";bo[2]="+bo[2]+";bo[3]="+bo[3]+";bo[4]="+bo[4]);
	  
	  if(	(	(bo[1]!=null && bo[1].hasWater==false)	
			  || (bo[2]!=null && bo[2].hasCap==false)
			  || (bo[3]!=null && bo[3].hasGripper==false))
			  ||	(bo[0]==null&&bo[1]==null&&bo[2]==null&&bo[3]==null&&bo[4]==null)
		)
	  {
		  System.out.println("CAN NOTTTTTTTTTTTT   MOVE");
		  return false;
	  }else{
		  System.out.println("CAN >>>> MOVE");
		  return true;
	  }
  }
  public Bottle Move(){
	  System.out.println("MMMMMMOVE~~~~~~~");
	  bo[5]=bo[4];
	  bo[4]=bo[3];
	  bo[3]=bo[2];
	  bo[1]=bo[0];
	  bo[0]=null;
	  return bo[5];
  }
@Override
public void run() {
	 if(checkCanMove()==true){
		 Ltwo.putBottle(Move());
	 }
	 System.out.println("size now = "+Ltwo.queue.size());
	
}
}
