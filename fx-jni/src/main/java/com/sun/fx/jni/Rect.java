package com.sun.fx.jni;

import javafx.geometry.Bounds;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.util.List;

/**
 * @author XDSSWAR
 * Created on 06/10/2023
 */
public class Rect {

    /**
     * Creates a Rectangle2D object from a Bounds object.
     *
     * @param bounds The Bounds object to create the Rectangle2D from.
     * @return The created Rectangle2D object.
     */
    public static Rectangle2D createFromBounds(Bounds bounds){
        return new Rectangle2D(bounds.getMinX()+5, bounds.getMinY(), bounds.getWidth(),bounds.getHeight());
    }


    /**
     * Retrieves the current Screen where the specified Stage is located.
     * If the Stage intersects with multiple screens, it returns the Screen
     * that contains the majority of the Stage. If no intersecting screens
     * are found, it returns the primary Screen.
     *
     * @param stage The Stage for which to retrieve the current Screen.
     * @return The current Screen where the Stage is located.
     */
    public static Screen getCurrentScreen(Stage stage){
        Rectangle2D bounds = new Rectangle2D(stage.getX(), stage.getY(),stage.getWidth(), stage.getHeight());
        List<Screen> screens=Screen.getScreensForRectangle(bounds);
        if (!screens.isEmpty()){
            return screens.get(0);
        }
        return Screen.getPrimary();
    }
}
