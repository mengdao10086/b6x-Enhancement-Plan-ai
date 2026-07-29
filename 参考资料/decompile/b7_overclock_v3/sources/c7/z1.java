package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.flydigi.device_manager.R;
import java.util.Objects;

/* JADX INFO: loaded from: classes7.dex */
public final class z1 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final TextView f10641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final TextView f10642b;

    public z1(@g.n0 TextView textView, @g.n0 TextView textView2) {
        this.f10641a = textView;
        this.f10642b = textView2;
    }

    @g.n0
    public static z1 a(@g.n0 View view) {
        Objects.requireNonNull(view, "rootView");
        TextView textView = (TextView) view;
        return new z1(textView, textView);
    }

    @g.n0
    public static z1 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static z1 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_item_led_type, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public TextView getRoot() {
        return this.f10641a;
    }
}
