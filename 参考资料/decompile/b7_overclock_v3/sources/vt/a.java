package vt;

import org.greenrobot.eventbus.EventBusException;
import org.greenrobot.eventbus.ThreadMode;
import tt.n;

/* JADX INFO: loaded from: classes6.dex */
public abstract class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f53368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<? extends c> f53369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f53370c;

    public a(Class cls, Class<? extends c> cls2, boolean z10) {
        this.f53368a = cls;
        this.f53369b = cls2;
        this.f53370c = z10;
    }

    @Override // vt.c
    public c b() {
        Class<? extends c> cls = this.f53369b;
        if (cls == null) {
            return null;
        }
        try {
            return cls.newInstance();
        } catch (IllegalAccessException e10) {
            throw new RuntimeException(e10);
        } catch (InstantiationException e11) {
            throw new RuntimeException(e11);
        }
    }

    @Override // vt.c
    public boolean c() {
        return this.f53370c;
    }

    @Override // vt.c
    public Class d() {
        return this.f53368a;
    }

    public n e(String str, Class<?> cls) {
        return g(str, cls, ThreadMode.POSTING, 0, false);
    }

    public n f(String str, Class<?> cls, ThreadMode threadMode) {
        return g(str, cls, threadMode, 0, false);
    }

    public n g(String str, Class<?> cls, ThreadMode threadMode, int i10, boolean z10) {
        try {
            return new n(this.f53368a.getDeclaredMethod(str, cls), cls, threadMode, i10, z10);
        } catch (NoSuchMethodException e10) {
            throw new EventBusException("Could not find subscriber method in " + this.f53368a + ". Maybe a missing ProGuard rule?", e10);
        }
    }
}
