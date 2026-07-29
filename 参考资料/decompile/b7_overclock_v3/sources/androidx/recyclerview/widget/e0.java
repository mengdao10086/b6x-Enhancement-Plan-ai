package androidx.recyclerview.widget;

import androidx.recyclerview.widget.f0;

/* JADX INFO: loaded from: classes2.dex */
public interface e0<T> {

    public interface a<T> {
        void a(int i10, int i11, int i12, int i13, int i14);

        void b(f0.a<T> aVar);

        void c(int i10, int i11);

        void d(int i10);
    }

    public interface b<T> {
        void a(int i10, f0.a<T> aVar);

        void b(int i10, int i11);

        void c(int i10, int i11);
    }

    a<T> a(a<T> aVar);

    b<T> b(b<T> bVar);
}
