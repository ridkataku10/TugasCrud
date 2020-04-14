/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tescrud;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author sistem
 */
public class VFilm extends JFrame {

    DefaultTableModel model;
    JTable table;
    String judult[] = {"#", "ID", "Judul", "Tipe", "Episode", "Genre", "Status", "Rating"};
    JScrollPane sp;
    
    JLabel judul = new JLabel("Judul: ");
    JTextField tjudul = new JTextField();
    JLabel tipe = new JLabel("Tipe");
    JTextField ttipe = new JTextField();
    JLabel episode = new JLabel("Episode: ");
    JTextField tepisode = new JTextField();
    JLabel genre = new JLabel("Genre: ");
    JTextField tgenre = new JTextField();
    JLabel status = new JLabel("Status: ");
    String[] sts = {"--Pilihan--", "Belum selesai", "Selesai"};
    JComboBox cstatus = new JComboBox(sts);
    JLabel rating = new JLabel("Rating: ");
    JTextField trating = new JTextField();
    JTextField tsearch = new JTextField();
    JButton search = new JButton("Search");
    JButton refresh = new JButton("Refresh");
    JButton create = new JButton("Create");
    JButton update = new JButton("Update");
    JButton delete = new JButton("Delete");
    JButton exit = new JButton("Exit");

    VFilm() {
        setTitle("Rekap Data Film");
        setSize(950, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);

        model = new DefaultTableModel(judult, 0);
        table = new JTable(model);
        sp = new JScrollPane(table);
        add(sp).setBounds(30, 20, 900, 200);
        sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        add(judul).setBounds(30, 230, 90, 20);
        add(tjudul).setBounds(30, 250, 300, 20);
        add(tipe).setBounds(30, 280, 90, 20);
        add(ttipe).setBounds(30, 300, 120, 20);
        add(episode).setBounds(30, 330, 90, 20);
        add(tepisode).setBounds(30, 350, 120, 20);
        add(genre).setBounds(30, 380, 90, 20);
        add(tgenre).setBounds(30, 400, 120, 20);
        add(status).setBounds(220, 280, 90, 20);
        add(cstatus).setBounds(220, 300, 100, 20);
        add(rating).setBounds(220, 330, 90, 20);
        add(trating).setBounds(220, 350, 120, 20);
        add(tsearch).setBounds(400, 250, 250, 20);
        add(search).setBounds(660, 250, 90, 20);
        add(refresh).setBounds(400, 400, 90, 20);
        add(create).setBounds(500, 400, 90, 20);
        add(update).setBounds(600, 400, 90, 20);
        add(delete).setBounds(700, 400, 90, 20);
        add(exit).setBounds(800, 400, 90, 20);

       
    }

    public String getJudul() {
        return tjudul.getText();
    }

    public String getTipe() {
        return ttipe.getText();
    }

    public String getEpisode() {
        return tepisode.getText();
    }

    public String getGenre() {
        return tgenre.getText();
    }

    public String getStatus() {
        return (String) cstatus.getSelectedItem();
    }

    public String getRating() {
        return trating.getText();
    }

}
