/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: Patient.java has all the methods to adjust patient info and display it. PatientDriver.java runs all of methods from main, procedure.java has all the info to set and display procedure info
 * Due: 03/01/2024
 * Platform/compiler: Java
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Logan Young
*/


public class PatientDriverApp {
	//create objects to be able to use
	Patient patient = new Patient("Jenny","Elaine","Santori","123 Main Street","MyTown","CA","01234","443-310-9100","Bill Santori", "777-555-1212");
	Procedure procedure1 = new Procedure();
	Procedure procedure2 = new Procedure("Jenny Elaine", "09/05/08");
	Procedure procedure3 = new Procedure("Jenny Elaine", "09/05/08", "Dr. Brother", 323);
	
	//main method to call actual statements to run the programs
	public static void main(String args[]) {
		PatientDriverApp test = new PatientDriverApp(); //makes new object to be able to use in static method
		test.displayPatient(test.patient); 
		test.displayProcedure(test.procedure1);
		test.displayProcedure(test.procedure2);
		test.displayProcedure(test.procedure3);
		
		
		double total = test.calculateTotalCharges(test.procedure1, test.procedure2, test.procedure3); //grabs the charges double value and adds up
		System.out.printf("Total Charges: $" + "%.2f", total); //displays total charges
		System.out.println();
		System.out.println();
		System.out.println("Student Name: Logan Young");
		System.out.println("MC#: M21195576");
		System.out.println("Due Date: 03/01/2024");
		
	}
	
	public void displayPatient(Patient patient) { 
		System.out.println("Patient info:");
		patient.tostring(); //displays patient info with tostring method

		
	}
	public void displayProcedure(Procedure procedure) {
		procedure.tostring(); //displays procedure stats
	}
	public double calculateTotalCharges(Procedure one, Procedure two, Procedure three) {
		double total;
		total = one.getCharges() + two.getCharges() + three.getCharges(); //adds together charges
		return total;
	}

}
