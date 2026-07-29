package org.bouncycastle.cms.jcajce;

import java.io.OutputStream;
import java.security.Key;
import java.security.PrivateKey;
import javax.crypto.Mac;
import org.bouncycastle.cms.CMSException;
import so.z1;
import zn.c1;

/* JADX INFO: loaded from: classes5.dex */
public class w extends y {

    public class a implements cs.y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ zn.b f44641a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Key f44642b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Mac f44643c;

        public a(zn.b bVar, Key key, Mac mac) {
            this.f44641a = bVar;
            this.f44642b = key;
            this.f44643c = mac;
        }

        @Override // cs.y
        public zn.b a() {
            return this.f44641a;
        }

        @Override // cs.y
        public OutputStream b() {
            return new lq.d(this.f44643c);
        }

        @Override // cs.y
        public byte[] d() {
            return this.f44643c.doFinal();
        }

        @Override // cs.y
        public cs.q getKey() {
            return new org.bouncycastle.operator.jcajce.g(this.f44641a, this.f44642b);
        }
    }

    public w(PrivateKey privateKey) {
        super(privateKey);
    }

    @Override // so.c1
    public z1 c(zn.b bVar, zn.b bVar2, c1 c1Var, gm.z zVar, byte[] bArr) throws CMSException {
        Key keyH = h(bVar, bVar2, c1Var, zVar, bArr);
        return new z1(new a(bVar2, keyH, this.f44654e.h(keyH, bVar2)));
    }
}
