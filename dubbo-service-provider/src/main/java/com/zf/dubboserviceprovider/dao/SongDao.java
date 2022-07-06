package com.zf.dubboserviceprovider.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import pojo.Song;

import java.util.List;

@Mapper
public interface SongDao extends BaseMapper<Song> {

    @Select("select s.name,s.introduction,e.name as singerName " +
            "from song s " +
            "inner join singer e on s.singer_id = e.id " +
            "where s.id = #{id}")
    Song getSong(@Param("id") int id);


    @Select("select s.name,s.introduction,e.name as singerName " +
            "from song s " +
            "inner join singer e on " +
            "s.singer_id=e.id ")
    List<Song> getAllSong();
}
