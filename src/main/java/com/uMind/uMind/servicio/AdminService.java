package com.uMind.uMind.servicio;

import com.uMind.uMind.modelo.Admin;
import com.uMind.uMind.repositorio.IAdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService implements IAdminService{

    private IAdminRepository adminRepository;

    public AdminService(IAdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public List<Admin> getAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public List<Admin> getAdminByEmail(String email) {
        return adminRepository.findByEmailContaining(email);
    }

    @Override
    public List<Admin> getAdminByLogin(String login) {
        return adminRepository.findByLoginContains(login);
    }

    @Override
    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Admin getAdminById(Integer id) {
        return adminRepository.findById(id).get();
    }

    @Override
    public Admin updateAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public void deleteAdminById(Integer id) {
        adminRepository.deleteById(id);
    }

}
