package com.umeng.umlink;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.an;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.umlink.a.b;
import hb.u;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import l4.f;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class MobclickLink {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f24842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Boolean f24843b = Boolean.TRUE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f24844c = null;

    private static String a() {
        try {
            Class<?> cls = Class.forName("com.umeng.umzid.Spy");
            Method declaredMethod = cls.getDeclaredMethod("getID", new Class[0]);
            if (declaredMethod != null) {
                return (String) declaredMethod.invoke(cls, new Object[0]);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean a(Context context, UMLinkListener uMLinkListener) {
        String strConcat;
        String string = a.a(context).getString("umlink_install_cache", null);
        try {
            if (TextUtils.isEmpty(string)) {
                return false;
            }
            JSONObject jSONObject = new JSONObject(string);
            HashMap<String, String> map = new HashMap<>();
            Uri uri = Uri.parse("");
            if (jSONObject.isNull("data")) {
                strConcat = "[match-local result]:none";
            } else {
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                TextUtils.isEmpty(jSONObject2.getString("linkId"));
                JSONObject jSONObject3 = jSONObject2.getJSONObject("installParams");
                Iterator<String> itKeys = jSONObject3.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    map.put(next, jSONObject3.getString(next));
                }
                String string2 = jSONObject2.getString("matchType");
                String string3 = jSONObject2.getString("wakeupUrl");
                if (!TextUtils.isEmpty(string3)) {
                    uri = Uri.parse(string3 + "&_scene_=install");
                }
                strConcat = "[match-local result]:".concat(String.valueOf(string2));
            }
            UMLog.mutlInfo(strConcat, 3, "", null, null);
            uMLinkListener.onInstall(map, uri);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, String str, Uri uri, String str2) {
        String str3;
        String str4 = "";
        try {
            if (context == null) {
                UMLog.aq("context参数不能为null。|需要指定ApplicationContext值。", 0, "\\|");
                return;
            }
            if (f24842a == null) {
                f24842a = context.getApplicationContext();
            }
            String string = uri.toString();
            String query = uri.getQuery();
            try {
                if (query.contains("url=")) {
                    query = query.substring(0, query.indexOf("url="));
                }
                if (query.length() > 0) {
                    str3 = "";
                    for (String str5 : query.split("&")) {
                        try {
                            int iIndexOf = str5.indexOf(u.f30904o);
                            if (iIndexOf > 0 && iIndexOf < str5.length() - 1) {
                                String strSubstring = str5.substring(0, iIndexOf);
                                String strSubstring2 = str5.substring(iIndexOf + 1);
                                if ("um_from_appkey".equals(strSubstring)) {
                                    str4 = strSubstring2;
                                } else if ("_bizType_".equals(strSubstring)) {
                                    str3 = strSubstring2;
                                }
                            }
                        } catch (Exception e10) {
                            e = e10;
                            e.printStackTrace();
                            if (TextUtils.isEmpty(str)) {
                            }
                            UMLog.aq("linkid、url、scene参数不能为null，也不能为空字符串。|必须为非空字符串。", 0, "\\|");
                            return;
                        }
                    }
                } else {
                    str3 = "";
                }
            } catch (Exception e11) {
                e = e11;
                str3 = "";
            }
            if (!TextUtils.isEmpty(str) || TextUtils.isEmpty(string) || TextUtils.isEmpty(str2)) {
                UMLog.aq("linkid、url、scene参数不能为null，也不能为空字符串。|必须为非空字符串。", 0, "\\|");
                return;
            }
            HashMap map = new HashMap();
            map.put("_$!link_id", str);
            map.put("_$!url", string);
            map.put("_$!scene", str2);
            map.put("_$!appkey", str4);
            map.put("_$!bizType", str3);
            MobclickAgent.onEvent(f24842a, "$$_um_link", map);
        } catch (Throwable th2) {
            if (MLog.DEBUG) {
                MLog.e(th2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized JSONObject c(Context context) {
        JSONObject jSONObject;
        String appkey;
        ClipData primaryClip;
        ClipData.Item itemAt;
        CharSequence charSequenceCoerceToText;
        try {
            jSONObject = new JSONObject();
        } catch (Exception e10) {
            e = e10;
            jSONObject = null;
        }
        try {
            appkey = UMUtils.getAppkey(context);
        } catch (Exception e11) {
            e = e11;
            UMLog.mutlInfo("[getUMLinkParam error]:" + e.getMessage(), 3, "", null, null);
        }
        if (TextUtils.isEmpty(appkey)) {
            throw new Exception("no appkey");
        }
        jSONObject.put("appkey", appkey);
        String uMId = UMUtils.getUMId(context);
        if (!TextUtils.isEmpty(uMId)) {
            jSONObject.put("umid", uMId);
        }
        jSONObject.put("appVersion", UMUtils.getAppVersionName(context));
        jSONObject.put("sdkVersion", "9.4.0");
        jSONObject.put("linkVersion", getVersion());
        jSONObject.put("channel", UMUtils.getChannel(context));
        jSONObject.put("os", f.f39447b);
        jSONObject.put("osVersion", Build.VERSION.RELEASE);
        jSONObject.put("buildId", Build.ID);
        jSONObject.put("brand", Build.BRAND);
        jSONObject.put("deviceModel", Build.MODEL);
        int[] resolutionArray = DeviceConfig.getResolutionArray(context);
        jSONObject.put("resolutionHeight", resolutionArray[1]);
        jSONObject.put("resolutionWidth", resolutionArray[0]);
        String[] localeInfo = DeviceConfig.getLocaleInfo(context);
        jSONObject.put(an.N, localeInfo[1]);
        jSONObject.put("country", localeInfo[0]);
        jSONObject.put("dateTime", String.valueOf((int) (System.currentTimeMillis() / 1000)));
        String umengZID = UMConfigure.getUmengZID(context);
        if (umengZID != null) {
            jSONObject.put(an.f23210al, umengZID);
        }
        String strA = a();
        if (strA != null) {
            jSONObject.put("zdata", strA);
        }
        String str = f24844c;
        if (str != null) {
            int iIndexOf = str.indexOf("8um:/");
            int iIndexOf2 = f24844c.indexOf("$$");
            if (iIndexOf < 0 || iIndexOf2 <= iIndexOf) {
                throw new Exception("token format error");
            }
            jSONObject.put("clipboardToken", f24844c.substring(iIndexOf, iIndexOf2 + 2));
        } else if (f24843b.booleanValue()) {
            ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
            String string = (clipboardManager == null || (primaryClip = clipboardManager.getPrimaryClip()) == null || primaryClip.getItemCount() <= 0 || (itemAt = primaryClip.getItemAt(0)) == null || (charSequenceCoerceToText = itemAt.coerceToText(context)) == null) ? null : charSequenceCoerceToText.toString();
            if (string != null) {
                int iIndexOf3 = string.indexOf("8um:/");
                int iIndexOf4 = string.indexOf("$$");
                if (iIndexOf3 >= 0 && iIndexOf4 > iIndexOf3) {
                    jSONObject.put("clipboardToken", string.substring(iIndexOf3, iIndexOf4 + 2));
                    ClipboardManager clipboardManager2 = (ClipboardManager) context.getSystemService("clipboard");
                    if (clipboardManager2 != null) {
                        clipboardManager2.setPrimaryClip(ClipData.newPlainText("", ""));
                    }
                }
            }
        }
        f24844c = null;
        f24843b = Boolean.TRUE;
        return jSONObject;
    }

    public static void getInstallParams(final Context context, final UMLinkListener uMLinkListener) {
        if (a(context, uMLinkListener)) {
            return;
        }
        b.a(new Thread(new Runnable() { // from class: com.umeng.umlink.MobclickLink.1
            @Override // java.lang.Runnable
            public final void run() {
                JSONObject jSONObjectC = MobclickLink.c(context);
                if (jSONObjectC == null) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.umeng.umlink.MobclickLink.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            uMLinkListener.onError("param error: appkey not set for example");
                        }
                    });
                    return;
                }
                String strA = com.umeng.umlink.a.a.a("https://deeplink.umeng.com/deeplink/match", jSONObjectC.toString());
                try {
                    if (TextUtils.isEmpty(strA)) {
                        throw new Exception("network error");
                    }
                    JSONObject jSONObject = new JSONObject(strA);
                    if (jSONObject.getInt("code") != 200) {
                        throw new Exception("code=" + jSONObject.getInt("code"));
                    }
                    SharedPreferences.Editor editorEdit = a.a(context).edit();
                    editorEdit.putString("umlink_install_cache", strA);
                    editorEdit.commit();
                    final HashMap map = new HashMap();
                    final Uri uri = Uri.parse("");
                    if (jSONObject.isNull("data")) {
                        UMLog.mutlInfo("[match result]:none", 3, "", null, null);
                    } else {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                        String string = jSONObject2.getString("linkId");
                        if (TextUtils.isEmpty(string)) {
                            string = "";
                        }
                        JSONObject jSONObject3 = jSONObject2.getJSONObject("installParams");
                        Iterator<String> itKeys = jSONObject3.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            map.put(next, jSONObject3.getString(next));
                        }
                        String string2 = jSONObject2.getString("matchType");
                        String string3 = jSONObject2.getString("wakeupUrl");
                        if (!TextUtils.isEmpty(string3)) {
                            uri = Uri.parse(string3 + "&_scene_=install");
                        }
                        UMLog.mutlInfo("[match result]:".concat(String.valueOf(string2)), 3, "", null, null);
                        MobclickLink.b(context, string, uri, "install");
                    }
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.umeng.umlink.MobclickLink.1.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            uMLinkListener.onInstall(map, uri);
                        }
                    });
                } catch (Exception e10) {
                    UMLog.mutlInfo("[match error]:" + e10.getMessage(), 3, "", null, null);
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.umeng.umlink.MobclickLink.1.3
                        @Override // java.lang.Runnable
                        public final void run() {
                            uMLinkListener.onError(e10.getMessage());
                        }
                    });
                }
            }
        }));
    }

    public static void getInstallParams(Context context, String str, UMLinkListener uMLinkListener) {
        f24844c = str;
        getInstallParams(context, uMLinkListener);
    }

    public static void getInstallParams(Context context, boolean z10, UMLinkListener uMLinkListener) {
        f24844c = null;
        f24843b = Boolean.valueOf(z10);
        getInstallParams(context, uMLinkListener);
    }

    public static String getVersion() {
        return com.umeng.commonsdk.internal.a.f24033e;
    }

    public static void handleUMLinkURI(final Context context, Uri uri, UMLinkListener uMLinkListener) {
        String str;
        String str2;
        String str3 = "";
        if (uri == null || uri.toString().length() <= 0) {
            return;
        }
        String path = uri.getPath();
        String query = uri.getQuery();
        HashMap<String, String> map = new HashMap<>();
        try {
            if (query.contains("url=")) {
                int iIndexOf = query.indexOf("url=");
                map.put("url", query.substring(iIndexOf + 4));
                query = query.substring(0, iIndexOf);
            }
            if (query.length() > 0) {
                str = "wakeup";
                str2 = "";
                for (String str4 : query.split("&")) {
                    try {
                        int iIndexOf2 = str4.indexOf(u.f30904o);
                        if (iIndexOf2 > 0 && iIndexOf2 < str4.length() - 1) {
                            String strSubstring = str4.substring(0, iIndexOf2);
                            String strSubstring2 = str4.substring(iIndexOf2 + 1);
                            if ("_sdk_".equals(strSubstring)) {
                                str3 = strSubstring2;
                            } else if ("_linkid_".equals(strSubstring)) {
                                str2 = strSubstring2;
                            } else if ("_scene_".equals(strSubstring)) {
                                str = strSubstring2;
                            }
                            map.put(strSubstring, strSubstring2);
                        }
                    } catch (Exception e10) {
                        e = e10;
                        e.printStackTrace();
                        if (str3 != null) {
                            return;
                        }
                    }
                }
            } else {
                str = "wakeup";
                str2 = "";
            }
        } catch (Exception e11) {
            e = e11;
            str = "wakeup";
            str2 = "";
        }
        if (str3 != null && "umeng".equals(str3)) {
            if ("wakeup".equals(str)) {
                b(context, str2, uri, str);
                final String string = uri.toString();
                b.a(new Thread(new Runnable() { // from class: com.umeng.umlink.MobclickLink.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        String string2;
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("appkey", UMUtils.getAppkey(context));
                            jSONObject.put("wakeupUrl", string);
                            jSONObject.put("time", String.valueOf((int) (System.currentTimeMillis() / 1000)));
                            String umengZID = UMConfigure.getUmengZID(context);
                            if (umengZID != null) {
                                jSONObject.put(an.f23210al, umengZID);
                            }
                            string2 = jSONObject.toString();
                        } catch (Exception unused) {
                            UMLog.mutlInfo("[reportFP error]:param", 3, "", null, null);
                            string2 = "";
                        }
                        String strA = com.umeng.umlink.a.a.a("https://deeplink.umeng.com/deeplink/deviceFingerprint", string2);
                        try {
                            if (TextUtils.isEmpty(strA)) {
                                throw new Exception("network error");
                            }
                            JSONObject jSONObject2 = new JSONObject(strA);
                            if (jSONObject2.getInt("code") == 200) {
                                UMLog.mutlInfo("[reportFP result]:200", 3, "", null, null);
                            } else {
                                throw new Exception("code=" + jSONObject2.getInt("code"));
                            }
                        } catch (Exception e12) {
                            UMLog.mutlInfo("[reportFP error]:" + e12.getMessage(), 3, "", null, null);
                        }
                    }
                }));
            }
            uMLinkListener.onLink(path, map);
        }
    }

    public void init(Context context) {
        if (f24842a == null) {
            f24842a = context.getApplicationContext();
        }
    }
}
