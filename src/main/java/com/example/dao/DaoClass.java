package com.example.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.example.entity.DiagnosticCenter;


@Repository

public class DaoClass implements DaoInterface{
	@PersistenceContext	
	 EntityManager em;
	public DiagnosticCenter DiagnosticCenterCreation(DiagnosticCenter dia) {
		// TODO Auto-generated method stub
		DiagnosticCenter d=em.merge(dia);
		return d;
	}
	public DiagnosticCenter getDiagnosticCenter(int id) {
		
		return em.find(DiagnosticCenter.class,id);
	}
	
	public List<DiagnosticCenter> getAllDiagnosticCenter() {
		Query q=em.createQuery("select m from Employee m");
		List<DiagnosticCenter> emplist=q.getResultList();
		return emplist;
	}
	
	public DiagnosticCenter UpdateDiagnosticCenter(DiagnosticCenter dia) {
		DiagnosticCenter d=em.find(DiagnosticCenter.class,dia.getId());
		if(d!=null)
		{
			d.setCenterName(dia.getCenterName());
			d.setContactNumber(dia.getContactNumber());
			d.setAddress(dia.getAddress());
		}
		return d;
			
	}
	public DiagnosticCenter deleteById(int id) {
		DiagnosticCenter d=em.find(DiagnosticCenter.class,id);
		if(d!=null)
			{em.remove(d);
			}
        return d;
	}
	@Override
	public DiagnosticCenter getDiagnosticCenterById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
