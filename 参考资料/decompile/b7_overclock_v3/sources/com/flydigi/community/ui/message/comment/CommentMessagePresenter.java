package com.flydigi.community.ui.message.comment;

import com.flydigi.community.ui.message.comment.a;
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
public final class CommentMessagePresenter implements a.InterfaceC0139a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final a.b f13913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public final f f13914b;

    public CommentMessagePresenter(@k a.b mView) {
        f0.p(mView, "mView");
        this.f13913a = mView;
        this.f13914b = new f();
    }

    public static final Iterable i0(l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        return (Iterable) tmp0.i(obj);
    }

    public static final CommentRecordItem j0(l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        return (CommentRecordItem) tmp0.i(obj);
    }

    public static final void k0(l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void l0(l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    @Override // com.flydigi.community.ui.message.comment.a.InterfaceC0139a
    public void p(final int i10, int i11) {
        z<MyMessageBean> zVarU = this.f13914b.u(i10, i11);
        final CommentMessagePresenter$getMyMessage$disposable$1 commentMessagePresenter$getMyMessage$disposable$1 = new l<MyMessageBean, Iterable<? extends MyMessageBean.Message>>() { // from class: com.flydigi.community.ui.message.comment.CommentMessagePresenter$getMyMessage$disposable$1
            @Override // ik.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Iterable<MyMessageBean.Message> i(@k MyMessageBean it2) {
                f0.p(it2, "it");
                return it2.getList();
            }
        };
        z<U> zVarZ2 = zVarU.z2(new o() { // from class: com.flydigi.community.ui.message.comment.e
            @Override // dj.o
            public final Object apply(Object obj) {
                return CommentMessagePresenter.i0(commentMessagePresenter$getMyMessage$disposable$1, obj);
            }
        });
        final CommentMessagePresenter$getMyMessage$disposable$2 commentMessagePresenter$getMyMessage$disposable$2 = new l<MyMessageBean.Message, CommentRecordItem>() { // from class: com.flydigi.community.ui.message.comment.CommentMessagePresenter$getMyMessage$disposable$2
            @Override // ik.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final CommentRecordItem i(@k MyMessageBean.Message it2) {
                f0.p(it2, "it");
                return new CommentRecordItem(it2);
            }
        };
        z zVarS0 = zVarZ2.A3(new o() { // from class: com.flydigi.community.ui.message.comment.d
            @Override // dj.o
            public final Object apply(Object obj) {
                return CommentMessagePresenter.j0(commentMessagePresenter$getMyMessage$disposable$2, obj);
            }
        }).Y6().v1().s0(o5.l.d());
        final l<List<CommentRecordItem>, z1> lVar = new l<List<CommentRecordItem>, z1>() { // from class: com.flydigi.community.ui.message.comment.CommentMessagePresenter$getMyMessage$disposable$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(List<CommentRecordItem> it2) {
                a.b bVar = this.this$0.f13913a;
                boolean z10 = i10 == 1;
                f0.o(it2, "it");
                bVar.c(z10, it2);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(List<CommentRecordItem> list) {
                b(list);
                return z1.f38230a;
            }
        };
        g gVar = new g() { // from class: com.flydigi.community.ui.message.comment.b
            @Override // dj.g
            public final void accept(Object obj) {
                CommentMessagePresenter.k0(lVar, obj);
            }
        };
        final l<Throwable, z1> lVar2 = new l<Throwable, z1>() { // from class: com.flydigi.community.ui.message.comment.CommentMessagePresenter$getMyMessage$disposable$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(Throwable it2) {
                a.b bVar = this.this$0.f13913a;
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
        zVarS0.F5(gVar, new g() { // from class: com.flydigi.community.ui.message.comment.c
            @Override // dj.g
            public final void accept(Object obj) {
                CommentMessagePresenter.l0(lVar2, obj);
            }
        });
    }
}
