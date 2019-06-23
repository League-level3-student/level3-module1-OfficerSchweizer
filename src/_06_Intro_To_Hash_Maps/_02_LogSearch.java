package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {

	HashMap<Integer, String> list = new HashMap<Integer, String>();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton add = new JButton();
	JButton search = new JButton();
	JButton view = new JButton();
	JButton remove = new JButton();

	/*
	 * Crate a HashMap of Integers for the keys and Strings for the values. Create a
	 * GUI with three buttons. Button 1: Add Entry When this button is clicked, use
	 * an input dialog to ask the user to enter an ID number. After an ID is
	 * entered, use another input dialog to ask the user to enter a name. Add this
	 * information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID When this button is clicked, use an input dialog to
	 * ask the user to enter an ID number. If that ID exists, display that name to
	 * the user. Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List When this button is clicked, display the entire list in a
	 * message dialog in the following format: ID: 123 Name: Harry Howard ID: 245
	 * Name: Polly Powers ID: 433 Name: Oliver Ortega etc...
	 * 
	 * When this is complete, add a fourth button to your window. Button 4: Remove
	 * Entry When this button is clicked, prompt the user to enter an ID using an
	 * input dialog. If this ID exists in the HashMap, remove it. Otherwise, notify
	 * the user that the ID is not in the list.
	 *
	 */
	public static void main(String[] args) {
		_02_LogSearch asdf = new _02_LogSearch();
		asdf.initialize();
	}

	public void initialize() {

		add.addActionListener(this);
		search.addActionListener(this);
		view.addActionListener(this);
		remove.addActionListener(this);

		add.setText("Add");
		search.setText("Search");
		view.setText("View");
		remove.setText("Remove");

		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		panel.add(add);
		panel.add(search);
		panel.add(view);
		panel.add(remove);
		frame.add(panel);
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == add) {
			String IDAddedString = JOptionPane.showInputDialog("Enter an ID number");
			String nameAdded = JOptionPane.showInputDialog("Enter a name for that ID number");
			int IDAddedint = Integer.parseInt(IDAddedString);

			list.put(IDAddedint, nameAdded);

		}

		if (e.getSource() == view) {
			// JOptionPane.showMessageDialog(null, message);

			for (Integer ID : list.keySet()) {
				System.out.print("ID: " + ID);
				System.out.print(", name: " + list.get(ID));
				System.out.println();
			}
		}

		if (e.getSource() == search) {

			String nameSearchedString = JOptionPane
					.showInputDialog("Enter the ID of the person you would like to search for");
			int nameSearchedint = Integer.parseInt(nameSearchedString);

			if (list.containsKey(nameSearchedint)) {
				JOptionPane.showMessageDialog(null, "The person with that ID number is: " + list.get(nameSearchedint));
			} else {
				JOptionPane.showMessageDialog(null, "There is no one with that ID number");
			}
		}

		if (e.getSource() == remove) {
			String IDRemovedString = JOptionPane
					.showInputDialog("Enter the ID of the person you want to remove from the roster");
			int IDRemovedint = Integer.parseInt(IDRemovedString);

			if (list.containsKey(IDRemovedint)) {
				list.remove(IDRemovedint);
			} else {
				JOptionPane.showMessageDialog(null, "There is no one with that ID number");
			}
		}
	}
}
