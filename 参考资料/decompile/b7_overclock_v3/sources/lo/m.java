package lo;

import java.util.Date;

/* JADX INFO: loaded from: classes5.dex */
public class m implements d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public nn.m f40101b;

    public m(Date date, int i10) {
        this.f40101b = new nn.m(new gm.o(date), zn.m.z(i10));
    }

    public m(nn.m mVar) {
        this.f40101b = mVar;
    }

    public int a() {
        if (this.f40101b.z() != null) {
            return this.f40101b.z().y().intValue();
        }
        throw new IllegalStateException("attempt to get a reason where none is available");
    }

    public Date b() {
        return i.a(this.f40101b.A());
    }

    public boolean c() {
        return this.f40101b.z() != null;
    }
}
