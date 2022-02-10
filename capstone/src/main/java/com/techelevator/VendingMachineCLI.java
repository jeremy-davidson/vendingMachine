package com.techelevator;

import com.techelevator.view.Menu;
import com.techelevator.VendingMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };
	private static final String FEED_MONEY = "Feed Money";
	private static final String PRODUCT_SELECTION = "Select Product";
	private static final String FINISH = "Finish";
	private static final String[] OPTIONS = {FEED_MONEY, PRODUCT_SELECTION, FINISH};
	private Menu menu;
	List<Products> purchasedProducts = new ArrayList<>();

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				while (true) {
					String[] productArray = new String[inventoryMap.size()];
					int counter = 0;
					Set<Map.Entry<String, Products>> entrySet = inventoryMap.entrySet();
					for (Map.Entry<String, Products> entry: entrySet) {
						String key = entry.getKey();
						Products value = entry.getValue();
						productArray[counter] = key + " " + value.toString();
						counter++;
					}
					menu.displayMenuOptionsForItems(productArray);
					break;
				}
				}
			//} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
