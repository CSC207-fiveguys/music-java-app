package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

class ArtistRowPanel extends JPanel {
    ArtistRowPanel(String imageURL, JLabel name, JLabel followers) {

        Image image;

        try {
            URL url = new URL(imageURL);
            image = ImageIO.read(url);
        } catch (Exception e) {
            File imgageFile = new File("error-image-generic.png");
            try {
                image = ImageIO.read(imgageFile);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        image = image.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(image);
        name.setIcon(icon);

        this.add(name);
        this.add(followers);
    }
}
