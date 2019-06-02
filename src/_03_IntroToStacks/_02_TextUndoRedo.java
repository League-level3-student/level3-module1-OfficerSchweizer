package _03_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	String labelText = "";
	String lastText = "";
	Stack<Character> stack = new Stack<Character>();

	/*
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look
	 * like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character
	 * is erased from the JLabel. Save that deleted character onto a Stack of
	 * Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed,
	 * the top Character is popped off the Stack and added back to the JLabel.
	 * 
	 */

	public static void main(String[] args) {

		_02_TextUndoRedo asdf = new _02_TextUndoRedo();
		asdf.initialize();

	}

	void initialize() {

		frame.addKeyListener(this);
		frame.setSize(400, 50);
		frame.setPreferredSize(frame.getSize());
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		panel.add(label);
		frame.add(panel);

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			stack.push(e.getKeyChar());
			label.remove(label.toString().length());
		}
		
		if (e.getKeyCode() != KeyEvent.VK_BACK_SPACE) {
			lastText = label.getText();
			labelText = (lastText + e.getKeyChar());
		}
		
		
		label.setText(labelText);

				
		
		if (e.getKeyCode() == KeyEvent.VK_ALT) {
			
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
