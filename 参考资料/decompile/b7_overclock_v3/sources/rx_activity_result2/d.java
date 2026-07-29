package rx_activity_result2;

import android.content.Intent;
import g.p0;

/* JADX INFO: loaded from: classes6.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Intent f49233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f49234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public OnResult f49235c;

    public d(@p0 Intent intent) {
        this.f49233a = intent;
    }

    @p0
    public Intent a() {
        return this.f49233a;
    }

    public c b() {
        return this.f49234b;
    }

    public OnResult c() {
        return this.f49235c;
    }

    public void d(@p0 c cVar) {
        this.f49234b = cVar;
    }

    public void e(OnResult onResult) {
        this.f49235c = onResult;
    }
}
