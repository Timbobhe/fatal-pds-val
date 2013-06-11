package org.rtdg.prioriser.dao;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import junit.framework.Assert;

import org.dbunit.DatabaseTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.rtdg.prioriser.CriticiteValue;
import org.rtdg.prioriser.db.SessionDB;

public class CriticiteValueDAOTest extends DatabaseTestCase {

	@Override
	protected IDatabaseConnection getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection jdbcConnection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/nidal", "root", "admin");
		return new DatabaseConnection(jdbcConnection);
	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		File branchXMLFile = new File(
				"src/test/resources/CriticiteValueDAOTest.xml");
		return new FlatXmlDataSetBuilder().build(new FileInputStream(
				branchXMLFile));
	}

	@After
	protected void tearDown() throws Exception {
		SessionDB.close();
		DatabaseOperation.DELETE_ALL.execute(getConnection(), getDataSet());
		super.tearDown();

	}

	@Before
	protected void setUp() throws Exception {
		SessionDB.init();
		DatabaseOperation.CLEAN_INSERT.execute(getConnection(), getDataSet());
		super.setUp();
	}

	@Test
	public void testList() {
		List<CriticiteValue> list = CriticiteValueDao.list();
		Assert.assertNotNull(list);
		Assert.assertEquals(5, list.size());
	}

	@Test
	public void testSave() {
		CriticiteValue criticiteValue = new CriticiteValue();
		criticiteValue.setSensorType("sensorTypeTest");
		criticiteValue.setValue("valueTest");
		Double equartype = new Double(67);
		criticiteValue.setEquartype(equartype);
		CriticiteValueDao.save(criticiteValue);
		SessionDB.commit();
		List<CriticiteValue> list = CriticiteValueDao.list();
		Assert.assertEquals(6, list.size());
		Assert.assertTrue(list.contains(criticiteValue));
	}

}
