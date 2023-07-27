package su.demands.darkswing.elements.checkbox;

import su.demands.darkswing.Colors;

import javax.swing.*;

public class CheckBox extends JCheckBox {

    public CheckBox() {
        setForeground(Colors.TEXT_FOREGROUND);
        setBackground(Colors.FRAME_BACKGROUND);
        setFocusPainted(false);
        setBorderPainted(false);
        setRolloverEnabled(false);
    }

    public void showBorders() {
        setBorderPainted(true);
        setBorder(BorderFactory.createMatteBorder(1,1,1,1, Colors.SUB_SELECT));
    }
}
