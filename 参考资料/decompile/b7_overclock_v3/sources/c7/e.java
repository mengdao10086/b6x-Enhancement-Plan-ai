package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentContainerView;
import com.flydigi.device_manager.R;
import top.androidman.SuperButton;

/* JADX INFO: loaded from: classes7.dex */
public final class e implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final LinearLayout f9945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final SuperButton f9946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final SuperButton f9947c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final FragmentContainerView f9948d;

    public e(@g.n0 LinearLayout linearLayout, @g.n0 SuperButton superButton, @g.n0 SuperButton superButton2, @g.n0 FragmentContainerView fragmentContainerView) {
        this.f9945a = linearLayout;
        this.f9946b = superButton;
        this.f9947c = superButton2;
        this.f9948d = fragmentContainerView;
    }

    @g.n0
    public static e a(@g.n0 View view) {
        int i10 = R.id.btn_apply;
        SuperButton superButton = (SuperButton) j2.c.a(view, i10);
        if (superButton != null) {
            i10 = R.id.btn_back;
            SuperButton superButton2 = (SuperButton) j2.c.a(view, i10);
            if (superButton2 != null) {
                i10 = R.id.fl_container;
                FragmentContainerView fragmentContainerView = (FragmentContainerView) j2.c.a(view, i10);
                if (fragmentContainerView != null) {
                    return new e((LinearLayout) view, superButton, superButton2, fragmentContainerView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static e c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static e d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_activity_led_setting, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f9945a;
    }
}
