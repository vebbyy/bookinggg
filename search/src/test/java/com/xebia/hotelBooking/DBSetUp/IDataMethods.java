package com.xebia.hotelBooking.DBSetUp;

import java.io.File;

import javax.sql.DataSource;

import org.dbunit.DatabaseTestCase;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.ext.hsqldb.HsqldbDataTypeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;

public class IDataMethods extends DatabaseTestCase{
	
	@Autowired
	private DataSource dataSource ;
	
	@Override
	protected IDatabaseConnection getConnection() throws Exception {
		DatabaseConnection databaseConnection = new DatabaseConnection(
				dataSource.getConnection());
		DatabaseConfig config = databaseConnection.getConfig();
		config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY,
				new HsqldbDataTypeFactory());
		return databaseConnection;
	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		File file = new ClassPathResource("/dataset.xml").getFile();
		return new FlatXmlDataSet(file);
	}
	
}
