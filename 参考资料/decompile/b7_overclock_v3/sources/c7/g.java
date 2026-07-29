package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.flydigi.device_manager.R;
import com.google.android.material.switchmaterial.SwitchMaterial;

/* JADX INFO: loaded from: classes7.dex */
public final class g implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final LinearLayout f10036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final SwitchMaterial f10037b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final FrameLayout f10038c;

    public g(@g.n0 LinearLayout linearLayout, @g.n0 SwitchMaterial switchMaterial, @g.n0 FrameLayout frameLayout) {
        this.f10036a = linearLayout;
        this.f10037b = switchMaterial;
        this.f10038c = frameLayout;
    }

    @g.n0
    public static g a(@g.n0 View view) {
        int i10 = R.id.sm_state;
        SwitchMaterial switchMaterial = (SwitchMaterial) j2.c.a(view, i10);
        if (switchMaterial != null) {
            i10 = R.id.web_container;
            FrameLayout frameLayout = (FrameLayout) j2.c.a(view, i10);
            if (frameLayout != null) {
                return new g((LinearLayout) view, switchMaterial, frameLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static g c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static g d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_activity_waspwing_experimental_run_mode, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f10036a;
    }
}
