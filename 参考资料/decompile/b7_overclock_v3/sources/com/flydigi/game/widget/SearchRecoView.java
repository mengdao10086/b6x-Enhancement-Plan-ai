package com.flydigi.game.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.flydigi.base.common.i;
import com.flydigi.data.DataConstant;
import com.flydigi.game.R;
import com.flydigi.game.data.bean.SearchRecoBean;
import com.flydigi.game.widget.SearchRecoView;
import g.n0;
import g.p0;
import g.v0;
import i9.a;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class SearchRecoView extends i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f15970c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f15971d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f15972e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f15973f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f15974g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f15975h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ImageView f15976i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f15977j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextView f15978k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ImageView f15979l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextView f15980m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TextView f15981n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ImageView f15982o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TextView f15983p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public TextView f15984q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ImageView f15985r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public TextView f15986s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public TextView f15987t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public LinearLayout f15988u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public LinearLayout f15989v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public LinearLayout f15990w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public LinearLayout f15991x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public LinearLayout f15992y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public LinearLayout f15993z;

    public SearchRecoView(@n0 Context context) {
        super(context);
    }

    public static /* synthetic */ void j(SearchRecoBean searchRecoBean, View view) {
        h3.a.j().d(a.e.f31969e).withString(DataConstant.KEY_GAME_ID, searchRecoBean.f15821id).navigation();
    }

    @Override // com.flydigi.base.common.i
    public void f(AttributeSet attributeSet) {
        this.f15988u = (LinearLayout) findViewById(R.id.ll_1);
        this.f15970c = (ImageView) findViewById(R.id.iv_icon_1);
        this.f15971d = (TextView) findViewById(R.id.tv_title_1);
        this.f15972e = (TextView) findViewById(R.id.tv_cat_1);
        this.f15989v = (LinearLayout) findViewById(R.id.ll_2);
        this.f15973f = (ImageView) findViewById(R.id.iv_icon_2);
        this.f15974g = (TextView) findViewById(R.id.tv_title_2);
        this.f15975h = (TextView) findViewById(R.id.tv_cat_2);
        this.f15990w = (LinearLayout) findViewById(R.id.ll_3);
        this.f15976i = (ImageView) findViewById(R.id.iv_icon_3);
        this.f15977j = (TextView) findViewById(R.id.tv_title_3);
        this.f15978k = (TextView) findViewById(R.id.tv_cat_3);
        this.f15991x = (LinearLayout) findViewById(R.id.ll_4);
        this.f15979l = (ImageView) findViewById(R.id.iv_icon_4);
        this.f15980m = (TextView) findViewById(R.id.tv_title_4);
        this.f15981n = (TextView) findViewById(R.id.tv_cat_4);
        this.f15992y = (LinearLayout) findViewById(R.id.ll_5);
        this.f15982o = (ImageView) findViewById(R.id.iv_icon_5);
        this.f15983p = (TextView) findViewById(R.id.tv_title_5);
        this.f15984q = (TextView) findViewById(R.id.tv_cat_5);
        this.f15993z = (LinearLayout) findViewById(R.id.ll_6);
        this.f15985r = (ImageView) findViewById(R.id.iv_icon_6);
        this.f15986s = (TextView) findViewById(R.id.tv_title_6);
        this.f15987t = (TextView) findViewById(R.id.tv_cat_6);
    }

    @Override // com.flydigi.base.common.i
    public int getLayoutId() {
        return R.layout.game_view_search_reco_view;
    }

    public final void k(final SearchRecoBean searchRecoBean, LinearLayout linearLayout, TextView textView, TextView textView2, ImageView imageView) {
        linearLayout.setVisibility(0);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: z8.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchRecoView.j(searchRecoBean, view);
            }
        });
        textView.setText(searchRecoBean.title);
        textView2.setText(com.blankj.utilcode.util.n0.o(searchRecoBean.category) ? "" : searchRecoBean.category.get(0));
        l5.a.b().h(this, imageView, searchRecoBean.thumb);
    }

    public void setData(List<SearchRecoBean> list) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            SearchRecoBean searchRecoBean = list.get(i10);
            if (i10 == 0) {
                k(searchRecoBean, this.f15988u, this.f15971d, this.f15972e, this.f15970c);
            }
            if (i10 == 1) {
                k(searchRecoBean, this.f15989v, this.f15974g, this.f15975h, this.f15973f);
            }
            if (i10 == 2) {
                k(searchRecoBean, this.f15990w, this.f15977j, this.f15978k, this.f15976i);
            }
            if (i10 == 3) {
                k(searchRecoBean, this.f15991x, this.f15980m, this.f15981n, this.f15979l);
            }
            if (i10 == 4) {
                k(searchRecoBean, this.f15992y, this.f15983p, this.f15984q, this.f15982o);
            }
            if (i10 == 5) {
                k(searchRecoBean, this.f15993z, this.f15986s, this.f15987t, this.f15985r);
            }
        }
    }

    public SearchRecoView(@n0 Context context, @p0 AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SearchRecoView(@n0 Context context, @p0 AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    @v0(api = 21)
    public SearchRecoView(@n0 Context context, @p0 AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
    }
}
