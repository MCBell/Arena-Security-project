package arenaClasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Passwordchecker {
	static ResultSet rs;

	static Boolean lengthchecker(String password){
		if (password.length()>=8)
			return true;
		else
			return false;
		
	}
	
	static Boolean CapitalChecker(String password){
		Boolean capital = false;
		for (int i =0; i<password.length(); i++){
			if(Character.isUpperCase(password.charAt(i))){
				capital = true;
				break;
			}
		}
		return capital;
	}
	
	static Boolean NumberChecker(String password){
		Boolean num = false;
		for (int i = 0; i<password.length();i++){
			if(Character.isDigit(password.charAt(i))){
				num = true;
				break;
			}
		}
		return num;
	}
	
	static Boolean quoteChecker(String input){
		Boolean ok = true;
		for (int i =0; i<input.length(); i++){
			if(input.charAt(i)== '\'' || input.charAt(i)=='"'){
				ok =false;
				break;
			}
		}
		return ok;
	}
	static Boolean userPass(String user, String pass){
		if (user != pass)
			return true;
		else
			return false;
	}
	
	static Boolean dictionary(String password) throws SQLException{
		Boolean ok = false;
		Connection myConnection = DBHandler.getConnection();
		try{
			String query = "SELECT * FROM commonpass WHERE userName ="+ password;
			PreparedStatement preparedStatement = myConnection.prepareStatement(query);
			preparedStatement.executeQuery(query);
			rs = preparedStatement.executeQuery(query);
			if (!rs.isBeforeFirst())
				ok = true;
		}
		finally
		{
			myConnection.close();
		}
		return ok;
	}
}
