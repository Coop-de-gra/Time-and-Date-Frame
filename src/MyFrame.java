import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class MyFrame extends JFrame {

   Calendar calendar;
   SimpleDateFormat timeFormat;
   SimpleDateFormat dayFormat;
   JLabel timeLabel;
   JLabel dayLabel;

   String time;
   String day;

    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My Clock");
        this.setLayout(new FlowLayout());
        this.setSize(350,150);
        this.setResizable(false);

        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        dayFormat = new SimpleDateFormat("EEE, MMM d, yyyy");

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Verdanda",Font.PLAIN,50));
        timeLabel.setForeground(Color.BLACK);
        timeLabel.setBackground(Color.BLACK);
        timeLabel.setOpaque(false);

        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Verdanda",Font.PLAIN,25));

        this.add(timeLabel);
        this.add(dayLabel);
        this.setVisible(true);

        setTime();
    }

    public void setTime(){
        while (true) {
            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);

            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);

            try {
                Thread.sleep(1000);
            }
                catch (InterruptedException e){
                e.printStackTrace();
                }
        }
    }
}
