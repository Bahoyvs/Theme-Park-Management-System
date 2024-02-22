package MachineInheritance;

import java.util.Objects;

import HasA_Customer.Customer;

public class Machines implements Comparable<Machines>{
	
	private String machineName;
	private int machineId;
	private double ticketPrice;
	private int duration;
	private int adrenalin;
	
	
	
	

	public Machines(String machineName, int machineId, double ticketPrice, int duration, int adrenalin) {
		this.setMachineName(machineName);
		this.machineId = machineId;
		this.ticketPrice = ticketPrice;
		this.duration = duration;
		this.adrenalin = adrenalin;
	}

	public int getMachineId() {
		return machineId;
	}

	public void setMachineId(int machineId) {
		this.machineId = machineId;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getAdrenalin() {
		return adrenalin;
	}

	public void setAdrenalin(int adrenalin) {
		this.adrenalin = adrenalin;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 29 * hash + this.machineId;
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Machines other = (Machines) obj;
		return machineId == other.machineId;
	}
	
	public String toString() {
		return  "\nmachine name= " + machineName +
				"\nmachine id= " + machineId +
				"\nticket price= " + ticketPrice +
				"\nduration= " + duration +
				"\nadrenalin= " + adrenalin;
	}

	@Override
	public int compareTo(Machines o) {
		// TODO Auto-generated method stub
		return this.machineId - o.getMachineId();
	}

	public String getMachineName() {
		return machineName;
	}

	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}
}
