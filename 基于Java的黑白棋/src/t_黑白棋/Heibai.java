package t_黑白棋;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Heibai extends JFrame{
	private  boolean a=true;
	private boolean b=false;
	public static void main(String args[]){ 
		Heibai hb=new Heibai();
		hb.showstartFrame(hb.a);
		
	}
	public void showstartFrame(boolean a){
		JPanel start=new JPanel();
		start.setSize(200,100);
		start.setLayout(new GridBagLayout());
		JButton dan=new JButton("单人游戏");
		JButton shuang=new JButton("双人游戏");
		JButton exit=new JButton("退出游戏");
		Dimension di=new Dimension(100,50);
		dan.setPreferredSize(di);
		shuang.setPreferredSize(di);
		exit.setPreferredSize(di);
		start.setVisible(a);
		start.add(dan);
		start.add(shuang);
		start.add(exit);
		this.setTitle("黑白棋");
		this.add(start,BorderLayout.EAST);
		this.setSize(1000, 650);
		this.setLocationRelativeTo(null);
		this.setVisible(a);
		ActionListener danrende=new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
                start.setVisible(b);
                Heibai m=new Heibai();
                m.showframe1(a);
            }  
        };
        dan.addActionListener(danrende);
        ActionListener shuangren=new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
                start.setVisible(b);
                Heibai m=new Heibai();
                m.showframe(a);
            }  
        };
        shuang.addActionListener(shuangren);
        ActionListener tuichu=new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
                System.exit(0);
            }  
        };
        exit.addActionListener(tuichu);
	}
	public void showframe(boolean a){  
        //--------------------游戏界面----------------------  
        JPanel gamejp=new JPanel();  
        //--------------------组件界面----------------------  
        JPanel buttonjp=new JPanel();  
        //按钮图标  
        ImageIcon baizi=new ImageIcon("image/阿狸.png");  
        ImageIcon heizi=new ImageIcon("image/桃子.png");  
        ImageIcon baizi1=new ImageIcon("image/阿狸1.png");  
        ImageIcon heizi1=new ImageIcon("image/桃子1.png");  
        JButton baizibu=new JButton(baizi);  
        JButton heizibu=new JButton(heizi);  
        baizibu.setRolloverIcon(baizi1);  
        heizibu.setRolloverIcon(heizi1);  
        baizibu.setPressedIcon(baizi1);  
        heizibu.setPressedIcon(heizi1);  
        Dimension di=new Dimension(100,100);  
        baizibu.setPreferredSize(di);  
        heizibu.setPreferredSize(di);  
        //-----------------------当前下棋的人---------------------  
        final JLabel jilu=new JLabel("  白子下  ");  
        //设置字体  
        Font jilufont=new Font("黑体",Font.BOLD,30);  
        jilu.setFont(jilufont);  
        //用来记录阿狸与桃子的数目  
        final JLabel baizila=new JLabel("2");  
        final JLabel heizila=new JLabel("2");  
        //设置Label的字体和大小  
        Font font=new Font("宋体",Font.BOLD,42);  
        baizila.setFont(font);  
        heizila.setFont(font);  
        //-----------------重新开局的方法------------------  
        ImageIcon img=new ImageIcon("image/restart.jpg");  
        JButton bu=new JButton(img);  
        bu.setPreferredSize(new Dimension(100,40));  
        buttonjp.add(jilu);  
        buttonjp.add(baizibu);  
        buttonjp.add(baizila);  
        buttonjp.add(heizibu);  
        buttonjp.add(heizila);  
        buttonjp.add(bu);  
        this.setLayout(new GridLayout(1,2,600,0));  
        this.add(gamejp);  
        this.add(buttonjp);  
        this.setTitle("黑白棋");  
        this.setSize(1000,650);  
        this.setResizable(false);  
        this.setLocationRelativeTo(null);  
        this.setDefaultCloseOperation(3);  
        //显示窗口  
        this.setVisible(a);  
        //获取画布权限  
        Graphics g=this.getGraphics();  
        chess[3][3]=1;  
        chess[4][4]=1;  
        chess[3][4]=2;  
        chess[4][3]=2;  
        ChessListener lis=new ChessListener(g,this,jilu,baizila,heizila);  
        this.addMouseListener(lis);  
        //按钮监听器----------------重新开始  
        ActionListener bulis=new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                clear();  
                //重绘的方法  
                repaint();  
                //绘制初始的四个图片  
                chess[3][3]=1;  
                chess[4][4]=1;  
                chess[3][4]=2;  
                chess[4][3]=2;  
                //将状态改为初始状态  
                ChessListener.stata=2;  
                jilu.setText("  白子下  ");  
                baizila.setText("2");  
                heizila.setText("2");  
            }  
        };  
        //如果点击白子则白子下  
        ActionListener alilis=new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                ChessListener.stata=1;  
                jilu.setText("  白子下  ");  
            }  
        };  
        //如果点击黑子则黑子下  
        ActionListener taozilis=new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                ChessListener.stata=2;  
                jilu.setText("  黑子下  ");  
            }  
        };  
        baizibu.addActionListener(alilis);  
        heizibu.addActionListener(taozilis);  
        bu.addActionListener(bulis);  
    }  
	public void showframe1(boolean a){  
        //--------------------游戏界面----------------------  
        JPanel gamejp=new JPanel();  
        //--------------------组件界面----------------------  
        JPanel buttonjp=new JPanel();  
        //按钮图标  
        ImageIcon baizi=new ImageIcon("image/阿狸.png");  
        ImageIcon heizi=new ImageIcon("image/桃子.png");  
        ImageIcon baizi1=new ImageIcon("image/阿狸1.png");  
        ImageIcon heizi1=new ImageIcon("image/桃子1.png");  
        JButton baizibu=new JButton(baizi);  
        JButton heizibu=new JButton(heizi);  
        baizibu.setRolloverIcon(baizi1);  
        heizibu.setRolloverIcon(heizi1);  
        baizibu.setPressedIcon(baizi1);  
        heizibu.setPressedIcon(heizi1);  
        Dimension di=new Dimension(100,100);  
        baizibu.setPreferredSize(di);  
        heizibu.setPreferredSize(di);  
        //-----------------------当前下棋的人---------------------  
        final JLabel jilu=new JLabel("  白子下  ");  
        //设置字体  
        Font jilufont=new Font("黑体",Font.BOLD,30);  
        jilu.setFont(jilufont);  
        //用来记录阿狸与桃子的数目  
        final JLabel baizila=new JLabel("2");  
        final JLabel heizila=new JLabel("2");  
        //设置Label的字体和大小  
        Font font=new Font("宋体",Font.BOLD,42);  
        baizila.setFont(font);  
        heizila.setFont(font);  
        //-----------------重新开局的方法------------------  
        ImageIcon img=new ImageIcon("image/restart.jpg");  
        JButton bu=new JButton(img);  
        bu.setPreferredSize(new Dimension(100,40));  
        buttonjp.add(jilu);  
        buttonjp.add(baizibu);  
        buttonjp.add(baizila);  
        buttonjp.add(heizibu);  
        buttonjp.add(heizila);  
        buttonjp.add(bu);  
        this.setLayout(new GridLayout(1,2,600,0));  
        this.add(gamejp);  
        this.add(buttonjp);  
        this.setTitle("黑白棋");  
        this.setSize(1000,650);  
        this.setResizable(false);  
        this.setLocationRelativeTo(null);  
        this.setDefaultCloseOperation(3);  
        //显示窗口  
        this.setVisible(a);  
        //获取画布权限  
        Graphics g=this.getGraphics();  
        chess[3][3]=1;  
        chess[4][4]=1;  
        chess[3][4]=2;  
        chess[4][3]=2;  
        ChessListener1 lis=new ChessListener1(g,this,jilu,baizila,heizila);  
        this.addMouseListener(lis);  
        //按钮监听器----------------重新开始  
        ActionListener bulis=new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                clear();  
                //重绘的方法  
                repaint();  
                //绘制初始的四个图片  
                chess[3][3]=1;  
                chess[4][4]=1;  
                chess[3][4]=2;  
                chess[4][3]=2;  
                //将状态改为初始状态  
                ChessListener.stata=2;  
                jilu.setText("  白子下  ");  
                baizila.setText("2");  
                heizila.setText("2");  
            }  
        };  
        //如果点击黑子则黑子下   
        bu.addActionListener(bulis);  
    }  
    /** 
     * 清空棋盘的方法 
     */
    public void clear(){  
        for(int i=0;i<chess.length;i++){  
            for(int j=0;j<chess[i].length;j++){  
                chess[i][j]=0;  
            }  
        }  
    }  
    /** 
     * 重写父类的paint方法 
     */
    public void paint(Graphics g){  
        super.paint(g);  
        Image back=new ImageIcon("image/1.jpg").getImage();  
        g.drawImage(back, 10,30,650,600, null);  
        //重绘棋盘  
        //划横线  
      for(int i=0;i<rows;i++){  
          g.setColor(Color.BLUE);  
         g.drawLine(x,y+i*size,x+size*(rows-1),y+i*size);  
      }  
     //划竖线  
      for(int j=0;j<cols;j++){  
          g.setColor(Color.BLUE);  
          g.drawLine(x+j*size,y,x+j*size,y+size*(cols-1));  
      }  
        //绘制棋子  
        for(int i=0;i<rows-1;i++){  
            for(int j=0;j<cols-1;j++){  
                int X=x+size/2+size*i;//棋子的横坐标  
                int Y=y+size/2+size*j;//棋子的纵坐标  
                if(chess[i][j]==1){  
                    //画白棋  
                    Image b=new ImageIcon("image/阿狸1.PNG").getImage();  
                    g.drawImage(b, X-Chess_size/2, Y-Chess_size/2, Chess_size, Chess_size, null);  
                    //g.fillOval(X-size/2,Y-size/2,Chess_size,Chess_size);  
                }  
                else if(chess[i][j]==2){  
                    //画黑棋  
                    Image w=new ImageIcon("image/桃子1.PNG").getImage();  
                    g.drawImage(w, X-Chess_size/2, Y-Chess_size/2, Chess_size, Chess_size, null);  
                    //g.fillOval(X-size/2,Y-size/2,Chess_size,Chess_size);  
                }  
            }  
        }  
    }
    
	
	public final static int x=79;   //棋盘初始点横坐标  
    public final static int y=83;   //棋盘初始点纵坐标  
    public final static int rows=9; //棋盘行数  
    public final static int cols=9; //棋盘列数  
    public final static int size=61;//棋盘格子大小  
    public final static int Chess_size=56;//棋子大小  
    public final static int chess[][]=new int[rows-1][cols-1];//定义一个8*8的数组
}