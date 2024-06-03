package de.kolbenik;

import de.kolbenik.image.BIifier;
import de.kolbenik.image.TRANSifier;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.drawImage(image, 0, 0, null);
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0,0,image.getWidth(),image.getHeight());
        graphics.dispose();

        BufferedImage bi = TRANSifier.transify(image);

        ImageIO.write(image, "png", new File("white.png"));
        ImageIO.write(bi, "png", new File("trans.png"));
    }
}