package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.flydigi.device_manager.R;
import top.androidman.SuperButton;

/* JADX INFO: loaded from: classes7.dex */
public final class s0 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final FrameLayout f10440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final SuperButton f10441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final RecyclerView f10442c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final TextView f10443d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final TextView f10444e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final View f10445f;

    public s0(@g.n0 FrameLayout frameLayout, @g.n0 SuperButton superButton, @g.n0 RecyclerView recyclerView, @g.n0 TextView textView, @g.n0 TextView textView2, @g.n0 View view) {
        this.f10440a = frameLayout;
        this.f10441b = superButton;
        this.f10442c = recyclerView;
        this.f10443d = textView;
        this.f10444e = textView2;
        this.f10445f = view;
    }

    @g.n0
    public static s0 a(@g.n0 View view) {
        View viewA;
        int i10 = R.id.btn_close;
        SuperButton superButton = (SuperButton) j2.c.a(view, i10);
        if (superButton != null) {
            i10 = R.id.rv_game_list;
            RecyclerView recyclerView = (RecyclerView) j2.c.a(view, i10);
            if (recyclerView != null) {
                i10 = R.id.tv_notice;
                TextView textView = (TextView) j2.c.a(view, i10);
                if (textView != null) {
                    i10 = R.id.tv_title;
                    TextView textView2 = (TextView) j2.c.a(view, i10);
                    if (textView2 != null && (viewA = j2.c.a(view, (i10 = R.id.view_divider))) != null) {
                        return new s0((FrameLayout) view, superButton, recyclerView, textView, textView2, viewA);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static s0 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static s0 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_fragment_game_select, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f10440a;
    }
}
