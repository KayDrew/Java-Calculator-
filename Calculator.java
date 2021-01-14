import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Calculator implements ActionListener{
	
	static JFrame f;
	static JPanel pt;
	static JPanel pb;
	static JTextArea t;
	static JToggleButton tb;

	int count=0;
	
	static String arg0, arg1,arg2;
	

	static char[] operands= {'3','.','4','5','6','=','7','8','9','0'};
	
	static String[] operators= {"+","-","*","/","√","²","C","1","2"};
	

	
	static JButton [] ops= new JButton[operators.length];

	static JButton [] opas= new JButton[operands.length];
	

	public Calculator() {
		
		init();
		
		arg0=arg1=arg2="";
		
		
	}
	

	//action listener for on/off button
	
	class Action implements ActionListener{

		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			++count;
			
			//button is on
			if(count%2==1) {
				
				pt.setBackground(Color.white);
				
			for(int i=0;i<ops.length;++i) {
				
			ops[i].setEnabled(true);
			
			
			}
			
			for(int i=0;i<opas.length;++i) {
				
				opas[i].setEnabled(true);
				
				
				
				}	
		
			
		}
			//button is off
			else {
				
			
				for(int i=0;i<ops.length;++i) {
					
				ops[i].setEnabled(false);
				
				
				
				}
				
				for(int i=0;i<opas.length;++i) {
					
					opas[i].setEnabled(false);
					
					
					}	
				
				arg0=arg1=arg2="";
				t.setText("");
			}
		
		}
	}
		
	//the initializing method
	
	
	public void init() {
		
		//initialize and customize frame
		
		f=new JFrame("Calculator");
		f.setSize(400, 500);
		f.setLayout(new GridLayout(2,1));
		f.setResizable(false);
		

		//initialize and customize panel
		pt=new JPanel();
		
		
		
		pb=new JPanel();
		pb.setBackground(Color.black);
		pb.setLayout(new GridLayout(5,5));
	
	

		//initialize and customize textfield
		t=new JTextArea();
		t.setEditable(false);
		t.setFont(t.getFont().deriveFont(18f));
		
		//add text field to panel
		pt.add(t);
		
		
		tb=new JToggleButton("on/off");
		tb.addActionListener(new Action());
		tb.setBackground(Color.white);
		pb.add(tb);
		
		
		//set system look and feel
		
		try {
UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		
			
		
		//create and add operator buttons to panel 
		for(int i=0;i<ops.length;++i) {
			
		ops[i]=new JButton(operators[i]+"");
		
		//set action command
		ops[i].setActionCommand(operators[i]+"");
		
		
		//add action listener except on on/off button
		
		if(!(ops[i]==ops[3])) {
			ops[i].setEnabled(false);
		ops[i].addActionListener(this);
		}
		pb.add(ops[i]);

	
			
		}
			//add action listener on on/off button
		ops[3].addActionListener(new Action());
		
		
		

		//create and add operands buttons to panel
		for(int i=0;i<opas.length;++i) {
			
			opas[i]=new JButton(operands[i]+"");
			//set action command
			opas[i].setActionCommand(operands[i]+"");
			//add action listener
			opas[i].addActionListener(this);
			opas[i].setEnabled(false);
			
			pb.add(opas[i]);
				
			}
		
		//add panel to frame and display frame
		f.add(pt);
		f.add(pb);
		f.setVisible(true);
		
	}
	public static void main(String[] args) {
	
		new Calculator();
		
	
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
String arg=	e.getActionCommand();
		

if((Character.isDigit(arg.charAt(0))|| arg.charAt(0)=='.')) {
	
	if(!arg1.equals("")) 
		
	{	arg2+=arg;
	}
	
	else 
	{
		arg0+=arg;
	}
	//display on screen
	
	t.setText(arg0+arg1+arg2);
	
}

//clear button is clicked, clear everything
else if((arg.charAt(0)=='C')) {
	arg0=arg1=arg2="";
	t.setText(arg0+arg1+arg2);
	
}

//equals button is clicked,perform calculations

else if((arg.charAt(0)=='=')) {
	
	
	double res=0;
	
	switch(arg1) {
	
	case "+":
		
		res= Double.parseDouble(arg0)+Double.parseDouble(arg2);
		break;
		
	case "-":
		res= Double.parseDouble(arg0)-Double.parseDouble(arg2);
		break;
		
	case "/":
		res= Double.parseDouble(arg0)/Double.parseDouble(arg2);
		break;
		
	case "*":
		res= Double.parseDouble(arg0)*Double.parseDouble(arg2);
		break;
		
		
	case "²":
		res= Math.pow(2,Double.parseDouble(arg2));
		
		
		break;
		
	case "√":
		res= Math.sqrt(Double.parseDouble(arg2));
		break;
		
	case "":
		res= Double.parseDouble(arg0);
		break;
	
	}
	

	t.setText(arg0+arg1+arg2+"="+res);

	
	arg0=Double.toString(res);
	
	arg1=arg2="";
	
	
	
	
}

else {
	
	//if there are no operands
	
	if(arg1.equals("")|| arg2.equals("")) {
		
		arg1=arg;
	}
	
	//else evaluate
	else {
		
		double res = 0;
		
		//store the value in first
		switch(arg1) {
		
		case "+":
			
			res= Double.parseDouble(arg0)+Double.parseDouble(arg2);
			break;
			
		case "-":
			res= Double.parseDouble(arg0)-Double.parseDouble(arg2);
			break;
			
		case "/":
			res= Double.parseDouble(arg0)/Double.parseDouble(arg2);
			break;
			
		case "*":
			res= Double.parseDouble(arg0)*Double.parseDouble(arg2);
			break;
			
			
		case "²":
			res= Math.pow(2,Double.parseDouble(arg2));
		
			break;
			
		case "√":
			res= Math.sqrt(Double.parseDouble(arg2));
			break;
			
		case "":
			res= Double.parseDouble(arg0);
			break;
		
		}
		
		//convert to string
		arg0=Double.toString(res);
		
		//include the operator
		arg1=arg;
		
		//reset operand
		arg2="";
		
		
	}
	
}
//display expression and answer
	t.setText(arg0+arg1+arg2);
	
	}

}
