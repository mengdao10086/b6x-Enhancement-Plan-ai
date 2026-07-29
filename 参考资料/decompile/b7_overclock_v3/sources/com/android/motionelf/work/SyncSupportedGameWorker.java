package com.android.motionelf.work;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.RxWorker;
import androidx.work.WorkerParameters;
import androidx.work.d;
import com.flydigi.base.common.n;
import com.flydigi.data.DBManager;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.SupportedGameListBean;
import dj.g;
import dj.o;
import h5.d;
import ik.l;
import java.util.List;
import kotlin.jvm.internal.f0;
import kotlin.z1;
import m5.c0;
import o5.m;
import xi.i0;
import xi.z;
import yt.k;

/* JADX INFO: loaded from: classes2.dex */
public final class SyncSupportedGameWorker extends RxWorker {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SyncSupportedGameWorker(@k Context appContext, @k WorkerParameters workerParams) {
        super(appContext, workerParams);
        f0.p(appContext, "appContext");
        f0.p(workerParams, "workerParams");
    }

    public static final void F(l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final Boolean G(l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        return (Boolean) tmp0.i(obj);
    }

    public static final ListenableWorker.a H(l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        return (ListenableWorker.a) tmp0.i(obj);
    }

    @Override // androidx.work.RxWorker
    @k
    public i0<ListenableWorker.a> y() {
        final long jP = m.l(DataConstant.SP_FLOAT, 2).p(DataConstant.SP_APP_GAME_WITH_CONFIG_VERSION, 0L);
        z<R> zVarS0 = ((d) m5.f0.i().k().g(d.class)).A(jP).s0(c0.p());
        final l<SupportedGameListBean, z1> lVar = new l<SupportedGameListBean, z1>() { // from class: com.android.motionelf.work.SyncSupportedGameWorker$createWork$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(SupportedGameListBean supportedGameListBean) {
                if (supportedGameListBean.getVersion() > jP) {
                    m.l(DataConstant.SP_FLOAT, 2).z(DataConstant.SP_APP_GAME_WITH_CONFIG_VERSION, supportedGameListBean.getVersion());
                    n.b("SyncGames SyncSupportedGameWorker getAllSupportGame localVersion:" + jP + ",newVersion:" + supportedGameListBean.getVersion(), new Object[0]);
                    DBManager.getInstance().updateSupportedGameList(supportedGameListBean.getList());
                }
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(SupportedGameListBean supportedGameListBean) {
                b(supportedGameListBean);
                return z1.f38230a;
            }
        };
        z zVarY1 = zVarS0.Y1(new g() { // from class: com.android.motionelf.work.a
            @Override // dj.g
            public final void accept(Object obj) {
                SyncSupportedGameWorker.F(lVar, obj);
            }
        });
        final l<SupportedGameListBean, Boolean> lVar2 = new l<SupportedGameListBean, Boolean>() { // from class: com.android.motionelf.work.SyncSupportedGameWorker$createWork$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // ik.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Boolean i(@k SupportedGameListBean it2) {
                f0.p(it2, "it");
                return Boolean.valueOf(it2.getVersion() > jP);
            }
        };
        i0 i0VarH0 = zVarY1.A3(new o() { // from class: com.android.motionelf.work.b
            @Override // dj.o
            public final Object apply(Object obj) {
                return SyncSupportedGameWorker.G(lVar2, obj);
            }
        }).Y6().c1(lj.b.a()).H0(lj.b.a());
        final SyncSupportedGameWorker$createWork$3 syncSupportedGameWorker$createWork$3 = new l<List<Boolean>, ListenableWorker.a>() { // from class: com.android.motionelf.work.SyncSupportedGameWorker$createWork$3
            @Override // ik.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final ListenableWorker.a i(@k List<Boolean> it2) {
                f0.p(it2, "it");
                d.a aVar = new d.a();
                Boolean bool = it2.get(0);
                f0.o(bool, "it[0]");
                return ListenableWorker.a.f(aVar.e("key_cleanup", bool.booleanValue()).a());
            }
        };
        i0<ListenableWorker.a> i0VarS0 = i0VarH0.s0(new o() { // from class: com.android.motionelf.work.c
            @Override // dj.o
            public final Object apply(Object obj) {
                return SyncSupportedGameWorker.H(syncSupportedGameWorker$createWork$3, obj);
            }
        });
        f0.o(i0VarS0, "localGameVersion = SPUti…]).build())\n            }");
        return i0VarS0;
    }
}
