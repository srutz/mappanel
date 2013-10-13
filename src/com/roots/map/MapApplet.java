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

package com.roots.map;
import javax.swing.JApplet;
import javax.swing.JMenuBar;


/**
 * MapApplet, shows a {@link MapPanel} as an applet.
 * @author stepan.rutz
 * @version $Revision$
 */
public class MapApplet extends JApplet {
    
    public MapApplet() {
        MapPanel.Gui gui = new MapPanel.Gui();

        JMenuBar menuBar = gui.createMenuBar();
        setJMenuBar(menuBar);
        getContentPane().add(gui);
    }

}

 
