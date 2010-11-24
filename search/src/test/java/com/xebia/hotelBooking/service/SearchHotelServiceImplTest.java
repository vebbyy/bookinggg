package com.xebia.hotelBooking.service;

import java.io.File;

import javax.sql.DataSource;

import org.dbunit.DatabaseTestCase;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.ext.hsqldb.HsqldbDataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.DirectFieldAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xebia.hotelBooking.domain.Hotel;
import com.xebia.hotelBooking.hibernate.HibernateTemplate;
import com.xebia.hotelBooking.model.SearchModel;
import com.xebia.hotelBooking.service.impl.SearchHotelServiceImpl;

@ContextConfiguration(locations = { "classpath:hibernate-test.cfg.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class SearchHotelServiceImplTest extends DatabaseTestCase {

	private static final String TABLE_HOTEL = "hotel";

	private FlatXmlDataSet loadedDataSet;

	private SearchHotelServiceImpl searchHotelService;

	@Autowired
	private SessionFactory hibernateSession;

	@Autowired
	private DataSource dataSource;

	private DirectFieldAccessor directFieldAccessor;

	private HibernateTemplate hibernateTemplate;

	private SearchModel searchModel;
	
	@Before
	public void setUp() throws Exception {
		DatabaseOperation.CLEAN_INSERT.execute(getConnection(), getDataSet());
		searchModel=new SearchModel();
		searchModel.setHotelName("Rad");
		searchHotelService = new SearchHotelServiceImpl();
		hibernateTemplate = new HibernateTemplate();

		directFieldAccessor = new DirectFieldAccessor(searchHotelService);
		directFieldAccessor.setPropertyValue("hibernateTemplate",
				hibernateTemplate);
		directFieldAccessor.setPropertyValue("searchModel",searchModel);
		directFieldAccessor = new DirectFieldAccessor(hibernateTemplate);
		directFieldAccessor.setPropertyValue("session", hibernateSession
				.openSession());
		}

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
		loadedDataSet = new FlatXmlDataSet(file);

		return loadedDataSet;
	}

	@Test
	public void shouldGetHotelList() {
		assertEquals(1, searchHotelService.getHotelList().size());

	}

}
