package com.uMind.uMind.servicio;

import com.uMind.uMind.modelo.Admin;
import java.util.List;

public interface IAdminService {

    List<Admin> getAdmins();

    List<Admin> getAdminByEmail(String email);

    List<Admin> getAdminByLogin(String email);

    Admin saveAdmin(Admin admin);

    Admin getAdminById(Integer id);

    Admin updateAdmin(Admin admin);

    void deleteAdminById(Integer id);
}
