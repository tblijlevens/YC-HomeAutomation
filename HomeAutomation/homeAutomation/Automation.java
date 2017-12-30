package homeAutomation;

import java.util.ArrayList;

/**
 * Class responsible for managing automations. An automation links two components
 * together. Changing the status of a <code>triggerComp</code> to the <code>triggeStatus</code> will
 * automatically change the status of the <code>responseComp</code> to the <code>responseStatus</code>.
 * @author tblijlevens
 *
 */
public class Automation {
  //  ATRIBUTES
  private String name = "";
  private Component triggerComp;
  private boolean triggerStatus;
  private Component responseComp;
  private boolean responseStatus;


  /**
   * Constructor creates a new Automation with given name,
   * and trigger and response components and statuses.
   * @param name the name this Automation is given
   * @param triggerComp the component on which a status
   * change should trigger this automation.
   * @param triggerStatus the status that <code>triggerComp</code>
   * should change to, to trigger this automation.
   * @param responseComp the component that should change it's status
   * in response to the trigger
   * @param responseStatus the status that <code>responseComp</code>
   * should get
   */
  //CONSTRUCTOR
  public Automation(String name, Component triggerComp, boolean triggerStatus, Component responseComp, boolean responseStatus){
    this.name = name;
    this.triggerComp = triggerComp;
    this.triggerStatus = triggerStatus;
    this.responseComp = responseComp;
    this.responseStatus = responseStatus;
  }


  // METHODS
  public String getName(){
    return name;
  }
  public Component getTriggerComp(){
    return triggerComp;
  }
  public boolean getTriggerStatus(){
    return triggerStatus;
  }
  public Component getRespComp(){
    return responseComp;
  }
  public boolean getRespStatus(){
    return responseStatus;
  }

  /**
   * Responsible for changing the status of the <code>responseComp</code>,
   * triggering the right automations based on that status change and returning
   * a list of the triggered automations (including chain triggered automations).
   * Automations will only trigger if the status of the <code>responseComp</code>
   * was changed (e.g. when setting false to false nothing triggers)
   * @param automations the given list of automations from a HAManager instance
   * in which this method should look for other automations to trigger
   * @return a list of names of the triggered automations. If this automation
   * triggers other automations (by changing a status of a component), they in
   * turn will return a list of names to this Automation instance, which will
   * add them to its own return list of names.
   * The first triggered automation (called on by the HAManager) will therefore always
   * return all the names of all the triggered automations, including all
   * chain triggered automations.
   */
  public ArrayList<String> triggerAutomation(ArrayList<Automation> automations){
    ArrayList<String> allChainedAutos = new ArrayList<>();
    if (responseStatus != responseComp.getStatus()){ //only triggers if status changes
      responseComp.changeStatus(responseStatus); //change the status of responseComp

      ArrayList<String> chainedAutos = new ArrayList<>();
      allChainedAutos.add(this.name); // name of this automation is added to the ArrayList that will eventually be returned to the caller of this method

      //hulpmethode schrijven (findTriggeredAutos(responseComp, responseStatus){} die onderstaande doet.
      // find and trigger automations that are triggered by the status change of responseComp:
      for (Automation a : automations){ //loop through all automations
        if (a.getTriggerComp() == this.responseComp && a.getTriggerStatus() == this.responseStatus){ // if responseComp and status are in another automation as triggerComp and status
          chainedAutos = a.triggerAutomation(automations); // trigger that automation. chainedAutos now contains an ArrayList of Strings of all names of all chained automations
          for (String s : chainedAutos){ //loop through chainedAutos
            allChainedAutos.add(s);  //add all names from chainedAutos to allChainedAutos (chainedAutos will be re-initialised in every loop, losing the names. allChainedAutos will contain all names added each loop and keep it until the end of the method)
          }
        }
      }
    }
    return allChainedAutos; // automations triggered by this automation have returned all names of (by them) triggered automations. The first triggered automation (called on by a HAManager instance) now contains all names of all chained automations and returns it to the HAManager instance
  } //endmethod triggerAutomation

}
