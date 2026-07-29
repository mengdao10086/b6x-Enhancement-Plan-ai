package j5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.flydigi.base.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class s implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final LinearLayout f36145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final TextView f36146b;

    public s(@n0 LinearLayout linearLayout, @n0 TextView textView) {
        this.f36145a = linearLayout;
        this.f36146b = textView;
    }

    @n0
    public static s a(@n0 View view) {
        int i10 = R.id.tv_title;
        TextView textView = (TextView) j2.c.a(view, i10);
        if (textView != null) {
            return new s((LinearLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static s c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static s d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_dialog_loading, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f36145a;
    }
}
