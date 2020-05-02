package com.example.service;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.DaoClass;
import com.example.entity.DiagnosticCenter;

@Service
@Transactional

public class ServiceClass {
	@Autowired
	DaoClass dao;
	public DiagnosticCenter DiagnosticCenterCreation(DiagnosticCenter dia) {
		return dao.DiagnosticCenterCreation(dia);
	}

	public DiagnosticCenter getDiagnosticCenterById(int id) 
	{
	return dao.getDiagnosticCenterById(id);
	}

	public List<DiagnosticCenter> getAllDiagnosticCenter() 
	{
	return dao.getAllDiagnosticCenter();
	}

	public DiagnosticCenter delete(int id) 
	{
		return dao.deleteById(id);
	}

	public DiagnosticCenter UpdateDiagnosticCenter(DiagnosticCenter dia) {
		return dao.UpdateDiagnosticCenter(dia);	
	}

}
