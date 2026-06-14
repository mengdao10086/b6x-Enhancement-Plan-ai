package a;

import com.omarea.vtools.activities.ActivityPowerBench;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class qe1 extends g92 implements g82<Integer, String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityPowerBench f7204a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qe1(ActivityPowerBench activityPowerBench) {
        super(1);
        this.f7204a = activityPowerBench;
    }

    public final String a(int i) {
        return String.valueOf(((Number) this.f7204a.f5408a.get(i)).intValue() / 1000);
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ String f(Integer num) {
        return a(num.intValue());
    }
}
