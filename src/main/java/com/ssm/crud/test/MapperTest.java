package com.ssm.crud.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ssm.crud.bean.Department;
import com.ssm.crud.bean.Employee;
import com.ssm.crud.dao.DepartmentMapper;
import com.ssm.crud.dao.EmployeeMapper;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
	@Autowired
	DepartmentMapper departmentmapper;
	@Autowired
	EmployeeMapper employeemapper;
	
	@Autowired
	SqlSession sqlSession;
	@Test
	public void testCRUD(){
		//����springioc����
		//�������л�ȡmapper
		/*ApplicationContext ioc =new ClassPathXmlApplicationContext("applicationcontext.xml");
		DepartmentMapper bean = ioc.getBean(DepartmentMapper.class);*/
		System.out.println(departmentmapper);
		/*departmentmapper.insertSelective(new Department(null,"������"));
		departmentmapper.insertSelective(new Department(null, "���Բ�"));
		employeemapper.insertSelective(new Employee(null,"jerry","M","837555220@qq.com",1));*/
		//��������
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		for(int i=0;i<1000;i++){
			String uid = UUID.randomUUID().toString().substring(0, 5)+i;
			mapper.insertSelective(new Employee(null, uid, "M", uid+"@qq.com", 1));
		}
		System.out.println("�������");
		
	}
}
