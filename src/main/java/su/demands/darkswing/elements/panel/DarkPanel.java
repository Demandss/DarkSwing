package su.demands.darkswing.elements.panel;

import su.demands.darkswing.DarkSwingColors;

import javax.swing.*;
import java.awt.*;

public class DarkPanel extends JPanel {

    public DarkPanel(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);

        setBackground(DarkSwingColors.FRAME_BACKGROUND);
    }

    public DarkPanel(LayoutManager layout) {
        this(layout, true);
    }

    public DarkPanel(boolean isDoubleBuffered) {
        this(new FlowLayout(), isDoubleBuffered);
    }

    public DarkPanel() {
        this(true);
    }
}
