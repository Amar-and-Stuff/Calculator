
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class CalcMain {

	public static boolean isDigit(char c) {
		try {
			Integer.parseInt(String.valueOf(c));
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	public static String calc(String exp) {
		try {
		int len = exp.length();
		ArrayList<String> nums = new ArrayList<String>();
		ArrayList<Character> ops = new ArrayList<Character>();
		String s = "";
		//process of seperation
		for(int i = 0;i<len;i++) {
			char c = exp.charAt(i);
			if(isDigit(c)||c=='.') {
				s+=c;
			}
			else if(c=='-'&&s.length()==0) {
				s+='-';
			}
			else if(c=='+'&&s.length()==0) {}//do nothing

			else {
				if(c=='-') { nums.add(s);ops.add('+');s="-";}
				else {nums.add(s);ops.add(c);s="";}
			}
		}
		nums.add(s);
		
		if(nums.size()!=ops.size()+1)return "INVALID EXPRESSION";
		
		//process of calculation
		while(ops.indexOf('^')!=-1) {
			int ind = ops.indexOf('^');
			String a = nums.remove(ind);
			String b = nums.remove(ind);ops.remove(ind);
			if(a.contains(".")&&b.contains(".")) {
				float x = Float.parseFloat(a);
				float y = Float.parseFloat(b);
				nums.add(String.format("%.6f",Math.pow(x, y)));
			}
			else if(a.contains(".")) {
				float x = Float.parseFloat(a);
				int y = Integer.parseInt(b);
				nums.add(String.format("%.6f",Math.pow(x, y)));
			}
			else if(b.contains(".")) {
				int x = Integer.parseInt(a);
				float y = Float.parseFloat(b);
				nums.add(String.format("%.6f",Math.pow(x, y)));
			}
			else {
				int x = Integer.parseInt(a);
				int y = Integer.parseInt(b);
				nums.add(String.valueOf((int)Math.pow(x, y)));
			}
			
		}
		
		
		while(ops.indexOf('/')!=-1) {
			int ind = ops.indexOf('/');
			String a = nums.remove(ind);
			String b = nums.remove(ind);ops.remove(ind);
			float x = Float.parseFloat(a);
			float y = Float.parseFloat(b);
			
			try {
				Float.parseFloat(String.valueOf(x/y)+"0");
				nums.add(String.format("%.6f",x/y));
			}
			catch(Exception e) {
				return "ZERO DIV";
			}			
		}
		while(ops.indexOf('*')!=-1) {
			int ind = ops.indexOf('*');
			String a = nums.remove(ind);
			String b = nums.remove(ind);ops.remove(ind);
			if(a.contains(".")&&b.contains(".")) {
				float x = Float.parseFloat(a);
				float y = Float.parseFloat(b);
				nums.add(String.format("%.6f",x*y));
			}
			else if(a.contains(".")) {
				float x = Float.parseFloat(a);
				int y = Integer.parseInt(b);
				nums.add(String.format("%.6f",x*y));
			}
			else if(b.contains(".")) {
				int x = Integer.parseInt(a);
				float y = Float.parseFloat(b);
				nums.add(String.format("%.6f",x*y));
			}
			else {
				int x = Integer.parseInt(a);
				int y = Integer.parseInt(b);
				nums.add(String.valueOf(x*y));
			}
			
		}
		while(ops.indexOf('+')!=-1) {
			int ind = ops.indexOf('+');
			String a = nums.remove(ind);
			String b = nums.remove(ind);ops.remove(ind);
			if(a.contains(".")&&b.contains(".")) {
				float x = Float.parseFloat(a);
				float y = Float.parseFloat(b);
				nums.add(String.format("%.6f",x+y));
			}
			else if(a.contains(".")) {
				float x = Float.parseFloat(a);
				int y = Integer.parseInt(b);
				nums.add(String.format("%.6f",x+y));
			}
			else if(b.contains(".")) {
				int x = Integer.parseInt(a);
				float y = Float.parseFloat(b);
				nums.add(String.format("%.6f",x+y));
			}
			else {
				int x = Integer.parseInt(a);
				int y = Integer.parseInt(b);
				nums.add(String.valueOf(x+y));
			}
			
		}
		return nums.get(0);
		}
		catch(Exception e) {
			return "SOMETHING WRONG GLOBALLY";
		}

	}

	public static void main(String a[]) {
		
		Frame f = new Frame();
		f.setSize(400, 600);
				
		Font fnt = new Font("Courier",Font.BOLD,32);
		Font fntb = new Font("Courier",Font.BOLD,16);
		
		TextField enteringArea = new TextField();
		enteringArea.setBackground(Color.GRAY);
		enteringArea.setFont(fnt);
		
		
		Button b7 = new Button("7");
		b7.setFont(fntb);
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				enteringArea.setText(enteringArea.getText().concat(b7.getLabel()));
			}
		});
		Button b8 = new Button("8");b8.setFont(fntb);
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				enteringArea.setText(enteringArea.getText().concat(b8.getLabel()));
			}
		});
		Button b9 = new Button("9");b9.setFont(fntb);
		b9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				enteringArea.setText(enteringArea.getText().concat(b9.getLabel()));
			}
		});
		Button bmul = new Button("*");bmul.setFont(fntb);
		bmul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				enteringArea.setText(enteringArea.getText().concat(bmul.getLabel()));
			}
		});
		Button b4 = new Button("4");b4.setFont(fntb);
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				enteringArea.setText(enteringArea.getText().concat(b4.getLabel()));
			}
		});
		Button b5 = new Button("5");b5.setFont(fntb);
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				enteringArea.setText(enteringArea.getText().concat(b5.getLabel()));
			}
		});
		Button b6 = new Button("6");b6.setFont(fntb);
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				enteringArea.setText(enteringArea.getText().concat(b6.getLabel()));
			}
		});
		Button bmin = new Button("-");bmin.setFont(fntb);
		bmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				enteringArea.setText(enteringArea.getText().concat(bmin.getLabel()));
			}
		});
		Button b1 = new Button("1");b1.setFont(fntb);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				enteringArea.setText(enteringArea.getText().concat(b1.getLabel()));
			}
		});
		Button b2 = new Button("2");b2.setFont(fntb);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				enteringArea.setText(enteringArea.getText().concat(b2.getLabel()));
			}
		});
		Button b3 = new Button("3");b3.setFont(fntb);
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				enteringArea.setText(enteringArea.getText().concat(b3.getLabel()));
			}
		});
		Button bdiv = new Button("/");bdiv.setFont(fntb);
		bdiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				enteringArea.setText(enteringArea.getText().concat(bdiv.getLabel()));
			}
		});
		Button bpoint = new Button(".");bpoint.setFont(fntb);
		bpoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				enteringArea.setText(enteringArea.getText().concat(bpoint.getLabel()));
			}
		});
		Button b0 = new Button("0");b0.setFont(fntb);
		b0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				enteringArea.setText(enteringArea.getText().concat(b0.getLabel()));
			}
		});
		Button bplus = new Button("+");bplus.setFont(fntb);
		bplus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				enteringArea.setText(enteringArea.getText().concat(bplus.getLabel()));
			}
		});
		Button bequal = new Button("=");bequal.setFont(fntb);
		bequal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				enteringArea.setText(calc((enteringArea.getText())));
			}
		});
		Button bclear = new Button("C");bclear.setFont(fntb);
		bclear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				enteringArea.setText("");
			}
		});
		Button bbs = new Button("<x|");bbs.setFont(fntb);
		bbs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				enteringArea.setText(enteringArea.getText().substring(0, enteringArea.getText().length()-1));
			}
		});
		Button bpow = new Button("^");bpow.setFont(fntb);
		bpow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				enteringArea.setText(enteringArea.getText().concat(bpow.getLabel()));
			}
		});

		GridBagLayout gblb = new GridBagLayout();
		Panel buttonHolder = new Panel();
		buttonHolder.setLayout(gblb);
		buttonHolder.setBackground(Color.GRAY);

		GridBagConstraints gbcb = new GridBagConstraints();
		
		gbcb.weightx=1;gbcb.weighty=1;
		gbcb.gridheight=1;gbcb.gridwidth=1;
		gbcb.gridx=0;gbcb.gridy=0;gbcb.fill=GridBagConstraints.BOTH;
		gblb.setConstraints(bclear, gbcb);buttonHolder.add(bclear);//							clear
		gbcb.gridx=1;gbcb.gridy=0;gblb.setConstraints(bbs, gbcb);buttonHolder.add(bbs);//		back space
		gbcb.gridx=2;gbcb.gridy=0;gblb.setConstraints(bpow, gbcb);buttonHolder.add(bpow);//		power
		gbcb.gridx=3;gbcb.gridy=0;gblb.setConstraints(bdiv, gbcb);buttonHolder.add(bdiv);//		division
		gbcb.gridx=0;gbcb.gridy=1;gblb.setConstraints(b7, gbcb);buttonHolder.add(b7);//			7
		gbcb.gridx=1;gbcb.gridy=1;gblb.setConstraints(b8, gbcb);buttonHolder.add(b8);//			8
		gbcb.gridx=2;gbcb.gridy=1;gblb.setConstraints(b9, gbcb);buttonHolder.add(b9);//			9
		gbcb.gridx=3;gbcb.gridy=1;gblb.setConstraints(bmul, gbcb);buttonHolder.add(bmul);//		multiplication
		gbcb.gridx=0;gbcb.gridy=2;gblb.setConstraints(b4, gbcb);buttonHolder.add(b4);//			4
		gbcb.gridx=1;gbcb.gridy=2;gblb.setConstraints(b5, gbcb);buttonHolder.add(b5);//			5
		gbcb.gridx=2;gbcb.gridy=2;gblb.setConstraints(b6, gbcb);buttonHolder.add(b6);//			6
		gbcb.gridx=3;gbcb.gridy=2;gblb.setConstraints(bmin, gbcb);buttonHolder.add(bmin);//		minus
		gbcb.gridx=0;gbcb.gridy=3;gblb.setConstraints(b1, gbcb);buttonHolder.add(b1);//			1
		gbcb.gridx=1;gbcb.gridy=3;gblb.setConstraints(b2, gbcb);buttonHolder.add(b2);//			2
		gbcb.gridx=2;gbcb.gridy=3;gblb.setConstraints(b3, gbcb);buttonHolder.add(b3);//			3
		gbcb.gridx=0;gbcb.gridy=4;gblb.setConstraints(bpoint, gbcb);buttonHolder.add(bpoint);//	Floating point
		gbcb.gridx=1;gbcb.gridy=4;gblb.setConstraints(b0, gbcb);buttonHolder.add(b0);//			0
		gbcb.gridx=2;gbcb.gridy=4;gblb.setConstraints(bplus, gbcb);buttonHolder.add(bplus);//	addition
		gbcb.gridx=3;gbcb.gridy=3;gbcb.gridheight=2;gblb.setConstraints(bequal, gbcb);buttonHolder.add(bequal);//	equals
		
		buttonHolder.setVisible(true);
			
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				f.dispose();
			}
		});
		
		GridBagLayout gbl = new GridBagLayout();
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.weightx=1;gbc.weighty=1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx=0;gbc.gridy=0;
		gbc.gridheight =1;gbc.gridwidth=1;
		gbl.setConstraints(enteringArea, gbc);
		f.setLayout(gbl);
		f.add(enteringArea,gbc);
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weighty=1;gbc.gridx=0;gbc.gridy=1;
		gbl.setConstraints(buttonHolder, gbc);
		f.add(buttonHolder,gbc);
		
		f.setTitle("CALCULATOR");
		f.setMinimumSize(new Dimension(400,600));
		f.setVisible(true);
	}
}
