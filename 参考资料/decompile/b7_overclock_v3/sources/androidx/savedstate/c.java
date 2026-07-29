package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import g.k0;
import hk.m;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @k
    public static final a f7641d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final d f7642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public final b f7643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f7644c;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @m
        @k
        public final c a(@k d owner) {
            f0.p(owner, "owner");
            return new c(owner, null);
        }
    }

    public c(d dVar) {
        this.f7642a = dVar;
        this.f7643b = new b();
    }

    public /* synthetic */ c(d dVar, u uVar) {
        this(dVar);
    }

    @m
    @k
    public static final c a(@k d dVar) {
        return f7641d.a(dVar);
    }

    @k
    public final b b() {
        return this.f7643b;
    }

    @k0
    public final void c() {
        Lifecycle lifecycleE = this.f7642a.e();
        if (!(lifecycleE.b() == Lifecycle.State.INITIALIZED)) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage".toString());
        }
        lifecycleE.a(new Recreator(this.f7642a));
        this.f7643b.g(lifecycleE);
        this.f7644c = true;
    }

    @k0
    public final void d(@l Bundle bundle) {
        if (!this.f7644c) {
            c();
        }
        Lifecycle lifecycleE = this.f7642a.e();
        if (!lifecycleE.b().isAtLeast(Lifecycle.State.STARTED)) {
            this.f7643b.h(bundle);
            return;
        }
        throw new IllegalStateException(("performRestore cannot be called when owner is " + lifecycleE.b()).toString());
    }

    @k0
    public final void e(@k Bundle outBundle) {
        f0.p(outBundle, "outBundle");
        this.f7643b.i(outBundle);
    }
}
