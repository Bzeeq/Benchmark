package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import main.Paint;
import main.Photo;

public class Window extends JFrame
{
	DefaultTableModel tableModel;
	Object[] headers = new String[] {"Computing complex", "First test, seconds", "Second test, seconds", "Third test, seconds", "Index, seconds"};
	Object[][] data = new String[][] {
            {"1. Computing complex","1","2","3","1"},
            {"2. Computing complex","1","2","3","1"},
            {"3. Computing complex","1","2","3","1"},
            {"4. Computing complex","1","2","3","1"},
            {"5. Computing complex","1","2","3","1"},
            {"Your computing complex","1","2","3","1"},
    };
	
	public Window()
	{
		super("Benchmark by Bzeeq");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(headers);
		for (int i = 0; i < data.length; i++)
			tableModel.addRow(data[i]);
		JLabel label1 = new JLabel("Benchmark card");
		JLabel label2 = new JLabel("Normaliz benchmark card");
	    JTable table1 = new JTable(tableModel);
	    JTable table2 = new JTable(data, headers);
	    Box contents = new Box(BoxLayout.Y_AXIS);
	    contents.add(label1);
	    contents.add(new JScrollPane(table1));
	    contents.add(label2);
	    contents.add(new JScrollPane(table2));
	    getContentPane().add(contents);
	    Paint paint = new Paint();
	    JButton button_start = new JButton("Начать");
	    button_start.addActionListener(new ActionListener() {
	    	 public void actionPerformed(ActionEvent e)
	    	 {
	    		DecimalFormat df = new DecimalFormat("#.####");
	    		df.setRoundingMode(RoundingMode.CEILING);
	    		String name;
	    		double startTime, endTime, firstTime = 0, secondTime = 0;
	    		for (int i = 0; i < 10000000; i++)
	    		{
	    			firstTime += QuickSort.assignment();
	    		}
	    		firstTime /= 1000000000.0;
	    		for (int i = 0; i < 10; i++)
	    		{
	    			name = "resources/" + i + ".JPG";
	    			startTime = System.nanoTime();
	    			try
	    			{
	    				Photo image = new Photo(name);
					} 
	    			catch (IOException e1)
	    			{}
	    			endTime = System.nanoTime();
	    			secondTime += (endTime - startTime);
	    		}
	    		secondTime /= 1000000000.0;
	    		tableModel.setValueAt(df.format(firstTime), 5, 1);
	    		tableModel.setValueAt(df.format(secondTime), 5, 2);
	    		tableModel.setValueAt(df.format(paint.fullTime), 5, 3);
	    		tableModel.setValueAt(df.format(Math.sqrt(firstTime * secondTime * paint.fullTime)), 5, 4);
	    	 }
	    });
	    JPanel buttons = new JPanel();
	    buttons.add(button_start);
	    getContentPane().add(buttons, "South");
	    setResizable(false);
	    setSize(750, 350);
	    setVisible(true);
	}
}
