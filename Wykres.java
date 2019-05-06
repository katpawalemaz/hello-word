package lab8;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Wykres extends JFrame {
	
	JRadioButton sinx;
	JRadioButton cosx;
	JRadioButton x;
	JRadioButton wielomian;
	JRadioButton exp;
	
	ButtonGroup buttonGroup;
	JPanel panelWybor;
	
	XYSeries series=new XYSeries("Nazwa serii");
	XYSeriesCollection dataset=new XYSeriesCollection();
	
	Wykres(){
		this.setSize(1000,550);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		this.setTitle("Rysowanie");
		
		
		JRadioButton sinx=new JRadioButton("sinx");
		JRadioButton cosx=new JRadioButton("cosx");
		JRadioButton x=new JRadioButton("x");
		JRadioButton wielomian=new JRadioButton("x^2+3");
		JRadioButton exp=new JRadioButton("exp");
		
		ButtonGroup buttonGroup=new ButtonGroup();
		
		buttonGroup.add(sinx);
		buttonGroup.add(cosx);
		buttonGroup.add(x);
		buttonGroup.add(wielomian);
		buttonGroup.add(exp);
		sinx.setSelected(true);
		
		
		
		
		sinx.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				series.clear();
				funkcjaSin();
				
			}

			
		});
		
		cosx.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				series.clear();
				funkcjaCos();
				
			}
		});
		
		x.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				series.clear();
				funkcjaX();
				
			}
		});
		
		wielomian.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				series.clear();
				funkcjaWielomian();
				
			}
		});
		
		exp.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				series.clear();
				funkcjaExp();
				
			}
		});
		
		JPanel panelWybor=new JPanel(new GridLayout(10,1));
		
		
		
	
		
		panelWybor.add(new JLabel("Wybór wykresu"));
		panelWybor.add(sinx);
		panelWybor.add(cosx);
		panelWybor.add(x);
		panelWybor.add(exp);
		panelWybor.add(wielomian);
		this.add(panelWybor,BorderLayout.LINE_END);
		
		JFreeChart chart=ChartFactory.createXYLineChart("Wykres XY","X","Y",dataset,PlotOrientation.VERTICAL,true,true,false);
		
		ChartPanel chartPanel=new ChartPanel(chart);
	    this.getContentPane().add(chartPanel);
		
		
	}
	
	private void funkcjaSin()
	{
		for(double i=0;i<20;i+=0.2)
		{
			double sinx=Math.sin(i);
			series.add(i,sinx);
		}
		dataset.addSeries(series);
	}
	
	private void funkcjaCos()
	{
		for(double i=0;i<20;i+=0.2)
		{
			double cosx=Math.cos(i);
			series.add(i,cosx);
		}
		dataset.addSeries(series);
	}
	
	private void funkcjaX()

	{
		for(double i=0;i<20;i+=0.2)
		{
			double x=i;
			series.add(i,x);
		}
		dataset.addSeries(series);
	}

	private void funkcjaWielomian()
	{
		for(double i=-10;i<10;i+=0.2)
		{
			double x=i;
			double y=x*x+3;
			series.add(i,y);
		}
		dataset.addSeries(series);
	}
	
	private void funkcjaExp()
	{
		for(double i=0;i<5;i+=0.2)
		{
			double expx=Math.exp(i);
			series.add(i,expx);
		}
		dataset.addSeries(series);
	}
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater
		(
		    new Runnable(){
		    	public void run() {
		    		Wykres w=new Wykres();
		    		w.setVisible(true);
		    	}
		    });
		
	}
	
	
	
	

	
}
