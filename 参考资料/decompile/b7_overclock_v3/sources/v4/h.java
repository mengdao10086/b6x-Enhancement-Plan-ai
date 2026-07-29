package v4;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class a<T> implements b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile T f52681a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f52682b;

        public a(b bVar) {
            this.f52682b = bVar;
        }

        @Override // v4.h.b
        public T get() {
            if (this.f52681a == null) {
                synchronized (this) {
                    if (this.f52681a == null) {
                        this.f52681a = (T) m.d(this.f52682b.get());
                    }
                }
            }
            return this.f52681a;
        }
    }

    public interface b<T> {
        T get();
    }

    public static <T> b<T> a(b<T> bVar) {
        return new a(bVar);
    }
}
