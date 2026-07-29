package b9;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.fdg.flashplay.farsef.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final FrameLayout f9162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final ImageView f9163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final ImageView f9164c;

    public f(@n0 FrameLayout frameLayout, @n0 ImageView imageView, @n0 ImageView imageView2) {
        this.f9162a = frameLayout;
        this.f9163b = imageView;
        this.f9164c = imageView2;
    }

    @n0
    public static f a(@n0 View view) {
        int i10 = R.id.btn_close;
        ImageView imageView = (ImageView) j2.c.a(view, R.id.btn_close);
        if (imageView != null) {
            i10 = R.id.iv_code;
            ImageView imageView2 = (ImageView) j2.c.a(view, R.id.iv_code);
            if (imageView2 != null) {
                return new f((FrameLayout) view, imageView, imageView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static f c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static f d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.main_dialog_qrcode, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f9162a;
    }
}
