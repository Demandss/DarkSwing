package su.demands.darkswing.elements.menuBar;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

public class MenuBar extends JMenuBar {

    @Getter @Setter
    private boolean canAddNewElement;

    @Override
    public Component add(Component comp) {
        if (isCanAddNewElement())
            return null;
        return super.add(comp);
    }
}
