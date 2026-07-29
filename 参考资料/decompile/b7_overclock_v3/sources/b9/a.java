package b9;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import com.fdg.flashplay.farsef.R;
import g.n0;
import g.p0;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final ConstraintLayout f9140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final FragmentContainerView f9141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final MagicIndicator f9142c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final ViewStub f9143d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final TextView f9144e;

    public a(@n0 ConstraintLayout constraintLayout, @n0 FragmentContainerView fragmentContainerView, @n0 MagicIndicator magicIndicator, @n0 ViewStub viewStub, @n0 TextView textView) {
        this.f9140a = constraintLayout;
        this.f9141b = fragmentContainerView;
        this.f9142c = magicIndicator;
        this.f9143d = viewStub;
        this.f9144e = textView;
    }

    @n0
    public static a a(@n0 View view) {
        int i10 = R.id.container_fragment;
        FragmentContainerView fragmentContainerView = (FragmentContainerView) j2.c.a(view, R.id.container_fragment);
        if (fragmentContainerView != null) {
            i10 = R.id.magic_indicator;
            MagicIndicator magicIndicator = (MagicIndicator) j2.c.a(view, R.id.magic_indicator);
            if (magicIndicator != null) {
                i10 = R.id.stub_customer_service_tip;
                ViewStub viewStub = (ViewStub) j2.c.a(view, R.id.stub_customer_service_tip);
                if (viewStub != null) {
                    i10 = R.id.tv_device_manager;
                    TextView textView = (TextView) j2.c.a(view, R.id.tv_device_manager);
                    if (textView != null) {
                        return new a((ConstraintLayout) view, fragmentContainerView, magicIndicator, viewStub, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static a c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static a d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.app_activity_home, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f9140a;
    }
}
