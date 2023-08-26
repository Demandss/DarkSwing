package su.demands.darkswing.elements.tabbedPane;

import lombok.Getter;
import lombok.Setter;
import su.demands.darkswing.DarkSwingColors;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import java.awt.*;

@Getter
public class DarkTabbedPane extends JTabbedPane {

    @Setter
    private boolean paintingBorders = false;

    public DarkTabbedPane() {
        setForeground(DarkSwingColors.TEXT_FOREGROUND);
        setBackground(DarkSwingColors.FRAME_BACKGROUND);

        setUI(new BasicTabbedPaneUI() {
            @Override
            protected void installDefaults() {
                super.installDefaults();
                highlight = DarkSwingColors.FRAME_BACKGROUND;
                lightHighlight = DarkSwingColors.FRAME_BACKGROUND;
                shadow = DarkSwingColors.FRAME_BACKGROUND;
                darkShadow = DarkSwingColors.FRAME_BACKGROUND;
                focus = DarkSwingColors.SUB_SELECT;
            }

            @Override
            protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex) {
                if (paintingBorders)
                    super.paintContentBorder(g,tabPlacement,selectedIndex);

                if (!paintingBorders && tabPlacement == SwingConstants.TOP) {
                    int width = tabPane.getWidth();
                    Insets insets = tabPane.getInsets();

                    int x = insets.left;
                    int y = insets.top;
                    int w = width - insets.right - insets.left;

                    y += calculateTabAreaHeight(tabPlacement, runCount, maxTabHeight) + 1;
                    g.setColor(DarkSwingColors.DARKENED_BORDER);

                    g.fillRect(x, y, w, 1);
                }
            }

            @Override
            protected void paintTabBackground(Graphics g, int tabPlacement,
                                              int tabIndex,
                                              int x, int y, int w, int h,
                                              boolean isSelected ) {
                g.setColor(!isSelected ? tabPane.getBackgroundAt(tabIndex) : DarkSwingColors.SUB_SELECT);
                switch (tabPlacement) {
                    case LEFT -> g.fillRect(x + 1, y + 1, w - 1, h - 3);
                    case RIGHT -> g.fillRect(x, y + 1, w - 2, h - 3);
                    case BOTTOM -> g.fillRect(x + 1, y, w - 3, h - 1);
                    default -> g.fillRect(x + 1, y + 1, w - 3, h - 1);
                }
            }
        });
    }
}