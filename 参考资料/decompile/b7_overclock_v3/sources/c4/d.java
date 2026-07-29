package c4;

import g.n0;
import g.p0;
import java.security.MessageDigest;
import v4.m;

/* JADX INFO: loaded from: classes2.dex */
public final class d<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b<Object> f9747e = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f9748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b<T> f9749b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f9750c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile byte[] f9751d;

    public class a implements b<Object> {
        @Override // c4.d.b
        public void a(@n0 byte[] bArr, @n0 Object obj, @n0 MessageDigest messageDigest) {
        }
    }

    public interface b<T> {
        void a(@n0 byte[] bArr, @n0 T t10, @n0 MessageDigest messageDigest);
    }

    public d(@n0 String str, @p0 T t10, @n0 b<T> bVar) {
        this.f9750c = m.b(str);
        this.f9748a = t10;
        this.f9749b = (b) m.d(bVar);
    }

    @n0
    public static <T> d<T> a(@n0 String str, @n0 b<T> bVar) {
        return new d<>(str, null, bVar);
    }

    @n0
    public static <T> d<T> b(@n0 String str, @p0 T t10, @n0 b<T> bVar) {
        return new d<>(str, t10, bVar);
    }

    @n0
    public static <T> b<T> c() {
        return (b<T>) f9747e;
    }

    @n0
    public static <T> d<T> f(@n0 String str) {
        return new d<>(str, null, c());
    }

    @n0
    public static <T> d<T> g(@n0 String str, @n0 T t10) {
        return new d<>(str, t10, c());
    }

    @p0
    public T d() {
        return this.f9748a;
    }

    @n0
    public final byte[] e() {
        if (this.f9751d == null) {
            this.f9751d = this.f9750c.getBytes(c4.b.f9745b);
        }
        return this.f9751d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof d) {
            return this.f9750c.equals(((d) obj).f9750c);
        }
        return false;
    }

    public void h(@n0 T t10, @n0 MessageDigest messageDigest) {
        this.f9749b.a(e(), t10, messageDigest);
    }

    public int hashCode() {
        return this.f9750c.hashCode();
    }

    public String toString() {
        return "Option{key='" + this.f9750c + "'}";
    }
}
