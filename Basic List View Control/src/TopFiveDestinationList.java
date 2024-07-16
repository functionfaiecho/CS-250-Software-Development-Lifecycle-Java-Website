import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import javax.swing.*;
import javax.swing.border.*;

public class TopFiveDestinationList {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TopDestinationListFrame topDestinationListFrame = new TopDestinationListFrame();
                topDestinationListFrame.setTitle("Top 5 Destination List");
                topDestinationListFrame.getContentPane().setBackground(Color.decode("#FAE3C6"));
                topDestinationListFrame.setVisible(true);
            }
        });
    }
}

@SuppressWarnings("serial")
class TopDestinationListFrame extends JFrame {
    private DefaultListModel<TextAndIcon> listModel;

    public TopDestinationListFrame() {
        super("Top Five Destination List");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(900, 750);

        listModel = new DefaultListModel<>();
        
        //Label with my name on it.
        
        JLabel nameLabel = new JLabel("Created by Faizah");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nameLabel.setBorder(new EmptyBorder(10, 0, 10, 0));
        
        // Clickable links to "the most popular travel package". 

        addDestinationNameAndPicture("1. Auckland, New Zealand", "The multi-cultural and vibrant financial capital of New Zealand.", new ImageIcon(getClass().getResource("/resources/Auckland.jpg")), "https://www.newzealand.com/nz/auckland/");
        addDestinationNameAndPicture("2. Singapore", "Lovingly referred to as the 'Little Red Dot' and home to the world's best airport.", new ImageIcon(getClass().getResource("/resources/Singapore.jpg")), "https://www.visitsingapore.com/en/");
        addDestinationNameAndPicture("3. Dubai, United Arab Emirates", "This urban jungle is the place to be for all your shopping needs and memories to last a lifetime.", new ImageIcon(getClass().getResource("/resources/Dubai.jpg")), "https://www.italia.it/en/lazio/rome");
        addDestinationNameAndPicture("4. Vienna, Austria", "The hills are alive, with the sound of music.", new ImageIcon(getClass().getResource("/resources/Vienna.jpg")), "https://www.austria.info/en/where-to-go/cities/vienna");

        JList<TextAndIcon> list = new JList<>(listModel);
        // Background colour has changed.
        list.setBackground(Color.decode("#FAE3C6"));
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.getViewport().setBackground(Color.decode("#A9e4ef"));

        TextAndIconListCellRenderer renderer = new TextAndIconListCellRenderer(10, 10, 10, 10); // Add padding here
        list.setCellRenderer(renderer);
        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JList<?> list = (JList<?>) e.getSource();
                int index = list.locationToIndex(e.getPoint());
                TextAndIcon item = (TextAndIcon) list.getModel().getElementAt(index);
                if (Desktop.isDesktopSupported()) {
                    try {
                        Desktop.getDesktop().browse(new URI(item.getUrl()));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(nameLabel, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    private void addDestinationNameAndPicture(String name, String description, Icon icon, String url) {
        TextAndIcon tai = new TextAndIcon(name, description, icon, url);
        listModel.addElement(tai);
    }
}

class TextAndIcon {
    private String name;
    private String description;
    private Icon icon;
    private String url;

    public TextAndIcon(String name, String description, Icon icon, String url) {
        this.name = name;
        this.description = description;
        this.icon = icon;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Icon getIcon() {
        return icon;
    }

    public String getUrl() {
        return url;
    }
}

class TextAndIconListCellRenderer extends JLabel implements ListCellRenderer<TextAndIcon> {
    private static final Border NO_FOCUS_BORDER = new EmptyBorder(1, 1, 1, 1);
    private Border insideBorder;

    public TextAndIconListCellRenderer() {
        this(0, 0, 0, 0);
    }

    public TextAndIconListCellRenderer(int padding) {
        this(padding, padding, padding, padding);
    }

    public TextAndIconListCellRenderer(int topPadding, int rightPadding, int bottomPadding, int leftPadding) {
        insideBorder = BorderFactory.createEmptyBorder(topPadding, leftPadding, bottomPadding, rightPadding);
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends TextAndIcon> list, TextAndIcon value,
                                                  int index, boolean isSelected, boolean hasFocus) {
        setText("<html><a href='" + value.getUrl() + "'>" + value.getName() + "</a><br/>" + value.getDescription() + "</html>");
        setIcon(value.getIcon());

        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        Border outsideBorder = hasFocus ? UIManager.getBorder("List.focusCellHighlightBorder") : NO_FOCUS_BORDER;
        setBorder(BorderFactory.createCompoundBorder(outsideBorder, insideBorder));

        setComponentOrientation(list.getComponentOrientation());
        setEnabled(list.isEnabled());
        setFont(list.getFont());

        return this;
    }

    @Override
    public void validate() {}
    @Override
    public void invalidate() {}
    @Override
    public void repaint() {}
    @Override
    public void revalidate() {}
    @Override
    public void repaint(long tm, int x, int y, int width, int height) {}
    @Override
    public void repaint(Rectangle r) {}
}
