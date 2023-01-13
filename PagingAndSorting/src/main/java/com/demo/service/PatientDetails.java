package com.demo.service;

import java.io.File;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceUnit;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.PatientModel;
import com.demo.model.PatientPage;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;

@Service
public class PatientDetails {
	
	@Autowired(required=true)
	EntityManager entityManager;
	

	

	public EntityManager getEntityManager() {
		return entityManager;
	}


	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


	@Autowired
	private Storage storage;

	
	public List<PatientModel> getAllPatient(PatientPage page) {
		try {
			StoredProcedureQuery obj = entityManager.createStoredProcedureQuery("", PatientModel.class);
			obj.registerStoredProcedureParameter( "PageNumber", Integer.class, ParameterMode.IN);
			obj.setParameter("PageNumber",page.getPageNumber() );
			obj.registerStoredProcedureParameter( "PageSize", Integer.class, ParameterMode.IN);
			obj.setParameter("PageSize", page.getPageSize());
			//obj.registerStoredProcedureParameter( "sortDirection", Integer.class, ParameterMode.IN);
			//obj.setParameter("sortDirection", Sort.Direction.ASC);
			//obj.registerStoredProcedureParameter( "sortBy", String.class, ParameterMode.IN);
			//obj.setParameter("sortBy", "city");
			
			
			//obj.execute();
			// List list=(List) obj.getOutputParameterValue("patients");

			List<PatientModel> resultList = obj.getResultList();
			System.out.println(resultList);
			return resultList;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	

	
//	public String getScheduleTime() {
//
//		String res = "";
//		try {
//			
//			StoredProcedureQuery query = this.getEntityManager().createStoredProcedureQuery("get_servicescheduletime");
//			
//			res = (String) query.getSingleResult();
//			
//		} catch (Exception e) {
//
//			System.out.println(e.toString());
//
//			// e.printStackTrace();
//		} finally {
//			getEntityManager().close();
//		}
//		return res;
//	}
		

//	public String sendData() throws IOException {
//		BlobId id = BlobId.of("q-demo", "schedule.txt");
//		BlobInfo info = BlobInfo.newBuilder(id).build();
//		File file = new File("C:\\git", "schedule.txt");
//		byte[] arr = Files.readAllBytes(Paths.get(file.toURI()));
//		storage.create(info, arr);
//		return "File Stored";
//	}
}
	
	


