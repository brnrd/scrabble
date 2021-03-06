package client.views.swing.menu;

import client.views.swing.common.ImageIconTools;
import client.views.swing.gameboard.Game;
import client.views.swing.gameboard.GameBoard;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

/**
 *
 * @author Bernard <bernard.debecker@gmail.com>
 */
public class Settings extends JDialog {

    private static final String PATH_MEDIA = "/media/";
    private static final String MODERN_PATH = "modern_grid.png";
    private static final String MODERN_ICON_PATH = "modern_gb_icon.png";
    private static final String VINTAGE_PATH = "vintage_grid.png";
    private static final String VINTAGE_ICON_PATH = "vintage_gb_icon.png";
    private static final String LIGHT_PATH = "light_bg_icon.png";
    private static final String DARK_PATH = "dark_bg_icon.png";
    private static final String DARKER_PATH = "darker_bg_icon.png";
    private static final String DARKEST_PATH = "darkest_bg_icon.png";
    private static final String BLACK_PATH = "black_bg_icon.png";
    
    private Game game;
    private Menu menu;
    private JPanel backgroundPanel, gameboardPanel;
    private JRadioButton lightRadioButton, darkRadioButton, darkerRadioButton,
            darkerstRadioButton, blackRadioButton, vintageRadioButton,
            modernRadioButton;

    private Settings(JFrame frame) {
        super(frame, "Settings", true);
        this.setSize(450, 120);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setBackground(Color.WHITE);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        initComponents();
    }

    public Settings(Game game, Menu menu) {
        this(null);
        this.game = game;
        this.menu = menu;
    }

    private void initComponents() {
        initBackgroundPanel();
        initGameboardPanel();
        add(backgroundPanel, BorderLayout.EAST);
        add(gameboardPanel, BorderLayout.WEST);
    }

    private void initBackgroundPanel() {
        backgroundPanel = new JPanel();
        backgroundPanel.setOpaque(false);
        backgroundPanel.setSize(220, 60);
        backgroundPanel.setBorder(BorderFactory.createTitledBorder("Background"));
        lightRadioButton = new JRadioButton(new ImageIcon(ImageIconTools.
                createImageIcon(PATH_MEDIA + LIGHT_PATH, null).
                getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH)));
        lightRadioButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                game.changeBackground(Game.TYPE_LIGHT);
                menu.setIcons(false);
            }
        });
        backgroundPanel.add(lightRadioButton);
        darkRadioButton = new JRadioButton(new ImageIcon(ImageIconTools.
                createImageIcon(PATH_MEDIA + DARK_PATH, null).
                getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH)));
        darkRadioButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                game.changeBackground(Game.TYPE_DARK);
                menu.setIcons(false);
            }
        });
        backgroundPanel.add(darkRadioButton);
        darkerRadioButton = new JRadioButton(new ImageIcon(ImageIconTools.
                createImageIcon(PATH_MEDIA + DARKER_PATH, null).
                getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH)));
        darkerRadioButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                game.changeBackground(Game.TYPE_DARKER);
                menu.setIcons(false);
            }
        });
        backgroundPanel.add(darkerRadioButton);
        darkerstRadioButton = new JRadioButton(new ImageIcon(ImageIconTools.
                createImageIcon(PATH_MEDIA + DARKEST_PATH, null).
                getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH)));
        darkerstRadioButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                game.changeBackground(Game.TYPE_DARKEST);
                menu.setIcons(true);
            }
        });
        backgroundPanel.add(darkerstRadioButton);
        blackRadioButton = new JRadioButton(new ImageIcon(ImageIconTools.
                createImageIcon(PATH_MEDIA + BLACK_PATH, null).
                getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH)));
        blackRadioButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                game.changeBackground(Game.TYPE_BLACK);
                menu.setIcons(true);
            }
        });
        backgroundPanel.add(blackRadioButton);
    }

    private void initGameboardPanel() {
        gameboardPanel = new JPanel();
        gameboardPanel.setOpaque(false);
        gameboardPanel.setSize(220, 60);
        gameboardPanel.setBorder(BorderFactory.createTitledBorder("Gameboard"));
        vintageRadioButton = new JRadioButton(new ImageIcon(ImageIconTools.
                createImageIcon(PATH_MEDIA + VINTAGE_ICON_PATH, null).
                getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH)));
        vintageRadioButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                game.changeGameBoard(GameBoard.TYPE_VINTAGE);
            }
        });
        gameboardPanel.add(vintageRadioButton);
        modernRadioButton = new JRadioButton(new ImageIcon(ImageIconTools.
                createImageIcon(PATH_MEDIA + MODERN_ICON_PATH, null).
                getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH)));
        modernRadioButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                game.changeGameBoard(GameBoard.TYPE_MODERN);
            }
        });
        gameboardPanel.add(modernRadioButton);
    }

    public void showSettings() {
        this.setVisible(true);
    }
}
