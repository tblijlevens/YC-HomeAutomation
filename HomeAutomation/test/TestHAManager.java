package test;

import java.util.ArrayList;

import homeAutomation.Automation;
import homeAutomation.Component;
import homeAutomation.HAManager;

public class TestHAManager {

	public static void main(String[] args) {
		HAManager theManager = new HAManager(); //make new manager
		ArrayList<Component> allComponents = theManager.getComponents();
		ArrayList<Automation> allAutomations = theManager.getAutomations();

		System.out.println("expect 0 of everything");
		System.out.println(textComps(allComponents));
		System.out.println(textAuts(allAutomations));

		//create two components
		System.out.println();
		System.out.println("4 comps are made. 4 auts are made.");
		theManager.createNewComponent("wifi");
		theManager.createNewComponent("Kitchen Light");
		theManager.createNewComponent("Table Light");
		theManager.createNewComponent("Heating");

		theManager.createNewAutomation("Wifi on > Kitchen Light on", "wifi", true, "Kitchen Light", true);
		theManager.createNewAutomation("Kitchen on > Table Light on", "Kitchen Light", true, "Table Light", true);
		theManager.createNewAutomation("Table Light on > Heating on", "Table Light", true, "Heating", true);
		theManager.createNewAutomation("Heating off > Kitchen Light off", "Heating", false, "Kitchen Light", false);


		allComponents = theManager.getComponents();
		allAutomations = theManager.getAutomations();
		System.out.println(textComps(allComponents));
		System.out.println(textAuts(allAutomations));


		System.out.println();
		System.out.println("table is turned on. Expect 1 triggers, table and heating on.");
		System.out.println(theManager.changeStatus("Table Light", true));
		allComponents = theManager.getComponents();
		allAutomations = theManager.getAutomations();
		System.out.println(textComps(allComponents));
		System.out.println(textAuts(allAutomations));

		System.out.println("table and heating is turned off. Expect all off.");
		System.out.println(theManager.changeStatus("Table Light", false));
		System.out.println(theManager.changeStatus("Heating", false));
		allComponents = theManager.getComponents();
		allAutomations = theManager.getAutomations();

		System.out.println();
		System.out.println("wifi is turned on. Expect 3 triggers, all 4 components on.");
		System.out.println(theManager.changeStatus("wifi", true));
		allComponents = theManager.getComponents();
		allAutomations = theManager.getAutomations();
		System.out.println(textComps(allComponents));
		System.out.println(textAuts(allAutomations));

		System.out.println();
		System.out.println("Heating is turned off. expect heating and kLight off.");
		System.out.println(theManager.changeStatus("Heating", false));
		allComponents = theManager.getComponents();
		allAutomations = theManager.getAutomations();
		System.out.println(textComps(allComponents));
		System.out.println(textAuts(allAutomations));

		System.out.println();
		System.out.println("kLight turned on. expect 0 triggered. expect heating to stay off cause tLight was already on.");
		System.out.println(theManager.changeStatus("Kitchen Light", true));
		allComponents = theManager.getComponents();
		allAutomations = theManager.getAutomations();
		System.out.println(textComps(allComponents));
		System.out.println(textAuts(allAutomations));

		System.out.println();
		System.out.println("removed Table Light.");
		theManager.removeComponent("Table Light");
		allComponents = theManager.getComponents();
		allAutomations = theManager.getAutomations();
		System.out.println(textComps(allComponents));
		System.out.println(textAuts(allAutomations));
/*
		Further tests:
		removed components in triggered automations.
		trigger the same automation in one chain. Should only give back the trigger once with maybe a counter.
*/

	} //end main

//create printtexts:
	public static String textComps(ArrayList<Component> allComponents){
		String text = "Currently there are " + allComponents.size() + " components. Named:";
		for (int i = 0 ; i<allComponents.size() ; i++){
			text += " " + allComponents.get(i).getName() + " (" + allComponents.get(i).getStatus() +").";
		}
		return text;
	}
	public static String textAuts(ArrayList<Automation> allAutomations){
		String text = "Currently there are " + allAutomations.size() + " automations. Named:";
		for (int i = 0 ; i<allAutomations.size() ; i++){
			text += 	" " + allAutomations.get(i).getName() + ".";
		}
		return text;
	}


}// end doc
