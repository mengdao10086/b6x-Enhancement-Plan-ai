package pi;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes5.dex */
@li.c
public class n<T> implements a<T>, h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<a<T>> f46698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f46699b;

    public n(a<T> aVar) {
        this.f46698a = new WeakReference<>(aVar);
    }

    @Override // pi.h
    public a<T> a() {
        return this.f46698a.get();
    }

    @Override // pi.a
    public void b(T t10) {
        a<T> aVar = this.f46698a.get();
        if (aVar != null) {
            aVar.b(t10);
        } else {
            this.f46699b.cancel();
        }
    }

    public void c(d dVar) {
        this.f46699b = dVar;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        a<T> aVar = this.f46698a.get();
        if (aVar == null || aVar != ((n) obj).f46698a.get()) {
            return super.equals(obj);
        }
        return true;
    }

    public int hashCode() {
        a<T> aVar = this.f46698a.get();
        return aVar != null ? aVar.hashCode() : super.hashCode();
    }
}
