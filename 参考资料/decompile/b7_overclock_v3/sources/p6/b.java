package p6;

import android.os.Handler;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes7.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC0527b f46474b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f46473a = "RWCPClient";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f46475c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f46476d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f46477e = 15;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f46478f = 32;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f46479g = 15;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f46480h = 15;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f46481i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f46482j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final LinkedList<byte[]> f46483k = new LinkedList<>();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final LinkedList<p6.c> f46484l = new LinkedList<>();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final c f46485m = new c();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f46486n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Handler f46487o = new Handler();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f46488p = 100;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f46489q = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f46490r = 0;

    /* JADX INFO: renamed from: p6.b$b, reason: collision with other inner class name */
    public interface InterfaceC0527b {
        void J();

        void Q(int i10);

        void q();

        boolean s(byte[] bArr);
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.m();
        }
    }

    public b(InterfaceC0527b interfaceC0527b) {
        this.f46474b = interfaceC0527b;
    }

    public final boolean A(p6.c cVar, int i10) {
        if (!this.f46474b.s(cVar.b())) {
            return false;
        }
        F(i10);
        return true;
    }

    public boolean B(int i10) {
        k("set initial window size to " + i10);
        if (this.f46482j != 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("FAIL to set initial window size to ");
            sb2.append(i10);
            sb2.append(": not possible when there is an ongoing session.");
            return false;
        }
        if (i10 > 0 && i10 <= this.f46478f) {
            this.f46477e = i10;
            this.f46479g = i10;
            return true;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("FAIL to set initial window to ");
        sb3.append(i10);
        sb3.append(": size is out of range.");
        return false;
    }

    public boolean C(int i10) {
        k("set maximum window size to " + i10);
        if (this.f46482j != 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("FAIL to set maximum window size to ");
            sb2.append(i10);
            sb2.append(": not possible when there is an ongoing session.");
            return false;
        }
        if (i10 <= 0 || i10 > 32) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("FAIL to set maximum window to ");
            sb3.append(i10);
            sb3.append(": size is out of range.");
            return false;
        }
        if (this.f46477e > this.f46478f) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("FAIL to set maximum window to ");
            sb4.append(i10);
            sb4.append(": initial window is ");
            sb4.append(this.f46477e);
            sb4.append(j3.b.f36044h);
            return false;
        }
        this.f46478f = i10;
        if (this.f46479g <= i10) {
            return true;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("window is updated to be less than the maximum window size (");
        sb5.append(this.f46478f);
        sb5.append(").");
        this.f46479g = this.f46478f;
        return true;
    }

    public void D(boolean z10) {
        this.f46489q = z10;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Debug logs are now ");
        sb2.append(z10 ? "activated" : "deactivated");
        sb2.append(j3.b.f36044h);
    }

    public final boolean E() {
        k("startSession");
        if (this.f46482j != 0) {
            return false;
        }
        if (y()) {
            return true;
        }
        G();
        return false;
    }

    public final void F(long j10) {
        if (this.f46486n) {
            this.f46487o.removeCallbacks(this.f46485m);
        }
        this.f46486n = true;
        this.f46487o.postDelayed(this.f46485m, j10);
    }

    public final void G() {
        k("terminateSession");
        v(true);
    }

    public final int H(int i10, int i11) {
        if (i11 < 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Received ACK sequence (");
            sb2.append(i11);
            sb2.append(") is less than 0.");
            return -1;
        }
        if (i11 > 63) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Received ACK sequence (");
            sb3.append(i11);
            sb3.append(") is bigger than its maximum value (");
            sb3.append(63);
            sb3.append(").");
            return -1;
        }
        int iH = this.f46475c;
        int i12 = this.f46476d;
        if (iH < i12 && (i11 < iH || i11 > i12)) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Received ACK sequence (");
            sb4.append(i11);
            sb4.append(") is out of interval: last received is ");
            sb4.append(this.f46475c);
            sb4.append(" and next will be ");
            sb4.append(this.f46476d);
            return -1;
        }
        if (iH > i12 && i11 < iH && i11 > i12) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Received ACK sequence (");
            sb5.append(i11);
            sb5.append(") is out of interval: last received is ");
            sb5.append(this.f46475c);
            sb5.append(" and next will be ");
            sb5.append(this.f46476d);
            return -1;
        }
        int i13 = 0;
        synchronized (this.f46484l) {
            while (iH != i11) {
                iH = h(iH);
                if (r(i10, iH)) {
                    this.f46475c = iH;
                    int i14 = this.f46480h;
                    if (i14 < this.f46479g) {
                        this.f46480h = i14 + 1;
                    }
                    i13++;
                } else {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("Error validating sequence ");
                    sb6.append(iH);
                    sb6.append(": no corresponding segment in pending segments.");
                }
            }
        }
        k(i13 + " segment(s) validated with ACK sequence(code=" + i10 + ", seq=" + i11 + ee.a.f26979d);
        i(i13);
        return i13;
    }

    public final void b() {
        if (this.f46486n) {
            this.f46487o.removeCallbacks(this.f46485m);
            this.f46486n = false;
        }
    }

    public void c() {
        k("cancelTransfer");
        if (this.f46482j == 0) {
            return;
        }
        v(true);
        if (y()) {
            return;
        }
        G();
    }

    public final int d(int i10, int i11) {
        return (((i10 - i11) + 63) + 1) % 64;
    }

    public final void e() {
        int i10 = ((this.f46479g - 1) / 2) + 1;
        this.f46479g = i10;
        if (i10 > this.f46478f || i10 < 1) {
            this.f46479g = 1;
        }
        this.f46490r = 0;
        this.f46480h = this.f46479g;
        k("decrease window to " + this.f46479g);
    }

    public int f() {
        return this.f46477e;
    }

    public int g() {
        return this.f46478f;
    }

    public final int h(int i10) {
        return (i10 + 1) % 64;
    }

    public final void i(int i10) {
        int i11 = this.f46490r + i10;
        this.f46490r = i11;
        int i12 = this.f46479g;
        if (i11 <= i12 || i12 >= this.f46478f) {
            return;
        }
        this.f46490r = 0;
        this.f46479g = i12 + 1;
        this.f46480h++;
        k("increase window to " + this.f46479g);
    }

    public boolean j() {
        return this.f46482j != 0;
    }

    public final void k(String str) {
        if (this.f46489q) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append("\t\t\tstate=");
            sb2.append(p6.a.a(this.f46482j));
            sb2.append("\n\tWindow: \tcurrent = ");
            sb2.append(this.f46479g);
            sb2.append(" \t\tdefault = ");
            sb2.append(this.f46477e);
            sb2.append(" \t\tcredits = ");
            sb2.append(this.f46480h);
            sb2.append("\n\tSequence: \tlast = ");
            sb2.append(this.f46475c);
            sb2.append(" \t\tnext = ");
            sb2.append(this.f46476d);
            sb2.append("\n\tPending: \tPSegments = ");
            sb2.append(this.f46484l.size());
            sb2.append(" \t\tPData = ");
            sb2.append(this.f46483k.size());
        }
    }

    public boolean l(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        if (bArr.length < 1) {
            if (this.f46489q) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Analyse of RWCP Segment failed: the byte array does not contain the minimum required information.");
                sb2.append("\n\tbytes=");
                sb2.append(i6.b.f(bArr));
            }
            return false;
        }
        p6.c cVar = new p6.c(bArr);
        int iD = cVar.d();
        if (iD == -1) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("onReceivedRWCPSegment failed to get a RWCP segment from given bytes: ");
            sb3.append(i6.b.f(bArr));
            return false;
        }
        if (iD == 0) {
            return n(cVar);
        }
        if (iD == 1) {
            return q(cVar);
        }
        if (iD == 2) {
            return p(cVar);
        }
        if (iD == 3) {
            return o(cVar);
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append("Received unknown operation code: ");
        sb4.append(iD);
        return false;
    }

    public final void m() {
        if (this.f46486n) {
            this.f46486n = false;
            this.f46481i = true;
            this.f46490r = 0;
            if (this.f46482j != 2) {
                u();
                return;
            }
            int i10 = this.f46488p * 2;
            this.f46488p = i10;
            if (i10 > 2000) {
                this.f46488p = 2000;
            }
            t();
        }
    }

    public final boolean n(p6.c cVar) {
        if (this.f46489q) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Receive DATA_ACK for sequence ");
            sb2.append(cVar.f());
        }
        int i10 = this.f46482j;
        if (i10 != 2) {
            if (i10 != 3) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Received unexpected DATA_ACK segment with sequence ");
                sb3.append(cVar.f());
                sb3.append(" while in state ");
                sb3.append(p6.a.a(this.f46482j));
                return false;
            }
            if (this.f46489q) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Received DATA_ACK(");
                sb4.append(cVar.f());
                sb4.append(") segment while in state CLOSING: segment discarded.");
            }
            return true;
        }
        b();
        int iH = H(0, cVar.f());
        if (iH >= 0) {
            if (this.f46480h > 0 && !this.f46483k.isEmpty()) {
                x();
            } else if (this.f46483k.isEmpty() && this.f46484l.isEmpty()) {
                y();
            } else if (this.f46483k.isEmpty() || this.f46480h == 0) {
                F(this.f46488p);
            }
            this.f46474b.Q(iH);
        }
        return true;
    }

    public final boolean o(p6.c cVar) {
        if (this.f46489q) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Receive GAP for sequence ");
            sb2.append(cVar.f());
        }
        int i10 = this.f46482j;
        if (i10 != 2) {
            if (i10 != 3) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Received unexpected GAP segment with header ");
                sb3.append((int) cVar.c());
                sb3.append(" while in state ");
                sb3.append(p6.a.a(this.f46482j));
                return false;
            }
            if (this.f46489q) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Received GAP(");
                sb4.append(cVar.f());
                sb4.append(") segment while in state CLOSING: segment discarded.");
            }
            return true;
        }
        if (this.f46475c <= cVar.f()) {
            if (this.f46475c <= cVar.f()) {
                e();
                H(0, cVar.f());
            }
            b();
            t();
            return true;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Ignoring GAP (");
        sb5.append(cVar.f());
        sb5.append(") as last ack sequence is ");
        sb5.append(this.f46475c);
        sb5.append(j3.b.f36044h);
        return true;
    }

    public final boolean p(p6.c cVar) {
        if (this.f46489q) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Receive RST or RST_ACK for sequence ");
            sb2.append(cVar.f());
        }
        int i10 = this.f46482j;
        if (i10 == 1) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Received RST (sequence ");
            sb3.append(cVar.f());
            sb3.append(") in SYN_SENT state, ignoring segment.");
            return true;
        }
        if (i10 == 2) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Received RST (sequence ");
            sb4.append(cVar.f());
            sb4.append(") in ESTABLISHED state, terminating session, transfer failed.");
            G();
            this.f46474b.J();
            return true;
        }
        if (i10 != 3) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Received unexpected RST segment with sequence=");
            sb5.append(cVar.f());
            sb5.append(" while in state ");
            sb5.append(p6.a.a(this.f46482j));
            return false;
        }
        b();
        H(2, cVar.f());
        v(false);
        if (this.f46483k.isEmpty()) {
            this.f46474b.q();
        } else if (!z()) {
            G();
            this.f46474b.J();
        }
        return true;
    }

    public final boolean q(p6.c cVar) {
        if (this.f46489q) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Receive SYN_ACK for sequence ");
            sb2.append(cVar.f());
        }
        int i10 = this.f46482j;
        if (i10 != 1) {
            if (i10 == 2) {
                b();
                if (this.f46484l.size() > 0) {
                    t();
                }
                return true;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Received unexpected SYN_ACK segment with header ");
            sb3.append((int) cVar.c());
            sb3.append(" while in state ");
            sb3.append(p6.a.a(this.f46482j));
            return false;
        }
        b();
        if (H(1, cVar.f()) >= 0) {
            this.f46482j = 2;
            if (this.f46483k.size() > 0) {
                x();
            }
        } else {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Receive SYN_ACK with unexpected sequence number: ");
            sb4.append(cVar.f());
            G();
            this.f46474b.J();
            y();
        }
        return true;
    }

    public final boolean r(int i10, int i11) {
        synchronized (this.f46484l) {
            for (p6.c cVar : this.f46484l) {
                if (cVar.d() == i10 && cVar.f() == i11) {
                    this.f46484l.remove(cVar);
                    return true;
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Pending segments does not contain acknowledged segment: code=");
            sb2.append(i10);
            sb2.append(" \tsequence=");
            sb2.append(i11);
            return false;
        }
    }

    public final boolean s(p6.c cVar) {
        synchronized (this.f46484l) {
            if (this.f46484l.remove(cVar)) {
                return true;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Pending unack segments does not contain segment (code=");
            sb2.append(cVar.d());
            sb2.append(", seq=");
            sb2.append(cVar.f());
            sb2.append(ee.a.f26979d);
            return false;
        }
    }

    public final void t() {
        if (this.f46482j != 2) {
            return;
        }
        this.f46481i = true;
        this.f46480h = this.f46479g;
        k("reset credits");
        synchronized (this.f46484l) {
            int i10 = 0;
            while (true) {
                if (this.f46484l.size() <= this.f46480h) {
                    break;
                }
                p6.c last = this.f46484l.getLast();
                if (last.d() != 0) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Segment ");
                    sb2.append(last.toString());
                    sb2.append(" in pending segments but not a DATA segment.");
                    break;
                }
                s(last);
                this.f46483k.addFirst(last.e());
                i10++;
            }
            this.f46476d = d(this.f46476d, i10);
            Iterator<p6.c> it2 = this.f46484l.iterator();
            while (it2.hasNext()) {
                A(it2.next(), this.f46488p);
                this.f46480h--;
            }
        }
        k("Resend DATA segments");
        this.f46481i = false;
        if (this.f46480h > 0) {
            x();
        }
    }

    public final void u() {
        if (this.f46482j == 2) {
            return;
        }
        this.f46481i = true;
        this.f46480h = this.f46479g;
        synchronized (this.f46484l) {
            for (p6.c cVar : this.f46484l) {
                int i10 = 1000;
                if (cVar.d() != 1 && cVar.d() != 2) {
                    i10 = this.f46488p;
                }
                A(cVar, i10);
                this.f46480h--;
            }
        }
        k("resend segments");
        this.f46481i = false;
    }

    public final void v(boolean z10) {
        synchronized (this.f46484l) {
            this.f46475c = -1;
            this.f46476d = 0;
            this.f46482j = 0;
            this.f46484l.clear();
            int i10 = this.f46477e;
            this.f46479g = i10;
            this.f46490r = 0;
            this.f46480h = i10;
            b();
        }
        if (z10) {
            this.f46483k.clear();
        }
        k("reset");
    }

    public boolean w(byte[] bArr) {
        this.f46483k.add(bArr);
        int i10 = this.f46482j;
        if (i10 == 0) {
            return E();
        }
        if (i10 == 2 && !this.f46486n) {
            x();
        }
        return true;
    }

    public final void x() {
        while (this.f46480h > 0 && !this.f46483k.isEmpty() && !this.f46481i && this.f46482j == 2) {
            synchronized (this.f46484l) {
                p6.c cVar = new p6.c(0, this.f46476d, this.f46483k.poll());
                A(cVar, this.f46488p);
                this.f46484l.add(cVar);
                this.f46476d = h(this.f46476d);
                this.f46480h--;
            }
        }
        k("send DATA segments");
    }

    public final boolean y() {
        boolean zA;
        if (this.f46482j == 3) {
            return true;
        }
        v(false);
        synchronized (this.f46484l) {
            this.f46482j = 3;
            p6.c cVar = new p6.c(2, this.f46476d);
            zA = A(cVar, 1000);
            if (zA) {
                this.f46484l.add(cVar);
                this.f46476d = h(this.f46476d);
                this.f46480h--;
                k("send RST segment");
            }
        }
        return zA;
    }

    public final boolean z() {
        boolean zA;
        synchronized (this.f46484l) {
            this.f46482j = 1;
            p6.c cVar = new p6.c(1, this.f46476d);
            zA = A(cVar, 1000);
            if (zA) {
                this.f46484l.add(cVar);
                this.f46476d = h(this.f46476d);
                this.f46480h--;
                k("send SYN segment");
            }
        }
        return zA;
    }
}
