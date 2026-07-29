package com.flydigi.community.ui.topic;

import com.flydigi.base.common.n;
import com.flydigi.community.ui.topic.a;
import com.flydigi.data.bean.community.TopicBean;
import com.flydigi.data.bean.community.TopicListBean;
import dj.g;
import dj.o;
import ik.l;
import java.util.ArrayList;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.z1;
import xi.z;
import yt.k;
import z5.f;

/* JADX INFO: loaded from: classes2.dex */
@t0({"SMAP\nTopicListPresenter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TopicListPresenter.kt\ncom/flydigi/community/ui/topic/TopicListPresenter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,26:1\n1#2:27\n*E\n"})
public final class TopicListPresenter implements a.InterfaceC0149a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final a.b f14088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public f f14089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @k
    public final io.reactivex.disposables.a f14090c;

    public TopicListPresenter(@k a.b mView) {
        f0.p(mView, "mView");
        this.f14088a = mView;
        this.f14089b = new f();
        this.f14090c = new io.reactivex.disposables.a();
    }

    public static final ArrayList h0(l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        return (ArrayList) tmp0.i(obj);
    }

    public static final void i0(l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void j0(l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    @k
    public final a.b g0() {
        return this.f14088a;
    }

    @Override // com.flydigi.community.ui.topic.a.InterfaceC0149a
    public void j(final int i10, int i11) {
        z<TopicListBean> zVarO = this.f14089b.o(false, i10, i11);
        final TopicListPresenter$loadData$1 topicListPresenter$loadData$1 = new PropertyReference1Impl() { // from class: com.flydigi.community.ui.topic.TopicListPresenter$loadData$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.p
            @yt.l
            public Object get(@yt.l Object obj) {
                return ((TopicListBean) obj).getTopics();
            }
        };
        z zVarS0 = zVarO.A3(new o() { // from class: com.flydigi.community.ui.topic.d
            @Override // dj.o
            public final Object apply(Object obj) {
                return TopicListPresenter.h0(topicListPresenter$loadData$1, obj);
            }
        }).s0(o5.l.d());
        final l<ArrayList<TopicBean>, z1> lVar = new l<ArrayList<TopicBean>, z1>() { // from class: com.flydigi.community.ui.topic.TopicListPresenter$loadData$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(ArrayList<TopicBean> it2) {
                a.b bVarG0 = this.this$0.g0();
                int i12 = i10;
                f0.o(it2, "it");
                bVarG0.q0(i12, it2);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(ArrayList<TopicBean> arrayList) {
                b(arrayList);
                return z1.f38230a;
            }
        };
        g gVar = new g() { // from class: com.flydigi.community.ui.topic.c
            @Override // dj.g
            public final void accept(Object obj) {
                TopicListPresenter.i0(lVar, obj);
            }
        };
        final TopicListPresenter$loadData$3 topicListPresenter$loadData$3 = new l<Throwable, z1>() { // from class: com.flydigi.community.ui.topic.TopicListPresenter$loadData$3
            public final void b(Throwable th2) {
                n.c(th2.getMessage(), new Object[0]);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        this.f14090c.b(zVarS0.F5(gVar, new g() { // from class: com.flydigi.community.ui.topic.b
            @Override // dj.g
            public final void accept(Object obj) {
                TopicListPresenter.j0(topicListPresenter$loadData$3, obj);
            }
        }));
    }
}
