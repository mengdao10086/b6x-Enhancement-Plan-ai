package co;

/* JADX INFO: loaded from: classes5.dex */
public abstract class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l f11146a;

    public abstract l a();

    public synchronized l b() {
        if (this.f11146a == null) {
            this.f11146a = a();
        }
        return this.f11146a;
    }
}
