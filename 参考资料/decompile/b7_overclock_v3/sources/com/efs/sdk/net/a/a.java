package com.efs.sdk.net.a;

import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static a f13052c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<String, b> f13053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HashMap<String, c> f13054b;

    private a() {
        b();
    }

    public static a a() {
        if (f13052c == null) {
            f13052c = new a();
        }
        return f13052c;
    }

    private void b() {
        if (this.f13053a == null) {
            this.f13053a = new HashMap<>();
        }
        this.f13053a.clear();
    }

    public final c c(String str) {
        if (this.f13054b == null) {
            this.f13054b = new HashMap<>();
        }
        if (this.f13054b.containsKey(str)) {
            return this.f13054b.get(str);
        }
        c cVar = new c();
        cVar.A = str;
        cVar.C = System.currentTimeMillis();
        this.f13054b.put(str, cVar);
        return cVar;
    }

    public final void d(String str) {
        HashMap<String, c> map = this.f13054b;
        if (map == null || !map.containsKey(str)) {
            return;
        }
        this.f13054b.remove(str);
    }

    public final b a(String str) {
        if (this.f13053a == null) {
            b();
        }
        b bVar = this.f13053a.get(str);
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b();
        bVar2.f13072a = str;
        bVar2.f13073b = System.currentTimeMillis();
        this.f13053a.put(str, bVar2);
        return bVar2;
    }

    public final void b(String str) {
        HashMap<String, b> map = this.f13053a;
        if (map == null || !map.containsKey(str)) {
            return;
        }
        this.f13053a.remove(str);
    }
}
