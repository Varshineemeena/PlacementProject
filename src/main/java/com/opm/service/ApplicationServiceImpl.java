package com.opm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.opm.dao.ApplicationsDAO;
import com.opm.entity.Applications;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class ApplicationServiceImpl implements ApplicationService {
	
	@Autowired
	ApplicationsDAO dao;

	@Override
	public void addApplication(Applications applications) {
		dao.addApplication(applications);
		
	}

	@Override
	public List<Applications> getallApplications() {
		return dao.getallApplications();
	}

	@Override
	public List<Applications> getByStudentId(Long id) {
		return dao.getByStudentId(id);
	}

	@Override
	public List<Applications> getByCompanyId(Long id) {
		return dao.getByCompanyId(id);
	}

	@Override
	public Applications getApplicationId(Long id) {
		return dao.getApplicationId(id);
	}

	@Override
	public ResponseEntity<?> updateBill(long id, Applications updatedApplication) {
		return dao.updateBill(id, updatedApplication);
	}

	@Override
	public ResponseEntity<?> updateInterview(long id, Applications updatedInterview) {
		return dao.updateInterview(id, updatedInterview);
	}

	@Override
    public void deleteApplication(Long id) {
        dao.deleteApplication(id);
    }

}
