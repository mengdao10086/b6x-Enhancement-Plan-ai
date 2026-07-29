package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.flydigi.device_manager.R;
import top.androidman.SuperButton;

/* JADX INFO: loaded from: classes7.dex */
public final class a2 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f9804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final TextView f9805b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f9806c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final TextView f9807d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final SuperButton f9808e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final ImageView f9809f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final TextView f9810g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final TextView f9811h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final View f9812i;

    public a2(@g.n0 ConstraintLayout constraintLayout, @g.n0 TextView textView, @g.n0 ConstraintLayout constraintLayout2, @g.n0 TextView textView2, @g.n0 SuperButton superButton, @g.n0 ImageView imageView, @g.n0 TextView textView3, @g.n0 TextView textView4, @g.n0 View view) {
        this.f9804a = constraintLayout;
        this.f9805b = textView;
        this.f9806c = constraintLayout2;
        this.f9807d = textView2;
        this.f9808e = superButton;
        this.f9809f = imageView;
        this.f9810g = textView3;
        this.f9811h = textView4;
        this.f9812i = view;
    }

    @g.n0
    public static a2 a(@g.n0 View view) {
        View viewA;
        int i10 = R.id.btn_community;
        TextView textView = (TextView) j2.c.a(view, i10);
        if (textView != null) {
            i10 = R.id.btn_game_mode;
            ConstraintLayout constraintLayout = (ConstraintLayout) j2.c.a(view, i10);
            if (constraintLayout != null) {
                i10 = R.id.btn_open;
                TextView textView2 = (TextView) j2.c.a(view, i10);
                if (textView2 != null) {
                    i10 = R.id.iv_game_mode;
                    SuperButton superButton = (SuperButton) j2.c.a(view, i10);
                    if (superButton != null) {
                        i10 = R.id.iv_icon;
                        ImageView imageView = (ImageView) j2.c.a(view, i10);
                        if (imageView != null) {
                            i10 = R.id.tv_game_mode;
                            TextView textView3 = (TextView) j2.c.a(view, i10);
                            if (textView3 != null) {
                                i10 = R.id.tv_title;
                                TextView textView4 = (TextView) j2.c.a(view, i10);
                                if (textView4 != null && (viewA = j2.c.a(view, (i10 = R.id.view_divider))) != null) {
                                    return new a2((ConstraintLayout) view, textView, constraintLayout, textView2, superButton, imageView, textView3, textView4, viewA);
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
    public static a2 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static a2 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_item_local_game, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f9804a;
    }
}
