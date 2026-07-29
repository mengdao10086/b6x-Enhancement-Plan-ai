package zf;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import g.n0;
import g.p0;
import java.io.File;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final class g {
    @p0
    public static String a(@n0 Context context, @n0 String str) {
        Map<String, String> mapF = f(context);
        if (mapF == null) {
            return null;
        }
        return mapF.get(str);
    }

    @p0
    public static String b(@n0 Context context) {
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo == null) {
                return null;
            }
            return applicationInfo.sourceDir;
        } catch (Throwable unused) {
            return null;
        }
    }

    @p0
    public static String c(@n0 Context context) {
        return d(context, null);
    }

    @p0
    public static String d(@n0 Context context, @n0 String str) {
        c cVarE = e(context);
        return cVarE == null ? str : cVarE.a();
    }

    @p0
    public static c e(@n0 Context context) {
        String strB = b(context);
        if (TextUtils.isEmpty(strB)) {
            return null;
        }
        return d.a(new File(strB));
    }

    @p0
    public static Map<String, String> f(@n0 Context context) {
        String strB = b(context);
        if (TextUtils.isEmpty(strB)) {
            return null;
        }
        return d.b(new File(strB));
    }
}
