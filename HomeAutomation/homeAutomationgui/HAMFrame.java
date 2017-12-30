package homeAutomationgui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import homeAutomation.Automation;
import homeAutomation.Component;
import homeAutomation.HAManager;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JToggleButton;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;

/*
class responsible for showing a user interface in which the user can change component
statuses, get feedback on which automations were triggered and create new automations
*/
public class HAMFrame extends JFrame {

	private HAManager homeControl;
	private JPanel contentPane;
	private JLabel componentsLabel;
	private JLabel automationsLabel;
	private JToggleButton wifiOnToggle;
	private JToggleButton wifiOffToggle;
	private JTextArea wifiText;
	private JTextArea heatingText;
	private JToggleButton heatingOffToggle;
	private JToggleButton heatingOnToggle;
	private JTextArea tableText;
	private JToggleButton tableOffToggle;
	private JToggleButton tableOnToggle;
	private JTextArea couchText;
	private JToggleButton couchOffToggle;
	private JToggleButton couchOnToggle;
	private JTextArea automationsText;
	private JLabel lblTriggeredAutomations;
	public JTextArea triggeredText;
	private JButton createAutoButton;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HAMFrame frame = new HAMFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

// two constructors
	public HAMFrame() {
		homeControl = new HAManager();
		initialize();
		myInit();
	}
	public HAMFrame(HAManager homeControl) {
		this.homeControl = homeControl;
		initialize();
		myInit();
	}

