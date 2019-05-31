package com.bae.BDDTest.bing.tests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\Administrator\\Desktop\\JavaWS\\BDDTest\\src\\test\\java\\Parametisation.feature", glue = {
		"com.bae.BDDTest.bing.tests" })
public class Runner {

}
