package a;

import com.omarea.vtools.activities.ActivityAppDetails;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class l81 extends g92 implements g82<Integer, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityAppDetails.r f6684a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l81(ActivityAppDetails.r rVar) {
        super(1);
        this.f6684a = rVar;
    }

    public final void a(int i) {
        ActivityAppDetails.this.f5139a.m(ActivityAppDetails.this.y(), Integer.valueOf(i), null);
        ActivityAppDetails.this.D();
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(Integer num) {
        a(num.intValue());
        return m42.f6769a;
    }
}
