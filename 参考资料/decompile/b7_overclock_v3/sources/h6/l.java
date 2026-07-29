package h6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import com.flydigi.cyberfox.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes7.dex */
public final class l implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final LinearLayout f30657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final Button f30658b;

    public l(@n0 LinearLayout linearLayout, @n0 Button button) {
        this.f30657a = linearLayout;
        this.f30658b = button;
    }

    @n0
    public static l a(@n0 View view) {
        int i10 = R.id.btn_upgrade;
        Button button = (Button) j2.c.a(view, i10);
        if (button != null) {
            return new l((LinearLayout) view, button);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static l c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static l d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.cf_fragment_upgrade, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f30657a;
    }
}
