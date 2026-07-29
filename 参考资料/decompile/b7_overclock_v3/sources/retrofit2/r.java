package retrofit2;

import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.Protocol;
import okhttp3.b0;
import okhttp3.d0;
import okhttp3.e0;
import retrofit2.l;

/* JADX INFO: loaded from: classes6.dex */
public final class r<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d0 f48722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final T f48723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final e0 f48724c;

    public r(d0 d0Var, @Nullable T t10, @Nullable e0 e0Var) {
        this.f48722a = d0Var;
        this.f48723b = t10;
        this.f48724c = e0Var;
    }

    public static <T> r<T> c(int i10, e0 e0Var) {
        Objects.requireNonNull(e0Var, "body == null");
        if (i10 >= 400) {
            return d(e0Var, new d0.a().b(new l.c(e0Var.contentType(), e0Var.contentLength())).g(i10).y("Response.error()").B(Protocol.HTTP_1_1).E(new b0.a().B("http://localhost/").b()).c());
        }
        throw new IllegalArgumentException("code < 400: " + i10);
    }

    public static <T> r<T> d(e0 e0Var, d0 d0Var) {
        Objects.requireNonNull(e0Var, "body == null");
        Objects.requireNonNull(d0Var, "rawResponse == null");
        if (d0Var.k1()) {
            throw new IllegalArgumentException("rawResponse should not be successful response");
        }
        return new r<>(d0Var, null, e0Var);
    }

    public static <T> r<T> j(int i10, @Nullable T t10) {
        if (i10 >= 200 && i10 < 300) {
            return m(t10, new d0.a().g(i10).y("Response.success()").B(Protocol.HTTP_1_1).E(new b0.a().B("http://localhost/").b()).c());
        }
        throw new IllegalArgumentException("code < 200 or >= 300: " + i10);
    }

    public static <T> r<T> k(@Nullable T t10) {
        return m(t10, new d0.a().g(200).y("OK").B(Protocol.HTTP_1_1).E(new b0.a().B("http://localhost/").b()).c());
    }

    public static <T> r<T> l(@Nullable T t10, okhttp3.t tVar) {
        Objects.requireNonNull(tVar, "headers == null");
        return m(t10, new d0.a().g(200).y("OK").B(Protocol.HTTP_1_1).w(tVar).E(new b0.a().B("http://localhost/").b()).c());
    }

    public static <T> r<T> m(@Nullable T t10, d0 d0Var) {
        Objects.requireNonNull(d0Var, "rawResponse == null");
        if (d0Var.k1()) {
            return new r<>(d0Var, t10, null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }

    @Nullable
    public T a() {
        return this.f48723b;
    }

    public int b() {
        return this.f48722a.W();
    }

    @Nullable
    public e0 e() {
        return this.f48724c;
    }

    public okhttp3.t f() {
        return this.f48722a.h1();
    }

    public boolean g() {
        return this.f48722a.k1();
    }

    public String h() {
        return this.f48722a.m1();
    }

    public d0 i() {
        return this.f48722a;
    }

    public String toString() {
        return this.f48722a.toString();
    }
}
