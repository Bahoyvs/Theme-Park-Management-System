package MachineInheritance;

public class Carousel extends Machines{
	
	public int seatLimit;
	public Carousel(String machineName, int machineId, double ticketPrice,int duration,int adrenalin,int seatLimit){
	    super(machineName, machineId, ticketPrice, duration, adrenalin);
	    this.seatLimit=seatLimit;
	}
	public String toString(){
	    return super.toString()+"\nSeat Limit: "+seatLimit;
	}

}
