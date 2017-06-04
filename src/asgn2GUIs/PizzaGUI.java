package asgn2GUIs;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Restaurant.PizzaRestaurant;


/**
 * This class is the graphical user interface for the rest of the system. 
 * Currently it is a �dummy? class which extends JFrame and implements Runnable and ActionLister. 
 * It should contain an instance of an asgn2Restaurant.PizzaRestaurant object which you can use to 
 * interact with the rest of the system. You may choose to implement this class as you like, including changing 
 * its class signature ? as long as it  maintains its core responsibility of acting as a GUI for the rest of the system. 
 * You can also use this class and asgn2Wizards.PizzaWizard to test your system as a whole
 * 
 * 
 * @author Person A and Person B
 *
 */
public class PizzaGUI extends javax.swing.JFrame implements Runnable, ActionListener {
	
	private JFrame frame;
	ArrayList<String> pizza = new ArrayList<String>();
	ArrayList<String> customer = new ArrayList<String>();
	
	double totalDistance=0;
	double totalProfit=0;
	private PizzaRestaurant restaurant= new PizzaRestaurant();
	
	//set width and height for the window
	public static final int WIDTH = 1200;
	public static final int HEIGHT = 900;
	
	//set height for panels
	public static final int panelHEIGHT = 300;
	
	//log file chooser
	private JFileChooser logChooser = new JFileChooser();
	
	//Text areas to display logs and totals
	private JTextArea customers;
	private JTextArea pizzas;
	private JTextArea profit;
	private JTextArea distance;
	
	//create buttons
	
	private JButton loadFile;
	private JButton displayLogs;
	private JButton displayTotal;
	private JButton reset;
	
	//scrollable panes to display information of customers and pizzas
	
	JScrollPane customerScroll;
	JScrollPane pizzaScroll;
	
	
	/**
	 * Creates a new Pizza GUI with the specified title 
	 * @param title - The title for the supertype JFrame
	 */
	public PizzaGUI(String title) {
		super(title);
	}
	
	@Override
	public void actionPerformed(ActionEvent a){
		Object button = a.getSource();
		if(button==loadFile){
			int returnVal = logChooser.showOpenDialog(this);
			if(returnVal==JFileChooser.APPROVE_OPTION){
				File logFile = logChooser.getSelectedFile();
				System.out.println("Log file "+ logFile.getName()+" was selected");
				//if valid file was selected, process the log file and read lines
				try{
					String filename = logFile.getAbsolutePath();
					System.out.println(filename);
					if(restaurant.processLog(filename)){
						loadLogs();
						calculateTotal();
						displayLogs.setEnabled(true);
						displayTotal.setEnabled(true);
						reset.setEnabled(true);
					}
				} catch (CustomerException|PizzaException|LogHandlerException e){
					e.printStackTrace();
				}
			}
			else {
				System.out.println("Opening log file unsuccessful");
			}
		}
		if(button==displayLogs){
			showLogs();
		}
		if(button==displayTotal){
			showTotal();
		}
		if(button==reset){
			reset();
			customers.setText("");
			pizzas.setText("");
		}
		
		
	}
	
	private void loadLogs() throws PizzaException, CustomerException{
		
		//clear logs first in order to load strings
		customer.clear();
		pizza.clear();
		
		for(int customerIndex=0;customerIndex<restaurant.getNumCustomerOrders();customerIndex++){
			customer.add("Customer Name: "+restaurant.getCustomerByIndex(customerIndex).getName()+"\n"
			+"Mobile Number: "+restaurant.getCustomerByIndex(customerIndex).getMobileNumber()+"\n"
			+"Customer Type: "+restaurant.getCustomerByIndex(customerIndex).getCustomerType()+"\n"
			+"X Location: "+restaurant.getCustomerByIndex(customerIndex).getLocationX()+"\n"
			+"Y Location: "+restaurant.getCustomerByIndex(customerIndex).getLocationY()+"\n"
			+"Delivery Distance: "+restaurant.getCustomerByIndex(customerIndex).getDeliveryDistance()+"\n"
			+"\n");
		}
		
		for(int pizzaIndex=0;pizzaIndex<restaurant.getNumPizzaOrders();pizzaIndex++){
			pizza.add("type - " + restaurant.getPizzaByIndex(pizzaIndex).getPizzaType() + "\n"
			+ "Quantity - " + restaurant.getPizzaByIndex(pizzaIndex).getQuantity() + "\n"
			+ "Order Price - " + restaurant.getPizzaByIndex(pizzaIndex).getOrderPrice() + "\n"
			+ "Order Cost - " + restaurant.getPizzaByIndex(pizzaIndex).getOrderCost() + "\n"
			+ "Profit - " + restaurant.getPizzaByIndex(pizzaIndex).getOrderProfit() + "\n" 
			+ "\n");
		}
	}
	
