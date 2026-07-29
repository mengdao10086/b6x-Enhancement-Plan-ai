package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.c1;
import androidx.lifecycle.d1;
import androidx.lifecycle.t0;
import androidx.lifecycle.z0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public class l0 implements androidx.lifecycle.r, androidx.savedstate.d, d1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f6011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c1 f6012b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public z0.b f6013c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public androidx.lifecycle.a0 f6014d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public androidx.savedstate.c f6015e = null;

    public l0(@g.n0 Fragment fragment, @g.n0 c1 c1Var) {
        this.f6011a = fragment;
        this.f6012b = c1Var;
    }

    @Override // androidx.lifecycle.d1
    @g.n0
    public c1 O0() {
        b();
        return this.f6012b;
    }

    public void a(@g.n0 Lifecycle.Event event) {
        this.f6014d.l(event);
    }

    public void b() {
        if (this.f6014d == null) {
            this.f6014d = new androidx.lifecycle.a0(this);
            androidx.savedstate.c cVarA = androidx.savedstate.c.a(this);
            this.f6015e = cVarA;
            cVarA.c();
        }
    }

    public boolean c() {
        return this.f6014d != null;
    }

    public void d(@p0 Bundle bundle) {
        this.f6015e.d(bundle);
    }

    @Override // androidx.lifecycle.y
    @g.n0
    public Lifecycle e() {
        b();
        return this.f6014d;
    }

    public void f(@g.n0 Bundle bundle) {
        this.f6015e.e(bundle);
    }

    public void g(@g.n0 Lifecycle.State state) {
        this.f6014d.s(state);
    }

    @Override // androidx.lifecycle.r
    @g.n0
    public z0.b h0() {
        z0.b bVarH0 = this.f6011a.h0();
        if (!bVarH0.equals(this.f6011a.M7)) {
            this.f6013c = bVarH0;
            return bVarH0;
        }
        if (this.f6013c == null) {
            Application application = null;
            Context applicationContext = this.f6011a.R4().getApplicationContext();
            while (true) {
                if (!(applicationContext instanceof ContextWrapper)) {
                    break;
                }
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
            Fragment fragment = this.f6011a;
            this.f6013c = new t0(application, fragment, fragment.T1());
        }
        return this.f6013c;
    }

    @Override // androidx.lifecycle.r
    @g.i
    @g.n0
    public p1.a j0() {
        Application application;
        Context applicationContext = this.f6011a.R4().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            }
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            }
            applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
        }
        p1.e eVar = new p1.e();
        if (application != null) {
            eVar.c(z0.a.f6278i, application);
        }
        eVar.c(SavedStateHandleSupport.f6123c, this.f6011a);
        eVar.c(SavedStateHandleSupport.f6124d, this);
        if (this.f6011a.T1() != null) {
            eVar.c(SavedStateHandleSupport.f6125e, this.f6011a.T1());
        }
        return eVar;
    }

    @Override // androidx.savedstate.d
    @g.n0
    public androidx.savedstate.b l1() {
        b();
        return this.f6015e.b();
    }
}
