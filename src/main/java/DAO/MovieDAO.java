package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.DBConnect1;
import model.Movie;

public class MovieDAO {
	
	public ArrayList<Movie> getListMovie() throws SQLException {
		Connection connection = DBConnect1.getConnecttion();
		String sql = "SELECT * FROM movie";
		PreparedStatement ps = connection.prepareCall(sql);
		ResultSet rs = ps.executeQuery();
		ArrayList<Movie> list = new ArrayList<>();
		while (rs.next()) {
			Movie actor = new Movie();
			actor.setMovieId(rs.getInt("movie_id"));
			actor.setNameMovie(rs.getString("name_movie"));
			actor.setDescriptionMovie(rs.getString("description_movie"));
			actor.setImage(rs.getString("image"));
			actor.setTrailer(rs.getString("trailer"));
			actor.setVideo(rs.getString("video"));
			actor.setLo(rs.getString("lo"));
			actor.setMaturityRating(rs.getString("maturity_rating"));
			actor.setLastUpdate(rs.getDate("last_update"));
			actor.setDuration(rs.getString("duration"));
			actor.setTopHot(rs.getByte("top_hot"));
			list.add(actor);
		}
		return list;
	}
	
	public ArrayList<Movie> getListMovieLastest() throws SQLException {
		Connection connection = DBConnect1.getConnecttion();
		String sql = "SELECT * FROM movie order by last_update desc limit 20";
		PreparedStatement ps = connection.prepareCall(sql);
		ResultSet rs = ps.executeQuery();
		ArrayList<Movie> list = new ArrayList<>();
		while (rs.next()) {
			Movie actor = new Movie();
			actor.setMovieId(rs.getInt("movie_id"));
			actor.setNameMovie(rs.getString("name_movie"));
			actor.setDescriptionMovie(rs.getString("description_movie"));
			actor.setImage(rs.getString("image"));
			actor.setTrailer(rs.getString("trailer"));
			actor.setVideo(rs.getString("video"));
			actor.setLo(rs.getString("lo"));
			actor.setMaturityRating(rs.getString("maturity_rating"));
			actor.setLastUpdate(rs.getDate("last_update"));
			actor.setDuration(rs.getString("duration"));
			actor.setTopHot(rs.getByte("top_hot"));
			list.add(actor);
		}
		return list;
	}
	
	
	public ArrayList<Movie> getListMovieOfMenu(byte id_menu) throws SQLException {
		Connection connection = DBConnect1.getConnecttion();
		String sql = "";
		if (id_menu != 0) {
		 sql = "SELECT * FROM netflix.movie "
				+ "where movie_id IN (SELECT d.movie_id FROM  netflix.category as c "
				+ "INNER JOIN netflix.detail_movie as d ON d.category_id = c.category_id "
				+ "where c.menu_id = '"+id_menu +"')";
		}else {
		 sql = "SELECT * FROM netflix.movie order by top_hot asc";
		}
		PreparedStatement ps = connection.prepareCall(sql);
		ResultSet rs = ps.executeQuery();
		ArrayList<Movie> list = new ArrayList<>();
		while (rs.next()) {
			Movie actor = new Movie();
			actor.setMovieId(rs.getInt("movie_id"));
			actor.setNameMovie(rs.getString("name_movie"));
			actor.setDescriptionMovie(rs.getString("description_movie"));
			actor.setImage(rs.getString("image"));
			actor.setTrailer(rs.getString("trailer"));
			actor.setVideo(rs.getString("video"));
			actor.setLo(rs.getString("lo"));
			actor.setMaturityRating(rs.getString("maturity_rating"));
			actor.setLastUpdate(rs.getDate("last_update"));
			actor.setDuration(rs.getString("duration"));
			actor.setTopHot(rs.getByte("top_hot"));
			list.add(actor);
		}
		return list;
	}
	
