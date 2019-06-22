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
	String liveCount = Integer.toString(livesInt);
	String currentWord;
	Stack<String> words = new Stack<String>();
	Utilities util = new Utilities();
	ArrayList<String> wordLength = new ArrayList<String>();
	ArrayList<String> wordDisplayed = new ArrayList<String>();
	String[] wordDisplayedArray;

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

		String asdf = JOptionPane
				.showInputDialog("How many words would you like to guess? (Pick a number from 1 - 266)");
		int numberOfWordsChosen = Integer.parseInt(asdf);

		for (int i = 0; i < numberOfWordsChosen; i++) {
			words.push(util.readRandomLineFromFile("dictionary.txt"));
		}

		currentWord = words.pop();

		wordDisplayedArray = new String[currentWord.length()];

		for (int i = 0; i < currentWord.length(); i++) {

			wordLength.add(i, Character.toString(currentWord.charAt(i)));

			wordDisplayedArray[i] = " _ ";

			wordDisplayed.add(i, " _ ");
		}

		label.setText(wordDisplayed.toString());
		lives.setText("Lives: " + liveCount + currentWord);

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

		for (int i = 0; i < wordLength.size(); i++) {

			if (Character.toString(e.getKeyChar()).equals(wordLength.get(i))) {
				System.out.println("asdf");

				for (int a = 0; a < wordLength.size(); a++) {

					if (Character.toString(e.getKeyChar()).equals(wordLength.get(a))) {

						wordDisplayedArray[a] = Character.toString(e.getKeyChar());

						wordDisplayed.clear();

						for (int x = 0; x < wordLength.size(); x++) {

							wordDisplayed.add(x, wordDisplayedArray[x]);

						}

						label.setText(wordDisplayed.toString());
					}
				}
			}
		}
		
		for (int i = 0; i < wordLength.size(); i++) {
			if (!Character.toString(e.getKeyChar()).equals(wordLength.get(i))) {

				livesInt--;
				liveCount = Integer.toString(livesInt);
				lives.setText("Lives: " + liveCount + currentWord);
				if (livesInt <= 0) {
					JOptionPane.showMessageDialog(null, "You lost!");
				}
				break;
			}
		}
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
