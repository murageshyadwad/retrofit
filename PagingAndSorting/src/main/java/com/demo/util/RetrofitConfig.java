package com.demo.util;



import org.springframework.beans.factory.annotation.Value;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Component
@ConfigurationProperties
public class RetrofitConfig 
{
	private static String serviceurl;
	

	
	public static String getServiceurl() {
		return serviceurl;
	}

	@Value("${serviceurl}")
	public void setServiceurl(String serviceurl) {
		RetrofitConfig.serviceurl = serviceurl;
	}
	
	
	
	

	public static <S> S createPatientServerService(Class<S> serviceClass) {

		OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

		httpClient.interceptors().clear();
		httpClient.addInterceptor(chain -> {
			Request original = chain.request();
			Request request = original.newBuilder().build();
			return chain.proceed(request);
		});
		
		Retrofit.Builder builder = new Retrofit.Builder().baseUrl(serviceurl+"/patient/")
				.addConverterFactory(GsonConverterFactory.create()).client(httpClient.build());

		Retrofit retrofit = builder.build();
	
		return retrofit.create(serviceClass);
	}
	
}
