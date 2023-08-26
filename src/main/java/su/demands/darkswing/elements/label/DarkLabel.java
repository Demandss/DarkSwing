package su.demands.darkswing.elements.label;

import su.demands.darkswing.DarkSwingColors;

import javax.swing.*;
import java.awt.*;

public class DarkLabel extends JLabel {

    public DarkLabel(String text, Icon icon, int horizontalAlignment) {
        super(text, icon, horizontalAlignment);

        setForeground(DarkSwingColors.TEXT_FOREGROUND);
        setFont(new Font("Inter", Font.PLAIN,14));
    }

    public DarkLabel(String text, int horizontalAlignment) {
        this(text, null, horizontalAlignment);
    }

    public DarkLabel(String text) {
        this(text, null, LEADING);
    }

    public DarkLabel(Icon image, int horizontalAlignment) {
        this(null, image, horizontalAlignment);
    }

    public DarkLabel(Icon image) {
        this(null, image, CENTER);
    }

    public DarkLabel() {
        this("", null, LEADING);
    }
}
