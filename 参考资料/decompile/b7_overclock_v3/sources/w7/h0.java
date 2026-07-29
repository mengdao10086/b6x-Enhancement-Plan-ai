package w7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.flydigi.float_view.R;
import top.androidman.SuperButton;

/* JADX INFO: loaded from: classes7.dex */
public final class h0 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f54126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f54127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final SuperButton f54128c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final SuperButton f54129d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final SuperButton f54130e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final ImageView f54131f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final ImageView f54132g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final ImageView f54133h;

    public h0(@g.n0 ConstraintLayout constraintLayout, @g.n0 ConstraintLayout constraintLayout2, @g.n0 SuperButton superButton, @g.n0 SuperButton superButton2, @g.n0 SuperButton superButton3, @g.n0 ImageView imageView, @g.n0 ImageView imageView2, @g.n0 ImageView imageView3) {
        this.f54126a = constraintLayout;
        this.f54127b = constraintLayout2;
        this.f54128c = superButton;
        this.f54129d = superButton2;
        this.f54130e = superButton3;
        this.f54131f = imageView;
        this.f54132g = imageView2;
        this.f54133h = imageView3;
    }

    @g.n0
    public static h0 a(@g.n0 View view) {
        int i10 = R.id.area_operator_panel;
        ConstraintLayout constraintLayout = (ConstraintLayout) j2.c.a(view, i10);
        if (constraintLayout != null) {
            i10 = R.id.btn_delete;
            SuperButton superButton = (SuperButton) j2.c.a(view, i10);
            if (superButton != null) {
                i10 = R.id.btn_mode;
                SuperButton superButton2 = (SuperButton) j2.c.a(view, i10);
                if (superButton2 != null) {
                    i10 = R.id.btn_setting;
                    SuperButton superButton3 = (SuperButton) j2.c.a(view, i10);
                    if (superButton3 != null) {
                        i10 = R.id.iv_indicator_down;
                        ImageView imageView = (ImageView) j2.c.a(view, i10);
                        if (imageView != null) {
                            i10 = R.id.iv_indicator_left;
                            ImageView imageView2 = (ImageView) j2.c.a(view, i10);
                            if (imageView2 != null) {
                                i10 = R.id.iv_indicator_right;
                                ImageView imageView3 = (ImageView) j2.c.a(view, i10);
                                if (imageView3 != null) {
                                    return new h0((ConstraintLayout) view, constraintLayout, superButton, superButton2, superButton3, imageView, imageView2, imageView3);
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
    public static h0 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static h0 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.floatview_layout_setting_config_key_menu, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f54126a;
    }
}
