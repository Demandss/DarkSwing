package su.demands.darkswing.elements.checkbox;

import su.demands.darkswing.DarkSwingColors;

import javax.swing.*;

public class DarkCheckBox extends JCheckBox {

    public DarkCheckBox() {
        this(null, null, false);
    }

    public DarkCheckBox(Icon icon) {
        this(null, icon, false);
    }

    public DarkCheckBox(Icon icon, boolean selected) {
        this(null, icon, selected);
    }

    public DarkCheckBox(String text) {
        this(text, null, false);
    }

    public DarkCheckBox(Action a) {
        super(a);
    }

    public DarkCheckBox(String text, boolean selected) {
        this(text, null, selected);
    }

    public DarkCheckBox(String text, Icon icon) {
        this(text, icon, false);
    }

    public DarkCheckBox(String text, Icon icon, boolean selected) {
        super(text, icon, selected);
        setForeground(DarkSwingColors.TEXT_FOREGROUND);
        setBackground(DarkSwingColors.FRAME_BACKGROUND);
        setFocusPainted(false);
        setBorderPainted(false);
        setRolloverEnabled(false);
    }

    public void showBorders() {
        setBorderPainted(true);
        setBorder(BorderFactory.createMatteBorder(1,1,1,1, DarkSwingColors.SUB_SELECT));
    }
}
