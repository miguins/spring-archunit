package br.com.archunit.poc.codecoverage.controller;

import br.com.archunit.poc.codecoverage.service.TestService;

public class TestController {

    private TestService testService;

    public TestController(){
    }

    public void test(){
        TestService t = new TestService();
        t.teste();
    }
}