	public ArrayList<Movie> getListMovieHasSameCategory(int movie_id) throws SQLException {
		Connection connection = DBConnect1.getConnecttion();
		String sql = "select * from movie inner join detail_movie on movie.movie_id = detail_movie.movie_id where category_id = (select category_id from detail_movie where movie_id = '"+movie_id+"' limit 1)";
		PreparedStatement ps = connection.prepareCall(sql);
		ResultSet rs = ps.executeQuery();
		ArrayList<Movie> list = new ArrayList<>();
		while (rs.next()) {
			Movie actor = new Movie();
			actor.setMovieId(rs.getInt("movie_id"));
			actor.setNameMovie(rs.getString("name_movie"));
			actor.setDescriptionMovie(rs.getString("description_movie"));
			actor.setImage(rs.getString("image"));
			actor.setTrailer(rs.getString("trailer"));
			actor.setVideo(rs.getString("video"));
			actor.setLo(rs.getString("lo"));
			actor.setMaturityRating(rs.getString("maturity_rating"));
			actor.setLastUpdate(rs.getDate("last_update"));
			actor.setDuration(rs.getString("duration"));
			actor.setTopHot(rs.getByte("top_hot"));
			list.add(actor);
		}
		return list;
	}

	public ArrayList<Movie> getListMovieOfId(int account_id) throws SQLException {
		Connection connection = DBConnect1.getConnecttion();
		String sql = "select * from movie inner join activiti_history_movie on movie.movie_id = activiti_history_movie.movie_id where saved = 1 and account_id ='"+account_id+"';";
		PreparedStatement ps = connection.prepareCall(sql);
		ResultSet rs = ps.executeQuery();
		ArrayList<Movie> list = new ArrayList<>();
		while (rs.next()) {
			Movie actor = new Movie();
			actor.setMovieId(rs.getInt("movie_id"));
			actor.setNameMovie(rs.getString("name_movie"));
			actor.setDescriptionMovie(rs.getString("description_movie"));
			actor.setImage(rs.getString("image"));
			actor.setTrailer(rs.getString("trailer"));
			actor.setVideo(rs.getString("video"));
			actor.setLo(rs.getString("lo"));
			actor.setMaturityRating(rs.getString("maturity_rating"));
			actor.setLastUpdate(rs.getDate("last_update"));
			actor.setDuration(rs.getString("duration"));
			actor.setTopHot(rs.getByte("top_hot"));
			list.add(actor);
		}
		return list;
	}
	
	public ArrayList<Movie> getListMovieOfIdHistory(int account_id) throws SQLException {
		Connection connection = DBConnect1.getConnecttion();
		String sql = "select * from movie inner join activiti_history_movie on movie.movie_id = activiti_history_movie.movie_id where account_id ='"+account_id+"';";
		PreparedStatement ps = connection.prepareCall(sql);
		ResultSet rs = ps.executeQuery();
		ArrayList<Movie> list = new ArrayList<>();
		while (rs.next()) {
			Movie actor = new Movie();
			actor.setMovieId(rs.getInt("movie_id"));
			actor.setNameMovie(rs.getString("name_movie"));
			actor.setDescriptionMovie(rs.getString("description_movie"));
			actor.setImage(rs.getString("image"));
			actor.setTrailer(rs.getString("trailer"));
			actor.setVideo(rs.getString("video"));
			actor.setLo(rs.getString("lo"));
			actor.setMaturityRating(rs.getString("maturity_rating"));
			actor.setLastUpdate(rs.getDate("last_update"));
			actor.setDuration(rs.getString("duration"));
			actor.setTopHot(rs.getByte("top_hot"));
			list.add(actor);
		}
		return list;
	}

