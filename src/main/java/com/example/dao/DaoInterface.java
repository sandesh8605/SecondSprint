


package com.example.dao;

import java.util.List;

import com.example.entity.DiagnosticCenter;

public interface DaoInterface {
	DiagnosticCenter deleteById(int id) ;

	List<DiagnosticCenter> getAllDiagnosticCenter();

	DiagnosticCenter getDiagnosticCenterById(int id);

	DiagnosticCenter DiagnosticCenterCreation(DiagnosticCenter dia);

	DiagnosticCenter UpdateDiagnosticCenter(DiagnosticCenter dia);
}
