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
 * 药品管理Controller
 * 
 * @Title: DictController.java
 * @Package com.huazhukeji.controller
 * @author 耿壮
 * @date 2016年7月27日 上午11:46:41
 * @company 河北华助科技有限公司
 * @version V1.0
 */
@Controller
@RequestMapping("/dict")
public class AnJianController extends BaseController {
	
	@Autowired
	private AnJianService anJianService;
	
	/**
	 * 药品管理主页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/manager", method = RequestMethod.GET)
    public String manager() {
		logger.debug("药品管理主页面");
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
