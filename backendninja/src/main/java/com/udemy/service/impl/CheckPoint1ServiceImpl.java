package com.udemy.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.udemy.service.CheckPoint1Service;

@Service("checkPoint1Service")
public class CheckPoint1ServiceImpl implements CheckPoint1Service{
	
	private static final Log LOG = LogFactory.getLog(CheckPoint1Service.class);
	
	@Override
	public void showLog() {
		LOG.info("Pintando un log de tipo Info");
	}
			
			

}
