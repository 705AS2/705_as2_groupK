import java.io.IOException;


public class BFSystem implements Runnable{
	private Conveyor Lone = new Conveyor();
	private RoundC round = new RoundC();
	
	public synchronized RoundC getRound() {
		return round;
	}

	public synchronized void setRound(RoundC round) {
		this.round = round;
	}

	public void run() {
		try {
			System.out.println("..begin working ..");
			Lone.putNewBottle();

			System.out.println("..put bottle ..");
		    if(Lone.Checkqueue()!=null && round.checkRoundCanRecieve()==null){

				System.out.println(">>>>>>>>>>>>>>true ..");
				 round.getBottlefromLConveyor(Lone.popBottle());
				 System.out.println(Lone.queue.size());
			 }

			System.out.println("------------------------------------------");

			System.out.println("..check water ..");
		    if(round.checkFillingWaterBottle()!=null){
				 if(round.checkBottleWaterState()==false){
					 round.putWatertoBottle();
				 }
			 }

			System.out.println("..check lip ..");
			 if(round.checkPutCapBottle()!=null){
				 if(round.checkBottleCapState()==false){
					 round.putCaptoBottle();
				 }
			 }

				System.out.println("..gripper ..");
			 if(round.checkGripperBottle()!=null){
				 if(round.checkBottleGripperState()==false){
					 round.putGrippertoBottle();
				 }
			 }

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


//	Controller c;
//	Conveyor Lone,Ltwo;
//	RoundC round;
//	Integer n[],i;
//	//Bottle b;
//	public void runSystem() throws IOException
//	{
//		for(;;){//can get signal from controller for any time
//		String signal=c.getSignal();
//		for(i=0;signal.equals('s');i++)//start belt to run
//		{
//		 Lone.putNewBottle();
//		 n[i]=i;//record the number of bottle
//		 if(Lone.Checkqueue()!=null && round.checkRoundCanRecieve()==null){
//			 round.getBottlefromLConveyor(Lone.popBottle());
//		 }
//		 if(round.checkFillingWaterBottle()!=null){
//			 if(round.checkBottleWaterState()==false){
//				 round.putWatertoBottle();
//			 }
//		 }
//		 if(round.checkPutCapBottle()!=null){
//			 if(round.checkBottleCapState()==false){
//				 round.putCaptoBottle();
//			 }
//		 }
//		 if(round.checkGripperBottle()!=null){
//			 if(round.checkBottleGripperState()==false){
//				 round.putGrippertoBottle();
//			 }
//		 }
//		 if(round.checkCanMove()==true){
//			 Ltwo.putBottle(round.Move());
//		 }
//		}
//		if(signal.equals('q')){//quit to put bottle in belt
//			
//		}
//		}
//	}
//	 public static void main(String[] args) throws Exception 
//		{
//			
//	        BFSystem s = new BFSystem();
//	        s.runSystem();//run the bottle filling system,but still waiting for controller signal 
//		}
}
