package homeAutomation;

import java.util.ArrayList;

/**
 * Class responsible for managing home automations. Handles creation and removal
 * of Components and Automations. Changes status of components and reacts on
 * status changes with triggering the right automations (setting status of
 * other component)
 * @author tblijlevens
 *
 */
public class HAManager {

	//  ATRIBUTES
	private ArrayList<Component> components = new ArrayList<>();
	private ArrayList<Automation> automations = new ArrayList<>();
//	private ArrayList<String> triggeredAutomations = new ArrayList<>();

	// CONSTRUCTOR
	public HAManager(){
	}

	// METHODS

	public ArrayList<Component> getComponents(){
		return components;
	}
	public ArrayList<Automation> getAutomations(){
		return automations;
	}
	/**
	* Creates a new component and adds it to the <code>components</code> list attribute.
	* Only adds components with unique names.
	* @param name the name of the created component
	*/
	public void createNewComponent(String name){
		boolean exists = false;
		for (Component c : components){ //see if component does not already exist
			if (c.getName().equals(name)){
				exists = true;
				break;
			}
		}
		if (!exists){
			components.add(new Component(name));
		}
	}


// should not succeed when automation contains this component, or should ask to also remove those automations.
	/**
	 * Removes component with given name from the <code>components</code> list attribute.
	 * @param name the name of the component
	 */
	public void removeComponent(String name){
		Component removeThis = null;
		for (Component c : components){ //see if automation does not already exist
			if (c.getName().equals(name)){
				removeThis = c;
			}
		}
		if (removeThis!=null){
			components.remove(removeThis);
		}
	}
	/**
	 * Creates a new automation, linking two components together. When a status change
	 * of a component is defined as a trigger in an automation the status of Component
	 * <code>responseComp</code> will be changed to <code>responseStatus</code>.
	 * Only creates a new automation if it has a unique name (does not already exist).
	 * @param name the name of the automation
	 * @param triggerComp the Component which triggers the automation
	 * @param triggerStatus the prerequisite status of <code>triggerComp</code> to trigger the automation
	 * @param responseComp the Component which responses to the trigger
	 * @param responseStatus the wanted status of <code>responseComp</code>
	 * @return returns a boolean feedback of success (fails if no unique name)
	 */
	public boolean createNewAutomation(String autoName, String triggerCompName, boolean triggerStatus, String responseCompName, boolean responseStatus){
		boolean exists = false;

		for (Automation a : automations){ //see if automation does not already exist
			if (a.getName().equals(autoName)){
				exists = true;
			}
		}
		if (!exists){
			Component triggerComp = null;
			Component responseComp = null;
			for (Component c : components){	// find right components
				if (c.getName().equals(triggerCompName)){
					triggerComp = c;
				}
				else if (c.getName().equals(responseCompName)){
					responseComp = c;
				}
			}
			if (triggerComp!=null && responseComp !=null){
				Automation newAutomation = new Automation(autoName, triggerComp, triggerStatus, responseComp, responseStatus); // create new automation
				automations.add(newAutomation);
				return true; //returns succes feedback
			}
		}
			return false; // returns fail feedback

	}

	/**
	 * Removes Automation with the given name from the <code>automations</code> list
	 * attribute.
	 * @param name
	 */
	public void removeAutomation(String name){
		Automation removeThis = null;
		for (Automation a : automations){ //see if automation does not already exist
			if (a.getName().equals(name)){
				removeThis = a;
			}
		}
		if (removeThis!=null){
			automations.remove(removeThis);
		}
	}


	/**
	 * Responsible for changing the status of the named component, triggering
	 * the right automations based on that status change and returning a list
	 * of the triggered automations (including chain triggered automations).
	 * Automations will only trigger if the status of the <code>triggerComponent</code>
	 * was changed (e.g. when setting false to false nothing triggers)
	 * @param name the name of the component which status must be changed
	 * @param stat the status that component needs to change to.
	 * @return a string with the names of all triggered automations (including
	 * chain triggered automations).
	 */
	public String changeStatus(String name, boolean stat){
		String triggeredAutomations = "";
		ArrayList<String> allChainedAutos = new ArrayList<>();
		ArrayList<String> chainedAutos = new ArrayList<>();
		for (Component c : components){
			if (c.getName()==name && c.getStatus() != stat){ //if current status is not "stat"
				c.changeStatus(stat); //change status
				for (Automation a : automations){ //loop through automations
					if (a.getTriggerComp() == c && a.getTriggerStatus() == stat){ // find triggered automations: component and status are triggers in an automation

						chainedAutos = a.triggerAutomation(automations); // trigger that automation. first triggered automation now contains all names of all chained automations and returns it to this HAManager instance
						for (String s : chainedAutos){ //loop through chained automations
							// add line to only add unique strings...
							allChainedAutos.add(s);  //add all names to allChainedAutos
						}
					}
				}
			}
		}

		for (String s : allChainedAutos){
			triggeredAutomations += s +"\n";
		}
		return triggeredAutomations;
	} // endmethod changeStatus

	public Component getComponent(String name){
		Component comp = null;
		for (Component c : components){	// find right components
			if (c.getName()==name){
				comp = c;
			}
		}
		return comp;
	}

}
