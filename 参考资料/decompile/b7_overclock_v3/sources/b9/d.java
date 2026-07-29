package b9;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.fdg.flashplay.farsef.R;
import g.n0;
import g.p0;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final LinearLayout f9153a;

    public d(@n0 LinearLayout linearLayout) {
        this.f9153a = linearLayout;
    }

    @n0
    public static d a(@n0 View view) {
        Objects.requireNonNull(view, "rootView");
        return new d((LinearLayout) view);
    }

    @n0
    public static d c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static d d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.main_activity_wechat_follow, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f9153a;
    }
}
