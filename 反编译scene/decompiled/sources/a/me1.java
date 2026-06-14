package a;

import a.p80;
import android.widget.LinearLayout;
import com.omarea.vtools.activities.ActivityPowerBench;
import java.util.Arrays;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class me1 extends g92 implements g82<Integer, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityPowerBench.n f6800a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f1927a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public me1(ActivityPowerBench.n nVar, String str) {
        super(1);
        this.f6800a = nVar;
        this.f1927a = str;
    }

    public final void a(int i) {
        if (i == 0) {
            ActivityPowerBench activityPowerBench = ActivityPowerBench.this;
            ph0 ph0Var = new ph0(activityPowerBench, activityPowerBench.getThemeMode());
            LinearLayout linearLayout = (LinearLayout) ActivityPowerBench.this._$_findCachedViewById(t61.rootView);
            f92.c(linearLayout, "rootView");
            ph0.c(ph0Var, linearLayout, this.f1927a + ".jpg", null, 4, null);
            return;
        }
        p80.a aVar = p80.f2403a;
        ActivityPowerBench activityPowerBench2 = ActivityPowerBench.this;
        String string = activityPowerBench2.getString(u61.fps_export_csv);
        f92.c(string, "getString(R.string.fps_export_csv)");
        q92 q92Var = q92.f7191a;
        String string2 = ActivityPowerBench.this.getString(u61.fps_export_confirm);
        f92.c(string2, "getString(R.string.fps_export_confirm)");
        String str = String.format(string2, Arrays.copyOf(new Object[]{this.f1927a}, 1));
        f92.c(str, "java.lang.String.format(format, *args)");
        aVar.i(activityPowerBench2, (16 & 2) != 0 ? "" : string, (16 & 4) != 0 ? "" : str, (16 & 8) != 0 ? null : new le1(this), (16 & 16) != 0 ? null : null);
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(Integer num) {
        a(num.intValue());
        return m42.f6769a;
    }
}
