package com.senvon.firstapp.dal.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.senvon.spring.dao.GradeInfoDAO;
import com.senvon.spring.model.GradeInfo;
import com.senvon.spring.model.GradeInfoExample;
import com.senvon.spring.page.Page;

@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:application-test.xml"})
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class DaoTest {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private GradeInfoDAO gradeInfoDao;
	
	@Test
	public void test1() throws Exception{
		GradeInfoExample example = new GradeInfoExample();
		GradeInfoExample.Criteria criteria = example.createCriteria();
		
//		criteria.andSubjectIdEqualTo(1);
		List<GradeInfo> studentInfoList = gradeInfoDao.selectByExample(example);
//		System.out.println(studentInfoList);
		logger.info("this is studentList:{}" , studentInfoList);
	}
	
	@Test
	public void test2() throws Exception{
		GradeInfoExample example = new GradeInfoExample();
		GradeInfoExample.Criteria criteria = example.createCriteria();
		
//		criteria.andSubjectIdEqualTo(1);
		List<GradeInfo> studentInfoList = gradeInfoDao.selectByPage(example , new Page());
//		System.out.println(studentInfoList);
		logger.info("this is page:{}" , studentInfoList);
	}
}
