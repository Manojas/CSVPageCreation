package com.mindtree.test.core.config;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.osgi.service.metatype.annotations.Option;

@ObjectClassDefinition(name = "First Configuration", description = "First config")
public @interface FirstConfig {

	@AttributeDefinition(name = "Name", description = "Enter your name", type = AttributeType.STRING)
	String getText() default "john";

	@AttributeDefinition(name = "Indian", description = "Are you indian", type = AttributeType.BOOLEAN)
	boolean getBoolean() default false;

	@AttributeDefinition(name = " Gender", description = "Select gender", options = {
			@Option(label = "Male", value = "male"), @Option(label = "Female", value = "Female"),
			@Option(label = "Others", value = "Others") }, type = AttributeType.STRING)
	String getSelection() default "Male";

	@AttributeDefinition(name = "Languages", description = "LanguagesKnown", type = AttributeType.STRING)
	String[] getMultiField() default { "English", "Kannada" };
}
