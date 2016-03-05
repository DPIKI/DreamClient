package ki13dpi.dreambarclient61.Logic;

import android.app.Application;

/**
 * Created by prog1 on 01.03.2016.
 */
public class InitApp extends Application {
    @Override
    public void onCreate(){
        super.onCreate();
        Singleton.initInstance();
    }
}
