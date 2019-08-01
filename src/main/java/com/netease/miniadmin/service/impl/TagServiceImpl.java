package com.netease.miniadmin.service.impl;

import com.github.pagehelper.Page;
import com.netease.miniadmin.mapper.TagMapper;
import com.netease.miniadmin.model.Tag;
import com.netease.miniadmin.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagMapper tagMapper;

    public TagServiceImpl() {
        super();
    }

    @Override
    public void insertTag(Tag tag) {
        if (tag != null) {
            tagMapper.insert(tag);
        }
    }

    @Override
    public int deleteTag(Integer id) {
        if (id != null) {
            return tagMapper.deleteByPrimaryKey(id);
        } else {
            return 0;
        }
    }

    @Override
    public Integer updateTag(Tag tag) {
        if (tag != null) {
            return tagMapper.updateByPrimaryKey(tag);
        }
        return null;
    }

    @Override
    public List<Tag> selectAllTags() {
        return tagMapper.selectAllTags();
    }

    @Override
    public Page<Tag> selectTagsByType(Integer tagType) {
        if ( tagType != null) {
            return tagMapper.selectTagsByType(tagType);
        } else {
            return null;
        }
    }
}
