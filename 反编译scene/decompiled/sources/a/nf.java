package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class nf<T> implements mf<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6908a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Object[] f2089a;

    public nf(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f2089a = new Object[i];
    }

    @Override // a.mf
    public T a() {
        int i = this.f6908a;
        if (i <= 0) {
            return null;
        }
        int i2 = i - 1;
        Object[] objArr = this.f2089a;
        T t = (T) objArr[i2];
        objArr[i2] = null;
        this.f6908a = i - 1;
        return t;
    }

    @Override // a.mf
    public boolean b(T t) {
        if (c(t)) {
            throw new IllegalStateException("Already in the pool!");
        }
        int i = this.f6908a;
        Object[] objArr = this.f2089a;
        if (i >= objArr.length) {
            return false;
        }
        objArr[i] = t;
        this.f6908a = i + 1;
        return true;
    }

    public final boolean c(T t) {
        for (int i = 0; i < this.f6908a; i++) {
            if (this.f2089a[i] == t) {
                return true;
            }
        }
        return false;
    }
}
