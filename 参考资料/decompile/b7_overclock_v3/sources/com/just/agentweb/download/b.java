package com.just.agentweb.download;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ConcurrentHashMap<String, c> f21947a;

    /* JADX INFO: renamed from: com.just.agentweb.download.b$b, reason: collision with other inner class name */
    public static class C0237b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f21948a = new b();
    }

    public static b c() {
        return C0237b.f21948a;
    }

    public void a(String str, c cVar) {
        if (str == null || cVar == null) {
            return;
        }
        this.f21947a.put(str, cVar);
    }

    public void b(String str) {
        c cVar = this.f21947a.get(str);
        if (cVar != null) {
            cVar.b();
        }
    }

    public void d(String str) {
        if (str != null) {
            this.f21947a.remove(str);
        }
    }

    public b() {
        this.f21947a = null;
        this.f21947a = new ConcurrentHashMap<>();
    }
}
