package Clock;

import java.text.SimpleDateFormat;
import java.util.*;
import orders.Orders;
 
public class Clock extends TimerTask
{
    private Orders obj;
    SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss a"); 
    @Override
    public void run()
    {
       String TIME = timeFormat.format(Calendar.getInstance().getTime());        
        this.obj.getCurrentTime().setText(TIME);
        this.obj.getCurrentTime1().setText(TIME);
        this.obj.getCurrentTime2().setText(TIME);
    
    }
    public Clock(Orders o){
    this.obj = o;
    }
}