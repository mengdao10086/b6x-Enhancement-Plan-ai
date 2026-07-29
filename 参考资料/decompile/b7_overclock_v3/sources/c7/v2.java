package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.flydigi.device_manager.R;

/* JADX INFO: loaded from: classes7.dex */
public final class v2 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f10529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final SeekBar f10530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final TextView f10531c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final TextView f10532d;

    public v2(@g.n0 ConstraintLayout constraintLayout, @g.n0 SeekBar seekBar, @g.n0 TextView textView, @g.n0 TextView textView2) {
        this.f10529a = constraintLayout;
        this.f10530b = seekBar;
        this.f10531c = textView;
        this.f10532d = textView2;
    }

    @g.n0
    public static v2 a(@g.n0 View view) {
        int i10 = R.id.seekbar;
        SeekBar seekBar = (SeekBar) j2.c.a(view, i10);
        if (seekBar != null) {
            i10 = R.id.tv_max_value;
            TextView textView = (TextView) j2.c.a(view, i10);
            if (textView != null) {
                i10 = R.id.tv_min_value;
                TextView textView2 = (TextView) j2.c.a(view, i10);
                if (textView2 != null) {
                    return new v2((ConstraintLayout) view, seekBar, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static v2 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static v2 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_view_single_seek_bar, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f10529a;
    }
}
