package de.kolbenik.image;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

public class BIifier {

    private static final List<Color> COLORS = List.of(
            new Color(0xD50070),
            new Color(0xD50070),
            new Color(0x9B4E96),
            new Color(0x0035A9),
            new Color(0x0035A9)
    );

    private BIifier() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static BufferedImage biify(BufferedImage image) {
        var newImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);

        Graphics2D graphics = newImage.createGraphics();
        graphics.drawImage(image, 0, 0, null);
        graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.5f));

        int stripeHeight = (int) Math.ceil(image.getHeight() / 5D);
        System.out.println(stripeHeight);
        int yIndex = 0;
        for (int y = 0; y < image.getHeight(); y += stripeHeight) {
            Color color = COLORS.get(yIndex++);
            graphics.setColor(color);
            graphics.fillRect(0, y, image.getWidth(), stripeHeight);
        }

        graphics.dispose();

        return newImage;
    }
}
