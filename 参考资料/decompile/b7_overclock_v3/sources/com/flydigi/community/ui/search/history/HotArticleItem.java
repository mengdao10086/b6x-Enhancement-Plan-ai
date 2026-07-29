package com.flydigi.community.ui.search.history;

import android.view.View;
import android.widget.TextView;
import com.flydigi.base.widget.recyclerview.adapter.AbstractModelItem;
import com.flydigi.community.R;
import com.flydigi.data.bean.community.ArticleBean;
import d6.f;
import ei.h;
import eu.davidea.flexibleadapter.b;
import gi.d;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class HotArticleItem extends AbstractModelItem<ArticleBean, a> {

    public static class a extends d {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final TextView f14065g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final TextView f14066h;

        public a(View view, b bVar) {
            super(view, bVar);
            this.f14065g = (TextView) view.findViewById(R.id.tv_title);
            this.f14066h = (TextView) view.findViewById(R.id.tv_date);
        }
    }

    public HotArticleItem(ArticleBean articleBean) {
        super(articleBean);
    }

    @Override // ei.c, ei.h
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public void o(b<h> bVar, a aVar, int i10, List<Object> list) {
        aVar.f14065g.setText(z().getTitle());
        aVar.f14066h.setText(f.a(z().getUpdateTime()));
    }

    @Override // ei.c, ei.h
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public a i(View view, b<h> bVar) {
        return new a(view, bVar);
    }

    @Override // ei.c, ei.h
    public int c() {
        return R.layout.community_item_hot_search_article;
    }
}
