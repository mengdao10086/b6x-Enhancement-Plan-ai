package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.flydigi.device_manager.R;
import com.shuhart.stepview.StepView;

/* JADX INFO: loaded from: classes7.dex */
public final class i0 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f10097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final Button f10098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final TextView f10099c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final StepView f10100d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final RecyclerView f10101e;

    public i0(@g.n0 ConstraintLayout constraintLayout, @g.n0 Button button, @g.n0 TextView textView, @g.n0 StepView stepView, @g.n0 RecyclerView recyclerView) {
        this.f10097a = constraintLayout;
        this.f10098b = button;
        this.f10099c = textView;
        this.f10100d = stepView;
        this.f10101e = recyclerView;
    }

    @g.n0
    public static i0 a(@g.n0 View view) {
        int i10 = R.id.btn_action;
        Button button = (Button) j2.c.a(view, i10);
        if (button != null) {
            i10 = R.id.btn_help_article;
            TextView textView = (TextView) j2.c.a(view, i10);
            if (textView != null) {
                i10 = R.id.indicator;
                StepView stepView = (StepView) j2.c.a(view, i10);
                if (stepView != null) {
                    i10 = R.id.recycler_view;
                    RecyclerView recyclerView = (RecyclerView) j2.c.a(view, i10);
                    if (recyclerView != null) {
                        return new i0((ConstraintLayout) view, button, textView, stepView, recyclerView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static i0 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static i0 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_fragment_developer_permission, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f10097a;
    }
}
