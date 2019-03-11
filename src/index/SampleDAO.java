package index;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SampleDAO {
	Connection con = null;
	//接続メソッド
	public void connection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/sampledb?useSSL=false",
					"root", "root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//切断メソッド
	public void disconnection() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//sampletbの一覧を出力するメソッド
	public ArrayList<Person> selectAll() {
		ArrayList<Person> list = new ArrayList<Person>();
		connection();
		if (con != null) {
			String sql = "select * from sampletb";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					//表示せず、ArrayListに代入、あとで利用するので
					//今回はnameとageだけ
					//1行分のクラスを生成してフィールドに代入
					Person p = new Person();
					p.id=rs.getInt("id");
					p.name=rs.getString("name");
					p.age=rs.getInt("age");
					list.add(p);
		    	}
				rs.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconnection();
			}
		}
		return list;
	}


	public void printSelectByID(int id) {
		connection();
		if (con != null) {
			String sql = "select * from sampletb where id = ?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				//set
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					System.out.println("id列の取得" + rs.getInt("id"));
					System.out.println("name列の取得" + rs.getString("name"));
					System.out.println("age列の取得" + rs.getInt("age"));
					//System.out.println("time列の取得" + rs.getDate("time"));
				}
				rs.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconnection();
			}
		}
	}


	//sampletbに追加メソッド
	public int insert(String name,int age) {
		int rs=0;
		//InsertMiniの内容をペーストする
		connection();
		if (con != null) {
			String sql = "insert into  sampletb (name,age) values (?,?)";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1,name);
				ps.setInt(2, age);
				//ps.setString(3, "2010/10/10 9:5:1");
				rs = ps.executeUpdate();
				System.out.println("操作した行数は" + rs + "行です");
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconnection();
			}
		}
		return rs;
	}
	//変更メソッド
	public int update(int id,String name,int age) {
		int rs=0;
		//InsertMiniの内容をペーストする
		connection();
		if (con != null) {
			// update sampletb set name = 'aa', age=10 where id = 10;
			// update sampletb set name = ?, age=? where id = ?;

			String sql = "update sampletb set name = ?, age=? where id = ?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1,name);
				ps.setInt(2, age);
				ps.setInt(3, id);
				rs = ps.executeUpdate();
				System.out.println("操作した行数は" + rs + "行です");
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconnection();
			}
		}
		return rs;
	}
	//削除メソッド
	public int delete(int id) {
		int rs=0;
		connection();
		if (con != null) {
			//delete from sampletb where id = 10;
			//delete from sampletb where id = ?;
			String sql = "delete from sampletb where id = ?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1,id);
				rs = ps.executeUpdate();
				System.out.println("操作した行数は" + rs + "行です");
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconnection();
			}
		}
		return rs;
	}







}