	/*
	responsible for filling the user interface with initial graphical elements
	*/
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getComponentsLabel());
		contentPane.add(getAutomationsLabel());
		contentPane.add(getWifiOnToggle());
		contentPane.add(getWifiOffToggle());
		contentPane.add(getWifiText());
		contentPane.add(getHeatingText());
		contentPane.add(getHeatingOffToggle());
		contentPane.add(getHeatingOnToggle());
		contentPane.add(getTableText());
		contentPane.add(getTableOffToggle());
		contentPane.add(getTableOnToggle());
		contentPane.add(getCouchText());
		contentPane.add(getCouchOffToggle());
		contentPane.add(getCouchOnToggle());
		contentPane.add(getAutomationsText());
		contentPane.add(getLblTriggeredAutomations());
		contentPane.add(getTriggeredText());
		contentPane.add(getCreateAutoButton());

		JButton btnTestbutton = new JButton("Testbutton");
		btnTestbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				testButtonAction();
			}
		});
		btnTestbutton.setBounds(143, 320, 117, 25);
		contentPane.add(btnTestbutton);
	}

	// methods giving the graphical elements its properties and behaviour

			private JLabel getComponentsLabel() {
				if (componentsLabel == null) {
					componentsLabel = new JLabel("Devices");
					componentsLabel.setBackground(Color.ORANGE);
					componentsLabel.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 18));
					componentsLabel.setBounds(35, 12, 242, 38);
					contentPane.add(componentsLabel);
				}
			return componentsLabel;
			}

			private JToggleButton getWifiOnToggle() {
				if (wifiOnToggle == null) {
			wifiOnToggle = new JToggleButton("On");
			wifiOnToggle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					onToggleAction("WiFi");
				}
			});
			wifiOnToggle.setFont(new Font("Dialog", Font.PLAIN, 14));
			wifiOnToggle.setBounds(204, 62, 73, 25);
			contentPane.add(wifiOnToggle);
				}
			return wifiOnToggle;
			}

			private JToggleButton getWifiOffToggle() {
				if (wifiOffToggle == null) {
			wifiOffToggle = new JToggleButton("Off");
			wifiOffToggle.setEnabled(false);
			wifiOffToggle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					offToggleAction("WiFi");
				}
			});
			wifiOffToggle.setFont(new Font("Dialog", Font.PLAIN, 12));
			wifiOffToggle.setSelected(true);
			wifiOffToggle.setBounds(136, 62, 73, 25);
			contentPane.add(wifiOffToggle);
				}
			return wifiOffToggle;
			}

			private JTextArea getWifiText() {
				if (wifiText == null) {
			wifiText = new JTextArea();
			wifiText.setEditable(false);
			wifiText.setFont(new Font("Dialog", Font.PLAIN, 16));
			wifiText.setText("WiFi");
			wifiText.setBounds(35, 62, 90, 25);
			contentPane.add(wifiText);
				}
			return wifiText;
			}

			private JTextArea getHeatingText() {
				if (heatingText == null) {
			heatingText = new JTextArea();
			heatingText.setText("Heating");
			heatingText.setFont(new Font("Dialog", Font.PLAIN, 16));
			heatingText.setEditable(false);
			heatingText.setBounds(35, 99, 90, 25);
			contentPane.add(heatingText);
				}
			return heatingText;
			}

			private JToggleButton getHeatingOffToggle() {
				if (heatingOffToggle == null) {
			heatingOffToggle = new JToggleButton("Off");
			heatingOffToggle.setEnabled(false);
			heatingOffToggle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					offToggleAction("Heating");
				}
			});
			heatingOffToggle.setSelected(true);
			heatingOffToggle.setFont(new Font("Dialog", Font.PLAIN, 12));
			heatingOffToggle.setBounds(136, 99, 73, 25);
			contentPane.add(heatingOffToggle);
				}
			return heatingOffToggle;
			}

			private JToggleButton getHeatingOnToggle() {
				if (heatingOnToggle == null) {
			heatingOnToggle = new JToggleButton("On");
			heatingOnToggle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					onToggleAction("Heating");
				}
			});
			heatingOnToggle.setFont(new Font("Dialog", Font.PLAIN, 14));
			heatingOnToggle.setBounds(204, 99, 73, 25);
			contentPane.add(heatingOnToggle);
				}
			return heatingOnToggle;
			}

			private JTextArea getTableText() {
				if (tableText == null) {
			tableText = new JTextArea();
			tableText.setText("Table light");
			tableText.setFont(new Font("Dialog", Font.PLAIN, 16));
			tableText.setEditable(false);
			tableText.setBounds(35, 137, 90, 25);
			contentPane.add(tableText);
				}
			return tableText;
			}

			private JToggleButton getTableOffToggle() {
				if (tableOffToggle == null) {
			tableOffToggle = new JToggleButton("Off");
			tableOffToggle.setEnabled(false);
			tableOffToggle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					offToggleAction("Table Light");
				}
			});
			tableOffToggle.setSelected(true);
			tableOffToggle.setFont(new Font("Dialog", Font.PLAIN, 12));
			tableOffToggle.setBounds(136, 137, 73, 25);
			contentPane.add(tableOffToggle);
				}
			return tableOffToggle;
			}

			private JToggleButton getTableOnToggle() {
				if (tableOnToggle == null) {
			tableOnToggle = new JToggleButton("On");
			tableOnToggle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					onToggleAction("Table Light");
				}
			});
			tableOnToggle.setFont(new Font("Dialog", Font.PLAIN, 14));
			tableOnToggle.setBounds(204, 137, 73, 25);
			contentPane.add(tableOnToggle);
				}
			return tableOnToggle;
			}

			private JTextArea getCouchText() {
				if (couchText == null) {
			couchText = new JTextArea();
			couchText.setText("Couch light");
			couchText.setFont(new Font("Dialog", Font.PLAIN, 16));
			couchText.setEditable(false);
			couchText.setBounds(35, 174, 90, 25);
			contentPane.add(couchText);
				}
			return couchText;
			}

			private JToggleButton getCouchOffToggle() {
				if (couchOffToggle == null) {
			couchOffToggle = new JToggleButton("Off");
			couchOffToggle.setEnabled(false);
			couchOffToggle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					offToggleAction("Couch Light");
				}
			});
			couchOffToggle.setSelected(true);
			couchOffToggle.setFont(new Font("Dialog", Font.PLAIN, 12));
			couchOffToggle.setBounds(136, 174, 73, 25);
			contentPane.add(couchOffToggle);
				}

			return couchOffToggle;
			}
			private JToggleButton getCouchOnToggle() {
				if (couchOnToggle == null) {
					couchOnToggle = new JToggleButton("On");
					couchOnToggle.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							onToggleAction("Couch Light");
						}
					});
				couchOnToggle.setFont(new Font("Dialog", Font.PLAIN, 14));
				couchOnToggle.setBounds(204, 174, 73, 25);
				contentPane.add(couchOnToggle);
				}
				return couchOnToggle;
			}

			private JLabel getAutomationsLabel() {
				if (automationsLabel == null) {
					automationsLabel = new JLabel("Available automations");
					automationsLabel.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 18));
					automationsLabel.setBounds(452, 12, 360, 38);
					contentPane.add(automationsLabel);
				}
			return automationsLabel;
			}

			private JTextArea getAutomationsText() {
				if (automationsText == null) {
			automationsText = new JTextArea();
			automationsText.setEditable(false);
			automationsText.setBounds(452, 43, 360, 206);
			automationsText.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			contentPane.add(automationsText);
				}
			return automationsText;
			}

			private JButton getCreateAutoButton(){
				if (createAutoButton == null) {
					createAutoButton = new JButton("+ Create new automation");
					createAutoButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							createAutoButtonAction();
						}
					});
					createAutoButton.setBounds(452, 257, 360, 38);
					contentPane.add(createAutoButton);
				}
				return createAutoButton;
			}

			private JLabel getLblTriggeredAutomations() {
				if (lblTriggeredAutomations == null) {
			lblTriggeredAutomations = new JLabel("Triggered automations:");
			lblTriggeredAutomations.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 18));
			lblTriggeredAutomations.setBackground(Color.ORANGE);
			lblTriggeredAutomations.setBounds(452, 355, 372, 38);
			contentPane.add(lblTriggeredAutomations);
				}
			return lblTriggeredAutomations;
			}

			private JTextArea getTriggeredText() {
				if (triggeredText == null) {
			triggeredText = new JTextArea();
			triggeredText.setEditable(false);
			triggeredText.setBounds(452, 386, 360, 206);
			triggeredText.setBorder(BorderFactory.createLineBorder(Color.BLACK));

			contentPane.add(triggeredText);
				}
			return triggeredText;
		}

			//////////////////////////////
			///////// OWN CODE ///////////
			//////////////////////////////

			/*
			initializes the HAManager instance (homeControl) with a startset of	4
			components and 2 automations. Shows the automations in the correct textarea.
			*/
			private void myInit(){
				homeControl.createNewComponent("WiFi");
				homeControl.createNewComponent("Heating");
				homeControl.createNewComponent("Table Light");
				homeControl.createNewComponent("Couch Light");
				homeControl.createNewAutomation("WiFi On >> Heating On", "WiFi", true, "Heating", true);
				homeControl.createNewAutomation("Table Light On >> Couch Light On", "Table Light", true, "Couch Light", true);

				// show all available automations:
				automationsText.setText(getAllAutomations());
				updateAll(""); // sets all toggles in the correct position corresponding the statuses of the components
			}


			// HELP METHODS

			/*
			finds all existing automations and returns a String with all of their names
			*/
			private String getAllAutomations(){
				String allAutomations = "";
				for (Automation a : homeControl.getAutomations()){
					allAutomations += a.getName() + "\n";
				}
				return allAutomations;
			}

			//EVENT HANDLERS

			/*
			loop through all components. search by their names and check their statuses.
			Update all toggles accordingly plus set background colors for extra clear user feedback.
			*/
			private void updateAll(String triggeredAutomations){
				for (Component c : homeControl.getComponents()){
						if ("WiFi".equals(c.getName()) && c.getStatus()){
							wifiOnToggle.setSelected(true);
							wifiOnToggle.setEnabled(false);
							wifiOffToggle.setSelected(false);
							wifiOffToggle.setEnabled(true);
							wifiText.setBackground(Color.GREEN);

						}
						else if ("WiFi".equals(c.getName()) && !c.getStatus()){
							wifiOnToggle.setSelected(false);
							wifiOnToggle.setEnabled(true);
							wifiOffToggle.setSelected(true);
							wifiOffToggle.setEnabled(false);
							wifiText.setBackground(Color.WHITE);

						}
						else if ("Heating".equals(c.getName()) && c.getStatus()){
							heatingOnToggle.setSelected(true);
							heatingOnToggle.setEnabled(false);
							heatingOffToggle.setSelected(false);
							heatingOffToggle.setEnabled(true);
							heatingText.setBackground(Color.GREEN);
						}
						else if ("Heating".equals(c.getName()) && !c.getStatus()){
							heatingOnToggle.setSelected(false);
							heatingOnToggle.setEnabled(true);
							heatingOffToggle.setSelected(true);
							heatingOffToggle.setEnabled(false);
							heatingText.setBackground(Color.WHITE);
						}
						else if ("Table Light".equals(c.getName()) && c.getStatus()){
							tableOnToggle.setSelected(true);
							tableOnToggle.setEnabled(false);
							tableOffToggle.setSelected(false);
							tableOffToggle.setEnabled(true);
							tableText.setBackground(Color.GREEN);
						}
						else if ("Table Light".equals(c.getName()) && !c.getStatus()){
							tableOnToggle.setSelected(false);
							tableOnToggle.setEnabled(true);
							tableOffToggle.setSelected(true);
							tableOffToggle.setEnabled(false);
							tableText.setBackground(Color.WHITE);
						}
						else if ("Couch Light".equals(c.getName()) && c.getStatus()){
							couchOnToggle.setSelected(true);
							couchOnToggle.setEnabled(false);
							couchOffToggle.setSelected(false);
							couchOffToggle.setEnabled(true);
							couchText.setBackground(Color.GREEN);
						}
						else if ("Couch Light".equals(c.getName()) && !c.getStatus()){
							couchOnToggle.setSelected(false);
							couchOnToggle.setEnabled(true);
							couchOffToggle.setSelected(true);
							couchOffToggle.setEnabled(false);
							couchText.setBackground(Color.WHITE);
						}
				}
				triggeredText.setText(triggeredAutomations);
			}

			/*
			on toggle click: changes the status of the corresponding component.
			The status change could trigger automations causing more components
			to change status.
			*/
			private void onToggleAction(String name){
				String allTriggered = homeControl.changeStatus(name, true);
				updateAll(allTriggered); // updates the gui by setting the toggles in the correct positions and showing all triggered automation names.
			}
			private void offToggleAction(String name){
				String allTriggered = homeControl.changeStatus(name, false);
				updateAll(allTriggered);
			}

			/*
			on button click: shows a dialog in which the user can create a new automation
			*/
			private void createAutoButtonAction(){
			    new CreateAutoDialog2(homeControl).setVisible(true);
			   	HAMFrame.this.dispose();
			}

			/*
			on button click: prints out information to console for testing puposes.
			Currently shows all existing automations with their trigger and response
			components and all existing components with their statuses.
			*/
			private void testButtonAction(){
				for (Automation a : homeControl.getAutomations()){
					System.out.println(a.getName());
					System.out.println("t: " + a.getTriggerComp().getName());
					System.out.println("r: " + a.getRespComp().getName());
				}
				System.out.println();
				for (Component c : homeControl.getComponents()){
					System.out.println(c.getName() + ": " + c.getStatus());
				}
			}

}
