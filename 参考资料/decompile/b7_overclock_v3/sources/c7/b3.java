package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.flydigi.device_manager.R;
import top.androidman.SuperButton;

/* JADX INFO: loaded from: classes7.dex */
public final class b3 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f9861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final SuperButton f9862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final TextView f9863c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final TextView f9864d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final TextView f9865e;

    public b3(@g.n0 ConstraintLayout constraintLayout, @g.n0 SuperButton superButton, @g.n0 TextView textView, @g.n0 TextView textView2, @g.n0 TextView textView3) {
        this.f9861a = constraintLayout;
        this.f9862b = superButton;
        this.f9863c = textView;
        this.f9864d = textView2;
        this.f9865e = textView3;
    }

    @g.n0
    public static b3 a(@g.n0 View view) {
        int i10 = R.id.btn_action;
        SuperButton superButton = (SuperButton) j2.c.a(view, i10);
        if (superButton != null) {
            i10 = R.id.tv_temperature_b3;
            TextView textView = (TextView) j2.c.a(view, i10);
            if (textView != null) {
                i10 = R.id.tv_temperature_phone;
                TextView textView2 = (TextView) j2.c.a(view, i10);
                if (textView2 != null) {
                    i10 = R.id.tv_title;
                    TextView textView3 = (TextView) j2.c.a(view, i10);
                    if (textView3 != null) {
                        return new b3((ConstraintLayout) view, superButton, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static b3 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static b3 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_widget_wind_temperature, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f9861a;
    }
}
