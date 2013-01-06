package views.swing.menu;

import controller.MenuController;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import views.MenuView;
import views.swing.common.EmailValidator;
import views.swing.common.ImageIconTools;
import views.swing.gameboard.Blah;

/**
 *
 * @author Bernard <bernard.debecker@gmail.com>, R. FONCIER <ro.foncier@gmail.com>
 */
public class Menu extends MenuView {
		
		private static JPanel panel;
		private JButton PlayAsGuestButton, LoginButton, SignupButton, QuitButton;
		
		private JButton playerButton, scrabbleButton, gameBoardButton, scoreTestButton,
										addWordButton;
		private JPopupMenu popUpOnMenu, popUpOffMenu;
		private JMenuItem logIn, signUp, logOff, helpOn, helpOff;
		private JTextField emailField;
		private JLabel score;
		private String email;
		private JPasswordField passwordField;
		private char[] password;
		private EmailValidator emailValidator;
		private boolean playerIsLogged = false;
		private boolean debug = true;

		public Menu(MenuController controller)	{
				super(controller);
				buildMenu();
		}
		
		private void buildMenu() {
				panel = new JPanel();
				panel.setLayout(null);
				panel.setBounds(700, 0, 300, 800);
				panel.setOpaque(false);
				initComponent();
				setVisible(true);
		}

		private void initComponent() {
				initPlayAsGuestButton();
				initLoginButton();
				initSignupButton();
				initQuitButton();
				panel.add(PlayAsGuestButton);
				panel.add(LoginButton);
				panel.add(SignupButton);
				panel.add(QuitButton);
				panel.validate();
		}
		
		private void initPlayAsGuestButton() {
				PlayAsGuestButton = new JButton("Play As Guest");
				PlayAsGuestButton.setBounds(panel.getWidth()/2-80, 200, 160, 30);
				PlayAsGuestButton.addActionListener(new AbstractAction() {

						@Override
						public void actionPerformed(ActionEvent e) {
								// Call controller
						}
				});
				PlayAsGuestButton.setVisible(true);
		}
		
		private void initLoginButton() {
				LoginButton = new JButton("Log In");
				LoginButton.setBounds(panel.getWidth()/2-80, 250, 160, 30);
				LoginButton.addActionListener(new AbstractAction() {

						@Override
						public void actionPerformed(ActionEvent e) {
								// Call controller
						}
				});
				LoginButton.setVisible(true);
		}
		
		private void initSignupButton() {
				SignupButton = new JButton("Sign Up");
				SignupButton.setBounds(panel.getWidth()/2-80, 300, 160, 30);
				SignupButton.addActionListener(new AbstractAction() {

						@Override
						public void actionPerformed(ActionEvent e) {
								// Call controller
						}
				});
				SignupButton.setVisible(true);
		}
		
		private void initQuitButton() {
				QuitButton = new JButton("Quit");
				QuitButton.setBounds(panel.getWidth()/2-80, 350, 160, 30);
				QuitButton.addActionListener(new AbstractAction() {

						@Override
						public void actionPerformed(ActionEvent e) {
								// Call controller
						}
				});
				QuitButton.setVisible(true);
		}
		
		/*
		public Menu(GameBoard gameBoard, Rack rack) {
				this();
				this.gameBoard = gameBoard;
				this.rack = rack;
		}

		private void initComponent() {
				emailValidator = new EmailValidator();
				initPopupOnMenu();
				initPopupOffMenu();
				initPlayerButton();
				initScoreLabel();
				initScrabbleButton();
				initGameBoardButton();
				initAddWordButton();
				panel.add(playerButton);
				panel.add(scrabbleButton);
				panel.add(gameBoardButton);
				panel.add(addWordButton);
				if (debug) {
						scoreTestButton = new JButton("inc score");
						scoreTestButton.setBounds(panel.getWidth()- 100, 100, 100,	25);
						scoreTestButton.addActionListener(new AbstractAction() {

								@Override
								public void actionPerformed(ActionEvent e) {
										incScore();
								}
						});
						panel.add(scoreTestButton);
				}
				panel.add(score);
		}*/
		
		private void initPopupOnMenu() {
				popUpOnMenu = new JPopupMenu();
				emailField = new JTextField("Email");
				emailField.setPreferredSize(new Dimension(150,20));
				emailField.addFocusListener(new FocusListener() {
						
						@Override
						public void focusGained(FocusEvent e) {
								if (emailField.getText().equals("Email")) {
										emailField.setText("");
								}
						}
						
						@Override
						public void focusLost(FocusEvent e) {
								if (emailField.getText().equals("")) {
										emailField.setText("Email");
								}
						}
				});
				
				passwordField = new JPasswordField("Password");
				passwordField.setPreferredSize(new Dimension(150,20));
				
				logIn = new JMenuItem(new AbstractAction("Log in") {
						
						@Override
						public void actionPerformed(ActionEvent e) {
								logInSignUp();
						}
				});
				
				signUp = new JMenuItem(new AbstractAction("Sign Up") {
						
						@Override
						public void actionPerformed(ActionEvent e) {
								logInSignUp();
						}
				});
				
				helpOn = new JMenuItem(new AbstractAction("Help") {
						
						@Override
						public void actionPerformed(ActionEvent e) {
								JOptionPane.showMessageDialog(null, Blah.HELP_ON, "Help", JOptionPane.INFORMATION_MESSAGE);
						}
				});
								
				popUpOnMenu.add(emailField);
				popUpOnMenu.add(passwordField);
				popUpOnMenu.add(logIn);
				popUpOnMenu.add(signUp);
				popUpOnMenu.add(helpOn);
		}
		
