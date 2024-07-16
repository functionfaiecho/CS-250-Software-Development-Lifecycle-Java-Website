import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import javax.swing.*;
import javax.swing.border.*;

// Entry point for the TopFiveDestinationList application
public class TopFiveDestinationList {
    public static void main(String[] args) {
        // Use SwingUtilities to ensure the UI updates happen on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Create and display the main application frame
                TopDestinationListFrame topDestinationListFrame = new TopDestinationListFrame();
                topDestinationListFrame.setTitle("Top 5 Destination List");
                topDestinationListFrame.getContentPane().setBackground(Color.decode("#FAE3C6")); // Set background color
                topDestinationListFrame.setVisible(true);
            }
        });
    }
}

// JFrame subclass to represent the main window of the application
class TopDestinationListFrame extends JFrame {
    private DefaultListModel<TextAndIcon> listModel;

    public TopDestinationListFrame() {
        super("Top Five Destination List");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(900, 750); // Set the initial size of the frame

        listModel = new DefaultListModel<>();
        
        // Label with my name.
        JLabel nameLabel = new JLabel("Created by Faizah");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nameLabel.setBorder(new EmptyBorder(10, 0, 10, 0));

        // Add destination items to the list
        addDestinationNameAndPicture("1. Auckland, New Zealand", "The multi-cultural and vibrant financial capital of New Zealand.", new ImageIcon(getClass().getResource("/resources/Auckland.jpg")), "https://www.newzealand.com/nz/auckland/");
        addDestinationNameAndPicture("2. Singapore", "Lovingly referred to as the 'Little Red Dot' and home to the world's best airport.", new ImageIcon(getClass().getResource("/resources/Singapore.jpg")), "https://www.visitsingapore.com/en/");
        addDestinationNameAndPicture("3. Dubai, United Arab Emirates", "This urban jungle is the place to be for all your shopping needs and memories to last a lifetime.", new ImageIcon(getClass().getResource("/resources/Dubai.jpg")), "https://www.visitdubai.com/en/");
        addDestinationNameAndPicture("4. Vienna, Austria", "The hills are alive, with the sound of music.", new ImageIcon(getClass().getResource("/resources/Vienna.jpg")), "https://www.austria.info/en/where-to-go/cities/vienna");

        JList<TextAndIcon> list = new JList<>(listModel);
        list.setBackground(Color.decode("#FAE3C6")); // Set list background color
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.getViewport().setBackground(Color.decode("#A9e4ef")); // Set scroll pane background color

        // Set custom renderer for list items with padding
        TextAndIconListCellRenderer renderer = new TextAndIconListCellRenderer(10, 10, 10, 10);
        list.setCellRenderer(renderer);
        
        // Add mouse listener for click events on list items
        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JList<?> list = (JList<?>) e.getSource();
                int index = list.locationToIndex(e.getPoint());
                TextAndIcon item = (TextAndIcon) list.getModel().getElementAt(index);
                if (Desktop.isDesktopSupported()) {
                    try {
                        // Open the URL in the default browser
                        Desktop.getDesktop().browse(new URI(item.getUrl()));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        // Set layout and add components to the frame
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(nameLabel, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    // Helper method to add destinations to the list model
    private void addDestinationNameAndPicture(String name, String description, Icon icon, String url) {
        TextAndIcon tai = new TextAndIcon(name, description, icon, url);
        listModel.addElement(tai);
    }
}

// Class to encapsulate destination data
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

// Custom renderer for list items to display text and icon
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
        // Set the text with HTML to include the description and link
        setText("<html><a href='" + value.getUrl() + "'>" + value.getName() + "</a><br/><span style='font-weight: normal;'>" + value.getDescription() + "</span></html>");
        setIcon(value.getIcon());

        // Change background and foreground colors based on selection state
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        // Set border based on focus state
        Border outsideBorder = hasFocus ? UIManager.getBorder("List.focusCellHighlightBorder") : NO_FOCUS_BORDER;
        setBorder(BorderFactory.createCompoundBorder(outsideBorder, insideBorder));

        setComponentOrientation(list.getComponentOrientation());
        setEnabled(list.isEnabled());
        setFont(list.getFont());

        return this;
    }

    // Override methods to improve performance
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
