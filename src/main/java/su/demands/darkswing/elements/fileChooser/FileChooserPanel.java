package su.demands.darkswing.elements.fileChooser;

import lombok.Getter;
import lombok.Setter;
import su.demands.darkswing.Colors;
import su.demands.darkswing.elements.button.Button;
import su.demands.darkswing.elements.textfield.TextField;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.nio.file.Path;
import java.nio.file.Paths;

@Getter
public class FileChooserPanel extends JPanel {

    private final su.demands.darkswing.elements.textfield.TextField textField = new TextField();
    private final su.demands.darkswing.elements.button.Button searchFile = new su.demands.darkswing.elements.button.Button();
    private su.demands.darkswing.elements.button.Button plusButton;

    protected final MatteBorder border = BorderFactory.createMatteBorder(1,1,1,1, Colors.SUB_SELECT);

    private boolean showPlusButton = false;

    public void showPlusButton(boolean state) {
        this.showPlusButton = state;

        if (plusButton == null && showPlusButton) {

            plusButton = new Button();
            plusButton.setText("+");
            plusButton.setFont(textField.getFont().deriveFont(textField.getFont().getSize() + 2f));
            plusButton.setBorderPainted(true);
            plusButton.setBackground(getBackground());
            plusButton.setBorder(border);

            add(plusButton);
        } else if (!showPlusButton && plusButton != null) {
            remove(plusButton);
        }
    }

    public FileChooserPanel() {
        setBackground(Colors.FRAME_BACKGROUND);
        setPreferredSize(new Dimension(30,20));

        textField.setFont(new Font("Inter", Font.PLAIN,12));
        textField.setBackground(getBackground());
        searchFile.setText("...");
        searchFile.setFont(textField.getFont());
        searchFile.setBorderPainted(true);
        searchFile.setBackground(getBackground());
        searchFile.setBorder(border);
        searchFile.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int rVal = fileChooser.showOpenDialog(this);
            if (rVal == JFileChooser.APPROVE_OPTION) {
                textField.setText(fileChooser.getSelectedFile().getPath());
            }
        });

        setLayout(null);

        add(textField);
        add(searchFile);
    }

    public Path getPath() {
        return Paths.get(textField.getText());
    }

    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);

        height = Math.max(height, 20);
        width = Math.max(width, 20);

        int padding = width + 6;

        if (isShowPlusButton())
            padding += width;

        textField.setBounds(0,0,getWidth() - padding,height);
        searchFile.setBounds(textField.getWidth() + 3,0,width,height);

        if (isShowPlusButton())
            plusButton.setBounds(textField.getWidth() + searchFile.getWidth() + 6,0,width,height);
    }
}