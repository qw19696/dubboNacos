package service;

import pojo.Song;

import java.util.List;

public interface SongService {
    Song getSong(int id);

    List<Song> getAllSong();
}
