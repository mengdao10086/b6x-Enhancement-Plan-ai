package mi;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: mi.a$a, reason: collision with other inner class name */
    public class C0457a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f41251a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f41252b;

        public C0457a(String str, String str2) {
            this.f41251a = str;
            this.f41252b = str2;
        }

        public b a(String str) {
            return a.this.new b(this, str);
        }

        public void b() {
        }

        public void c(String str) {
        }
    }

    @SuppressFBWarnings
    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f41254a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C0457a f41255b;

        public b(C0457a c0457a, String str) {
            this.f41255b = c0457a;
            this.f41254a = str;
        }

        public void a() {
        }

        public void b(String str) {
        }
    }

    public C0457a a(String str) {
        return new C0457a("default", str);
    }
}
