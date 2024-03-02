
public class Procedure {
	private String procedureName;
	private String procedureDate;
	private String procedureDoc;
	private double procedureCharges;
	public Procedure() {
		procedureName = "";
		procedureDate = "";
		procedureDoc = "";
		procedureCharges = 0;
	}
	public Procedure(String name1, String date1) {
		procedureName = name1;
		procedureDate = date1;
	}
	public Procedure(String name, String date, String doc, double charges) {
		procedureName = name;
		procedureDate = date;
		procedureDoc = doc;
		procedureCharges = charges;
	}
	public String getName() {
		return procedureName;
	}
	public String getDate() {
		return procedureDate;
	}
	public String getDoc() {
		return procedureDoc;
	}
	public double getCharges() {
		return procedureCharges;
	}
	public void setName(String word) {
		procedureName = word;
	}
	public void setDate(String word) {
		procedureDate = word;
	}
	public void setDoc(String word) { 
		procedureDoc = word;
	}
	public void setCharges(double word) {
		procedureCharges = word;
	}
	public void tostring() {
		System.out.println();
		System.out.printf("        %s%n", "Procedure: " + procedureName);
		System.out.printf("        %s%n", "ProcedureDate: " + procedureDate);
		System.out.printf("        %s%n","Practitioner=" + procedureDoc);
		System.out.printf("        %s%n%n", "Charge: " + procedureCharges);
		
		
	}

}
