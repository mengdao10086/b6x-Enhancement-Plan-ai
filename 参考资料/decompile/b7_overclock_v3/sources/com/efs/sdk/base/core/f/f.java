package com.efs.sdk.base.core.f;

import com.efs.sdk.base.core.controller.ControllerCenter;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f12917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ControllerCenter f12918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f12919c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g f12920d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final f f12921a = new f(0);
    }

    public /* synthetic */ f(byte b10) {
        this();
    }

    public final void a(String str, String str2, String str3) {
        this.f12920d.a(str, str2, str3);
    }

    private f() {
        this.f12917a = new c();
        this.f12919c = new d();
        this.f12920d = new g();
    }

    public final void a(int i10) {
        ControllerCenter controllerCenter = this.f12918b;
        if (controllerCenter != null) {
            controllerCenter.send(a("flow_limit", i10));
        }
    }

    public final void a(int i10, String str) {
        if (this.f12918b != null || ControllerCenter.getGlobalEnvStruct().isEnableWaStat()) {
            b bVarA = a("flow_limit_type", i10);
            bVarA.put("code", str);
            this.f12918b.send(bVarA);
        }
    }

    public final b a(String str, int i10) {
        b bVar = new b("efs_core", str, this.f12917a.f12911c);
        bVar.put("cver", Integer.valueOf(i10));
        return bVar;
    }
}
