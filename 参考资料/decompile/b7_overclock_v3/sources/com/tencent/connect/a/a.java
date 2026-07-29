package com.tencent.connect.a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.open.b.e;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.g;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Class<?> f22360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Class<?> f22361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Method f22362c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Method f22363d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Method f22364e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Method f22365f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f22366g;

    public static boolean a(Context context, QQToken qQToken) {
        return g.a(context, qQToken.getAppId()).b("Common_ta_enable");
    }

    public static void b(Context context, QQToken qQToken) {
        try {
            if (a(context, qQToken)) {
                f22365f.invoke(f22360a, Boolean.TRUE);
            } else {
                f22365f.invoke(f22360a, Boolean.FALSE);
            }
        } catch (Exception e10) {
            SLog.e("OpenConfig", "checkStatStatus exception: " + e10.toString());
        }
    }

    public static void c(Context context, QQToken qQToken) {
        String str = "Aqc" + qQToken.getAppId();
        try {
            f22360a = Class.forName("com.tencent.stat.StatConfig");
            Class<?> cls = Class.forName("com.tencent.stat.StatService");
            f22361b = cls;
            f22362c = cls.getMethod("reportQQ", Context.class, String.class);
            f22363d = f22361b.getMethod("trackCustomEvent", Context.class, String.class, String[].class);
            Class<?> cls2 = f22361b;
            Class<?> cls3 = Integer.TYPE;
            f22364e = cls2.getMethod("commitEvents", Context.class, cls3);
            Class<?> cls4 = f22360a;
            Class<?> cls5 = Boolean.TYPE;
            f22365f = cls4.getMethod("setEnableStatService", cls5);
            b(context, qQToken);
            f22360a.getMethod("setAutoExceptionCaught", cls5).invoke(f22360a, Boolean.FALSE);
            f22360a.getMethod("setEnableSmartReporting", cls5).invoke(f22360a, Boolean.TRUE);
            f22360a.getMethod("setSendPeriodMinutes", cls3).invoke(f22360a, 1440);
            Class<?> cls6 = Class.forName("com.tencent.stat.StatReportStrategy");
            f22360a.getMethod("setStatSendStrategy", cls6).invoke(f22360a, cls6.getField("PERIOD").get(null));
            f22361b.getMethod("startStatService", Context.class, String.class, String.class).invoke(f22361b, context, str, Class.forName("com.tencent.stat.common.StatConstants").getField("VERSION").get(null));
            f22366g = true;
        } catch (Exception e10) {
            SLog.e("OpenConfig", "start4QQConnect exception: " + e10.toString());
        }
    }

    public static void d(Context context, QQToken qQToken) {
        if (!TextUtils.isEmpty(qQToken.getOpenId())) {
            e.a().a(qQToken.getOpenId(), qQToken.getAppId(), "2", "1", Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, "0", "0", "0");
        }
        if (f22366g) {
            b(context, qQToken);
            if (qQToken.getOpenId() != null) {
                try {
                    f22362c.invoke(f22361b, context, qQToken.getOpenId());
                } catch (Exception e10) {
                    SLog.e("OpenConfig", "reportQQ exception: " + e10.toString());
                }
            }
        }
    }

    public static void a(Context context, QQToken qQToken, String str, String... strArr) {
        if (f22366g) {
            b(context, qQToken);
            try {
                f22363d.invoke(f22361b, context, str, strArr);
            } catch (Exception e10) {
                SLog.e("OpenConfig", "trackCustomEvent exception: " + e10.toString());
            }
        }
    }
}
