import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlanoCartesiano2 extends JFrame implements ActionListener {
    private JTextField norteField, surField, esteField, oesteField;
    private JButton graficarButton;
    private JPanel drawingPanel;

    public PlanoCartesiano2() {
        setTitle("Suma de Vectores con Método del Triángulo");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Panel para la entrada de longitudes de vectores
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2, 5, 5));

        inputPanel.add(new JLabel("Longitud del vector Norte:"));
        norteField = new JTextField();
        inputPanel.add(norteField);

        inputPanel.add(new JLabel("Longitud del vector Sur:"));
        surField = new JTextField();
        inputPanel.add(surField);

        inputPanel.add(new JLabel("Longitud del vector Este:"));
        esteField = new JTextField();
        inputPanel.add(esteField);

        inputPanel.add(new JLabel("Longitud del vector Oeste:"));
        oesteField = new JTextField();
        inputPanel.add(oesteField);

        panel.add(inputPanel, BorderLayout.WEST);

        // Panel para el dibujo del plano cartesiano
        drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawVectors(g);
            }
        };
        panel.add(drawingPanel, BorderLayout.CENTER);

        // Botón para graficar los vectores
        graficarButton = new JButton("Graficar Vectores");
        graficarButton.addActionListener(this);
        panel.add(graficarButton, BorderLayout.SOUTH);

        add(panel);
    }

    private void drawVectors(Graphics g) {
        int centerX = drawingPanel.getWidth() / 2;
        int centerY = drawingPanel.getHeight() / 2;

        // Dibujar vector Norte (arriba)
        drawArrow(g, centerX, centerY, centerX, centerY - getLength(norteField), Color.BLUE);

        // Dibujar vector Sur (abajo)
        drawArrow(g, centerX, centerY, centerX, centerY + getLength(surField), Color.RED);

        // Dibujar vector Este (derecha)
        drawArrow(g, centerX, centerY, centerX + getLength(esteField), centerY, Color.GREEN);

        // Dibujar vector Oeste (izquierda)
        drawArrow(g, centerX, centerY, centerX - getLength(oesteField), centerY, Color.MAGENTA);
    }

    private int getLength(JTextField field) {
        try {
            return Integer.parseInt(field.getText());
        } catch (NumberFormatException e) {
            return 0; // Si hay un error en la conversión, se devuelve 0
        }
    }

    private void drawArrow(Graphics g, int x1, int y1, int x2, int y2, Color color) {
        g.setColor(color);
        g.drawLine(x1, y1, x2, y2);

        // Dibujar la punta de la flecha
        int deltaX = x2 - x1;
        int deltaY = y2 - y1;
        double angle = Math.atan2(deltaY, deltaX);
        int arrowLength = 10;
        int arrowX = x2 - (int) (arrowLength * Math.cos(angle - Math.PI / 6));
        int arrowY = y2 - (int) (arrowLength * Math.sin(angle - Math.PI / 6));
        g.drawLine(x2, y2, arrowX, arrowY);
        arrowX = x2 - (int) (arrowLength * Math.cos(angle + Math.PI / 6));
        arrowY = y2 - (int) (arrowLength * Math.sin(angle + Math.PI / 6));
        g.drawLine(x2, y2, arrowX, arrowY);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == graficarButton) {
            drawingPanel.repaint(); // Redibujar los vectores al presionar el botón
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PlanoCartesiano2 ventana = new PlanoCartesiano2();
            ventana.setVisible(true);
        });
    }
}
