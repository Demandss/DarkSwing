package su.demands.darkswing.elements.scrollPane;

import su.demands.darkswing.DarkSwingColors;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class DarkScrollBar extends JScrollBar {

    public DarkScrollBar(int orientation, int value, int extent, int min, int max) {
        super(orientation, value, extent, min, max);

        setBackground(DarkSwingColors.ELEMENTS_BACKGROUND);
        setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = DarkSwingColors.ELEMENTS_BACKGROUND;
                this.trackColor = getBackground();
            }

            @Override
            protected JButton createDecreaseButton(int orientation) {
                JButton button = super.createDecreaseButton(orientation);
                button.setBackground(DarkSwingColors.ELEMENTS_BACKGROUND);
                button.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.decode("#346BD8")));
                return button;
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                JButton button = super.createDecreaseButton(orientation);
                button.setBackground(DarkSwingColors.ELEMENTS_BACKGROUND);
                button.setBorder(BorderFactory.createMatteBorder(1,0,0,0,Color.decode("#346BD8")));
                return button;
            }
        });
    }

    public DarkScrollBar(int orientation) {
        this(orientation, 0, 10, 0, 100);
    }

    public DarkScrollBar() {
        this(VERTICAL);
    }
}
