package com.zf.dubboserviceprovider.service;

import com.zf.dubboserviceprovider.dao.SongDao;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import pojo.Song;
import service.SongService;

import java.util.List;

@DubboService(version = "1.0",timeout = 3000)
public class SongServiceImpl implements SongService {

    @Autowired
    private SongDao songDao;

    @Override
    public Song getSong(int id) {
        return songDao.getSong(id);
    }

    @Override
    public List<Song> getAllSong() {
        return songDao.getAllSong();
    }
}
