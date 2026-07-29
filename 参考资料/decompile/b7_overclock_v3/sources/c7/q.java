package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.flydigi.device_manager.R;

/* JADX INFO: loaded from: classes7.dex */
public final class q implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final RelativeLayout f10354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final LinearLayout f10355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final TextView f10356c;

    public q(@g.n0 RelativeLayout relativeLayout, @g.n0 LinearLayout linearLayout, @g.n0 TextView textView) {
        this.f10354a = relativeLayout;
        this.f10355b = linearLayout;
        this.f10356c = textView;
    }

    @g.n0
    public static q a(@g.n0 View view) {
        int i10 = R.id.layout_parent;
        LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
        if (linearLayout != null) {
            i10 = R.id.name;
            TextView textView = (TextView) j2.c.a(view, i10);
            if (textView != null) {
                return new q((RelativeLayout) view, linearLayout, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static q c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static q d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_cjzc_item_config, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f10354a;
    }
}
