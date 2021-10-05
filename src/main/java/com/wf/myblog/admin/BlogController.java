package com.wf.myblog.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wf.myblog.Bean.Blog;
import com.wf.myblog.Bean.Type;
import com.wf.myblog.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("getAllBlog")
    public String Blog(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        String orderBy = "id asc";
        PageHelper.startPage(pageNum, 10, orderBy);
        List<Blog> Blogs = blogService.getAllBlog();
        PageInfo<Blog> pageInfo = new PageInfo<>(Blogs);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/manage";
    }
}
