package executavel;

import view.Menu;

import java.util.Locale;

public class Executavel {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Menu menu = new Menu();
		menu.apresentaMenu();
		
	}

}
