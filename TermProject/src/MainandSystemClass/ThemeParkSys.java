package MainandSystemClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.TreeSet;

import Comparator.MachineAdrenalinComparator;
import HasA_Customer.Customer;
import MachineInheritance.BumperCar;
import MachineInheritance.Carousel;
import MachineInheritance.FerrisWheel;
import MachineInheritance.Frisbee;
import MachineInheritance.Machines;
import MachineInheritance.Ranger;
import MachineInheritance.RollerCoaster;

public class ThemeParkSys {

	private static HashSet<Machines> machSet = new HashSet();
	public static Customer ch = new Customer();
	
	public static boolean readFromFile() {

		try {
			Scanner input = new Scanner(new File("ThemeParkMachines.txt"));
			input.useLocale(Locale.US);
			
			
			while(input.hasNext()) {
				
				Machines m = null;
				
				String mtype = input.next();	
				String mname = input.next();
				int mid = input.nextInt();
				int dur = input.nextInt();
				double tprice = input.nextDouble();
				int adr = input.nextInt();
				
				int speedlim;	 
				int seatlim;	
				int spincnt;	
				
				
				if(mtype.equalsIgnoreCase("RollerCoaster")) {
					speedlim = input.nextInt();
					m = new RollerCoaster(mname, mid, tprice, dur, adr, speedlim);
				}
				
				else if(mtype.equalsIgnoreCase("BumperCar")) {
					speedlim = input.nextInt();
					m = new BumperCar(mname, mid, tprice, dur, adr, speedlim);
				}
				
				else if(mtype.equalsIgnoreCase("FerrisWheel")) {
					seatlim = input.nextInt();
					m = new FerrisWheel(mname, mid, tprice, dur, adr, seatlim);
				}
				
				else if(mtype.equalsIgnoreCase("Carousel")) {
					seatlim = input.nextInt();
					m = new Carousel(mname, mid, tprice, dur, adr, seatlim);
				}
				
				else if(mtype.equalsIgnoreCase("Ranger")) {
					spincnt = input.nextInt();
					m = new Ranger(mname, mid, tprice, dur, adr, spincnt);
				}
				
				else if(mtype.equalsIgnoreCase("Frisbee")) {
					spincnt = input.nextInt();
					m = new Frisbee(mname, mid, tprice, dur, adr, spincnt);
				}
				
				machSet.add(m);
			}
			
			input.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	
	public static Customer getCh() {
		return ch;
	}

	public static void setCh(Customer ch) {
		ThemeParkSys.ch = ch;
	}

	
	public static boolean addMachines(String machineType, int machineId, double ticketPrice, int duration, int adrenalin, int speedLimit,int seatLimit, int spinCount) {
		
		if(machineType.equalsIgnoreCase("RollerCoaster")) {
			return machSet.add(new RollerCoaster(machineType, machineId, ticketPrice, duration, adrenalin, speedLimit));
		}
		
		else if(machineType.equalsIgnoreCase("BumperCar")) {
			return machSet.add(new BumperCar(machineType, machineId, ticketPrice, duration, adrenalin, speedLimit));
		}
		
		else if(machineType.equalsIgnoreCase("FerrisWheel")) {
			return machSet.add(new FerrisWheel(machineType, machineId, ticketPrice, duration, adrenalin, seatLimit));
		}
		
		else if(machineType.equalsIgnoreCase("Carousel")) {
			return machSet.add(new Carousel(machineType, machineId, ticketPrice, duration, adrenalin, seatLimit));
		}
		
		else if(machineType.equalsIgnoreCase("Ranger")) {
			return machSet.add(new Ranger(machineType, machineId, ticketPrice, duration, adrenalin, spinCount));
		}
		
		else {
			return machSet.add(new Frisbee(machineType, machineId, ticketPrice, duration, adrenalin, spinCount));
		}
	}
	
	/*public static Machines searchMachines(int machineId) {
		
		for(Machines m : machSet) {
			if(m.getMachineId() == machineId) {
				return m;
			}
		}
		
		return null;
	}*/
	
	/*public static String displayMachines() {
		
		TreeSet<Machines> ts = new TreeSet();
		
		String op = "";
		
		ts.addAll(machSet);
		
		for(Machines m : ts) {
			op += m.toString() + "\n";
		}
		
		return op;
	}*/
	
	
	
	public static HashSet<Machines> getMachSet() {
		return machSet;
	}


	/*public static String displayMachinesByAdrenalin () {
		

		
		TreeSet<Machines> ts = new TreeSet(new MachineAdrenalinComparator());
		
		String op = "";
		
		ts.addAll(machSet);
		
		for(Machines m: ts) {
			op += m.toString() + "\n";
		}
		
		return op;
	}*/
}
