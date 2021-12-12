import api.DirectedWeightedGraph;
import api.DirectedWeightedGraphAlgorithms;
import api.NodeData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

public class MYwindow extends JFrame implements ActionListener, MouseListener, MouseMotionListener {
    DirectedWeightedGraphAlgorithms algo;
    DirectedWeightedGraph myGraph = new DirectedWeigtet();
    private MenuItem item1, item2, item3, itemIsConnected, itemPath, itemTSP, ItemGetNode, ItemGetEdge, ItemConnect, ItemRemoveEdge, ItemRemoveNode;
    private MenuBar menuBar;
    private Menu menu, algoMenu, MenuGraph;
    JLabel label1;
    private DisplayGraphics p;
    JFrame myf1 = new JFrame();
    JFrame myf2 = new JFrame();
    JFrame myf3 = new JFrame();
    JFrame myfpath = new JFrame();
    JFrame myfIsconnectet = new JFrame();
    JFrame myftsp = new JFrame();
    JFrame myfGetNode = new JFrame();
    JFrame myfGetEdge = new JFrame();
    JFrame myfConnect = new JFrame();
    JFrame myfRemoveNode = new JFrame();
    JFrame myfRemoveEdge = new JFrame();


    JPanel panel = new JPanel();
    JPanel panel1 = new JPanel();
    JPanel panelPath = new JPanel();
    JPanel panelIconnected = new JPanel();
    JPanel panelTSP = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panelGetnode = new JPanel();
    JPanel panelgetEdge = new JPanel();
    JPanel panelConnect = new JPanel();
    JPanel panelRemoveNode = new JPanel();
    JPanel panelRemoveEdge = new JPanel();


    JPanel Mypanel = new JPanel();
    JPanel Npanelrun = new JPanel();
    private JLabel label, labelCenter, labelWight, labeltsp;
    private JTextField text, text1, textSrcPath, TDP, TSPSrc, TSPDest, getNode, GetES, GetED, ConS, conD, remN, remES, remED;
    //private  JButton  button;
    JButton ButtonLoad, ButtonTSP;
    JButton ButtonSave;
    JButton ButtonRun;
    JButton ButtonGetNode;
    JButton ButtonGetEdge, ButtonConnect, ButtonRemoveEdge, ButtonRemoveNode;

    String t = new String();
    JFrame f1 = new JFrame();


    JTextField TextField;

    public static void main(String[] args) {
        new MYwindow();
    }

