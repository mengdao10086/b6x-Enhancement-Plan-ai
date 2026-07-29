package b9;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.fdg.flashplay.farsef.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final ConstraintLayout f9145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final ImageView f9146b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final ImageView f9147c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final TextView f9148d;

    public b(@n0 ConstraintLayout constraintLayout, @n0 ImageView imageView, @n0 ImageView imageView2, @n0 TextView textView) {
        this.f9145a = constraintLayout;
        this.f9146b = imageView;
        this.f9147c = imageView2;
        this.f9148d = textView;
    }

    @n0
    public static b a(@n0 View view) {
        int i10 = R.id.iv_ad;
        ImageView imageView = (ImageView) j2.c.a(view, R.id.iv_ad);
        if (imageView != null) {
            i10 = R.id.iv_logo;
            ImageView imageView2 = (ImageView) j2.c.a(view, R.id.iv_logo);
            if (imageView2 != null) {
                i10 = R.id.tv_jump;
                TextView textView = (TextView) j2.c.a(view, R.id.tv_jump);
                if (textView != null) {
                    return new b((ConstraintLayout) view, imageView, imageView2, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static b c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static b d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.app_layout_fragment_ad, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f9145a;
    }
}
