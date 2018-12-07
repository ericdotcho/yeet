//imported libraries
import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

@SuppressWarnings("serial")
//JFrame, JTextField and  imported from javax.swing.*;
public class BenkeiLunch extends JFrame {

private Container contents; //container and FlowLayout both imported from java.awt.*;
//components used in this GUI
private JLabel name, courseNum, welcome, prompt, tempUdon, tuna, salmon, yellowtail, caliRolls, spicyRolls, sodas, beers, waters;
private JLabel chargeDrinks, chargeSubtotal, chargeService, totalBill;
private JTextField numTempUdon, numTuna, numSalmon, numYellowtail, numCaliRolls, numSpicyRolls, numSodas, numBeers, numWaters;
private JButton compute;

	public BenkeiLunch() {
		//title of window says "Benkei Sushi Lunch Menu"
		super("Benkei Sushi Lunch Menu");

		contents = getContentPane();
		contents.setLayout(new FlowLayout());

		name = new JLabel("Programmer: Eric Cho | ");
		courseNum = new JLabel("CMPT 220 | ");
		welcome = new JLabel("Welcome To Benkei Sushi | Lunch Menu | ");
		prompt = new JLabel("Enter number of orders for each product; 0 if none");

		tempUdon = new JLabel("Tempura Udon: $11.00");
		tempUdon.setForeground(Color.BLUE);
		numTempUdon = new JTextField(2);
	
		tuna = new JLabel("Tuna: $3.00");
		tuna.setForeground(Color.BLUE);
		numTuna = new JTextField(2);
	
		salmon = new JLabel("Salmon: $2.50");
		salmon.setForeground(Color.BLUE);
		numSalmon = new JTextField(2);
	
		yellowtail = new JLabel("Yellowtail: $3.50");
		yellowtail.setForeground(Color.BLUE);
		numYellowtail = new JTextField(2);
		
		caliRolls = new JLabel("California Rolls: $6.00");
		caliRolls.setForeground(Color.BLUE);
		numCaliRolls = new JTextField(2);
		
		spicyRolls = new JLabel("Spicy Rolls: $8.00");
		spicyRolls.setForeground(Color.BLUE);
		numSpicyRolls = new JTextField(2);
			
		sodas = new JLabel("Sodas: $2.50");
		sodas.setForeground(Color.BLUE);
		numSodas = new JTextField(2);

		beers = new JLabel("Beers: $3.00");
		beers.setForeground(Color.BLUE);
		numBeers = new JTextField(2);

		waters = new JLabel("Waters: $2.00");
		waters.setForeground(Color.BLUE);
		numWaters = new JTextField(2);

		chargeDrinks = new JLabel("Drinks = $");
		chargeSubtotal = new JLabel("Subtotal = $");
		chargeService = new JLabel("Service and Taxes (16%) = $");
		totalBill= new JLabel("Total Bill = $");

		chargeDrinks = new JLabel("Drinks: ?");
		chargeSubtotal = new JLabel("Subtotal: ?");
		chargeService = new JLabel("Service and Taxes (16%): ?");
		totalBill = new JLabel("Total Bill: ?");
	
		compute = new JButton("Calculate Bill"); //button to compute bill
// adds all contents in container
		contents.add(name);
		contents.add(courseNum);
		contents.add(welcome);
		contents.add(prompt);
		contents.add(tempUdon);
		contents.add(numTempUdon);
		contents.add(tuna);
		contents.add(numTuna);
		contents.add(salmon);
		contents.add(numSalmon);
		contents.add(yellowtail);
		contents.add(numYellowtail);
		contents.add(caliRolls);
		contents.add(numCaliRolls);
		contents.add(spicyRolls);
		contents.add(numSpicyRolls);
		contents.add(sodas);
		contents.add(numSodas);
		contents.add(beers);
		contents.add(numBeers);	
		contents.add(waters);
		contents.add(numWaters);
		contents.add(chargeDrinks);
		contents.add(chargeSubtotal);
		contents.add(chargeService);
		contents.add(totalBill);
		contents.add(chargeDrinks);
		contents.add(chargeSubtotal);
		contents.add(chargeService);
		contents.add(totalBill);
		contents.add(compute);

	ButtonHandler bh = new ButtonHandler(); 

	compute.addActionListener(bh); //actionListener imported from java.awt.event.*;
	
	setSize(950,350); //setting size of the GUI window (width,height)

	setVisible(true); //reveals components by making components visible

}
private class ButtonHandler implements ActionListener {

@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {

		try {
			double one = Double.parseDouble(numTuna.getText());
			double two = Double.parseDouble(numSalmon.getText());
			double three = Double.parseDouble(numYellowtail.getText());
			double four = Double.parseDouble(numCaliRolls.getText());
			double five = Double.parseDouble(numSpicyRolls.getText());
			double six = Double.parseDouble(numTempUdon.getText());
			double d1 = Double.parseDouble(numSodas.getText());
			double d2 = Double.parseDouble(numBeers.getText());
			double d3 = Double.parseDouble(numWaters.getText());

// Methods/Calculations used for determining total price of bill

			double drinks = (d1 * 2.50) + (d2 * 3.00) + (d3 * 2.00);
			double orderAmount = ((one * 3.00) + (two * 2.50) + (three * 3.50) + (four * 6.00) + (five * 8.00) + (six * 11.00) + drinks);
			double serviceAmount = (orderAmount) * .16;
			double totalAmount = (orderAmount + serviceAmount + drinks);

// Now to display the charges

			chargeDrinks.setText("Drinks: " + new Double(drinks).toString());
			chargeSubtotal.setText(" | Subtotal: " + new Double(orderAmount).toString());
			chargeService.setText(" | Service and Taxes: " + new Double(serviceAmount).toString());
			totalBill.setText(" | Total Bill: " + new Double(totalAmount).toString());
			}
//tells user to enter number when a textfield is accidentally left blank
		catch(NumberFormatException ex) {
			
			numTuna.setText("Enter Number");
			numTempUdon.setText("Enter Number");	
			numYellowtail.setText("Enter Number");
			numCaliRolls.setText("Enter Number");
			numSpicyRolls.setText("Enter Number");
			numWaters.setText("Enter Number");
			numBeers.setText("Enter Number");
			numSodas.setText("Enter Number");
			numSalmon.setText("Enter Number");
			totalBill.setText("Total: ???");
		}
	}
}
//main class
public static void main(String[] args) {

BenkeiLunch rest = new BenkeiLunch();

rest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exits program completely when window is closed

	}
}