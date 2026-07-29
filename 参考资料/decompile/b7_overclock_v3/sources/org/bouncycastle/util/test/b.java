package org.bouncycastle.util.test;

import java.io.PrintStream;
import java.util.Enumeration;
import java.util.Vector;

/* JADX INFO: loaded from: classes6.dex */
public abstract class b implements d {
    public static void q(d dVar) {
        r(dVar, System.out);
    }

    public static void r(d dVar, PrintStream printStream) {
        f fVarA = dVar.a();
        if (fVarA.a() != null) {
            fVarA.a().printStackTrace(printStream);
        }
        printStream.println(fVarA);
    }

    public static void s(d[] dVarArr) {
        t(dVarArr, System.out);
    }

    public static void t(d[] dVarArr, PrintStream printStream) {
        Vector vector = new Vector();
        for (int i10 = 0; i10 != dVarArr.length; i10++) {
            f fVarA = dVarArr[i10].a();
            if (!fVarA.b()) {
                vector.addElement(fVarA);
            }
            if (fVarA.a() != null) {
                fVarA.a().printStackTrace(printStream);
            }
            printStream.println(fVarA);
        }
        printStream.println("-----");
        if (vector.isEmpty()) {
            printStream.println("All tests successful.");
            return;
        }
        printStream.println("Completed with " + vector.size() + " FAILURES:");
        Enumeration enumerationElements = vector.elements();
        while (enumerationElements.hasMoreElements()) {
            System.out.println("=>  " + ((f) enumerationElements.nextElement()));
        }
    }

    @Override // org.bouncycastle.util.test.d
    public f a() {
        try {
            p();
            return u();
        } catch (TestFailedException e10) {
            return e10.a();
        } catch (Exception e11) {
            return c.e(this, "Exception: " + e11, e11);
        }
    }

    public boolean b(byte[] bArr, int i10, int i11, byte[] bArr2, int i12, int i13) {
        return org.bouncycastle.util.a.f(bArr, i10, i11, bArr2, i12, i13);
    }

    public boolean c(byte[] bArr, byte[] bArr2) {
        return org.bouncycastle.util.a.g(bArr, bArr2);
    }

    public boolean d(byte[][] bArr, byte[][] bArr2) {
        if (bArr == null && bArr2 == null) {
            return true;
        }
        if (bArr == null || bArr2 == null || bArr.length != bArr2.length) {
            return false;
        }
        for (int i10 = 0; i10 < bArr.length; i10++) {
            if (!c(bArr[i10], bArr2[i10])) {
                return false;
            }
        }
        return true;
    }

    public void e(String str) {
        throw new TestFailedException(c.c(this, str));
    }

    public void f(String str, Object obj, Object obj2) {
        throw new TestFailedException(c.d(this, str, obj, obj2));
    }

    public void g(String str, Throwable th2) {
        throw new TestFailedException(c.e(this, str, th2));
    }

    @Override // org.bouncycastle.util.test.d
    public abstract String getName();

    public void h(int i10, int i11) {
        if (i10 != i11) {
            throw new TestFailedException(c.c(this, "no message"));
        }
    }

    public void i(long j10, long j11) {
        if (j10 != j11) {
            throw new TestFailedException(c.c(this, "no message"));
        }
    }

    public void j(Object obj, Object obj2) {
        if (!obj.equals(obj2)) {
            throw new TestFailedException(c.c(this, "no message"));
        }
    }

    public void k(String str, long j10, long j11) {
        if (j10 != j11) {
            throw new TestFailedException(c.c(this, str));
        }
    }

    public void l(String str, Object obj, Object obj2) {
        if (obj == null && obj2 == null) {
            return;
        }
        if (obj == null) {
            throw new TestFailedException(c.c(this, str));
        }
        if (obj2 == null) {
            throw new TestFailedException(c.c(this, str));
        }
        if (!obj.equals(obj2)) {
            throw new TestFailedException(c.c(this, str));
        }
    }

    public void m(String str, boolean z10, boolean z11) {
        if (z10 != z11) {
            throw new TestFailedException(c.c(this, str));
        }
    }

    public void n(String str, boolean z10) {
        if (!z10) {
            throw new TestFailedException(c.c(this, str));
        }
    }

    public void o(boolean z10) {
        if (!z10) {
            throw new TestFailedException(c.c(this, "no message"));
        }
    }

    public abstract void p() throws Exception;

    public final f u() {
        return c.g(this, "Okay");
    }
}
