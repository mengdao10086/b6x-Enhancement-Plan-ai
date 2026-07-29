package f0;

import android.content.res.Configuration;
import g.n0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f27456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Configuration f27457b;

    public g0(boolean z10) {
        this.f27456a = z10;
        this.f27457b = null;
    }

    @n0
    @v0(26)
    public Configuration a() {
        Configuration configuration = this.f27457b;
        if (configuration != null) {
            return configuration;
        }
        throw new IllegalStateException("PictureInPictureModeChangedInfo must be constructed with the constructor that takes a Configuration to call getNewConfig(). Are you running on an API 26 or higher device that makes this information available?");
    }

    public boolean b() {
        return this.f27456a;
    }

    @v0(26)
    public g0(boolean z10, @n0 Configuration configuration) {
        this.f27456a = z10;
        this.f27457b = configuration;
    }
}
