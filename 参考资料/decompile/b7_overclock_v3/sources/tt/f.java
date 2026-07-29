package tt;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes6.dex */
public interface f {

    public static class a {
        public static f a() {
            return ut.a.a() ? ut.a.b().f52442a : new c();
        }
    }

    public static class b implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Logger f51684a;

        public b(String str) {
            this.f51684a = Logger.getLogger(str);
        }

        @Override // tt.f
        public void a(Level level, String str) {
            this.f51684a.log(level, str);
        }

        @Override // tt.f
        public void b(Level level, String str, Throwable th2) {
            this.f51684a.log(level, str, th2);
        }
    }

    public static class c implements f {
        @Override // tt.f
        public void a(Level level, String str) {
            System.out.println("[" + level + "] " + str);
        }

        @Override // tt.f
        public void b(Level level, String str, Throwable th2) {
            System.out.println("[" + level + "] " + str);
            th2.printStackTrace(System.out);
        }
    }

    void a(Level level, String str);

    void b(Level level, String str, Throwable th2);
}
