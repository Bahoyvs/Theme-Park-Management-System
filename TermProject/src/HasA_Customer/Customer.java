package HasA_Customer;

import java.util.ArrayList;

import Interface.TicketInterface;
import MachineInheritance.Machines;

public class Customer implements TicketInterface{

		private static ArrayList<Machines> machineChoice = new ArrayList<>();
		private Group g = new Group();
	 	private static String name;
	 	private int age;
		private double height;
		private double weight;
	  

		private String status;
	    private static int score=0;
	    private int sizeGroup;
	    private boolean wellness;
	    public double expenditure;

	    public Customer(){}

 	    
		public Customer( String name, int age, double height, double weight,
				String status, int sizeGroup, boolean wellness, double expenditure) {
			
			g.setNumOfPpl(sizeGroup);
			this.name = name;
			this.age = age;
			this.height = height;
			this.weight = weight;
			this.status = status;
			this.sizeGroup = sizeGroup;
			this.wellness = wellness;
			this.expenditure = expenditure;
			
		}

		



		public Group getG() {
			return g;
		}


		public void setG(Group g) {
			this.g = g;
		}


		public static String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public int getAge() {
			return age;
		}


		public void setAge(int age) {
			this.age = age;
		}


		public double getHeight() {
			return height;
		}


		public void setHeight(double height) {
			this.height = height;
		}


		public double getWeight() {
			return weight;
		}


		public void setWeight(double weight) {
			this.weight = weight;
		}


		public String getStatus() {
			return status;
		}


		public void setStatus(String status) {
			this.status = status;
		}


		public static int getScore() {
			return score;
		}


		public static void setScore(int score) {
			Customer.score = score;
		}


		public int getSizeGroup() {
			return sizeGroup;
		}


		public void setSizeGroup(int sizeGroup) {
			this.sizeGroup = sizeGroup;
		}


		public boolean isWellness() {
			return wellness;
		}


		public void setWellness(boolean wellness) {
			this.wellness = wellness;
		}


		public double getExpenditure() {
			return expenditure;
		}


		public void setExpenditure(double expenditure) {
			this.expenditure = expenditure;
		}


		public String toString(){
	        return "Name: "+name+
	                "\nYear: "+age+
	                "\nHeight: "+height+
	                "\nWeight: "+weight+
	                "\nStatus: "+status+
	                "\nWellness: "+wellness+
	                "\nScore: "+score+
	                "\nSizeAGroup: "+sizeGroup+
	                "\nExpenditure: "+expenditure;
	    }
	    
	public double calculateFinalPrice() {
			
			double p = 0.;

			for(Machines m : machineChoice) {
				p += m.getTicketPrice();
			}
			
			return addDiscount(p);
			
		}

		public ArrayList<Machines> getMachineChoice() {
			return machineChoice;
		}

		public void setMachineChoice(ArrayList<Machines> machineChoice) {
			this.machineChoice = machineChoice;
		}

		@Override
		public double addDiscount(double price) {
			
			if(status.equalsIgnoreCase("Student")) {
				price =(price * 85 / 100);
			}
			
			else if(status.equalsIgnoreCase("Teacher")) {
				price =(price * 95 / 100);
				
			}
			
			if(sizeGroup != 0)
			{
				//Group g = new Group();
				double discGroup=g.calcGroupDisc();
				if(discGroup!=0) {
					price =(price * (100 - discGroup) / 100);
				}
			}
			return price;
		}
		
		public boolean addMachine(String machineName, int machineId, double ticketPrice, int duration, int adrenalin) {
			Machines m = new Machines(machineName, machineId, ticketPrice, duration, adrenalin);
			if(!isEligible())
				return false;
			else
			{	
				score+=adrenalin;
				return machineChoice.add(m);
			}


		}
		
		public boolean isEligible() {
			
			if(height<150 || height>220 || weight<40 || weight >120)
				return false;
			else if(age<7 || age>90)
				return false;
			else if(wellness==false)
				return false;
			else if(score >= 20) 
				return false;
			return true;
		}
		
}
