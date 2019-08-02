package com.netease.miniadmin.service;

import com.github.pagehelper.Page;
import com.netease.miniadmin.model.Tag;

import java.util.List;

/**
 * author cuiyang
 */
public interface TagService {
    /**
     * 增
     */
    void insertTag(Tag tag);

    /**
     * 删
     */
    int deleteTag(Integer id);


    /**
     * 改
     */
     Integer updateTag(Tag tag);


    /**
     * 查
     */
    List<Tag> selectAllTags();

    Page<Tag> selectTagsByType( Integer tagType);

    Tag selectTagById(Integer id);
}
