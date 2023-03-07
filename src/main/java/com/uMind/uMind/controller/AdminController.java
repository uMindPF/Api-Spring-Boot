package com.uMind.uMind.controller;

import com.uMind.uMind.modelo.Admin;
import com.uMind.uMind.security.SecurityClass;
import com.uMind.uMind.servicio.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/admins")
    public String listAdmins(Model model) {
        model.addAttribute("admin", adminService.getAdmins());
        return "admin/admins";
    }

    @GetMapping("/admins/new")
    public String createAdminForm(Model model) {
        Admin admin = new Admin();

        model.addAttribute("admin", admin);

        return "admin/create_admin";
    }

    @PostMapping("/admins")
    public String saveAdmin(@ModelAttribute("admin") Admin admin) {
        admin.setPassword(SecurityClass.hashSHA1(admin.getPassword()));
        adminService.saveAdmin(admin);
        return "redirect:/admins";
    }

    @GetMapping("/admins/edit/{id}")
    public String editAdminForm(@PathVariable Integer id, Model model)
    {
        Admin admin = adminService.getAdminById(id);

        model.addAttribute("admin", admin);

        return "admin/edit_admin";
    }

    @GetMapping("/admins/edit/password/{id}")
    public String editAdminPasswordForm(@PathVariable Integer id, Model model)
    {
        Admin admin = adminService.getAdminById(id);

        model.addAttribute("admin", admin);

        return "admin/edit_admin_password";
    }

    @PostMapping ("/admins/{id}")
    public String updateAdmin(@PathVariable Integer id, @ModelAttribute("admin") Admin admin)
    {
        Admin existentAdmin = adminService.getAdminById(id);

        existentAdmin.setId(id);
        existentAdmin.setLogin(admin.getLogin());
        existentAdmin.setEmail(admin.getEmail());

        adminService.updateAdmin(existentAdmin);

        return "redirect:/admins";
    }

    @PostMapping ("/admins/password/{id}")
    public String updateAdminPassword(@PathVariable Integer id, @ModelAttribute("admin") Admin admin)
    {
        Admin existentAdmin = adminService.getAdminById(id);

        existentAdmin.setId(id);
        existentAdmin.setPassword(SecurityClass.hashSha1Text(admin.getPassword()));

        adminService.updateAdmin(existentAdmin);

        return "redirect:/admins";
    }

    @GetMapping("/admins/delete/{id}")
    public String deleteAdmin(@PathVariable Integer id)
    {
        adminService.deleteAdminById(id);

        return "redirect:/admins";
    }

}
