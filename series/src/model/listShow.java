/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;

public class listShow implements Serializable {
    
    private ArrayList<show> serieslist;
    
    public listShow() {
        serieslist = new ArrayList<>();
    }
    
    public show getShow(int p) {
        return serieslist.get(p);
    }
    
    public void setShow(show s) {
        serieslist.add(s);
    }
    
    public int longuitud() {
        return serieslist.size();
    }
    
    public void removeShow(int p) {
        serieslist.remove(p);
    }
    
    public void updateShow(show s, int p) {
        
        serieslist.get(p).setTitle(s.getTitle());
        serieslist.get(p).setScripwriter(s.getScripwriter());
        serieslist.get(p).setSeasons(s.getSeasons());;
        serieslist.get(p).setGenre(s.getGenre());
        serieslist.get(p).setViews(s.getViews());
        serieslist.get(p).setPlataforma(s.getPlataforma());
        
    }
    
}
