package j5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.flydigi.base.R;
import com.github.chrisbanes.photoview.PhotoView;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class w implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final RelativeLayout f36169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final ProgressBar f36170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final PhotoView f36171c;

    public w(@n0 RelativeLayout relativeLayout, @n0 ProgressBar progressBar, @n0 PhotoView photoView) {
        this.f36169a = relativeLayout;
        this.f36170b = progressBar;
        this.f36171c = photoView;
    }

    @n0
    public static w a(@n0 View view) {
        int i10 = R.id.pb_loading;
        ProgressBar progressBar = (ProgressBar) j2.c.a(view, i10);
        if (progressBar != null) {
            i10 = R.id.photo_view;
            PhotoView photoView = (PhotoView) j2.c.a(view, i10);
            if (photoView != null) {
                return new w((RelativeLayout) view, progressBar, photoView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static w c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static w d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.main_layout_fragment_image_view, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f36169a;
    }
}
