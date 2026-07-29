package lu;

import java.util.Objects;
import javax.annotation.Nullable;
import retrofit2.r;

/* JADX INFO: loaded from: classes6.dex */
public final class d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final r<T> f40468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final Throwable f40469b;

    public d(@Nullable r<T> rVar, @Nullable Throwable th2) {
        this.f40468a = rVar;
        this.f40469b = th2;
    }

    public static <T> d<T> b(Throwable th2) {
        Objects.requireNonNull(th2, "error == null");
        return new d<>(null, th2);
    }

    public static <T> d<T> d(r<T> rVar) {
        Objects.requireNonNull(rVar, "response == null");
        return new d<>(rVar, null);
    }

    @Nullable
    public Throwable a() {
        return this.f40469b;
    }

    public boolean c() {
        return this.f40469b != null;
    }

    @Nullable
    public r<T> e() {
        return this.f40468a;
    }
}
