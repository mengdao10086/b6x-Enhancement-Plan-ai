package y5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import com.flydigi.community.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final FrameLayout f56334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final Button f56335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final Button f56336c;

    public h(@n0 FrameLayout frameLayout, @n0 Button button, @n0 Button button2) {
        this.f56334a = frameLayout;
        this.f56335b = button;
        this.f56336c = button2;
    }

    @n0
    public static h a(@n0 View view) {
        int i10 = R.id.btn_cancel;
        Button button = (Button) j2.c.a(view, i10);
        if (button != null) {
            i10 = R.id.btn_delete;
            Button button2 = (Button) j2.c.a(view, i10);
            if (button2 != null) {
                return new h((FrameLayout) view, button, button2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static h c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static h d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.community_dialog_more_action, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f56334a;
    }
}
