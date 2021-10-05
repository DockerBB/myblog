package com.wf.myblog.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wf.myblog.Bean.Tag;
import com.wf.myblog.Service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class TagController {
    @Autowired
    TagService tagService;

    // 展示所有分类
    @GetMapping("/getAllTag")
    public String TagList(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        String orderBy = "id desc";
        PageHelper.startPage(pageNum, 10, orderBy);
        List<Tag> tags = tagService.listTag();
        PageInfo<Tag> pageInfo = new PageInfo<>(tags);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/tags";
    }

    // 跳转到分类发布页面
    @GetMapping("/tags/edit")
    public String addCategory() {
        return "admin/post_tags";
    }

    @GetMapping("/tags/post")
    public String addCategory(RedirectAttributes attributes) {
        attributes.addFlashAttribute("tag",new Tag());
        return "redirect:/tags/edit";
    }

//    更新分类
    @GetMapping("/tags/edit/{id}")
    public String editCategory(@PathVariable Long id, Model model) {
        model.addAttribute("tag", tagService.getTag(id));

        return "admin/post_tags";
    }

    // 删除分类
    @GetMapping("/tags/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes attributes) {
        int res = tagService.delteTag(id);
        if(res == 0) {
            attributes.addFlashAttribute("message", "删除失败");
        }else {
            attributes.addFlashAttribute("message","删除成功");
        }
        return "redirect:/getAllTag";
    }

    // 新增分类
    @PostMapping("/tags")
    public String post(Tag tag, RedirectAttributes attributes) {
        int res = tagService.getTagByName(tag.getName());
        System.out.println(res);
        if (res != 0) {
            attributes.addFlashAttribute("message", "不能添加重复的分类");
            return "redirect:/tags/edit";
        }
        res = tagService.saveTag(tag);
        if(res == 0) {
            attributes.addFlashAttribute("message", "操作失败");
        }else {
            attributes.addFlashAttribute("message", "操作成功");
        }
        return "redirect:/getAllTag";
    }

    @PostMapping("/tags/{id}")
    public String post(@PathVariable Long id, Tag tag, RedirectAttributes attributes) {
        int res = tagService.getTagByName(tag.getName());
        System.out.println(tag.toString());
        if (res != 0) {
            attributes.addFlashAttribute("message", "不能添加重复的分类");
            return "redirect:/tags/edit/" + id;
        }
        res = tagService.updateTag(id, tag);
        if(res == 0) {
            attributes.addFlashAttribute("message", "修改失败");
        }else {
            attributes.addFlashAttribute("message", "修改成功");
        }
        return "redirect:/tags/edit/" + id;
    }
}
