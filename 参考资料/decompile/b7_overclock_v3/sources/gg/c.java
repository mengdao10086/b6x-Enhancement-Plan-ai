package gg;

import android.os.Handler;
import com.qualcomm.qti.libraries.gaia.GaiaException;
import g.p0;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes5.dex */
public abstract class c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f29543g = 30000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f29548e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f29544a = "GaiaManager";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.collection.a<Integer, LinkedList<a>> f29545b = new androidx.collection.a<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f29546c = 30000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f29547d = new Handler();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f29549f = false;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ig.b f29550a;

        public a(ig.b bVar) {
            this.f29550a = bVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            synchronized (c.this.f29545b) {
                int iE = this.f29550a.f32371b.e();
                if (c.this.f29549f) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("A request is timed out for command: ");
                    sb2.append(d.c(iE));
                }
                if (!c.this.f29545b.containsKey(Integer.valueOf(iE))) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Unexpected runnable is running for command: ");
                    sb3.append(d.c(iE));
                    return;
                }
                LinkedList linkedList = (LinkedList) c.this.f29545b.get(Integer.valueOf(iE));
                linkedList.remove(this);
                if (linkedList.isEmpty()) {
                    c.this.f29545b.remove(Integer.valueOf(iE));
                }
                StringBuilder sb4 = new StringBuilder();
                sb4.append("No ACK packet for command: ");
                sb4.append(d.c(this.f29550a.f32371b.e()));
                c.this.o(this.f29550a.f32371b);
            }
        }
    }

    public c(int i10) {
        this.f29548e = i10;
    }

    public void A(boolean z10) {
        this.f29549f = z10;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Debug logs are now ");
        sb2.append(z10 ? "activated" : "deactivated");
        sb2.append(j3.b.f36044h);
    }

    public final void B(ig.b bVar) {
        if (this.f29549f) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Set up TimeOutRequestRunnable for type request: ");
            sb2.append(bVar.f32370a);
            sb2.append(" for command ");
            sb2.append(d.c(bVar.f32371b.e()));
        }
        a aVar = new a(bVar);
        int iE = bVar.f32371b.e();
        if (this.f29545b.containsKey(Integer.valueOf(iE))) {
            this.f29545b.get(Integer.valueOf(iE)).add(aVar);
        } else {
            LinkedList<a> linkedList = new LinkedList<>();
            linkedList.add(aVar);
            this.f29545b.put(Integer.valueOf(bVar.f32371b.e()), linkedList);
        }
        this.f29547d.postDelayed(aVar, this.f29546c);
    }

    public final boolean j(int i10) {
        synchronized (this.f29545b) {
            if (this.f29549f) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Request to cancel a TimeOutRequestRunnable for command: ");
                sb2.append(d.c(i10));
            }
            if (!this.f29545b.containsKey(Integer.valueOf(i10))) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("No pending TimeOutRequestRunnable matches command: ");
                sb3.append(d.c(i10));
                return false;
            }
            LinkedList<a> linkedList = this.f29545b.get(Integer.valueOf(i10));
            this.f29547d.removeCallbacks(linkedList.remove(0));
            if (linkedList.isEmpty()) {
                this.f29545b.remove(Integer.valueOf(i10));
            }
            return true;
        }
    }

    public void k(hg.a aVar, int i10, @p0 byte[] bArr) {
        if (this.f29549f) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Received request to send an acknowledgement packet for command: ");
            sb2.append(d.c(aVar.e()));
            sb2.append(" with status: ");
            sb2.append(b.c(i10));
        }
        ig.a aVar2 = new ig.a(i10, bArr);
        aVar2.f32371b = aVar;
        s(aVar2);
    }

    public void l(hg.a aVar) {
        if (this.f29549f) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Received request to send a packet with expected acknowledgement for command: ");
            sb2.append(d.c(aVar.e()));
        }
        ig.b bVar = new ig.b(1);
        bVar.f32371b = aVar;
        s(bVar);
    }

    public void m(hg.a aVar) {
        if (this.f29549f) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Received request to send a packet with no acknowledgement for command: ");
            sb2.append(d.c(aVar.e()));
        }
        ig.b bVar = new ig.b(3);
        bVar.f32371b = aVar;
        s(bVar);
    }

    public int n() {
        return this.f29548e;
    }

    public abstract void o(hg.a aVar);

    public abstract boolean p(hg.a aVar);

    public void q(byte[] bArr) {
        if (this.f29549f) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Received potential GAIA packet: ");
            sb2.append(d.d(bArr));
        }
        try {
            hg.a bVar = this.f29548e == 0 ? new hg.b(bArr) : new hg.c(bArr);
            if (this.f29549f) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Manager could retrieve a packet from the given data with command: ");
                sb3.append(d.c(bVar.e()));
            }
            if (!bVar.l()) {
                if (p(bVar)) {
                    return;
                }
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Packet has not been managed by application, manager sends NOT_SUPPORTED acknowledgement, bytes: \n\t\t");
                sb4.append(d.c(bVar.f()));
                k(bVar, 1, null);
                return;
            }
            if (!j(bVar.e())) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Received unexpected acknowledgement packet for command ");
                sb5.append(d.c(bVar.e()));
            }
            int iJ = bVar.j();
            if (this.f29549f) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("Received GAIA ACK packet for command ");
                sb6.append(d.c(bVar.e()));
                sb6.append(" with status: ");
                sb6.append(b.c(iJ));
            }
            if (iJ == 0) {
                t(bVar);
            } else {
                u(bVar);
            }
        } catch (GaiaException unused) {
            StringBuilder sb7 = new StringBuilder();
            sb7.append("Impossible to retrieve packet from device: ");
            sb7.append(d.d(bArr));
        }
    }

    public abstract void r(hg.a aVar);

    public final void s(ig.b bVar) {
        if (this.f29549f) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Processing request of type ");
            sb2.append(bVar.f32370a);
        }
        int i10 = bVar.f32370a;
        if (i10 == 1) {
            try {
                byte[] bArrD = bVar.f32371b.d();
                B(bVar);
                if (y(bArrD)) {
                    return;
                }
                j(bVar.f32371b.e());
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Fail to send GAIA packet for GAIA command: ");
                sb3.append(d.c(bVar.f32371b.f()));
                r(bVar.f32371b);
                return;
            } catch (GaiaException e10) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Exception when attempting to create GAIA packet: ");
                sb4.append(e10.toString());
                return;
            }
        }
        if (i10 == 2) {
            ig.a aVar = (ig.a) bVar;
            x(aVar.f32371b, aVar.f32368c, aVar.f32369d);
            return;
        }
        if (i10 != 3) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Not possible to create request with type ");
            sb5.append(bVar.f32370a);
            sb5.append(" for GAIA command: ");
            sb5.append(bVar.f32371b.f());
            return;
        }
        try {
            if (y(bVar.f32371b.d())) {
                return;
            }
            StringBuilder sb6 = new StringBuilder();
            sb6.append("Fail to send GAIA packet for GAIA command: ");
            sb6.append(bVar.f32371b.f());
            r(bVar.f32371b);
        } catch (GaiaException e11) {
            StringBuilder sb7 = new StringBuilder();
            sb7.append("Exception when attempting to create GAIA packet: ");
            sb7.append(e11.toString());
        }
    }

    public abstract void t(hg.a aVar);

    public abstract void u(hg.a aVar);

    public void v() {
        w();
    }

    public final synchronized void w() {
        boolean z10 = this.f29549f;
        for (int i10 = 0; i10 < this.f29545b.size(); i10++) {
            Iterator<a> it2 = this.f29545b.o(i10).iterator();
            while (it2.hasNext()) {
                this.f29547d.removeCallbacks(it2.next());
            }
        }
        this.f29545b.clear();
    }

    public final void x(hg.a aVar, int i10, @p0 byte[] bArr) {
        if (this.f29549f) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Request to send acknowledgement for packet with command ");
            sb2.append(d.e(aVar.e()));
        }
        if (aVar.l()) {
            return;
        }
        try {
            y(aVar.c(i10, bArr));
        } catch (GaiaException e10) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("ACK packet not created, exception occurred: ");
            sb3.append(e10.toString());
        }
    }

    public abstract boolean y(byte[] bArr);

    public synchronized void z(int i10) {
        if (this.f29549f) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Time out set up to ");
            sb2.append(i10);
            sb2.append(", previous time out was ");
            sb2.append(this.f29546c);
        }
        this.f29546c = i10;
    }
}
