package Comparator;

import java.util.Comparator;

import MachineInheritance.Machines;

public class MachineAdrenalinComparator implements Comparator<Machines>{

	@Override
	public int compare(Machines o1, Machines o2) {
		// TODO Auto-generated method stub
		return o1.getMachineName().compareTo(o2.getMachineName());
	}

}
