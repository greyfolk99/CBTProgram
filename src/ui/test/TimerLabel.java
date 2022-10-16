package ui.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

public class TimerLabel extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 타이머 관련
	private Timer timer;
	private int hour, min, sec;
	
	/** JLabel 클래스 상속, 생성 파라미터 int 시험시간(분) **/
	TimerLabel(int min){
		this.sec = min * 60;
		timerStart();
	}
	
	public String secToString(int sec) {
		hour = sec / 3600;
		min = sec % 3600 / 60;
		sec = sec % 3600 % 60;

		String str = "";
		if (hour < 10) {
			str += "0";
		}
		str += hour + ":";
		if (min < 10) {
			str += "0";
		}
		str += min + ":";
		if (sec < 10) {
			str += "0";
		}
		str += sec;
		return str;
	}

	void timerStart() {
		timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				--sec;
				if (sec > 0) setText(secToString(sec));
				else setText("시간 초과");
			}
		});
		timer.start();
	}

	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getSec() {
		return sec;
	}
	public void setSec(int sec) {
		this.sec = sec;
	}
	
	
}
