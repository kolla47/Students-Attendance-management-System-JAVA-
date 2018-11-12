
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.io.*;
import java.util.*;


@SuppressWarnings("unused")
public class Entryportal extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7522526792628754248L;
	public Entryportal() {
        initComponents();
    }
    @SuppressWarnings({ "rawtypes", "unchecked" })
	private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        jLabel2 = new javax.swing.JLabel();
        jLabel2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        jLabel3 = new javax.swing.JLabel();
        jLabel3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        userid = new javax.swing.JTextField();
        mode = new javax.swing.JComboBox();
        loginb = new javax.swing.JButton();
        cancelb = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Information");
        setName("Entryportal");

        jLabel1.setText("Username");

        jLabel2.setText("Password");

        jLabel3.setText("User Type");

        mode.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrator", "Teacher" }));

        loginb.setText("Login");
        loginb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cancelb.setText("Cancel");
        cancelb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("ATTENDANCE MANAGEMENT SYSTEM");
        
        pwd = new JTextField();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(87)
        					.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 324, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(layout.createSequentialGroup()
        							.addGap(68)
        							.addGroup(layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(jLabel2)
        								.addGroup(layout.createSequentialGroup()
        									.addPreferredGap(ComponentPlacement.RELATED)
        									.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
        								.addComponent(jLabel1)))
        						.addGroup(layout.createSequentialGroup()
        							.addGap(76)
        							.addComponent(loginb, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)))
        					.addGap(79)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(cancelb, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
        						.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        							.addComponent(mode, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
        							.addComponent(userid, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
        							.addComponent(pwd, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))))
        			.addContainerGap(89, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
        			.addGap(44)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel1)
        				.addComponent(userid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(36)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel2)
        				.addComponent(pwd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(31)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel3)
        				.addComponent(mode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(58)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(cancelb, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(loginb, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
        			.addGap(56))
        );
        getContentPane().setLayout(layout);

        pack();
    }
    
    @SuppressWarnings("resource")
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    	try {
    		String username = userid.getText();
        	String password = pwd.getText();
        	String file = "src\\users.txt";
            BufferedReader br=new BufferedReader(new FileReader(file));
        	String line, user, pass;
            boolean isLoginSuccess = false;
            while ((line = br.readLine()) != null) {
                user = line.split(",")[0];
                pass = line.split(",")[1];
                if (user.equals(username) && pass.equals(password)) {
                    isLoginSuccess = true;
                }
            }
            if (isLoginSuccess) {
                JOptionPane.showMessageDialog(null, "Succesfully logged in");
                
                if( mode.getSelectedItem()=="Administrator")
                {
                admin f2 = new admin(userid.getText());
                f2.setVisible(true);
                dispose();
                }
                else
                if( mode.getSelectedItem()=="Teacher")
                {
                Teacher1 f2 = new Teacher1(userid.getText());
                f2.setVisible(true);
                dispose();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or paswword");
            }
        } catch (Exception e) {
            System.out.println("Somethig is wrong");
            JOptionPane.showMessageDialog(null, e);

        }  
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(1);
    }

    public static void main(String args[]) {
        
    	new Entryportal().setVisible(true);
    	
    }
    private javax.swing.JTextField userid;
    @SuppressWarnings("rawtypes")
	private javax.swing.JComboBox mode;
    private javax.swing.JButton loginb;
    private javax.swing.JButton cancelb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private JTextField pwd;
}
