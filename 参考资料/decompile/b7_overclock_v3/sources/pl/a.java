package pl;

import android.os.Build;
import android.text.TextUtils;
import com.google.android.material.internal.i;
import o5.h;

/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f46700a;

    public static a a() {
        if (f46700a == null) {
            synchronized (a.class) {
                if (f46700a == null) {
                    f46700a = new a();
                }
            }
        }
        return f46700a;
    }

    public final String b(String str) {
        return c.c().a(str);
    }

    public final boolean c() {
        String str = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str) && str.contains("HUAWEI");
    }

    public final boolean d() {
        return !TextUtils.isEmpty(b(h.f42758o));
    }

    public final boolean e() {
        return "oppo".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public final boolean f() {
        return i.f20422b.equalsIgnoreCase(Build.MANUFACTURER);
    }

    public final boolean g() {
        return !TextUtils.isEmpty(b("ro.vivo.os.name"));
    }
}
