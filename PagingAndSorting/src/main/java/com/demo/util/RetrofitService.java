package com.demo.util;


import com.demo.model.PatientModel;
import com.demo.viewmodel.PatientViewModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitService 
{
	@GET("{id}")
	Call<PatientViewModel> getPatientDetails(@Path("id") long id);

	//Call<PatientModel> getPatientDetails(long id);
}