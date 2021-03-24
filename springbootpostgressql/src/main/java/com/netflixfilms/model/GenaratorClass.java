package com.netflixfilms.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class GenaratorClass implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		String prefix = "s";
		String suffix = "";
		Connection connection = session.connection();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select count(show_id) as showId from Films");
			if (rs.next()) {
				int id = rs.getInt(1) + 1;
				suffix = String.valueOf(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return prefix + suffix;
	}

}
