package gameboard;

import common.GlassPane;
import common.LocateOfTile;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
	* Main class for Scrabble game
	* @author Arnaud Morel <a.morel@hotmail.com>, Bernard <bernard.debecker@gmail.com>, R. FONCIER <ro.foncier@gmail.com>
	*/
public class Scrabble {
    
		private JFrame frame;
		private Container contentPane;
		private GameBoard gameBoard;
		private Rack rack;
		private GameGrid gameGrid;
		private JPanel rackBackground, mainPanel, sidePanel;
		private Shade shadeTile;
		private SideMenu sideMenu;

		public Scrabble()  {
				frame = new JFrame("Scrabble");
				gameBoard = new GameBoard();
				rack = new Rack();
				gameGrid = new GameGrid();
				shadeTile = new Shade();
				sideMenu = new SideMenu();
				LocateOfTile locateOfTile = new LocateOfTile(shadeTile);
				// ShadeTile.setVisibleShade(1, false);
				rackBackground = new RackBackground();
				initContainer();
				initFrame();
		}

		private void initContainer() {
				contentPane =  frame.getContentPane() ;
				contentPane.setLayout(new BorderLayout());
				mainPanel = new JPanel();
				mainPanel.setLayout(null);
    mainPanel.add(gameBoard, 0);
    mainPanel.add(rackBackground, 0);
    mainPanel.add(rack, 0);
				mainPanel.add(shadeTile, 0);
    mainPanel.add(gameGrid, 0);
				contentPane.add(mainPanel, 0);
    contentPane.setVisible(true);
				sidePanel = SideMenu.getPanel();
				contentPane.add(sidePanel, BorderLayout.EAST);
		}
		
		private void initFrame() {
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(gameBoard.getWidth() + gameBoard.getInsets().left+gameBoard.getInsets().right+15 + 450, 850);
				frame.setContentPane(contentPane);
				frame.setGlassPane(GlassPane.getInstance());
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
		}

		/**
		  * @param args the command line arguments
		  */
		public static void main(String[] args) {
				javax.swing.SwingUtilities.invokeLater(new Runnable() {
				
						@Override
						public void run() {
								Scrabble scrabble = new Scrabble();
						}
				});
		}
}