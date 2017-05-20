package lol;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class CalcForFun extends JFrame implements ActionListener{

	private String str;
	private int num1, num2;
	private String op;
	private double res, keepnum;
	private JTextField display;
	private JTextField displayres;
	private JButton[] button=new JButton[20];
	String[] buttonstr={"C", "(", ")", "BACK", "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "+", "=", "0", "KEEP", "-"};
	
	public CalcForFun(){
		super("calc");
		setLayout(new FlowLayout());
		display=new JTextField(30);
		display.setEditable(false);
		add(display);
		displayres=new JTextField(30);
		displayres.setEditable(false);
		add(displayres);
		for(int i=0; i<20; i++){
			button[i]=new JButton(buttonstr[i]);
			button[i].setPreferredSize(new Dimension(72, 72));
			button[i].addActionListener(this);
			add(button[i]);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==button[0]){ 	//C
			str="";
			keepnum=0;
		}
		if(e.getSource()==button[1]){	//(
			str+="(";
		}
		if(e.getSource()==button[2]){	//)
			str+=")";
		}
		if(e.getSource()==button[3]){	//back
			if(str.length()!=0){
				str=str.substring(0, str.length()-1);
			}
		}
		if(e.getSource()==button[4]){	//7
			str+="7";
		}
		if(e.getSource()==button[5]){	//8
			str+="8";
		}
		if(e.getSource()==button[6]){	//9
			str+="9";
		}
		if(e.getSource()==button[7]){	//"/"
			str+="/";
		}
		if(e.getSource()==button[8]){	//4
			str+="4";
		}
		if(e.getSource()==button[9]){	//5
			str+="5";
		}
		if(e.getSource()==button[10]){	//6
			str+="6";
		}
		if(e.getSource()==button[11]){	//*
			str+="*";
		}
		if(e.getSource()==button[12]){	//1
			str+="1";
		}
		if(e.getSource()==button[13]){	//2
			str+="2";
		} 
		if(e.getSource()==button[14]){	//3
			str+="3";
		}
		if(e.getSource()==button[15]){	//+
			str+="+";
		}
		if(e.getSource()==button[16]){	//=
			try {
				calcstep(str);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()==button[17]){	//0
			str+="0";
		}
		if(e.getSource()==button[18]){	//keep
			try {
				keepnum=calcstep(str);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			str="";
		}
		if(e.getSource()==button[19]){	//-
			str+="-";
		}
	}
	
	public double calcstep(String str) throws IOException{
		
		File file=new File("calc.java");
		BufferedWriter bw=new BufferedWriter(new FileWriter(file));
		bw.append("package lol;\n public class calc{\n public int fun{\n res="+str+ "return res;\n}\n}");
		calc f=new calc();
		double keepnum=res;
		return keepnum;
		
	}
	
	public static void main(){
		CalcForFun mycalc=new CalcForFun();
		mycalc.setSize(300, 200);
		mycalc.setVisible(true);
	}
}
