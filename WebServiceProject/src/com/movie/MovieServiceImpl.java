package com.movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.jws.WebService;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.jboss.ws.annotation.EndpointConfig;

@WebService(endpointInterface = "com.movie.MovieService")
@EndpointConfig(configName = "Standard WSSecurity Endpoint")
public class MovieServiceImpl implements MovieService {

	public String addMovie(MovieType movie) {
		try {
			insertMovie(movie);
		} catch (NamingException e) {
			e.printStackTrace();
			return ("Could not insert movie due to naming exception");
		} catch (SQLException e) {
			e.printStackTrace();
			return ("Could not insert movie due to database exception");
		}
		return ("Successfully added movie " + movie.getTitle());

	}

	public static void insertMovie(MovieType movie) throws NamingException,
			SQLException {
		DataSource ds = null;
		try {
			InitialContext ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/MovieDSAlias");
		} catch (NamingException e) {
			throw e;
		}

		Connection con = null;
		try {
			con = ds.getConnection();
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement (
							"insert into movie (title, description, rating) values (?, ?, ?)",
							Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, movie.getTitle());
			ps.setString(2, movie.getDescription());
			ps.setString(3, movie.getRating());
			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				int key = rs.getInt(1);
				System.out.println("Added movie with ID: " + key);
			}

			rs.close();
			ps.close();
			con.commit();
		} catch (SQLException e) {
			con.rollback();
			throw e;
		} finally {
			if (con != null) {
				con.close();
			}
		}

	}

}
