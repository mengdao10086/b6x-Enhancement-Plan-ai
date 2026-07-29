package com.flydigi.community.ui.my.config;

import com.flydigi.base.net.BaseResponse;
import com.flydigi.community.ui.my.config.a;
import com.flydigi.data.bean.MyPublishedArticlesBean;
import com.flydigi.data.bean.community.ArticleBean;
import dj.o;
import ik.l;
import java.util.List;
import kotlin.jvm.internal.f0;
import kotlin.z1;
import m5.c0;
import xi.z;
import yt.k;

/* JADX INFO: loaded from: classes2.dex */
public final class MySharedConfigPresenter implements a.InterfaceC0142a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final a.b f13967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public final z5.f f13968b;

    public MySharedConfigPresenter(@k a.b mView) {
        f0.p(mView, "mView");
        this.f13967a = mView;
        this.f13968b = new z5.f();
    }

    public static final void j0(l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void k0(l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final Iterable m0(l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        return (Iterable) tmp0.i(obj);
    }

    public static final MySharedConfigItem n0(l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        return (MySharedConfigItem) tmp0.i(obj);
    }

    public static final void o0(l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void p0(l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    @Override // com.flydigi.community.ui.my.config.a.InterfaceC0142a
    public void P(final int i10, int i11) {
        z<MyPublishedArticlesBean> zVarL = this.f13968b.l(2, i10, i11);
        final MySharedConfigPresenter$getMySharedConfig$disposable$1 mySharedConfigPresenter$getMySharedConfig$disposable$1 = new l<MyPublishedArticlesBean, Iterable<? extends ArticleBean>>() { // from class: com.flydigi.community.ui.my.config.MySharedConfigPresenter$getMySharedConfig$disposable$1
            @Override // ik.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Iterable<ArticleBean> i(@k MyPublishedArticlesBean it2) {
                f0.p(it2, "it");
                return it2.getList();
            }
        };
        z<U> zVarZ2 = zVarL.z2(new o() { // from class: com.flydigi.community.ui.my.config.h
            @Override // dj.o
            public final Object apply(Object obj) {
                return MySharedConfigPresenter.m0(mySharedConfigPresenter$getMySharedConfig$disposable$1, obj);
            }
        });
        final MySharedConfigPresenter$getMySharedConfig$disposable$2 mySharedConfigPresenter$getMySharedConfig$disposable$2 = MySharedConfigPresenter$getMySharedConfig$disposable$2.f13970c;
        z zVarS0 = zVarZ2.A3(new o() { // from class: com.flydigi.community.ui.my.config.i
            @Override // dj.o
            public final Object apply(Object obj) {
                return MySharedConfigPresenter.n0(mySharedConfigPresenter$getMySharedConfig$disposable$2, obj);
            }
        }).Y6().v1().s0(c0.t()).s0(o5.l.d());
        final l<List<MySharedConfigItem>, z1> lVar = new l<List<MySharedConfigItem>, z1>() { // from class: com.flydigi.community.ui.my.config.MySharedConfigPresenter$getMySharedConfig$disposable$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(List<MySharedConfigItem> it2) {
                a.b bVarL0 = this.this$0.l0();
                boolean z10 = i10 == 1;
                f0.o(it2, "it");
                bVarL0.c(z10, it2);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(List<MySharedConfigItem> list) {
                b(list);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.community.ui.my.config.g
            @Override // dj.g
            public final void accept(Object obj) {
                MySharedConfigPresenter.o0(lVar, obj);
            }
        };
        final l<Throwable, z1> lVar2 = new l<Throwable, z1>() { // from class: com.flydigi.community.ui.my.config.MySharedConfigPresenter$getMySharedConfig$disposable$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(Throwable it2) {
                a.b bVarL0 = this.this$0.l0();
                boolean z10 = i10 == 1;
                f0.o(it2, "it");
                bVarL0.b(z10, it2);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.community.ui.my.config.e
            @Override // dj.g
            public final void accept(Object obj) {
                MySharedConfigPresenter.p0(lVar2, obj);
            }
        });
    }

    @k
    public final a.b l0() {
        return this.f13967a;
    }

    @Override // com.flydigi.community.ui.my.config.a.InterfaceC0142a
    public void z(@k final MySharedConfigItem item) {
        f0.p(item, "item");
        if (item.z().getId() == 0) {
            return;
        }
        z zVarS0 = this.f13968b.y(item.z().getId()).s0(c0.t()).s0(o5.l.d());
        final l<BaseResponse<?>, z1> lVar = new l<BaseResponse<?>, z1>() { // from class: com.flydigi.community.ui.my.config.MySharedConfigPresenter$deleteConfig$disposable$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(BaseResponse<?> baseResponse) {
                this.this$0.l0().M2(item);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(BaseResponse<?> baseResponse) {
                b(baseResponse);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.community.ui.my.config.f
            @Override // dj.g
            public final void accept(Object obj) {
                MySharedConfigPresenter.j0(lVar, obj);
            }
        };
        final l<Throwable, z1> lVar2 = new l<Throwable, z1>() { // from class: com.flydigi.community.ui.my.config.MySharedConfigPresenter$deleteConfig$disposable$2
            {
                super(1);
            }

            public final void b(Throwable it2) {
                a.b bVarL0 = this.this$0.l0();
                f0.o(it2, "it");
                bVarL0.b(false, it2);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.community.ui.my.config.d
            @Override // dj.g
            public final void accept(Object obj) {
                MySharedConfigPresenter.k0(lVar2, obj);
            }
        });
    }
}
