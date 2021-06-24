package com.mindtree.test.core.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.wcm.api.Page;
import com.mindtree.test.core.services.PageCreateChallengeInterface;

@Component(service = Servlet.class)
@SlingServletPaths(value = { "/bin/csvPages" })
public class CSVPageServlet extends SlingSafeMethodsServlet {
	
	
	private static final Logger log = LoggerFactory.getLogger(CSVPageServlet.class);

	@Reference
	private transient PageCreateChallengeInterface pageCreate;
	
	
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		try {
			PrintWriter pw = response.getWriter();
			response.setContentType("text/plain");

			List<Page> pagesCreated = pageCreate.getCSVPages();
			if (pagesCreated != null) {
				log.info("Printing names");
				pw.println("The  pages are created as follows:");
				for (Page p : pagesCreated) {
					pw.println(p.getName());

				}
			} else {
				log.error("Pages are not created");
				pw.println("Pages are not created");
			}

		} catch (Exception e) {
			log.error("Error");
		}

	}

}
