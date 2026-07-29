package com.umeng.commonsdk.config;

import android.content.Context;
import android.util.Pair;
import com.umeng.commonsdk.config.d;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public class FieldManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23899a = "cfgfd";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static b f23900b = b.b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f23901c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Object f23902d = new Object();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final FieldManager f23903a = new FieldManager();

        private a() {
        }
    }

    public static FieldManager a() {
        return a.f23903a;
    }

    public static boolean allow(String str) {
        synchronized (f23902d) {
            if (!f23901c) {
                return false;
            }
            return b.a(str);
        }
    }

    public static boolean b() {
        boolean z10;
        synchronized (f23902d) {
            z10 = f23901c;
        }
        return z10;
    }

    private FieldManager() {
    }

    public void a(Context context) {
        String str;
        String str2 = "1001@3749699455,2130669566,262139,1983";
        String[] strArr = {d.a.class.getName(), d.b.class.getName(), d.c.class.getName(), d.EnumC0258d.class.getName()};
        String strImprintProperty = UMEnvelopeBuild.imprintProperty(context, "cfgfd", "1001@3749699455,2130669566,262139,1983");
        synchronized (f23902d) {
            Pair<Long, String> pairA = a(strImprintProperty);
            if (((Long) pairA.first).longValue() > 1000 && (str = (String) pairA.second) != null && str.length() > 0) {
                str2 = str;
            }
            String[] strArrSplit = str2.split(ag.c.f654g);
            int length = strArrSplit.length;
            if (length > 0) {
                ArrayList arrayList = new ArrayList();
                g gVar = new g();
                for (int i10 = 0; i10 < length; i10++) {
                    arrayList.add(gVar);
                    ((e) arrayList.get(i10)).a(strArrSplit[i10], f23900b, d.b(strArr[i10]));
                }
            }
            f23901c = true;
        }
    }

    public void a(Context context, String str) {
        String str2;
        String str3 = "1001@3749699455,2130669566,262139,1983";
        String[] strArr = {d.a.class.getName(), d.b.class.getName(), d.c.class.getName(), d.EnumC0258d.class.getName()};
        synchronized (f23902d) {
            f23900b.a();
            if (str != null) {
                Pair<Long, String> pairA = a(str);
                if (((Long) pairA.first).longValue() > 1000 && (str2 = (String) pairA.second) != null && str2.length() > 0) {
                    str3 = str2;
                }
            }
            String[] strArrSplit = str3.split(ag.c.f654g);
            int length = strArrSplit.length;
            if (length > 0) {
                ArrayList arrayList = new ArrayList();
                g gVar = new g();
                for (int i10 = 0; i10 < length; i10++) {
                    arrayList.add(gVar);
                    ((e) arrayList.get(i10)).a(strArrSplit[i10], f23900b, d.b(strArr[i10]));
                }
            }
            f23901c = true;
        }
    }

    private static Pair<Long, String> a(String str) {
        Pair<Long, String> pair = new Pair<>(-1L, null);
        if (str != null && str.length() >= 2) {
            String[] strArrSplit = str.split("@");
            if (strArrSplit.length < 2) {
                return pair;
            }
            try {
                long j10 = Long.parseLong(strArrSplit[0]);
                return new Pair<>(Long.valueOf(j10), strArrSplit[1]);
            } catch (Throwable unused) {
            }
        }
        return pair;
    }
}
