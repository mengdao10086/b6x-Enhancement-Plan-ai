package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.flydigi.device_manager.R;

/* JADX INFO: loaded from: classes7.dex */
public final class f implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final LinearLayout f9997a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final j5.r f9998b;

    public f(@g.n0 LinearLayout linearLayout, @g.n0 j5.r rVar) {
        this.f9997a = linearLayout;
        this.f9998b = rVar;
    }

    @g.n0
    public static f a(@g.n0 View view) {
        int i10 = R.id.area_recycler_view;
        View viewA = j2.c.a(view, i10);
        if (viewA == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
        }
        return new f((LinearLayout) view, j5.r.a(viewA));
    }

    @g.n0
    public static f c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static f d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_activity_target_temperature, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f9997a;
    }
}
