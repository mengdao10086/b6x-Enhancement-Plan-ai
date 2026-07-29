package b9;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.fdg.flashplay.farsef.R;
import g.n0;
import g.p0;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class r implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final TextView f9236a;

    public r(@n0 TextView textView) {
        this.f9236a = textView;
    }

    @n0
    public static r a(@n0 View view) {
        Objects.requireNonNull(view, "rootView");
        return new r((TextView) view);
    }

    @n0
    public static r c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static r d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.main_item_mall_product_header, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public TextView getRoot() {
        return this.f9236a;
    }
}
