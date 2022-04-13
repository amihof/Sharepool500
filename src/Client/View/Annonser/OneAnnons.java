package Client.View.Annonser;

import javax.swing.*;
import java.awt.*;

public class OneAnnons extends JPanel {

    public OneAnnons(){
        GridLayout annonsLayout = new GridLayout(0,1,10,10);
        this.setLayout(annonsLayout);
        this.setPreferredSize(new Dimension(475,300));

        JPanel testPanel = new JPanel();
        testPanel.setBackground(Color.RED);

        this.add(testPanel);

        JPanel testPanel2 = new JPanel();
        testPanel2.setBackground(Color.BLUE);
        this.add(testPanel2);

        /*for (int i = 0; i < numberOfParams; ++i) {
            yourSettingsPanel.add(labels[i]);
            yourSettingsPanel.add(components[i]);
        }

        JPanel northOnlyPanel = new JPanel();
        northOnlyPanel.setLayout(new BorderLayout());
        northOnlyPanel.add(yourSettingsPanel, BorderLayout.NORTH);

        JScrollPane scroll = new JScrollPane(northOnlyPanel,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        this.add(scroll, BorderLayout.CENTER);*/
    }
}
