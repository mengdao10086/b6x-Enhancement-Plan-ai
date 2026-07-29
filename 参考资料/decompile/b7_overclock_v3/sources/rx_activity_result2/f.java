package rx_activity_result2;

import android.content.Intent;

/* JADX INFO: loaded from: classes6.dex */
public class f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f49242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f49243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f49244c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Intent f49245d;

    public f(T t10, int i10, int i11, Intent intent) {
        this.f49242a = t10;
        this.f49243b = i11;
        this.f49244c = i10;
        this.f49245d = intent;
    }

    public Intent a() {
        return this.f49245d;
    }

    public int b() {
        return this.f49244c;
    }

    public int c() {
        return this.f49243b;
    }

    public T d() {
        return this.f49242a;
    }
}
