package su.demands.darkswing.elements.label;

import su.demands.darkswing.Colors;

import javax.swing.*;
import java.awt.*;

public class Label extends JLabel {

    public Label(String text, Icon icon, int horizontalAlignment) {
        super(text, icon, horizontalAlignment);

        setForeground(Colors.TEXT_FOREGROUND);
        setFont(new Font("Inter", Font.PLAIN,14));
    }

    public Label(String text, int horizontalAlignment) {
        this(text, null, horizontalAlignment);
    }

    public Label(String text) {
        this(text, null, LEADING);
    }

    public Label(Icon image, int horizontalAlignment) {
        this(null, image, horizontalAlignment);
    }

    public Label(Icon image) {
        this(null, image, CENTER);
    }

    public Label() {
        this("", null, LEADING);
    }
}
