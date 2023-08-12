package su.demands.darkswing.elements.fileChooser;

import lombok.Getter;
import lombok.Setter;
import su.demands.darkswing.Colors;
import su.demands.darkswing.elements.button.Button;
import su.demands.darkswing.elements.textfield.TextField;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.nio.file.Path;
import java.nio.file.Paths;

@Getter
public class FileChooserPanel extends JPanel {

    protected final su.demands.darkswing.elements.textfield.TextField textField = new TextField();
    protected final su.demands.darkswing.elements.button.Button searchFile = new su.demands.darkswing.elements.button.Button();

    public FileChooserPanel() {
        setBackground(Colors.FRAME_BACKGROUND);
        setPreferredSize(new Dimension(30,20));
        MatteBorder border = BorderFactory.createMatteBorder(1,1,1,1, Colors.SUB_SELECT);

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
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
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
        searchFile.setBounds(textField.getWidth() + 3,0,20,20);
    }
}