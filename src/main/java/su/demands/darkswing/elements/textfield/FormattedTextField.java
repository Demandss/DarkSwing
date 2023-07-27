package su.demands.darkswing.elements.textfield;

import lombok.Getter;
import su.demands.darkswing.Colors;

import javax.swing.*;

@Getter
public class FormattedTextField extends JFormattedTextField {

    private final TextPrompt textPrompt;

    public FormattedTextField() {
        this(TextPrompt.Show.ALWAYS);
    }

    public FormattedTextField(TextPrompt.Show show) {
        textPrompt = new TextPrompt("",this,show);
        setForeground(Colors.TEXT_FOREGROUND);
        setBackground(Colors.FRAME_BACKGROUND);
        setBorder(BorderFactory.createMatteBorder(1,1,1,1, Colors.SUB_SELECT));
    }
}
