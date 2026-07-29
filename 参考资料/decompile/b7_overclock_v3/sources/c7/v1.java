package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.flydigi.device_manager.R;

/* JADX INFO: loaded from: classes7.dex */
public final class v1 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final RelativeLayout f10527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final TextView f10528b;

    public v1(@g.n0 RelativeLayout relativeLayout, @g.n0 TextView textView) {
        this.f10527a = relativeLayout;
        this.f10528b = textView;
    }

    @g.n0
    public static v1 a(@g.n0 View view) {
        int i10 = R.id.tv_category_name;
        TextView textView = (TextView) j2.c.a(view, i10);
        if (textView != null) {
            return new v1((RelativeLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static v1 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static v1 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_item_device_section, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f10527a;
    }
}
