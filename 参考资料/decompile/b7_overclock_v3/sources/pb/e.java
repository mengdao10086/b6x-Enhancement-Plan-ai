package pb;

import hb.l;
import hd.c0;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f46548a = new f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0 f46549b = new c0(new byte[f.f46555n], 0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f46550c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f46551d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f46552e;

    public final int a(int i10) {
        int i11;
        int i12 = 0;
        this.f46551d = 0;
        do {
            int i13 = this.f46551d;
            int i14 = i10 + i13;
            f fVar = this.f46548a;
            if (i14 >= fVar.f46565g) {
                break;
            }
            int[] iArr = fVar.f46568j;
            this.f46551d = i13 + 1;
            i11 = iArr[i13 + i10];
            i12 += i11;
        } while (i11 == 255);
        return i12;
    }

    public f b() {
        return this.f46548a;
    }

    public c0 c() {
        return this.f46549b;
    }

    public boolean d(l lVar) throws IOException {
        int i10;
        hd.a.i(lVar != null);
        if (this.f46552e) {
            this.f46552e = false;
            this.f46549b.O(0);
        }
        while (!this.f46552e) {
            if (this.f46550c < 0) {
                if (!this.f46548a.d(lVar) || !this.f46548a.b(lVar, true)) {
                    return false;
                }
                f fVar = this.f46548a;
                int iA = fVar.f46566h;
                if ((fVar.f46560b & 1) == 1 && this.f46549b.f() == 0) {
                    iA += a(0);
                    i10 = this.f46551d + 0;
                } else {
                    i10 = 0;
                }
                lVar.o(iA);
                this.f46550c = i10;
            }
            int iA2 = a(this.f46550c);
            int i11 = this.f46550c + this.f46551d;
            if (iA2 > 0) {
                c0 c0Var = this.f46549b;
                c0Var.c(c0Var.f() + iA2);
                lVar.readFully(this.f46549b.d(), this.f46549b.f(), iA2);
                c0 c0Var2 = this.f46549b;
                c0Var2.R(c0Var2.f() + iA2);
                this.f46552e = this.f46548a.f46568j[i11 + (-1)] != 255;
            }
            if (i11 == this.f46548a.f46565g) {
                i11 = -1;
            }
            this.f46550c = i11;
        }
        return true;
    }

    public void e() {
        this.f46548a.c();
        this.f46549b.O(0);
        this.f46550c = -1;
        this.f46552e = false;
    }

    public void f() {
        if (this.f46549b.d().length == 65025) {
            return;
        }
        c0 c0Var = this.f46549b;
        c0Var.Q(Arrays.copyOf(c0Var.d(), Math.max(f.f46555n, this.f46549b.f())), this.f46549b.f());
    }
}
