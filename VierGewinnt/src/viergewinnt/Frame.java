package viergewinnt;

//
//import java.awt.GridBagConstraints;
//import java.awt.GridBagLayout;
//import java.awt.Insets;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.BoxLayout;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JTextField;
//
///**
// * Ich hhabe keiene Ahnung von JFrame ...
// * 
// * @author Anton Kesy
// *
// */
//public class Frame {
//	
//	public static void mainFrame() {
//		// Erstellung des Frames
//		JFrame frame = new JFrame();
//		frame.setTitle("n-Wins");
//		// GridBagLayout
//		JPanel mainPanel = new JPanel();
//		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
//
//		JPanel headingPanel = new JPanel();
//		JLabel headingLabel = new JLabel("n-Wins by PoorSkill");
//		headingPanel.add(headingLabel);
//
//		// GridBagLayout
//		JPanel panel = new JPanel(new GridBagLayout());
//		// Einschraenkungen des Layouts
//		GridBagConstraints constr = new GridBagConstraints();
//		constr.insets = new Insets(5, 5, 5, 5);
//		constr.anchor = GridBagConstraints.WEST;
//
//		// Einschraenkungen auf 0,0
//		constr.gridx = 0;
//		constr.gridy = 0;
//
//		// Deklarierung des benoetigten Labels
//		JLabel playerNameLabel = new JLabel("Spieler Name eingeben:");
//		JLabel countOfPlayersLabel = new JLabel("Anzahl von Spielern eingeben:");
//		JLabel languageLabel = new JLabel("Anzahl von Spielern eingeben:");
//		JLabel gamefieldSizeLabel = new JLabel("Anzahl von Spielern eingeben:");
//		JLabel playerCountLabel = new JLabel("Anzahl von Spielern eingeben:");
//
//		// Deklarierung der Text felder
//		JTextField playerNameTxt = new JTextField(20);
//		JTextField countOfPoints2WinTxt = new JTextField(20);
//		JTextField languageTxt = new JTextField(20);
//		JTextField gamefieldSizeTxt = new JTextField(20);
//		JTextField playerCountTxt = new JTextField(20);
//		JTextField firstTxt = new JTextField(20);
//		JTextField secondTxt = new JTextField(20);
//		JTextField thirdTxt = new JTextField(20);
//
//		panel.add(playerNameLabel, constr);
//		constr.gridx = 1;
//		panel.add(playerNameTxt, constr);
//		constr.gridx = 0;
//		constr.gridy = 1;
//
//		panel.add(countOfPlayersLabel, constr);
//		constr.gridx = 1;
//		panel.add(playerCountTxt, constr);
//		constr.gridx = 0;
//		constr.gridy = 2;
//
//		constr.gridwidth = 2;
//		constr.anchor = GridBagConstraints.CENTER;
//
//		// Button mit den Einstellungen
//		JButton buttonChangeRules = new JButton("Einstellungen");
//		// ActionListner
//		buttonChangeRules.addActionListener(new ActionListener() {
//
//			public void actionPerformed(ActionEvent e) {
//				panel.remove(countOfPlayersLabel);
//				headingLabel.setText("Einstellungen");
//				panel.add(languageLabel, constr);
//				constr.gridx = 1;
//				panel.add(playerNameTxt, constr);
//				constr.gridx = 0;
//				constr.gridy = 1;
//
//				panel.add(gamefieldSizeLabel, constr);
//				constr.gridx = 1;
//				panel.add(gamefieldSizeTxt, constr);
//				constr.gridx = 0;
//				constr.gridy = 2;
//
//				playerNameTxt.setText("Anzahl von Punkten zum Gewinnen");
//				firstTxt.setText("Sprache");
//				secondTxt.setText("Spielfeldgroesse");
//				thirdTxt.setText("Spieleranzahl");
//			}
//		});
//
//		// Button zum Spielstart
//		JButton buttonStartGame = new JButton("Starte Spiel");
//		// ActionListner
//		buttonStartGame.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				headingLabel.setText("n-Wins:");
//				firstTxt.setText("Sprache");
//				secondTxt.setText("Spielfeldgroesse");
//				thirdTxt.setText("Spieleranzahl");
//			}
//		});
//
//		// Add label and button to panel
//		panel.add(buttonChangeRules, constr);
//		panel.add(buttonStartGame, constr);
//
//		mainPanel.add(headingPanel);
//		mainPanel.add(panel);
//
//		// Add panel to frame
//		frame.add(mainPanel);
//		frame.pack();
//		frame.setSize(1000, 600);
//		frame.setLocationRelativeTo(null);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);
//	}
//}
