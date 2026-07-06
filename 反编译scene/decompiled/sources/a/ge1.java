package a;

import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.omarea.ui.BlurViewLinearLayout;
import com.omarea.ui.BlurViewRelativeLayout;
import com.omarea.vtools.activities.ActivityPowerBench;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ge1 extends g92 implements v72<m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityPowerBench.k f6199a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ge1(ActivityPowerBench.k kVar) {
        super(0);
        this.f6199a = kVar;
    }

    public final void a() {
        FrameLayout frameLayout = (FrameLayout) ActivityPowerBench.this._$_findCachedViewById(t61.cpu_title);
        f92.c(frameLayout, "cpu_title");
        frameLayout.setVisibility(8);
        BlurViewLinearLayout blurViewLinearLayout = (BlurViewLinearLayout) ActivityPowerBench.this._$_findCachedViewById(t61.cpu_options);
        f92.c(blurViewLinearLayout, "cpu_options");
        blurViewLinearLayout.setVisibility(8);
        BlurViewRelativeLayout blurViewRelativeLayout = (BlurViewRelativeLayout) ActivityPowerBench.this._$_findCachedViewById(t61.cpu_bench_chart_view);
        f92.c(blurViewRelativeLayout, "cpu_bench_chart_view");
        blurViewRelativeLayout.setVisibility(0);
        TextView textView = (TextView) ActivityPowerBench.this._$_findCachedViewById(t61.cpu_bench_result);
        f92.c(textView, "cpu_bench_result");
        textView.setText((CharSequence) null);
        TextView textView2 = (TextView) ActivityPowerBench.this._$_findCachedViewById(t61.cpu_bench_result);
        f92.c(textView2, "cpu_bench_result");
        textView2.setVisibility(0);
        LinearLayout linearLayout = (LinearLayout) ActivityPowerBench.this._$_findCachedViewById(t61.rootView);
        f92.c(linearLayout, "rootView");
        linearLayout.setKeepScreenOn(true);
        ActivityPowerBench.this.V(qc2.d(xd2.a(qe2.b()), null, null, new fe1(this, null), 3, null));
    }

    @Override // a.v72
    public /* bridge */ /* synthetic */ m42 i() {
        a();
        return m42.f6769a;
    }
}
