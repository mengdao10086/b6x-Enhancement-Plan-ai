package pi;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class e<T> implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f46676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b<T> f46677b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f46678c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a<T> f46679d;

    public e(b<T> bVar, @Nullable Object obj, a<T> aVar) {
        this.f46677b = bVar;
        this.f46678c = obj;
        this.f46679d = aVar;
    }

    @Override // pi.d
    public boolean W() {
        return this.f46676a;
    }

    @Override // pi.d
    public synchronized void cancel() {
        this.f46676a = true;
        b<T> bVar = this.f46677b;
        if (bVar != null) {
            bVar.a(this.f46679d, this.f46678c);
            this.f46677b = null;
            this.f46679d = null;
            this.f46678c = null;
        }
    }
}
