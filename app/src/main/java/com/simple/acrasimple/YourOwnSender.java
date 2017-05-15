package com.simple.acrasimple;


import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import org.acra.collector.CrashReportData;
import org.acra.sender.ReportSender;
import org.acra.sender.ReportSenderException;

/**
 * Created by Administrator on 2017/5/15.
 */

public class YourOwnSender implements ReportSender {
    @Override
    public void send(@NonNull Context context, @NonNull CrashReportData crashReportData) throws ReportSenderException {
        //发送邮件
//        Log.i("YourOwnSender", "send: " + crashReportData.toJSON());
        Mail mail=new Mail("xiaxiayige@163.com","zhangqilin.0000");
        mail.set_to(new String[]{"xiaxiayige@163.com"});//接受者邮箱 可以是多个
        mail.set_from("xiaxiayige@163.com");//邮件来源
        mail.set_subject("错误日志demo");//设置主题标题
        mail.setBody(crashReportData.toString());
        try {
            if( mail.send()){
                Log.i("YourOwnSender", "send: 发送成功");
            }else{
                Log.i("YourOwnSender", "send: 发送失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
