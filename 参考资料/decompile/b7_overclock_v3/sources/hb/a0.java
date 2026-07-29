package hb;

import g.p0;

/* JADX INFO: loaded from: classes3.dex */
public interface a0 {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b0 f30800a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b0 f30801b;

        public a(b0 b0Var) {
            this(b0Var, b0Var);
        }

        public boolean equals(@p0 Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f30800a.equals(aVar.f30800a) && this.f30801b.equals(aVar.f30801b);
        }

        public int hashCode() {
            return (this.f30800a.hashCode() * 31) + this.f30801b.hashCode();
        }

        public String toString() {
            String str;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[");
            sb2.append(this.f30800a);
            if (this.f30800a.equals(this.f30801b)) {
                str = "";
            } else {
                str = ", " + this.f30801b;
            }
            sb2.append(str);
            sb2.append("]");
            return sb2.toString();
        }

        public a(b0 b0Var, b0 b0Var2) {
            this.f30800a = (b0) hd.a.g(b0Var);
            this.f30801b = (b0) hd.a.g(b0Var2);
        }
    }

    public static class b implements a0 {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f30802d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final a f30803e;

        public b(long j10) {
            this(j10, 0L);
        }

        @Override // hb.a0
        public boolean e() {
            return false;
        }

        @Override // hb.a0
        public a g(long j10) {
            return this.f30803e;
        }

        @Override // hb.a0
        public long h() {
            return this.f30802d;
        }

        public b(long j10, long j11) {
            this.f30802d = j10;
            this.f30803e = new a(j11 == 0 ? b0.f30804c : new b0(0L, j11));
        }
    }

    boolean e();

    a g(long j10);

    long h();
}
