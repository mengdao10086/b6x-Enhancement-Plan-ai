package vq;

import android.support.v4.media.session.MediaSessionCompat;
import zo.b0;

/* JADX INFO: loaded from: classes7.dex */
public class o {

    public static class a extends vq.a implements Cloneable {
        public a() {
            super(new b0());
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            a aVar = (a) super.clone();
            aVar.f53335a = new b0((b0) this.f53335a);
            return aVar;
        }
    }

    public static class b extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public b() {
            super(new ip.k(new b0()));
        }
    }

    public static class c extends ar.c {
        public c() {
            super("HMACRIPEMD320", MediaSessionCompat.M, new org.bouncycastle.crypto.j());
        }
    }

    public static class d extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f53349a = o.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f53349a;
            sb2.append(str);
            sb2.append("$Digest");
            aVar.h("MessageDigest.RIPEMD320", sb2.toString());
            b(aVar, "RIPEMD320", str + "$HashMac", str + "$KeyGenerator");
        }
    }
}
