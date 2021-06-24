package com.mindtree.test.core.services;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.jcr.Node;
import javax.jcr.Session;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;

import com.day.cq.dam.api.Asset;
import com.day.cq.dam.api.Rendition;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.api.WCMException;
import com.mindtree.test.core.models.PageCreationModel;
import com.mindtree.test.core.models.PageModel;
import org.slf4j.LoggerFactory;

@Component(service =  CSVPageCreationWithoutServlet.class, immediate = true)
public class CSVPageCreationWithoutServlet {
	
	@Reference
	ResourceResolverFactory resourceResolverFactory;

	private final Logger LOG = LoggerFactory.getLogger(PageCreateChallengeImpl.class);

	public static final String SERVICE_NAME = "secondSubService";

	//public static final String RESOURCE_PATH = "/content/dam/test/CSV/CSVCodeChallenge-CSV.csv";

	ResourceResolver resourceResolver = null;

	@Activate
	@Modified
	public void activate() {
		LOG.info("We are activating the bundle");

		Map<String, Object> map = new HashMap<>();

		map.put(ResourceResolverFactory.SUBSERVICE, SERVICE_NAME);
		try {
			resourceResolver = resourceResolverFactory.getServiceResourceResolver(map);
			LOG.info("Resource Resolver Registered");
		} catch (LoginException e) {
			LOG.info("Login Failed");
		}
	}

	
	public List<Page> getCSVPages(String pathBrowser) {
		// TODO Auto-generated method stub

		List<Page> createdPages = new LinkedList<>();
		List<PageCreationModel> pageProperties = getCSVContent(pathBrowser);

		LOG.info("I am in getCSVPages function");
		

		Session session = resourceResolver.adaptTo(Session.class);

		PageManager pageManager = resourceResolver.adaptTo(PageManager.class);

		Page page;

		try {
			for (PageCreationModel pageModel : pageProperties) {
				LOG.info("Trying to print page properties");
				
				LOG.info(pageModel.getDisplay());
				LOG.info(pageModel.getNavTitle());
				LOG.info(pageModel.getPageName());
				LOG.info(pageModel.getPageTitle());
				LOG.info(pageModel.getTemplatePath());
				
				page = pageManager.create("/content/test/us/en",
						pageModel.getPageName(),
						pageModel.getTemplatePath(),
						pageModel.getPageTitle());

				Node node;
				try {
					LOG.info("I am setting page info");
					node = (Node) session.getItem(page.getPath() + "/jcr:content");
					if (node != null) {
						LOG.info(node.getName());
						node.setProperty("pageTitle", pageModel.getPageTitle());
						node.setProperty("navTitle", pageModel.getNavTitle());
						node.setProperty("display", pageModel.getDisplay());
						session.save();
					} else {
						LOG.info("Node is null");
					}

				} catch (Exception e) {
					LOG.error("Error while setting properties");
				}
				if (page != null) {
					createdPages.add(page);
				}
			}
			return createdPages;
		} catch (Exception e) {
			LOG.error("Error while creating pages");
		}

		return Collections.emptyList();
	}

	private List<PageCreationModel> getCSVContent(String pathBrowser) {
		// TODO Auto-generated method stub
		List<PageCreationModel> pageProperties = null;
		InputStream inputstream = null;
		InputStreamReader inputstreamreader = null;
		BufferedReader bufferedreader = null;

		try {

			Resource resource = resourceResolver.getResource(pathBrowser);
			LOG.info("Getting resource");
			Asset asset = resource.adaptTo(Asset.class);
			Rendition rendition = asset.getOriginal();

			inputstream = rendition.adaptTo(InputStream.class);
			inputstreamreader = new InputStreamReader(inputstream);
			bufferedreader = new BufferedReader(inputstreamreader);

			pageProperties = new LinkedList<>();

			pageProperties = bufferedreader.lines().skip(1).map(singleLine -> {
				String[] arr = singleLine.split(",");

				PageCreationModel pageModel = new PageCreationModel();
				pageModel.setPageName(arr[1].trim());
				pageModel.setPageTitle(arr[0].trim());
				pageModel.setTemplatePath(arr[3].trim());
				pageModel.setDisplay(arr[2].trim());
				pageModel.setNavTitle(arr[4].trim());
				return pageModel;
			}).collect(Collectors.toList());
		} catch (Exception e) {
			LOG.error("Error While reading csv content");
		} finally {
			try {
				if (bufferedreader != null) {
					bufferedreader.close();
				}
				if (inputstream != null) {
					inputstream.close();
				}
				if (inputstreamreader != null) {
					inputstreamreader.close();
				}
			} catch (Exception e) {
				LOG.error("Cant close streams");
			}
		}

		return pageProperties;
	}

	
}
