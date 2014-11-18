package com.skt.ssp.gw.web.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"applicationContext.xml", "/action-servlet.xml"})
public class MainControllerTests {
 @Autowired
 private MainController mainController = null;

 @Test
 public void testIndex() {
//  String page = mainController.index();
//
//  assertEquals("index",page);
 }

}