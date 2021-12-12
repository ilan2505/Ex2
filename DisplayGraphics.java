// source https://www.javatpoint.com/Graphics-in-swing

//import MenuExample;

import api.DirectedWeightedGraphAlgorithms;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.util.ArrayList;

public class DisplayGraphics extends Canvas {
    DirectedWeightedGraphAlgorithms myalgo;
    Menu menu, submenu, submenu1;
    MenuItem i1, i2, i3, i4, i5, i6;

    // ArrayList<GeoLocation> pointList = new ArrayList<>();
    DirectedWeightedGraphAlgorithms algo = new Algo();
    private int kRADIUS = 5;
    private int window_H = 1000;
    private int window_W = 1000;
    Graphics g;


    public DisplayGraphics(DirectedWeightedGraphAlgorithms algo1) {
        this.myalgo = algo1;
    }


    public void paint(Graphics g) {
        this.g = g;
        setBackground(Color.YELLOW);
        setForeground(Color.BLACK);
        DirectedWeigtet gg = (DirectedWeigtet) myalgo.getGraph();
        ArrayList<Point2D> p = (ArrayList<Point2D>) TestHash.pp(gg);
        double sizes[] = checksizes(p);
        for (int i = 0; i < p.size(); i++) {
            DrawPoint(p.get(i),sizes);
        }
        ArrayList<Point2D> egges = TestHash.ed(gg);
        for (int i = 0; i < egges.size(); i = i + 2) {
            Drawline(egges.get(i), egges.get(i + 1), sizes);
        }
    }

    private void DrawPoint(Point2D po, double[] sizes) {
        Double xdist = sizes[1] - sizes[0];
        double xx = ((950 / xdist) * (po.getX() - sizes[0]));
        Double ydist = (sizes[3] - sizes[2]);
        double yy = (950 / ydist) * (po.getY() - sizes[2]);
        g.fillOval((int) xx - 10, (int) yy - 10, 20, 20);
    }

    private void Drawline(Point2D src, Point2D dest, double[] sizes) {
        Double x1 = src.getX();
        Double y1 = src.getY();
        Double x2 = dest.getX();
        Double y2 = dest.getY();
        Double xdist = sizes[1] - sizes[0];
        double x11 = ((950 / xdist) * (x1 - sizes[0]));
        Double ydist = (sizes[3] - sizes[2]);
        double y11 = (950 / ydist) * (y1 - sizes[2]);
        double x21 = ((950 / xdist) * (x2 - sizes[0]));
        double y21 = (950 / ydist) * (y2 - sizes[2]);
        Point2D dir=new Point2D() {
            @Override
            public double getX() {
                return 0.9*x21+0.1*x11;
            }

            @Override
            public double getY() {
                return 0.9*y21+0.1*y11;
            }

            @Override
            public void setLocation(double x, double y) {

            }
        };
        DrawPointdir(dir,sizes);
        g.drawLine((int) x11, (int) y11, (int) x21, (int) y21);
    }

    private void DrawPointdir(Point2D dir, double[] sizes) {
        Double xdist = sizes[1] - sizes[0];
        double xx = dir.getX();
        Double ydist = (sizes[3] - sizes[2]);
        double yy =dir.getY();
        System.out.println(xx+","+yy);

        g.fillOval((int) xx , (int) yy , 10, 10);
    }

    private double[] checksizes(ArrayList<Point2D> p) {
        double xmin = Double.MAX_VALUE;
        double xmax = Double.MIN_VALUE;
        double ymin = Double.MAX_VALUE;
        double ymax = Double.MIN_VALUE;
        for (int i = 0; i < p.size(); i++) {

            if (p.get(i).getX() < xmin) {
                xmin = p.get(i).getX();
            }
            if (p.get(i).getX() > xmax) {
                xmax = p.get(i).getX();
            }
            if (p.get(i).getY() < ymin) {
                ymin = p.get(i).getY();
            }
            if (p.get(i).getY() > ymax) {
                ymax = p.get(i).getY();
            }
        }
        return new double[]{xmin, xmax, ymin, ymax};
    }


    public static void main(String[] args) {
        //  DisplayGraphics m = new DisplayGraphics();
        //JFrame f = new JFrame();
        //f.add(m);
        //f.setSize(1000, 1000);


        // f.setLayout(null);
        //   f.setVisible(true);
    }


}
/**
 * Frame f = new Frame("Menu and MenuItem Example");
 * MenuBar mb = new MenuBar();
 * menu = new Menu("Menu");
 * submenu = new Menu("Algo");
 * submenu1 = new Menu("Graph");
 * i1 = new MenuItem("Graph");
 * //i2.addActionListener(this);
 * i2 = new MenuItem("Algo");
 * <p>
 * i3 = new MenuItem("Load");
 * //i3.addActionListener((ActionListener) this);
 * i4 = new MenuItem("Is connected");
 * i5 = new MenuItem("Delete Node");
 * i6 = new MenuItem("Delete Edge");
 * <p>
 * submenu1.add(i5);
 * submenu1.add(i6);
 * submenu.add(i2);
 * submenu.add(i3);
 * submenu.add(i4);
 * menu.add(submenu);
 * menu.add(submenu1);
 * mb.add(menu);
 * f.setMenuBar(mb);
 * f.paint(g);
 * f.setSize(400, 400);
 * f.setLayout(null);
 * f.setVisible(true);
 */