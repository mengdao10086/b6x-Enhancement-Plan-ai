package y5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.flydigi.community.R;
import com.google.android.material.imageview.ShapeableImageView;
import g.n0;
import g.p0;
import top.androidman.SuperButton;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final ConstraintLayout f56241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final Toolbar f56242b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final LinearLayout f56243c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final SuperButton f56244d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final SuperButton f56245e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final SuperButton f56246f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @n0
    public final LinearLayout f56247g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @n0
    public final SuperButton f56248h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @n0
    public final FrameLayout f56249i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @n0
    public final FrameLayout f56250j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @n0
    public final ConstraintLayout f56251k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @n0
    public final ShapeableImageView f56252l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @n0
    public final SuperButton f56253m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @n0
    public final TextView f56254n;

    public a(@n0 ConstraintLayout constraintLayout, @n0 Toolbar toolbar, @n0 LinearLayout linearLayout, @n0 SuperButton superButton, @n0 SuperButton superButton2, @n0 SuperButton superButton3, @n0 LinearLayout linearLayout2, @n0 SuperButton superButton4, @n0 FrameLayout frameLayout, @n0 FrameLayout frameLayout2, @n0 ConstraintLayout constraintLayout2, @n0 ShapeableImageView shapeableImageView, @n0 SuperButton superButton5, @n0 TextView textView) {
        this.f56241a = constraintLayout;
        this.f56242b = toolbar;
        this.f56243c = linearLayout;
        this.f56244d = superButton;
        this.f56245e = superButton2;
        this.f56246f = superButton3;
        this.f56247g = linearLayout2;
        this.f56248h = superButton4;
        this.f56249i = frameLayout;
        this.f56250j = frameLayout2;
        this.f56251k = constraintLayout2;
        this.f56252l = shapeableImageView;
        this.f56253m = superButton5;
        this.f56254n = textView;
    }

    @n0
    public static a a(@n0 View view) {
        int i10 = R.id.appbar_layout_toolbar;
        Toolbar toolbar = (Toolbar) j2.c.a(view, i10);
        if (toolbar != null) {
            i10 = R.id.area_comment_content;
            LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
            if (linearLayout != null) {
                i10 = R.id.btn_close;
                SuperButton superButton = (SuperButton) j2.c.a(view, i10);
                if (superButton != null) {
                    i10 = R.id.btn_comment;
                    SuperButton superButton2 = (SuperButton) j2.c.a(view, i10);
                    if (superButton2 != null) {
                        i10 = R.id.btn_like;
                        SuperButton superButton3 = (SuperButton) j2.c.a(view, i10);
                        if (superButton3 != null) {
                            i10 = R.id.btn_send_comment;
                            LinearLayout linearLayout2 = (LinearLayout) j2.c.a(view, i10);
                            if (linearLayout2 != null) {
                                i10 = R.id.btn_share;
                                SuperButton superButton4 = (SuperButton) j2.c.a(view, i10);
                                if (superButton4 != null) {
                                    i10 = R.id.container_article;
                                    FrameLayout frameLayout = (FrameLayout) j2.c.a(view, i10);
                                    if (frameLayout != null) {
                                        i10 = R.id.container_comment;
                                        FrameLayout frameLayout2 = (FrameLayout) j2.c.a(view, i10);
                                        if (frameLayout2 != null) {
                                            ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                            i10 = R.id.iv_avatar;
                                            ShapeableImageView shapeableImageView = (ShapeableImageView) j2.c.a(view, i10);
                                            if (shapeableImageView != null) {
                                                i10 = R.id.tv_send_comment;
                                                SuperButton superButton5 = (SuperButton) j2.c.a(view, i10);
                                                if (superButton5 != null) {
                                                    i10 = R.id.tv_title;
                                                    TextView textView = (TextView) j2.c.a(view, i10);
                                                    if (textView != null) {
                                                        return new a(constraintLayout, toolbar, linearLayout, superButton, superButton2, superButton3, linearLayout2, superButton4, frameLayout, frameLayout2, constraintLayout, shapeableImageView, superButton5, textView);
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
    public static a c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static a d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.community_activity_article_detail, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f56241a;
    }
}
