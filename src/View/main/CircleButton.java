package View.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

public class CircleButton extends JButton {

    private boolean mousePressed = false;

    public CircleButton(String text) {
        super(text);
        setOpaque(false);
        setFocusPainted(false);
        setBorderPainted(false);

        MouseAdapter mouseListener = new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent me) {
                if (contains(me.getX(), me.getY())) {
                    mousePressed = true;
                    repaint();
                }
            }
        };

        addComponentListener(new ComponentAdapter() {

            @Override
            public void componentResized(ComponentEvent e) {
                if (mousePressed) {
                    repaint();
                }
            }

        });

        addMouseListener(mouseListener);
        addMouseMotionListener(mouseListener);
    }

    private int getDiameter(){
        int diameter = Math.min(getWidth(), getHeight());
        return diameter;
    }

    @Override
    public Dimension getPreferredSize(){
        FontMetrics metrics = getGraphics().getFontMetrics(getFont());
        int minDiameter = 10 + Math.max(metrics.stringWidth(getText()), metrics.getHeight());
        return new Dimension(minDiameter, minDiameter);
    }

    @Override
    public boolean contains(int x, int y){
        int radius = getDiameter()/2;
        return Point2D.distance(x, y, getWidth()/2, getHeight()/2) < radius;
    }

    @Override
    public void paintComponent(Graphics g){

        int diameter = getDiameter();
        int radius = diameter/2;

        if(mousePressed){
            g.setColor(new Color (225, 143, 107));
        }
        else{
            g.setColor(new Color(245, 221, 204));
        }
        g.fillOval(getWidth()/2 - radius, getHeight()/2 - radius, diameter, diameter);

        if(mousePressed){
            g.setColor(new Color (225, 143, 107));
        }
        else{
            g.setColor(Color.DARK_GRAY);
        }
        g.drawOval(getWidth()/2 - radius, getHeight()/2 - radius, diameter, diameter);

        g.setColor(Color.BLACK);
        g.setFont(getFont());
        FontMetrics metrics = g.getFontMetrics(getFont());
        int stringWidth = metrics.stringWidth(getText());
        int stringHeight = metrics.getHeight();
        g.drawString(getText(), getWidth()/2 - stringWidth/2, getHeight()/2 + stringHeight/4);
    }

    public void setDisabled(){
        mousePressed = false;
    }

}
