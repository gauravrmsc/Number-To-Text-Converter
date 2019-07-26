package com.volvain;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.GridBagLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class Number_To_Text {

	private JFrame frame;
	private JTextField input;
	private double x;
	private String num;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Number_To_Text window = new Number_To_Text();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Number_To_Text() {
		initialize();
		frame.setResizable(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JTextArea output = new JTextArea();
		output.setWrapStyleWord(true);
		output.setLineWrap(true);
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Calibri", Font.PLAIN, 14));
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEnterNumber = new JLabel("Enter Number");
		lblEnterNumber.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblEnterNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterNumber.setBounds(10, 32, 423, 22);
		frame.getContentPane().add(lblEnterNumber);
		
		input = new JTextField();
		input.setBounds(112, 65, 231, 20);
		frame.getContentPane().add(input);
		input.setColumns(10);
		
		JButton btnConvert = new JButton("Convert");
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				output.setText(convert());
			}
		});
		btnConvert.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnConvert.setBounds(180, 105, 89, 23);
		frame.getContentPane().add(btnConvert);
		
		JLabel lblOutput = new JLabel("Output");
		lblOutput.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblOutput.setBounds(114, 147, 48, 22);
		frame.getContentPane().add(lblOutput);
		
		output.setBorder(BorderFactory.createLineBorder(Color.black));
		output.setBounds(124, 180, 219, 57);
		frame.getContentPane().add(output);
		frame.setBounds(100, 100, 449, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
	private final String str(int n){
		int a=(int) (x/n);
		String ak[]={"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve",
		"Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen",
		"Nineteen","Twenty" ,"Twenty-one","Twenty-Two","Twenty-Three","Twenty-Four","Twenty-Five","Twenty-Six" ,"Twenty-Seven ","Twenty-Eight","Twenty-Nine",
		"Thirty","Thirty-One","Thirty-Two","Thirty-Three","Thirty-Four","Thirty-Five","Thirty-Six","Thirty-Seven","Thirty-Eight","Thirty-Nine","Forty",
		"Forty-One","Forty-Two","Forty-Three","Forty-Four","Forty-Five","Forty-Six","Forty-Seven","Forty-Eight","Forty-Nine","Fifty",
		"Fifty-One","Fifty-Two","Fifty-Three","Fifty-Four","Fifty-Five","Fifty-Six","Fifty-Seven","Fifty-Eight","Fifty-Nine","Sixty","Sixty-One","Sixty-Two","Sixty-Three",
		"Sixty-Four","Sixty-Five","Sixty-Six","Sixty-Seven","Sixty-Eight","Sixty-Nine","Seventy","Seventy-One",
		"Seventy-Two","Seventy-Three","Seventy-Four","Seventy-Five","Seventy-Six","Seventy-Seven","Seventy-Eight","Seventy-Nine","Eighty","Eighty-One",
		"Eighty-Two","Eighty-Three","Eighty-Four","Eighty-Five","Eighty-Six","Eighty-Seven","Eighty-Eight","Eighty-Nine",
		"Ninety"," Ninety-One", "Ninety-Two"," Ninety-Three","Ninety-Four","Ninety-Five","Ninety-Six","Ninety-Seven","Ninety-Eight ","Ninety-Nine"};
		x=x%n;   if(x>=0&&a==0){return "";}
		
		else {
		return ak[a];}
		
	}
public String convert() {
	
	x=Double.parseDouble(input.getText());
	  //x=Double.parseDouble(dec.format(x));
	if (x>99000000000l){
		JOptionPane.showMessageDialog(frame,"Number too large");
		return "";
		}
	  num="";
	  String val;
	  if(x>=1000000000){val=str(1000000000);
	  if(val.equals("")){}
	  else{num+=val+" Arab ";}
	  
	  }
	  if(x<1000000000&&x>=10000000){val=str(10000000);
	  if(val.equals("")){}
	  else{num+=val+" Crore ";}
	                      }
	  
	  if(x<10000000&&x>=100000){
	  val=str(100000);
	  if(val.equals("")){}
	  else{num+=val+" Lakh ";}
	                           }
	  
	   if(x<100000&&x>=1000){
	  val=str(1000);
	  if(val.equals("")){}
	  else{num+=val+" Thousand ";}
	                           }
	   if(x<1000&&x>=100){
	  val=str(100);
	  if(val.equals("")){}
	  else{num+=val+" Hundred ";}
	                           }
	   if(x<100&&x>=1){
	  val=str(1);
	  if(val.equals("")){}
	  else{num+=val;}
	   }
	   if(!num.equals("")) num+=" Rupees";
	   if(x>0&&x<1){
	   x=(double)Math.round(x*100);
	   val=str(1);
	  if(val.equals("")){}
	  else{num+=" and "+val+" Pice ";}
	   }
	   return num;
}
}
