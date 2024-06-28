package main;
import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Stopwatch implements ActionListener {

	JFrame frame = new JFrame();
	JButton startButton = new JButton("START");
	JButton resetButton = new JButton("RESET");
	JLabel timeLabel = new JLabel();
	int elapsedTime = 0;
	int seconds = 0;
	int minutes = 0;
	int hours;
	
	boolean started = false;
	String seconds_string = String.format("%02d", seconds);
	String minutes_string = String.format("%02d", minutes);
	String hours_string = String.format("%02d", hours);
	
	Timer timer = new Timer(1000, new ActionListener() {
		public void actionPerformed(ActionEvent e)
		{
			elapsedTime += 1000;
			hours = elapsedTime/3600000;
			minutes = (elapsedTime/60000) %60;
			seconds = (elapsedTime/1000) % 60;
			
			seconds_string = String.format("%02d", seconds);
			minutes_string = String.format("%02d", minutes);
			hours_string = String.format("%02d", hours);
			timeLabel.setText(hours_string+ ":" +minutes_string + ":" + seconds_string);
			
		}
		
	});
	Stopwatch()
	{
		timeLabel.setText(hours_string + ":" +minutes_string +":" + seconds_string);
	    timeLabel.setBounds(135, 200, 200, 100);
	    timeLabel.setFont(new Font("Verdana", Font.PLAIN, 35));
		timeLabel.setOpaque(false);
		timeLabel.setHorizontalAlignment(JTextField.CENTER);
		
		startButton.setBounds(125, 125, 100, 100);
		startButton.setFont(new Font("Verdana", Font.PLAIN, 20));
		startButton.setFocusable(false);
		startButton.addActionListener(this);
		startButton.setBackground(Color.GREEN);
		
		resetButton.setBounds(250, 125, 100, 100);
		resetButton.setFont(new Font("Verdana", Font.PLAIN, 20));
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		resetButton.setBackground(Color.RED);	
		frame.add(startButton);
		frame.add(resetButton);
		frame.add(timeLabel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==startButton)
		{
			start();
		}
		
		if (e.getSource()==resetButton)
		{
			started=false;
			startButton.setText("START");
			reset();
		}
		
	}

	void start()
	{
		timer.start();
		if(started==false)
		{
			started=true;
			startButton.setText("STOP");
		}
		else 
		{
			started=false;
			startButton.setText("START");
			stop();
		     
		}
	}
	
	void stop()
	{
		timer.stop();
	}
	void reset()
	{
		timer.stop();
		elapsedTime =0;
		seconds = 0;
		minutes = 0;
		hours = 0;
		
		seconds_string = String.format("%02d", seconds);
		minutes_string = String.format("%02d", minutes);
		hours_string = String.format("%02d", hours);
		timeLabel.setText(hours_string+ ":" +minutes_string + ":" + seconds_string);
	}
	
	
	
}
