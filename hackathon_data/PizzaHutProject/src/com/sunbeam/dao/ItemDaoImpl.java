package com.sunbeam.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sunbeam.entity.Items;

public class ItemDaoImpl extends Dao implements ItemDao {
	private PreparedStatement stmtshowVegPizza;
	private PreparedStatement stmtshowNonVegPizza;
	
	
	
	public ItemDaoImpl() throws Exception {
		String sqlShowVegPizza="Select * from pizza_items where type=?";
		stmtshowVegPizza=conn.prepareStatement(sqlShowVegPizza);
		String sqlShowNonVegPizza="Select * from pizza_items where type=?";
		stmtshowNonVegPizza=conn.prepareStatement(sqlShowNonVegPizza);
		
	
	}
	@Override
	public void close() throws Exception {
		stmtshowVegPizza.close();
		stmtshowNonVegPizza.close();
		super.close();
	}
	@Override
	public List<Items>  showVegItems(String type) throws Exception {
		List<Items> ilist=new ArrayList<Items>();
		stmtshowVegPizza.setString(1, type);
		try(ResultSet rs=stmtshowVegPizza.executeQuery()){
			while(rs.next()) {
				int id=rs.getInt("id");
				String name=rs.getString("name");
				 type=rs.getString("type");
				 String category=rs.getString("category");
				 String description=rs.getString("description");
				 Items ii=new Items(id,name,type,category,description);
				 ilist.add(ii);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ilist;
		
	}
	@Override
	public List<Items> showNonVegItems(String type) throws Exception {
		List<Items> ilist=new ArrayList<Items>();
		stmtshowNonVegPizza.setString(1, type);
		try(ResultSet rs=stmtshowNonVegPizza.executeQuery()){
			while(rs.next()) {
				int id=rs.getInt("id");
				String name=rs.getString("name");
				 type=rs.getString("type");
				 String category=rs.getString("category");
				 String description=rs.getString("description");
				 Items ii=new Items(id,name,type,category,description);
				 ilist.add(ii);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ilist;
		
		
	}

}
