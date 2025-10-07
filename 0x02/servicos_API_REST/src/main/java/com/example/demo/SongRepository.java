package com.example.demo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SongRepository {
    private List<Song> list = new ArrayList<Song>();

    public SongRepository() {
        this.list.add(new Song(1, "Bohemian Rhapsody", "Queen", "A Night at the Opera", "1975"));
        this.list.add(new Song(2, "Imagine", "John Lennon", "Imagine", "1971"));
    }

    public List<Song> getAllSongs() {
        return list;
    }

    public Song getSongById(Integer id) {
        return this.list.stream().filter(song -> song.getId().equals(id)).findFirst().get();
    }

    public void addSong(Song s) {
        this.list.add(s);
    }

    public void updateSong(Song s) {
        this.list.replaceAll(song -> song.getId().equals(s.getId()) ? s : song);
    }

    public void removeSong(Song s) {
        this.list.remove(s);
    }
}
