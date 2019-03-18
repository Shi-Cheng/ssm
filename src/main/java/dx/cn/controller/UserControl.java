package dx.cn.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dx.cn.domain.UserInfo;
import dx.cn.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserControl {

    @Autowired
    private IUserService userService;

    @RequestMapping("/login.do")
    public String userLogin(UserInfo user) throws Exception{
        String name = user.getUsername();
        String password = user.getPassword();
        UserInfo userInfo = userService.findByUsername(name);
        if (userInfo.getPassword().equals(password)){
            return "redirect:/index.jsp";
        } else {
            return "redirect:/failer.jsp";
        }
    }
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true, defaultValue = "1") int page,@RequestParam(name = "size",required = true,defaultValue = "4") int size){
        ModelAndView view = new ModelAndView();
        List<UserInfo> users = userService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(users);
        view.addObject("users",pageInfo);
        view.setViewName("user-list");
        return view;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(String id){
        ModelAndView view = new ModelAndView();
        int userid = Integer.parseInt(id);
        UserInfo user = userService.findByUserId(userid);
        view.addObject("user",user);
        view.setViewName("user-show");
        return view;
    }
    @RequestMapping("/saveUser.do")
    public String saveUser(UserInfo user){
        userService.saveUser(user);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id",required = true) int id) throws Exception{

        return null;
    }
}
