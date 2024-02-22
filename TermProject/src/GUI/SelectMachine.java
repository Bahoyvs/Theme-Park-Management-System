package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import HasA_Customer.Customer;
import MachineInheritance.Machines;
import MainandSystemClass.ThemeParkSys;
import HasA_Customer.Customer;

import javax.swing.ListSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;



public class SelectMachine extends JFrame {

	
	
	private HashSet<Machines> mh = ThemeParkSys.getMachSet();
	private String photoName = null;
	private JTextField textField;
	private ArrayList<Machines> MC = new ArrayList<>();


	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectMachine frame = new SelectMachine();
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
	
	
		

	public SelectMachine() {
		
		
		JTable table = new JTable();
		String[] columns =
		{"ID", "Machine Name", "Image", "Ticket Price", "Duration", "Adrenalin Score"};
		Object[] row = new Object[6];
		
		
		DefaultTableModel model = new DefaultTableModel();
		
		setBounds(100, 100, 1178,767);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		model.setColumnIdentifiers(columns);
		table.setModel(model) ;
		table.setBackground(Color. white) ;
		table.setForeground(Color. black) ;
		table.setSelectionBackground(Color. red) ;
		table.setGridColor(Color. red) ;
		table.setSelectionForeground(Color. white) ;
		table.setFont(new Font("Tahoma",Font.PLAIN,17));
		table.setRowHeight(75) ;
		table.setAutoCreateRowSorter(true);
		table.setDefaultEditor(Object.class, null);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getColumnModel().getColumn(2).setCellRenderer(new ImageRenderer());
		
		JScrollPane pane = new JScrollPane(table);
		pane.setForeground (Color. RED);
		pane.setBackground (Color. WHITE);
		pane.setBounds(38, 63, 739, 427);
		getContentPane() . add (pane);
		
		JLabel IImage = new JLabel("");
		ImageIcon img = new ImageIcon(new ImageIcon("src/images/"+photoName+".png").getImage().getScaledInstance(10,10,Image.SCALE_AREA_AVERAGING));
		IImage.setIcon(img);
		IImage.setBounds(787, 397, 367, 322);
		getContentPane().add(IImage);
		
		
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				photoName = table.getModel().getValueAt(table.getSelectedRow(), 1).toString();
				textField.setText(photoName);
				IImage.setIcon(new ImageIcon("src/images/"+photoName+".png"));
				
				
			}
		});
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(858, 362, 222, 37);
		getContentPane().add(textField);
		textField.setColumns(10);
		

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(787, 63, 254, 288);
		getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
	
		
		JButton btnReadFile = new JButton("Read From File");
		btnReadFile.setFont(new Font("X-Files", Font.PLAIN, 16));
		btnReadFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThemeParkSys.readFromFile();
				int i = 0;
				for(Machines a : mh) {
					
					row[0] = a.getMachineId();
					row[1] = a.getMachineName();
					row[2] = a.getMachineName();
					row[3] = a.getTicketPrice();
					row[4] = a.getDuration();
					row[5] = a.getAdrenalin();
					
					model.addRow(row);
					
				}
				
				btnReadFile.setEnabled(false);
			}
		});
		
		
		
		
		JButton btnAddMachine = new JButton("Add Machine");
		btnAddMachine.setFont(new Font("X-Files", Font.PLAIN, 16));
		btnAddMachine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mName = table.getModel().getValueAt(table.getSelectedRow(), 1).toString();
				int mID = Integer.parseInt(table.getModel().getValueAt(table.getSelectedRow(), 0).toString());
				double mPrice = Double.parseDouble(table.getModel().getValueAt(table.getSelectedRow(), 3).toString());
				int mDura = Integer.parseInt(table.getModel().getValueAt(table.getSelectedRow(), 4).toString());
				int mAdr = Integer.parseInt(table.getModel().getValueAt(table.getSelectedRow(), 5).toString());
				
				if(ThemeParkSys.ch.addMachine(mName, mID, mPrice, mDura, mAdr)) {
					textArea.setText(ThemeParkSys.ch.getMachineChoice().toString());
				}else {
					textArea.setText("Your NOT Eligible");
				}
				MainGUI.updateGUI();
			}
		});
		btnAddMachine.setBounds(57, 544, 307, 65);
		getContentPane().add(btnAddMachine);
		btnReadFile.setBounds(445, 544, 307, 65);
		getContentPane().add(btnReadFile);
		
		JButton btnNewButton_1 = new JButton("<- Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(10, 11, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		
	}
}
