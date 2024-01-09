package com.study.mybatis.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	// mybatis-config.xml 파일을 읽어들여서 해당 DB와 접속된 SqlSession 객체를 생성하여 반환
	public static SqlSession getSqlSession() {
		SqlSession sqlSession = null;
		String resource = "/mybatis-config.xml";
		
		// SqlSession을 생성하기 위해 => SqlSessionFactory가 필요
		// SqlSessionFactory => SqlSessionFactoryBuilder 필요
		try {
			InputStream stream = Resources.getResourceAsStream(resource);
			sqlSession = new SqlSessionFactoryBuilder().build(stream).openSession(false);
			// openSession(false) : 기본값
			// false -> 자동커밋 사용안함, true -> 자동커밋함
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sqlSession;
	}
}
