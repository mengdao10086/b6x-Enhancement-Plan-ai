package w7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.flydigi.float_view.R;

/* JADX INFO: loaded from: classes7.dex */
public final class i2 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final LinearLayout f54156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final ImageButton f54157b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final ImageView f54158c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final TextView f54159d;

    public i2(@g.n0 LinearLayout linearLayout, @g.n0 ImageButton imageButton, @g.n0 ImageView imageView, @g.n0 TextView textView) {
        this.f54156a = linearLayout;
        this.f54157b = imageButton;
        this.f54158c = imageView;
        this.f54159d = textView;
    }

    @g.n0
    public static i2 a(@g.n0 View view) {
        int i10 = R.id.iv_checkbox_status;
        ImageButton imageButton = (ImageButton) j2.c.a(view, i10);
        if (imageButton != null) {
            i10 = R.id.iv_help;
            ImageView imageView = (ImageView) j2.c.a(view, i10);
            if (imageView != null) {
                i10 = R.id.tv_checkbox_name;
                TextView textView = (TextView) j2.c.a(view, i10);
                if (textView != null) {
                    return new i2((LinearLayout) view, imageButton, imageView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static i2 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static i2 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.floatview_widget_single_checkbox_view, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f54156a;
    }
}
