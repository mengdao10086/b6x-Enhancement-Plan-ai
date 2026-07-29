package r8;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.flydigi.game.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes7.dex */
public final class k implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final RelativeLayout f47804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final TextView f47805b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final TextView f47806c;

    public k(@n0 RelativeLayout relativeLayout, @n0 TextView textView, @n0 TextView textView2) {
        this.f47804a = relativeLayout;
        this.f47805b = textView;
        this.f47806c = textView2;
    }

    @n0
    public static k a(@n0 View view) {
        int i10 = R.id.tv_game_cat;
        TextView textView = (TextView) j2.c.a(view, i10);
        if (textView != null) {
            i10 = R.id.tv_more;
            TextView textView2 = (TextView) j2.c.a(view, i10);
            if (textView2 != null) {
                return new k((RelativeLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static k c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static k d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.game_item_game_notice, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f47804a;
    }
}
