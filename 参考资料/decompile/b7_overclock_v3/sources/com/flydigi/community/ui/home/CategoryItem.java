package com.flydigi.community.ui.home;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.flydigi.action.ArticleReadLog;
import com.flydigi.base.widget.recyclerview.adapter.AbstractModelItem;
import com.flydigi.community.R;
import com.flydigi.community.ui.topic.TopicItem;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.community.TopicBean;
import eu.davidea.flexibleadapter.b;
import i9.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.t;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import yt.k;

/* JADX INFO: loaded from: classes2.dex */
@t0({"SMAP\nCategoryItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CategoryItem.kt\ncom/flydigi/community/ui/home/CategoryItem\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,78:1\n1549#2:79\n1620#2,3:80\n*S KotlinDebug\n*F\n+ 1 CategoryItem.kt\ncom/flydigi/community/ui/home/CategoryItem\n*L\n39#1:79\n39#1:80,3\n*E\n"})
public final class CategoryItem extends AbstractModelItem<List<? extends TopicBean>, a> {

    public static final class a extends gi.d implements b.z {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @k
        public final eu.davidea.flexibleadapter.b<TopicItem> f13885g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@k View view, @k eu.davidea.flexibleadapter.b<?> adapter) {
            super(view, adapter);
            f0.p(view, "view");
            f0.p(adapter, "adapter");
            View viewFindViewById = view.findViewById(R.id.rv_topic);
            f0.o(viewFindViewById, "view.findViewById(R.id.rv_topic)");
            eu.davidea.flexibleadapter.b<TopicItem> bVar = new eu.davidea.flexibleadapter.b<>(null, this);
            this.f13885g = bVar;
            ((RecyclerView) viewFindViewById).setAdapter(bVar);
            view.findViewById(R.id.btn_more).setOnClickListener(this);
        }

        @Override // eu.davidea.flexibleadapter.b.z
        public boolean M(@k View view, int i10) {
            TopicItem topicItem;
            f0.p(view, "view");
            if (i10 == -1 || (topicItem = (TopicItem) this.f13885g.g2(i10)) == null) {
                return false;
            }
            h3.a.j().d(a.b.f31918c).withString(DataConstant.COMMUNITY_ARTICLE_SOURCE, ArticleReadLog.f13283a).withParcelable(a.b.f31929n, topicItem.z()).navigation();
            return true;
        }

        @k
        public final eu.davidea.flexibleadapter.b<TopicItem> r() {
            return this.f13885g;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CategoryItem(@k List<TopicBean> data) {
        super(data);
        f0.p(data, "data");
    }

    @Override // ei.c, ei.h
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public void o(@k eu.davidea.flexibleadapter.b<ei.h<?>> adapter, @k a holder, int i10, @k List<? extends Object> payloads) {
        f0.p(adapter, "adapter");
        f0.p(holder, "holder");
        f0.p(payloads, "payloads");
        List<? extends TopicBean> data = z();
        f0.o(data, "data");
        List<? extends TopicBean> list = data;
        ArrayList arrayList = new ArrayList(t.Y(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(new TopicItem((TopicBean) it2.next()));
        }
        holder.r().I4(CollectionsKt___CollectionsKt.Q5(arrayList));
    }

    @Override // ei.c, ei.h
    @k
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public a i(@k View view, @k eu.davidea.flexibleadapter.b<ei.h<?>> adapter) {
        f0.p(view, "view");
        f0.p(adapter, "adapter");
        return new a(view, adapter);
    }

    @Override // ei.c, ei.h
    public int c() {
        return R.layout.community_item_category;
    }
}
