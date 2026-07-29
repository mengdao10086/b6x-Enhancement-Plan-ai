package w4;

import g.n0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f53905a = false;

    public static class b extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile RuntimeException f53906b;

        public b() {
            super();
        }

        @Override // w4.c
        public void b(boolean z10) {
            if (z10) {
                this.f53906b = new RuntimeException("Released");
            } else {
                this.f53906b = null;
            }
        }

        @Override // w4.c
        public void c() {
            if (this.f53906b != null) {
                throw new IllegalStateException("Already released", this.f53906b);
            }
        }
    }

    /* JADX INFO: renamed from: w4.c$c, reason: collision with other inner class name */
    public static class C0633c extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile boolean f53907b;

        public C0633c() {
            super();
        }

        @Override // w4.c
        public void b(boolean z10) {
            this.f53907b = z10;
        }

        @Override // w4.c
        public void c() {
            if (this.f53907b) {
                throw new IllegalStateException("Already released");
            }
        }
    }

    @n0
    public static c a() {
        return new C0633c();
    }

    public abstract void b(boolean z10);

    public abstract void c();

    public c() {
    }
}
