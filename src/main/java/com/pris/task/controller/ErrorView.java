/**
 * 
 */
package com.pris.task.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author LO
 *
 */
public class ErrorView implements ErrorViewResolver {

	/* (non-Javadoc)
	 * @see org.springframework.boot.autoconfigure.web.ErrorViewResolver#resolveErrorView(javax.servlet.http.HttpServletRequest, org.springframework.http.HttpStatus, java.util.Map)
	 */
	@Override
	public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model) {
		// TODO Auto-generated method stub
		return new ModelAndView("error");
	}

}
