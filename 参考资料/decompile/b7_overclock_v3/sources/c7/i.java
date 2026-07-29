package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.flydigi.device_manager.R;
import com.google.android.material.switchmaterial.SwitchMaterial;

/* JADX INFO: loaded from: classes7.dex */
public final class i implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final LinearLayout f10093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final LinearLayout f10094b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final SwitchMaterial f10095c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final TextView f10096d;

    public i(@g.n0 LinearLayout linearLayout, @g.n0 LinearLayout linearLayout2, @g.n0 SwitchMaterial switchMaterial, @g.n0 TextView textView) {
        this.f10093a = linearLayout;
        this.f10094b = linearLayout2;
        this.f10095c = switchMaterial;
        this.f10096d = textView;
    }

    @g.n0
    public static i a(@g.n0 View view) {
        int i10 = R.id.area_cold_protection;
        LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
        if (linearLayout != null) {
            i10 = R.id.sm_cold_protection;
            SwitchMaterial switchMaterial = (SwitchMaterial) j2.c.a(view, i10);
            if (switchMaterial != null) {
                i10 = R.id.tv_desc;
                TextView textView = (TextView) j2.c.a(view, i10);
                if (textView != null) {
                    return new i((LinearLayout) view, linearLayout, switchMaterial, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static i c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static i d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_activity_waspwing_protection, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f10093a;
    }
}
