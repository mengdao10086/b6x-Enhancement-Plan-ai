package b9;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.fdg.flashplay.farsef.R;
import com.google.android.material.divider.MaterialDivider;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final ConstraintLayout f9165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final Button f9166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final Button f9167c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final MaterialDivider f9168d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final MaterialDivider f9169e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final View f9170f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @n0
    public final TextView f9171g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @n0
    public final TextView f9172h;

    public g(@n0 ConstraintLayout constraintLayout, @n0 Button button, @n0 Button button2, @n0 MaterialDivider materialDivider, @n0 MaterialDivider materialDivider2, @n0 View view, @n0 TextView textView, @n0 TextView textView2) {
        this.f9165a = constraintLayout;
        this.f9166b = button;
        this.f9167c = button2;
        this.f9168d = materialDivider;
        this.f9169e = materialDivider2;
        this.f9170f = view;
        this.f9171g = textView;
        this.f9172h = textView2;
    }

    @n0
    public static g a(@n0 View view) {
        int i10 = R.id.btn_allow;
        Button button = (Button) j2.c.a(view, R.id.btn_allow);
        if (button != null) {
            i10 = R.id.btn_refuse;
            Button button2 = (Button) j2.c.a(view, R.id.btn_refuse);
            if (button2 != null) {
                i10 = R.id.divider_1;
                MaterialDivider materialDivider = (MaterialDivider) j2.c.a(view, R.id.divider_1);
                if (materialDivider != null) {
                    i10 = R.id.divider_2;
                    MaterialDivider materialDivider2 = (MaterialDivider) j2.c.a(view, R.id.divider_2);
                    if (materialDivider2 != null) {
                        i10 = R.id.divider_3;
                        View viewA = j2.c.a(view, R.id.divider_3);
                        if (viewA != null) {
                            i10 = R.id.tv_text;
                            TextView textView = (TextView) j2.c.a(view, R.id.tv_text);
                            if (textView != null) {
                                i10 = R.id.tv_title;
                                TextView textView2 = (TextView) j2.c.a(view, R.id.tv_title);
                                if (textView2 != null) {
                                    return new g((ConstraintLayout) view, button, button2, materialDivider, materialDivider2, viewA, textView, textView2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static g c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static g d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.main_dialog_user_policy, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f9165a;
    }
}
