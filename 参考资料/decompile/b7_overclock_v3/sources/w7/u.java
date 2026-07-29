package w7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.flydigi.float_view.R;

/* JADX INFO: loaded from: classes7.dex */
public final class u implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final RelativeLayout f54470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final ImageView f54471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final ImageView f54472c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final AppCompatTextView f54473d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final TextView f54474e;

    public u(@g.n0 RelativeLayout relativeLayout, @g.n0 ImageView imageView, @g.n0 ImageView imageView2, @g.n0 AppCompatTextView appCompatTextView, @g.n0 TextView textView) {
        this.f54470a = relativeLayout;
        this.f54471b = imageView;
        this.f54472c = imageView2;
        this.f54473d = appCompatTextView;
        this.f54474e = textView;
    }

    @g.n0
    public static u a(@g.n0 View view) {
        int i10 = R.id.iv_bg;
        ImageView imageView = (ImageView) j2.c.a(view, i10);
        if (imageView != null) {
            i10 = R.id.iv_key;
            ImageView imageView2 = (ImageView) j2.c.a(view, i10);
            if (imageView2 != null) {
                i10 = R.id.tv_key;
                AppCompatTextView appCompatTextView = (AppCompatTextView) j2.c.a(view, i10);
                if (appCompatTextView != null) {
                    i10 = R.id.tv_number;
                    TextView textView = (TextView) j2.c.a(view, i10);
                    if (textView != null) {
                        return new u((RelativeLayout) view, imageView, imageView2, appCompatTextView, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static u c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static u d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.floatview_layout_key, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f54470a;
    }
}
