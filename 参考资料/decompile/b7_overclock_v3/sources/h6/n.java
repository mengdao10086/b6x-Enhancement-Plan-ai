package h6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.flydigi.cyberfox.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes7.dex */
public final class n implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final LinearLayout f30664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final TextView f30665b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final ImageView f30666c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final TextView f30667d;

    public n(@n0 LinearLayout linearLayout, @n0 TextView textView, @n0 ImageView imageView, @n0 TextView textView2) {
        this.f30664a = linearLayout;
        this.f30665b = textView;
        this.f30666c = imageView;
        this.f30667d = textView2;
    }

    @n0
    public static n a(@n0 View view) {
        int i10 = R.id.name;
        TextView textView = (TextView) j2.c.a(view, i10);
        if (textView != null) {
            i10 = R.id.rssi_icon;
            ImageView imageView = (ImageView) j2.c.a(view, i10);
            if (imageView != null) {
                i10 = R.id.rssi_value;
                TextView textView2 = (TextView) j2.c.a(view, i10);
                if (textView2 != null) {
                    return new n((LinearLayout) view, textView, imageView, textView2);
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
        View viewInflate = layoutInflater.inflate(R.layout.device_item, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f30664a;
    }
}
