package com.jxnu.webapp.rw;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;


public class DataSourceAspect {

	private static DataSourceAspect dataSourceAspect;

	public static void main(String[] args) {

	}
	
	public DataSourceAspect() {
		dataSourceAspect = this;
	}
	
    public void before(JoinPoint point) {
        try {
            Method m = ((MethodSignature) point.getSignature())
                    .getMethod();
            String datasource = "master"; // 默认用master库
            boolean isRead = false; // 默认使用读写

            if (m != null && m.isAnnotationPresent(DataSource.class)) {
                DataSource data = m.getAnnotation(DataSource.class);
                datasource = data.value();
                isRead = data.isRead();
            }

            if (isRead) {
                datasource += "_read"; // 读库
            }

            HandleDataSource.putDataSource(datasource);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
