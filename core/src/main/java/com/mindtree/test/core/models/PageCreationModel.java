package com.mindtree.test.core.models;

public class PageCreationModel {

	private String pageTitle;
	private String pageName;
	private String display;
	private String templatePath;
	private String navTitle;

	public PageCreationModel() {
		super();
	}

	public PageCreationModel(String pageTitle, String pageName, String display, String templatePath, String navTitle) {
		super();
		this.pageTitle = pageTitle;
		this.pageName = pageName;
		this.display = display;
		this.templatePath = templatePath;
		this.navTitle = navTitle;
	}

	public String getPageTitle() {
		return pageTitle;
	}

	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public String getTemplatePath() {
		return templatePath;
	}

	public void setTemplatePath(String templatePath) {
		this.templatePath = templatePath;
	}

	public String getNavTitle() {
		return navTitle;
	}

	public void setNavTitle(String navTitle) {
		this.navTitle = navTitle;
	}

}
