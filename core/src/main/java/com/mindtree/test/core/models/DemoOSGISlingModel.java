package com.mindtree.test.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import com.mindtree.test.core.services.DemoService;

@Model(adaptables=SlingHttpServletRequest.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class DemoOSGISlingModel {

	@OSGiService
	DemoService demoService;
	
	public String getName()
	{
		return demoService.getName();
		
	}
	public boolean getIsIndian()
	{
		return demoService.getIsIndian();
		
	}
	public String getGender()
	{
		return demoService.getGender();
	}
	
	public String[] getLanguages()
	{
		return demoService.getLanguages();
	}
}