	private void showLogs(){
		//show in columns
		pizzas.setColumns(pizza.size());
		customers.setColumns(customer.size());
		
		for(String index: pizza){
			pizzas.append(index);
		}
		for(String index: customer){
			customers.append(index);
		}
	}
	
	private void showTotal(){
		profit.setText("Total Profit: $"+totalProfit);
		distance.setText("Total Distance: "+totalDistance);
	}
	
	private void calculateTotal() throws PizzaException, CustomerException{
		totalDistance = 0;
		totalProfit = 0;
		for(int customerIndex=0;customerIndex<restaurant.getNumCustomerOrders();customerIndex++){
			totalDistance += restaurant.getCustomerByIndex(customerIndex).getDeliveryDistance();
		}
		for(int pizzaIndex=0;pizzaIndex<restaurant.getNumPizzaOrders();pizzaIndex++){
			totalProfit += restaurant.getPizzaByIndex(pizzaIndex).getOrderProfit();
		}
	}
	
	private void reset(){
		//clear the list of customers,pizzas as well as texts
		pizza.clear();
		pizzas.setText("");
		customer.clear();
		customers.setText("");
		totalDistance = 0;
		totalProfit = 0;
		//disable buttons until another file is loaded
		displayLogs.setEnabled(false);
		displayTotal.setEnabled(false);
		reset.setEnabled(false);
	}
	
	
	private void createGUI(){
		frame = new JFrame();
		frame.setBounds(0, 0, 1000, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(12, 10, 200, 692);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		loadFile = new JButton("Load Log FIle");
		loadFile.setBounds(12, 10, 176, 35);
		loadFile.addActionListener(this);
		panel.add(loadFile);
		
		displayLogs = new JButton("Display Logs");
		displayLogs.setBounds(12, 55, 176, 35);
		displayLogs.addActionListener(this);
		panel.add(displayLogs);
		
		displayTotal = new JButton("Calculate Total");
		displayTotal.setBounds(12, 100, 176, 35);
		displayTotal.addActionListener(this);
		panel.add(displayTotal);
		
		reset = new JButton("Reset");
		reset.setBounds(12, 145, 176, 35);
		reset.addActionListener(this);
		panel.add(reset);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(12, 190, 176, 492);
		panel.add(textArea);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(224, 10, 748, 692);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new CompoundBorder());
		panel_2.setBounds(12, 10, 724, 250);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblCustomerLogs = new JLabel("Customer Logs");
		lblCustomerLogs.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		lblCustomerLogs.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerLogs.setBounds(12, 0, 700, 45);
		panel_2.add(lblCustomerLogs);
		
		JScrollPane customerScroll = new JScrollPane();
		customerScroll.setBounds(12, 55, 700, 185);
		panel_2.add(customerScroll);
		
		customers = new JTextArea();
		customers.setEditable(false);
		customerScroll.setViewportView(customers);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new CompoundBorder());
		panel_3.setBounds(12, 270, 724, 250);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblPizzaLogs = new JLabel("Pizza Logs");
		lblPizzaLogs.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		lblPizzaLogs.setHorizontalAlignment(SwingConstants.CENTER);
		lblPizzaLogs.setBounds(12, 0, 700, 45);
		panel_3.add(lblPizzaLogs);
		
		JScrollPane pizzaScroll = new JScrollPane();
		pizzaScroll.setBounds(12, 58, 700, 182);
		panel_3.add(pizzaScroll);
		
		pizzas = new JTextArea();
		pizzas.setEditable(false);
		pizzaScroll.setViewportView(pizzas);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new CompoundBorder());
		panel_4.setBounds(12, 530, 724, 152);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		distance = new JTextArea();
		distance.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		distance.setEditable(false);
		distance.setBounds(12, 10, 700, 58);
		panel_4.add(distance);
		
		profit = new JTextArea();
		profit.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		profit.setEditable(false);
		profit.setBounds(12, 84, 700, 58);
		panel_4.add(profit);
		
		displayLogs.setEnabled(false);
		displayTotal.setEnabled(false);
		reset.setEnabled(false);
		
		
		frame.setVisible(true);
	}
	
	@Override
	public void run() {
		createGUI();
	}


}
