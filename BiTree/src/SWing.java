import com.sun.javaws.util.JfxHelper;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class SWing {
	private static JFrame f = new JFrame("树的遍历"), NF = new JFrame() ,  useprintf = new JFrame(), NodeF = new JFrame();
	JButton b1 = new JButton("前序遍历"), b2 = new JButton("中序遍历");
	JButton b3 = new JButton("后序遍历"), b4 = new JButton("层次遍历");
	JButton b5 = new JButton("结点") , nbt = new JButton();
	TextField TA1 = new TextField();
	static JLabel ta1 = new JLabel(), ta2 = new JLabel(), ta3 = new JLabel(), ta4 = new JLabel(), print_ = new JLabel();
	static BitTree.Node root = new BitTree.Node();
	static String GetDate = new String();
	static String PutDate = new String();
	static int choice = 0;
	
	void Button() {																			//按键设置
		b1.setBorderPainted(false);
		b2.setBorderPainted(false);
		b3.setBorderPainted(false);
		b4.setBorderPainted(false);
		b5.setBorderPainted(false);
		b1.addActionListener(new Mothod1());  
		b2.addActionListener(new Mothod2());
		b3.addActionListener(new Mothod3());
		
	}
		
	private class Mothod1 implements ActionListener{										//弹出新窗口事件
		@Override
		public void actionPerformed(ActionEvent e){		
			NewWindow1(f);
			choice = 1;
		}
	}
		
	private class Mothod2 implements ActionListener{										//弹出新窗口事件
		@Override	
		public void actionPerformed(ActionEvent e){		
			NewWindow1(f);
			choice = 2;
		}
	}
	
	private class Mothod3 implements ActionListener{										//弹出新窗口事件
		@Override
		public void actionPerformed(ActionEvent e){		
			NewWindow1(f);
			choice = 3;
		}
	}

	void PlaneJ() {																			//原窗口面板设置
			JLabel TU = new JLabel(new ImageIcon("ImageIcon/shu.jpg"));				//
			TU.setBounds(0, 0, 800, 600);									//
			f.setSize(800 , 600);
			f.setLocationRelativeTo(null);									
			f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			f.setLayout(null);
			Button();
			JPanel j2  = new JPanel(new FlowLayout());
			j2.setSize(600, 50);
			j2.setLocation(100, 0);
			JPanel J = (JPanel)f.getContentPane();											//
			J.setOpaque(false);																//
			JPanel j = new JPanel(null);
			j.setSize(97, 54);
			j.setLocation(350, 35);
			nbt = new JButton();
			nbt.setSize(97, 54);
			nbt.setOpaque(false);	
			nbt.setIcon(new ImageIcon("ImageIcon/按下前.png"));
			nbt.setPressedIcon(new ImageIcon("ImageIcon/按下后.png"));
			nbt.setBorderPainted(false);
			nbt.setContentAreaFilled(false);
			j2.add(b1);
			j2.add(b2);
			j2.add(b3);
			j2.add(b4);
			j2.add(b5);
			j2.setOpaque(false);															//
			j.add(nbt);
			j.setOpaque(false);
			f.getLayeredPane().add(TU, new Integer(Integer.MIN_VALUE));						//								
			f.add(j2);
			f.add(j);
			f.setResizable(false);
			f.setVisible(true);
			nbt.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					PrintWindow(f);
					j.setLocation(0, 0);
				}
			});
			b5.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						NewWindow3(f);
					}
			 	});
			b4.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						NewWindow2(f);
						BitTree.i = 0;
						PutDate = "";
						BitTree.depthOrderTraverse(root);
						BitTree.visitToString();
						print_.setText(PutDate);
						
					}	
				});
			
		}
	
	private JFrame NewWindow1(JFrame relativeWindow){											//新窗口1设置
		JLabel TU = new JLabel(new ImageIcon("ImageIcon/back.jpg"));
		TU.setBounds(0, 0, 500, 400);
		NF = new JFrame("选择方式");													
		NF.setSize(500, 400);
		NF.setLocationRelativeTo(relativeWindow);
		JPanel NP = new JPanel(null);
		NP.setOpaque(false);
		JLabel t2 = new JLabel("输出:");
		t2.setFont(new Font("宋体",Font.PLAIN, 16));
		JLabel t2_ = new JLabel();
		JButton Nb1 = new JButton("递归");
		JButton Nb2 = new JButton("非递归");
		JButton back = new JButton();
		t2.setSize(40, 20);
		t2.setLocation(180, 70);
		t2_.setSize(100, 20);
		t2_.setLocation(220, 70);
		Nb1.setSize(80, 50);
		Nb2.setSize(80, 50);
		Nb1.setLocation(100, 180);
		Nb2.setLocation(300, 180);
		back.setSize(120, 90);
		back.setLocation(190, 240);
		NP.add(t2);
		NP.add(t2_);
		NP.add(Nb1);
		NP.add(Nb2);
		NP.add(back);
		Nb1.setBorderPainted(false);
		Nb2.setBorderPainted(false);
		Nb1.setContentAreaFilled(false);
		Nb2.setContentAreaFilled(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		back.setOpaque(true);
		back.setIcon(new ImageIcon("ImageIcon/1_.png"));
		NP.setOpaque(false);
		NF.setContentPane(NP);
		NF.getLayeredPane().add(TU , new Integer(Integer.MIN_VALUE));
		NF.setVisible(true);
		NF.setResizable(false);
		Nb1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BitTree.i = 0;
				PutDate = "";
				Choose1();
				BitTree.visitToString();
				t2_.setText(PutDate);
			}
		});
		Nb2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BitTree.i = 0;
				PutDate = "";
				Choose2();
				BitTree.visitToString();
				t2_.setText(PutDate);
			}
		});
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				NF.dispose();
			}
		});
		return NF;
	}
	
	private JFrame PrintWindow (JFrame relativeWindow) {
		useprintf = new JFrame("输入");
		useprintf.setSize(300, 200);
		JLabel TU = new JLabel(new ImageIcon("ImageIcon/1g.jpg"));
		TU.setBounds(0,-20,300,200);
		JLabel t1 = new JLabel("输入 :");
		JPanel P1 = new JPanel(null);
		JButton B1 = new JButton("确定？");
		JLabel tip1 = new JLabel("左，右孩子为空用#代替");
		tip1.setForeground(Color.decode("#FF94B1"));
		tip1.setFont(new Font("宋体", Font.PLAIN, 12));
		JLabel tip2 = new JLabel("构造树的序列为前序");
		tip2.setForeground(Color.decode("#FF94B1"));
		tip2.setFont(new Font("宋体",Font.PLAIN, 12));
		tip1.setSize(150, 30);
		tip2.setSize(150, 30);
		TA1 = new TextField();
		t1.setSize(50, 30);
		t1.setLocation(80, 35);
		B1.setSize(100, 50);
		B1.setLocation(100, 100);
		TA1.setSize(100, 20);
		TA1.setLocation(130, 40);
		tip2.setLocation(180,0);
		P1.add(tip1);
		P1.add(tip2);
		P1.add(t1);
		P1.add(TA1);
		P1.add(B1);
		useprintf.setContentPane(P1);
		P1.setOpaque(false);
		useprintf.getLayeredPane().add(TU, new Integer(Integer.MIN_VALUE));
		useprintf.setLocationRelativeTo(null);
		useprintf.setVisible(true);		
		B1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GetDate = TA1.getText();
				BitTree.s = GetDate;
				BitTree.input = BitTree.s.toCharArray();
				//root = new BitTree.Node();
				BitTree.i = 0;
				BitTree.bitTreeInit(root);
				useprintf.dispose();
			}
		});
		return useprintf;
	}
	
	private JFrame NewWindow2 (JFrame relativeWindow) {
		JFrame cengci = new JFrame("层次遍历");
		cengci.setLayout(new BorderLayout());
		JLabel TU = new JLabel(new ImageIcon("ImageIcon/3bg.jpg"));
		TU.setBounds(0 ,0,300,250);
		cengci.setSize(300, 250);
		JPanel cengcip = new JPanel(new BorderLayout()); 
		JPanel cengcip_ = new JPanel(null);
		JLabel print = new JLabel("输出：");	
		print.setSize(40, 20);
		print.setLocation(60, 20);
		print_.setSize(120, 20);
		print_.setLocation(120, 20);
		cengcip_.add(print);
		cengcip_.add(print_);
		JButton b1 = new JButton("返回");
		b1.setOpaque(false);
		cengcip.add(b1, BorderLayout.SOUTH);
		cengci.add(cengcip, BorderLayout.SOUTH);
		cengci.add(cengcip_, BorderLayout.CENTER);
		b1.setBorderPainted(false);
		JPanel P = (JPanel)cengci.getContentPane();
		P.setOpaque(false);
		cengcip.setOpaque(false);
		cengcip_.setOpaque(false);
		cengci.getLayeredPane().add(TU, new Integer(Integer.MIN_VALUE));
		cengci.setResizable(false);
		cengci.setVisible(true);
		cengci.setLocationRelativeTo(null);
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cengci.dispose();
			}
		});
		return cengci;
	}

    String GetNode = new String();
	private JFrame NewWindow3 (JFrame relativeWindow) {									//结点的前驱后继输出窗口
		NodeF = new JFrame("判断结点的前驱后继" );
		NodeF.setSize(400, 300);
		JPanel NodeP = new JPanel(new BorderLayout(30, 40));
		JPanel P1 = new JPanel(null);
		P1.setSize(400, 30);
		P1.setLocation(0, 0);
		JPanel P2 = new JPanel(new FlowLayout());
		NodeP.setBackground(Color.decode("#CBEFFF"));
		P2.setBackground(Color.decode("#CBEFFF"));
		P1.setBackground(Color.decode("#CBEFFF"));
		JPanel P3 = new JPanel(null);
		P3.setOpaque(false);
		JLabel ta2_ = new JLabel();
		JLabel ta3_ = new JLabel();
		ta2 = new JLabel("前驱：");
		ta3 = new JLabel("后继：");
		ta4 = new JLabel("输入结点：");
		JButton JB1 = new JButton("前序");
		JButton JB2 = new JButton("中序");
		JButton JB3 = new JButton("后序");
		JB1.setBorderPainted(false);
        JB2.setBorderPainted(false);
        JB3.setBorderPainted(false);
		TextField TA2 = new TextField();
		TA2.setSize(80, 20);
		TA2.setLocation(190, 100);
		ta2.setSize(40, 20);
		ta3.setSize(40, 20);
		ta2_.setSize(50, 20);
		ta3_.setSize(50, 20);
		ta2.setLocation(130, 10);
		ta2_.setLocation(170, 10);
		ta3.setLocation(225, 10);
		ta3_.setLocation(280, 10);
		ta4.setSize(60, 20);
		ta4.setLocation(130, 100);
		P1.add(ta2);
		P1.add(ta2_);
		P1.add(ta3);
		P1.add(ta3_);
		P2.add(JB1);
        P2.add(JB2);
        P2.add(JB3);
        P3.add(ta4);
        P3.add(TA2);
		NodeP.add(P1);
		NodeP.add(P2, BorderLayout.SOUTH);
        NodeP.add(P3, BorderLayout.CENTER);
        NodeF.setContentPane(NodeP);
		NodeF.setLocationRelativeTo(null);
		NodeF.setVisible(true);
		NodeF.setResizable(false);
		JB1.addActionListener(new ActionListener() {											//结点的前驱后继事件
			@Override
			public void actionPerformed(ActionEvent e) {
				GetNode = TA2.getText();
				BitTree.i = 0;
				BitTree.preOrderTraverse(root);
				char[] res1 = new char[2];
				char[] res2 = new char[2];
				char loc = GetNode.charAt(0);
				res1[0] = BitTree.findBefore(loc,BitTree.visit );
				String tres1 = res1[0] + " ";
				res2[0] = BitTree.findAfter(loc,BitTree.visit);
				String tres2 = res2[0] + " ";
				ta2_.setText(tres1);
				ta3_.setText(tres2);
			}
		});
		JB2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
				GetNode = TA2.getText().trim();
				BitTree.i = 0;
				BitTree.inOrderTraverse(root);
				char[] res1 = new char[2];
				char[] res2 = new char[2];
				char loc = GetNode.charAt(0);
				res1[0] = BitTree.findBefore(loc,BitTree.visit);
				String tres = res1[0] + " ";
				res2[0] = BitTree.findAfter(loc,BitTree.visit);
				String tres2 = res2[0] + " ";
				ta2_.setText(tres);
				ta3_.setText(tres2);
            }
        });
		JB3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
				GetNode = TA2.getText().trim();
				BitTree.i = 0;
				BitTree.postOrderTraverse(root);
				char[] res1 = new char[2];
				char[] res2 = new char[2];
				char loc = GetNode.charAt(0);
				res1[0] = BitTree.findBefore(loc,BitTree.visit);
				String tres1 = res1[0] + " ";
				res2[0] = BitTree.findAfter(loc,BitTree.visit);
				String tres2 = res2[0] + " ";
				ta2_.setText(tres1);
				ta3_.setText(tres2);
            }
        });
		return  NodeF;
	}
	
	public static void Choose1() {
		switch (choice){
			case 1:
				BitTree.preOrderTraverse(root);
				break;
			case 2:
				BitTree.inOrderTraverse(root);
				break;
			case 3:
				BitTree.postOrderTraverse(root);
				break;
			default:
				PutDate = "error";
				break;
		}
	}
	
	public static void Choose2() {
		switch (choice) {
			case 1:
				BitTree.whilePreOrderTraverse(root);
				break;
			case 2:
				BitTree.whileInOrderTraverse(root);
				break;
			case 3:
				BitTree.whilePostOrderTraverse(root);
				break;
			default:
				PutDate = "error";
				break;
		}
	}

 	
	static void MainPart() {													
		SWing a = new SWing();
		a.PlaneJ();
	}
	public static void main(String []args){		//主函数
		MainPart();
		
	}


}

