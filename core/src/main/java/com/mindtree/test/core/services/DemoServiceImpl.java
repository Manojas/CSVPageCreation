package com.mindtree.test.core.services;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;

import com.mindtree.test.core.config.DemoConfiguration;

@Component(service=DemoService.class,immediate=true)
@Designate(ocd=DemoConfiguration.class)
public class DemoServiceImpl implements DemoService{

	private String name;
	private boolean isIndian;
	private String gender;
	private String[] languages;
	
	
	@Activate
	protected void activate(DemoConfiguration demoConfig)
	{
		name=demoConfig.getName();
		isIndian=demoConfig.getIsIndian();
		gender=demoConfig.getGender();
		languages=demoConfig.getLanguages();
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public boolean getIsIndian() {
		// TODO Auto-generated method stub
		return isIndian;
	}

	@Override
	public String getGender() {
		// TODO Auto-generated method stub
		return gender;
	}

	@Override
	public String[] getLanguages() {
		// TODO Auto-generated method stub
		return languages;
	}

}
