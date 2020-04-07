package com.jobinbasani.hateoas.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.config.EnableHypermediaSupport;

import static org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType.HAL_FORMS;

@Configuration
@EnableHypermediaSupport(type = HAL_FORMS)
public class HypermediaConfiguration {

}
