package threelayer;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Presentation extends JFrame implements ActionListener{
	
	private UserBUS _userBUS;
	
	private JFrame frame = new JFrame("查询");
	private Container c = frame.getContentPane();
	private JTextField input = new JTextField();
	JLabel a1 = new JLabel("输入信息:");
	private JButton ok = new JButton("以雇员名称查询");
	private JButton cancel = new JButton("以雇员ID查询");
	private String empname;
	private String id;
	private JButton Bar=new JButton("统计雇员生日分布");
	private JButton Pie=new JButton("统计雇员所在城市");
	private JButton line=new JButton("产品库存与订单量的关系");
	
	public Presentation()
	{
		_userBUS = new UserBUS();
		frame.setSize(300,300);
		
		c.setLayout(new BorderLayout());
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new FlowLayout());
		titlePanel.add(new JLabel("查询"));
		c.add(titlePanel,"North");
		
		JPanel fieldPanel = new JPanel();
		fieldPanel.setLayout(null);
		
		a1.setBounds(10,20,80,20);;
		fieldPanel.add(a1);
		input.setBounds(80,20,180,20);
		fieldPanel.add(input);
		c.add(fieldPanel,"Center");
		
		Bar.setBounds(70, 60, 140, 20);
		fieldPanel.add(Bar);
		Pie.setBounds(70, 100, 140, 20);
		fieldPanel.add(Pie);
		line.setBounds(70, 140, 140, 20);
		fieldPanel.add(line);
		Bar.addActionListener(this);
		Pie.addActionListener(this);
		line.addActionListener(this);
		
		ok.addActionListener(this);
		cancel.addActionListener(this);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(ok);
		buttonPanel.add(cancel);
		c.add(buttonPanel,"South");
	}
	
	
	public void actionPerformed(ActionEvent e)
	{            
        if(e.getActionCommand()=="以雇员名称查询") 
        {  
        	empname=input.getText();
        	System.out.println(empname);
        	Vector<UserVO> rs=_userBUS.getEmpByName(empname);
        	if(rs.size()==0)
        	{
        		JOptionPane.showMessageDialog(null, "No Match Found!", "消息", JOptionPane.INFORMATION_MESSAGE);
        	}
        	else
        	{
        		new resultJframe().init(rs);
        	}
        	
        }	
        
        if(e.getActionCommand()=="统计雇员生日分布")  
        {
			JFrame frame=new JFrame("统计雇员生日分布");  
			frame.setLayout(new GridLayout(1,2));  
		    frame.add(new BarChart().getChartPanel());           //添加柱形图  
		    frame.setBounds(50, 50, 800, 800);  
		    frame.setVisible(true);
        }
		
		else if(e.getActionCommand()=="统计雇员所在城市")  
        {
			JFrame frame=new JFrame("统计雇员所在城市");  
			frame.setLayout(new GridLayout(1,2));  
		    frame.add(new PieChart().getChartPanel());           //添加饼状图  
		    frame.setBounds(50, 50, 800, 800);  
		    frame.setVisible(true);
        }
		
		else if(e.getActionCommand()=="产品库存与订单量的关系")  
        {
			JFrame frame=new JFrame("产品库存与订单量的关系");  
			frame.setLayout(new GridLayout(1,2));  
		    frame.add(new LineChart().getChartPanel());           //添加折线图
		    frame.setBounds(50, 50, 800, 800);  
		    frame.setVisible(true);
        }
        
        else if(e.getActionCommand()=="以雇员ID查询")  
        { 
        	id=input.getText();
        	System.out.println(id);
        	Vector<UserVO> rs=_userBUS.getEmpById(id);
        	if(rs.size()==0)
        	{
        		JOptionPane.showMessageDialog(null, "No Match Found!", "消息", JOptionPane.INFORMATION_MESSAGE);
        	}
        	else
        	{
        		new resultJframe().init(rs);
        	}
 
        }             
	}
	
	public static void main(String[] args)
	{
		new Presentation();
	}
	
	
}

class BarChart {  
    ChartPanel frame1;  
    public  BarChart(){  
        CategoryDataset dataset = getDataSet();  
        JFreeChart chart = ChartFactory.createBarChart3D(  
                            "统计雇员生日分布", // 图表标题  
                            "月份", // 目录轴的显示标签  
                            "雇员人数", // 数值轴的显示标签  
                            dataset, // 数据集  
                            PlotOrientation.VERTICAL, // 图表方向：水平、垂直  
                            true,           // 是否显示图例(对于简单的柱状图必须是false)  
                            false,          // 是否生成工具  
                            false           // 是否生成URL链接  
                            ); 
         CategoryPlot plot=chart.getCategoryPlot();
         CategoryAxis domainAxis=plot.getDomainAxis(); 
         domainAxis.setLabelFont(new Font("黑体",Font.BOLD,14));
         domainAxis.setTickLabelFont(new Font("宋体",Font.BOLD,12)); 
         ValueAxis rangeAxis=plot.getRangeAxis();//获取柱状  
         rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));  
          chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));  
          chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));       
         frame1=new ChartPanel(chart,true);         
    }  
       private static CategoryDataset getDataSet() 
       {  
           DefaultCategoryDataset dataset = new DefaultCategoryDataset(); 
           UserBUS _userBUS = new UserBUS();
           Vector<UserVO> rs=_userBUS.getPopulationOfBirthdy();
        int i=0;
   		int size=rs.size();
   		while(i<size)
   		{
   			UserVO uservo=new UserVO();
   			uservo=(((UserVO)rs.get(i)));
   			dataset.addValue(uservo.getPopulation(), uservo.getMonth(),"");
   			System.out.println("112");
   			i++;
   		}
   		return dataset;
   		}  
       public ChartPanel getChartPanel()
       {  
    	   return frame1;
       }  
}  

