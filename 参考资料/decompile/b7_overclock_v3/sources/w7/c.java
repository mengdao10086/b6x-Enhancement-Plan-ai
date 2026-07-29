package w7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.flydigi.float_view.R;
import java.util.Objects;

/* JADX INFO: loaded from: classes7.dex */
public final class c implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final TextView f53994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final TextView f53995b;

    public c(@g.n0 TextView textView, @g.n0 TextView textView2) {
        this.f53994a = textView;
        this.f53995b = textView2;
    }

    @g.n0
    public static c a(@g.n0 View view) {
        Objects.requireNonNull(view, "rootView");
        TextView textView = (TextView) view;
        return new c(textView, textView);
    }

    @g.n0
    public static c c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static c d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.floatview_item_macro_effect_type, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public TextView getRoot() {
        return this.f53994a;
    }
}
