package com.permissionx.guolindev.request;

import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import bg.c;
import java.util.ArrayList;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b \u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0016\u0010\u000b\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/permissionx/guolindev/request/a;", "Lcom/permissionx/guolindev/request/b;", "Lcom/permissionx/guolindev/request/c;", i1.a.T4, "Lcom/permissionx/guolindev/request/d;", "X", "Lkotlin/z1;", "U", "Lcom/permissionx/guolindev/request/t;", "a", "Lcom/permissionx/guolindev/request/t;", "pb", "b", "Lcom/permissionx/guolindev/request/b;", "next", "c", "Lcom/permissionx/guolindev/request/c;", "explainReasonScope", "d", "Lcom/permissionx/guolindev/request/d;", "forwardToSettingsScope", "<init>", "(Lcom/permissionx/guolindev/request/t;)V", "permissionx_release"}, k = 1, mv = {1, 7, 1})
public abstract class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @hk.e
    @yt.k
    public t f22099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @hk.e
    @yt.l
    public b f22100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public c f22101c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public d f22102d;

    public a(@yt.k t pb2) {
        f0.p(pb2, "pb");
        this.f22099a = pb2;
        this.f22101c = new c(pb2, this);
        this.f22102d = new d(this.f22099a, this);
        this.f22101c = new c(this.f22099a, this);
        this.f22102d = new d(this.f22099a, this);
    }

    @Override // com.permissionx.guolindev.request.b
    public void U() {
        z1 z1Var;
        b bVar = this.f22100b;
        if (bVar != null) {
            bVar.T();
            z1Var = z1.f38230a;
        } else {
            z1Var = null;
        }
        if (z1Var == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.f22099a.f22146m);
            arrayList.addAll(this.f22099a.f22147n);
            arrayList.addAll(this.f22099a.f22144k);
            if (this.f22099a.D()) {
                if (bg.c.d(this.f22099a.i(), u.f22155f)) {
                    this.f22099a.f22145l.add(u.f22155f);
                } else {
                    arrayList.add(u.f22155f);
                }
            }
            if (this.f22099a.I() && Build.VERSION.SDK_INT >= 23 && this.f22099a.l() >= 23) {
                if (Settings.canDrawOverlays(this.f22099a.i())) {
                    this.f22099a.f22145l.add("android.permission.SYSTEM_ALERT_WINDOW");
                } else {
                    arrayList.add("android.permission.SYSTEM_ALERT_WINDOW");
                }
            }
            if (this.f22099a.J() && Build.VERSION.SDK_INT >= 23 && this.f22099a.l() >= 23) {
                if (Settings.System.canWrite(this.f22099a.i())) {
                    this.f22099a.f22145l.add("android.permission.WRITE_SETTINGS");
                } else {
                    arrayList.add("android.permission.WRITE_SETTINGS");
                }
            }
            if (this.f22099a.G()) {
                if (Build.VERSION.SDK_INT < 30 || !Environment.isExternalStorageManager()) {
                    arrayList.add(y.f22163f);
                } else {
                    this.f22099a.f22145l.add(y.f22163f);
                }
            }
            if (this.f22099a.F()) {
                if (Build.VERSION.SDK_INT < 26 || this.f22099a.l() < 26 || !this.f22099a.i().getPackageManager().canRequestPackageInstalls()) {
                    arrayList.add(x.f22161f);
                } else {
                    this.f22099a.f22145l.add(x.f22161f);
                }
            }
            if (this.f22099a.H()) {
                if (bg.c.a(this.f22099a.i())) {
                    this.f22099a.f22145l.add(c.a.f9430a);
                } else {
                    arrayList.add(c.a.f9430a);
                }
            }
            if (this.f22099a.E()) {
                if (bg.c.d(this.f22099a.i(), v.f22157f)) {
                    this.f22099a.f22145l.add(v.f22157f);
                } else {
                    arrayList.add(v.f22157f);
                }
            }
            cg.d dVar = this.f22099a.f22150q;
            if (dVar != null) {
                f0.m(dVar);
                dVar.a(arrayList.isEmpty(), new ArrayList(this.f22099a.f22145l), arrayList);
            }
            this.f22099a.f();
        }
    }

    @Override // com.permissionx.guolindev.request.b
    @yt.k
    public c W() {
        return this.f22101c;
    }

    @Override // com.permissionx.guolindev.request.b
    @yt.k
    public d X() {
        return this.f22102d;
    }
}
