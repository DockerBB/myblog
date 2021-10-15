package com.wf.myblog.Controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wf.myblog.Bean.Blog;
import com.wf.myblog.Bean.User;
import com.wf.myblog.Service.*;
import com.wf.myblog.queryenc.BlogIndex;
import com.wf.myblog.queryenc.BlogQuery;
import com.wf.myblog.queryenc.BlogTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class indexController {
    @Autowired
    UserService userService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    TagService tagService;

    @Autowired
    BlogService blogService;

    @RequestMapping("/index")
    public String index(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        String orderBy = "id desc";
        PageHelper.startPage(pageNum, 5, orderBy);
        List<BlogIndex> BlogsDigit = blogService.getBlogDigit();
        System.out.println(BlogsDigit.toString());
        PageInfo<BlogIndex> pageInfo = new PageInfo<>(BlogsDigit);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("types", categoryService.listType());
        model.addAttribute("tags", tagService.listTag());

        List<BlogTitle> blogTitles = blogService.getBlogTitle();
        System.out.println(blogTitles.toString());
        model.addAttribute("blogRecommend", blogTitles);
        return "index";
    }

    @RequestMapping("/blog/page")
    public String blogPage(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        System.out.println(pageNum);
        String orderBy = "id desc";
        PageHelper.startPage(pageNum, 5, orderBy);
        List<BlogIndex> BlogsDigit = blogService.getBlogDigit();
        System.out.println(BlogsDigit.toString());

        PageInfo<BlogIndex> pageInfo = new PageInfo<>(BlogsDigit);
        model.addAttribute("pageInfo", pageInfo);
        return "index :: blogList";
    }

    @RequestMapping("/blog")
    public String Blog() {
        return "blog";
    }

    @RequestMapping("/blog/{id}")
    public String getBlog(Model model, @PathVariable Long id) {
        BlogIndex blog = blogService.getBlogDigitById(id);
        System.out.println(blog.toString());
        model.addAttribute("blog", blog);
        return "blog";
    }

    @RequestMapping("/about")
    public String About() {
        return "about";
    }

    @RequestMapping("/archives")
    public String archives() {
        return "archives";
    }

    @RequestMapping("/category")
    public String category() {
        return "category";
    }

    @RequestMapping("/tags")
    public String tags() {
        return "tags";
    }

}
