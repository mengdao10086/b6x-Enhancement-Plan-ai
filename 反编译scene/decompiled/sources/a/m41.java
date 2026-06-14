package a;

import android.content.pm.ActivityInfo;
import java.util.Comparator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class m41<T> implements Comparator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p41 f6768a;

    public m41(p41 p41Var) {
        this.f6768a = p41Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        ActivityInfo activityInfo = (ActivityInfo) t;
        int i = 0;
        Integer numValueOf = Integer.valueOf(f92.a(this.f6768a.b, activityInfo.name) ? -1 : (activityInfo.exported && activityInfo.enabled) ? 0 : 1);
        ActivityInfo activityInfo2 = (ActivityInfo) t2;
        if (f92.a(this.f6768a.b, activityInfo2.name)) {
            i = -1;
        } else if (!activityInfo2.exported || !activityInfo2.enabled) {
            i = 1;
        }
        return w52.a(numValueOf, Integer.valueOf(i));
    }
}
