package com.inferentia.venus.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.inferentia.venus.pojo.IngredientType;
import com.inferentia.venus.pojo.VMInfo;

public class VMInfoDao {

	 private JdbcTemplate jdbcTemplate;
	 
	 private final static String GET_MACHINE_INFO = "select * from machine_details where machine_id=?;";
	 
	 private final static String INSERT_MACHINE_INFO = "insert into machine_details values(?,?,?,?,?,?);";
	 
	 private final static String UPDATE_MACHINE_INFO = "update machine_details set ";
	 
	 public VMInfoDao(DataSource dataSource){
		 jdbcTemplate = new JdbcTemplate(dataSource);
	 }

	 public VMInfo getVMInfo(UUID machineID) {
		 List<Object> args = new ArrayList<Object>();
		 args.add(machineID.toString());
		 List<VMInfo> machineList = jdbcTemplate.query(GET_MACHINE_INFO,args.toArray(),new VMInfoMapper());
		 if(machineList.size()>1) {
			 System.err.println("Multiple entries present for the same machine" + machineID);
		 }
		 return machineList.get(0);
	 }
	 
	 
	 public boolean createMachineDetails(VMInfo info) {
		 List<Object> args = new ArrayList<Object>();
		 args.add(info.getMachineID().toString());
		 args.add(info.getIngredientType().name());
		 args.add(info.getCollectorNumber());
		 args.add(info.getIngredientName());
		 args.add(info.getIngredientAmount());
		 args.add(info.getIngredientUnit());
		 int rows = jdbcTemplate.update(INSERT_MACHINE_INFO, args.toArray());
		 if(rows==1) {
			 return true;
		 }
		 return false;
	 }
	
}


class VMInfoMapper implements RowMapper<VMInfo>{

	public VMInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		VMInfo info = new VMInfo();
		info.setMachineID(UUID.fromString(rs.getString("machine_id")));
		info.setIngredientType(IngredientType.valueOf(rs.getString("ingredient_type")));
		info.setCollectorNumber(rs.getInt("collector_num"));
		info.setIngredientName(rs.getString("ingredient_name"));
		info.setIngredientUnit(rs.getString("ingredient_unit"));
		info.setIngredientAmount(rs.getInt("ingredient_amount"));
		return info;
	}
}
