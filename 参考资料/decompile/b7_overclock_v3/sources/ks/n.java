package ks;

import com.blankj.utilcode.util.i0;
import com.bumptech.glide.load.engine.GlideException;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.Vector;
import org.bouncycastle.crypto.s;

/* JADX INFO: loaded from: classes6.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f39228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Vector f39229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Vector f39230c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f39231d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f39232e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f39233f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f39234g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f39235h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f39236i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f39237j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f39238k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public s f39239l;

    public n(Vector vector, int i10, s sVar) {
        this.f39229b = vector;
        this.f39228a = i10;
        this.f39231d = null;
        this.f39236i = false;
        this.f39237j = false;
        this.f39238k = false;
        this.f39239l = sVar;
        this.f39233f = new byte[sVar.h()];
        this.f39232e = new byte[this.f39239l.h()];
    }

    public n(s sVar, byte[][] bArr, int[] iArr) {
        this.f39239l = sVar;
        this.f39228a = iArr[0];
        this.f39234g = iArr[1];
        this.f39235h = iArr[2];
        if (iArr[3] == 1) {
            this.f39237j = true;
        } else {
            this.f39237j = false;
        }
        if (iArr[4] == 1) {
            this.f39236i = true;
        } else {
            this.f39236i = false;
        }
        if (iArr[5] == 1) {
            this.f39238k = true;
        } else {
            this.f39238k = false;
        }
        this.f39230c = new Vector();
        for (int i10 = 0; i10 < this.f39234g; i10++) {
            this.f39230c.addElement(org.bouncycastle.util.j.g(iArr[i10 + 6]));
        }
        this.f39231d = bArr[0];
        this.f39232e = bArr[1];
        this.f39233f = bArr[2];
        this.f39229b = new Vector();
        for (int i11 = 0; i11 < this.f39234g; i11++) {
            this.f39229b.addElement(bArr[i11 + 3]);
        }
    }

    public void a() {
        this.f39236i = false;
        this.f39237j = false;
        this.f39231d = null;
        this.f39234g = 0;
        this.f39235h = -1;
    }

    public byte[] b() {
        return this.f39231d;
    }

    public int c() {
        return this.f39231d == null ? this.f39228a : this.f39235h;
    }

    public int d() {
        return this.f39231d == null ? this.f39228a : this.f39234g == 0 ? this.f39235h : Math.min(this.f39235h, ((Integer) this.f39230c.lastElement()).intValue());
    }

    public byte[] e() {
        return this.f39232e;
    }

    public byte[][] f() {
        byte[][] bArr = (byte[][]) Array.newInstance((Class<?>) byte.class, this.f39234g + 3, this.f39239l.h());
        bArr[0] = this.f39231d;
        bArr[1] = this.f39232e;
        bArr[2] = this.f39233f;
        for (int i10 = 0; i10 < this.f39234g; i10++) {
            bArr[i10 + 3] = (byte[]) this.f39229b.elementAt(i10);
        }
        return bArr;
    }

    public int[] g() {
        int i10 = this.f39234g;
        int[] iArr = new int[i10 + 6];
        iArr[0] = this.f39228a;
        iArr[1] = i10;
        iArr[2] = this.f39235h;
        if (this.f39237j) {
            iArr[3] = 1;
        } else {
            iArr[3] = 0;
        }
        if (this.f39236i) {
            iArr[4] = 1;
        } else {
            iArr[4] = 0;
        }
        if (this.f39238k) {
            iArr[5] = 1;
        } else {
            iArr[5] = 0;
        }
        for (int i11 = 0; i11 < this.f39234g; i11++) {
            iArr[i11 + 6] = ((Integer) this.f39230c.elementAt(i11)).intValue();
        }
        return iArr;
    }

    public Vector h() {
        return this.f39229b;
    }

    public void i() {
        if (!this.f39238k) {
            throw new IllegalStateException("Seed " + this.f39228a + " not initialized");
        }
        this.f39230c = new Vector();
        this.f39234g = 0;
        this.f39231d = null;
        this.f39235h = -1;
        this.f39236i = true;
        System.arraycopy(this.f39233f, 0, this.f39232e, 0, this.f39239l.h());
    }

    public void j(byte[] bArr) {
        System.arraycopy(bArr, 0, this.f39233f, 0, this.f39239l.h());
        this.f39238k = true;
    }

    public void k(byte[] bArr) {
        if (!this.f39236i) {
            i();
        }
        this.f39231d = bArr;
        this.f39235h = this.f39228a;
        this.f39237j = true;
    }

    public void l(ls.a aVar, byte[] bArr) {
        PrintStream printStream;
        String str;
        if (this.f39237j) {
            printStream = System.err;
            str = "No more update possible for treehash instance!";
        } else {
            if (this.f39236i) {
                byte[] bArr2 = new byte[this.f39239l.h()];
                aVar.c(this.f39232e);
                if (this.f39231d == null) {
                    this.f39231d = bArr;
                    this.f39235h = 0;
                } else {
                    int i10 = 0;
                    while (this.f39234g > 0 && i10 == ((Integer) this.f39230c.lastElement()).intValue()) {
                        int iH = this.f39239l.h() << 1;
                        byte[] bArr3 = new byte[iH];
                        System.arraycopy(this.f39229b.lastElement(), 0, bArr3, 0, this.f39239l.h());
                        Vector vector = this.f39229b;
                        vector.removeElementAt(vector.size() - 1);
                        Vector vector2 = this.f39230c;
                        vector2.removeElementAt(vector2.size() - 1);
                        System.arraycopy(bArr, 0, bArr3, this.f39239l.h(), this.f39239l.h());
                        this.f39239l.update(bArr3, 0, iH);
                        bArr = new byte[this.f39239l.h()];
                        this.f39239l.c(bArr, 0);
                        i10++;
                        this.f39234g--;
                    }
                    this.f39229b.addElement(bArr);
                    this.f39230c.addElement(org.bouncycastle.util.j.g(i10));
                    this.f39234g++;
                    if (((Integer) this.f39230c.lastElement()).intValue() == this.f39235h) {
                        int iH2 = this.f39239l.h() << 1;
                        byte[] bArr4 = new byte[iH2];
                        System.arraycopy(this.f39231d, 0, bArr4, 0, this.f39239l.h());
                        System.arraycopy(this.f39229b.lastElement(), 0, bArr4, this.f39239l.h(), this.f39239l.h());
                        Vector vector3 = this.f39229b;
                        vector3.removeElementAt(vector3.size() - 1);
                        Vector vector4 = this.f39230c;
                        vector4.removeElementAt(vector4.size() - 1);
                        this.f39239l.update(bArr4, 0, iH2);
                        byte[] bArr5 = new byte[this.f39239l.h()];
                        this.f39231d = bArr5;
                        this.f39239l.c(bArr5, 0);
                        this.f39235h++;
                        this.f39234g = 0;
                    }
                }
                if (this.f39235h == this.f39228a) {
                    this.f39237j = true;
                    return;
                }
                return;
            }
            printStream = System.err;
            str = "Treehash instance not initialized before update";
        }
        printStream.println(str);
    }

    public void m(ls.a aVar) {
        aVar.c(this.f39233f);
    }

    public boolean n() {
        return this.f39237j;
    }

    public boolean o() {
        return this.f39236i;
    }

    public String toString() {
        StringBuilder sb2;
        String string = "Treehash    : ";
        for (int i10 = 0; i10 < this.f39234g + 6; i10++) {
            string = string + g()[i10] + i0.f11861z;
        }
        for (int i11 = 0; i11 < this.f39234g + 3; i11++) {
            if (f()[i11] != null) {
                sb2 = new StringBuilder();
                sb2.append(string);
                sb2.append(new String(jt.h.h(f()[i11])));
                sb2.append(i0.f11861z);
            } else {
                sb2 = new StringBuilder();
                sb2.append(string);
                sb2.append("null ");
            }
            string = sb2.toString();
        }
        return string + GlideException.a.f12263d + this.f39239l.h();
    }
}
