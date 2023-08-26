package su.demands.darkswing.elements.scrollPane;

import su.demands.darkswing.DarkSwingColors;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class DarkScrollPane extends JScrollPane {

    public DarkScrollPane(Component view, int vsbPolicy, int hsbPolicy) {
        super(view, vsbPolicy, hsbPolicy);

        setBackground(DarkSwingColors.FRAME_BACKGROUND);

        getVerticalScrollBar().setBorder(BorderFactory.createMatteBorder(0,1,0,0,DarkSwingColors.SUB_SELECT));
        getVerticalScrollBar().setBackground(DarkSwingColors.ELEMENTS_BACKGROUND);
        getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = DarkSwingColors.ELEMENTS_BACKGROUND;
                this.trackColor = getBackground();
            }

            @Override
            protected JButton createDecreaseButton(int orientation) {
                JButton button = super.createDecreaseButton(orientation);
                button.setBackground(DarkSwingColors.ELEMENTS_BACKGROUND);
                button.setBorder(BorderFactory.createMatteBorder(0,0,1,0,DarkSwingColors.SUB_SELECT));
                return button;
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                JButton button = super.createDecreaseButton(orientation);
                button.setBackground(DarkSwingColors.ELEMENTS_BACKGROUND);
                button.setBorder(BorderFactory.createMatteBorder(1,0,0,0,DarkSwingColors.SUB_SELECT));
                return button;
            }
        });

        getHorizontalScrollBar().setBorder(BorderFactory.createMatteBorder(0,1,0,0,DarkSwingColors.SUB_SELECT));
        getHorizontalScrollBar().setBackground(DarkSwingColors.ELEMENTS_BACKGROUND);
        getHorizontalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = DarkSwingColors.ELEMENTS_BACKGROUND;
                this.trackColor = getBackground();
            }

            @Override
            protected JButton createDecreaseButton(int orientation) {
                JButton button = super.createDecreaseButton(orientation);
                button.setBackground(DarkSwingColors.ELEMENTS_BACKGROUND);
                button.setBorder(BorderFactory.createMatteBorder(0,0,1,0,DarkSwingColors.SUB_SELECT));
                return button;
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                JButton button = super.createDecreaseButton(orientation);
                button.setBackground(DarkSwingColors.ELEMENTS_BACKGROUND);
                button.setBorder(BorderFactory.createMatteBorder(1,0,0,0,DarkSwingColors.SUB_SELECT));
                return button;
            }
        });
    }

    public DarkScrollPane(Component view) {
        this(view, VERTICAL_SCROLLBAR_AS_NEEDED, HORIZONTAL_SCROLLBAR_AS_NEEDED);
    }

    public DarkScrollPane(int vsbPolicy, int hsbPolicy) {
        this(null, vsbPolicy, hsbPolicy);
    }

    public DarkScrollPane() {
        this(null, VERTICAL_SCROLLBAR_AS_NEEDED, HORIZONTAL_SCROLLBAR_AS_NEEDED);
    }
}
