package com.tencent.open.utils;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, g> f22809a = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f22810b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f22811c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f22812d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private JSONObject f22813e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f22814f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f22815g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f22816h = true;

    private g(Context context, String str) {
        this.f22811c = null;
        this.f22812d = null;
        this.f22811c = context.getApplicationContext();
        this.f22812d = str;
        a();
        b();
    }

    private void b() {
        if (this.f22815g != 0) {
            d("update thread is running, return");
            return;
        }
        this.f22815g = 1;
        final HashMap map = new HashMap();
        map.put("appid", this.f22812d);
        map.put("status_os", Build.VERSION.RELEASE);
        map.put("status_machine", Build.MODEL);
        map.put("status_version", Build.VERSION.SDK);
        map.put(SocializeProtocolConstants.PROTOCOL_KEY_VERSION, Constants.SDK_VERSION);
        map.put("sdkp", "a");
        j.a(new Runnable() { // from class: com.tencent.open.utils.g.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.tencent.open.a.b bVarA = com.tencent.open.a.a.a().a("https://cgi.connect.qq.com/qqconnectopen/openapi/policy_conf", map);
                    String strA = bVarA.a();
                    SLog.i("openSDK_LOG.OpenConfig", "update: get config statusCode " + bVarA.d());
                    g.this.a(k.d(strA));
                } catch (Exception e10) {
                    SLog.e("openSDK_LOG.OpenConfig", "get config error ", e10);
                }
                g.this.f22815g = 0;
            }
        });
    }

    private String c(String str) {
        InputStream inputStreamOpen;
        String str2;
        String string = "";
        try {
            try {
                if (this.f22812d != null) {
                    str2 = str + j3.b.f36044h + this.f22812d;
                } else {
                    str2 = str;
                }
                inputStreamOpen = this.f22811c.openFileInput(str2);
            } catch (IOException e10) {
                e10.printStackTrace();
                return "";
            }
        } catch (FileNotFoundException unused) {
            inputStreamOpen = this.f22811c.getAssets().open(str);
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen, Charset.forName("UTF-8")));
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            try {
                try {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        stringBuffer.append(line);
                    } catch (IOException e11) {
                        e11.printStackTrace();
                    }
                } catch (IOException e12) {
                    e12.printStackTrace();
                    inputStreamOpen.close();
                    bufferedReader.close();
                }
                return string;
            } catch (Throwable th2) {
                try {
                    inputStreamOpen.close();
                    bufferedReader.close();
                } catch (IOException e13) {
                    e13.printStackTrace();
                }
                throw th2;
            }
        }
        string = stringBuffer.toString();
        inputStreamOpen.close();
        bufferedReader.close();
        return string;
    }

    private void d(String str) {
        if (this.f22816h) {
            SLog.v("openSDK_LOG.OpenConfig", str + "; appid: " + this.f22812d);
        }
    }

    public static g a(Context context, String str) {
        g gVar;
        synchronized (f22809a) {
            SLog.v("openSDK_LOG.OpenConfig", "getInstance begin");
            if (str != null) {
                f22810b = str;
            }
            if (str == null && (str = f22810b) == null) {
                str = "0";
            }
            gVar = f22809a.get(str);
            if (gVar == null) {
                gVar = new g(context, str);
                f22809a.put(str, gVar);
            }
            SLog.v("openSDK_LOG.OpenConfig", "getInstance end");
        }
        return gVar;
    }

    public boolean b(String str) {
        d("get " + str);
        c();
        Object objOpt = this.f22813e.opt(str);
        if (objOpt == null) {
            return false;
        }
        if (objOpt instanceof Integer) {
            return !objOpt.equals(0);
        }
        if (objOpt instanceof Boolean) {
            return ((Boolean) objOpt).booleanValue();
        }
        return false;
    }

    private void a() {
        try {
            this.f22813e = new JSONObject(c("com.tencent.open.config.json"));
        } catch (JSONException unused) {
            this.f22813e = new JSONObject();
        }
    }

    private void a(String str, String str2) {
        try {
            if (this.f22812d != null) {
                str = str + j3.b.f36044h + this.f22812d;
            }
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.f22811c.openFileOutput(str, 0), Charset.forName("UTF-8"));
            outputStreamWriter.write(str2);
            outputStreamWriter.flush();
            outputStreamWriter.close();
        } catch (IOException e10) {
            e10.printStackTrace();
        }
    }

    private void c() {
        int iOptInt = this.f22813e.optInt("Common_frequency");
        if (iOptInt == 0) {
            iOptInt = 1;
        }
        if (SystemClock.elapsedRealtime() - this.f22814f >= iOptInt * w3.e.f53894d) {
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        d("cgi back, do update");
        this.f22813e = jSONObject;
        a("com.tencent.open.config.json", jSONObject.toString());
        this.f22814f = SystemClock.elapsedRealtime();
    }

    public int a(String str) {
        d("get " + str);
        c();
        return this.f22813e.optInt(str);
    }
}
