package com.hit.secondhouse.service;

import com.hit.secondhouse.dao.AdministratorDao;
import com.hit.secondhouse.domain.Administrator;
import com.hit.secondhouse.domain.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    public AdministratorDao administratorDao;

    public List<Administrator> getAllAdminService(){return administratorDao.getAllAdmin();}

    @Transactional
    public void insertAdminService(int adminId, String adminLevel, int employeeId){ administratorDao.insertAdmin(adminId,adminLevel,employeeId);}

    @Transactional
    public void deleteAdminByAdminIdService(int adminId){ administratorDao.deleteAdminById(adminId);}

    public List<House> getAllUnverified(){ return administratorDao.getAllUnverified();}

    @Transactional
    public void setVerifiedByIdService(int id){administratorDao.setVerifiedById(id);}

    public Administrator findAdminByEidService(int employeeId){return administratorDao.findAdminByEid(employeeId);}

}
