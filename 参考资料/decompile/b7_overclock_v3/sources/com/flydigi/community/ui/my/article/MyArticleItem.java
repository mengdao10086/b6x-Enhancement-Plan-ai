package com.flydigi.community.ui.my.article;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.flydigi.base.widget.recyclerview.adapter.AbstractModelItem;
import com.flydigi.community.R;
import com.flydigi.data.bean.community.ArticleBean;
import com.flydigi.data.bean.community.ArticleTopic;
import com.flydigi.data.bean.community.TopicBean;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.v0;
import y5.c0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes2.dex */
public final class MyArticleItem extends AbstractModelItem<ArticleBean, a> {

    public static final class a extends gi.d {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @k
        public final c0 f13948g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@k View view, @k eu.davidea.flexibleadapter.b<? extends ei.h<?>> adapter) {
            super(view, adapter);
            f0.p(view, "view");
            f0.p(adapter, "adapter");
            c0 c0VarA = c0.a(view);
            f0.o(c0VarA, "bind(view)");
            this.f13948g = c0VarA;
            c0VarA.f56277c.setOnClickListener(this);
            c0VarA.f56276b.setOnClickListener(this);
        }

        @k
        public final c0 r() {
            return this.f13948g;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyArticleItem(@k ArticleBean data) {
        super(data);
        f0.p(data, "data");
    }

    @Override // ei.c, ei.h
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public void o(@l eu.davidea.flexibleadapter.b<ei.h<RecyclerView.e0>> bVar, @k a holder, int i10, @l List<Object> list) {
        String strValueOf;
        String strValueOf2;
        f0.p(holder, "holder");
        List<ArticleTopic> topics = z().getTopics();
        if (topics != null) {
            if (!topics.isEmpty()) {
                TextView textView = holder.r().f56281g;
                TopicBean topic = topics.get(0).getTopic();
                textView.setText(topic != null ? topic.getTitle() : null);
                TextView textView2 = holder.r().f56281g;
                f0.o(textView2, "holder.viewBinding.tvGame");
                o5.c.b(textView2, Boolean.TRUE, false, 2, null);
            } else {
                holder.r().f56281g.setVisibility(4);
            }
        }
        holder.r().f56280f.setText(z().getDescription());
        holder.r().f56283i.setText(d6.f.a(z().getUpdateTime()));
        TextView textView3 = holder.r().f56282h;
        if (z().getLikes() >= 10000) {
            v0 v0Var = v0.f37964a;
            strValueOf = String.format(Locale.getDefault(), "%.1fw", Arrays.copyOf(new Object[]{Float.valueOf(z().getLikes() / 10000.0f)}, 1));
            f0.o(strValueOf, "format(locale, format, *args)");
        } else {
            strValueOf = String.valueOf(z().getLikes());
        }
        textView3.setText(strValueOf);
        TextView textView4 = holder.r().f56279e;
        if (z().getComments() >= 10000) {
            v0 v0Var2 = v0.f37964a;
            strValueOf2 = String.format(Locale.getDefault(), "%.1fw", Arrays.copyOf(new Object[]{Float.valueOf(z().getComments() / 10000.0f)}, 1));
            f0.o(strValueOf2, "format(locale, format, *args)");
        } else {
            strValueOf2 = String.valueOf(z().getComments());
        }
        textView4.setText(strValueOf2);
    }

    @Override // ei.c, ei.h
    @k
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public a i(@k View view, @k eu.davidea.flexibleadapter.b<ei.h<RecyclerView.e0>> adapter) {
        f0.p(view, "view");
        f0.p(adapter, "adapter");
        return new a(view, adapter);
    }

    @Override // ei.c, ei.h
    public int c() {
        return R.layout.community_item_my_published_article;
    }
}
