package su.demands.darkswing.elements.fileChooser;

import lombok.Getter;
import su.demands.darkswing.DarkSwingColors;
import su.demands.darkswing.elements.button.DarkButton;
import su.demands.darkswing.elements.panel.DarkPanel;
import su.demands.darkswing.elements.textfield.DarkTextField;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.nio.file.Path;
import java.nio.file.Paths;

@Getter
public class DarkFileChooserPanel extends DarkPanel {

    protected final DarkTextField textField = new DarkTextField();
    protected final DarkButton searchFile = new DarkButton();
    protected DarkFileChooser fileChooser = new DarkFileChooser();

    public DarkFileChooserPanel() {
        setPreferredSize(new Dimension(30,20));
        MatteBorder border = BorderFactory.createMatteBorder(1,1,1,1, DarkSwingColors.SUB_SELECT);

        textField.setFont(new Font("Inter", Font.PLAIN,12));
        textField.setBackground(getBackground());
        searchFile.setText("...");
        searchFile.setFont(textField.getFont());
        searchFile.setBorderPainted(true);
        searchFile.setBackground(getBackground());
        searchFile.setBorder(border);
        searchFile.addActionListener(this::openFileChooserAction);

        setLayout(null);

        add(textField);
        add(searchFile);
    }

    protected void openFileChooserAction(ActionEvent event) {
        int rVal = fileChooser.showOpenDialog(this);
        if (rVal == JFileChooser.APPROVE_OPTION) {
            textField.setText(fileChooser.getSelectedFile().getPath());
        }
    }

    public Path getPath() {
        return Paths.get(textField.getText());
    }

    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);

        textField.setBounds(0,0,getWidth() - 23,20);
        searchFile.setBounds((textField.getX() + textField.getWidth()) + 3,0,20,20);
    }
}