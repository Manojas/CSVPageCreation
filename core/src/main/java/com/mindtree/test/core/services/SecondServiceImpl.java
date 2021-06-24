package com.mindtree.test.core.services;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;

import com.mindtree.test.core.config.FirstConfig;

@Component(service=SecondService.class,immediate=true)
@Designate(ocd=FirstConfig.class)
public class SecondServiceImpl implements SecondService{

	private String name;
	private boolean isIndian;
	private String gender;
	private String[] languages;
	
	@Activate
	protected void activate(final FirstConfig firstConfig)
	{
		name=firstConfig.getText();
		isIndian=firstConfig.getBoolean();
		gender=firstConfig.getSelection();
		languages=firstConfig.getMultiField();
	}
	
	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public boolean getBoolean() {
		// TODO Auto-generated method stub
		return isIndian;
	}

	@Override
	public String getSelection() {
		// TODO Auto-generated method stub
		return gender;
	}

	@Override
	public String[] getMultifield() {
		// TODO Auto-generated method stub
		return languages;
	}

}
