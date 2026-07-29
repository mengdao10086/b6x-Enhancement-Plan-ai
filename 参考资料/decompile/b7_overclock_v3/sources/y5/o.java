package y5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.flydigi.community.R;
import g.n0;
import g.p0;
import top.androidman.SuperButton;

/* JADX INFO: loaded from: classes2.dex */
public final class o implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final ConstraintLayout f56394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final SuperButton f56395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final ImageView f56396c;

    public o(@n0 ConstraintLayout constraintLayout, @n0 SuperButton superButton, @n0 ImageView imageView) {
        this.f56394a = constraintLayout;
        this.f56395b = superButton;
        this.f56396c = imageView;
    }

    @n0
    public static o a(@n0 View view) {
        int i10 = R.id.iv_add;
        SuperButton superButton = (SuperButton) j2.c.a(view, i10);
        if (superButton != null) {
            i10 = R.id.iv_image;
            ImageView imageView = (ImageView) j2.c.a(view, i10);
            if (imageView != null) {
                return new o((ConstraintLayout) view, superButton, imageView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static o c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static o d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.community_item_add_media, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f56394a;
    }
}
