package com.easy.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easy.commons.base.BaseController;
import com.easy.commons.utils.PageInfo;
import com.easy.service.AnJianService;

/**
  *  案件管理管理Controller
 *                       
 * @Filename: AnJianController.java
 * @Description: 
 * @Version: V1.0.1
 * @Author: 耿壮
 * @Email: gengzhuang@easy.com
 * @History:<br>
 *
 */
@Controller
@RequestMapping("/anjian")
public class AnJianController extends BaseController {
	
	@Autowired
	private AnJianService anJianService;
	
	/**
	 * 案件管理主页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/manager", method = RequestMethod.GET)
    public String manager() {
		logger.debug("案件管理主页面");
        return "dict/manager";
    }
	
	/**
     * 数据源列表
     * 
     * @return
     */
    @RequestMapping("/dataGrid")
    @ResponseBody
    public Object dataGrid(Integer page, Integer rows, String sort, String order) {
    	logger.debug("数据源列表");
        PageInfo pageInfo = new PageInfo(page, rows);
        Map<String, Object> condition = new HashMap<String, Object>();
        // 非管理员，按照机构筛选数据源
        if (!getCurrentUser().getName().equals("admin"))
        	condition.put("orgId", getCurrentUser().getOrganizationId());
        pageInfo.setCondition(condition);
        anJianService.findDataGrid(pageInfo);
        return pageInfo;
    }
    
    /**
     * 增加数据源
     * 
     * @param id
     * 
     * @return
     */
    @RequestMapping("/uploadDatasource")
    @ResponseBody
    public Object uploadDatasource(Long id) {
    	logger.debug("增加数据源");
        try {
			anJianService.uploadDatasource(id, getCurrentUser().getOrganizationId(), getCurrentUser().getId());
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return renderError("增加数据源失败");
		}
        return renderSuccess("增加数据源成功");
    }
}
