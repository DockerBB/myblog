package com.wf.myblog.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wf.myblog.Bean.Type;
import com.wf.myblog.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    // 展示所有分类
    @GetMapping("/getAllType")
    public String TypeList(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        String orderBy = "id desc";
        PageHelper.startPage(pageNum, 10, orderBy);
        List<Type> types = categoryService.listType();
        PageInfo<Type> pageInfo = new PageInfo<>(types);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/category";
    }

    // 跳转到分类发布页面
    @GetMapping("/types/edit")
    public String addCategory() {
        return "admin/post_categorys";
    }

    @GetMapping("types/post")
    public String addCategory(RedirectAttributes attributes) {
        attributes.addFlashAttribute("type",new Type());
        return "redirect:/types/edit";
    }

//    更新分类
    @GetMapping("/types/edit/{id}")
    public String editCategory(@PathVariable Long id, Model model) {
        model.addAttribute("type", categoryService.getType(id));

        return "admin/post_categorys";
    }

    // 删除分类
    @GetMapping("/types/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes attributes) {
        int res = categoryService.delteType(id);
        if(res == 0) {
            attributes.addFlashAttribute("message", "删除失败");
        }else {
            attributes.addFlashAttribute("message","删除成功");
        }
        return "redirect:/getAllType";
    }

    // 新增分类
    @PostMapping("/types")
    public String post(Type type, RedirectAttributes attributes) {
        int res = categoryService.getTypeByName(type.getName());
        System.out.println(res);
        if (res != 0) {
            attributes.addFlashAttribute("message", "不能添加重复的分类");
            return "redirect:/types/edit";
        }
        res = categoryService.saveType(type);
        if(res == 0) {
            attributes.addFlashAttribute("message", "操作失败");
        }else {
            attributes.addFlashAttribute("message", "操作成功");
        }
        return "redirect:/getAllType";
    }

    @PostMapping("/types/{id}")
    public String post(@PathVariable Long id, Type type, RedirectAttributes attributes) {
        int res = categoryService.getTypeByName(type.getName());
        System.out.println(type.toString());
        if (res != 0) {
            attributes.addFlashAttribute("message", "不能添加重复的分类");
            return "redirect:/types/edit/" + id;
        }
        res = categoryService.updateType(id, type);
        if(res == 0) {
            attributes.addFlashAttribute("message", "修改失败");
        }else {
            attributes.addFlashAttribute("message", "修改成功");
        }
        return "redirect:/types/edit/" + id;
    }
}
