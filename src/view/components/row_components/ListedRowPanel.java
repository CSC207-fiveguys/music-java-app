package view.components.row_components;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public abstract class ListedRowPanel extends JPanel {

    public ListedRowPanel(String title, String iconPath) {
        setMinimumSize(new Dimension(1280, 60));
        setPreferredSize(new Dimension(1280, 60));
        setMaximumSize(new Dimension(1280, 60));

        JLabel label = new JLabel(title);
        add(label);

        Image image;

        try {
            // load image of the selected artist from spotify's CDN
            URL url = new URL(iconPath);
            image = ImageIO.read(url);
        } catch (Exception e) {
            // if image is not able to be retrieved, load image locally
            try {
                File imgageFile = new File(iconPath);
                image = ImageIO.read(imgageFile);
            } catch (Exception f) {
                // if image is not able to be retrieved, use local generic error image
                File imgageFile = new File("src/icons/error-image-generic.png");
                try {
                    image = ImageIO.read(imgageFile);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }

        image = image.getScaledInstance(48, 48, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(image);
        label.setIcon(icon);
        label.setMinimumSize(new Dimension(180, 52));
        label.setPreferredSize(new Dimension(180, 52));
        label.setMaximumSize(new Dimension(180, 52));
        label.setOpaque(true);
        label.setBackground(Color.GRAY);
        add(label);

        setBackground(new Color(143, 153, 141));
    }
}
