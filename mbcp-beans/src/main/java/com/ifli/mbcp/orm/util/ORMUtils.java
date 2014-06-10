package com.ifli.mbcp.orm.util;

import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;

/**
 * <p>Title: ORMUtils</p>
 * 
 * <p>
 * Util class containing several methods used in Hibernate session and beans's manipulations.
 * </p>
 * @author sureshk
 */
public class ORMUtils {

	public static <T> T initializeAndUnproxy(T entity) {
		if (entity == null) {
			return null;
		}

		if (entity instanceof HibernateProxy) {
			Hibernate.initialize(entity);
			entity = (T) ((HibernateProxy) entity).getHibernateLazyInitializer().getImplementation();
		}
		return entity;
	}

	
	
}
