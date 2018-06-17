package com.roots.map.overlay;

import java.awt.*;

public interface ILatLongToScreenCoordinatesConverter {
    Point getScreenCoordinates(Point.Double coords);
}
