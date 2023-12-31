package su.demands.darkswing.elements.textfield;

import lombok.Getter;
import lombok.Setter;
import su.demands.darkswing.DarkSwingColors;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.text.*;
import java.awt.*;

@Getter
public class DarkTextPane extends JScrollPane {

    protected final JTextPane textArea = new JTextPane();

    @Setter
    private String textStyle = "Inter";

    public DarkTextPane() {
        super(VERTICAL_SCROLLBAR_ALWAYS, HORIZONTAL_SCROLLBAR_NEVER);
        setViewportView(textArea);
        setBackground(DarkSwingColors.FRAME_BACKGROUND);
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
                button.setBorder(BorderFactory.createMatteBorder(0,0,1,0, DarkSwingColors.SUB_SELECT));
                return button;
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                JButton button = super.createDecreaseButton(orientation);
                button.setBackground(DarkSwingColors.ELEMENTS_BACKGROUND);
                button.setBorder(BorderFactory.createMatteBorder(1,0,0,0, DarkSwingColors.SUB_SELECT));
                return button;
            }
        });
        getVerticalScrollBar().setBorder(BorderFactory.createMatteBorder(0,1,0,0, DarkSwingColors.SUB_SELECT));
        setBorder(BorderFactory.createMatteBorder(1,1,1,1, DarkSwingColors.SUB_SELECT));
        textArea.setFont(new Font(textStyle, Font.PLAIN,14));
        textArea.setBackground(getBackground());
        textArea.setForeground(DarkSwingColors.TEXT_FOREGROUND);
    }

    public void append(String msg) {
        this.append(msg,null);
    }

    public void append(String msg, Color color) {
        StyleContext styleContext = StyleContext.getDefaultStyleContext();
        AttributeSet attributeSet = styleContext.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, color);

        attributeSet = styleContext.addAttribute(attributeSet, StyleConstants.FontFamily, textStyle);
        attributeSet = styleContext.addAttribute(attributeSet, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);

        Document doc = textArea.getDocument();
        if (doc != null) {
            try {
                doc.insertString(doc.getLength(), msg, attributeSet);
            } catch (BadLocationException e) {
            }
        }
    }
}