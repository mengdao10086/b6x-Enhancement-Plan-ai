package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class of<T> extends nf<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f7015a;

    public of(int i) {
        super(i);
        this.f7015a = new Object();
    }

    @Override // a.nf, a.mf
    public T a() {
        T t;
        synchronized (this.f7015a) {
            t = (T) super.a();
        }
        return t;
    }

    @Override // a.nf, a.mf
    public boolean b(T t) {
        boolean zB;
        synchronized (this.f7015a) {
            zB = super.b(t);
        }
        return zB;
    }
}