	public ArrayList<Movie> getListMovieInSearch(String name_movie) throws SQLException {
		Connection connection = DBConnect1.getConnecttion();
		String sql = "SELECT * FROM netflix.movie where name_movie like '%"+ name_movie +"%'";
		PreparedStatement ps = connection.prepareCall(sql);
		ResultSet rs = ps.executeQuery();
		ArrayList<Movie> list = new ArrayList<>();
		while (rs.next()) {
			Movie actor = new Movie();
			actor.setMovieId(rs.getInt("movie_id"));
			actor.setNameMovie(rs.getString("name_movie"));
			actor.setDescriptionMovie(rs.getString("description_movie"));
			actor.setImage(rs.getString("image"));
			actor.setTrailer(rs.getString("trailer"));
			actor.setVideo(rs.getString("video"));
			actor.setLo(rs.getString("lo"));
			actor.setMaturityRating(rs.getString("maturity_rating"));
			actor.setLastUpdate(rs.getDate("last_update"));
			actor.setDuration(rs.getString("duration"));
			actor.setTopHot(rs.getByte("top_hot"));
			list.add(actor);
		}
		return list;
	}

	
	public ArrayList<Movie> getListMovie(int movie_id) throws SQLException {
			 Connection connection = DBConnect1.getConnecttion();
			 String sql = "SELECT * FROM movie WHERE movie_id = '" + movie_id + "'";
			 PreparedStatement ps = connection.prepareCall(sql);
			 ResultSet rs = ps.executeQuery();
			 ArrayList<Movie> list = new ArrayList<>();
			 while (rs.next()) {
				 Movie movie = new Movie();
				 movie.setMovieId(rs.getInt("movie_id"));
				 movie.setNameMovie(rs.getString("name_movie"));
				 movie.setDescriptionMovie(rs.getString("description_movie"));
				 movie.setImage(rs.getString("image"));
				 movie.setTrailer(rs.getString("trailer"));
				 movie.setVideo(rs.getString("video"));
				 movie.setLo(rs.getString("lo"));
				 movie.setMaturityRating(rs.getString("maturity_rating"));
				 movie.setLastUpdate(rs.getDate("last_update"));
				 movie.setDuration(rs.getString("duration"));
				 movie.setTopHot(rs.getByte("top_hot"));
				 list.add(movie);
			 }
			 return list;
			 }
	
	public Movie getMovie(int movie_id) throws SQLException {
		Connection connection = DBConnect1.getConnecttion();
		String sql = "SELECT * FROM movie WHERE movie_id = '" + movie_id + "'";
		PreparedStatement ps = connection.prepareCall(sql);
		ResultSet rs = ps.executeQuery();
		Movie actor = new Movie();
		while (rs.next()) {
			actor.setMovieId(rs.getInt("movie_id"));
			actor.setNameMovie(rs.getString("name_movie"));
			actor.setDescriptionMovie(rs.getString("description_movie"));
			actor.setImage(rs.getString("image"));
			actor.setTrailer(rs.getString("trailer"));
			actor.setVideo(rs.getString("video"));
			actor.setLo(rs.getString("lo"));
			actor.setMaturityRating(rs.getString("maturity_rating"));
			actor.setLastUpdate(rs.getDate("last_update"));
			actor.setDuration(rs.getString("duration"));
			actor.setTopHot(rs.getByte("top_hot"));
		}
		return actor;
	}

