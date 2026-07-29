package org.bouncycastle.cms.jcajce;

import java.io.OutputStream;
import java.security.Key;
import java.security.PrivateKey;
import javax.crypto.Mac;
import org.bouncycastle.cms.CMSException;
import so.z1;

/* JADX INFO: loaded from: classes5.dex */
public class c0 extends e0 {

    public class a implements cs.y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ zn.b f44531a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Key f44532b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Mac f44533c;

        public a(zn.b bVar, Key key, Mac mac) {
            this.f44531a = bVar;
            this.f44532b = key;
            this.f44533c = mac;
        }

        @Override // cs.y
        public zn.b a() {
            return this.f44531a;
        }

        @Override // cs.y
        public OutputStream b() {
            return new lq.d(this.f44533c);
        }

        @Override // cs.y
        public byte[] d() {
            return this.f44533c.doFinal();
        }

        @Override // cs.y
        public cs.q getKey() {
            return new org.bouncycastle.operator.jcajce.g(this.f44531a, this.f44532b);
        }
    }

    public c0(PrivateKey privateKey) {
        super(privateKey);
    }

    @Override // so.g1
    public z1 a(zn.b bVar, zn.b bVar2, byte[] bArr) throws CMSException {
        Key keyG = g(bVar, bVar2, bArr);
        return new z1(new a(bVar2, keyG, this.f44540e.h(keyG, bVar2)));
    }
}
