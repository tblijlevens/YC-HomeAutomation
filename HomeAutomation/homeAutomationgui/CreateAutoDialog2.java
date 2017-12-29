package homeAutomationgui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import homeAutomation.Component;
import homeAutomation.HAManager;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public class CreateAutoDialog2 extends JDialog {

	private HAManager homeControl;
	private final JPanel contentPanel = new JPanel();
	private JComboBox tCompComboBox;
	private JComboBox rCompComboBox;
	private JComboBox tOnOffComboBox;
	private JComboBox rOnOffComboBox;
	private JTextField autoNameText;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CreateAutoDialog2 dialog = new CreateAutoDialog2();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CreateAutoDialog2() {
		initialize();
		myInit();
	}
	public CreateAutoDialog2(HAManager homeControl) {
		this.homeControl = homeControl;
		initialize();
		myInit();
	}

	private void initialize() {
		setBounds(100, 100, 850, 650);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getTCompComboBox());
		contentPanel.add(getRCompComboBox());
		contentPanel.add(getTOnOffComboBox());
		contentPanel.add(getROnOffComboBox());



		JLabel lblWhen = new JLabel("When");
		lblWhen.setBounds(52, 56, 70, 15);
		contentPanel.add(lblWhen);

		JLabel lblTurns = new JLabel("turns");
		lblTurns.setBounds(334, 58, 70, 15);
		contentPanel.add(lblTurns);

		JLabel lblShould = new JLabel("should turn");
		lblShould.setBounds(334, 102, 125, 15);
		contentPanel.add(lblShould);

		JLabel lblThen_1 = new JLabel("then");
		lblThen_1.setBounds(52, 100, 70, 15);
		contentPanel.add(lblThen_1);
		{
			JLabel autoNameLabel = new JLabel("Automation Name:");
			autoNameLabel.setBounds(52, 165, 153, 15);
			contentPanel.add(autoNameLabel);
		}
		{
			autoNameText = new JTextField();
			autoNameText.setBounds(223, 163, 365, 30);
			contentPanel.add(autoNameText);
			autoNameText.setColumns(10);
		}

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						okButtonAction();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						cancelButtonAction();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	private JComboBox getTCompComboBox(){
		if (tCompComboBox == null){
			tCompComboBox = new JComboBox();
			tCompComboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					choiceMade();
				}
			});
			tCompComboBox.setBounds(107, 51, 197, 25);
			contentPanel.add(tCompComboBox);
		}
		return tCompComboBox;
	}

	private JComboBox getRCompComboBox(){
		if (rCompComboBox == null){
			rCompComboBox = new JComboBox();
			rCompComboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					choiceMade();
				}
			});
			rCompComboBox.setBounds(107, 95, 197, 25);
			contentPanel.add(rCompComboBox);
		}
		return rCompComboBox;
	}
private JComboBox getTOnOffComboBox(){
	if (tOnOffComboBox == null){
		tOnOffComboBox = new JComboBox();
		tOnOffComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choiceMade();
			}
		});
		tOnOffComboBox.setBounds(444, 51, 144, 25);
		contentPanel.add(tOnOffComboBox);
	}
	return tOnOffComboBox;
}
private JComboBox getROnOffComboBox(){
	if (rOnOffComboBox == null){
		rOnOffComboBox = new JComboBox();
		rOnOffComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choiceMade();
			}
		});
		rOnOffComboBox.setBounds(444, 97, 144, 25);
		contentPanel.add(rOnOffComboBox);
	}
	return rOnOffComboBox;
}

	//////////////////////////////
	///////// OWN CODE ///////////
	//////////////////////////////

	private void myInit(){
		tOnOffComboBox.addItem("-on/off-");
		tOnOffComboBox.addItem("On");
		tOnOffComboBox.addItem("Off");
		rOnOffComboBox.addItem("-on/off-");
		rOnOffComboBox.addItem("On");
		rOnOffComboBox.addItem("Off");

		tCompComboBox.addItem("-choose a device-");
		rCompComboBox.addItem("-choose a device-");

		for (Component c : homeControl.getComponents()){
			tCompComboBox.addItem(c.getName());
			rCompComboBox.addItem(c.getName());
		}
	}

	private void choiceMade(){
		String tComp = "" + tCompComboBox.getSelectedItem();
		String tStat = "" + tOnOffComboBox.getSelectedItem();
		String rComp = "" + rCompComboBox.getSelectedItem();
		String rStat = "" + rOnOffComboBox.getSelectedItem();

		if (!tComp.equals("-choose a device-") && !rComp.equals("choose a device") && !tStat.equals("-on/off-") && !rStat.equals("-on/off-")){
			autoNameText.setText(tComp + " " + tStat + " >> " + rComp + " " + rStat);
		}
	}

	private void okButtonAction(){
		String tComp = "" + tCompComboBox.getSelectedItem();
		String tStatString = "" + tOnOffComboBox.getSelectedItem();
		String rComp = "" + rCompComboBox.getSelectedItem();
		String rStatString = "" + rOnOffComboBox.getSelectedItem();
		String name = autoNameText.getText();

		//only continue if everything is filled in
		if (!tComp.equals("-choose a device-") && !rComp.equals("choose a device") && !tStatString.equals("-on/off-") && !rStatString.equals("-on/off-") && !name.equals("")){
			boolean tStat = false;
			boolean rStat = false;

			if ("On".equals(tStatString)){
				tStat = true;
			}
			else if ("Off".equals(tStatString)){
				tStat = false;
			}
			if ("On".equals(rStatString)){
				rStat = true;
			}
			else if ("Off".equals(rStatString)){
				rStat = false;
			}

			//create new automation with given arguments
			homeControl.createNewAutomation(name, tComp, tStat, rComp, rStat);
			new HAMFrame(homeControl).setVisible(true);
			CreateAutoDialog2.this.dispose();
		}
	}
	private void cancelButtonAction(){
		new HAMFrame(homeControl).setVisible(true);
		CreateAutoDialog2.this.dispose();
	}
}
