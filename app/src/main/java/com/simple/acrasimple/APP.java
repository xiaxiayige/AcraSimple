package com.simple.acrasimple;

import android.app.Application;

import org.acra.ACRA;
import org.acra.ReportField;
import org.acra.annotation.ReportsCrashes;

/**
 * Created by Administrator on 2017/5/15.
 */
@ReportsCrashes(
        reportSenderFactoryClasses ={com.simple.acrasimple.YourOwnSenderfactory.class},
        customReportContent = { ReportField.APP_VERSION_CODE, ReportField.APP_VERSION_NAME, ReportField.ANDROID_VERSION, ReportField.PHONE_MODEL, ReportField.CUSTOM_DATA, ReportField.STACK_TRACE, ReportField.LOGCAT },
        resToastText = R.string.msg_acra_toast
)
public class APP extends Application {
    @Override
    public void onCreate() {
        ACRA.init(this);
        super.onCreate();
    }
}
