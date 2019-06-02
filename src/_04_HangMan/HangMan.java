package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	JLabel lives = new JLabel();
	int livesInt = 10;
	Stack<String> words = new Stack<String>();
	Utilities util = new Utilities();
	ArrayList<String> wordLength = new ArrayList<String>();
	String currentWord = words.pop();

	public static void main(String[] args) {
		HangMan hangman = new HangMan();

		hangman.initialize();

	}

	public void initialize() {

		frame.addKeyListener(this);
		frame.setSize(500, 100);
		frame.setPreferredSize(frame.getSize());
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		panel.add(label);
		panel.add(lives);
		frame.add(panel);

		String asdf = JOptionPane.showInputDialog("Pick a number from 1 to 266");
		int numberOfWordsChosen = Integer.parseInt(asdf);
		String liveCount = Integer.toString(livesInt);
		
		

		for (int i = 0; i < numberOfWordsChosen; i++) {
			words.push(util.readRandomLineFromFile("dictionary.txt"));
		}

		for (int i = 0; i < currentWord.length(); i++) {
			
			wordLength.add(i, Character.toString(currentWord.charAt(i)));
		}

		label.setText(wordLength.toString());
		lives.setText("Lives: " + liveCount);
	

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
