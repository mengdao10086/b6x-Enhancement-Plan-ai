package b9;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.fdg.flashplay.farsef.R;
import g.n0;
import g.p0;
import top.androidman.SuperLinearLayout;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final SuperLinearLayout f9149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final SuperLinearLayout f9150b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final TextView f9151c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final TextView f9152d;

    public c(@n0 SuperLinearLayout superLinearLayout, @n0 SuperLinearLayout superLinearLayout2, @n0 TextView textView, @n0 TextView textView2) {
        this.f9149a = superLinearLayout;
        this.f9150b = superLinearLayout2;
        this.f9151c = textView;
        this.f9152d = textView2;
    }

    @n0
    public static c a(@n0 View view) {
        SuperLinearLayout superLinearLayout = (SuperLinearLayout) view;
        int i10 = R.id.btn_continue;
        TextView textView = (TextView) j2.c.a(view, R.id.btn_continue);
        if (textView != null) {
            i10 = R.id.btn_end;
            TextView textView2 = (TextView) j2.c.a(view, R.id.btn_end);
            if (textView2 != null) {
                return new c(superLinearLayout, superLinearLayout, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static c c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static c d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.app_view_customer_service_tip, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public SuperLinearLayout getRoot() {
        return this.f9149a;
    }
}
