package GUI;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

import HasA_Customer.Customer;
import MainandSystemClass.ThemeParkSys;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JProgressBar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainGUI extends JFrame {

	/**
	 * 
	 */
	private JPanel contentPane;
	private SelectMachine sc = new SelectMachine();
	static JTextArea textArea = new JTextArea();
	static JLabel AdrenalinTitle = new JLabel("Anderalin Score: ");
	static JProgressBar AdrenalinBAr = new JProgressBar();
	static JLabel WelcomeLabel = new JLabel("Welcome #########");
	private JTextField textField;
	static JLabel GroupSize = new JLabel("Group Size: ");
	static JLabel IImage = new JLabel("");
	private final JLabel lblNewLabel = new JLabel("Price: ");
	private final static JLabel alertBox = new JLabel("New label");
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI frame = new MainGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private class ImageRenderer extends DefaultTableCellRenderer{

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			// TODO Auto-generated method stub
			String photoName = value.toString();
			ImageIcon img = new ImageIcon(new ImageIcon("src/images/"+photoName+".png").getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT));
			return new JLabel(img);
			
		}
	}
	
	public static void updateGUI() {
		textArea.setText(ThemeParkSys.getCh().getMachineChoice().toString());
		WelcomeLabel.setText("Welcome " + ThemeParkSys.ch.getName());
		AdrenalinTitle.setText("Adrenalin Score: "+ ThemeParkSys.ch.getScore());
		AdrenalinBAr.setValue(ThemeParkSys.ch.getScore());
		GroupSize.setText("Group Size: "+ThemeParkSys.ch.getG().getNumOfPpl());
		IImage.setIcon(new ImageIcon("src/images/Background.png"));
		alertBox.setText("");
	}
	
	/**
	 * Create the frame.
	 */
	public MainGUI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Title = new JLabel("Theme Park System");
		Title.setFont(new Font("Tahoma", Font.BOLD, 30));
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setBounds(10, 11, 1476, 50);
		contentPane.add(Title);
		
		
		WelcomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		WelcomeLabel.setBounds(10, 72, 344, 50);
		contentPane.add(WelcomeLabel);
		
		
		
		AdrenalinBAr.setMaximum(20);
		AdrenalinBAr.setBounds(409, 113, 182, 21);
		contentPane.add(AdrenalinBAr);
		
		
		
		
		AdrenalinTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		AdrenalinTitle.setBounds(409, 87, 167, 23);
		contentPane.add(AdrenalinTitle);
		
		JButton btnNewButton = new JButton("Select Machine");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sc.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(1106, 92, 178, 94);
		contentPane.add(btnNewButton);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(1106, 327, 222, 284);
		contentPane.add(scrollPane);
		
		
		scrollPane.setViewportView(textArea);
		
		
		
		JButton btnNewButton_1 = new JButton("Refresh");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateGUI();
			}
		});
		btnNewButton_1.setBounds(10, 729, 89, 23);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(1172, 644, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Calculate");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double price = ThemeParkSys.ch.calculateFinalPrice();
				textField.setText(price +"");
				alertBox.setText("DISCOUNT APPLIED");
			}
		});
		btnNewButton_2.setBounds(1294, 643, 89, 23);
		contentPane.add(btnNewButton_2);
		
		
		GroupSize.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupSize.setBounds(672, 87, 167, 23);
		contentPane.add(GroupSize);
		
		
		ImageIcon img = new ImageIcon(new ImageIcon("src/images/Background.png").getImage().getScaledInstance(10,10,Image.SCALE_AREA_AVERAGING));
		IImage.setIcon(img);
		IImage.setBounds(31, 164, 967, 539);
		contentPane.add(IImage);
		lblNewLabel.setBounds(1113, 647, 49, 14);
		
		contentPane.add(lblNewLabel);
		alertBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		alertBox.setHorizontalAlignment(SwingConstants.CENTER);
		alertBox.setBounds(1113, 672, 270, 56);
		
		contentPane.add(alertBox);
		
	}
}
