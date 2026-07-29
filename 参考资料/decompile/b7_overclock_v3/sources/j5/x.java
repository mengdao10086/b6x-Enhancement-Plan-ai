package j5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import cn.jzvd.JzvdStd;
import com.flydigi.base.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class x implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final LinearLayout f36172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final JzvdStd f36173b;

    public x(@n0 LinearLayout linearLayout, @n0 JzvdStd jzvdStd) {
        this.f36172a = linearLayout;
        this.f36173b = jzvdStd;
    }

    @n0
    public static x a(@n0 View view) {
        int i10 = R.id.jz_video_player_standard;
        JzvdStd jzvdStd = (JzvdStd) j2.c.a(view, i10);
        if (jzvdStd != null) {
            return new x((LinearLayout) view, jzvdStd);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static x c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static x d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.main_layout_fragment_video, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f36172a;
    }
}
