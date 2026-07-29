package androidx.core.util;

import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class n {

    public interface a<T> {
        @p0
        T a();

        boolean b(@n0 T t10);
    }

    public static class b<T> implements a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object[] f4769a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f4770b;

        public b(int i10) {
            if (i10 <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.f4769a = new Object[i10];
        }

        @Override // androidx.core.util.n.a
        public T a() {
            int i10 = this.f4770b;
            if (i10 <= 0) {
                return null;
            }
            int i11 = i10 - 1;
            Object[] objArr = this.f4769a;
            T t10 = (T) objArr[i11];
            objArr[i11] = null;
            this.f4770b = i10 - 1;
            return t10;
        }

        @Override // androidx.core.util.n.a
        public boolean b(@n0 T t10) {
            if (c(t10)) {
                throw new IllegalStateException("Already in the pool!");
            }
            int i10 = this.f4770b;
            Object[] objArr = this.f4769a;
            if (i10 >= objArr.length) {
                return false;
            }
            objArr[i10] = t10;
            this.f4770b = i10 + 1;
            return true;
        }

        public final boolean c(@n0 T t10) {
            for (int i10 = 0; i10 < this.f4770b; i10++) {
                if (this.f4769a[i10] == t10) {
                    return true;
                }
            }
            return false;
        }
    }

    public static class c<T> extends b<T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Object f4771c;

        public c(int i10) {
            super(i10);
            this.f4771c = new Object();
        }

        @Override // androidx.core.util.n.b, androidx.core.util.n.a
        public T a() {
            T t10;
            synchronized (this.f4771c) {
                t10 = (T) super.a();
            }
            return t10;
        }

        @Override // androidx.core.util.n.b, androidx.core.util.n.a
        public boolean b(@n0 T t10) {
            boolean zB;
            synchronized (this.f4771c) {
                zB = super.b(t10);
            }
            return zB;
        }
    }
}
