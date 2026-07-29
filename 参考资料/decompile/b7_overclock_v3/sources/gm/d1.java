package gm;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
public abstract class d1 extends p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f29654b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f29655c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f29656d;

    public d1(OutputStream outputStream) {
        super(outputStream);
        this.f29654b = false;
    }

    public d1(OutputStream outputStream, int i10, boolean z10) {
        super(outputStream);
        this.f29654b = true;
        this.f29655c = z10;
        this.f29656d = i10;
    }

    @Override // gm.p
    public OutputStream a() {
        return this.f29761a;
    }

    public void b() throws IOException {
        this.f29761a.write(0);
        this.f29761a.write(0);
        if (this.f29654b && this.f29655c) {
            this.f29761a.write(0);
            this.f29761a.write(0);
        }
    }

    public void c(int i10) throws IOException {
        if (this.f29654b) {
            int i11 = this.f29656d | 128;
            if (this.f29655c) {
                d(i11 | 32);
            } else {
                if ((i10 & 32) == 0) {
                    d(i11);
                    return;
                }
                i10 = i11 | 32;
            }
        }
        d(i10);
    }

    public final void d(int i10) throws IOException {
        this.f29761a.write(i10);
        this.f29761a.write(128);
    }
}
