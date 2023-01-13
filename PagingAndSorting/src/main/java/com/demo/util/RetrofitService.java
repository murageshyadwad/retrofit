package com.demo.util;


import com.demo.model.PatientModel;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitService 
{
	@GET("{id}")
	Call<PatientModel> getPatientDetails(@Path("id") String id);
}