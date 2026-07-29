package xa;

/* JADX INFO: loaded from: classes3.dex */
public class j extends i {
    public j(l lVar) {
        super(lVar);
    }

    @Override // xa.i
    public void p(boolean z10) {
        this.f54999b.reset();
        if (!z10) {
            this.f54999b.postTranslate(this.f55000c.P(), this.f55000c.n() - this.f55000c.O());
        } else {
            this.f54999b.setTranslate(-(this.f55000c.o() - this.f55000c.Q()), this.f55000c.n() - this.f55000c.O());
            this.f54999b.postScale(-1.0f, 1.0f);
        }
    }
}
