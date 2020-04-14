/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tescrud;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author sistem
 */
public class CFilm {

    MFilm mFilm;
    VFilm vFilm;
    String dataTerpilih;

    public CFilm(MFilm mFilm, VFilm vFilm) {
        this.mFilm = mFilm;
        this.vFilm = vFilm;

        if (mFilm.getBykData() != 0) {
            String dataFilm[][] = mFilm.ReadFilm();
            vFilm.table.setModel((new JTable(dataFilm, vFilm.judult)).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Data tidak ada");
        }
        vFilm.create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vFilm.getJudul().equals("")
                        || vFilm.getTipe().equals("")
                        || vFilm.getEpisode().equals("")) {
                    JOptionPane.showMessageDialog(null, "Field tidak boleh kosong");
                } else {
                    String judul = vFilm.getJudul();
                    String tipe = vFilm.getTipe();
                    String episode = vFilm.getEpisode();
                    String genre = vFilm.getGenre();
                    String status = vFilm.getStatus();
                    String rating = vFilm.getRating();
                    mFilm.InsertFilm(judul, tipe, episode, genre, status, rating);

                    String dataFilm[][] = mFilm.ReadFilm();
                    vFilm.table.setModel(new JTable(dataFilm, vFilm.judult).getModel());
                }
            }
        });

        vFilm.update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = dataTerpilih;

                String judul = vFilm.getJudul();
                String tipe = vFilm.getTipe();
                String episode = vFilm.getEpisode();
                String genre = vFilm.getGenre();
                String status = vFilm.getStatus();
                String rating = vFilm.getRating();
                mFilm.UpdateFilm(id, judul, tipe, episode, genre, status, rating);

                String dataFilm[][] = mFilm.ReadFilm();
                vFilm.table.setModel(new JTable(dataFilm, vFilm.judult).getModel());
            }
        }
        );

        vFilm.delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = dataTerpilih;
                mFilm.DeleteFilm(id);

                String dataFilm[][] = mFilm.ReadFilm();
                vFilm.table.setModel(new JTable(dataFilm, vFilm.judult).getModel());
            }
        }
        );

        vFilm.exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        vFilm.refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vFilm.tjudul.setText("");
                vFilm.ttipe.setText("");
                vFilm.tepisode.setText("");
                vFilm.tgenre.setText("");
                vFilm.cstatus.addItem("--Pilihan--");
                vFilm.trating.setText("");
                vFilm.tsearch.setText("");

            }
        });

        vFilm.search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String jd = vFilm.tsearch.getText();

                mFilm.SearchFilm(jd);

                String dataFilm[][] = mFilm.SearchFilm(jd);
                vFilm.table.setModel(new JTable(dataFilm, vFilm.judult).getModel());
            }
        });
        
         vFilm.table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int baris = vFilm.table.getSelectedRow();
                int kolom = vFilm.table.getSelectedColumn();
                dataTerpilih = vFilm.table.getValueAt(baris, 1).toString();

                String judul = vFilm.table.getValueAt(baris, 2).toString();
                vFilm.tjudul.setText(judul);
                String tipe = vFilm.table.getValueAt(baris, 3).toString();
                vFilm.ttipe.setText(tipe);
                String episode = vFilm.table.getValueAt(baris, 4).toString();
                vFilm.tepisode.setText(episode);
                String genre = vFilm.table.getValueAt(baris, 5).toString();
                vFilm.tgenre.setText(genre);
                String status = vFilm.table.getValueAt(baris, 6).toString();
                vFilm.cstatus.setSelectedItem(status);
                String rating = vFilm.table.getValueAt(baris, 7).toString();
                vFilm.trating.setText(rating);

            }
        });

    }

}
