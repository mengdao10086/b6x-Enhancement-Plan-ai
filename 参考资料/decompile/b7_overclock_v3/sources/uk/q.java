package uk;

import kotlin.v0;

/* JADX INFO: loaded from: classes5.dex */
@v0(version = "1.3")
@k
public interface q {

    public static final class a {
        public static boolean a(@yt.k q qVar) {
            return e.e0(qVar.d());
        }

        public static boolean b(@yt.k q qVar) {
            return !e.e0(qVar.d());
        }

        @yt.k
        public static q c(@yt.k q qVar, long j10) {
            return qVar.b(e.x0(j10));
        }

        @yt.k
        public static q d(@yt.k q qVar, long j10) {
            return new c(qVar, j10, null);
        }
    }

    @yt.k
    q a(long j10);

    @yt.k
    q b(long j10);

    boolean c();

    long d();

    boolean e();
}
