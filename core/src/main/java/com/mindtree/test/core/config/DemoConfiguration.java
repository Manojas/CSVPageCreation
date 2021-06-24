package com.mindtree.test.core.config;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.osgi.service.metatype.annotations.Option;
@ObjectClassDefinition(name="DemoConfiguration" , description="Demo Configuration")
public @interface DemoConfiguration {

	
	@AttributeDefinition(name="Name", description="Enter your name",type=AttributeType.STRING)
	String getName() default "john";


	@AttributeDefinition(name="Indian", description="Are you indian",type=AttributeType.BOOLEAN)
	boolean getIsIndian() default true;
	
	@AttributeDefinition(name="Gender", description="Select your Gender",options= {
			@Option(label="Male",value="Male"),@Option(label="FeMale",value="FeMale"),
			@Option(label="Others",value="Others")},type=AttributeType.STRING)
	String getGender() default "Male";
	
	@AttributeDefinition(name="Languages", description="Enter the Languages you know",type=AttributeType.STRING)
	String[] getLanguages() default {"Java"};
	
}

