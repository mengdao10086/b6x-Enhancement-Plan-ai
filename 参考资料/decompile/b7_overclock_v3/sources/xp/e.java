package xp;

import java.security.Provider;
import java.security.SecureRandom;
import org.bouncycastle.est.q;
import org.bouncycastle.operator.OperatorCreationException;

/* JADX INFO: loaded from: classes5.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public org.bouncycastle.operator.jcajce.d f55735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f55736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f55737c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final char[] f55738d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SecureRandom f55739e;

    public e(String str, String str2, char[] cArr) {
        this.f55735a = new org.bouncycastle.operator.jcajce.d();
        this.f55739e = new SecureRandom();
        this.f55736b = str;
        this.f55737c = str2;
        this.f55738d = cArr;
    }

    public e(String str, char[] cArr) {
        this(null, str, cArr);
    }

    public q a() throws OperatorCreationException {
        return new q(this.f55736b, this.f55737c, this.f55738d, this.f55739e, this.f55735a.b());
    }

    public e b(SecureRandom secureRandom) {
        this.f55739e = secureRandom;
        return this;
    }

    public e c(String str) {
        this.f55735a.d(str);
        return this;
    }

    public e d(Provider provider) {
        this.f55735a.e(provider);
        return this;
    }
}
