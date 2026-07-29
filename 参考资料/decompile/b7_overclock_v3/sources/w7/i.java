package w7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.flydigi.float_view.R;

/* JADX INFO: loaded from: classes7.dex */
public final class i implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final LinearLayout f54141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final ImageView f54142b;

    public i(@g.n0 LinearLayout linearLayout, @g.n0 ImageView imageView) {
        this.f54141a = linearLayout;
        this.f54142b = imageView;
    }

    @g.n0
    public static i a(@g.n0 View view) {
        int i10 = R.id.iv_cursor;
        ImageView imageView = (ImageView) j2.c.a(view, i10);
        if (imageView != null) {
            return new i((LinearLayout) view, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static i c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static i d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.floatview_layout_cursor, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f54141a;
    }
}
