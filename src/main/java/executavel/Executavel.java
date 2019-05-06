package executavel;

import view.Menu;

import java.sql.SQLException;
import java.util.Locale;

public class Executavel {

	public static void main(String[] args) throws SQLException {
		Locale.setDefault(Locale.US);
		Menu menu = new Menu();
		menu.apresentaMenu();
		
	}

}
