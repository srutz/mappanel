package com.roots.map.overlay;

import com.roots.map.MapPanel;

import javax.swing.*;
import java.awt.*;

public class OverlayDemo {
    public void run()
    {
        final JFrame mainFrame = new JFrame("MapPanel with place marks");
        final MapPanel mapPanel = new MapPanel(new Point(3636598, 1535138), 14);
        mainFrame.add(mapPanel);

        final DemoGlassPane glassPane = new DemoGlassPane(mapPanel);

        mainFrame.setGlassPane(glassPane);

        mainFrame.getGlassPane().setVisible(true);

        mainFrame.pack();
        mainFrame.setVisible(true);

    }

    public static void main(final String[] aArgs)
    {
        final OverlayDemo app = new OverlayDemo();

        app.run();
    }
}
