package cis5200.project6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 * CIS5200-W01
 * Project 6, Exercise 26.9, Calculator GUI
 * Justin Burden
 *
 * @author Justin Burden
 */
public class CalculatorFrame extends JFrame {
    
    private final JLabel resultsLabel;
    private final JPanel buttonPanel;
    private final GridLayout buttonGridLayout;
    private final String[] buttonNames = { "7", "8", "9", "/",
            "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+" };
    
    public CalculatorFrame() {
        super("Calculator");
                 
        JPanel contentPanel = new JPanel();
        Border padding = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        contentPanel.setBorder(padding);
        setContentPane(contentPanel);
        
        // JLabel
        resultsLabel = new JLabel("");
        resultsLabel.setBackground(Color.WHITE);
        resultsLabel.setBorder(new LineBorder(new Color(112, 189, 204), 3));
        resultsLabel.setMinimumSize(new Dimension(280, 35));
        resultsLabel.setPreferredSize(new Dimension(280, 35));
        resultsLabel.setOpaque(true);
        resultsLabel.add(Box.createHorizontalStrut(15));
        contentPanel.add(resultsLabel, BorderLayout.NORTH);
        
        // Button panel
        buttonPanel = new JPanel();
        buttonGridLayout = new GridLayout(4, 4, 5, 5);
        buttonPanel.setLayout(buttonGridLayout);
        
        addButtons(buttonNames, buttonPanel);
        
        contentPanel.add(buttonPanel, BorderLayout.CENTER);
    }
    
    private void addButtons(String[] buttonNames, JPanel panel) {
        for (String buttonName : buttonNames) {
            JButton button = new JButton(buttonName);
            button.setMinimumSize(new Dimension(65, 48));
            button.setPreferredSize(new Dimension(65, 48));
            panel.add(button);
        }
    }
}
