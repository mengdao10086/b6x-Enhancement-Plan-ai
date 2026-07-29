package f0;

import android.content.res.Configuration;
import g.n0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f27585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Configuration f27586b;

    public q(boolean z10) {
        this.f27585a = z10;
        this.f27586b = null;
    }

    @n0
    @v0(26)
    public Configuration a() {
        Configuration configuration = this.f27586b;
        if (configuration != null) {
            return configuration;
        }
        throw new IllegalStateException("MultiWindowModeChangedInfo must be constructed with the constructor that takes a Configuration to call getNewConfig(). Are you running on an API 26 or higher device that makes this information available?");
    }

    public boolean b() {
        return this.f27585a;
    }

    @v0(26)
    public q(boolean z10, @n0 Configuration configuration) {
        this.f27585a = z10;
        this.f27586b = configuration;
    }
}
