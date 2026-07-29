package r8;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.flydigi.game.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes7.dex */
public final class p implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final LinearLayout f47819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final TextView f47820b;

    public p(@n0 LinearLayout linearLayout, @n0 TextView textView) {
        this.f47819a = linearLayout;
        this.f47820b = textView;
    }

    @n0
    public static p a(@n0 View view) {
        int i10 = R.id.tv_delete_file;
        TextView textView = (TextView) j2.c.a(view, i10);
        if (textView != null) {
            return new p((LinearLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static p c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static p d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.game_pop_delete_file, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f47819a;
    }
}
