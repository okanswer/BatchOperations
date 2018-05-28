package view;

import javax.faces.event.ActionEvent;


import javax.naming.InitialContext;

import javax.naming.NamingException;


import commonj.timers.TimerManager;

public class Scheduler{
    public Scheduler() {
    }

    public void startTask(ActionEvent actionEvent) throws NamingException {
        try{
            InitialContext ic = new InitialContext();
            TimerManager tm = (TimerManager)ic.lookup("java:comp/env/tm/TimerManager");
            
            
            tm.schedule(new BatchJob("Task 1"),0);
            
        }catch(NamingException ne){
            ne.printStackTrace();
        }
    }

    public void startTask2(ActionEvent actionEvent) {
        try{
            InitialContext ic = new InitialContext();
            TimerManager tm = (TimerManager)ic.lookup("java:comp/env/tm/TimerManager");
            
            
            tm.schedule(new BatchJob("Task 2"),0);
            
        }catch(NamingException ne){
            ne.printStackTrace();
        }
    }
}
