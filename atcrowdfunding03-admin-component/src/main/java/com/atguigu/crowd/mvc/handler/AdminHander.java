package com.atguigu.crowd.mvc.handler;

import com.atguigu.crowd.constant.CrowdConstant;
import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.service.api.AdminService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminHander {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/test/ssm.html")
    public String testssm(ModelMap modelMap) {
        List<Admin> adminList = adminService.getAll();
        modelMap.addAttribute("adminList", adminList);
        return "redirect:/admin/to/login/page.html";
    }

    @RequestMapping("admin/to/do/login.html")
    public String dologin(@RequestParam("account") String account, @RequestParam("password") String password, HttpSession session) {
        if (account.length() == 0 || password.length() == 0) {
            return "redirect:/admin/to/login/page.html";
        }
        Admin admin = adminService.getAdminByLoginAccount(account, password);
        session.setAttribute(CrowdConstant.ATTR_NAME_LOGIN_ADMIN, admin);
        return "redirect:/admin/to/main/page.html";
    }

    @RequestMapping("/admin/get/page.html")
    public String getPageInfo(
            @RequestParam(value = "keyword",defaultValue = "") String keyword,
            @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize",defaultValue = "8") Integer pageSize,
            ModelMap modelMap
    ){
        PageInfo<Admin> pageInfo=adminService.getPageHelper(keyword,pageNum,pageSize);
        modelMap.addAttribute(CrowdConstant.ATTR_NAME_PAGE_INFO,pageInfo);
        return "admin-page";

    }

    @RequestMapping("/admin/do/logout.html")
    public String doLogOut(HttpSession session) {
        session.invalidate();
        return "redirect:/admin/to/login/page.html";
    }

    @RequestMapping("admin/remove/{adminId}/{pageNum}/{keyword}.html")
    public String remove(@PathVariable("adminId") Integer adminId,
                         @PathVariable("pageNum") Integer pageNum,
                         @PathVariable("keyword") String keyword
    ){
        adminService.remove(adminId);
        return "redirect:/admin/get/page.html?pageNum="+pageNum+"&keyword="+keyword;
    }

    @RequestMapping("admin/save.html")
    public String adminSave(Admin admin){
        adminService.saveAdmin(admin);
        return "redirect:/admin/get/page.html?pageNum="+Integer.MAX_VALUE;
    }

    @RequestMapping("admin/to/edit/page.html")
    public  String toEditpage(
            @RequestParam(value = "adminId",defaultValue = "") Integer adminId,
            ModelMap modemap
    ){
        Admin admin=adminService.getAdminById(adminId);

        modemap.addAttribute("admin",admin);

        return "admin-edit";
    }
    @RequestMapping("admin/updateAdmin.html")
    public String updateAdmin( Admin admin,
                               @RequestParam(value = "pageNum") Integer pageNum,
                               @RequestParam(value = "keyword") String keyword){
        adminService.update(admin);
        return "redirect:/admin/get/page.html?pageNum="+pageNum+"&keyword="+keyword;
    }
}
