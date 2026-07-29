package org.bouncycastle.cms.jcajce;

import java.io.OutputStream;
import java.security.Key;
import javax.crypto.Mac;
import org.bouncycastle.cms.CMSException;
import so.z1;

/* JADX INFO: loaded from: classes5.dex */
public class h0 extends j0 {

    public class a implements cs.y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ zn.b f44554a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Key f44555b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Mac f44556c;

        public a(zn.b bVar, Key key, Mac mac) {
            this.f44554a = bVar;
            this.f44555b = key;
            this.f44556c = mac;
        }

        @Override // cs.y
        public zn.b a() {
            return this.f44554a;
        }

        @Override // cs.y
        public OutputStream b() {
            return new lq.d(this.f44556c);
        }

        @Override // cs.y
        public byte[] d() {
            return this.f44556c.doFinal();
        }

        @Override // cs.y
        public cs.q getKey() {
            return new org.bouncycastle.operator.jcajce.g(this.f44554a, this.f44555b);
        }
    }

    public h0(char[] cArr) {
        super(cArr);
    }

    @Override // so.q1
    public z1 e(zn.b bVar, zn.b bVar2, byte[] bArr, byte[] bArr2) throws CMSException {
        Key keyG = g(bVar, bVar2, bArr, bArr2);
        return new z1(new a(bVar2, keyG, this.f44578d.h(keyG, bVar2)));
    }
}
