/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

public class show implements  Serializable{
    
    private String title;
    private String  scripwriter;
    private int seasons;
    private String genre;
    private int views;
    public String plataforma;
    
    
    //constructor sin nada

    public show(){
        this.title="";
        this.scripwriter="";
        this.seasons=0;
        this.genre="";
        this.views=0;
        this.plataforma="";
    }

    
    //constructor con todos los parametros
    public show(String title,String  scripwriter, int seasons, String genre,int views,String plataforma){
        this.title=title;
        this.scripwriter=scripwriter;
        this.seasons=seasons;
        this.genre=genre;
        this.views=views;
        this.plataforma=plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }
    public String getPlataforma() {
        return plataforma;
    }

    
    public String getTitle() {
        return title;
    }

    public String getScripwriter() {
        return scripwriter;
    }

    public int getSeasons() {
        return seasons;
    }

    public String getGenre() {
        return genre;
    }

    public int getViews() {
        return views;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setScripwriter(String scripwriter) {
        this.scripwriter = scripwriter;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setViews(int views) {
        this.views = views;
    }
    
    
}
