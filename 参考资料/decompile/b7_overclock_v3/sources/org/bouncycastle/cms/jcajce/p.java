package org.bouncycastle.cms.jcajce;

import java.io.OutputStream;
import java.security.Key;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import org.bouncycastle.cms.CMSException;
import so.z1;

/* JADX INFO: loaded from: classes5.dex */
public class p extends r {

    public class a implements cs.y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ zn.b f44610a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Key f44611b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Mac f44612c;

        public a(zn.b bVar, Key key, Mac mac) {
            this.f44610a = bVar;
            this.f44611b = key;
            this.f44612c = mac;
        }

        @Override // cs.y
        public zn.b a() {
            return this.f44610a;
        }

        @Override // cs.y
        public OutputStream b() {
            return new lq.d(this.f44612c);
        }

        @Override // cs.y
        public byte[] d() {
            return this.f44612c.doFinal();
        }

        @Override // cs.y
        public cs.q getKey() {
            return new org.bouncycastle.operator.jcajce.g(this.f44610a, this.f44611b);
        }
    }

    public p(SecretKey secretKey) {
        super(secretKey);
    }

    @Override // so.y0
    public z1 a(zn.b bVar, zn.b bVar2, byte[] bArr) throws CMSException {
        Key keyG = g(bVar, bVar2, bArr);
        return new z1(new a(bVar2, keyG, this.f44624e.h(keyG, bVar2)));
    }
}
