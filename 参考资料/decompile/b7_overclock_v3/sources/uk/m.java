package uk;

import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.v0;
import kotlin.z1;
import uk.r;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nmeasureTime.kt\nKotlin\n*S Kotlin\n*F\n+ 1 measureTime.kt\nkotlin/time/MeasureTimeKt\n*L\n1#1,121:1\n50#1,7:122\n113#1,7:129\n*S KotlinDebug\n*F\n+ 1 measureTime.kt\nkotlin/time/MeasureTimeKt\n*L\n21#1:122,7\n83#1:129,7\n*E\n"})
public final class m {
    @v0(version = "1.3")
    @k
    public static final long a(@yt.k ik.a<z1> block) {
        f0.p(block, "block");
        long jB = r.b.f52187b.b();
        block.o();
        return r.b.a.j(jB);
    }

    @v0(version = "1.7")
    @k
    public static final long b(@yt.k r.b bVar, @yt.k ik.a<z1> block) {
        f0.p(bVar, "<this>");
        f0.p(block, "block");
        long jB = bVar.b();
        block.o();
        return r.b.a.j(jB);
    }

    @v0(version = "1.3")
    @k
    public static final long c(@yt.k r rVar, @yt.k ik.a<z1> block) {
        f0.p(rVar, "<this>");
        f0.p(block, "block");
        q qVarA = rVar.a();
        block.o();
        return qVarA.d();
    }

    @v0(version = "1.3")
    @yt.k
    @k
    public static final <T> s<T> d(@yt.k ik.a<? extends T> block) {
        f0.p(block, "block");
        return new s<>(block.o(), r.b.a.j(r.b.f52187b.b()), null);
    }

    @v0(version = "1.7")
    @yt.k
    @k
    public static final <T> s<T> e(@yt.k r.b bVar, @yt.k ik.a<? extends T> block) {
        f0.p(bVar, "<this>");
        f0.p(block, "block");
        return new s<>(block.o(), r.b.a.j(bVar.b()), null);
    }

    @v0(version = "1.3")
    @yt.k
    @k
    public static final <T> s<T> f(@yt.k r rVar, @yt.k ik.a<? extends T> block) {
        f0.p(rVar, "<this>");
        f0.p(block, "block");
        return new s<>(block.o(), rVar.a().d(), null);
    }
}
