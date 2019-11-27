package com.rcb.financialservice.crash;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.util.Log;

import androidx.annotation.NonNull;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CrashHandler implements Thread.UncaughtExceptionHandler {
    private Context mContext ;
    private Thread.UncaughtExceptionHandler mUncaughtExceptionHandler;
    public void init(Context context) {

        try {
            if (context == null)
                throw new NullPointerException("Application 的Context不能为空");

            this.mContext = context;

            /**
             * 获取系统默认的异常处理类
             */
            mUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();

            /**
             * 使用当前的类为异常处理类
             */
            Thread.setDefaultUncaughtExceptionHandler(this);
        }catch (Exception e){
        }

    }

    @Override
    public void uncaughtException(@NonNull Thread thread, @NonNull Throwable throwable) {
        try {

            /**
             * hanlderException此方法是是否处理异常日志，如果处理那么就返回tru              * e，如果处理遇到问题那么就返回false，交由系统默认处理
             **/
            if (!hanlderException(throwable) && mUncaughtExceptionHandler != null) {

                /**
                 * 如果此异常不处理则由系统自己处理
                 */
                this.mUncaughtExceptionHandler.uncaughtException(thread, throwable);

            }else{

                /**
                 * 可以延迟一秒钟在退出
                 */
//                Thread.sleep(1000);
                //如果开发者自己处理一场那么就自己处理，这里我处理的是退出进程
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);

            }
        }catch (Exception ex) {
        }
    }



    /**
     * 用户处理异常日志
     * @param throwable
     * @return
     */
    private boolean hanlderException(Throwable throwable) {

        try {

            if (throwable == null)
                return false;


            /**
             * 收集应用信息
             */
          HashMap<String,String> logMap =  collectCrashLogInfo(mContext);
            /**
             * 将日志写入文件
             */
            writerCrashLogToFile(throwable,logMap);

        } catch (Exception e) {
        }
        return false;
    }



    /**
     * 获取应用信息
     *
     * @param mContext
     */
    private HashMap<String, String> collectCrashLogInfo(Context mContext) {

        HashMap<String, String> crashAppLog = new HashMap<>();
        try {
            if (mContext == null)
                return crashAppLog;

            PackageManager packageManager = mContext.getPackageManager();

            if (packageManager != null) {

                PackageInfo packageInfo = packageManager.getPackageInfo(mContext.getPackageName(), PackageManager.GET_ACTIVITIES);

                if (packageInfo != null) {

                    String versionName = packageInfo.versionName;
                    String versionCode = "" + packageInfo.versionCode;
                    String packName = packageInfo.packageName;

                    crashAppLog.put("versionName", versionName);
                    crashAppLog.put("versionCode", versionCode);
                    crashAppLog.put("packName", packName);

                }
            }


            /**
             * 获取手机型号，系统版本，以及SDK版本
             */
            crashAppLog.put("手机型号:", Build.MODEL);
            crashAppLog.put("系统版本", "" + Build.VERSION.SDK);
            crashAppLog.put("Android版本", Build.VERSION.RELEASE);

            Field[] fields = Build.class.getFields();

            if (fields != null && fields.length > 0) {

                for (Field field : fields) {

                    if (field != null) {

                        field.setAccessible(true);

                        crashAppLog.put(field.getName(), field.get(null).toString());
                    }
                }
            }

        } catch (Exception e) {

        }
        return crashAppLog;
    }

    /**
     * 写入文件中
     *
     * @param ex
     */
    private void writerCrashLogToFile(Throwable ex, HashMap<String, String> crashAppLog) {

        try {

            StringBuffer buffer = new StringBuffer();

            if (crashAppLog != null && crashAppLog.size() > 0) {

                for (Map.Entry<String, String> entry : crashAppLog.entrySet()) {

                    buffer.append(entry.getKey() + ":" + entry.getValue() + "\n");
                }
            }

            Writer writer = new StringWriter();
            PrintWriter printWriter = new PrintWriter(writer);
            ex.printStackTrace(printWriter);
            Throwable cause = ex.getCause();

            while (cause != null) {
                cause.printStackTrace(printWriter);
                cause = cause.getCause();
            }

            printWriter.flush();
            printWriter.close();

            String result = writer.toString();

            buffer.append("Exception:+\n");

            buffer.append(result);

            writerToFile(buffer.toString());

        } catch (Exception e) {
        }
    }


    //将文件写入

    private void writerToFile(String s) {

        try {
            /**
             * 创建日志文件名称
             */
            String curtTimer = "" + System.currentTimeMillis();

            DateFormat formate = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
            String timer = formate.format(new Date());

            String fileName = "crash-" + timer + "-" + curtTimer + ".txt";

            String root = Environment.getExternalStorageDirectory().getAbsoluteFile() + File.separator + "CrashLog";
            File folder = new File(root);
            if (!folder.exists() && !folder.mkdirs()) {
                return;
            }


            /**
             * 创建日志文件
             */
            File file = new File(folder.getAbsolutePath() + File.separator + fileName);

            if (!file.exists())
                file.createNewFile();

            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(s);
            bufferedWriter.flush();
            bufferedWriter.close();
            Log.i("CrashHandler",
                "==== creash write crash log into file "+ file.getAbsolutePath()
            );

        } catch (Exception e) {
        }
    }


}
