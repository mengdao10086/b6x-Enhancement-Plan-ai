package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.flydigi.device_manager.R;
import com.google.android.material.divider.MaterialDivider;

/* JADX INFO: loaded from: classes7.dex */
public final class y implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final FrameLayout f10589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final ImageView f10590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final RecyclerView f10591c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final TextView f10592d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final MaterialDivider f10593e;

    public y(@g.n0 FrameLayout frameLayout, @g.n0 ImageView imageView, @g.n0 RecyclerView recyclerView, @g.n0 TextView textView, @g.n0 MaterialDivider materialDivider) {
        this.f10589a = frameLayout;
        this.f10590b = imageView;
        this.f10591c = recyclerView;
        this.f10592d = textView;
        this.f10593e = materialDivider;
    }

    @g.n0
    public static y a(@g.n0 View view) {
        int i10 = R.id.btn_close;
        ImageView imageView = (ImageView) j2.c.a(view, i10);
        if (imageView != null) {
            i10 = R.id.recycler_view;
            RecyclerView recyclerView = (RecyclerView) j2.c.a(view, i10);
            if (recyclerView != null) {
                i10 = R.id.tv_title;
                TextView textView = (TextView) j2.c.a(view, i10);
                if (textView != null) {
                    i10 = R.id.view_divider;
                    MaterialDivider materialDivider = (MaterialDivider) j2.c.a(view, i10);
                    if (materialDivider != null) {
                        return new y((FrameLayout) view, imageView, recyclerView, textView, materialDivider);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static y c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static y d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_dialog_introduction, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f10589a;
    }
}
