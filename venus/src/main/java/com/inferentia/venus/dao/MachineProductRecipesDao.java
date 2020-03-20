package com.inferentia.venus.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.inferentia.venus.pojo.MachineProductRecipeInfo;

public class MachineProductRecipesDao {
	private JdbcTemplate jdbcTemplate;
	 
	 private final static String GET_ALL_PRODUCTS_INFO = "select * from machine_product_recipes where machine_id=?;";
	 
	 private final static String INSERT_NEW_PRODUCT_INFO= "insert into machine_product_recipes values(?,?,?,?,?) "
	 		+ "	ON DUPLICATE KEY UPDATE product_name=? , amounts_required=? , amount_unit=? , recipe_code=?";
	 
	 private final static String UPDATE_PRODUCT_INFO = "update payment_options set ";
	 
	 public MachineProductRecipesDao(DataSource dataSource){
		 jdbcTemplate = new JdbcTemplate(dataSource);
	 }

	 public List<MachineProductRecipeInfo> getRecipeCodes(UUID machineID) {
		 List<Object> args = new ArrayList<Object>();
		 args.add(machineID.toString());
		return jdbcTemplate.query(GET_ALL_PRODUCTS_INFO,args.toArray(),new ProductRecipeInfoMapper());
	 }
	 
	 
	 public boolean addNewProduct(MachineProductRecipeInfo info) {
		 List<Object> args = new ArrayList<Object>();
		 args.add(info.getMachineID().toString());
		 args.add(info.getProductUniqueName());
		 args.add(info.getProductUnit());
		 args.add(info.getProductUnitsRequired());
		 args.add(info.getRecipeCode());
		 
		 int rows = jdbcTemplate.update(INSERT_NEW_PRODUCT_INFO, args.toArray());
		 if(rows>0) {
			 return true;
		 }
		 return false;
	 }
	
	}

	class ProductRecipeInfoMapper implements RowMapper<MachineProductRecipeInfo>{

		public MachineProductRecipeInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
			MachineProductRecipeInfo info = new MachineProductRecipeInfo();
			info.setMachineID(UUID.fromString(rs.getString("machine_id")));
			info.setProductUniqueName(rs.getString("product_name"));
			info.setProductUnitsRequired(rs.getInt("amounts_required"));
			info.setProductUnit(rs.getString("amount_unit"));
			info.setRecipeCode(rs.getString("recipe_code"));
			return info;
		}
}
