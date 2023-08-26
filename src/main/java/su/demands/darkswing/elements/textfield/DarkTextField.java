package su.demands.darkswing.elements.textfield;

import lombok.Getter;
import su.demands.darkswing.DarkSwingColors;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

@Getter
public class DarkTextField extends JTextField {

    protected final DarkTextPrompt textPrompt;

    public DarkTextField() {
        this(DarkTextPrompt.Show.ALWAYS);
    }

    public DarkTextField(DarkTextPrompt.Show show) {
        textPrompt = new DarkTextPrompt("",this,show);
        setForeground(DarkSwingColors.TEXT_FOREGROUND);
        setBackground(DarkSwingColors.FRAME_BACKGROUND);
        setBorder(new CompoundBorder(
                BorderFactory.createMatteBorder(1,1,1,1, DarkSwingColors.SUB_SELECT),
                new EmptyBorder(0, 5, 0, 0)
        ));
    }
}
