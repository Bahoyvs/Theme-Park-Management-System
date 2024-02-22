package HasA_Customer;

public class Group {
	
	 private int numOfPpl;
	 
	 public void setNumOfPpl(int numOfPpl) {
		this.numOfPpl = numOfPpl;
	}

	public Group() {
	 }

	
	 
	 public double calcGroupDisc(){
	        if(numOfPpl>=5)
	        	if(numOfPpl >= 19)
	        		return 95;
	        	else
	        		return (numOfPpl - 5) * 2;
	        else
	        return 0;
	 }

	public int getNumOfPpl() {
		// TODO Auto-generated method stub
		return numOfPpl;
	}
}
