package com.flydigi.qiji.ui.customer_service;

import android.util.ArrayMap;
import com.blankj.utilcode.util.j1;
import com.flydigi.base.net.BaseResponse;
import com.flydigi.qiji.ui.customer_service.a;
import ik.l;
import kotlin.jvm.internal.f0;
import kotlin.text.StringsKt__StringsKt;
import kotlin.z1;
import m5.c0;
import org.json.JSONException;
import xi.z;
import yt.k;

/* JADX INFO: loaded from: classes3.dex */
public final class CustomerServiceEvaluatePresenter implements a.InterfaceC0165a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final a.b f16100a;

    public CustomerServiceEvaluatePresenter(@k a.b mView) {
        f0.p(mView, "mView");
        this.f16100a = mView;
    }

    public static final void g0(l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void h0(l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    @Override // com.flydigi.qiji.ui.customer_service.a.InterfaceC0165a
    public void t(@k String sessionId, final int i10, @k String content) {
        f0.p(sessionId, "sessionId");
        f0.p(content, "content");
        z zVarS0 = ((h5.d) m5.f0.i().k().g(h5.d.class)).t(StringsKt__StringsKt.m4(sessionId, "\""), i10, content).s0(c0.r()).s0(c0.t()).s0(o5.l.d());
        final l<BaseResponse<Object>, z1> lVar = new l<BaseResponse<Object>, z1>() { // from class: com.flydigi.qiji.ui.customer_service.CustomerServiceEvaluatePresenter$evaluate$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(BaseResponse<Object> baseResponse) throws JSONException {
                ArrayMap arrayMap = new ArrayMap();
                arrayMap.put("score", String.valueOf(i10));
                u9.h.f(j1.a(), "App_Customer_Service_Evaluate", "客服服务评价", false, arrayMap);
                this.f16100a.E1();
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(BaseResponse<Object> baseResponse) throws JSONException {
                b(baseResponse);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.qiji.ui.customer_service.e
            @Override // dj.g
            public final void accept(Object obj) {
                CustomerServiceEvaluatePresenter.g0(lVar, obj);
            }
        };
        final l<Throwable, z1> lVar2 = new l<Throwable, z1>() { // from class: com.flydigi.qiji.ui.customer_service.CustomerServiceEvaluatePresenter$evaluate$2
            {
                super(1);
            }

            public final void b(Throwable throwable) {
                a.b bVar = this.this$0.f16100a;
                f0.o(throwable, "throwable");
                bVar.m(throwable);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.qiji.ui.customer_service.f
            @Override // dj.g
            public final void accept(Object obj) {
                CustomerServiceEvaluatePresenter.h0(lVar2, obj);
            }
        });
    }
}
