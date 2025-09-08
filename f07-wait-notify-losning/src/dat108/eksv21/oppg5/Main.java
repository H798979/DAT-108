package dat108.eksv21.oppg5;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {

		UtskriftsloopTraad printLoop = new UtskriftsloopTraad();
		printLoop.start();

		MeldingsboksTraad avbrytDialog = new MeldingsboksTraad(printLoop);
		avbrytDialog.start();
		
		System.out.println("Tråder er startet. Venter på at de er ferdige ...");
		
		printLoop.join();
		avbrytDialog.join();
		System.out.println("Begge tråder er ferdige!");
		
		System.out.println("Main-tråd ferdig!");
	}
}