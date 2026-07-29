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
public final class a0 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final ConstraintLayout f56255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final SuperButton f56256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final ImageView f56257c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final TextView f56258d;

    public a0(@n0 ConstraintLayout constraintLayout, @n0 SuperButton superButton, @n0 ImageView imageView, @n0 TextView textView) {
        this.f56255a = constraintLayout;
        this.f56256b = superButton;
        this.f56257c = imageView;
        this.f56258d = textView;
    }

    @n0
    public static a0 a(@n0 View view) {
        int i10 = R.id.btn_remove;
        SuperButton superButton = (SuperButton) j2.c.a(view, i10);
        if (superButton != null) {
            i10 = R.id.iv_image;
            ImageView imageView = (ImageView) j2.c.a(view, i10);
            if (imageView != null) {
                i10 = R.id.tv_addon_count;
                TextView textView = (TextView) j2.c.a(view, i10);
                if (textView != null) {
                    return new a0((ConstraintLayout) view, superButton, imageView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static a0 c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static a0 d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.community_item_image, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f56255a;
    }
}
