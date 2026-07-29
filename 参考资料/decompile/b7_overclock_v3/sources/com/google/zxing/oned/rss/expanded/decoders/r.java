package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import kotlin.text.y;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

/* JADX INFO: loaded from: classes7.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final af.a f21504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CurrentParsingState f21505b = new CurrentParsingState();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StringBuilder f21506c = new StringBuilder();

    public r(af.a aVar) {
        this.f21504a = aVar;
    }

    public static int g(af.a aVar, int i10, int i11) {
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            if (aVar.h(i10 + i13)) {
                i12 |= 1 << ((i11 - i13) - 1);
            }
        }
        return i12;
    }

    public String a(StringBuilder sb2, int i10) throws NotFoundException, FormatException {
        String str = null;
        while (true) {
            n nVarC = c(i10, str);
            String strA = q.a(nVarC.b());
            if (strA != null) {
                sb2.append(strA);
            }
            String strValueOf = nVarC.d() ? String.valueOf(nVarC.c()) : null;
            if (i10 == nVarC.a()) {
                return sb2.toString();
            }
            i10 = nVarC.a();
            str = strValueOf;
        }
    }

    public final m b(int i10) {
        char c10;
        int iF = f(i10, 5);
        if (iF == 15) {
            return new m(i10 + 5, '$');
        }
        if (iF >= 5 && iF < 15) {
            return new m(i10 + 5, (char) ((iF + 48) - 5));
        }
        int iF2 = f(i10, 6);
        if (iF2 >= 32 && iF2 < 58) {
            return new m(i10 + 6, (char) (iF2 + 33));
        }
        switch (iF2) {
            case 58:
                c10 = '*';
                break;
            case 59:
                c10 = ',';
                break;
            case 60:
                c10 = '-';
                break;
            case 61:
                c10 = '.';
                break;
            case 62:
                c10 = zc.f.f58380j;
                break;
            default:
                throw new IllegalStateException("Decoding invalid alphanumeric value: " + iF2);
        }
        return new m(i10 + 6, c10);
    }

    public n c(int i10, String str) throws FormatException {
        this.f21506c.setLength(0);
        if (str != null) {
            this.f21506c.append(str);
        }
        this.f21505b.i(i10);
        n nVarO = o();
        return (nVarO == null || !nVarO.d()) ? new n(this.f21505b.a(), this.f21506c.toString()) : new n(this.f21505b.a(), this.f21506c.toString(), nVarO.c());
    }

    public final m d(int i10) throws FormatException {
        char c10;
        int iF = f(i10, 5);
        if (iF == 15) {
            return new m(i10 + 5, '$');
        }
        if (iF >= 5 && iF < 15) {
            return new m(i10 + 5, (char) ((iF + 48) - 5));
        }
        int iF2 = f(i10, 7);
        if (iF2 >= 64 && iF2 < 90) {
            return new m(i10 + 7, (char) (iF2 + 1));
        }
        if (iF2 >= 90 && iF2 < 116) {
            return new m(i10 + 7, (char) (iF2 + 7));
        }
        switch (f(i10, 8)) {
            case 232:
                c10 = PublicSuffixDatabase.f43873i;
                break;
            case 233:
                c10 = y.f38188b;
                break;
            case 234:
                c10 = '%';
                break;
            case 235:
                c10 = '&';
                break;
            case 236:
                c10 = '\'';
                break;
            case 237:
                c10 = '(';
                break;
            case mb.e.f41061s1 /* 238 */:
                c10 = ')';
                break;
            case 239:
                c10 = '*';
                break;
            case 240:
                c10 = '+';
                break;
            case 241:
                c10 = ',';
                break;
            case m9.m.f40854e0 /* 242 */:
                c10 = '-';
                break;
            case 243:
                c10 = '.';
                break;
            case 244:
                c10 = zc.f.f58380j;
                break;
            case 245:
                c10 = ':';
                break;
            case 246:
                c10 = zc.f.f58382l;
                break;
            case 247:
                c10 = '<';
                break;
            case 248:
                c10 = '=';
                break;
            case a4.d.f205j /* 249 */:
                c10 = '>';
                break;
            case 250:
                c10 = '?';
                break;
            case mb.e.f41067u1 /* 251 */:
                c10 = '_';
                break;
            case 252:
                c10 = zc.f.f58383m;
                break;
            default:
                throw FormatException.b();
        }
        return new m(i10 + 8, c10);
    }

    public final o e(int i10) throws FormatException {
        int i11 = i10 + 7;
        if (i11 > this.f21504a.l()) {
            int iF = f(i10, 4);
            return iF == 0 ? new o(this.f21504a.l(), 10, 10) : new o(this.f21504a.l(), iF - 1, 10);
        }
        int iF2 = f(i10, 7) - 8;
        return new o(i11, iF2 / 11, iF2 % 11);
    }

    public int f(int i10, int i11) {
        return g(this.f21504a, i10, i11);
    }

    public final boolean h(int i10) {
        int i11 = i10 + 3;
        if (i11 > this.f21504a.l()) {
            return false;
        }
        while (i10 < i11) {
            if (this.f21504a.h(i10)) {
                return false;
            }
            i10++;
        }
        return true;
    }

    public final boolean i(int i10) {
        int i11;
        if (i10 + 1 > this.f21504a.l()) {
            return false;
        }
        for (int i12 = 0; i12 < 5 && (i11 = i12 + i10) < this.f21504a.l(); i12++) {
            if (i12 == 2) {
                if (!this.f21504a.h(i10 + 2)) {
                    return false;
                }
            } else if (this.f21504a.h(i11)) {
                return false;
            }
        }
        return true;
    }

    public final boolean j(int i10) {
        int i11;
        if (i10 + 1 > this.f21504a.l()) {
            return false;
        }
        for (int i12 = 0; i12 < 4 && (i11 = i12 + i10) < this.f21504a.l(); i12++) {
            if (this.f21504a.h(i11)) {
                return false;
            }
        }
        return true;
    }

    public final boolean k(int i10) {
        int iF;
        if (i10 + 5 > this.f21504a.l()) {
            return false;
        }
        int iF2 = f(i10, 5);
        if (iF2 < 5 || iF2 >= 16) {
            return i10 + 6 <= this.f21504a.l() && (iF = f(i10, 6)) >= 16 && iF < 63;
        }
        return true;
    }

    public final boolean l(int i10) {
        int iF;
        if (i10 + 5 > this.f21504a.l()) {
            return false;
        }
        int iF2 = f(i10, 5);
        if (iF2 >= 5 && iF2 < 16) {
            return true;
        }
        if (i10 + 7 > this.f21504a.l()) {
            return false;
        }
        int iF3 = f(i10, 7);
        if (iF3 < 64 || iF3 >= 116) {
            return i10 + 8 <= this.f21504a.l() && (iF = f(i10, 8)) >= 232 && iF < 253;
        }
        return true;
    }

    public final boolean m(int i10) {
        if (i10 + 7 > this.f21504a.l()) {
            return i10 + 4 <= this.f21504a.l();
        }
        int i11 = i10;
        while (true) {
            int i12 = i10 + 3;
            if (i11 >= i12) {
                return this.f21504a.h(i12);
            }
            if (this.f21504a.h(i11)) {
                return true;
            }
            i11++;
        }
    }

    public final l n() {
        while (k(this.f21505b.a())) {
            m mVarB = b(this.f21505b.a());
            this.f21505b.i(mVarB.a());
            if (mVarB.c()) {
                return new l(new n(this.f21505b.a(), this.f21506c.toString()), true);
            }
            this.f21506c.append(mVarB.b());
        }
        if (h(this.f21505b.a())) {
            this.f21505b.b(3);
            this.f21505b.h();
        } else if (i(this.f21505b.a())) {
            if (this.f21505b.a() + 5 < this.f21504a.l()) {
                this.f21505b.b(5);
            } else {
                this.f21505b.i(this.f21504a.l());
            }
            this.f21505b.g();
        }
        return new l();
    }

    public final n o() throws FormatException {
        l lVarQ;
        boolean zB;
        do {
            int iA = this.f21505b.a();
            if (this.f21505b.c()) {
                lVarQ = n();
                zB = lVarQ.b();
            } else if (this.f21505b.d()) {
                lVarQ = p();
                zB = lVarQ.b();
            } else {
                lVarQ = q();
                zB = lVarQ.b();
            }
            if (!(iA != this.f21505b.a()) && !zB) {
                break;
            }
        } while (!zB);
        return lVarQ.a();
    }

    public final l p() throws FormatException {
        while (l(this.f21505b.a())) {
            m mVarD = d(this.f21505b.a());
            this.f21505b.i(mVarD.a());
            if (mVarD.c()) {
                return new l(new n(this.f21505b.a(), this.f21506c.toString()), true);
            }
            this.f21506c.append(mVarD.b());
        }
        if (h(this.f21505b.a())) {
            this.f21505b.b(3);
            this.f21505b.h();
        } else if (i(this.f21505b.a())) {
            if (this.f21505b.a() + 5 < this.f21504a.l()) {
                this.f21505b.b(5);
            } else {
                this.f21505b.i(this.f21504a.l());
            }
            this.f21505b.f();
        }
        return new l();
    }

    public final l q() throws FormatException {
        while (m(this.f21505b.a())) {
            o oVarE = e(this.f21505b.a());
            this.f21505b.i(oVarE.a());
            if (oVarE.e()) {
                return new l(oVarE.f() ? new n(this.f21505b.a(), this.f21506c.toString()) : new n(this.f21505b.a(), this.f21506c.toString(), oVarE.c()), true);
            }
            this.f21506c.append(oVarE.b());
            if (oVarE.f()) {
                return new l(new n(this.f21505b.a(), this.f21506c.toString()), true);
            }
            this.f21506c.append(oVarE.c());
        }
        if (j(this.f21505b.a())) {
            this.f21505b.f();
            this.f21505b.b(4);
        }
        return new l();
    }
}
