package test;

import homeAutomation.Component;

public class TestComponent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Component wifi = new Component("wifi");
		System.out.println(wifi.getName() + " is " + wifi.getStatus());

		wifi.changeStatus(true);
		System.out.println(wifi.getName() + " is " + wifi.getStatus());

	}

}
