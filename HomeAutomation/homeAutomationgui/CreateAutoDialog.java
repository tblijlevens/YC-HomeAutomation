package homeAutomationgui;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import homeAutomation.HAManager;

import java.awt.event.ActionListener;
import java.awt.Window;
import java.awt.event.ActionEvent;

public class CreateAutoDialog extends JPanel {
   private JTextField field = new JTextField(10);
   private JButton okButton = new JButton("OK");
   private HAManager homeControl;

   public CreateAutoDialog() {
		initialize();

   }
   public CreateAutoDialog(HAManager homeControl) {
		this.homeControl = homeControl;
		initialize();
	}


   private void initialize() {
	      this.add(field);
	      okButton.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent arg0) {
	            okButtonAction();
	      	}
	      });
	      this.add(okButton);
   }
   // to allow outside classes to get the text held by the JTextField
   public String getFieldText() {
      return field.getText();
   }

   // This button's action is simply to dispose of the JDialog.
   private void okButtonAction() {
      // win is here the JDialog that holds this JPanel, but it could be a JFrame or
      // any other top-level container that is holding this JPanel
			homeControl.createNewAutomation("Couch off >> Wifi off", "Couch Light", false, "WiFi", false);
      Window win = SwingUtilities.getWindowAncestor(this);
      if (win != null) {
         win.dispose();
      }
   }
}