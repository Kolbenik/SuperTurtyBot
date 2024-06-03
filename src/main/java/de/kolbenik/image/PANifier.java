package de.kolbenik.image;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

public class PANifier {

    private static final List<Color> COLORS = List.of(
            new Color(0xF52087),
            new Color(0xF5CF00),
            new Color(0x20AAF5)
    );

    private PANifier() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static BufferedImage panify(BufferedImage image) {
        var newImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);

        Graphics2D graphics = newImage.createGraphics();
        graphics.drawImage(image, 0, 0, null);
        graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.5f));

        int stripeHeight = (int) Math.ceil(image.getHeight() / 3D);
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
