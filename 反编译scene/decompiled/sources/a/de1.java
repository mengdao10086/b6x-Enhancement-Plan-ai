package a;

import com.omarea.vtools.activities.ActivityPowerBench;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class de1 extends g92 implements g82<Integer, String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityPowerBench f5889a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public de1(ActivityPowerBench activityPowerBench) {
        super(1);
        this.f5889a = activityPowerBench;
    }

    public final String a(int i) {
        return String.valueOf(((Number) this.f5889a.M().get(i)).intValue() / 1000);
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ String f(Integer num) {
        return a(num.intValue());
    }
}
