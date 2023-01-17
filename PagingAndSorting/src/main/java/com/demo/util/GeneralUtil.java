package com.demo.util;

import java.util.UUID;

import com.fasterxml.uuid.Generators;

public class GeneralUtil
{
	public static long getUUID()
	{
		UUID uuid = Generators.timeBasedGenerator().generate();
		long uuid1=Long.parseLong(uuid.toString());
		return uuid1;
	}
	
	public static String getUUID1() 
	{
		UUID uuid = Generators.timeBasedGenerator().generate();
		return uuid.toString();
	}
}
