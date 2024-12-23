package com.example;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class ColumnSelectBorder {
    public static void main(String[] args) {
        // Membuat frame
        JFrame frame = new JFrame("");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 400);

        // Data tabel
        String[][] data = {
            {"123", "John"},
            {"123", "Jane"},
            {"124123", "Jono"},
            {"1241234", "Agus"}
        };

        // Header tabel
        String[] columnNames = {"NIM", "Nama"};

        // Deklarasikan JTable terlebih dahulu
        JTable table = new JTable();
        
        // Inisialisasi JTable dengan data
        table.setModel(new DefaultTableModel(data, columnNames));

        // Override method prepareRenderer untuk styling
        JTable finalTable = table; // Variabel 'final' untuk akses di dalam anonymous class
        table = new JTable(data, columnNames) {
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component c = super.prepareRenderer(renderer, row, column);

                // Warna selang-seling untuk background
                if (!isRowSelected(row)) {
                    if (row % 2 == 0) {
                        c.setBackground(Color.WHITE); // Baris genap: putih
                    } else {
                        c.setBackground(new Color(0xF0F0F0)); // Baris ganjil: abu-abu muda
                    }
                } else {
                    c.setBackground(new Color(0xDCF0FF)); // Biru muda jika baris dipilih
                }

                // Menentukan border jika kolom dipilih
                if (finalTable.getSelectedColumn() == column) {
                    ((JComponent) c).setBorder(BorderFactory.createLineBorder(new Color(0x007FFF), 2)); // Border biru
                } else {
                    ((JComponent) c).setBorder(BorderFactory.createEmptyBorder()); // Border default
                }

                return c;
            }
        };

        // Mengaktifkan pemilihan kolom
        table.setColumnSelectionAllowed(true);
        table.setRowSelectionAllowed(false);

        // Mengatur header style
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 12));
        header.setBackground(new Color(0xC8C8C8)); // Warna abu-abu terang
        header.setForeground(Color.BLACK);

        // Mengatur tinggi baris
        table.setRowHeight(25);

        // Menambahkan tabel ke dalam scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        // Menambahkan ke frame
        frame.add(scrollPane);
        frame.setVisible(true);
    }
}
