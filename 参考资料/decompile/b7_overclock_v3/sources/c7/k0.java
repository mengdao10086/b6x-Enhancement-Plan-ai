package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.flydigi.device_manager.R;

/* JADX INFO: loaded from: classes7.dex */
public final class k0 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final LinearLayout f10167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final RecyclerView f10168b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final RecyclerView f10169c;

    public k0(@g.n0 LinearLayout linearLayout, @g.n0 RecyclerView recyclerView, @g.n0 RecyclerView recyclerView2) {
        this.f10167a = linearLayout;
        this.f10168b = recyclerView;
        this.f10169c = recyclerView2;
    }

    @g.n0
    public static k0 a(@g.n0 View view) {
        int i10 = R.id.rv_categories;
        RecyclerView recyclerView = (RecyclerView) j2.c.a(view, i10);
        if (recyclerView != null) {
            i10 = R.id.rv_devices;
            RecyclerView recyclerView2 = (RecyclerView) j2.c.a(view, i10);
            if (recyclerView2 != null) {
                return new k0((LinearLayout) view, recyclerView, recyclerView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static k0 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static k0 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_fragment_device_list, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f10167a;
    }
}
