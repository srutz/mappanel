/*******************************************************************************
 * Copyright (c) 2008, 2012 Stepan Rutz.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Stepan Rutz - initial implementation
 *******************************************************************************/
 
 
package com.roots.map.fx;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.ext.swing.SwingComponent;
import java.awt.Point;
import java.awt.Dimension;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

import com.roots.map.MapPanel;

/**
 * @author stepan.rutz
 */


var moveStep = 32;
var panelWidth = 900;
var panelHeight = 700;

var gui = MapPanel.createGui(new Point(8282, 5179), 6);
var mapPanel = gui.getMapPanel();

gui.setPreferredSize(new Dimension(panelWidth, panelHeight));
gui.getCustomSplitPane().setSplit(0.3);

var searchPanel = mapPanel.getSearchPanel();
var guiComponent = SwingComponent.wrap(gui);

 

var cycleRendererButton = Button {
    text: "Cycle Renderer"
    action: function() {
        mapPanel.nextTileServer();
    }
}

var toggleSearchPanelButton = Button {
    text: "Toggle Search"
    action: function() {
        searchPanel.setVisible(not searchPanel.isVisible());
    }
}

var zoomInButton = Button {
    text: "Zoom In"
    action: function() {
        mapPanel.zoomInAnimated(new Point(mapPanel.getWidth() / 2, mapPanel.getHeight() / 2));
    }
}

var zoomOutButton = Button {
    text: "Zoom Out"
    action: function() {
        mapPanel.zoomOutAnimated(new Point(mapPanel.getWidth() / 2, mapPanel.getHeight() / 2));
    }
}

var moveLeftButton = Button {
    text: "Left"
    action: function() {
        mapPanel.translateMapPosition(-moveStep, 0);
        mapPanel.repaint();
    }
}

var moveRightButton = Button {
    text: "Right"
    action: function() {
        mapPanel.translateMapPosition(moveStep, 0);
        mapPanel.repaint();
    }
}

var moveUpButton = Button {
    text: "Up"
    action: function() {
        mapPanel.translateMapPosition(0, -moveStep);
        mapPanel.repaint();
    }
}

var moveDownButton = Button {
    text: "Down"
    action: function() {
        mapPanel.translateMapPosition(0, moveStep);
        mapPanel.repaint();
    }
}

var buttonGrid : HBox = HBox {
    spacing: 8
    content: [ cycleRendererButton, toggleSearchPanelButton, zoomInButton, zoomOutButton,
        moveLeftButton, moveRightButton, moveUpButton, moveDownButton ]
    translateX: 300
    translateY: panelHeight - 100
}


Stage {
    title: "MapPanel"
    scene: Scene {
        width: panelWidth
        height: panelHeight
        content: [
            guiComponent,
            Rectangle {
                x: 510
                y: 12
                width: 180
                height : 40
                opacity: 0.6
            },
            Text {
                font : Font {
                    size : 20
                }
                fill: Color.WHITE
                x: 520
                y: 42
                content: "MapPanel Viewer"
            },
            buttonGrid
        ]
    }
}