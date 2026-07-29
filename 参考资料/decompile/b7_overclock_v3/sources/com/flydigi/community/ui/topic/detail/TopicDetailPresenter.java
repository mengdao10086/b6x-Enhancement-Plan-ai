package com.flydigi.community.ui.topic.detail;

import com.flydigi.community.ui.topic.detail.e;
import com.flydigi.data.bean.community.TopicBean;
import ik.l;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.z1;
import xi.z;
import yt.k;

/* JADX INFO: loaded from: classes2.dex */
@t0({"SMAP\nTopicDetailPresenter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TopicDetailPresenter.kt\ncom/flydigi/community/ui/topic/detail/TopicDetailPresenter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,22:1\n1#2:23\n*E\n"})
public final class TopicDetailPresenter implements e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final e.b f14098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public final io.reactivex.disposables.a f14099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @k
    public final z5.f f14100c;

    public TopicDetailPresenter(@k e.b view) {
        f0.p(view, "view");
        this.f14098a = view;
        this.f14099b = new io.reactivex.disposables.a();
        this.f14100c = new z5.f();
    }

    public static final void f0(l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void g0(l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    @Override // com.flydigi.community.ui.topic.detail.e.a
    public void T(int i10) {
        z<R> zVarS0 = this.f14100c.d(i10).s0(o5.l.d());
        final l<TopicBean, z1> lVar = new l<TopicBean, z1>() { // from class: com.flydigi.community.ui.topic.detail.TopicDetailPresenter$getTopic$1
            {
                super(1);
            }

            public final void b(TopicBean it2) {
                e.b bVarH0 = this.this$0.h0();
                f0.o(it2, "it");
                bVarH0.A0(it2);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(TopicBean topicBean) {
                b(topicBean);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.community.ui.topic.detail.f
            @Override // dj.g
            public final void accept(Object obj) {
                TopicDetailPresenter.f0(lVar, obj);
            }
        };
        final l<Throwable, z1> lVar2 = new l<Throwable, z1>() { // from class: com.flydigi.community.ui.topic.detail.TopicDetailPresenter$getTopic$2
            {
                super(1);
            }

            public final void b(Throwable th2) {
                this.this$0.h0().y2(th2.getMessage());
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        this.f14099b.b(zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.community.ui.topic.detail.g
            @Override // dj.g
            public final void accept(Object obj) {
                TopicDetailPresenter.g0(lVar2, obj);
            }
        }));
    }

    @k
    public final e.b h0() {
        return this.f14098a;
    }
}
