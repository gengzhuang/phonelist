package com.easy.mapper;

import java.util.List;

import com.easy.commons.utils.PageInfo;
import com.easy.model.Datasource;

public interface DatasourceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Datasource record);

    int insertSelective(Datasource record);

    Datasource selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Datasource record);

    int updateByPrimaryKey(Datasource record);

	Integer findDictPageCount(PageInfo pageInfo);

	List findDictPageCondition(PageInfo pageInfo);
}