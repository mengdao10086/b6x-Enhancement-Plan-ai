package y5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.flydigi.community.R;
import g.n0;
import g.p0;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class e0 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final TextView f56316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final TextView f56317b;

    public e0(@n0 TextView textView, @n0 TextView textView2) {
        this.f56316a = textView;
        this.f56317b = textView2;
    }

    @n0
    public static e0 a(@n0 View view) {
        Objects.requireNonNull(view, "rootView");
        TextView textView = (TextView) view;
        return new e0(textView, textView);
    }

    @n0
    public static e0 c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static e0 d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.community_item_pop_device_category, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public TextView getRoot() {
        return this.f56316a;
    }
}