	public boolean insert(Movie c) throws SQLException {
		try {
		Connection connection = DBConnect1.getConnecttion();
		String sql = "INSERT INTO movie VALUE(?,?,?,?,?,?,?,?,?,?,?)";
		java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
		
		PreparedStatement ps = connection.prepareCall(sql);
		ps.setInt(1, c.getMovieId());
		ps.setString(2, c.getNameMovie());
		ps.setString(3, c.getDescriptionMovie());
		ps.setString(4, c.getImage());
		ps.setString(5, c.getTrailer());
		ps.setString(6, c.getVideo());
		ps.setString(7, c.getLo());
		ps.setString(8, c.getMaturityRating());
		ps.setDate(9, sqlDate);
		ps.setString(10, c.getDuration());
		ps.setByte(11, c.getTopHot());
		int temp = ps.executeUpdate();
		return temp == 1;
		} catch (Exception e) {
		return false;
		}
	}
	public ArrayList<Movie> getMoviebyCategory(int category_id) 
			throws SQLException {
			 Connection connection = DBConnect1.getConnecttion();
			 String sql = "SELECT * FROM movie inner join detail_movie on movie.movie_id=detail_movie.movie_id where category_id='" + category_id + "'";
			 PreparedStatement ps = connection.prepareCall(sql);
			 ResultSet rs = ps.executeQuery();
			 ArrayList<Movie> list = new ArrayList<>();
			 while (rs.next()) {
				 Movie movie = new Movie();
				 movie.setMovieId(rs.getInt("movie_id"));
				 movie.setNameMovie(rs.getString("name_movie"));
				 movie.setDescriptionMovie(rs.getString("description_movie"));
				 movie.setImage(rs.getString("image"));
				 movie.setTrailer(rs.getString("trailer"));
				 movie.setVideo(rs.getString("video"));
				 movie.setLo(rs.getString("lo"));
				 movie.setMaturityRating(rs.getString("maturity_rating"));
				 movie.setLastUpdate(rs.getDate("last_update"));
				 movie.setDuration(rs.getString("duration"));
				 movie.setTopHot(rs.getByte("top_hot"));
				 list.add(movie);
			 }
			 return list;
			 }
	// get Max ID in database
	public int getMaxId() throws SQLException {
		try {
		Connection connection = DBConnect1.getConnecttion();
		String sql = "SELECT movie_id FROM movie ORDER BY movie_id DESC LIMIT 1";
		PreparedStatement ps = connection.prepareCall(sql);
		ResultSet rs = ps.executeQuery();
		int i = 0;
//		 loop any row in database to get every Items and return a value
		while(rs.next()) {
			i = rs.getInt("movie_id");
		}
		return i;
		} catch (Exception e) {
		return 0;
		}
	}
	
	public boolean update(Movie c) throws SQLException {
		try {
		Connection connection = DBConnect1.getConnecttion();
		String sql = "UPDATE movie SET name_movie =?, description_movie = ?,"
				+ " image = ?, trailer = ?, video = ?, lo = ?, maturity_rating =?, "
				+ "last_update = ?, duration = ?, top_hot = ? WHERE movie_id = ?";
		PreparedStatement ps = connection.prepareCall(sql);
		java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
		ps.setString(1, c.getNameMovie());
		ps.setString(2, c.getDescriptionMovie());
		ps.setString(3, c.getImage());
		ps.setString(4, c.getTrailer());
		ps.setString(5, c.getVideo());
		ps.setString(6, c.getLo());
		ps.setString(7, c.getMaturityRating());
		ps.setDate(8, sqlDate);
		ps.setString(9, c.getDuration());
		ps.setByte(10, c.getTopHot());
		ps.setInt(11, c.getMovieId());
		int temp = ps.executeUpdate();
		return temp == 1;
		} catch (Exception e) {
		return false;
		}
	}		
	
	public boolean delete(int movie_id) throws SQLException {
	try {
		Connection connection = DBConnect1.getConnecttion();
		String sql = "DELETE FROM movie WHERE movie_id = '"+ movie_id +"'";
		PreparedStatement ps = connection.prepareCall(sql)	;
		int temp = ps.executeUpdate();
		return temp == 1;
		} catch (Exception e) {
		return false;
		}
	}		
	
	public static void main(String[] args) throws SQLException {
			MovieDAO dao = new MovieDAO();
//			for(int i=7; i<12; i++ ) {
//				System.out.println(dao.insert(new Movie(i,"Buffalo",null,null,null,null,null,null,null,Byte.parseByte("1")))); 
//			}
//			System.out.println(dao.update(new Movie(6,"Bird",null,null,null,null,null,null,null,Byte.parseByte("1"))));
//			System.out.println(dao.delete(7));
//			System.out.println(dao.getMaxId());
			System.out.println(dao.delete(10));
	}

}
