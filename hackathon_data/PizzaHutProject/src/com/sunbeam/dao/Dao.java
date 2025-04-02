package com.sunbeam.dao;

import java.sql.Connection;

import com.sunbeam.utility.DBUtil;

public abstract class Dao implements AutoCloseable{
		protected Connection conn;
		public Dao() throws Exception{
			conn=DBUtil.getConnection();
		}
		public void close() throws Exception{
			conn.close();
		}
	}


