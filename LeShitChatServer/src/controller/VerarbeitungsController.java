package controller;

public class VerarbeitungsController implements Runnable {
	
	public void run() {
		for(int i = 0; i<20;i++) {
			verarbeitung();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void verarbeitung() {
		System.out.println("Ich bin furchtbar beschäftigt" + this.toString());
	}
	
}
