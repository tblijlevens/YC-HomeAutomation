package homeAutomationgui;

import java.awt.BorderLayout;
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
import javax.swing.JSlider;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HAMFrame extends JFrame {

	private HAManager homeControl = new HAManager();
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
	private JTextArea triggeredText;


	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public HAMFrame() {
		initialize();
		myInit();
	}

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

	}

			private JLabel getComponentsLabel() {
				if (componentsLabel == null) {
					componentsLabel = new JLabel("Components");
					componentsLabel.setBackground(Color.ORANGE);
					componentsLabel.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 18));
					componentsLabel.setBounds(49, 12, 211, 38);
					contentPane.add(componentsLabel);
				}
			return componentsLabel;
			}

			private JLabel getAutomationsLabel() {
				if (automationsLabel == null) {
					automationsLabel = new JLabel("Automations");
					automationsLabel.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 18));
					automationsLabel.setBounds(547, 12, 211, 38);
					contentPane.add(automationsLabel);
				}
			return automationsLabel;
			}
			private JToggleButton getWifiOnToggle() {
				if (wifiOnToggle == null) {
			wifiOnToggle = new JToggleButton("On");
			wifiOnToggle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					wifiOnToggleAction();
				}
			});
			wifiOnToggle.setFont(new Font("Dialog", Font.BOLD, 14));
			wifiOnToggle.setBounds(204, 62, 73, 25);
			contentPane.add(wifiOnToggle);
				}
			return wifiOnToggle;
			}
			private JToggleButton getWifiOffToggle() {
				if (wifiOffToggle == null) {
			wifiOffToggle = new JToggleButton("Off");
			wifiOffToggle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
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
			heatingOffToggle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
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
				}
			});
			heatingOnToggle.setFont(new Font("Dialog", Font.BOLD, 14));
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
			tableOffToggle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
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
				}
			});
			tableOnToggle.setFont(new Font("Dialog", Font.BOLD, 14));
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
			couchOffToggle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
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
				}
			});
			couchOnToggle.setFont(new Font("Dialog", Font.BOLD, 14));
			couchOnToggle.setBounds(204, 174, 73, 25);
			contentPane.add(couchOnToggle);
			}
		return couchOnToggle;
		}
			private JTextArea getAutomationsText() {
				if (automationsText == null) {
			automationsText = new JTextArea();
			automationsText.setBounds(452, 67, 360, 276);
			contentPane.add(automationsText);
				}
			return automationsText;
			}
			private JLabel getLblTriggeredAutomations() {
				if (lblTriggeredAutomations == null) {
			lblTriggeredAutomations = new JLabel("Triggered automations:");
			lblTriggeredAutomations.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 18));
			lblTriggeredAutomations.setBackground(Color.ORANGE);
			lblTriggeredAutomations.setBounds(49, 338, 253, 38);
			contentPane.add(lblTriggeredAutomations);
				}
			return lblTriggeredAutomations;
			}
			private JTextArea getTriggeredText() {
				if (triggeredText == null) {
			triggeredText = new JTextArea();
			triggeredText.setBounds(35, 388, 372, 206);
			contentPane.add(triggeredText);
				}
			return triggeredText;
		}

			//////////////////////////////
			///////// OWN CODE ///////////
			//////////////////////////////

			private void myInit(){
				// create 4 basic components and 3 automations
				homeControl.createNewComponent("WiFi");
				homeControl.createNewComponent("Heating");
				homeControl.createNewComponent("Table Light");
				homeControl.createNewComponent("Couch Light");
				homeControl.createNewAutomation("Wifi on >> Heating on", "Wifi", true, "Heating", true);
				homeControl.createNewAutomation("Wifi off >> Table off", "Wifi", false, "Table", false);
				homeControl.createNewAutomation("Table on >> Couch on", "Table Light", true, "Couch Light", true);

				// show all automations:
				String allAutomations = "";
				for (Automation a : homeControl.getAutomations()){
					allAutomations += a.getName() + "\n";
				}
				automationsText.setText(allAutomations);
			}


			//Event handler code

			private void updateAll(String compname){
				// the list with triggeredAutomations should be cleared and updated
				// all toggles should correspond to the new statuses of all components

				for (Component c : homeControl.getComponents()){
					if (c.getStatus()){
						if (compname.equals(c.getName()) && compname.equals("WiFi")){
							wifiOnToggle.setSelected(true);
							wifiOffToggle.setSelected(false);
						}
						else if (compname.equals(c.getName()) && compname.equals("Heating")){
							heatingOnToggle.setSelected(true);
							heatingOffToggle.setSelected(false);
						}
							//more else ifs for each component
					}
				}

			}
			private void wifiOnToggleAction(){
				// changeStatus of wifi
				homeControl.changeStatus("WiFi", true);

				updateAll("WiFi");

			}

}