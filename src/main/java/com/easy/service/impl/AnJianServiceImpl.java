package com.easy.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easy.commons.utils.PageInfo;
import com.easy.mapper.DatasourceMapper;
import com.easy.model.Datasource;
import com.easy.service.AnJianService;

/**
 * 药品管理
 * 
 * @Title: DictServiceImpl.java
 * @Package com.huazhukeji.service.impl
 * @author 耿壮
 * @date 2016年7月27日 上午11:29:18
 * @company 河北华助科技有限公司
 * @version V1.0
 */
@Service
public class AnJianServiceImpl implements AnJianService {
	
	@Autowired
	private DatasourceMapper datasourceMapper;

	/**
	 * 查找类目录
	 * 
	 */
	@Override
	public void findDataGrid(PageInfo pageInfo) {
		pageInfo.setRows(datasourceMapper.findDictPageCondition(pageInfo));
        pageInfo.setTotal(datasourceMapper.findDictPageCount(pageInfo));
	}

	/**
	 * 解析excel
	 */
	@Override
	public void uploadDatasource(Long id, Integer orgId, Long userId) throws Exception {
		Datasource record = new Datasource();
		record.setFileid(id);
		record.setOrgid(orgId);
		record.setUptime(new Date());
		record.setUserid(userId);
		datasourceMapper.insert(record);
	}
}
