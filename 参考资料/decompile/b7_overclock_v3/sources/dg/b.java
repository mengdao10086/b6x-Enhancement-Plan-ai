package dg;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.permissionx.guolindev.R;
import g.n0;
import g.p0;
import j2.c;

/* JADX INFO: loaded from: classes5.dex */
public final class b implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final LinearLayout f26254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final ImageView f26255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final TextView f26256c;

    public b(@n0 LinearLayout linearLayout, @n0 ImageView imageView, @n0 TextView textView) {
        this.f26254a = linearLayout;
        this.f26255b = imageView;
        this.f26256c = textView;
    }

    @n0
    public static b a(@n0 View view) {
        int i10 = R.id.permissionIcon;
        ImageView imageView = (ImageView) c.a(view, i10);
        if (imageView != null) {
            i10 = R.id.permissionText;
            TextView textView = (TextView) c.a(view, i10);
            if (textView != null) {
                return new b((LinearLayout) view, imageView, textView);
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
        View viewInflate = layoutInflater.inflate(R.layout.permissionx_permission_item, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f26254a;
    }
}
