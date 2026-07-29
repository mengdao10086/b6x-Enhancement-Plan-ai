package zs;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.crypto.n;
import org.bouncycastle.pqc.jcajce.provider.qtesla.BCqTESLAPrivateKey;
import org.bouncycastle.pqc.jcajce.provider.qtesla.BCqTESLAPublicKey;
import org.bouncycastle.util.j;
import os.e;
import os.f;
import os.g;

/* JADX INFO: loaded from: classes6.dex */
public class b extends KeyPairGenerator {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map f59716e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public os.c f59717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public os.d f59718b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SecureRandom f59719c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f59720d;

    static {
        HashMap map = new HashMap();
        f59716e = map;
        map.put(g.a(5), j.g(5));
        map.put(g.a(6), j.g(6));
    }

    public b() {
        super("qTESLA");
        this.f59718b = new os.d();
        this.f59719c = n.f();
        this.f59720d = false;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        if (!this.f59720d) {
            os.c cVar = new os.c(6, this.f59719c);
            this.f59717a = cVar;
            this.f59718b.a(cVar);
            this.f59720d = true;
        }
        org.bouncycastle.crypto.c cVarB = this.f59718b.b();
        return new KeyPair(new BCqTESLAPublicKey((f) cVarB.b()), new BCqTESLAPrivateKey((e) cVarB.a()));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int i10, SecureRandom secureRandom) {
        throw new IllegalArgumentException("use AlgorithmParameterSpec");
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (!(algorithmParameterSpec instanceof et.g)) {
            throw new InvalidAlgorithmParameterException("parameter object not a QTESLAParameterSpec");
        }
        os.c cVar = new os.c(((Integer) f59716e.get(((et.g) algorithmParameterSpec).a())).intValue(), secureRandom);
        this.f59717a = cVar;
        this.f59718b.a(cVar);
        this.f59720d = true;
    }
}
