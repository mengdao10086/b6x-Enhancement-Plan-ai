package y5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.flydigi.community.R;
import g.n0;
import g.p0;
import top.androidman.SuperButton;

/* JADX INFO: loaded from: classes2.dex */
public final class n implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final ConstraintLayout f56390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final SuperButton f56391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final ImageView f56392c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final TextView f56393d;

    public n(@n0 ConstraintLayout constraintLayout, @n0 SuperButton superButton, @n0 ImageView imageView, @n0 TextView textView) {
        this.f56390a = constraintLayout;
        this.f56391b = superButton;
        this.f56392c = imageView;
        this.f56393d = textView;
    }

    @n0
    public static n a(@n0 View view) {
        int i10 = R.id.btn_remove;
        SuperButton superButton = (SuperButton) j2.c.a(view, i10);
        if (superButton != null) {
            i10 = R.id.iv_image;
            ImageView imageView = (ImageView) j2.c.a(view, i10);
            if (imageView != null) {
                i10 = R.id.tv_addon_count;
                TextView textView = (TextView) j2.c.a(view, i10);
                if (textView != null) {
                    return new n((ConstraintLayout) view, superButton, imageView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static n c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static n d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.community_item_add_image, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f56390a;
    }
}
