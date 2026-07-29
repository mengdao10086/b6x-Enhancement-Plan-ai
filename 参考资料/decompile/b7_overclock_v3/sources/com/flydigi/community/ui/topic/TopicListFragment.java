package com.flydigi.community.ui.topic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.core.os.e;
import androidx.fragment.app.g;
import com.flydigi.action.ArticleReadLog;
import com.flydigi.base.common.FZRecyclerViewFragment;
import com.flydigi.community.ui.topic.a;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.community.TopicBean;
import ei.h;
import hk.m;
import i9.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.t;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.u;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes2.dex */
@t0({"SMAP\nTopicListFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TopicListFragment.kt\ncom/flydigi/community/ui/topic/TopicListFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,94:1\n1549#2:95\n1620#2,3:96\n*S KotlinDebug\n*F\n+ 1 TopicListFragment.kt\ncom/flydigi/community/ui/topic/TopicListFragment\n*L\n34#1:95\n34#1:96,3\n*E\n"})
public final class TopicListFragment extends FZRecyclerViewFragment implements a.b {

    /* JADX INFO: renamed from: x8, reason: collision with root package name */
    @k
    public static final a f14085x8 = new a(null);

    /* JADX INFO: renamed from: v8, reason: collision with root package name */
    public a.InterfaceC0149a f14086v8;

    /* JADX INFO: renamed from: w8, reason: collision with root package name */
    public boolean f14087w8;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @m
        @k
        public final TopicListFragment a(boolean z10) {
            TopicListFragment topicListFragment = new TopicListFragment();
            topicListFragment.c5(e.b(new Pair(a.b.f31934s, Boolean.valueOf(z10))));
            return topicListFragment;
        }
    }

    @m
    @k
    public static final TopicListFragment j6(boolean z10) {
        return f14085x8.a(z10);
    }

    @Override // com.flydigi.base.common.FZRecyclerViewFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void K3(@l Bundle bundle) {
        super.K3(bundle);
        Bundle bundleT1 = T1();
        this.f14087w8 = bundleT1 != null ? bundleT1.getBoolean(a.b.f31934s) : false;
        this.f14086v8 = new TopicListPresenter(this);
    }

    @Override // eu.davidea.flexibleadapter.b.z
    public boolean M(@l View view, int i10) {
        if (d6()) {
            return false;
        }
        h hVarG2 = this.f13331r8.g2(i10);
        if (!(hVarG2 instanceof TopicItem)) {
            return false;
        }
        if (!this.f14087w8) {
            h3.a.j().d(a.b.f31918c).withString(DataConstant.COMMUNITY_ARTICLE_SOURCE, ArticleReadLog.f13283a).withParcelable(a.b.f31929n, ((TopicItem) hVarG2).z()).navigation();
            return true;
        }
        g gVarW1 = w1();
        if (gVarW1 == null) {
            return true;
        }
        Intent intent = new Intent();
        intent.putExtra(a.b.f31929n, ((TopicItem) hVarG2).z());
        gVarW1.setResult(-1, intent);
        gVarW1.finish();
        return true;
    }

    @Override // com.flydigi.base.common.FZRecyclerViewFragment
    public int c6() {
        return 10;
    }

    @Override // com.flydigi.community.ui.topic.a.b
    public void q0(int i10, @k ArrayList<TopicBean> topics) {
        f0.p(topics, "topics");
        ArrayList arrayList = new ArrayList(t.Y(topics, 10));
        Iterator<T> it2 = topics.iterator();
        while (it2.hasNext()) {
            arrayList.add(new TopicItem((TopicBean) it2.next()));
        }
        List listQ5 = CollectionsKt___CollectionsKt.Q5(arrayList);
        if (i10 != 1) {
            this.f13331r8.r3(listQ5);
        } else {
            this.f13331r8.I4(listQ5);
            this.f13329p8.N();
        }
    }

    @Override // eu.davidea.flexibleadapter.b.s
    public void y0(int i10, int i11) {
        a.InterfaceC0149a interfaceC0149a = this.f14086v8;
        if (interfaceC0149a == null) {
            f0.S("mPresenter");
            interfaceC0149a = null;
        }
        interfaceC0149a.j(i11 + 1, c6());
    }
}
