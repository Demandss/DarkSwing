package su.demands.darkswing.elements;

import lombok.Getter;
import lombok.Setter;
import su.demands.darkswing.Colors;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import java.awt.*;

@Getter
public class TabbedPane extends JTabbedPane {

    @Setter
    private boolean paintingBorders = false;

    public TabbedPane() {
        setForeground(Colors.TEXT_FOREGROUND);
        setBackground(Colors.FRAME_BACKGROUND);

        setUI(new BasicTabbedPaneUI() {
            @Override
            protected void installDefaults() {
                super.installDefaults();
                highlight = Colors.FRAME_BACKGROUND;
                lightHighlight = Colors.FRAME_BACKGROUND;
                shadow = Colors.FRAME_BACKGROUND;
                darkShadow = Colors.FRAME_BACKGROUND;
                focus = Colors.SUB_SELECT;
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
                    g.setColor(Color.BLACK);

                    g.fillRect(x, y, w, 1);
                }
            }

            @Override
            protected void paintTabBackground(Graphics g, int tabPlacement,
                                              int tabIndex,
                                              int x, int y, int w, int h,
                                              boolean isSelected ) {
                g.setColor(!isSelected ? tabPane.getBackgroundAt(tabIndex) : Colors.SUB_SELECT);
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