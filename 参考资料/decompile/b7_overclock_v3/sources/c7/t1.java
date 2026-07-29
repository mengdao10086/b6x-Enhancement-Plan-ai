package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.flydigi.device_manager.R;

/* JADX INFO: loaded from: classes7.dex */
public final class t1 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final LinearLayout f10480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final LinearLayout f10481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final View f10482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final TextView f10483d;

    public t1(@g.n0 LinearLayout linearLayout, @g.n0 LinearLayout linearLayout2, @g.n0 View view, @g.n0 TextView textView) {
        this.f10480a = linearLayout;
        this.f10481b = linearLayout2;
        this.f10482c = view;
        this.f10483d = textView;
    }

    @g.n0
    public static t1 a(@g.n0 View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i10 = R.id.iv_flag;
        View viewA = j2.c.a(view, i10);
        if (viewA != null) {
            i10 = R.id.tv_category_name;
            TextView textView = (TextView) j2.c.a(view, i10);
            if (textView != null) {
                return new t1(linearLayout, linearLayout, viewA, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static t1 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static t1 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_item_device_category, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f10480a;
    }
}
