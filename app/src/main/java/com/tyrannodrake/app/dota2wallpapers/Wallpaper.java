package com.tyrannodrake.app.dota2wallpapers;

/**
 * Created by rajat on 6/8/2016.
 */
public class Wallpaper {
    private String name;
   // private int numOfSongs;
    private int thumbnail;

    public Wallpaper() {
    }

    public Wallpaper(String name, int thumbnail) {
        this.name = name;
       // this.numOfSongs = numOfSongs;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public int getNumOfSongs() {
//        return numOfSongs;
//    }

//    public void setNumOfSongs(int numOfSongs) {
//        this.numOfSongs = numOfSongs;
//    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
