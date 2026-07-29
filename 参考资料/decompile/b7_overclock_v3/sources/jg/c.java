package jg;

import android.annotation.SuppressLint;
import android.os.Handler;
import com.qualcomm.qti.libraries.vmupgrade.packet.VMUException;
import g.n0;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes5.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f36395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f36396b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f36397c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f36398d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f36399e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f36400f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f36401g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f36402h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f36403i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public File f36404j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f36405k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Handler f36406l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f36407m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f36408n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f36409o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f36410p;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.G();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.K();
        }
    }

    /* JADX INFO: renamed from: jg.c$c, reason: collision with other inner class name */
    @Retention(RetentionPolicy.SOURCE)
    @SuppressLint({"ShiftFlags"})
    public @interface InterfaceC0414c {
        public static final int L2 = 1;
        public static final int M2 = 2;
        public static final int N2 = 3;
        public static final int O2 = 4;
        public static final int P2 = 5;
    }

    public interface d {
        void b(int i10);

        void c(int i10);

        void d(jg.b bVar);

        void e();

        void f(byte[] bArr, boolean z10);

        void g(double d10);

        void h();
    }

    public c(@n0 d dVar) {
        this.f36395a = "UpgradeManager";
        this.f36397c = false;
        this.f36398d = 0;
        this.f36399e = 0;
        this.f36401g = 8;
        this.f36402h = false;
        this.f36405k = false;
        this.f36406l = new Handler();
        this.f36407m = 0;
        this.f36408n = false;
        this.f36409o = false;
        this.f36410p = false;
        this.f36396b = dVar;
    }

    public void A(int i10, boolean z10) throws Throwable {
        if (i10 == 1) {
            I(z10);
            if (z10) {
                return;
            }
            this.f36405k = true;
            return;
        }
        if (i10 == 2) {
            z(z10);
            if (z10) {
                return;
            }
            this.f36405k = true;
            return;
        }
        if (i10 == 3) {
            D(z10);
            if (z10) {
                return;
            }
            a();
            return;
        }
        if (i10 == 4) {
            this.f36409o = z10;
            y();
        } else {
            if (i10 != 5) {
                return;
            }
            if (z10) {
                H();
            } else {
                a();
            }
        }
    }

    public final void B(boolean z10, byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length + 1];
        bArr2[0] = z10 ? (byte) 1 : (byte) 0;
        System.arraycopy(bArr, 0, bArr2, 1, bArr.length);
        J(new com.qualcomm.qti.libraries.vmupgrade.packet.a(4, bArr2), true);
    }

    public final void C(byte[] bArr) {
        J(new com.qualcomm.qti.libraries.vmupgrade.packet.a(31, bArr), false);
    }

    public final void D(boolean z10) {
        J(new com.qualcomm.qti.libraries.vmupgrade.packet.a(14, new byte[]{!z10 ? 1 : 0}), false);
    }

    public final void E() {
        h();
        int i10 = this.f36407m;
        int i11 = this.f36401g;
        if (i10 >= i11 - 1) {
            i10 = i11 - 1;
        }
        byte[] bArr = this.f36400f;
        int length = bArr.length;
        int i12 = this.f36399e;
        boolean z10 = length - i12 <= i10;
        byte[] bArr2 = new byte[i10];
        System.arraycopy(bArr, i12, bArr2, 0, i10);
        if (z10) {
            this.f36402h = true;
            this.f36407m = 0;
        } else {
            this.f36399e += i10;
            this.f36407m -= i10;
        }
        B(z10, bArr2);
    }

    public final void F() {
        M(0);
        J(new com.qualcomm.qti.libraries.vmupgrade.packet.a(21), false);
    }

    public final void G() {
        J(new com.qualcomm.qti.libraries.vmupgrade.packet.a(1), false);
    }

    public final void H() throws Throwable {
        byte[] bArrI = jg.d.i(this.f36404j);
        byte[] bArr = new byte[4];
        if (bArrI.length >= 4) {
            System.arraycopy(bArrI, bArrI.length - 4, bArr, 0, 4);
        } else if (bArrI.length > 0) {
            System.arraycopy(bArrI, 0, bArr, 0, bArrI.length);
        }
        J(new com.qualcomm.qti.libraries.vmupgrade.packet.a(19, bArr), false);
    }

    public final void I(boolean z10) {
        J(new com.qualcomm.qti.libraries.vmupgrade.packet.a(12, new byte[]{!z10 ? 1 : 0}), false);
    }

    public final void J(com.qualcomm.qti.libraries.vmupgrade.packet.a aVar, boolean z10) {
        byte[] bArrA = aVar.a();
        if (!this.f36397c) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Sending failed as application is no longer upgrading for opcode: ");
            sb2.append(kg.a.b(aVar.d()));
            return;
        }
        if (this.f36408n) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("send ");
            sb3.append(kg.a.b(aVar.d()));
            sb3.append(": ");
            sb3.append(jg.d.g(bArrA));
        }
        this.f36396b.f(bArrA, z10);
    }

    public final void K() {
        J(new com.qualcomm.qti.libraries.vmupgrade.packet.a(22), false);
    }

    public void L(File file) {
        this.f36404j = file;
    }

    public final void M(int i10) {
        this.f36403i = i10;
        this.f36396b.b(i10);
    }

    public void N(boolean z10) {
        this.f36408n = z10;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Debug logs are now ");
        sb2.append(z10 ? "activated" : "deactivated");
        sb2.append(j3.b.f36044h);
    }

    public final void O(jg.b bVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Error occurs during upgrade process: ");
        sb2.append(bVar.d());
        sb2.append("\nStart abortion...");
        this.f36396b.d(bVar);
        a();
    }

    public void P() {
    }

    public void Q(int i10, boolean z10) throws Throwable {
        if (i10 < 8) {
            this.f36401g = 8;
        } else {
            this.f36401g = i10 - 3;
        }
        this.f36410p = z10;
        File file = this.f36404j;
        if (file == null) {
            this.f36396b.d(new jg.b(6));
            return;
        }
        try {
            this.f36400f = jg.d.e(file);
            R();
        } catch (VMUException e10) {
            jg.b bVar = new jg.b(e10);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Error occurs when attempt to start the process: ");
            sb2.append(bVar.d());
            this.f36396b.d(bVar);
        }
    }

    public final void R() throws Throwable {
        boolean z10 = this.f36397c;
        if (!z10 && this.f36400f != null) {
            this.f36397c = true;
            w();
            H();
        } else if (z10) {
            this.f36396b.d(new jg.b(5));
        } else {
            this.f36396b.d(new jg.b(6));
        }
    }

    public final void S() {
        this.f36397c = false;
        this.f36396b.h();
    }

    public void a() {
        if (this.f36397c) {
            y();
            this.f36397c = false;
        }
    }

    public final void d(int i10) {
        this.f36396b.c(i10);
    }

    public int e() {
        return this.f36403i;
    }

    @SuppressLint({"SwitchIntDef"})
    public final void f(com.qualcomm.qti.libraries.vmupgrade.packet.a aVar) {
        int iD = aVar.d();
        if (iD == 2) {
            p(aVar);
            return;
        }
        if (iD == 3) {
            n(aVar);
            return;
        }
        if (iD == 8) {
            k();
            return;
        }
        if (iD == 11) {
            r();
            return;
        }
        if (iD == 15) {
            l();
            return;
        }
        if (iD == 20) {
            q(aVar);
            return;
        }
        if (iD == 23) {
            v(aVar);
        } else if (iD == 17) {
            o(aVar);
        } else {
            if (iD != 18) {
                return;
            }
            m();
        }
    }

    public boolean g() {
        return this.f36397c;
    }

    public final void h() {
        double d10 = 100.0d;
        double length = (((double) this.f36399e) * 100.0d) / ((double) this.f36400f.length);
        if (length < 0.0d) {
            d10 = 0.0d;
        } else if (length <= 100.0d) {
            d10 = length;
        }
        this.f36396b.g(d10);
    }

    public void i() {
        if (this.f36402h) {
            if (this.f36403i == 0) {
                this.f36402h = false;
                M(1);
                K();
                return;
            }
            return;
        }
        if (this.f36405k) {
            this.f36405k = false;
            a();
        } else {
            if (this.f36407m <= 0 || this.f36403i != 0 || this.f36410p) {
                return;
            }
            E();
        }
    }

    public void j() throws Throwable {
        if (this.f36409o) {
            this.f36409o = false;
            R();
        }
    }

    public final void k() {
        S();
    }

    public final void l() {
        M(4);
        d(2);
    }

    public final void m() {
        this.f36397c = false;
        this.f36396b.e();
    }

    public final void n(com.qualcomm.qti.libraries.vmupgrade.packet.a aVar) {
        byte[] bArrB = aVar.b();
        if (bArrB.length != 8) {
            O(new jg.b(2));
            return;
        }
        this.f36407m = jg.d.b(bArrB, 0, 4, false);
        int iB = jg.d.b(bArrB, 4, 4, false);
        int i10 = this.f36399e;
        if (iB <= 0 || iB + i10 >= this.f36400f.length) {
            iB = 0;
        }
        int i11 = i10 + iB;
        this.f36399e = i11;
        int i12 = this.f36407m;
        int i13 = i12 > 0 ? i12 : 0;
        this.f36407m = i13;
        int length = this.f36400f.length - i11;
        if (i13 >= length) {
            i13 = length;
        }
        this.f36407m = i13;
        if (!this.f36410p) {
            E();
        } else {
            while (this.f36407m > 0) {
                E();
            }
        }
    }

    public final void o(com.qualcomm.qti.libraries.vmupgrade.packet.a aVar) {
        byte[] bArrB = aVar.b();
        C(bArrB);
        int iA = kg.c.a(jg.d.d(bArrB, 0, 2, false));
        if (iA == 129) {
            d(4);
        } else if (iA == 33) {
            d(5);
        } else {
            O(new jg.b(3, iA));
        }
    }

    public final void p(com.qualcomm.qti.libraries.vmupgrade.packet.a aVar) {
        byte[] bArrB = aVar.b();
        if (bArrB.length < 3) {
            O(new jg.b(2));
            return;
        }
        jg.d.d(bArrB, 1, 2, false);
        if (bArrB[0] != 0) {
            if (bArrB[0] != 9) {
                O(new jg.b(2));
                return;
            }
            int i10 = this.f36398d;
            if (i10 < 5) {
                this.f36398d = i10 + 1;
                this.f36406l.postDelayed(new a(), 2000);
                return;
            } else {
                this.f36398d = 0;
                O(new jg.b(1));
                return;
            }
        }
        this.f36398d = 0;
        int i11 = this.f36403i;
        if (i11 == 1) {
            K();
            return;
        }
        if (i11 == 2) {
            d(1);
            return;
        }
        if (i11 == 3) {
            d(3);
        } else if (i11 != 4) {
            F();
        } else {
            d(2);
        }
    }

    public final void q(com.qualcomm.qti.libraries.vmupgrade.packet.a aVar) {
        byte[] bArrB = aVar.b();
        if (bArrB.length >= 6) {
            int iC = kg.b.c(bArrB[0]);
            jg.d.b(bArrB, 1, 4, false);
            byte b10 = bArrB[5];
            if (iC == 3) {
                M(iC);
            } else {
                this.f36403i = iC;
            }
        } else {
            this.f36403i = 0;
        }
        G();
    }

    public final void r() {
        M(2);
        d(1);
    }

    public void s() {
    }

    public void t() {
    }

    public void u(byte[] bArr) {
        try {
            com.qualcomm.qti.libraries.vmupgrade.packet.a aVar = new com.qualcomm.qti.libraries.vmupgrade.packet.a(bArr);
            if (!this.f36397c && aVar.d() != 8) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Received VMU packet while application is not upgrading anymore, opcode received: ");
                sb2.append(kg.a.b(aVar.d()));
                return;
            }
            if (this.f36408n) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Received ");
                sb3.append(kg.a.b(aVar.d()));
                sb3.append(": ");
                sb3.append(jg.d.g(aVar.b()));
            }
            f(aVar);
        } catch (VMUException e10) {
            O(new jg.b(e10));
        }
    }

    public final void v(com.qualcomm.qti.libraries.vmupgrade.packet.a aVar) {
        byte[] bArrA = aVar.a();
        if (bArrA.length != 2) {
            K();
        } else {
            this.f36406l.postDelayed(new b(), jg.d.c(bArrA, 0, 2, false));
        }
    }

    public final void w() {
        this.f36398d = 0;
        this.f36407m = 0;
        this.f36399e = 0;
    }

    public boolean x() throws Throwable {
        if (this.f36397c) {
            w();
            H();
        }
        return this.f36397c;
    }

    public final void y() {
        J(new com.qualcomm.qti.libraries.vmupgrade.packet.a(7), false);
    }

    public final void z(boolean z10) {
        J(new com.qualcomm.qti.libraries.vmupgrade.packet.a(16, new byte[]{!z10 ? 1 : 0}), false);
    }

    public c(@n0 d dVar, int i10) {
        this.f36395a = "UpgradeManager";
        this.f36397c = false;
        this.f36398d = 0;
        this.f36399e = 0;
        this.f36401g = 8;
        this.f36402h = false;
        this.f36405k = false;
        this.f36406l = new Handler();
        this.f36407m = 0;
        this.f36408n = false;
        this.f36409o = false;
        this.f36410p = false;
        this.f36396b = dVar;
        this.f36401g = i10 - 3;
    }
}
