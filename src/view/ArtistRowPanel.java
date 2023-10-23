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

        // Creating a panel display for the artist class, displaying the name in the panel or displaying
        // an error image if there is an issue
        try {
            // Obtains an image of the selected artist from the API to display as part of the panel
            URL url = new URL(imageURL);
            image = ImageIO.read(url);
        } catch (Exception e) {
            // In case an image is not able to save, the photo of the artist will be replaced
            // by a generic error image saved outside the src folder
            File imgageFile = new File("error-image-generic.png");
            try {
                image = ImageIO.read(imgageFile);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        // Sets the image obtained through the try-catch and sets it as the icon for the current artist
        image = image.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(image);
        name.setIcon(icon);

        // Other variables for the panel display, showing the name and follower count alongside the photo
        this.add(name);
        this.add(followers);
    }
}
