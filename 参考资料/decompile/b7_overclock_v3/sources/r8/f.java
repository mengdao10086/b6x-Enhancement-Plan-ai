package r8;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.flydigi.base.widget.ExpandableTextView;
import com.flydigi.base.widget.ratingbar.CBRatingBar;
import com.flydigi.game.R;
import com.flydigi.game.widget.TextProgressView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes7.dex */
public final class f implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final LinearLayout f47766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final CBRatingBar f47767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final ExpandableTextView f47768c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final ImageView f47769d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final LinearLayout f47770e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final LinearLayout f47771f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @n0
    public final RelativeLayout f47772g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @n0
    public final RecyclerView f47773h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @n0
    public final SmartRefreshLayout f47774i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @n0
    public final TextProgressView f47775j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @n0
    public final TextView f47776k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @n0
    public final TextView f47777l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @n0
    public final TextView f47778m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @n0
    public final TextView f47779n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @n0
    public final TextView f47780o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @n0
    public final TextView f47781p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @n0
    public final TextView f47782q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @n0
    public final TextView f47783r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @n0
    public final TextView f47784s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @n0
    public final TextView f47785t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @n0
    public final TextView f47786u;

    public f(@n0 LinearLayout linearLayout, @n0 CBRatingBar cBRatingBar, @n0 ExpandableTextView expandableTextView, @n0 ImageView imageView, @n0 LinearLayout linearLayout2, @n0 LinearLayout linearLayout3, @n0 RelativeLayout relativeLayout, @n0 RecyclerView recyclerView, @n0 SmartRefreshLayout smartRefreshLayout, @n0 TextProgressView textProgressView, @n0 TextView textView, @n0 TextView textView2, @n0 TextView textView3, @n0 TextView textView4, @n0 TextView textView5, @n0 TextView textView6, @n0 TextView textView7, @n0 TextView textView8, @n0 TextView textView9, @n0 TextView textView10, @n0 TextView textView11) {
        this.f47766a = linearLayout;
        this.f47767b = cBRatingBar;
        this.f47768c = expandableTextView;
        this.f47769d = imageView;
        this.f47770e = linearLayout2;
        this.f47771f = linearLayout3;
        this.f47772g = relativeLayout;
        this.f47773h = recyclerView;
        this.f47774i = smartRefreshLayout;
        this.f47775j = textProgressView;
        this.f47776k = textView;
        this.f47777l = textView2;
        this.f47778m = textView3;
        this.f47779n = textView4;
        this.f47780o = textView5;
        this.f47781p = textView6;
        this.f47782q = textView7;
        this.f47783r = textView8;
        this.f47784s = textView9;
        this.f47785t = textView10;
        this.f47786u = textView11;
    }

    @n0
    public static f a(@n0 View view) {
        int i10 = R.id.cb_score;
        CBRatingBar cBRatingBar = (CBRatingBar) j2.c.a(view, i10);
        if (cBRatingBar != null) {
            i10 = R.id.expandable_text_view;
            ExpandableTextView expandableTextView = (ExpandableTextView) j2.c.a(view, i10);
            if (expandableTextView != null) {
                i10 = R.id.iv_icon;
                ImageView imageView = (ImageView) j2.c.a(view, i10);
                if (imageView != null) {
                    i10 = R.id.ll_notice;
                    LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
                    if (linearLayout != null) {
                        i10 = R.id.ll_prize;
                        LinearLayout linearLayout2 = (LinearLayout) j2.c.a(view, i10);
                        if (linearLayout2 != null) {
                            i10 = R.id.rl_group;
                            RelativeLayout relativeLayout = (RelativeLayout) j2.c.a(view, i10);
                            if (relativeLayout != null) {
                                i10 = R.id.rv_game_poster;
                                RecyclerView recyclerView = (RecyclerView) j2.c.a(view, i10);
                                if (recyclerView != null) {
                                    i10 = R.id.smart_refresh_layout;
                                    SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) j2.c.a(view, i10);
                                    if (smartRefreshLayout != null) {
                                        i10 = R.id.text_progress_view;
                                        TextProgressView textProgressView = (TextProgressView) j2.c.a(view, i10);
                                        if (textProgressView != null) {
                                            i10 = R.id.tv_copy_group_num;
                                            TextView textView = (TextView) j2.c.a(view, i10);
                                            if (textView != null) {
                                                i10 = R.id.tv_get_prize;
                                                TextView textView2 = (TextView) j2.c.a(view, i10);
                                                if (textView2 != null) {
                                                    i10 = R.id.tv_group_name;
                                                    TextView textView3 = (TextView) j2.c.a(view, i10);
                                                    if (textView3 != null) {
                                                        i10 = R.id.tv_group_num;
                                                        TextView textView4 = (TextView) j2.c.a(view, i10);
                                                        if (textView4 != null) {
                                                            i10 = R.id.tv_name;
                                                            TextView textView5 = (TextView) j2.c.a(view, i10);
                                                            if (textView5 != null) {
                                                                i10 = R.id.tv_notice;
                                                                TextView textView6 = (TextView) j2.c.a(view, i10);
                                                                if (textView6 != null) {
                                                                    i10 = R.id.tv_notice_name;
                                                                    TextView textView7 = (TextView) j2.c.a(view, i10);
                                                                    if (textView7 != null) {
                                                                        i10 = R.id.tv_prize_name;
                                                                        TextView textView8 = (TextView) j2.c.a(view, i10);
                                                                        if (textView8 != null) {
                                                                            i10 = R.id.tv_prize_num;
                                                                            TextView textView9 = (TextView) j2.c.a(view, i10);
                                                                            if (textView9 != null) {
                                                                                i10 = R.id.tv_score;
                                                                                TextView textView10 = (TextView) j2.c.a(view, i10);
                                                                                if (textView10 != null) {
                                                                                    i10 = R.id.tv_size;
                                                                                    TextView textView11 = (TextView) j2.c.a(view, i10);
                                                                                    if (textView11 != null) {
                                                                                        return new f((LinearLayout) view, cBRatingBar, expandableTextView, imageView, linearLayout, linearLayout2, relativeLayout, recyclerView, smartRefreshLayout, textProgressView, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11);
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static f c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static f d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.game_fragment_game_detail, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f47766a;
    }
}
