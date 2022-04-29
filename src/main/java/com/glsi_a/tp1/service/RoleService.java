package com.glsi_a.tp1.service;

import com.glsi_a.tp1.models.Role;
import com.glsi_a.tp1.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public void saveRole(Role role){
        roleRepository.save(role);
    }

    public List<Role> showAllRole(){
        return roleRepository.findAll();
    }
    public void showOneRole(int id){
        roleRepository.findById(id);
    }

    public void delete(int id){
        roleRepository.deleteById(id);
    }
}
