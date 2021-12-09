// source https://www.javatpoint.com/Graphics-in-swing

//import MenuExample;

import api.DirectedWeightedGraph;
import api.DirectedWeightedGraphAlgorithms;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.util.ArrayList;

public class DisplayGraphics extends Canvas {
    Menu menu, submenu, submenu1;
    MenuItem i1, i2, i3, i4, i5, i6;

   // ArrayList<GeoLocation> pointList = new ArrayList<>();
    DirectedWeightedGraphAlgorithms algo;
   // GeoLocation mPivot_point = null;
    boolean mDraw_pivot = false;
    boolean mMoving_point = false;
    private int kRADIUS = 5;
    private int window_H = 1000;
    private int window_W = 1000;
    private Image mBuffer_image;
    private Graphics mBuffer_graphics;


    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Line2D line = new Line2D.Float(100, 100, 250, 260);
        g2.draw(line);

        Graphics2D g2d = (Graphics2D) g;
        //  g2d.drawOval(5, 10, 10, 10);
        //g2.draw( line);
        // System.out.println(p);
        //g.drawString("Hello", 40, 40);
        setBackground(Color.YELLOW);
        // g.fillRect(130, 30, 100, 80);
        //g.drawOval(30, 130, 50, 60);
        setForeground(Color.BLACK);
       // g.drawLine(0, 1000, 0, 1000);
       // g.fillOval(100, 100, 10, 10);
        //g.drawArc(30, 200, 40,50,90,60);
        //g.fillArc(30, 130, 40,50,180,40);
        DirectedWeigtet gg = new DirectedWeigtet();

        try {
            gg = TestHash.graph();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<Point2D> p = (ArrayList<Point2D>) TestHash.pp(gg);
        double sizes[] = checksizes(p);
        for (int i = 0; i < p.size(); i++) {
            Point2D po = p.get(i);
            Double xdist=sizes[1]-sizes[0];
            double xx=  ((1000/xdist)*(po.getX()-sizes[0]));
            Double ydist =(sizes[3]-sizes[2]);
            double yy=(1000/ydist)*(po.getY()-sizes[2]);
            g.fillOval((int) xx-10, (int) yy-10, 20, 20);


        }
        ArrayList<Point2D> egges=TestHash.ed(gg);
        for (int i = 0; i < egges.size(); i=i+2) {

           Point2D src= egges.get(i);
           Double x1=src.getX();
            Double y1=src.getY();
            Point2D dest= egges.get(i+1);
            Double x2=dest.getX();
            Double y2=dest.getY();
            Double xdist=sizes[1]-sizes[0];
            double x11=  ((1000/xdist)*(x1-sizes[0]));
            Double ydist =(sizes[3]-sizes[2]);
            double y11=(1000/ydist)*(y1-sizes[2]);
            double x21=  ((1000/xdist)*(x2-sizes[0]));
            double y21=(1000/ydist)*(y2-sizes[2]);


            g.drawLine((int) x11,(int) y11,(int) x21,(int) y21);
        }
        Frame f = new Frame("Menu and MenuItem Example");
        MenuBar mb = new MenuBar();
        menu = new Menu("Menu");
        submenu = new Menu("Algo");
        submenu1 = new Menu("Graph");
        i1 = new MenuItem("Graph");
        //i2.addActionListener(this);
        i2 = new MenuItem("Algo");

        i3 = new MenuItem("Load");
        //i3.addActionListener((ActionListener) this);
        i4 = new MenuItem("Is connected");
        i5 = new MenuItem("Delete Node");
        i6 = new MenuItem("Delete Edge");

        submenu1.add(i5);
        submenu1.add(i6);
        submenu.add(i2);
        submenu.add(i3);
        submenu.add(i4);
        menu.add(submenu);
        menu.add(submenu1);
        mb.add(menu);
        f.setMenuBar(mb);
        f.paint(g);
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
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
        DisplayGraphics m = new DisplayGraphics();
        JFrame f = new JFrame();
        f.add(m);
        f.setSize(1000, 1000);


        //f.setLayout(null);
        f.setVisible(true);
    }

}
