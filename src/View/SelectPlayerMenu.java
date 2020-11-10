package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class SelectPlayerMenu extends JDialog {

	private JPanel selectPlayerMenu;
	private JLabel selectPlayerMenuLabel;

	private JButton twoPlayersBT;
	private JButton threePlayersBT;
	private JButton fourPlayersBT;
	private JButton fivePlayersBT;
	private JButton sixPlayersBT;
	private JButton backBT;

	/**
	 * The constructor with one parameter
	 * 
	 * @param main the main view
	 */
	public SelectPlayerMenu(RiskView main) {
		super(main);
		setTitle("Player Select Menu");
		setSize(300, 300);
		setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);

		JPanel border = new JPanel(new BorderLayout());
		border.setBorder(new EmptyBorder(2, 3, 2, 3));
		JPanel borderLayout = new JPanel(new GridBagLayout());
		borderLayout.setBorder(new EmptyBorder(5, 5, 5, 5));
		selectPlayerMenu = new JPanel();
		selectPlayerMenu.setLayout(new GridLayout(10, 1, 10, 6));

		selectPlayerMenuLabel = new JLabel("Select the number of Players:");

		twoPlayersBT = new JButton("2 Players");
		threePlayersBT = new JButton("3 Players");
		fourPlayersBT = new JButton("4 Players");
		fivePlayersBT = new JButton("5 Players");
		sixPlayersBT = new JButton("6 Players");
		backBT = new JButton("Back");

		twoPlayersBT.setActionCommand("twoPlayersSelected");
		threePlayersBT.setActionCommand("threePlayersSelected");
		fourPlayersBT.setActionCommand("fourPlayersSelected");
		fivePlayersBT.setActionCommand("fivePlayersSelected");
		sixPlayersBT.setActionCommand("sixPlayersSelected");
		backBT.setActionCommand("backButtonSelected");

		selectPlayerMenu.add(selectPlayerMenuLabel);
		selectPlayerMenu.add(twoPlayersBT);
		selectPlayerMenu.add(threePlayersBT);
		selectPlayerMenu.add(fourPlayersBT);
		selectPlayerMenu.add(fivePlayersBT);
		selectPlayerMenu.add(sixPlayersBT);
		selectPlayerMenu.add(backBT);

		borderLayout.add(selectPlayerMenu);
		border.add(borderLayout, BorderLayout.CENTER);

		add(border);

		setLocationRelativeTo(null);

	}

	/**
	 * The action listener for the class
	 * 
	 * @param listener the action listener for the class
	 */
	public void addActionListeners(ActionListener listener) {
		twoPlayersBT.addActionListener(listener);
		threePlayersBT.addActionListener(listener);
		fourPlayersBT.addActionListener(listener);
		fivePlayersBT.addActionListener(listener);
		sixPlayersBT.addActionListener(listener);
		backBT.addActionListener(listener);
	}

}
