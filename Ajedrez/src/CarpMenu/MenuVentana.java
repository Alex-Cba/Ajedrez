package CarpMenu;

import Tablero.Tablero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuVentana extends JFrame implements ActionListener
{
    private JButton jugarButton;
    private JButton salirButton;
    private JPanel panelPrincipal;
    private Tablero _tablero = new Tablero();

    public MenuVentana()
    {
        setTitle("Ajedrez");
        setSize(756,500);
        setLocationRelativeTo(null);

        add(panelPrincipal);

        //Colocar el cursor con forma de Mano
        jugarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jugarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jugarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                jugarButton.setFont(new Font("Roboto", Font.TRUETYPE_FONT, 22));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                jugarButton.setCursor(Cursor.getDefaultCursor());
            }
        });

        salirButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        salirButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                salirButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                salirButton.setFont(new Font("Roboto", Font.TRUETYPE_FONT, 22));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                salirButton.setCursor(Cursor.getDefaultCursor());
            }
        });

        jugarButton.addActionListener(this);
        salirButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jugarButton) {

            this.dispose();
            SwingUtilities.invokeLater(new Runnable()
            {
                @Override
                public void run() {
                    _tablero.setVisible(true);
                }
            });

        } else if (e.getSource() == salirButton) {

            int resp = JOptionPane.showConfirmDialog(null, "¿Seguro? Que desea salir de la aplicación", "", JOptionPane.YES_NO_OPTION);

            if (resp == JOptionPane.YES_OPTION) {

                System.exit(0);

            } else {
                //Vacio
            }

        }
    }
}
