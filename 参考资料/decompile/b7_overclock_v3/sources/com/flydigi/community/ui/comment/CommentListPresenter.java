package com.flydigi.community.ui.comment;

import com.flydigi.base.net.BaseResponse;
import com.flydigi.community.ui.comment.d;
import com.flydigi.data.bean.community.CommentBean;
import com.flydigi.data.bean.community.CommentListBean;
import com.flydigi.data.bean.community.LikeCommentBean;
import java.util.ArrayList;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.z1;
import xi.e0;
import xi.z;

/* JADX INFO: loaded from: classes2.dex */
@t0({"SMAP\nCommentListPresenter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommentListPresenter.kt\ncom/flydigi/community/ui/comment/CommentListPresenter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,73:1\n1#2:74\n*E\n"})
public class CommentListPresenter implements d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final d.b f13834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final z5.f f13835b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final io.reactivex.disposables.a f13836c;

    public CommentListPresenter(@yt.k d.b mView) {
        f0.p(mView, "mView");
        this.f13834a = mView;
        this.f13835b = new z5.f();
        this.f13836c = new io.reactivex.disposables.a();
    }

    public static final void A0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void B0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void C0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void D0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void q0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void r0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void s0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final e0 t0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        return (e0) tmp0.i(obj);
    }

    public static final void u0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void v0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void y0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void z0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    @Override // com.flydigi.community.ui.comment.d.a
    public void C(final int i10, int i11) {
        z<R> zVarS0 = this.f13835b.z(i11).s0(o5.l.d());
        final ik.l<LikeCommentBean, z1> lVar = new ik.l<LikeCommentBean, z1>() { // from class: com.flydigi.community.ui.comment.CommentListPresenter$likeComment$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(LikeCommentBean likeCommentBean) {
                this.this$0.f13834a.S1(i10);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(LikeCommentBean likeCommentBean) {
                b(likeCommentBean);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.community.ui.comment.m
            @Override // dj.g
            public final void accept(Object obj) {
                CommentListPresenter.y0(lVar, obj);
            }
        };
        final ik.l<Throwable, z1> lVar2 = new ik.l<Throwable, z1>() { // from class: com.flydigi.community.ui.comment.CommentListPresenter$likeComment$2
            {
                super(1);
            }

            public final void b(Throwable th2) {
                this.this$0.f13834a.K(th2.getMessage());
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        this.f13836c.b(zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.community.ui.comment.q
            @Override // dj.g
            public final void accept(Object obj) {
                CommentListPresenter.z0(lVar2, obj);
            }
        }));
    }

    @Override // com.flydigi.community.ui.comment.d.a
    public void I(int i10, int i11, int i12, int i13, int i14, int i15, @yt.k String content, final int i16) {
        f0.p(content, "content");
        z<R> zVarS0 = this.f13835b.v(i10, i11, i12, i13, i14, i15, content).s0(o5.l.d());
        final ik.l<CommentBean, z1> lVar = new ik.l<CommentBean, z1>() { // from class: com.flydigi.community.ui.comment.CommentListPresenter$sendComment$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(CommentBean it2) {
                d.b bVar = this.this$0.f13834a;
                f0.o(it2, "it");
                bVar.N2(it2, i16);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(CommentBean commentBean) {
                b(commentBean);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.community.ui.comment.o
            @Override // dj.g
            public final void accept(Object obj) {
                CommentListPresenter.A0(lVar, obj);
            }
        };
        final ik.l<Throwable, z1> lVar2 = new ik.l<Throwable, z1>() { // from class: com.flydigi.community.ui.comment.CommentListPresenter$sendComment$2
            {
                super(1);
            }

            public final void b(Throwable th2) {
                this.this$0.f13834a.B(th2.getMessage());
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        this.f13836c.b(zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.community.ui.comment.j
            @Override // dj.g
            public final void accept(Object obj) {
                CommentListPresenter.B0(lVar2, obj);
            }
        }));
    }

    @Override // com.flydigi.community.ui.comment.d.a
    public void L(final int i10, int i11) {
        z<R> zVarS0 = this.f13835b.q(i11).s0(o5.l.d());
        final ik.l<BaseResponse<?>, z1> lVar = new ik.l<BaseResponse<?>, z1>() { // from class: com.flydigi.community.ui.comment.CommentListPresenter$deleteComment$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(BaseResponse<?> baseResponse) {
                this.this$0.f13834a.d1(i10);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(BaseResponse<?> baseResponse) {
                b(baseResponse);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.community.ui.comment.l
            @Override // dj.g
            public final void accept(Object obj) {
                CommentListPresenter.q0(lVar, obj);
            }
        };
        final CommentListPresenter$deleteComment$2 commentListPresenter$deleteComment$2 = new ik.l<Throwable, z1>() { // from class: com.flydigi.community.ui.comment.CommentListPresenter$deleteComment$2
            public final void b(Throwable th2) {
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        this.f13836c.b(zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.community.ui.comment.p
            @Override // dj.g
            public final void accept(Object obj) {
                CommentListPresenter.r0(commentListPresenter$deleteComment$2, obj);
            }
        }));
    }

    @Override // com.flydigi.community.ui.comment.d.a
    public void N(final int i10, int i11) {
        z<R> zVarS0 = this.f13835b.z(i11).s0(o5.l.d());
        final ik.l<LikeCommentBean, z1> lVar = new ik.l<LikeCommentBean, z1>() { // from class: com.flydigi.community.ui.comment.CommentListPresenter$unlikeComment$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(LikeCommentBean likeCommentBean) {
                this.this$0.f13834a.d0(i10);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(LikeCommentBean likeCommentBean) {
                b(likeCommentBean);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.community.ui.comment.i
            @Override // dj.g
            public final void accept(Object obj) {
                CommentListPresenter.C0(lVar, obj);
            }
        };
        final ik.l<Throwable, z1> lVar2 = new ik.l<Throwable, z1>() { // from class: com.flydigi.community.ui.comment.CommentListPresenter$unlikeComment$2
            {
                super(1);
            }

            public final void b(Throwable th2) {
                this.this$0.f13834a.K1(th2.getMessage());
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        this.f13836c.b(zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.community.ui.comment.r
            @Override // dj.g
            public final void accept(Object obj) {
                CommentListPresenter.D0(lVar2, obj);
            }
        }));
    }

    @Override // com.flydigi.community.ui.comment.d.a
    public void Y(int i10, @yt.k final String sort, final int i11, int i12) {
        f0.p(sort, "sort");
        z<CommentListBean> zVarT = this.f13835b.t(i10, sort, i11, i12);
        final ik.l<CommentListBean, z1> lVar = new ik.l<CommentListBean, z1>() { // from class: com.flydigi.community.ui.comment.CommentListPresenter$getCommentList$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(CommentListBean commentListBean) {
                this.this$0.f13834a.e1(commentListBean.getAllCount(), sort);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(CommentListBean commentListBean) {
                b(commentListBean);
                return z1.f38230a;
            }
        };
        z<CommentListBean> zVarY1 = zVarT.Y1(new dj.g() { // from class: com.flydigi.community.ui.comment.n
            @Override // dj.g
            public final void accept(Object obj) {
                CommentListPresenter.s0(lVar, obj);
            }
        });
        final CommentListPresenter$getCommentList$2 commentListPresenter$getCommentList$2 = new ik.l<CommentListBean, e0<? extends ArrayList<CommentBean>>>() { // from class: com.flydigi.community.ui.comment.CommentListPresenter$getCommentList$2
            @Override // ik.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final e0<? extends ArrayList<CommentBean>> i(@yt.k CommentListBean it2) {
                f0.p(it2, "it");
                return z.m3(it2.getList());
            }
        };
        z zVarS0 = zVarY1.l2(new dj.o() { // from class: com.flydigi.community.ui.comment.k
            @Override // dj.o
            public final Object apply(Object obj) {
                return CommentListPresenter.t0(commentListPresenter$getCommentList$2, obj);
            }
        }).s0(o5.l.d());
        final ik.l<ArrayList<CommentBean>, z1> lVar2 = new ik.l<ArrayList<CommentBean>, z1>() { // from class: com.flydigi.community.ui.comment.CommentListPresenter$getCommentList$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(ArrayList<CommentBean> comments) {
                d.b bVar = this.this$0.f13834a;
                boolean z10 = i11 == 1;
                f0.o(comments, "comments");
                bVar.w(z10, comments);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(ArrayList<CommentBean> arrayList) {
                b(arrayList);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.community.ui.comment.t
            @Override // dj.g
            public final void accept(Object obj) {
                CommentListPresenter.u0(lVar2, obj);
            }
        };
        final ik.l<Throwable, z1> lVar3 = new ik.l<Throwable, z1>() { // from class: com.flydigi.community.ui.comment.CommentListPresenter$getCommentList$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(Throwable throwable) {
                d.b bVar = this.this$0.f13834a;
                boolean z10 = i11 == 1;
                f0.o(throwable, "throwable");
                bVar.b(z10, throwable);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        this.f13836c.b(zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.community.ui.comment.s
            @Override // dj.g
            public final void accept(Object obj) {
                CommentListPresenter.v0(lVar3, obj);
            }
        }));
    }

    @yt.k
    public final io.reactivex.disposables.a w0() {
        return this.f13836c;
    }

    @yt.k
    public final z5.f x0() {
        return this.f13835b;
    }
}
