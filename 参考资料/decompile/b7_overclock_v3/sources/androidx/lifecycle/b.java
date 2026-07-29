package androidx.lifecycle;

import android.app.Application;

/* JADX INFO: loaded from: classes2.dex */
public class b extends x0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final Application f6173d;

    public b(@yt.k Application application) {
        kotlin.jvm.internal.f0.p(application, "application");
        this.f6173d = application;
    }

    @yt.k
    public <T extends Application> T g() {
        T t10 = (T) this.f6173d;
        kotlin.jvm.internal.f0.n(t10, "null cannot be cast to non-null type T of androidx.lifecycle.AndroidViewModel.getApplication");
        return t10;
    }
}
