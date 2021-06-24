package com.mindtree.test.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import com.mindtree.test.core.services.SecondService;

@Model(adaptables = SlingHttpServletRequest.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class OSGIConfigModel {
	@OSGiService
	SecondService secondService;

	public String getName() {
		return secondService.getText();
	}

	public boolean getIsIndian() {
		return secondService.getBoolean();
	}

	public String getGender() {
		return secondService.getSelection();
	}

	public String[] getLanguages() {
		return secondService.getMultifield();
	}
}