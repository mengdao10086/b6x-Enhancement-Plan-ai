package j4;

import com.bumptech.glide.load.engine.s;
import g.n0;
import v4.m;

/* JADX INFO: loaded from: classes2.dex */
public class b<T> implements s<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f36065a;

    public b(@n0 T t10) {
        this.f36065a = (T) m.d(t10);
    }

    @Override // com.bumptech.glide.load.engine.s
    public void a() {
    }

    @Override // com.bumptech.glide.load.engine.s
    public final int c() {
        return 1;
    }

    @Override // com.bumptech.glide.load.engine.s
    @n0
    public Class<T> d() {
        return (Class<T>) this.f36065a.getClass();
    }

    @Override // com.bumptech.glide.load.engine.s
    @n0
    public final T get() {
        return this.f36065a;
    }
}