class PieChart {  
    ChartPanel frame1;  
    public PieChart(){  
          DefaultPieDataset data = getDataSet();  
          JFreeChart chart = ChartFactory.createPieChart3D("雇员所在城市统计",data,true,false,false);  
        //设置百分比  
          PiePlot pieplot = (PiePlot) chart.getPlot();  
          DecimalFormat df = new DecimalFormat("0.00%");//获得一个DecimalFormat对象，主要是设置小数问题  
          NumberFormat nf = NumberFormat.getNumberInstance();//获得一个NumberFormat对象  
          StandardPieSectionLabelGenerator sp1 = new StandardPieSectionLabelGenerator("{0}  {2}", nf, df);//获得StandardPieSectionLabelGenerator对象  
          pieplot.setLabelGenerator(sp1);//设置饼图显示百分比  
        
      //没有数据的时候显示的内容  
          pieplot.setNoDataMessage("无数据显示");  
          pieplot.setCircular(false);  
          pieplot.setLabelGap(0.02D);  
        
          pieplot.setIgnoreNullValues(true);//设置不显示空值  
          pieplot.setIgnoreZeroValues(true);//设置不显示负值  
         frame1=new ChartPanel (chart,true);  
          chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体  
          PiePlot piePlot= (PiePlot) chart.getPlot();//获取图表区域对象  
          piePlot.setLabelFont(new Font("宋体",Font.BOLD,10));//解决乱码  
          chart.getLegend().setItemFont(new Font("黑体",Font.BOLD,10));  
    }  
    private static DefaultPieDataset getDataSet() {  
        DefaultPieDataset dataset = new DefaultPieDataset();  
        UserBUS _userBUS = new UserBUS();
        Vector<UserVO> rs=_userBUS.getSupplierOfCity();
        int i=0;
		int size=rs.size();
		while(i<size)
		{
			UserVO uservo=new UserVO();
			uservo=(((UserVO)rs.get(i)));
			dataset.setValue(uservo.getCity(),uservo.getPopulation());
			i++;
		}  
        return dataset;  
}  
    public ChartPanel getChartPanel(){  
        return frame1;  
        }  
} 

class LineChart {  
    ChartPanel frame1;  
    public LineChart(){  
    	DefaultCategoryDataset linedataset = createDataset();  
        JFreeChart chart = ChartFactory.createLineChart("产品库存与订单量的关系", "产品编号", "数量",linedataset,PlotOrientation.VERTICAL,true, true, true);  
        CategoryPlot plot = chart.getCategoryPlot();
        CategoryAxis dateaxis=plot.getDomainAxis(); 
        
        frame1=new ChartPanel(chart,true);  
        dateaxis.setLabelFont(new Font("黑体",Font.BOLD,14));         //水平底部标题  
        dateaxis.setTickLabelFont(new Font("宋体",Font.BOLD,6));  //垂直标题  
        ValueAxis rangeAxis=plot.getRangeAxis();//获取柱状  
        rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));  
        chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));  
        chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体  
  
    }   
     private static DefaultCategoryDataset createDataset()
     {  //这个数据集有点多，但都不难理解  
    	 DefaultCategoryDataset linedataset = new DefaultCategoryDataset();
    	 UserBUS _userBUS = new UserBUS();
         Vector<UserVO> rs=_userBUS.getInStockAndOnOrder();
         int i=0;
 		int size=rs.size();
 		while(i<size)
 		{
 			Vector row = new Vector();
 			UserVO uservo=new UserVO();
 			uservo=(((UserVO)rs.get(i)));
 			linedataset.addValue(uservo.getUnitsInStock(), "库存数量",String.valueOf(uservo.getProductID()));
 			linedataset.addValue(uservo.getUnitsOnOrder(), "订购数量",String.valueOf(uservo.getProductID()));
 			i++;
 		} 
 		  return linedataset; 
     }  
      public ChartPanel getChartPanel()
      {  
            return frame1;  
              
        }  
}

class resultJframe {
	private JFrame jFrame;
	private JPanel jPanel;
	private JTable jTable;
	private JScrollPane jScrollPane;
	public void init(Vector rs) {
		jFrame = new JFrame("查询记录");
		jPanel = new JPanel(new BorderLayout());
		Vector content = new Vector();
		int i=0;
		int size=rs.size();
		while(i<size)
		{
			Vector row = new Vector();
			UserVO uservo=new UserVO();
			uservo=(((UserVO)rs.get(i)));
			row.add(uservo.getidUser());
			row.add(uservo.getfirstname());
			row.add(uservo.getlastname());
			row.add(uservo.getbirthday());
			row.add(uservo.getcity());
			content.add(row);
			i++;
		}
		Vector column = new Vector();
		column.add("ID");
		column.add("firstname");
		column.add("lastname");
		column.add("birthday");
		column.add("city");
		jTable = new JTable(content,column);
		jScrollPane = new JScrollPane(jTable);
		jPanel.add(jScrollPane,BorderLayout.CENTER);
		jFrame.setVisible(true);
		jFrame.setSize(400,250);
		jFrame.setContentPane(jPanel);
		jFrame.setLocationRelativeTo(null);
		jFrame.setAlwaysOnTop(true);
	}
	
}

