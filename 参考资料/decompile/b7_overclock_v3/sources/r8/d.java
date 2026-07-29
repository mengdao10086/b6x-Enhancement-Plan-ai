package r8;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.SwitchCompat;
import com.flydigi.game.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes7.dex */
public final class d implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final LinearLayout f47762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final SwitchCompat f47763b;

    public d(@n0 LinearLayout linearLayout, @n0 SwitchCompat switchCompat) {
        this.f47762a = linearLayout;
        this.f47763b = switchCompat;
    }

    @n0
    public static d a(@n0 View view) {
        int i10 = R.id.switchWidget;
        SwitchCompat switchCompat = (SwitchCompat) j2.c.a(view, i10);
        if (switchCompat != null) {
            return new d((LinearLayout) view, switchCompat);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static d c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static d d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.game_fragment_download_setting, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f47762a;
    }
}
