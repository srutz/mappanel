package com.roots.map.overlay;

import java.awt.*;
import java.awt.geom.Point2D;

public class DemoGlassPane extends PointSetMarkingGlassPane {

    public static final Point2D.Double ARTYOM = new Point.Double(132.18381, 43.35514);

    public static final Point2D.Double COLOGNE = new Point.Double(6.96202, 50.93575);

    public DemoGlassPane(ILatLongToScreenCoordinatesConverter latitudeLongitudeToScreenCoordinatesConverter) {
        super(latitudeLongitudeToScreenCoordinatesConverter);

        addPointToMark(ARTYOM);
        addPointToMark(COLOGNE);
    }
}
