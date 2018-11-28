package com.easy.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easy.commons.base.BaseController;
import com.easy.model.Reg;
import com.easy.service.RegService;

/**
 * 注册
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/reg")
public class RegController extends BaseController {
	
	@Autowired
	private RegService regService;
	
    /**
     * 跳转首页
     *
     * @return
     */
    @RequestMapping("/manager")
    public String index() {
        return "reg/manager";
    }
    
    /**
     * 注册
     *
     * @return
     */
    @RequestMapping(value ="/add")
    @ResponseBody
    public Object add(Reg reg) {
    	logger.debug("提交注册");
        try {
        	reg.setPassword(encryption(reg.getPassword()));
        	regService.addUsers(reg);
        	reg.setUserid(reg.getId());
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return renderError("添加失败");
		}
        return renderSuccess("添加成功");
    }
    
    /**
     * 查询用户名
     * @param loginname
     * @return
     */
    @RequestMapping(value ="/checkLoginName")
    @ResponseBody
    public String checkLoginName(String loginname){
    	try {
    		return regService.checkLoginName(loginname) + "";
		} catch (Exception e) {
			logger.error("");
			e.printStackTrace();
			return "1";
		}
    }
    
    /**
     * 查询昵称
     * @param checkname
     * @return
     */
    @RequestMapping(value ="/checkName")
    @ResponseBody
    public String checkName(String checkname){
    	try {
    		return regService.checkName(checkname) + "";
		} catch (Exception e) {
			logger.error("");
			e.printStackTrace();
			return "1";
		}
    }
    
    /**
     * MD5加密
     * @param msg
     * @return
     */
    public String encryption(String md5) {
        String re_md5 = new String();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            
            md.update(md5.getBytes());
            byte b[] = md.digest();
 
            int i;
 
            StringBuilder bud = new StringBuilder("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    bud.append("0");
                bud.append(Integer.toHexString(i));
            }
 
            re_md5 = bud.toString();
            return re_md5;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
   
}
