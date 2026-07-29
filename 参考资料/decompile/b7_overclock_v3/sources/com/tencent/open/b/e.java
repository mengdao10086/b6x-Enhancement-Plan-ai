package com.tencent.open.b;

import android.os.Build;
import android.os.SystemClock;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.k;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import hb.u;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static e f22680a;

    public static synchronized e a() {
        if (f22680a == null) {
            f22680a = new e();
        }
        return f22680a;
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6) {
        h.a().a(k.a(str, str3, str4, str5, str2, str6), str2, true);
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        h.a().a(k.a(str, str4, str5, str3, str2, str6, "", str7, str8, "", "", ""), str2, false);
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        h.a().a(k.a(str, str4, str5, str3, str2, str6, str7, "", "", str8, str9, str10), str2, false);
    }

    public void a(int i10, String str, String str2, String str3, String str4, Long l10, int i11, int i12, String str5) {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - l10.longValue();
        if (l10.longValue() == 0 || jElapsedRealtime < 0) {
            jElapsedRealtime = 0;
        }
        StringBuffer stringBuffer = new StringBuffer("https://huatuocode.huatuo.qq.com");
        stringBuffer.append("?domain=mobile.opensdk.com&cgi=opensdk&type=");
        stringBuffer.append(i10);
        stringBuffer.append("&code=");
        stringBuffer.append(i11);
        stringBuffer.append("&time=");
        stringBuffer.append(jElapsedRealtime);
        stringBuffer.append("&rate=");
        stringBuffer.append(i12);
        stringBuffer.append("&uin=");
        stringBuffer.append(str2);
        try {
            String strEncode = URLEncoder.encode(HttpUtils.encodeUrl(a(String.valueOf(i10), String.valueOf(i11), String.valueOf(jElapsedRealtime), String.valueOf(i12), str, str2, str3, str4, str5)), "UTF-8");
            stringBuffer.append("&data");
            stringBuffer.append(u.f30904o);
            stringBuffer.append(strEncode);
            h.a().a(stringBuffer.toString(), (Map<String, String>) null);
        } catch (UnsupportedEncodingException e10) {
            SLog.e("openSDK_LOG.OpenSdkStatic", "reportHaboCgi exception.", e10);
        }
    }

    public static Map<String, String> a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        HashMap map = new HashMap();
        map.put(Constants.PARAM_PLATFORM, "1");
        map.put(CommonNetImpl.RESULT, str);
        map.put("code", str2);
        map.put("tmcost", str3);
        map.put("rate", str4);
        map.put("cmd", str5);
        map.put("uin", str6);
        map.put("appid", str7);
        map.put("share_type", str8);
        map.put("detail", str9);
        map.put("os_ver", Build.VERSION.RELEASE);
        map.put("network", a.a(com.tencent.open.utils.f.a()));
        map.put("apn", a.b(com.tencent.open.utils.f.a()));
        map.put(Constants.PARAM_MODEL_NAME, Build.MODEL);
        map.put(Constants.PARAM_SDK_VER, Constants.SDK_VERSION);
        map.put("packagename", com.tencent.open.utils.f.b());
        map.put(Constants.PARAM_APP_VER, k.d(com.tencent.open.utils.f.a(), com.tencent.open.utils.f.b()));
        return map;
    }
}