    public MYwindow() {
        menu = new Menu("menu");
        algoMenu = new Menu("ALGOMenu");
        menuBar = new MenuBar();
        MenuGraph = new Menu("GraphMenu");
        item1 = new MenuItem("load");
        item1.addActionListener(this);
        item2 = new MenuItem("save");
        item2.addActionListener(this);
        item3 = new MenuItem("center");
        item3.addActionListener(this);
        itemIsConnected = new MenuItem("IsConnected?");
        itemIsConnected.addActionListener(this);
        itemPath = new MenuItem("Shorted path");
        itemPath.addActionListener(this);
        itemTSP = new MenuItem("findTSP");
        itemTSP.addActionListener(this);
        ItemGetNode = new MenuItem("GetNode");
        ItemGetNode.addActionListener(this);
        ItemGetEdge = new MenuItem("GetEdge");
        ItemGetEdge.addActionListener(this);
        ItemConnect = new MenuItem("Connect");
        ItemConnect.addActionListener(this);
        ItemRemoveNode = new MenuItem("RemoveNode");
        ItemRemoveNode.addActionListener(this);
        ItemRemoveEdge = new MenuItem("RemoveEdge");
        ItemRemoveEdge.addActionListener(this);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.add(item1);
        menu.add(item2);
        algoMenu.add(item3);
        algoMenu.add(itemIsConnected);
        algoMenu.add(itemPath);
        algoMenu.add(itemTSP);
        MenuGraph.add(ItemGetNode);
        MenuGraph.add(ItemGetEdge);
        MenuGraph.add(ItemConnect);
        MenuGraph.add(ItemRemoveNode);
        MenuGraph.add(ItemRemoveEdge);
        menu.add(algoMenu);
        menu.add(MenuGraph);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        menuBar.add(menu);
        f1.setMenuBar(menuBar);
        f1.setSize(1000, 1000);
        this.pack();


        myf1.setSize(200, 200);
        panel.setLayout(null);
        myf1.add(panel);

        myf2.setSize(200, 200);
        panel1.setLayout(null);
        myf2.add(panel1);

        myf3.setSize(200, 200);
        panel3.setLayout(null);
        myf3.add(panel3);

        myfIsconnectet.setSize(200, 200);
        panelIconnected.setLayout(null);
        myfIsconnectet.add(panelIconnected);

        myfpath.setSize(400, 400);
        panelPath.setLayout(null);
        myfpath.add(panelPath);

        myftsp.setSize(200, 200);
        panelTSP.setLayout(null);
        myftsp.add(panelTSP);

        myfGetNode.setSize(200, 200);
        panelGetnode.setLayout(null);
        myfGetNode.add(panelGetnode);

        myfGetEdge.setSize(200, 200);
        panelgetEdge.setLayout(null);
        myfGetEdge.add(panelgetEdge);

        myfConnect.setSize(200, 200);
        panelConnect.setLayout(null);
        myfConnect.add(panelConnect);

        myfRemoveNode.setSize(200, 200);
        panelRemoveNode.setLayout(null);
        myfRemoveNode.add(panelRemoveNode);

        myfRemoveEdge.setSize(200, 200);
        panelRemoveEdge.setLayout(null);
        myfRemoveEdge.add(panelRemoveEdge);

        ButtonLoad = new JButton("Loading");
        ButtonLoad.setBounds(10, 80, 80, 25);
        ButtonLoad.addActionListener(this);
        panel.add(ButtonLoad);
        text = new JTextField(50);
        text.setBounds(100, 20, 165, 25);
        panel.add(text);

        ButtonSave = new JButton("Saving");
        ButtonSave.setBounds(100, 80, 180, 25);
        ButtonSave.addActionListener(this);
        panel1.add(ButtonSave);
        text1 = new JTextField(50);
        text1.setBounds(100, 20, 165, 25);
        panel1.add(text1);

        ButtonRun = new JButton("CheckPath");
        ButtonRun.setBounds(100, 100, 180, 25);
        ButtonRun.addActionListener(this);
        panelPath.add(ButtonRun);
        textSrcPath = new JTextField(50);
        textSrcPath.setBounds(100, 20, 165, 25);
        TDP = new JTextField(50);
        TDP.setBounds(100, 60, 165, 25);
        panelPath.add(textSrcPath);
        panelPath.add(TDP);

        ButtonTSP = new JButton("CheckTSP");
        ButtonTSP.setBounds(100, 100, 180, 25);
        ButtonTSP.addActionListener(this);
        panelTSP.add(ButtonTSP);
        TSPSrc = new JTextField(50);
        TSPSrc.setBounds(100, 20, 165, 25);
        TSPDest = new JTextField(50);
        TSPDest.setBounds(100, 50, 165, 25);
        panelTSP.add(TSPSrc);
        panelTSP.add(TSPDest);
        // ButtonTSP=new JButton("center");
        // ButtonCenter.setBounds(10,140,40,25);
        //ButtonCenter.addActionListener(this);

        f1.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        algo = new Algo();

        String str = e.getActionCommand();
        if (str.equals("load")) {
            label = new JLabel("load");
            label.setBounds(10, 20, 80, 25);
            panel.add(label);
            myf1.setVisible(true);
        }

        if (str.equals("Loading")) {
            t = text.getText();
            System.out.println(t);
            try {
                this.algo.load(t);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            myGraph = algo.getGraph();
            myf1.setVisible(true);
            p = new DisplayGraphics(algo);
            f1.add(p);


            f1.repaint();
            this.add(Npanelrun);
            f1.add(p);
            f1.setSize(1000, 1000);


            //f.setLayout(null);
            f1.setVisible(true);


        }

        if (str.equals("save")) {
            label1 = new JLabel("save:");
            label1.setBounds(10, 20, 80, 25);
            panel1.add(label1);
            myf2.setVisible(true);
        }
        if (str.equals("saving")) {
            String t = text1.getText();
            boolean a = this.algo.save(t);


            myf2.setVisible(true);
        }

        if (str.equals("center")) {
            algo.init(myGraph);
            int center1 = algo.center().getKey();
            labelCenter = new JLabel("center= " + center1);
            labelCenter.setBounds(10, 20, 80, 25);
            panel3.add(labelCenter);
            myf3.setVisible(true);
        }
        if (str.equals("IsConnected?")) {
            algo.init(myGraph);
            boolean connected = algo.isConnected();
            labelCenter = new JLabel(String.valueOf(connected));
            labelCenter.setBounds(10, 20, 80, 25);
            panelIconnected.add(labelCenter);
            myfIsconnectet.setVisible(true);
        }
        if (str.equals("Shorted path")) {
            labelWight = new JLabel("setNodes:");
            labelWight.setBounds(10, 20, 80, 25);
            panelPath.add(labelWight);
            myfpath.setVisible(true);
        }
        if (str.equals("CheckPath")) {
            String s = textSrcPath.getText();
            String d = TDP.getText();
            int src = Integer.parseInt(s);
            int dest = Integer.parseInt(d);
            algo.init(myGraph);
            double dist = algo.shortestPathDist(src, dest);
            if (labelWight.getText() != "") {
                labelWight.setText(String.valueOf(dist));
            } else {
                labelWight = new JLabel(String.valueOf(dist));
            }
            labelWight.setBounds(100, 140, 180, 25);
            panelPath.add(labelWight);
            myfpath.setVisible(true);
        }
        if (str.equals("findTSP")) {
            labeltsp = new JLabel("setNodes:");
            labeltsp.setBounds(10, 20, 80, 25);
            panelTSP.add(labeltsp);
            myftsp.setVisible(true);

            myftsp.setVisible(true);
        }
        if (str.equals("CheckTSP")) {
            String s = TSPSrc.getText();
            String d = TSPDest.getText();
            int src = Integer.parseInt(s);
            int dest = Integer.parseInt(d);
            algo.init(myGraph);
            String lis = new String();
            ArrayList<NodeData> ts = (ArrayList<NodeData>) algo.tsp(algo.shortestPath(src, dest));
            for (int i = 0; i < ts.size(); i++) {
                int cur = ts.get(i).getKey();
                lis += cur + ",";
            }
            if (labeltsp.getText() != "") {
                labeltsp.setText(lis);
            } else {
                labeltsp = new JLabel(lis);
            }
            labeltsp.setBounds(100, 130, 180, 100);
            panelTSP.add(labeltsp);
            myftsp.setVisible(true);
        }


    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
