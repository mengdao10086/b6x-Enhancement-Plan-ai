package h6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.flydigi.cyberfox.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes7.dex */
public final class d implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final LinearLayout f30569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final ListView f30570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final SwipeRefreshLayout f30571c;

    public d(@n0 LinearLayout linearLayout, @n0 ListView listView, @n0 SwipeRefreshLayout swipeRefreshLayout) {
        this.f30569a = linearLayout;
        this.f30570b = listView;
        this.f30571c = swipeRefreshLayout;
    }

    @n0
    public static d a(@n0 View view) {
        int i10 = R.id.devices;
        ListView listView = (ListView) j2.c.a(view, i10);
        if (listView != null) {
            i10 = R.id.swipe_refresh;
            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) j2.c.a(view, i10);
            if (swipeRefreshLayout != null) {
                return new d((LinearLayout) view, listView, swipeRefreshLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static d c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static d d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.act_scan, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f30569a;
    }
}
