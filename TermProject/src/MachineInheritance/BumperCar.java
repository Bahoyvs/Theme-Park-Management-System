package MachineInheritance;

public class BumperCar extends Machines{
	
	public int speedLimit;

	public BumperCar(String machineName, int machineId, double ticketPrice,int duration,int adrenalin,int speedLimit){
	    super(machineName, machineId, ticketPrice,duration, adrenalin);
	    this.speedLimit=speedLimit;
	}

	public String toString(){
	    return super.toString()+"\nSpeed Limit: "+speedLimit;
	}

}
