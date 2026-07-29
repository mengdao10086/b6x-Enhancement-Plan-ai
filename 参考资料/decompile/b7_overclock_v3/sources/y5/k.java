package y5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import cn.jzvd.JzvdStd;
import com.flydigi.community.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class k implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final ConstraintLayout f56366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final ImageView f56367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final JzvdStd f56368c;

    public k(@n0 ConstraintLayout constraintLayout, @n0 ImageView imageView, @n0 JzvdStd jzvdStd) {
        this.f56366a = constraintLayout;
        this.f56367b = imageView;
        this.f56368c = jzvdStd;
    }

    @n0
    public static k a(@n0 View view) {
        int i10 = R.id.area_image;
        ImageView imageView = (ImageView) j2.c.a(view, i10);
        if (imageView != null) {
            i10 = R.id.area_video;
            JzvdStd jzvdStd = (JzvdStd) j2.c.a(view, i10);
            if (jzvdStd != null) {
                return new k((ConstraintLayout) view, imageView, jzvdStd);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static k c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static k d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.community_fragment_media_banner, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f56366a;
    }
}
