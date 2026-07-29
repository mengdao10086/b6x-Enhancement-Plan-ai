package uk;

import kotlin.jvm.internal.f0;
import kotlin.v0;
import uk.q;

/* JADX INFO: loaded from: classes5.dex */
@v0(version = "1.8")
@k
public interface d extends q, Comparable<d> {

    public static final class a {
        public static int a(@yt.k d dVar, @yt.k d other) {
            f0.p(other, "other");
            return e.j(dVar.C(other), e.f52169b.W());
        }

        public static boolean b(@yt.k d dVar) {
            return q.a.a(dVar);
        }

        public static boolean c(@yt.k d dVar) {
            return q.a.b(dVar);
        }

        @yt.k
        public static d d(@yt.k d dVar, long j10) {
            return dVar.b(e.x0(j10));
        }
    }

    long C(@yt.k d dVar);

    @Override // uk.q
    @yt.k
    d a(long j10);

    @Override // uk.q
    @yt.k
    d b(long j10);

    boolean equals(@yt.l Object obj);

    int hashCode();

    int z(@yt.k d dVar);
}
