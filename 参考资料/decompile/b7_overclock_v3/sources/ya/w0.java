package ya;

/* JADX INFO: loaded from: classes3.dex */
public final class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.p0
    public final String f57211a;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @g.p0
        public String f57212a;

        public w0 a() {
            return new w0(this.f57212a);
        }

        public b b(@g.p0 String str) {
            this.f57212a = str;
            return this;
        }
    }

    public boolean equals(@g.p0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || w0.class != obj.getClass()) {
            return false;
        }
        return hd.u0.c(this.f57211a, ((w0) obj).f57211a);
    }

    public int hashCode() {
        String str = this.f57211a;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public w0(@g.p0 String str) {
        this.f57211a = str;
    }
}
