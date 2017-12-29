package homeAutomationgui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import homeAutomation.Automation;
import homeAutomation.HAManager;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateAutoFrame extends JFrame {

	private JPanel contentPane;
	private JComboBox tCompComboBox;
	private static JTextField someText;
	private JButton saveButton;
	private HAManager homeControl;
	private HAMFrame hamFrame;
	private Automation newAuto;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAutoFrame frame = new CreateAutoFrame();
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
	public CreateAutoFrame() {
		initialize();
		myInit();
	}
	public CreateAutoFrame(HAManager homeControl, HAMFrame frame) {
		this.homeControl = homeControl;
		initialize();
		myInit();
	}

	private void initialize(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getTCompComboBox());
		contentPane.add(getSomeText());
		contentPane.add(getSaveButton());



	}

	private JTextField getSomeText(){
			if (someText == null){
				someText = new JTextField();
				someText.setText("Hija/1");
				someText.setBounds(139, 156, 114, 19);
				contentPane.add(someText);
				someText.setColumns(10);
			}
			return someText;
		}
	private JComboBox getTCompComboBox(){
		if (tCompComboBox == null){
			tCompComboBox = new JComboBox();
			tCompComboBox.setBounds(139, 89, 198, 24);
			contentPane.add(tCompComboBox);
		}
		return tCompComboBox;
	}
	private JButton getSaveButton(){
		if (saveButton == null){
			saveButton = new JButton("Save Automation");
			saveButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					saveButtonAction();
				}
			});
			saveButton.setBounds(234, 415, 238, 25);
			contentPane.add(saveButton);
	}
		return saveButton;
	}

//////////////////////////////
///////// OWN CODE ///////////
//////////////////////////////
private void myInit(){
	// create 4 basic components and 3 automations


}
	public static String getFieldText(){
		return someText.getText();
	}
	private void saveButtonAction(){
		homeControl.createNewAutomation("Couch off >> Wifi off", "Couch Light", false, "WiFi", false);
		//hamFrame.triggeredText.setText(hamFrame.getAllAutomations());
		CreateAutoFrame.this.dispose();
	}
}