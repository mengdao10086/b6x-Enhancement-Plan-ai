package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.flydigi.device_manager.R;

/* JADX INFO: loaded from: classes7.dex */
public final class q1 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final LinearLayout f10363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final LinearLayout f10364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final LinearLayout f10365c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final LinearLayout f10366d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final LinearLayout f10367e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final RecyclerView f10368f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final RecyclerView f10369g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final RecyclerView f10370h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final TextView f10371i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @g.n0
    public final TextView f10372j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @g.n0
    public final TextView f10373k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @g.n0
    public final TextView f10374l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @g.n0
    public final TextView f10375m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @g.n0
    public final TextView f10376n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @g.n0
    public final TextView f10377o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @g.n0
    public final TextView f10378p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @g.n0
    public final TextView f10379q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @g.n0
    public final TextView f10380r;

    public q1(@g.n0 LinearLayout linearLayout, @g.n0 LinearLayout linearLayout2, @g.n0 LinearLayout linearLayout3, @g.n0 LinearLayout linearLayout4, @g.n0 LinearLayout linearLayout5, @g.n0 RecyclerView recyclerView, @g.n0 RecyclerView recyclerView2, @g.n0 RecyclerView recyclerView3, @g.n0 TextView textView, @g.n0 TextView textView2, @g.n0 TextView textView3, @g.n0 TextView textView4, @g.n0 TextView textView5, @g.n0 TextView textView6, @g.n0 TextView textView7, @g.n0 TextView textView8, @g.n0 TextView textView9, @g.n0 TextView textView10) {
        this.f10363a = linearLayout;
        this.f10364b = linearLayout2;
        this.f10365c = linearLayout3;
        this.f10366d = linearLayout4;
        this.f10367e = linearLayout5;
        this.f10368f = recyclerView;
        this.f10369g = recyclerView2;
        this.f10370h = recyclerView3;
        this.f10371i = textView;
        this.f10372j = textView2;
        this.f10373k = textView3;
        this.f10374l = textView4;
        this.f10375m = textView5;
        this.f10376n = textView6;
        this.f10377o = textView7;
        this.f10378p = textView8;
        this.f10379q = textView9;
        this.f10380r = textView10;
    }

    @g.n0
    public static q1 a(@g.n0 View view) {
        int i10 = R.id.ll_cloud_config;
        LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
        if (linearLayout != null) {
            i10 = R.id.ll_cloud_config_detail;
            LinearLayout linearLayout2 = (LinearLayout) j2.c.a(view, i10);
            if (linearLayout2 != null) {
                i10 = R.id.ll_local_config;
                LinearLayout linearLayout3 = (LinearLayout) j2.c.a(view, i10);
                if (linearLayout3 != null) {
                    i10 = R.id.ll_local_config_detail;
                    LinearLayout linearLayout4 = (LinearLayout) j2.c.a(view, i10);
                    if (linearLayout4 != null) {
                        i10 = R.id.rv_cloud_config;
                        RecyclerView recyclerView = (RecyclerView) j2.c.a(view, i10);
                        if (recyclerView != null) {
                            i10 = R.id.rv_game_list;
                            RecyclerView recyclerView2 = (RecyclerView) j2.c.a(view, i10);
                            if (recyclerView2 != null) {
                                i10 = R.id.rv_local_config;
                                RecyclerView recyclerView3 = (RecyclerView) j2.c.a(view, i10);
                                if (recyclerView3 != null) {
                                    i10 = R.id.tv_cloud_down;
                                    TextView textView = (TextView) j2.c.a(view, i10);
                                    if (textView != null) {
                                        i10 = R.id.tv_cloud_edit;
                                        TextView textView2 = (TextView) j2.c.a(view, i10);
                                        if (textView2 != null) {
                                            i10 = R.id.tv_cloud_remove;
                                            TextView textView3 = (TextView) j2.c.a(view, i10);
                                            if (textView3 != null) {
                                                i10 = R.id.tv_cloud_select_all;
                                                TextView textView4 = (TextView) j2.c.a(view, i10);
                                                if (textView4 != null) {
                                                    i10 = R.id.tv_cloud_share;
                                                    TextView textView5 = (TextView) j2.c.a(view, i10);
                                                    if (textView5 != null) {
                                                        i10 = R.id.tv_local_edit;
                                                        TextView textView6 = (TextView) j2.c.a(view, i10);
                                                        if (textView6 != null) {
                                                            i10 = R.id.tv_local_remove;
                                                            TextView textView7 = (TextView) j2.c.a(view, i10);
                                                            if (textView7 != null) {
                                                                i10 = R.id.tv_local_select_all;
                                                                TextView textView8 = (TextView) j2.c.a(view, i10);
                                                                if (textView8 != null) {
                                                                    i10 = R.id.tv_local_upload;
                                                                    TextView textView9 = (TextView) j2.c.a(view, i10);
                                                                    if (textView9 != null) {
                                                                        i10 = R.id.tv_title_cloud;
                                                                        TextView textView10 = (TextView) j2.c.a(view, i10);
                                                                        if (textView10 != null) {
                                                                            return new q1((LinearLayout) view, linearLayout, linearLayout2, linearLayout3, linearLayout4, recyclerView, recyclerView2, recyclerView3, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10);
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

    @g.n0
    public static q1 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static q1 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_fragment_sync_config, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f10363a;
    }
}
