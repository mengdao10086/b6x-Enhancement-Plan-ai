package xp;

import java.util.Set;
import org.bouncycastle.est.ESTException;

/* JADX INFO: loaded from: classes5.dex */
public class d implements org.bouncycastle.est.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f55728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f55729b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f55730c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f55731d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<String> f55732e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Long f55733f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f55734g;

    public d(i iVar, k kVar, int i10, a aVar, Set<String> set, Long l10, boolean z10) {
        this.f55728a = iVar;
        this.f55729b = kVar;
        this.f55730c = i10;
        this.f55731d = aVar;
        this.f55732e = set;
        this.f55733f = l10;
        this.f55734g = z10;
    }

    @Override // org.bouncycastle.est.g
    public boolean a() {
        return this.f55729b.a();
    }

    @Override // org.bouncycastle.est.g
    public org.bouncycastle.est.f b() throws ESTException {
        try {
            return new b(new c(this.f55729b.b(), this.f55728a, this.f55730c, this.f55731d, this.f55732e, this.f55733f, this.f55734g));
        } catch (Exception e10) {
            throw new ESTException(e10.getMessage(), e10.getCause());
        }
    }
}
