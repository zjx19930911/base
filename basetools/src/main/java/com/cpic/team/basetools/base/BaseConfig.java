package com.cpic.team.basetools.base;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.wanjian.cockroach.Cockroach;

/**
 * Created by Administrator on 2017/2/6 0006.
 */

public class BaseConfig {

    public static Context context;
    public static String MainColor = "#ffffff";
    public static String URL = "";
    public static String User = "";
    public static String Key = "";
    public static String Name = "";
    public static Boolean isrelease = false;

    public static void init(Context appContext, String mainColor, Boolean isRelease) {
        context = appContext;
        MainColor = mainColor;
        isrelease = isRelease;
        setCrash(isrelease);
    }

    public static void setAliOss(String url, String user, String key, String name) {
        URL = url;
        User = user;
        Key = key;
        Name = name;
    }


    public static void setCrash(Boolean isRelease) {
        if (isRelease) {
            Cockroach.install(new Cockroach.ExceptionHandler() {
                // handlerException内部建议手动try{  你的异常处理逻辑  }catch(Throwable e){ } ，以防handlerException内部再次抛出异常，导致循环调用handlerException

                @Override
                public void handlerException(final Thread thread, final Throwable throwable) {
                    //开发时使用Cockroach可能不容易发现bug，所以建议开发阶段在handlerException中用Toast谈个提示框，
                    //由于handlerException可能运行在非ui线程中，Toast又需要在主线程，所以new了一个new Handler(Looper.getMainLooper())，
                    //所以千万不要在下面的run方法中执行耗时操作，因为run已经运行在了ui线程中。
                    //new Handler(Looper.getMainLooper())只是为了能弹出个toast，并无其他用途
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                //建议使用下面方式在控制台打印异常，这样就可以在Error级别看到红色log
//                            Log.e("AndroidRuntime","--->CockroachException:"+thread+"<---",throwable);
//                            Toast.makeText(MyApplication.this, "Exception Happend\n" + thread + "\n" + throwable.toString(), Toast.LENGTH_SHORT).show();
//                        throw new RuntimeException("..."+(i++));
                            } catch (Throwable e) {

                            }
                        }
                    });
                }
            });
        }
    }

}
