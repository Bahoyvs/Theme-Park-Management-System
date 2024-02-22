package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MainandSystemClass.ThemeParkSys;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.ChangeListener;

import HasA_Customer.Customer;
import HasA_Customer.Group;

import javax.swing.event.ChangeEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField Name;
	private JTextField Height;
	private JTextField Weight;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private boolean hasGroup;
	private boolean wellness;
	JSlider slider = new JSlider();
	MainGUI mg = new MainGUI();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer Information");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 426, 46);
		contentPane.add(lblNewLabel);
		
		Name = new JTextField();
		Name.setBounds(140, 88, 96, 20);
		contentPane.add(Name);
		Name.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(37, 91, 49, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Age");
		lblNewLabel_1_1.setBounds(37, 120, 49, 14);
		contentPane.add(lblNewLabel_1_1);
		
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Height");
		lblNewLabel_1_1_1.setBounds(37, 151, 49, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		Height = new JTextField();
		Height.setColumns(10);
		Height.setBounds(140, 148, 96, 20);
		contentPane.add(Height);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Weight");
		lblNewLabel_1_1_2.setBounds(37, 179, 49, 14);
		contentPane.add(lblNewLabel_1_1_2);
		
		Weight = new JTextField();
		Weight.setColumns(10);
		Weight.setBounds(140, 176, 96, 20);
		contentPane.add(Weight);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Group Size");
		lblNewLabel_1_1_3.setBounds(35, 240, 82, 14);
		contentPane.add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("Wellness");
		lblNewLabel_1_1_4.setBounds(35, 268, 49, 14);
		contentPane.add(lblNewLabel_1_1_4);
		
		JSpinner Age = new JSpinner();
		Age.setBounds(140, 117, 96, 20);
		contentPane.add(Age);
		
		JSpinner GroupCNT = new JSpinner();
		GroupCNT.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				slider.setValue(Integer.parseInt(GroupCNT.getValue().toString()));
			}
		});
		GroupCNT.setBounds(348, 237, 62, 20);
		contentPane.add(GroupCNT);
		
		
		
		slider.setPaintTicks(true);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				GroupCNT.setValue(slider.getValue());
				if(slider.getValue() == 0) {
					hasGroup = false;
				}else {
					hasGroup = true;
					
				}
				//ThemeParkSys.ch.getG().setNumOfPpl(slider.getValue());
				
			}
		});
		slider.setValue(0);
		slider.setSnapToTicks(true);
		slider.setMaximum(20);
		slider.setBounds(138, 240, 200, 19);
		contentPane.add(slider);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("True");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wellness = true;
			}
		});
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(138, 264, 69, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnFalse = new JRadioButton("False");
		rdbtnFalse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wellness = false;
			}
		});
		buttonGroup.add(rdbtnFalse);
		rdbtnFalse.setBounds(225, 264, 69, 23);
		contentPane.add(rdbtnFalse);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Status");
		lblNewLabel_1_1_2_1.setBounds(37, 215, 49, 14);
		contentPane.add(lblNewLabel_1_1_2_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"None", "Student", "Teacher"}));
		comboBox.setBounds(140, 207, 154, 22);
		
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Customer temp;
				
				temp = new Customer(Name.getText(), Integer.parseInt(Age.getValue().toString()) ,Double.parseDouble(Height.getText()), Double.parseDouble(Weight.getText()), comboBox.getSelectedItem().toString(), slider.getValue(), wellness, 0.0);
				ThemeParkSys.setCh(temp);
				
				//textField.setText(ThemeParkSys.getCh() + "");
				
				mg.setVisible(true);
				MainGUI.updateGUI();
				dispose();
			}
		});
		btnNewButton.setBounds(147, 529, 89, 23);
		contentPane.add(btnNewButton);
		
		
		
		
		
		
		
		
	}
}
