package com.mindtree.test.core.models;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.wcm.api.Page;


@Model(adaptables=SlingHttpServletRequest.class,
adapters=DemoPageModelInterface.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class DemoPageModelImpl implements DemoPageModelInterface{

	private final Logger log=LoggerFactory.getLogger(getClass());
	@ScriptVariable
	Page currentPage;
	
	@Inject
	@Via("resource")
	List<String> names;
	
	@ValueMapValue
	String gender;
	
	@Inject @Via("resource")
	@Optional//To mark them as optional
	Boolean isIndian;
	
	
	@Override
	public List<String> getNames() {
		// TODO Auto-generated method stub
		return names;
	}

	@Override
	public Boolean getIsIndian() {
		// TODO Auto-generated method stub
		return isIndian;
	}

	@Override
	public String getGender() {
		// TODO Auto-generated method stub
		return gender;
	}

	@Override
	public String getPageTitle() {
		// TODO Auto-generated method stub
		return currentPage.getTitle();
	}
	
	@PostConstruct
	public void init()
	{
		log.info(gender+","+isIndian);
	}
	
	
//@Inject@ScriptVariable@ValueMapValue@PostConstruct@Optional












}
