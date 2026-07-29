package com.flydigi.device_manager.ui.driver_active.permission;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import androidx.lifecycle.x0;
import com.blankj.utilcode.util.j1;
import kotlin.jvm.internal.u;

/* JADX INFO: loaded from: classes7.dex */
public final class l extends x0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @yt.k
    public static final a f14921g = new a(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f14922h = 2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f14923i = 3;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f14924j = 4;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f14925k = 5;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f14926l = 6;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f14927m = -1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f14928n = 7;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final j0<Integer> f14929d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public final LiveData<Integer> f14930e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f14931f;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    public l() {
        j0<Integer> j0Var = new j0<>();
        this.f14929d = j0Var;
        this.f14930e = j0Var;
    }

    public final void g() {
        if (!o5.b.d(j1.a())) {
            this.f14929d.o(2);
            return;
        }
        if (o5.h.h() && !o5.b.f(j1.a())) {
            this.f14929d.o(6);
            return;
        }
        if (!o5.b.k(j1.a())) {
            this.f14929d.o(3);
            return;
        }
        if (o5.h.h() && !o5.b.g(j1.a())) {
            this.f14929d.o(5);
        } else if ((o5.h.l() || o5.h.d()) && !o5.b.l()) {
            this.f14929d.o(4);
        } else {
            this.f14929d.o(-1);
        }
    }

    @yt.k
    public final LiveData<Integer> h() {
        return this.f14930e;
    }

    public final boolean i() {
        return this.f14931f;
    }

    public final void j(boolean z10) {
        this.f14931f = z10;
    }
}
