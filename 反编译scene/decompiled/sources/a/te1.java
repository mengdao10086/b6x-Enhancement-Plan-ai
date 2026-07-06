package a;

import android.widget.TextView;
import com.omarea.ui.SeekBar;
import com.omarea.vtools.activities.ActivityPowerBench;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class te1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7493a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ TextView f3021a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityPowerBench f3022a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f3023a;
    public final /* synthetic */ int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final /* synthetic */ String f3024b;

    public te1(TextView textView, String str, String str2, ActivityPowerBench activityPowerBench, String str3, int i, int i2, int i3) {
        this.f3021a = textView;
        this.f3023a = str;
        this.f3024b = str2;
        this.f3022a = activityPowerBench;
        this.f7493a = i2;
        this.b = i3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3021a.setText(this.f3022a.P() + "     " + this.f3023a + "     " + ((SeekBar) this.f3022a._$_findCachedViewById(t61.cpu_bench_threads)).getProgress() + this.f3022a.getString(u61.pb_threads) + "    " + this.f3024b + "CPU " + this.f3022a.K() + "    " + this.f3022a.getString(u61.pb_target_load) + ' ' + this.f7493a + "    " + this.f3022a.getString(u61.pb_ddr_min) + ' ' + this.b);
    }
}
