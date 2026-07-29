package org.bouncycastle.cms.jcajce;

import java.io.IOException;
import java.io.OutputStream;
import java.security.Key;
import java.security.PrivateKey;
import javax.crypto.Mac;
import org.bouncycastle.cms.CMSException;
import so.h1;
import so.z1;

/* JADX INFO: loaded from: classes5.dex */
public class t extends v {

    public class a implements cs.y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ zn.b f44626a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Key f44627b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Mac f44628c;

        public a(zn.b bVar, Key key, Mac mac) {
            this.f44626a = bVar;
            this.f44627b = key;
            this.f44628c = mac;
        }

        @Override // cs.y
        public zn.b a() {
            return this.f44626a;
        }

        @Override // cs.y
        public OutputStream b() {
            return new lq.d(this.f44628c);
        }

        @Override // cs.y
        public byte[] d() {
            return this.f44628c.doFinal();
        }

        @Override // cs.y
        public cs.q getKey() {
            return new org.bouncycastle.operator.jcajce.g(this.f44626a, this.f44627b);
        }
    }

    public t(PrivateKey privateKey, h1 h1Var) throws IOException {
        super(privateKey, v.h(h1Var));
    }

    @Override // so.g1
    public z1 a(zn.b bVar, zn.b bVar2, byte[] bArr) throws CMSException {
        Key keyG = g(bVar, bVar2, bArr);
        return new z1(new a(bVar2, keyG, this.f44637f.h(keyG, bVar2)));
    }
}
