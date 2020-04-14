/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tescrud;

/**
 *
 * @author sistem
 */
public class MVC {

    MFilm mFilm = new MFilm();
    VFilm vFilm = new VFilm();

    CFilm cFilm = new CFilm(mFilm, vFilm);

}
