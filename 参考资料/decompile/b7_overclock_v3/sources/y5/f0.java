package y5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.flydigi.community.R;
import g.n0;
import g.p0;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class f0 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final LinearLayout f56329a;

    public f0(@n0 LinearLayout linearLayout) {
        this.f56329a = linearLayout;
    }

    @n0
    public static f0 a(@n0 View view) {
        Objects.requireNonNull(view, "rootView");
        return new f0((LinearLayout) view);
    }

    @n0
    public static f0 c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static f0 d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.community_item_search_empty, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f56329a;
    }
}
