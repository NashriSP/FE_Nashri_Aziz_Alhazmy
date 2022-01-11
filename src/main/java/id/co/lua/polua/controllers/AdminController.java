package id.co.lua.polua.controllers;

import id.co.lua.polua.helpers.GlobalMethods;
import id.co.lua.polua.models.apps.Product;
import id.co.lua.polua.models.accounts.User;
import id.co.lua.polua.models.apps.Group;
import id.co.lua.polua.services.apps.ProdukService;
import id.co.lua.polua.services.accounts.UserService;
import id.co.lua.polua.services.groups.GroupService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder; 
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminController extends BasicController {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    ProdukService produkService;

    @Autowired
    UserService userService;
    
    @Autowired
    GroupService groupService;

    @RequestMapping("/daftar-seller")
    public ModelAndView daftarSeller(ModelAndView mView,
                            @ModelAttribute(name = "result_code") String result_code,
                            @ModelAttribute(name = "result_message") String result_message,
                            RedirectAttributes redirectAttributes) {
        mView.setViewName("pages/admin/daftar-seller");
        return mView;
    }

    @GetMapping("/daftar-seller/create")
    public String createSeller(Model model,
                      @ModelAttribute(name = "result_code") String result_code,
                      @ModelAttribute(name = "result_message") String result_message,
                      RedirectAttributes redirectAttributes){
        if(!model.containsAttribute("data")){
            model.addAttribute("data", new User());
        }
        return "pages/admin/add-seller";
    }

    @RequestMapping("/daftar-seller/add")
    public ModelAndView addSeller(@Valid @ModelAttribute(name = "data") User user,
                            BindingResult result,
                            ModelAndView mView,
                            @ModelAttribute(name = "result_code") String result_code,
                            @ModelAttribute(name = "result_message") String result_message,
                            RedirectAttributes redirectAttributes) {
        if(result.hasErrors()){
            GlobalMethods.setRedirectAttribute(redirectAttributes, "0", "Produk gagal ditambahkan", user, result);
            mView.setViewName("redirect:/admin/daftar-seller/create");
            return mView;
        }                        
        userService.create(user, "iuli123456");
        mView.setViewName("redirect:/admin/daftar-seller/");
        return mView;
    }

    @RequestMapping("/daftar-grup")
    public ModelAndView daftarGrup(ModelAndView mView,
                            @ModelAttribute(name = "result_code") String result_code,
                            @ModelAttribute(name = "result_message") String result_message,
                            RedirectAttributes redirectAttributes) {
        mView.setViewName("pages/admin/daftar-grup");
        return mView;
    }

    @GetMapping("/daftar-grup/create")
    public String createGrup(Model model,
                      @ModelAttribute(name = "result_code") String result_code,
                      @ModelAttribute(name = "result_message") String result_message,
                      RedirectAttributes redirectAttributes){
        if(!model.containsAttribute("data")){
            model.addAttribute("data", new Group());
        }
        return "pages/admin/add-grup";
    }

    @RequestMapping("/daftar-grup/add")
    public ModelAndView addGrup(@Valid @ModelAttribute(name = "data") Group group,
                            BindingResult result,
                            ModelAndView mView,
                            @ModelAttribute(name = "result_code") String result_code,
                            @ModelAttribute(name = "result_message") String result_message,
                            RedirectAttributes redirectAttributes) {
        if(result.hasErrors()){
            GlobalMethods.setRedirectAttribute(redirectAttributes, "0", "Produk gagal ditambahkan", group, result);
            mView.setViewName("redirect:/admin/daftar-grup/create");
            return mView;
        }                        
        groupService.create(group);
        mView.setViewName("redirect:/admin/daftar-grup/");
        return mView;
    }

    @RequestMapping("/daftar-produk")
    public ModelAndView daftarProduk(ModelAndView mView,
                            @ModelAttribute(name = "result_code") String result_code,
                            @ModelAttribute(name = "result_message") String result_message,
                            RedirectAttributes redirectAttributes) {
        List<Product> produkList = produkService.getAll();
        mView.addObject("produkList", produkList); 
        mView.setViewName("pages/admin/daftar-produk");
        return mView;
    }

    @GetMapping("/daftar-produk/create")
    public String createProduk(Model model,
                      @ModelAttribute(name = "result_code") String result_code,
                      @ModelAttribute(name = "result_message") String result_message,
                      RedirectAttributes redirectAttributes){
        if(!model.containsAttribute("data")){
            model.addAttribute("data", new Product());
        }
        return "pages/admin/add-produk";
    }

    @RequestMapping("/daftar-produk/add")
    public ModelAndView addProduk(@Valid @ModelAttribute(name = "data") Product product,
                            BindingResult result,
                            ModelAndView mView,
                            @ModelAttribute(name = "result_code") String result_code,
                            @ModelAttribute(name = "result_message") String result_message,
                            RedirectAttributes redirectAttributes) {
        if(result.hasErrors()){
            GlobalMethods.setRedirectAttribute(redirectAttributes, "0", "Produk gagal ditambahkan", product, result);
            mView.setViewName("redirect:/admin/daftar-produk/create");
            return mView;
        }                        
        produkService.create(product);
        mView.setViewName("redirect:/admin/daftar-produk/");
        return mView;
    }
}
