
package PenumpangPesawat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private Flight flight;
    private JTextArea textArea;
    private JTextField nameField;

    public Main() {
        flight = new Flight();
        setTitle("Manajemen Pesawat Penumpang");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        getContentPane().setBackground(new Color(135, 206, 235)); // Warna latar belakang

        // Elemen UI
        nameField = new JTextField(20);
        JButton addButton = new JButton("Add Passenger");
        JButton removeButton = new JButton("Remove Passenger");
        textArea = new JTextArea(10, 30);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(new Color(255, 255, 255));
        textArea.setForeground(new Color(0, 0, 0));

        // Mengatur warna tombol
        addButton.setBackground(new Color(60, 179, 113));
        addButton.setForeground(Color.WHITE);
        removeButton.setBackground(new Color(255, 69, 0));
        removeButton.setForeground(Color.WHITE);

        // Action Listener untuk tombol
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                if (!name.isEmpty()) {
                    if (flight.addPassenger(name)) {
                        nameField.setText("");
                        JOptionPane.showMessageDialog(null, "Passenger added: " + name, "Success", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Passenger already exists: " + name, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    textArea.setText(flight.displayPassengers()); // Tampilkan daftar penumpang
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                if (!name.isEmpty()) {
                    flight.removePassenger(name);
                    nameField.setText("");
                    JOptionPane.showMessageDialog(null, "Passenger removed: " + name, "Success", JOptionPane.INFORMATION_MESSAGE);
                    textArea.setText(flight.displayPassengers()); // Tampilkan daftar penumpang
                }
            }
        });

        // Menambahkan elemen ke JFrame
        add(new JLabel("Passenger Name:"));
        add(nameField);
        add(addButton);
        add(removeButton);
        add(new JScrollPane(textArea));

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}