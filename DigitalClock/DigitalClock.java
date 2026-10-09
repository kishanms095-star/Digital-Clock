import javax.swing.*;
import java.text.*;
import java.util.*;
import java.awt.*;

class DigitalClock extends JFrame
{
    JLabel l1;
    JLabel l2;

    SimpleDateFormat timeFormat = new SimpleDateFormat();
    SimpleDateFormat dateFormat = new SimpleDateFormat();

    DigitalClock(String s1)
    {
        super(s1);
    }

    DigitalClock(){}

    void setComponents()
    {
        // Time Label
        l1 = new JLabel("Time");

        l1.setFont(new Font("Verdana", Font.BOLD, 28));
        l1.setForeground(new Color(0,255,255));
        l1.setHorizontalAlignment(JLabel.CENTER);

        add(l1);
        l1.setBounds(50,150,400,60);


        // Date Label
        l2 = new JLabel("Date");

        l2.setFont(new Font("Verdana", Font.BOLD, 20));
        l2.setForeground(new Color(0,255,255));
        l2.setHorizontalAlignment(JLabel.CENTER);

        add(l2);
        l2.setBounds(50,210,400,50);


        // Date and Time Formats
        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        dateFormat = new SimpleDateFormat("EEEE, dd MMMM yyyy");

        setTime();
    }

    public void setTime()
    {
        String time;
        String date;

        while(true)
        {
            time = timeFormat.format(Calendar.getInstance().getTime());
            date = dateFormat.format(Calendar.getInstance().getTime());

            l1.setText(time);
            l2.setText(date);

            try
            {
                Thread.sleep(1000);
            }
            catch(Exception e1){}
        }
    }

    public static void main(String[] args)
    {
        DigitalClock d1 = new DigitalClock("Digital Clock");

        d1.setVisible(true);
        d1.setSize(500,500);
        d1.setLayout(null);

        d1.getContentPane().setBackground(new Color(10,10,40));

        d1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        d1.setComponents();
    }
}