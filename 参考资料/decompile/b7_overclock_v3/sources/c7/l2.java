package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.flydigi.device_manager.R;
import top.androidman.SuperButton;

/* JADX INFO: loaded from: classes7.dex */
public final class l2 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f10193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final TextView f10194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final SuperButton f10195c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final ImageView f10196d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f10197e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final ProgressBar f10198f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final TextView f10199g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final TextView f10200h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final TextView f10201i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @g.n0
    public final TextView f10202j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @g.n0
    public final View f10203k;

    public l2(@g.n0 ConstraintLayout constraintLayout, @g.n0 TextView textView, @g.n0 SuperButton superButton, @g.n0 ImageView imageView, @g.n0 ConstraintLayout constraintLayout2, @g.n0 ProgressBar progressBar, @g.n0 TextView textView2, @g.n0 TextView textView3, @g.n0 TextView textView4, @g.n0 TextView textView5, @g.n0 View view) {
        this.f10193a = constraintLayout;
        this.f10194b = textView;
        this.f10195c = superButton;
        this.f10196d = imageView;
        this.f10197e = constraintLayout2;
        this.f10198f = progressBar;
        this.f10199g = textView2;
        this.f10200h = textView3;
        this.f10201i = textView4;
        this.f10202j = textView5;
        this.f10203k = view;
    }

    @g.n0
    public static l2 a(@g.n0 View view) {
        View viewA;
        int i10 = R.id.btn_action;
        TextView textView = (TextView) j2.c.a(view, i10);
        if (textView != null) {
            i10 = R.id.btn_close;
            SuperButton superButton = (SuperButton) j2.c.a(view, i10);
            if (superButton != null) {
                i10 = R.id.iv_icon;
                ImageView imageView = (ImageView) j2.c.a(view, i10);
                if (imageView != null) {
                    i10 = R.id.ll_game_status;
                    ConstraintLayout constraintLayout = (ConstraintLayout) j2.c.a(view, i10);
                    if (constraintLayout != null) {
                        i10 = R.id.pb_download;
                        ProgressBar progressBar = (ProgressBar) j2.c.a(view, i10);
                        if (progressBar != null) {
                            i10 = R.id.tv_size_ratio;
                            TextView textView2 = (TextView) j2.c.a(view, i10);
                            if (textView2 != null) {
                                i10 = R.id.tv_speed;
                                TextView textView3 = (TextView) j2.c.a(view, i10);
                                if (textView3 != null) {
                                    i10 = R.id.tv_tag;
                                    TextView textView4 = (TextView) j2.c.a(view, i10);
                                    if (textView4 != null) {
                                        i10 = R.id.tv_title;
                                        TextView textView5 = (TextView) j2.c.a(view, i10);
                                        if (textView5 != null && (viewA = j2.c.a(view, (i10 = R.id.view_divider))) != null) {
                                            return new l2((ConstraintLayout) view, textView, superButton, imageView, constraintLayout, progressBar, textView2, textView3, textView4, textView5, viewA);
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
    public static l2 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static l2 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_item_recommend_game, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f10193a;
    }
}
