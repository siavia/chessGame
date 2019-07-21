package chess;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ChessFrame extends JFrame implements ActionListener ,MouseListener,KeyListener{

	//private static final int WIDTH = 1024;
	//private static final int HEIGHT = 768;
	private static final int LEFT = 212;//(1024-40*15)/2
	private static final int TOP = 84;//(768-40*15)/2
	private Image black,white;
//	private ImageIcon backGround,back;
//	private javax.swing.JButton JB_back;
	
	//int i,j;
	boolean backable = false;
	
	byte chessBoard[][]= {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
	byte copy[][]={{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
	int[] a = new int[15];
	int[] b = new int[15];
	int[] c = new int[29];
	int[] d = new int[29];
	int[] aCopy = new int[15];  //copy
	int[] bCopy = new int[15];
	int[] cCopy = new int[29];
	int[] dCopy = new int[29];
	
	public ChessFrame() {
		super("������");
		setSize(1024,768);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container cont = getContentPane();
		cont.setLayout(null);
		//cont.setBackground(Color.PINK);
		getPic();
		setB();
		
	    //initComponents();
	    init();
	    this.addMouseListener(this);
	    this.addKeyListener(this);
	    
	    setFocusable(true);
	    setVisible(true);
	}
	
	public void initComponents() {
		/*//javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		//getContentPane().setLayout(layout);
		
		//layout.createParallelGroup.addLayoutComponent(JB_back);
		JB_back = new javax.swing.JButton("back");
		//JB_back.setIcon(back);
		JB_back.setSize(64, 64);
		JB_back.setLocation(800,600);
		JB_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_backActionPerformed(evt);
            }
        });
		
		this.add(JB_back);
		//this.addMouseListener(this);*/
	}
	
	public byte[][] init(){
		for(int i=0;i<15;i++) {
			for(int j=0;j<15;j++)
				System.out.print(chessBoard[i][j]);
			System.out.println();
		}
		System.out.println("******************");
		return chessBoard;
	}
	
	public void getPic(){
		//backGround = new ImageIcon("D:/ooh/Java/chess/src/backGround.png");
//		back = new ImageIcon("D:/ooh/Java/chess/src/back.png");//64*64
		white = Toolkit.getDefaultToolkit().getImage("D:/ooh/Java/chess/src/white.png");//40*40
		black = Toolkit.getDefaultToolkit().getImage("D:/ooh/Java/chess/src/black.png");
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		//System.out.println("�ұ�������");
		// g.drawRect(111, 111, 40, 40);
		// g.drawLine(x1, y1, x2, y2);
		for (int i = 0; i < 15; i++)
			for (int j = 0; j < 15; j++) {
				if (chessBoard[i][j] == 1)
					g.drawImage(black, LEFT + j * 40, TOP + i * 40, 40, 40, this);
				else if (chessBoard[i][j] == 2)
					g.drawImage(white, LEFT + j * 40, TOP + i * 40, 40, 40, this);
			}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int i,j;
		for (i = 0; i < 15; i++)
			for (j = 0; j < 15; j++)
				copy[i][j] = chessBoard[i][j];
		for(i = 0; i < 15; i++) {
			aCopy[i] = a[i];
			bCopy[i] = b[i];
			cCopy[i] = c[i];
			dCopy[i] = d[i];
		}
		for(; i < 29; i++) {
			cCopy[i] = c[i];
			dCopy[i] = d[i];
		}
		int x = e.getX();
		int y = e.getY();
		if (x > LEFT && x < LEFT + 40 * 15 && y > TOP && y < TOP + 40 * 15) {
			j = (x - LEFT) / 40;
			i = (y - TOP) / 40;
			if (chessBoard[i][j] == 0) {
				chessBoard[i][j] = 2;        //TODO black&white
				backable = true;
				updateABCD(i,j);
				System.out.println("player drop: i="+i+" j="+j);
				init();
				repaint();
				if(iswin(i,j,(byte) 2)) {}
				else {
				    computerPlay(i, j);
				}
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int i,j;
		if (e.getKeyCode() == KeyEvent.VK_B) {
			if (!backable)
				JOptionPane.showMessageDialog(null, "���ڲ��ɻ���","��ʾ",JOptionPane.ERROR_MESSAGE);
			else {
				for (i = 0; i < 15; i++)
					for (j = 0; j < 15; j++)
						chessBoard[i][j] = copy[i][j];
				for(i = 0; i < 15; i++) {
					a[i] = aCopy[i];
					b[i] = bCopy[i];
					c[i] = cCopy[i];
					d[i] = dCopy[i];
				}
				for(; i < 29; i++) {
					c[i] = cCopy[i];
					d[i] = dCopy[i];
				}
				System.out.println("back:");
				init();
				repaint();
				backable = false;
			}	
		}
		else if(e.getKeyCode() == KeyEvent.VK_N) {
			backable = false;
			for(i=0;i<15;i++)
				for(j=0;j<15;j++)
					chessBoard[i][j]=0;
			for(i = 0; i < 15; i++) {
				a[i] = 0;
				b[i] = 0;
				c[i] = 0;
				d[i] = 0;
			}
			for(; i < 29; i++) {
				c[i] = 0;
				d[i] = 0;
			}
			System.out.println("new game:");
			init();
			repaint();
		}
		else if(e.getKeyCode() == KeyEvent.VK_H)
			JOptionPane.showMessageDialog(null, "���������\n"
		+"�����Լ������ӣ�ʹ���Լ������Ӿ������������һ��ͬʱ���ضԷ����ӣ���ֹ�Է��������ӡ�\n"
		+ "��ô���ھͿ�ʼ��Ϸ��~   ����Ŷ~");
		else if(e.getKeyCode() == KeyEvent.VK_A)
			JOptionPane.showMessageDialog(null, "������...\n"+"���޸�����Ϣ");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	
	/*private void JB_backActionPerformed(java.awt.event.ActionEvent evt) {
		System.out.println("clicked!");
	}*/
	
	public static void main(String[] args) {
		new ChessFrame();
	}
	
	private int aCnt(int ii, int jj, byte chessColor) {//��
		int i = 0,j = 0;
		while(jj-i > 0) {
			if(chessBoard[ii][jj-i-1] == chessColor)
				i++;
			else
				break;
		}
		while(jj+j < 14) {
			if(chessBoard[ii][jj+j+1] == chessColor)
				j++;
			else
				break;
		}
		return i+j;
	}
	
	private int bCnt(int ii, int jj, byte chessColor) {//��
		int i = 0,j = 0;
		while(ii-i > 0) {
			if(chessBoard[ii-i-1][jj] == chessColor)
				i++;
			else
				break;
		}
		while(ii+j < 14) {
			if(chessBoard[ii+j+1][jj] == chessColor)
				j++;
			else
				break;
		}
		return i+j;
	}
	
	private int cCnt(int ii, int jj, byte chessColor) {//Ʋ'/'
		int i = 0,j = 0;
		while(ii-i > 0 && jj+i < 14) {
			if(chessBoard[ii-i-1][jj+i+1] == chessColor) {
				i++;
			}
			else
				break;
		}
		while(ii+j < 14 && jj-j >  0) {
			if(chessBoard[ii+j+1][jj-j-1] == chessColor) {
				j++;
			}
			else
				break;
		}
		return i+j;
	}
	
	private int dCnt(int ii, int jj, byte chessColor) {//��'\'
		int i = 0,j = 0;
		while(ii-i > 0 && jj-i > 0) {
			if(chessBoard[ii-i-1][jj-i-1] == chessColor) {
				i++;
			}
			else
				break;
		}
		while(ii+j < 14 && jj+j < 14) {
			if(chessBoard[ii+j+1][jj+j+1] == chessColor) {
				j++;
			}
			else
				break;
		}
		return i+j;
	}
	
	private void updateABCD(int ii, int jj) {
		int i,j;
		System.out.println("update:");
		boolean clock1 = false;
		//boolean clock2 = true;
		//boolean clock1 = false;
		//boolean clock2 = false;
		//1.��ȥabcd�б������ġ�����abcd[]
		int cnt,max;
		//��
		cnt = 0; max = 0;
		if(chessBoard[ii][0] == 1) {//�����һ�����Ǻ��ӣ���ôclock1�Ѿ�����
			clock1 = true;cnt++;
		}
		for(j = 1; j < 14; j++) {//�ӵڶ����ֵ������ڶ������ҵ�������û��ǰ��������max����
			if(chessBoard[ii][j] == 1) {
				cnt++;
				if(chessBoard[ii][j-1] == 2)
					clock1 = true;
				else if(chessBoard[ii][j-1] == 0)
					clock1 = false;
			}
			else if(chessBoard[ii][j] == 0) {
				if(cnt > max)
					max = cnt;
				cnt = 0;
			}
			else if(chessBoard[ii][j] == 2) {
				if(clock1 == false) {
					if(cnt > max)
						max = cnt;
					cnt = 0;
				}
				else
					cnt = 0;
			}
		}
		if(chessBoard[ii][14] == 1) {//�鿴���һ���Ƿ�Ҳ�����ˣ����ж�max
			cnt++;
			if(clock1 == false || chessBoard[ii][13] == 0)
				if(cnt > max)
					max = cnt;
		}
		a[ii] = max;//�����ڵ�max������a[]
		for(i = 0; i < 15; i++)/////////////////
			System.out.print(a[i]);
		System.out.println("a");	
		
		//��
		cnt = 0; max = 0;
		clock1 = false;
		if(chessBoard[0][jj] == 1) {//�����һ�����Ǻ��ӣ���ôclock1�Ѿ�����
			clock1 = true;cnt++;
		}
		for(i = 1; i < 14; i++) {//�ӵڶ����ֵ������ڶ������ҵ�������û��ǰ��������max����
			if(chessBoard[i][jj] == 1) {
				cnt++;
				if(chessBoard[i-1][jj] == 2)
					clock1 = true;
				else if(chessBoard[i-1][jj] == 0)
					clock1 = false;
			}
			else if(chessBoard[i][jj] == 0) {
				if(cnt > max)
					max = cnt;
				cnt = 0;
			}
			else if(chessBoard[i][jj] == 2) {
				if(clock1 == false) {
					if(cnt > max)
						max = cnt;
					cnt = 0;
				}
				else
					cnt = 0;
			}
		}
		if(chessBoard[14][jj] == 1) {//�鿴���һ���Ƿ�Ҳ�����ˣ����ж�max
			cnt++;
			if(clock1 == false || chessBoard[13][jj] == 0)
				if(cnt > max)
					max = cnt;
		}
		b[jj] = max;//�����ڵ�max������b[]
		for(i = 0; i < 15; i++)
			System.out.print(b[i]);
		System.out.println("b");		

		// Ʋ'/'
		int sum = ii + jj; //Ʋ���ص��ǣ�i+j==����c����Ӧ���±꣨һ��c�����ǵ�i+j����һ���ģ�
		cnt = 0;max = 0;
		clock1 = false;
		if (sum <= 14) {//ע����ϵ������ҵ�ʱ�򣬷�Ϊ��/����/�����ߵ���ʼλ�ò�ͬ��Ҫ���������
			if (chessBoard[0][sum] == 1) {
				clock1 = true;
				cnt++;
			}
			for (i = 1; sum-i > 0; i++) {
				if (chessBoard[i][sum - i] == 1) {
					cnt++;
					if (chessBoard[i - 1][sum - i + 1] == 2)
						clock1 = true;
					else if (chessBoard[i - 1][sum - i + 1] == 0)
						clock1 = false;
				} else if (chessBoard[i][sum - i] == 0) {
					if (cnt > max)
						max = cnt;
					cnt = 0;
				} else if (chessBoard[i][sum - i] == 2) {
					if (clock1 == false) {
						if (cnt > max)
							max = cnt;
						cnt = 0;
					} else
						cnt = 0;
				}
			}
			if(sum > 0 && chessBoard[sum][0] == 1) {
				cnt++;
				if(clock1 == false || chessBoard[sum-1][1] == 0)
					if(cnt > max)
						max = cnt;
			}
		}
		else if(sum > 14) {//ע����ϵ������ҵ�ʱ�򣬷�Ϊ��/����/�����ߵ���ʼλ�ò�ͬ��Ҫ���������
			if (chessBoard[sum-14][14] == 1) {
				clock1 = true;
				cnt++;
			}
			for (i = sum-14+1; i < 14; i++) {// ֱ��һ��ѭ��������������211211
				if (chessBoard[i][sum - i] == 1) {
					cnt++;
					if (chessBoard[i - 1][sum - i + 1] == 2)
						clock1 = true;
					else if (chessBoard[i - 1][sum - i + 1] == 0)
						clock1 = false;
				} else if (chessBoard[i][sum - i] == 0) {
					if (cnt > max)
						max = cnt;
					cnt = 0;
				} else if (chessBoard[i][sum - i] == 2) {
					if (clock1 == false) {
						if (cnt > max)
							max = cnt;
						cnt = 0;
					} else
						cnt = 0;
				}
			}
			if(chessBoard[14][sum-14] == 1) {
				cnt++;
				if(clock1 == false || chessBoard[13][sum-13] == 0)
					if(cnt > max)
						max = cnt;
			}
		}
		c[sum] = max;//��������ۺ󣬸���c[]
		for (i = 0; i < 29; i++)
			System.out.print(c[i]);
		System.out.println("c");
		
		// ��'\'
		cnt = 0;max = 0;
		clock1 = false;
		int starti = 0, startj = 0, dline = 0;//����ص���ÿ��һ����i��j��ֱ��һ��
		if(ii < jj) {
			starti = 0; startj = jj-ii; dline = 14 - (jj-ii);//ע�ⲻͬ�������Ӧ����\��ͬ����Ӧd���±겻ͬ
		}
		if(ii >= jj) {
			starti = ii-jj; startj = 0; dline = 14 + (ii-jj);
		}
		if (chessBoard[starti][startj] == 1) {//��ʼ��ͷ����ͬǰ��һ���ķ���
			clock1 = true;
			cnt++;
		}
		for (i=starti+1,j=startj+1; i<=14&&j<=14; i++,j++) {
			if (chessBoard[i][j] == 1) {
				cnt++;
				if (chessBoard[i - 1][j - 1] == 2)
					clock1 = true;
				else if (chessBoard[i - 1][j - 1] == 0)
					clock1 = false;
				if((i==14 || j==14) && clock1==false && cnt>max)
					max = cnt;
			} else if (chessBoard[i][j] == 0) {
				if (cnt > max)
					max = cnt;
				cnt = 0;
			} else if (chessBoard[i][j] == 2) {
				if (clock1 == false) {
					if (cnt > max)
						max = cnt;
					cnt = 0;
				} else
					cnt = 0;
			}
		}
		d[dline] = max; //��max������d[]
		for (i = 0; i < 29; i++)
			System.out.print(d[i]);
		System.out.println("d");
	}
	
	private void computerPlay(int ii,int jj) {
		int i,j;
		//TODO �м�ȱһ������� 022022
		System.out.println("computer!");
		//1.�Ƿ�������δ��һ�ߣ������ĸ�û����(2.3)������У�������Ӳ����ٴθ���abcd[]
		//��
		boolean clock1 = false;
		boolean clock2 = false;
		int cnt = 0, max = 0;
		i = 0; j = 0;//���￪ʼ�������ii��jj���İ��Ӻ�ķ����м����������ģ�����2����ϱ��������������Ȼ��������ж��Ƿ��ס�ˣ�
		if(jj==0)//��������
			clock1 = true;
		else {
			while (jj - i > 0) {//i������¼������������İ��ӵĸ���
				if (chessBoard[ii][jj - i - 1] == 2) {
					if(jj-i-1 == 0)
						clock1 = true;
					i++;
				}	
				else if (chessBoard[ii][jj - i - 1] == 1) {
					clock1 = true;
					break;
				} else
					break;
			}
		}
		if(jj == 14)//��������
			clock2 =  false;
		else {
			while (jj + j < 15) {
				if (chessBoard[ii][jj + j + 1] == 2) {
					if(jj + j + 1 == 14)
						clock2 = true;
					j++;
				}
				else if (chessBoard[ii][jj + j + 1] == 1) {
					clock2 = true;
					break;
				} else
					break;
			}
		}
		if(i+j == 2 && clock1==false && clock2==false) { //���������ˣ���ʼ��������3����������ͷ��û�з�ס�����
				chessBoard[ii][jj-i-1] = 1;//Ĭ���������������ӵ���߷ź���
				updateABCD(ii,jj-i-1);//TODO ���Բ�Ϊabcd�ĸ����������ԺͲ���һ����һ����Ūһ��
				System.out.println("computer drop:");
				init();
			    repaint();
			    iswin(ii,jj-i-1,(byte) 1);
			    return;
		}
		else if(i+j==3 && clock1 == false) {//���������ĸ����������û�б���ס�����
				chessBoard[ii][jj-i-1] = 1;//�������ĸ����ӵ���߷ź���
				updateABCD(ii,jj-i-1);
				System.out.println("computer drop:");
				init();
				repaint();
				iswin(ii,jj-i-1,(byte) 1);
				return;
		}
		else if(i+j==3 && clock2 == false) {//���������ĸ��������Ҳ�û�б���ס�����
				chessBoard[ii][jj+j+1] = 1;//�������ĸ����ӵ��ұ߷ź���
				updateABCD(ii,jj+j+1);
				System.out.println("computer drop:");
			    init();
			    repaint();
			    iswin(ii,jj+j+1,(byte) 1);
			    return;
		}
		
		//��
		clock1 = false;
		clock2 = false;
		i = 0; j = 0;//���￪ʼ�������ii��jj���İ������ķ����м����������ģ�����2����ϱ��������������Ȼ��������ж��Ƿ��ס�ˣ�
		if(ii==0)//��������
			clock1 = true;
		else {
			while (ii - i > 0) {//i������¼���ϱ��������İ��ӵĸ���
				if (chessBoard[ii - i - 1][jj] == 2) {
					if(ii - i - 1 == 0)
						clock1 = true;
					i++;
				}	
				else if (chessBoard[ii - i - 1][jj] == 1) {
					clock1 = true;
					break;
				} else
					break;
			}
		}
		if(ii == 14)//��������
			clock2 =  false;
		else {
			while (ii + j < 15) {
				if (chessBoard[ii + j + 1][jj] == 2) {
					if(ii + j + 1 == 14)
						clock2 = true;
					j++;
				}
				else if (chessBoard[ii][jj + j + 1] == 1) {
					clock2 = true;
					break;
				} else
					break;
			}
		}
		if(i+j == 2 && clock1==false && clock2==false) { //���������ˣ���ʼ��������3����������ͷ��û�з�ס�����
				chessBoard[ii-i-1][jj] = 1;//Ĭ���������������ӵ��ϱ߷ź���
				updateABCD(ii-i-1,jj);
				System.out.println("computer drop:");
			    init();
			    repaint();
			    iswin(ii-i-1,jj,(byte) 1);
			    return;
		}
		else if(i+j==3 && clock1 == false) {//���������ĸ��������ϲ�û�б���ס�����
				chessBoard[ii-i-1][jj] = 1;//�������ĸ����ӵ��ϱ߷ź���
				updateABCD(ii-i-1,jj);
				System.out.println("computer drop:");
				init();
				repaint();
				iswin(ii-i-1,jj,(byte) 1);
				return;
		}
		else if(i+j==3 && clock2 == false) {//���������ĸ��������²�û�б���ס�����
				chessBoard[ii+j+1][jj] = 1;//�������ĸ����ӵ��±߷ź���
				updateABCD(ii+j+1,jj);
				System.out.println("computer drop:");
			    init();
			    repaint();
			    iswin(ii+j+1,jj,(byte) 1);
			    return;
		}

		//Ʋ'/' 
		clock1 = false;
		clock2 = false;
		//sum = ii + jj;//Ʋ���ص��ǣ�i+j==����c����Ӧ���±꣨һ��c�����ǵ�i+j����һ���ģ�
		i = 0; j = 0;//���￪ʼ�������ii��jj���İ���'/'�ķ����м����������ģ�����2����ϱ��������������Ȼ��������ж��Ƿ��ס�ˣ�
		if(ii==0 || jj==14)//����������
			clock1 = true;
		else {
			while (ii-i>0 && jj+i<14) {//i������¼�������������İ��ӵĸ���
				if (chessBoard[ii-i-1][jj+i+1] == 2) {
					if(ii-i-1==0 || jj+i+1==14)
						clock1 = true;
					i++;
				}
				else if (chessBoard[ii-i-1][jj+i+1] == 1) {
					clock1 = true;
					break;
				} else
					break;
			}
		}
		if(ii==14 || jj==0)//����������
			clock2 =  false;
		else {
			while (ii+j<14 && jj-j>0) { //j������¼�������������İ��ӵĸ���
				if (chessBoard[ii+j+1][jj-j-1] == 2) {
					if(ii+j+1==14 || jj-j-1==0)
						clock2 = true;
					j++;
				}
				else if (chessBoard[ii+j+1][jj-j-1] == 1) {
					clock2 = true;
					break;
				} else
					break;
			}
		}
		if(i+j == 2 && clock1==false && clock2==false) { //���������ˣ���ʼ��������3����������ͷ��û�з�ס�����
				chessBoard[ii-i-1][jj+i+1] = 1;//Ĭ���������������ӵ����Ϸź���
				updateABCD(ii-i-1,jj+i+1);
				System.out.println("computer drop:");
			    init();
			    repaint();
			    iswin(ii-i-1,jj+i+1,(byte) 1);
			    return;
		}
		else if(i+j==3 && clock1 == false) {//���������ĸ�����������û�б���ס�����
				chessBoard[ii-i-1][jj+i+1] = 1;//�������ĸ����ӵ����Ϸź���
				updateABCD(ii-i-1,jj+i+1);
				System.out.println("computer drop:");
				init();
				repaint();
				iswin(ii-i-1,jj+i+1,(byte) 1);
				return;
		}
		else if(i+j==3 && clock2 == false) {//���������ĸ�����������û�б���ס�����
				chessBoard[ii+j+1][jj-j-1] = 1;//�������ĸ����ӵ����·ź���
				updateABCD(ii+j+1,jj-j-1);
				System.out.println("computer drop:");
			    init();
			    repaint();
			    iswin(ii+j+1,jj-j-1,(byte) 1);
			    return;
		}
		
		//��'\' 
		clock1 = false;//����ص���ÿ��һ����i��j��ֱ��һ��
		clock2 = false;
		i = 0; j = 0;//���￪ʼ�������ii��jj���İ��Ӻ�ķ����м����������ģ�����2����ϱ��������������Ȼ��������ж��Ƿ��ס�ˣ�
		if(ii==0 || jj==0)//��������
			clock1 = true;
		else {
			while (ii-i>0 && jj-i>0) {//i������¼������������İ��ӵĸ���
				if (chessBoard[ii-i-1][jj-i-1] == 2) {
					if(ii-i-1==0 || jj-i-1==0)
						clock1 = true;
					i++;
				}
				else if (chessBoard[ii-i-1][jj-i-1] == 1) {
					clock1 = true;
					break;
				} else
					break;
			}
		}
		if(ii==14 || jj==14)//��������
			clock2 =  false;
		else {
			while (ii+j<14 && jj+j<14) {
				if (chessBoard[ii+j+1][jj+j+1] == 2) {
					if(ii+j+1==14 || jj+j+1==14)//////////////////////////
						clock2 = true;
					j++;
				}
				else if (chessBoard[ii+j+1][jj+j+1] == 1) {
					clock2 = true;
					break;
				} else
					break;
			}
		}
		if(i+j == 2 && clock1==false && clock2==false) { //���������ˣ���ʼ��������3����������ͷ��û�з�ס�����
				chessBoard[ii-i-1][jj-i-1] = 1;//Ĭ���������������ӵ���߷ź���
				updateABCD(ii-i-1,jj-i-1);
				System.out.println("computer drop:");
			    init();
			    repaint();
			    iswin(ii-i-1,jj-i-1,(byte) 1);
			    return;
		}
		else if(i+j==3 && clock1 == false) {//���������ĸ����������û�б���ס�����
				chessBoard[ii-i-1][jj-i-1] = 1;//�������ĸ����ӵ���߷ź���
				updateABCD(ii-i-1,jj-i-1);
				System.out.println("computer drop:");
				init();
				repaint();
				iswin(ii-i-1,jj-i-1,(byte) 1);
				return;
		}
		else if(i+j==3 && clock2 == false) {//���������ĸ��������Ҳ�û�б���ס�����
				chessBoard[ii+j+1][jj+j+1] = 1;//�������ĸ����ӵ��ұ߷ź���
				updateABCD(ii+j+1,jj+j+1);
				System.out.println("computer drop:");
			    init();
			    repaint();
			    iswin(ii+j+1,jj+j+1,(byte) 1);
			    return;
		}
		
		///////////////////////////////////////////////////////////////////////////
		//2.��̺ʽ����
		System.out.println("��ʼ��̺ʽ����");
		max=0;char derection = 'a'; int xiabiao = 0;
		for(i=0;i<15;i++) {
			if(a[i]>max) {
				max = a[i];
				derection='a'; xiabiao = i;
			}
			if(b[i]>max) {
				max = b[i];
				derection='b'; xiabiao = i;
			}
		}
		for(i=0;i<29;i++) {
			if(c[i]>max) {
				max=c[i];
				derection='c'; xiabiao = i;
			}
			if(d[i]>max) {
				max=d[i];
				derection='d'; xiabiao = i;
			}
		}
		System.out.println(derection + "["+xiabiao+"]="+max);///////////////////
		
		if(max == 0) {//�µ�һ���ӵ�ʱ��abcd������0������Ĭ�ϻ�����ͬһ��j==1�ĵط���������ǰ�������һ��ĺ��Ӷ���ס�ˣ�Ҳ��max==0��Ҳѡ�����ڰ����ԣ�
			if(jj>0 && chessBoard[ii][jj-1]==0) {
				chessBoard[ii][jj-1] = 1;
				updateABCD(ii,jj-1);
				System.out.println("computer drop:");
				init();
				repaint();
				iswin(ii,jj-1,(byte) 1);
				return;
			}
			else if(jj<14 && chessBoard[ii][jj+1]==0) {
				chessBoard[ii][jj+1] = 1;
				updateABCD(ii,jj+1);
				System.out.println("computer drop:");
				init();
				repaint();
				iswin(ii,jj+1,(byte) 1);
				return;
			}
			else if(ii>0 && chessBoard[ii-1][jj]==0) {
				chessBoard[ii-1][jj] = 1;
				updateABCD(ii-1,jj);
				System.out.println("computer drop:");
				init();
				repaint();
				iswin(ii-1,jj,(byte) 1);
				return;
			}
			else if(ii<14 && chessBoard[ii+1][jj]==0) {
				chessBoard[ii][jj-1] = 1;
				updateABCD(ii,jj-1);
				System.out.println("computer drop:");
				init();
				repaint();
				iswin(ii,jj-1,(byte) 1);
				return;
			}
		}
		
		switch(derection) {
		case 'a':{
			//��
			cnt = 0;
			clock1 = false; clock2 = false;
			if(chessBoard[xiabiao][0] == 1) {//�����һ�����Ǻ��ӣ���ôclock1�Ѿ�����
				clock1 = true;cnt++;
			}
			for(j = 1; j <= 14; j++) {//�ӵڶ����ֵ������ڶ������ҵ�������û��ǰ��������cnt������������������max�Ա�һ�µĻ�����������԰��º���
				if(chessBoard[xiabiao][j] == 1) {
					cnt++;
					if(chessBoard[xiabiao][j-1] == 2)
						clock1 = true;
					else if(chessBoard[xiabiao][j-1] == 0)
						clock1 = false;
					if(j==14 && cnt==max && clock1==false) {//�鿴���һ��
						chessBoard[xiabiao][j-cnt] = 1;
						updateABCD(xiabiao,j-cnt);
						System.out.println("computer drop:");
						init();
						repaint();
						iswin(xiabiao,j-cnt,(byte) 1);
						return;
					}
				}
				else if(chessBoard[xiabiao][j] == 0) {
					if(cnt == max) {
						chessBoard[xiabiao][j] = 1;
						updateABCD(xiabiao,j);
						System.out.println("computer drop:");
						init();
						repaint();
						iswin(xiabiao,j,(byte) 1);
						return;
					}
					cnt = 0;
				}
				else if(chessBoard[xiabiao][j] == 2) {
					if(clock1 == false && cnt == max) {
						chessBoard[xiabiao][j-cnt-1] = 1;
						updateABCD(xiabiao,j-cnt-1);
						System.out.println("computer drop:");
						init();
						repaint();
						iswin(xiabiao,j-cnt-1,(byte) 1);
						return;
					}
					cnt = 0;
				}
			}
			break;
		}
		case 'b':{
			//��
			cnt = 0;
			clock1 = false; clock2 = false;
			if(chessBoard[0][xiabiao] == 1) {//�����һ�����Ǻ��ӣ���ôclock1�Ѿ�����
				clock1 = true;cnt++;
			}
			for(i = 1; i <= 14; i++) {//�ӵڶ����ֵ������ڶ������ҵ�������û��ǰ��������cnt������������������max�Ա�һ�µĻ�����������԰��º���
				if(chessBoard[i][xiabiao] == 1) {
					cnt++;
					if(chessBoard[i-1][xiabiao] == 2)
						clock1 = true;
					else if(chessBoard[i-1][xiabiao] == 0)
						clock1 = false;
					if(i==14 && cnt==max && clock1==false) {//�鿴���һ��
						chessBoard[i-cnt][xiabiao] = 1;
						updateABCD(i-cnt,xiabiao);
						System.out.println("computer drop:");
						init();
						repaint();
						iswin(i-cnt,xiabiao,(byte) 1);
						return;
					}
				}
				else if(chessBoard[i][xiabiao] == 0) {
					if(cnt == max) {
						chessBoard[i][xiabiao] = 1;
						updateABCD(i,xiabiao);
						System.out.println("computer drop:");
						init();
						repaint();
						iswin(i,xiabiao,(byte) 1);
						return;
					}
					cnt = 0;
				}
				else if(chessBoard[i][xiabiao] == 2) {
					if(clock1 == false && cnt == max) {
						chessBoard[i-cnt-1][xiabiao] = 1;
						updateABCD(i-cnt-1,xiabiao);
						System.out.println("computer drop:");
						init();
						repaint();
						iswin(i-cnt-1,xiabiao,(byte) 1);
						return;
					}
					cnt = 0;
				}
			}	
			break;
		}
		case 'c':{
			// Ʋ'/'
			//int sum = xiabiao; //Ʋ���ص��ǣ�i+j==����c����Ӧ���±꣨һ��c�����ǵ�i+j����һ���ģ�
			cnt = 0;
			clock1 = false; clock2 = false;
			if (xiabiao <= 14) {//ע����ϵ������ҵ�ʱ�򣬷�Ϊ��/����/�����ߵ���ʼλ�ò�ͬ��Ҫ���������
				if (chessBoard[0][xiabiao] == 1) {
					clock1 = true;
					cnt++;
				}
				for (i = 1; xiabiao-i >= 0; i++) {
					if (chessBoard[i][xiabiao - i] == 1) {
						cnt++;
						if (chessBoard[i - 1][xiabiao - i + 1] == 2)
							clock1 = true;
						else if (chessBoard[i - 1][xiabiao - i + 1] == 0)
							clock1 = false;
						if(xiabiao-i == 0 && cnt==max && clock1==false) {//last
							chessBoard[i-cnt][xiabiao-i+cnt] = 1;
							updateABCD(i-cnt,xiabiao-i+cnt);
							System.out.println("computer drop:");
							init();
							repaint();
							iswin(i-cnt,xiabiao-i+cnt,(byte) 1);
							return;
						}
					} else if (chessBoard[i][xiabiao - i] == 0) {
						if (cnt == max) {
							chessBoard[i][xiabiao-i] = 1;
							updateABCD(i,xiabiao-i);
							System.out.println("computer drop:");
							init();
							repaint();
							iswin(i,xiabiao-i,(byte) 1);
							return;
						}
						cnt = 0;
					} else if (chessBoard[i][xiabiao - i] == 2) {
						if (clock1 == false && cnt == max) {
							chessBoard[i-cnt-1][xiabiao-i+cnt+1] = 1;
							updateABCD(i-cnt-1,xiabiao-i+cnt+1);
							System.out.println("computer drop:");
							init();
							repaint();
							iswin(i-cnt-1,xiabiao-i+cnt+1,(byte) 1);
							return;
						} 
						cnt = 0;
					}
				}
			}
			else if(xiabiao > 14) {//ע����ϵ������ҵ�ʱ�򣬷�Ϊ��/����/�����ߵ���ʼλ�ò�ͬ��Ҫ���������
				if (chessBoard[xiabiao-14][14] == 1) {
					clock1 = true;
					cnt++;
				}
				for (i = xiabiao-14+1; i <= 14; i++) {// ֱ��һ��ѭ��������������211211
					if (chessBoard[i][xiabiao - i] == 1) {
						cnt++;
						if (chessBoard[i - 1][xiabiao - i + 1] == 2)
							clock1 = true;
						else if (chessBoard[i - 1][xiabiao - i + 1] == 0)
							clock1 = false;
						if(i==14 && cnt==max && clock1==false) {//last
							chessBoard[i-cnt][xiabiao-i+cnt] = 1;
							updateABCD(i-cnt,xiabiao-i+cnt);
							System.out.println("computer drop:");
							init();
							repaint();
							iswin(i-cnt,xiabiao-i+cnt,(byte) 1);
							return;
						}
					} else if (chessBoard[i][xiabiao - i] == 0) {
						if (cnt == max) {
							chessBoard[i][xiabiao-i] = 1;
							updateABCD(i,xiabiao-i);
							System.out.println("computer drop:");
							init();
							repaint();
							iswin(i,xiabiao-i,(byte) 1);
							return;
						}
						cnt = 0;
					} else if (chessBoard[i][xiabiao - i] == 2) {
						if (cnt == max && clock1 == false) {
							chessBoard[i-cnt-1][xiabiao-i+cnt+1] = 1;
							updateABCD(i-cnt-1,xiabiao-i+cnt+1);
							System.out.println("computer drop:");
							init();
							repaint();
							iswin(i-cnt-1,xiabiao-i+cnt+1,(byte) 1);
							return;
						}
						cnt = 0;
					}
				}
			}
			break;
		}
		default:{
			// ��'\'
			cnt = 0;
			clock1 = false;
			int starti = 0, startj = 0;
			if(xiabiao <= 14) { //xiabiao = 14-(jj-ii)
				starti = 0; startj = 14-xiabiao;//startj = 14-xiabiao+starti;
			}
			else if(xiabiao > 14) {//xiabiao = 14 + (ii-jj)
				starti = xiabiao-14; startj = 0;
			}
			if (chessBoard[starti][startj] == 1) {//��ʼ��ͷ����ͬǰ��һ���ķ���
				clock1 = true;
				cnt++;
			}
			for (i=starti+1,j=startj+1; i<=14&&j<=14; i++,j++) {
				if (chessBoard[i][j] == 1) {
					cnt++;
					if (chessBoard[i - 1][j - 1] == 2)
						clock1 = true;
					else if (chessBoard[i - 1][j - 1] == 0)
						clock1 = false;
					if((i==14||j==14) && cnt==max && clock1==false) {//last
						chessBoard[i-cnt][j-cnt] = 1 ;
						updateABCD(i-cnt,j-cnt);
						System.out.println("computer drop:");
						init();
						repaint();
						iswin(i-cnt,j-cnt,(byte) 1);
						return;
					}
				} else if (chessBoard[i][j] == 0) {
					if (cnt == max) {
						chessBoard[i][j] = 1;
						updateABCD(i,j);
						System.out.println("computer drop:");
						init();
						repaint();
						iswin(i,j,(byte) 1);
						return;
					}
					cnt = 0;
				} else if (chessBoard[i][j] == 2) {
					if (clock1 == false && cnt == max) {
						chessBoard[i-cnt-1][j-cnt-1] = 1;
						updateABCD(i-cnt-1,j-cnt-1);
						System.out.println("computer drop:");
						init();
						repaint();
						iswin(i-cnt-1,j-cnt-1,(byte) 1);
						return;
					} 
					cnt = 0;
				}
			}		
			break;
		  }
		}
		System.out.println("��̺ʽ����ʧ��");
		
		///////////////////////////////////////////////////////////////////
		//��������»���������ҵ���λλ�þ���
		System.out.println("���������ҵ���λ����");
		for(i = 0; i < 15; i++)
			for(j = 0; j < 15; j++) {
				if(chessBoard[i][j] == 0) {
					chessBoard[i][j] = 1;
					updateABCD(i,j);
					System.out.println("computer drop:");
					init();
					repaint();
					iswin(i,j,(byte) 1);
					return;
				}
			}
		
        ///////////////////////////////////////////////////////////////////
		//����λ��û����
		System.out.println("no spare place, game over!");
		int next = JOptionPane.showConfirmDialog(null, "���Ǽ��ҵĶ����������Ѿ�������","\n����һ�֣�",JOptionPane.YES_NO_OPTION);
		if(next == JOptionPane.YES_OPTION) {
			backable = false;
			for(i=0;i<15;i++)
				for(j=0;j<15;j++)
					chessBoard[i][j]=0;
			for(i = 0; i < 15; i++) {
				a[i] = 0;
				b[i] = 0;
				c[i] = 0;
				d[i] = 0;
			}
			for(; i < 29; i++) {
				c[i] = 0;
				d[i] = 0;
			}
			System.out.println("new game:");
			init();
			repaint();
		}
		else {
			this.setVisible(false);
		}
	}
	
	private boolean iswin(int ii, int jj, byte chessColor) {
		int i,j;
		if (chessColor == (byte) 2) {
			if (aCnt(ii, jj, chessColor) == 4 || bCnt(ii, jj, chessColor) == 4 || cCnt(ii, jj, chessColor) == 4
					|| dCnt(ii, jj, chessColor) == 4) {
				System.out.println("you win!");
				int next = JOptionPane.showConfirmDialog(null, "YOU WIN!!\n����һ�֣�", "Congratulations!",JOptionPane.YES_NO_OPTION);
				if (next == JOptionPane.YES_OPTION) {
					for (i = 0; i < 15; i++)
						for (j = 0; j < 15; j++) {
							chessBoard[i][j] = 0;
						}
					for (i = 0; i < 15; i++) {
						a[i] = 0;
						b[i] = 0;
						c[i] = 0;
						d[i] = 0;
					}
					for (; i < 29; i++) {
						c[i] = 0;
						d[i] = 0;
					}
					System.out.println("new game:");
					init();
					repaint();
				} else {
					this.setVisible(false);
				}
				return true;
			}
		}
		if (chessColor == (byte) 1) {
			if (aCnt(ii, jj, chessColor) == 4 || bCnt(ii, jj, chessColor) == 4 || cCnt(ii, jj, chessColor) == 4
					|| dCnt(ii, jj, chessColor) == 4) {
				System.out.println("computer win!");
				int next = JOptionPane.showConfirmDialog(null,"��С�������...\n����һ����" ,"Oops~" ,JOptionPane.YES_NO_OPTION);
				if (next == JOptionPane.YES_OPTION) {
					for (i = 0; i < 15; i++)
						for (j = 0; j < 15; j++) {
							chessBoard[i][j] = 0;
						}
					for (i = 0; i < 15; i++) {
						a[i] = 0;
						b[i] = 0;
						c[i] = 0;
						d[i] = 0;
					}
					for (; i < 29; i++) {
						c[i] = 0;
						d[i] = 0;
					}
					System.out.println("new game:");
					init();
					repaint();
				} else {
					this.setVisible(false);
				}
				return true;
			}
		}
		return false;	
	}
	
	private void setB(){
        ImageIcon img = new ImageIcon("backGround.png");//���Ǳ���ͼƬ////////////////////////////////
        JLabel imgLabel = new JLabel(img);//������ͼ���ڱ�ǩ�
          this.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));//ע�������ǹؼ�����������ǩ��ӵ�jfram��LayeredPane����
          imgLabel.setBounds(0,0,img.getIconWidth(), img.getIconHeight());//���ñ�����ǩ��λ��
          Container cp=this.getContentPane();
          cp.setLayout(new BorderLayout());
          ((JPanel)cp).setOpaque(false); //ע����������������Ϊ͸��������LayeredPane����еı���������ʾ������
   }
	
}
