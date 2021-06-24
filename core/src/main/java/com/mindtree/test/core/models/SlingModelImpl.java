package com.mindtree.test.core.models;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.ResourcePath;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;

import com.day.cq.wcm.api.Page;
import com.mindtree.test.core.services.CSVPageCreationWithoutServlet;
@Model(adaptables = SlingHttpServletRequest.class,
defaultInjectionStrategy=DefaultInjectionStrategy.OPTIONAL)


public class SlingModelImpl {
	//CSVPageCreationWithoutServlet npc= new CSVPageCreationWithoutServlet();
	
	@ScriptVariable
	Page currentPage;
		
	@Inject
	@Via("resource")
	List<String> names;
	//i have changed something.
	
	@Inject
	@Via("resource")
	String pathBrowser;
	
	@Inject
	@Via("resource")
	@Default(values="true")
	Boolean isIndian;
	
	@Inject
	@Via("resource")
	String gender;
	

	@ResourcePath(path="/content/test/us/en/TestPage")
	@Via("resource")
	Resource resource;
	
	@Inject
	@Via("resource")
	@Named("jcr:createdBy")
	String createdBy;
	
	@Inject
	CSVPageCreationWithoutServlet npc;
		
	public List<String> getNames() {
		// TODO Auto-generated method stub
		return names;
	}


	public String getPathBrowser() {
		// TODO Auto-generated method stub
		return pathBrowser;
	}


	public Boolean getIsIndian() {
		// TODO Auto-generated method stub
		return isIndian;
	}


	public String getGender() {
		// TODO Auto-generated method stub
		return gender;
	}

	public String getPageTitle()
	{
		return currentPage.getTitle();
	}
	
	public String getHomePage() {
		// TODO Auto-generated method stub
		return resource.getName();
	}

	
	public String getLastModified() {
		// TODO Auto-generated method stub
		return createdBy;
	}

	
	@PostConstruct
	public void init()
	{
		npc.getCSVPages(pathBrowser);
	}
	
}
