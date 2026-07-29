package com.flydigi.community.ui.comment.detail;

import com.flydigi.community.ui.comment.CommentListPresenter;
import com.flydigi.community.ui.comment.detail.b;
import com.flydigi.data.bean.community.CommentBean;
import com.flydigi.data.bean.community.CommentDetailBean;
import dj.o;
import ik.l;
import java.util.ArrayList;
import kotlin.jvm.internal.f0;
import kotlin.z1;
import xi.e0;
import xi.z;
import yt.k;

/* JADX INFO: loaded from: classes2.dex */
public final class CommentDetailPresenter extends CommentListPresenter implements b.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @k
    public final b.InterfaceC0137b f13850d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommentDetailPresenter(@k b.InterfaceC0137b mView) {
        super(mView);
        f0.p(mView, "mView");
        this.f13850d = mView;
    }

    public static final void J0(l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final e0 K0(l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        return (e0) tmp0.i(obj);
    }

    public static final void L0(l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void M0(l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    @Override // com.flydigi.community.ui.comment.detail.b.a
    public void b(int i10, final int i11, int i12, int i13) {
        z<CommentDetailBean> zVarB = x0().b(i10, i11, i12, i13);
        final l<CommentDetailBean, z1> lVar = new l<CommentDetailBean, z1>() { // from class: com.flydigi.community.ui.comment.detail.CommentDetailPresenter$getCommentDetail$1
            {
                super(1);
            }

            public final void b(CommentDetailBean commentDetailBean) {
                this.this$0.f13850d.R(commentDetailBean.getFloorHost(), commentDetailBean.getArticle(), commentDetailBean.getTotal());
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(CommentDetailBean commentDetailBean) {
                b(commentDetailBean);
                return z1.f38230a;
            }
        };
        z<CommentDetailBean> zVarY1 = zVarB.Y1(new dj.g() { // from class: com.flydigi.community.ui.comment.detail.d
            @Override // dj.g
            public final void accept(Object obj) {
                CommentDetailPresenter.J0(lVar, obj);
            }
        });
        final CommentDetailPresenter$getCommentDetail$2 commentDetailPresenter$getCommentDetail$2 = new l<CommentDetailBean, e0<? extends ArrayList<CommentBean>>>() { // from class: com.flydigi.community.ui.comment.detail.CommentDetailPresenter$getCommentDetail$2
            @Override // ik.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final e0<? extends ArrayList<CommentBean>> i(@k CommentDetailBean it2) {
                f0.p(it2, "it");
                return z.m3(it2.getList());
            }
        };
        z zVarS0 = zVarY1.l2(new o() { // from class: com.flydigi.community.ui.comment.detail.g
            @Override // dj.o
            public final Object apply(Object obj) {
                return CommentDetailPresenter.K0(commentDetailPresenter$getCommentDetail$2, obj);
            }
        }).s0(o5.l.d());
        final l<ArrayList<CommentBean>, z1> lVar2 = new l<ArrayList<CommentBean>, z1>() { // from class: com.flydigi.community.ui.comment.detail.CommentDetailPresenter$getCommentDetail$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(ArrayList<CommentBean> it2) {
                b.InterfaceC0137b interfaceC0137b = this.this$0.f13850d;
                boolean z10 = i11 == 1;
                f0.o(it2, "it");
                interfaceC0137b.w(z10, it2);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(ArrayList<CommentBean> arrayList) {
                b(arrayList);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.community.ui.comment.detail.f
            @Override // dj.g
            public final void accept(Object obj) {
                CommentDetailPresenter.L0(lVar2, obj);
            }
        };
        final l<Throwable, z1> lVar3 = new l<Throwable, z1>() { // from class: com.flydigi.community.ui.comment.detail.CommentDetailPresenter$getCommentDetail$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(Throwable throwable) {
                b.InterfaceC0137b interfaceC0137b = this.this$0.f13850d;
                boolean z10 = i11 == 1;
                f0.o(throwable, "throwable");
                interfaceC0137b.b(z10, throwable);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        w0().b(zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.community.ui.comment.detail.e
            @Override // dj.g
            public final void accept(Object obj) {
                CommentDetailPresenter.M0(lVar3, obj);
            }
        }));
    }
}
