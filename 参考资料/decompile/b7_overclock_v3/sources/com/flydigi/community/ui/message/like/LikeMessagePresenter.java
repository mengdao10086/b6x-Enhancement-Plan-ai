package com.flydigi.community.ui.message.like;

import com.flydigi.community.ui.message.like.a;
import com.flydigi.data.bean.MyMessageBean;
import dj.g;
import dj.o;
import ik.l;
import java.util.List;
import kotlin.jvm.internal.f0;
import kotlin.z1;
import xi.z;
import yt.k;
import z5.f;

/* JADX INFO: loaded from: classes2.dex */
public final class LikeMessagePresenter implements a.InterfaceC0140a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final a.b f13932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public final f f13933b;

    public LikeMessagePresenter(@k a.b mView) {
        f0.p(mView, "mView");
        this.f13932a = mView;
        this.f13933b = new f();
    }

    public static final Iterable i0(l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        return (Iterable) tmp0.i(obj);
    }

    public static final LikeRecordItem j0(l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        return (LikeRecordItem) tmp0.i(obj);
    }

    public static final void k0(l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void l0(l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    @Override // com.flydigi.community.ui.message.like.a.InterfaceC0140a
    public void p(final int i10, int i11) {
        z<MyMessageBean> zVarJ = this.f13933b.j(i10, i11);
        final LikeMessagePresenter$getMyMessage$disposable$1 likeMessagePresenter$getMyMessage$disposable$1 = new l<MyMessageBean, Iterable<? extends MyMessageBean.Message>>() { // from class: com.flydigi.community.ui.message.like.LikeMessagePresenter$getMyMessage$disposable$1
            @Override // ik.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Iterable<MyMessageBean.Message> i(@k MyMessageBean it2) {
                f0.p(it2, "it");
                return it2.getList();
            }
        };
        z<U> zVarZ2 = zVarJ.z2(new o() { // from class: com.flydigi.community.ui.message.like.e
            @Override // dj.o
            public final Object apply(Object obj) {
                return LikeMessagePresenter.i0(likeMessagePresenter$getMyMessage$disposable$1, obj);
            }
        });
        final LikeMessagePresenter$getMyMessage$disposable$2 likeMessagePresenter$getMyMessage$disposable$2 = new l<MyMessageBean.Message, LikeRecordItem>() { // from class: com.flydigi.community.ui.message.like.LikeMessagePresenter$getMyMessage$disposable$2
            @Override // ik.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final LikeRecordItem i(@k MyMessageBean.Message it2) {
                f0.p(it2, "it");
                return new LikeRecordItem(it2);
            }
        };
        z zVarS0 = zVarZ2.A3(new o() { // from class: com.flydigi.community.ui.message.like.d
            @Override // dj.o
            public final Object apply(Object obj) {
                return LikeMessagePresenter.j0(likeMessagePresenter$getMyMessage$disposable$2, obj);
            }
        }).Y6().v1().s0(o5.l.d());
        final l<List<LikeRecordItem>, z1> lVar = new l<List<LikeRecordItem>, z1>() { // from class: com.flydigi.community.ui.message.like.LikeMessagePresenter$getMyMessage$disposable$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(List<LikeRecordItem> it2) {
                a.b bVar = this.this$0.f13932a;
                boolean z10 = i10 == 1;
                f0.o(it2, "it");
                bVar.c(z10, it2);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(List<LikeRecordItem> list) {
                b(list);
                return z1.f38230a;
            }
        };
        g gVar = new g() { // from class: com.flydigi.community.ui.message.like.c
            @Override // dj.g
            public final void accept(Object obj) {
                LikeMessagePresenter.k0(lVar, obj);
            }
        };
        final l<Throwable, z1> lVar2 = new l<Throwable, z1>() { // from class: com.flydigi.community.ui.message.like.LikeMessagePresenter$getMyMessage$disposable$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(Throwable it2) {
                a.b bVar = this.this$0.f13932a;
                boolean z10 = i10 == 1;
                f0.o(it2, "it");
                bVar.b(z10, it2);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        zVarS0.F5(gVar, new g() { // from class: com.flydigi.community.ui.message.like.b
            @Override // dj.g
            public final void accept(Object obj) {
                LikeMessagePresenter.l0(lVar2, obj);
            }
        });
    }
}
