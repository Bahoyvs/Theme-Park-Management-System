package MachineInheritance;

public class Frisbee extends Machines{
	
	public int spinCount;
	public Frisbee(String machineName, int machineId, double ticketPrice,int duration,int adrenalin,int spinCount){
	    super(machineName, machineId, ticketPrice,duration, adrenalin);
	    this.spinCount=spinCount;
	}
	public String toString(){
	    return super.toString() +"\nSpin Count: "+spinCount;
	}

}
