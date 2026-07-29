package lb;

import hb.l;
import hb.v;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends v {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f39552c;

    public c(l lVar, long j10) {
        super(lVar);
        hd.a.a(lVar.getPosition() >= j10);
        this.f39552c = j10;
    }

    @Override // hb.v, hb.l
    public long getLength() {
        return super.getLength() - this.f39552c;
    }

    @Override // hb.v, hb.l
    public long getPosition() {
        return super.getPosition() - this.f39552c;
    }

    @Override // hb.v, hb.l
    public long i() {
        return super.i() - this.f39552c;
    }

    @Override // hb.v, hb.l
    public <E extends Throwable> void l(long j10, E e10) throws Throwable {
        super.l(j10 + this.f39552c, e10);
    }
}
