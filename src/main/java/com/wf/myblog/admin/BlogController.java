package com.wf.myblog.admin;

import com.alibaba.druid.sql.visitor.functions.Now;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wf.myblog.Bean.Blog;
import com.wf.myblog.Bean.Type;
import com.wf.myblog.Bean.User;
import com.wf.myblog.Dao.BlogDao;
import com.wf.myblog.Service.BlogService;
import com.wf.myblog.Service.CategoryService;
import com.wf.myblog.Service.TagService;
import com.wf.myblog.queryenc.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.sql.Timestamp;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private TagService tagService;

    @GetMapping("/getAllBlog")
    public String Blog(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        String orderBy = "id asc";
        PageHelper.startPage(pageNum, 10, orderBy);
        List<BlogQuery> Blogs = blogService.getAllBlog();
        System.out.println(Blogs.toString());
        PageInfo<BlogQuery> pageInfo = new PageInfo<>(Blogs);
        model.addAttribute("types",categoryService.listType());
        model.addAttribute("tags", tagService.listTag());
        model.addAttribute("pageInfo", pageInfo);
        return "admin/manage";
    }

    //跳转博客新增页面
    @GetMapping("/blogs/input")
    public String input(Model model) {
        model.addAttribute("types",categoryService.listType());
        model.addAttribute("tags", tagService.listTag());
        model.addAttribute("blog", new Blog());
        return "admin/post_blogs";
    }

    // 博客更新
    @GetMapping("/blogs/{id}")
    public String update(@PathVariable Long id,Model model, RedirectAttributes attributes, HttpSession session) {
        model.addAttribute("types",categoryService.listType());
        model.addAttribute("tags", tagService.listTag());
        model.addAttribute("blog", blogService.getBlogById(id));
        return "admin/post_blogs";
    }

    //    博客新增、更新
    @PostMapping("/blogs")
    public String post(Blog blog, RedirectAttributes attributes, HttpSession session){
        blog.setUser((User) session.getAttribute("user"));
        //设置blog的type
        blog.setType(categoryService.getType(blog.getType().getId()));
        //设置blog中typeId属性
        blog.setTypeId(blog.getType().getId());
        //设置用户id
        blog.setUserId(blog.getUser().getId());
        //初次创建设置新增时间
        if(blog.getId() == null) {
            blog.setCreateTime(new Timestamp(System.currentTimeMillis()));
            int b = blogService.saveBlog(blog);
            if(b == 0){
                attributes.addFlashAttribute("message", "新增失败");
            }else {
                attributes.addFlashAttribute("message", "新增成功");
            }
        }else {
            blog.setUpdateTime(new Timestamp(System.currentTimeMillis()));
            int b = blogService.updateBlog(blog);
            if(b == 0){
                attributes.addFlashAttribute("message", "更新失败");
            }else {
                attributes.addFlashAttribute("message", "更新成功");
            }
        }

        System.out.println(blog.toString());

        return "redirect:/admin/getAllBlog";
    }

    // 博客删除
    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable Long id, RedirectAttributes attributes) {
        int t = blogService.deleteBlog(id);

        return "redirect:/admin/getAllBlog";
    }
}
