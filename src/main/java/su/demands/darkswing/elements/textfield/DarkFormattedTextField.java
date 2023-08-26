package su.demands.darkswing.elements.textfield;

import lombok.Getter;
import su.demands.darkswing.DarkSwingColors;

import javax.swing.*;

@Getter
public class DarkFormattedTextField extends JFormattedTextField {

    protected final DarkTextPrompt textPrompt;

    public DarkFormattedTextField() {
        this(DarkTextPrompt.Show.ALWAYS);
    }

    public DarkFormattedTextField(DarkTextPrompt.Show show) {
        textPrompt = new DarkTextPrompt("",this,show);
        setForeground(DarkSwingColors.TEXT_FOREGROUND);
        setBackground(DarkSwingColors.FRAME_BACKGROUND);
        setBorder(BorderFactory.createMatteBorder(1,1,1,1, DarkSwingColors.SUB_SELECT));
    }
}
