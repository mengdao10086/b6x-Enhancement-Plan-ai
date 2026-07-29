package com.flydigi.qiji.ui.advertise;

import android.annotation.SuppressLint;
import androidx.lifecycle.j0;
import androidx.lifecycle.x0;
import com.flydigi.data.bean.AdvertiseBean;
import kotlin.z1;
import m5.c0;
import m5.f0;
import o5.l;
import xi.z;
import yt.k;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"CheckResult"})
public final class AdvertiseViewModel extends x0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @k
    public j0<AdvertiseBean> f16086d = new j0<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @k
    public j0<Boolean> f16087e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @k
    public final j0<AdvertiseBean> f16088f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @k
    public final j0<Boolean> f16089g;

    public AdvertiseViewModel() {
        j0<Boolean> j0Var = new j0<>();
        this.f16087e = j0Var;
        this.f16088f = this.f16086d;
        this.f16089g = j0Var;
        z zVarS0 = ((h5.d) f0.i().k().g(h5.d.class)).n().s0(c0.p()).s0(l.d());
        final ik.l<AdvertiseBean, z1> lVar = new ik.l<AdvertiseBean, z1>() { // from class: com.flydigi.qiji.ui.advertise.AdvertiseViewModel.1
            {
                super(1);
            }

            public final void b(AdvertiseBean advertiseBean) {
                if (advertiseBean.getAdvertiseId() == 0) {
                    AdvertiseViewModel.this.f16087e.o(Boolean.FALSE);
                } else {
                    AdvertiseViewModel.this.f16086d.o(advertiseBean);
                    AdvertiseViewModel.this.f16087e.o(Boolean.TRUE);
                }
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(AdvertiseBean advertiseBean) {
                b(advertiseBean);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.qiji.ui.advertise.h
            @Override // dj.g
            public final void accept(Object obj) {
                AdvertiseViewModel.i(lVar, obj);
            }
        };
        final ik.l<Throwable, z1> lVar2 = new ik.l<Throwable, z1>() { // from class: com.flydigi.qiji.ui.advertise.AdvertiseViewModel.2
            {
                super(1);
            }

            public final void b(Throwable th2) {
                AdvertiseViewModel.this.f16087e.o(Boolean.FALSE);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.qiji.ui.advertise.g
            @Override // dj.g
            public final void accept(Object obj) {
                AdvertiseViewModel.j(lVar2, obj);
            }
        });
    }

    public static final void i(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void j(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    @k
    public final j0<AdvertiseBean> m() {
        return this.f16088f;
    }

    @k
    public final j0<Boolean> n() {
        return this.f16089g;
    }
}
