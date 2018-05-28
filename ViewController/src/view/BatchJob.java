package view;
import commonj.timers.CancelTimerListener;
import commonj.timers.Timer;
import commonj.timers.TimerListener;

import java.io.Serializable;


import model.AppModuleImpl;

import oracle.jbo.client.Configuration;

public class BatchJob implements Serializable,TimerListener,CancelTimerListener{
    String pName;
    
    public BatchJob(String pName) {
        this.pName = pName;
    }
    @Override
    public void timerExpired(Timer timer) {
        String  amDef = "model.AppModule";
        String  config = "AppModuleScheduler";
        AppModuleImpl am = (AppModuleImpl)Configuration.createRootApplicationModule(amDef, config);
        
        am.startProcess(pName);
        
        Configuration.releaseRootApplicationModule(am, true);
        timer.cancel();
            
    }

    @Override
    public void timerCancel(Timer timer) {
        // TODO Implement this method
    }
}
