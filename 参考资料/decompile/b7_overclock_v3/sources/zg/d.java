package zg;

import dj.o;
import dj.r;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import xi.z;

/* JADX INFO: loaded from: classes5.dex */
public class d {

    /* JADX INFO: Add missing generic type declarations: [R] */
    public static class a<R> implements r<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f58581a;

        public a(Object obj) {
            this.f58581a = obj;
        }

        @Override // dj.r
        public boolean a(R r10) throws Exception {
            return r10.equals(this.f58581a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    public static class b<R> implements dj.c<R, R, Boolean> {
        @Override // dj.c
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean apply(R r10, R r11) throws Exception {
            return Boolean.valueOf(r11.equals(r10));
        }
    }

    public d() {
        throw new AssertionError("No instances");
    }

    @Nonnull
    @CheckReturnValue
    public static <T, R> c<T> a(@Nonnull z<R> zVar) {
        return new c<>(zVar);
    }

    @Nonnull
    @CheckReturnValue
    public static <T, R> c<T> b(@Nonnull z<R> zVar, @Nonnull o<R, R> oVar) {
        dh.a.a(zVar, "lifecycle == null");
        dh.a.a(oVar, "correspondingEvents == null");
        return a(d(zVar.i5(), oVar));
    }

    @Nonnull
    @CheckReturnValue
    public static <T, R> c<T> c(@Nonnull z<R> zVar, @Nonnull R r10) {
        dh.a.a(zVar, "lifecycle == null");
        dh.a.a(r10, "event == null");
        return a(e(zVar, r10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <R> z<Boolean> d(z<R> zVar, o<R, R> oVar) {
        return z.d0(zVar.a6(1L).A3(oVar), zVar.m5(1L), new b()).h4(zg.a.f58577a).h2(zg.a.f58578b);
    }

    public static <R> z<R> e(z<R> zVar, R r10) {
        return zVar.h2(new a(r10));
    }
}
