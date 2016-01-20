package com.jxnu.webapp.rw;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 选择数据源
 * @author zby
 *
 */
public class ChooseDataSource extends AbstractRoutingDataSource{

	@Override
	protected Object determineCurrentLookupKey() {
		// TODO Auto-generated method stub
		return  HandleDataSource.getDataSource();
	}

}
