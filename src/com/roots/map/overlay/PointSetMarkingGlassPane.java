package com.roots.map.overlay;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class PointSetMarkingGlassPane extends JComponent implements IGlassPane {
    private final ILatLongToScreenCoordinatesConverter latLongToScreenCoordinatesConverter;
    private final List<Point.Double> pointsToMark = new LinkedList<Point.Double>();

    public PointSetMarkingGlassPane(final ILatLongToScreenCoordinatesConverter aConverter) {
        this.latLongToScreenCoordinatesConverter = aConverter;
    }

    protected void addPointToMark(final Point.Double aPoint)
    {
        if (aPoint != null)
        {
            pointsToMark.add(aPoint);
        }
    }

    @Override
    protected void paintComponent(final Graphics aGraphics) {
        for (final Point.Double pointToMark : pointsToMark)
        {
            final Point positionInScreenCoords = latLongToScreenCoordinatesConverter.getScreenCoordinates(pointToMark);
            drawCircle(aGraphics, positionInScreenCoords, Color.red);
        }
    }

    private void drawCircle(Graphics g, Point point, Color color) {
        g.setColor(color);
        g.fillOval(point.x, point.y, 10, 10);
    }

}
