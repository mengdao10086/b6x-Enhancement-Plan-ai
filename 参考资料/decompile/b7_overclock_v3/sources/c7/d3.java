package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.flydigi.device_manager.R;

/* JADX INFO: loaded from: classes7.dex */
public final class d3 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final FrameLayout f9943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final TextView f9944b;

    public d3(@g.n0 FrameLayout frameLayout, @g.n0 TextView textView) {
        this.f9943a = frameLayout;
        this.f9944b = textView;
    }

    @g.n0
    public static d3 a(@g.n0 View view) {
        int i10 = R.id.btn_action;
        TextView textView = (TextView) j2.c.a(view, i10);
        if (textView != null) {
            return new d3((FrameLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static d3 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static d3 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.main_dialog_alpha_group_join_success, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f9943a;
    }
}
