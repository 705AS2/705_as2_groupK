public class MainProcessor implements Runnable{
	private String signal ="";
	private boolean runningFlag = true;
	private BFSystem bfSystem;
	private RoundC roundC;
	
	public synchronized String getSignal() {
		return signal;
	}

	public synchronized void setSignal(String signal) {
		System.out.println("set to:"+signal);
		this.signal = signal;
	}

	public void run() {
		bfSystem = new BFSystem();
		Thread systemThread = new Thread(bfSystem); 
		
		roundC = bfSystem.getRound();
		Thread roundCThread = new Thread(roundC); 
		
		while (runningFlag){	
			try {
				synchronized(this){
					System.out.println("begin sleep");
				    setSignal("time to put bottles and check all status ");
				    systemThread.run();
					Thread.sleep((long)(Math.random()*10000));
				    System.out.println("end sleep");
				}
		    } catch (InterruptedException e) { 
		     Thread.interrupted(); 
		    }
			try {
				synchronized(this){
					System.out.println("-- start working ----");
					setSignal("operate the RoundC container and move bottles");
				    Thread.sleep((long)(Math.random()*10000));
				    //roundC change array
				    roundCThread.run();
				    System.out.println("-- end working ----");
				}
		    } catch (InterruptedException e) { 
		     Thread.interrupted(); 
		    }
		}
	}

	public static void main(String[] args){
		MainProcessor mp = new MainProcessor();
		Thread test = new Thread(mp); 
		test.run();
	}
}
