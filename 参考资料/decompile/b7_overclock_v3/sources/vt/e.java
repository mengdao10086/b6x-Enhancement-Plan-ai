package vt;

import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes6.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f53372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ThreadMode f53373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Class<?> f53374c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f53375d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f53376e;

    public e(String str, Class<?> cls, ThreadMode threadMode, int i10, boolean z10) {
        this.f53372a = str;
        this.f53373b = threadMode;
        this.f53374c = cls;
        this.f53375d = i10;
        this.f53376e = z10;
    }

    public e(String str, Class<?> cls) {
        this(str, cls, ThreadMode.POSTING, 0, false);
    }

    public e(String str, Class<?> cls, ThreadMode threadMode) {
        this(str, cls, threadMode, 0, false);
    }
}
