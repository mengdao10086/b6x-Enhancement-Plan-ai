package com.umeng.commonsdk.config;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class b implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, Boolean> f23904a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Object f23905b = new Object();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f23906a = new b();

        private a() {
        }
    }

    public static b b() {
        return a.f23906a;
    }

    public void a() {
        synchronized (f23905b) {
            f23904a.clear();
        }
    }

    private b() {
    }

    public static boolean a(String str) {
        if (!d.a(str)) {
            return false;
        }
        synchronized (f23905b) {
            if (!f23904a.containsKey(str)) {
                return true;
            }
            return f23904a.get(str).booleanValue();
        }
    }

    @Override // com.umeng.commonsdk.config.f
    public void a(String str, Boolean bool) {
        if (d.a(str)) {
            synchronized (f23905b) {
                Map<String, Boolean> map = f23904a;
                if (map != null) {
                    map.put(str, bool);
                }
            }
        }
    }
}
