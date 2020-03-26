package lab6;

import java.awt.geom.Ellipse2D;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author stefan
 */
public class NodeShape extends Ellipse2D.Double {

    public NodeShape(double x0, double y0, double radius) {
        super(x0 - radius / 2, y0 - radius / 2, radius, radius);

    }
}
