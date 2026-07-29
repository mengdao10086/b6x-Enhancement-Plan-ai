package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.ui.apex_space.view.ColorSeekBar;

/* JADX INFO: loaded from: classes7.dex */
public final class u2 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f10506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final ColorSeekBar f10507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final TextView f10508c;

    public u2(@g.n0 ConstraintLayout constraintLayout, @g.n0 ColorSeekBar colorSeekBar, @g.n0 TextView textView) {
        this.f10506a = constraintLayout;
        this.f10507b = colorSeekBar;
        this.f10508c = textView;
    }

    @g.n0
    public static u2 a(@g.n0 View view) {
        int i10 = R.id.seekbar;
        ColorSeekBar colorSeekBar = (ColorSeekBar) j2.c.a(view, i10);
        if (colorSeekBar != null) {
            i10 = R.id.tv_tag;
            TextView textView = (TextView) j2.c.a(view, i10);
            if (textView != null) {
                return new u2((ConstraintLayout) view, colorSeekBar, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static u2 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static u2 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_view_color_seek_bar, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f10506a;
    }
}
