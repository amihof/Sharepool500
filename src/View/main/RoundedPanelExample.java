package View.main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;

/**
 * a class that makes the panels with rounded corners, so the GUI looks better. Refer to this class
 * when you need to make a panel with rounded corners
 */
public class RoundedPanelExample{
    private JLabel searchText;
    private JTextField search;
    private JTextField kategori;
    private JTextField datum;
    private JButton searchRuta;

    public static JPanel roundedPanelExample()
    {
        Color myNewColor = new Color (225, 143, 107);

        Color greenColor = new Color (167, 203, 156, 255);

        JPanel p1 = new RoundedPanel(20, myNewColor);
        p1.setBounds(120,160,350,300);
        p1.setOpaque(false);
        p1.setLayout(null);

        return p1;

    }

    static class RoundedPanel extends JPanel
    {
        private Color backgroundColor;
        private int cornerRadius = 15;

        public RoundedPanel(int radius, Color bgColor) {
            super();
            cornerRadius = radius;
            backgroundColor = bgColor;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Dimension arcs = new Dimension(cornerRadius, cornerRadius);
            int width = getWidth();
            int height = getHeight();
            Graphics2D graphics = (Graphics2D) g;
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            //Draws the rounded panel with borders.
            if (backgroundColor != null) {
                graphics.setColor(backgroundColor);
            } else {
                graphics.setColor(getBackground());
            }
            graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint background
            graphics.setColor(getForeground());
           // graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint border
        }
    }

    public static class RoundedTextField extends JTextField
    {
        private Shape shape;
        public RoundedTextField(int size) {
            super(size);
            setOpaque(false); // As suggested by @AVD in comment.
        }
        protected void paintComponent(Graphics g) {
            g.setColor(getBackground());
            g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
            super.paintComponent(g);
        }
        protected void paintBorder(Graphics g) {
           // g.setColor(getForeground());
            g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
        }
        public boolean contains(int x, int y) {
            if (shape == null || !shape.getBounds().equals(getBounds())) {
                shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
            }
            return shape.contains(x, y);
        }
    }

    public static class CircleBtn extends  JButton {
        public CircleBtn(String text) {
            super(text);

            Dimension size = getPreferredSize();
            size.width = size.height = Math.max(size.width, size.height);
            setPreferredSize(size);

            setContentAreaFilled(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            if (getModel().isArmed()) {
                g.setColor(Color.GREEN);//Цвет фона при нажатой кнопке
                setForeground(Color.yellow);//Цвет надписи при нажатой кнопке
            } else {
                g.setColor(getBackground());//Цвет фона
                setForeground(Color.BLACK);//Цвет надписи
            }
            g.fillRoundRect(0, 0, getSize().width - 1, getSize().height - 1, 13, 13);

            super.paintComponent(g);
        }

        @Override
        protected void paintBorder(Graphics g) {
            //g.setColor(getForeground());
            //g.drawRoundRect(0, 0, getSize().width - 1, getSize().height - 1, 13,13);
        }
    }
}

