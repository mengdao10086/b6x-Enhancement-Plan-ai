package a;

import a.p80;
import com.omarea.vtools.activities.ActivityFpsSession;
import java.util.Arrays;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ya1 extends g92 implements g82<Integer, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityFpsSession.t f7963a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ya1(ActivityFpsSession.t tVar) {
        super(1);
        this.f7963a = tVar;
    }

    public final void a(int i) {
        String strG = new nb2(":").g(this.f7963a.f8672a.appName + ' ' + this.f7963a.f5267a, "-");
        if (i == 0) {
            ActivityFpsSession.this.v(strG + ".jpg");
            return;
        }
        p80.a aVar = p80.f2403a;
        ActivityFpsSession activityFpsSession = ActivityFpsSession.this;
        String string = activityFpsSession.getString(u61.fps_export_csv);
        f92.c(string, "getString(R.string.fps_export_csv)");
        q92 q92Var = q92.f7191a;
        String string2 = ActivityFpsSession.this.getString(u61.fps_export_confirm);
        f92.c(string2, "getString(R.string.fps_export_confirm)");
        String str = String.format(string2, Arrays.copyOf(new Object[]{strG}, 1));
        f92.c(str, "java.lang.String.format(format, *args)");
        aVar.i(activityFpsSession, (16 & 2) != 0 ? "" : string, (16 & 4) != 0 ? "" : str, (16 & 8) != 0 ? null : new xa1(this, strG), (16 & 16) != 0 ? null : null);
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(Integer num) {
        a(num.intValue());
        return m42.f6769a;
    }
}
