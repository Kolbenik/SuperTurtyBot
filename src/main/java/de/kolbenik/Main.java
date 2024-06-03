package de.kolbenik;

import de.kolbenik.image.PANifier;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");

        BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.drawImage(image, 0, 0, null);
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0,0,image.getWidth(),image.getHeight());
        graphics.dispose();

        BufferedImage pan = PANifier.panify(image);

        ImageIO.write(image, "png", new File("white.png"));
        ImageIO.write(pan, "png", new File("pan.png"));
    }
}