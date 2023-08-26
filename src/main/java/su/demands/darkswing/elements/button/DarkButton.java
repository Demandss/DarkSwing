package su.demands.darkswing.elements.button;

import su.demands.darkswing.DarkSwingColors;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;

public class DarkButton extends JButton {
    public DarkButton() {
        this(null, null);
    }

    public DarkButton(Icon icon) {
        this(null, icon);
    }

    public DarkButton(String text) {
        this(text, null);
    }

    public DarkButton(Action a) {
        super(a);
    }

    public DarkButton(String text, Icon icon) {
        super(text, icon);

        setForeground(DarkSwingColors.TEXT_FOREGROUND);
        setBackground(DarkSwingColors.ELEMENTS_BACKGROUND);
        setFocusPainted(false);
        setBorderPainted(false);
        setRolloverEnabled(false);
        setDefaultCapable(false);

        setUI(new BasicButtonUI() {
            @Override
            protected void paintButtonPressed(Graphics g, AbstractButton b) {
                super.paintButtonPressed(g, b);
                if (getModel().isPressed()) {
                    g.setColor(DarkSwingColors.SELECT);
                } else {
                    g.setColor(getBackground());
                }
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        });
    }

}
