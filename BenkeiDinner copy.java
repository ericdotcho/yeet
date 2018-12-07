import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

@SuppressWarnings("serial")
public class BenkeiDinner extends JFrame {
private Container contents;

//Benkei dinner menu does not include yellowtail, but offer Japanese dinner platters

private JLabel name, coursenum, welcome, prompt, chickTeri, shrimpTeri, beefTeri, tempUdon, tuna, salmon, caliRolls, spicyRolls, sodas, waters, beers;
private JLabel chargeDrinks, chargeSubtotal, chargeService, totalBill;
private JTextField numChickTeri, numShrimpTeri, numBeefTeri, numTempUdon, numTuna, numSalmon, numCaliRolls, numSpicyRolls, numSodas, numWaters, numBeers;
private JButton compute;

public BenkeiDinner() {
	//title of window says "Benkei Dinner Menu"
	super("Benkei Dinner Menu");
	contents = getContentPane();
	contents.setLayout(new FlowLayout());
	
	name = new JLabel("Programmer: Eric Cho | ");
	coursenum = new JLabel("CMPT 220 | ");
	welcome = new JLabel("Welcome To Benkei Sushi | Dinner Menu |");
	prompt = new JLabel("Enter number of orders for each product; 0 if none");
	
	chickTeri = new JLabel("Chicken Teriyaki: $12.50");
	chickTeri.setForeground(Color.BLUE);
	numChickTeri = new JTextField(2);
	
	shrimpTeri = new JLabel("Shrimp Teriyaki: $12.50");
	shrimpTeri.setForeground(Color.BLUE);
	numShrimpTeri = new JTextField(2);
	
	beefTeri = new JLabel("Beef Teriyaki: $12.50");
	beefTeri.setForeground(Color.BLUE);
	numBeefTeri = new JTextField(2);
	
	tempUdon = new JLabel("Tempura Udon: $11.00");
	tempUdon.setForeground(Color.BLUE);
	numTempUdon = new JTextField(2);
	
	tuna = new JLabel("Tuna: $3.00");
	tuna.setForeground(Color.BLUE);
	numTuna = new JTextField(2);

	salmon = new JLabel("Salmon: $2.50");
	salmon.setForeground(Color.BLUE);
	numSalmon = new JTextField(2);

	caliRolls = new JLabel("California Rolls: $6.50");
	caliRolls.setForeground(Color.BLUE);
	numCaliRolls = new JTextField(2);

	spicyRolls = new JLabel("Spicy Rolls: $8.50");
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

	compute = new JButton("Calculate Bill");

	contents.add(name);
	contents.add(coursenum);
	contents.add(welcome);
	contents.add(prompt);
	contents.add(chickTeri);
	contents.add(numChickTeri);
	contents.add(shrimpTeri);
	contents.add(numShrimpTeri);
	contents.add(beefTeri);
	contents.add(numBeefTeri);
	contents.add(tempUdon);
	contents.add(numTempUdon);
	contents.add(tuna);
	contents.add(numTuna);
	contents.add(salmon);
	contents.add(numSalmon);
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

	compute.addActionListener(bh);

	setSize(900,250);

	setVisible(true);
	}

	private class ButtonHandler implements ActionListener {

@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e) {
			try {
				double one = Double.parseDouble(numTuna.getText());
				double two = Double.parseDouble(numSalmon.getText());
				double three = Double.parseDouble(numTempUdon.getText());
				double four = Double.parseDouble(numCaliRolls.getText());
				double five = Double.parseDouble(numSpicyRolls.getText());
				double ct = Double.parseDouble(numChickTeri.getText());
				double st = Double.parseDouble(numShrimpTeri.getText());
				double bt = Double.parseDouble(numBeefTeri.getText());
				double d1 = Double.parseDouble(numSodas.getText());
				double d2 = Double.parseDouble(numWaters.getText());
				double d3 = Double.parseDouble(numBeers.getText());

//Calculations/methods used for determining total price of bill

				double drinks = (d1 * 2.50) + (d2 * 2.00) + (d3 * 3.00);
				double orderAmount = ((12.50 * (ct + st + bt)) + (one * 3.00) + (two * 2.50) + (three * 11.00) + (four * 6.50) + (five * 8.50) + drinks);
				double serviceAmount = (orderAmount) * .16; //tax and service fee
				double totalAmount = (orderAmount + serviceAmount + drinks);

//Now to display the charges

				chargeDrinks.setText("Drinks: " + new Double(drinks).toString());
				chargeSubtotal.setText(" | Subtotal: " + new Double(orderAmount).toString());
				chargeService.setText(" | Service and Taxes: " + new Double(serviceAmount).toString());
				totalBill.setText(" | Total Bill: " + new Double(totalAmount).toString());
			}
			catch(NumberFormatException ex) {
				numTuna.setText("Enter Number");
				numShrimpTeri.setText("Enter Number");
				numBeefTeri.setText("Enter Number");
				numTempUdon.setText("Enter Number");	
				numChickTeri.setText("Enter Number");
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
		
	BenkeiDinner rest = new BenkeiDinner();
	
	rest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

