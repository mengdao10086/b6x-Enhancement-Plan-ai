package com.umeng.socialize.net.dplus.cache1;

import ag.c;
import android.text.TextUtils;
import com.flydigi.data.DataConstant;
import com.umeng.socialize.utils.ContextUtil;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class DplueCache {
    private static JSONObject a(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        return (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("content")) == null) ? new JSONObject() : jSONObjectOptJSONObject.optJSONObject("share");
    }

    public static boolean deleteFile(File file) {
        return file.delete();
    }

    public static String getFileName() {
        return "dpluscache";
    }

    public static File getFilePath(String str) {
        if (ContextUtil.getContext() == null) {
            return null;
        }
        String packageName = ContextUtil.getContext().getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append("data");
        sb2.append(str2);
        sb2.append("data");
        sb2.append(str2);
        sb2.append(packageName);
        sb2.append(str2);
        sb2.append(DataConstant.FOLDER_FILE);
        sb2.append(str2);
        sb2.append(str);
        String string = sb2.toString();
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        File file = new File(string);
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        return null;
    }

    public static String readFile(File file) throws Throwable {
        Throwable th2;
        BufferedReader bufferedReader;
        Exception e10;
        StringBuilder sb2;
        if (!file.exists()) {
            return "";
        }
        try {
            sb2 = new StringBuilder();
            bufferedReader = new BufferedReader(new InputStreamReader(ContextUtil.getContext().openFileInput(file.getName())));
        } catch (Exception e11) {
            e10 = e11;
            bufferedReader = null;
        } catch (Throwable th3) {
            th2 = th3;
            bufferedReader = null;
        }
        while (true) {
            try {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    sb2.append(line);
                } catch (Exception e12) {
                    e10 = e12;
                    SLog.error(UmengText.CACHE.CACHEFILE, e10);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e13) {
                            SLog.error(UmengText.CACHE.CACHEFILE, e13);
                        }
                    }
                    return "";
                }
            } catch (Throwable th4) {
                th2 = th4;
            }
            th2 = th4;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e14) {
                    SLog.error(UmengText.CACHE.CACHEFILE, e14);
                }
            }
            throw th2;
        }
        String string = sb2.toString();
        try {
            bufferedReader.close();
        } catch (Exception e15) {
            SLog.error(UmengText.CACHE.CACHEFILE, e15);
        }
        return string;
    }

    public static boolean save(JSONObject jSONObject, File file) throws Throwable {
        if (!file.exists()) {
            file.createNewFile();
            return a(jSONObject.toString(), file);
        }
        return a(readFile(file) + c.f654g + jSONObject, file);
    }

    private static boolean a(String str, File file) throws Throwable {
        BufferedWriter bufferedWriter;
        BufferedWriter bufferedWriter2 = null;
        try {
            try {
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(ContextUtil.getContext().openFileOutput(file.getName(), 0)));
            } catch (Exception e10) {
                e = e10;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            bufferedWriter.write(str);
            try {
                bufferedWriter.close();
            } catch (Exception e11) {
                SLog.error(UmengText.CACHE.CLOSE, e11);
            }
            return true;
        } catch (Exception e12) {
            e = e12;
            bufferedWriter2 = bufferedWriter;
            SLog.error(UmengText.CACHE.CACHEFILE, e);
            if (bufferedWriter2 != null) {
                try {
                    bufferedWriter2.close();
                } catch (Exception e13) {
                    SLog.error(UmengText.CACHE.CLOSE, e13);
                }
            }
            return false;
        } catch (Throwable th3) {
            th = th3;
            bufferedWriter2 = bufferedWriter;
            if (bufferedWriter2 != null) {
                try {
                    bufferedWriter2.close();
                } catch (Exception e14) {
                    SLog.error(UmengText.CACHE.CLOSE, e14);
                }
            }
            throw th;
        }
    }
}
