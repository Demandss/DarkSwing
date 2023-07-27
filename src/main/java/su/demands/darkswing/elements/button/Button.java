package su.demands.darkswing.elements;

import su.demands.darkswing.Colors;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;

public class Button extends JButton {
    public Button() {
        setForeground(Colors.TEXT_FOREGROUND);
        setBackground(Colors.ELEMENTS_BACKGROUND);
        setFocusPainted(false);
        setBorderPainted(false);
        setRolloverEnabled(false);
        setDefaultCapable(false);

        setUI(new BasicButtonUI() {
            @Override
            protected void paintButtonPressed(Graphics g, AbstractButton b) {
                super.paintButtonPressed(g, b);
                if (getModel().isPressed()) {
                    g.setColor(Colors.SELECT);
                } else {
                    g.setColor(getBackground());
                }
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        });
    }
}
