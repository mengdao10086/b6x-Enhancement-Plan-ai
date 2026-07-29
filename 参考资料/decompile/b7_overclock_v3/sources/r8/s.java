package r8;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.flydigi.game.R;
import g.n0;
import g.p0;
import java.util.Objects;

/* JADX INFO: loaded from: classes7.dex */
public final class s implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final LinearLayout f47835a;

    public s(@n0 LinearLayout linearLayout) {
        this.f47835a = linearLayout;
    }

    @n0
    public static s a(@n0 View view) {
        Objects.requireNonNull(view, "rootView");
        return new s((LinearLayout) view);
    }

    @n0
    public static s c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static s d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.game_view_downloaded_empty, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f47835a;
    }
}