		private void initPopupOffMenu() {
				popUpOffMenu = new JPopupMenu();
				logOff = new JMenuItem(new AbstractAction("Log off") {
						
						@Override
						public void actionPerformed(ActionEvent e) {
								resetPlayer();
						}
				});
				
				helpOff = new JMenuItem(new AbstractAction("Help") {
						
						@Override
						public void actionPerformed(ActionEvent e) {
								JOptionPane.showMessageDialog(null, Blah.HELP_OFF, "Help", JOptionPane.INFORMATION_MESSAGE);
						}
				});
				
				popUpOffMenu.add(logOff);
				popUpOffMenu.add(helpOff);
		}
		
		/*** Methods used for login, sign up or logout ***/
		private void logInSignUp() {
				email = emailField.getText();
				password = passwordField.getPassword();
				if (EmailValidator.validate(email)) {
						playerButton.setIcon(ImageIconTools.getGravatar(email));
						if (/*call log in player*/true) {
								playerIsLogged = true;
						} else {
								JOptionPane.showMessageDialog(null, "Error, please try again.", 
																"Error", JOptionPane.ERROR_MESSAGE);
						}
				} else {
						JOptionPane.showMessageDialog(null, email + "is not a valid "
														+ "email address", "Incorrect email", JOptionPane.ERROR_MESSAGE);
				}
		}
		
		private void resetPlayer() {
				playerButton.setIcon(ImageIconTools.getGravatar("default@gravatar.logo"));
				emailField.setText("Email");
				passwordField.setText("aaaaaa");
				playerIsLogged = false;
		}
		
		/*** ***/
		
		private void initPlayerButton() {
				playerButton = new JButton();
				playerButton.setPreferredSize(new Dimension(80,80));
				playerButton.setBounds(panel.getWidth()-80, 1, 80, 80);
				playerButton.setIcon(ImageIconTools.getGravatar("default@gravatar.logo"));
				playerButton.addMouseListener(new MouseAdapter() {
						@Override
						public void mousePressed(MouseEvent e) {
								if (playerIsLogged) {
										popUpOffMenu.show(e.getComponent(), playerButton.getX()-202, playerButton.getY()+79);
								} else {
										popUpOnMenu.show(e.getComponent(), playerButton.getX()-292, playerButton.getY()+79);
								}
								
//								popupMenu.show(e.getComponent(), playerButton.getX(), playerButton.getY());
						}
				});
		}
		
		private void initScoreLabel() {
				score = new JLabel("000");
				score.setBounds(panel.getWidth()-160, 24, 80, 80);
				Font font = null;
				try {
						font = Font.createFont(Font.TRUETYPE_FONT, new File(Menu.class.getResource("media/DS-DIGI.ttf").toURI()));
				} catch (FontFormatException | IOException | URISyntaxException ex) {
						Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
				}
				font = font.deriveFont(Font.PLAIN, 48);
				score.setFont(font);
				score.setForeground(Color.BLACK);
		}
		
		private void initScrabbleButton() {
				scrabbleButton = new JButton(ImageIconTools.createImageIcon("media/Scrabble.png","Scrabble"));
				scrabbleButton.setPreferredSize(new Dimension(190,102));
				scrabbleButton.addActionListener(new AbstractAction() {

						@Override
						public void actionPerformed(ActionEvent e) {
								JOptionPane.showMessageDialog(null, Blah.ABOUT, "About", JOptionPane.INFORMATION_MESSAGE);
						}
				});
				scrabbleButton.setBounds(panel.getWidth()/2-95, panel.getHeight()-103, 190, 102);
				scrabbleButton.setBackground(Color.WHITE);
				scrabbleButton.setBorder(null);
		}
		
		private void initGameBoardButton() {
				gameBoardButton = new JButton("Modern");
				gameBoardButton.setBounds(10, 10, 90, 20);
				gameBoardButton.addActionListener(new AbstractAction() {

						@Override
						public void actionPerformed(ActionEvent e) {
								//gameBoard.changeGameBoard();
						}
				});
		}
		
		private void initAddWordButton() {
				addWordButton = new JButton("Add word");
				addWordButton.setBounds(panel.getWidth()/2-50, panel.getHeight()-140, 100, 30);
				addWordButton.addActionListener(new AbstractAction() {

						@Override
						public void actionPerformed(ActionEvent e) {
//								call the add word method on the controller
								setAddWordVisible(false);
						}
				});
				addWordButton.setVisible(false);
		}
		
		public static void setVisible(boolean visible) {
				panel.setVisible(visible);
		}
		
		public JPanel getPanel() {
				return panel;
		}
		
	 public void incScore() {
				int tempScore = Integer.parseInt(score.getText());
				tempScore++;
				if (tempScore < 10) {
						score.setText("00"+String.valueOf(tempScore));
				} else if	(tempScore < 100) {
						score.setText("0"+String.valueOf(tempScore));
				} else{
						score.setText(String.valueOf(tempScore));
				}
		}
		
		public void setScore(int score) {
				if (score < 10) {
						this.score.setText("00"+String.valueOf(score));
				} else if	(score < 100) {
						this.score.setText("0"+String.valueOf(score));
				} else{
						this.score.setText(String.valueOf(score));
				}
		}
		
		public void setAddWordVisible(boolean visibility) {
				addWordButton.setVisible(visibility);
		}
		
		public boolean isAddWordVisible() {
				return addWordButton.isVisible();
		}
}