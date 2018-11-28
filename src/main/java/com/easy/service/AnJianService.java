package com.easy.service;

import com.easy.commons.utils.PageInfo;

public interface AnJianService {

	/**
	 * 
	 * @param pageInfo
	 */
	void findDataGrid(PageInfo pageInfo);

	void uploadDatasource(Long id, Integer orgId, Long userId) throws Exception;

}
