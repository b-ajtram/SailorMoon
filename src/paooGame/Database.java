package paooGame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public final class Database {
	Connection c = null;
	Statement stmt = null;

	public Database() {
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:GameDB.db");
			c.setAutoCommit(false);
			c.commit();
			c.close();
		} catch (Exception e) {
			System.err.print(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}

	public void loadGame(){
		Connection c = null;
		Statement stmt = null;

		try {
		Class.forName("org.sqlite.JDBC");
		c = DriverManager.getConnection("jdbc:sqlite:GameDB.db");
		c.setAutoCommit(false);
		stmt = c.createStatement();
		String sql = "";
		ResultSet rs = stmt.executeQuery(sql);
		if(rs.next()) {

		}
		rs.close();
		stmt.close();
		c.close();
	} catch (Exception e) {
		System.err.print(e.getClass().getName() + ": " + e.getMessage());
		System.exit(0);
	}
}

	public void saveLevel(int level, int score, int health, String player) {
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:GameDB.db");
			c.setAutoCommit(false);
			stmt = c.createStatement();
			stmt = c.createStatement();
			String sql = "INSERT INTO SAVEDSTATE(LEVEL, SCORE, HEALTH, PLAYER)" + "VALUES(" + level + " " + score + " "+" " +health + player + ");";
			stmt.executeUpdate(sql);
			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			System.err.print(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}

	public String getBackgroundPath(int level) {
		Connection c = null;
		Statement stmt = null;
		String path="";
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:GameDB.db");
			c.setAutoCommit(false);
			stmt = c.createStatement();
			String sql = "SELECT * FROM LEVELS WHERE LEVEL" + " = " + level+";";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				path = rs.getString("BACKGROUND");
			}
			rs.close();
			stmt.close();
			c.close();
			return path;
		} catch (Exception e) {
			System.err.print(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
			return "";
		}
	}

	public String getForegroundPath(int level) {
		Connection c = null;
		Statement stmt = null;
		String path="";
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:GameDB.db");
			c.setAutoCommit(false);
			stmt = c.createStatement();
			String sql = "SELECT * FROM LEVELS WHERE LEVEL" + " = " + level+";";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				path = rs.getString("FOREGROUND");
			}
			rs.close();
			stmt.close();
			c.close();
			return path;
		} catch (Exception e) {
			System.err.print(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
			return "";
		}
	}
	public String getCollectablePath(int level) {
		Connection c = null;
		Statement stmt = null;
		String path="";
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:GameDB.db");
			c.setAutoCommit(false);
			stmt = c.createStatement();
			String sql = "SELECT * FROM LEVELS WHERE LEVEL" + " = " + level+";";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				path = rs.getString("COLLECTABLE");
			}
			rs.close();
			stmt.close();
			c.close();
			return path;
		} catch (Exception e) {
			System.err.print(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
			return "";
		}
	}
}
