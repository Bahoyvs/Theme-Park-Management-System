package MachineInheritance;

public class RollerCoaster extends Machines{
	
	public int speedLimit;

	public RollerCoaster(String machineName, int machineId, double ticketPrice,int duration,int adrenalin,int speedLimit){
	    super(machineName, machineId, ticketPrice,duration, adrenalin);
	    this.speedLimit=speedLimit;
	}
	public String toString(){
	    return super.toString() +"\nSpeed Limit: "+speedLimit;
	}

}
