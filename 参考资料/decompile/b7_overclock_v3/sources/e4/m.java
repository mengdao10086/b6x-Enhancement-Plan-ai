package e4;

import androidx.core.util.n;
import g.n0;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import v4.o;
import w4.a;

/* JADX INFO: loaded from: classes2.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v4.j<c4.b, String> f26653a = new v4.j<>(1000);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n.a<b> f26654b = w4.a.e(10, new a());

    public class a implements a.d<b> {
        public a() {
        }

        @Override // w4.a.d
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public b create() {
            try {
                return new b(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e10) {
                throw new RuntimeException(e10);
            }
        }
    }

    public static final class b implements a.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MessageDigest f26656a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final w4.c f26657b = w4.c.a();

        public b(MessageDigest messageDigest) {
            this.f26656a = messageDigest;
        }

        @Override // w4.a.f
        @n0
        public w4.c f() {
            return this.f26657b;
        }
    }

    public final String a(c4.b bVar) {
        b bVar2 = (b) v4.m.d(this.f26654b.a());
        try {
            bVar.a(bVar2.f26656a);
            return o.z(bVar2.f26656a.digest());
        } finally {
            this.f26654b.b(bVar2);
        }
    }

    public String b(c4.b bVar) {
        String strK;
        synchronized (this.f26653a) {
            strK = this.f26653a.k(bVar);
        }
        if (strK == null) {
            strK = a(bVar);
        }
        synchronized (this.f26653a) {
            this.f26653a.o(bVar, strK);
        }
        return strK;
    }
}
