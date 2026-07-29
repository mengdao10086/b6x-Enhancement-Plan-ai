package org.bouncycastle.cms.jcajce;

import java.io.OutputStream;
import java.security.AlgorithmParameters;
import java.security.Provider;
import java.security.SecureRandom;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import org.bouncycastle.cms.CMSException;

/* JADX INFO: loaded from: classes5.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gm.y f44601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f44602b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f44603c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AlgorithmParameters f44604d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SecureRandom f44605e;

    public class a implements cs.y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SecretKey f44606a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public zn.b f44607b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Mac f44608c;

        public a(gm.y yVar, int i10, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws CMSException {
            KeyGenerator keyGeneratorK = o.this.f44603c.k(yVar);
            secureRandom = secureRandom == null ? new SecureRandom() : secureRandom;
            if (i10 < 0) {
                keyGeneratorK.init(secureRandom);
            } else {
                keyGeneratorK.init(i10, secureRandom);
            }
            this.f44606a = keyGeneratorK.generateKey();
            this.f44607b = o.this.f44603c.s(yVar, algorithmParameters == null ? o.this.f44603c.r(yVar, this.f44606a, secureRandom) : algorithmParameters);
            this.f44608c = o.this.f44603c.h(this.f44606a, this.f44607b);
        }

        @Override // cs.y
        public zn.b a() {
            return this.f44607b;
        }

        @Override // cs.y
        public OutputStream b() {
            return new lq.d(this.f44608c);
        }

        @Override // cs.y
        public byte[] d() {
            return this.f44608c.doFinal();
        }

        @Override // cs.y
        public cs.q getKey() {
            return new org.bouncycastle.operator.jcajce.g(this.f44607b, this.f44606a);
        }
    }

    public o(gm.y yVar) {
        this(yVar, -1);
    }

    public o(gm.y yVar, int i10) {
        this.f44603c = new c(new b());
        this.f44601a = yVar;
        this.f44602b = i10;
    }

    public cs.y b() throws CMSException {
        return new a(this.f44601a, this.f44602b, this.f44604d, this.f44605e);
    }

    public o c(AlgorithmParameters algorithmParameters) {
        this.f44604d = algorithmParameters;
        return this;
    }

    public o d(String str) {
        this.f44603c = new c(new m0(str));
        return this;
    }

    public o e(Provider provider) {
        this.f44603c = new c(new n0(provider));
        return this;
    }

    public o f(SecureRandom secureRandom) {
        this.f44605e = secureRandom;
        return this;
    }
}
