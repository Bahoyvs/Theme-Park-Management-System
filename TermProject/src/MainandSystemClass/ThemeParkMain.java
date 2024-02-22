package MainandSystemClass;


import GUI.LoginPage;


public class ThemeParkMain {

	public static void main(String[] args) {
		//implementation will be with the GUI part.
		//customer classes and its methods need GUI to be implemented
		
		System.out.println(ThemeParkSys.getCh());
		LoginPage mg = new LoginPage();
		mg.setVisible(true);
		
		
		
		
	}

}
