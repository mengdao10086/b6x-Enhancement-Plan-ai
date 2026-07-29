package wn;

import com.bumptech.glide.load.engine.GlideException;
import gm.c0;
import gm.d;
import gm.d0;
import gm.e0;
import gm.e1;
import gm.f;
import gm.f0;
import gm.h;
import gm.h0;
import gm.i1;
import gm.j2;
import gm.k;
import gm.l;
import gm.l0;
import gm.l1;
import gm.l2;
import gm.n0;
import gm.n1;
import gm.n2;
import gm.o;
import gm.q;
import gm.q0;
import gm.r;
import gm.r0;
import gm.t;
import gm.u;
import gm.u1;
import gm.u2;
import gm.v;
import gm.v0;
import gm.w0;
import gm.x;
import gm.x0;
import gm.y;
import gm.z;
import java.math.BigInteger;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f54751a = "    ";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f54752b = 32;

    public static void a(String str, boolean z10, c0 c0Var, StringBuffer stringBuffer) {
        StringBuilder sb2;
        String strD;
        BigInteger bigIntegerJ;
        StringBuilder sb3;
        String str2;
        String strE;
        String strL;
        StringBuilder sb4;
        int length;
        c0 c0VarB;
        String strE2 = Strings.e();
        if (!(c0Var instanceof u)) {
            int i10 = 0;
            if (c0Var instanceof f0) {
                stringBuffer.append(str);
                stringBuffer.append(c0Var instanceof i1 ? "BER Sequence" : c0Var instanceof j2 ? "DER Sequence" : "Sequence");
                stringBuffer.append(strE2);
                f0 f0Var = (f0) c0Var;
                String str3 = str + f54751a;
                int size = f0Var.size();
                while (i10 < size) {
                    a(str3, z10, f0Var.K(i10).b(), stringBuffer);
                    i10++;
                }
                return;
            }
            if (c0Var instanceof h0) {
                stringBuffer.append(str);
                stringBuffer.append(c0Var instanceof l1 ? "BER Set" : c0Var instanceof l2 ? "DER Set" : "Set");
                stringBuffer.append(strE2);
                h0 h0Var = (h0) c0Var;
                String str4 = str + f54751a;
                int size2 = h0Var.size();
                while (i10 < size2) {
                    a(str4, z10, h0Var.J(i10).b(), stringBuffer);
                    i10++;
                }
                return;
            }
            if (c0Var instanceof gm.a) {
                c0VarB = ((gm.a) c0Var).N();
            } else if (c0Var instanceof n0) {
                stringBuffer.append(str);
                stringBuffer.append(c0Var instanceof n1 ? "BER Tagged " : c0Var instanceof n2 ? "DER Tagged " : "Tagged ");
                n0 n0Var = (n0) c0Var;
                stringBuffer.append(v0.m(n0Var));
                if (!n0Var.W()) {
                    stringBuffer.append(" IMPLICIT ");
                }
                stringBuffer.append(strE2);
                str = str + f54751a;
                c0VarB = n0Var.L().b();
            } else {
                if (!(c0Var instanceof z)) {
                    if (c0Var instanceof y) {
                        sb2 = new StringBuilder();
                        sb2.append(str);
                        sb2.append("ObjectIdentifier(");
                        strL = ((y) c0Var).L();
                    } else {
                        if (!(c0Var instanceof e0)) {
                            if (c0Var instanceof f) {
                                sb2 = new StringBuilder();
                                sb2.append(str);
                                sb2.append("Boolean(");
                                sb2.append(((f) c0Var).L());
                            } else {
                                if (c0Var instanceof t) {
                                    sb2 = new StringBuilder();
                                    sb2.append(str);
                                    sb2.append("Integer(");
                                    bigIntegerJ = ((t) c0Var).K();
                                } else {
                                    if (!(c0Var instanceof d)) {
                                        if (c0Var instanceof r) {
                                            sb2 = new StringBuilder();
                                            sb2.append(str);
                                            sb2.append("IA5String(");
                                            strD = ((r) c0Var).d();
                                        } else if (c0Var instanceof r0) {
                                            sb2 = new StringBuilder();
                                            sb2.append(str);
                                            sb2.append("UTF8String(");
                                            strD = ((r0) c0Var).d();
                                        } else if (c0Var instanceof v) {
                                            sb2 = new StringBuilder();
                                            sb2.append(str);
                                            sb2.append("NumericString(");
                                            strD = ((v) c0Var).d();
                                        } else if (c0Var instanceof d0) {
                                            sb2 = new StringBuilder();
                                            sb2.append(str);
                                            sb2.append("PrintableString(");
                                            strD = ((d0) c0Var).d();
                                        } else if (c0Var instanceof x0) {
                                            sb2 = new StringBuilder();
                                            sb2.append(str);
                                            sb2.append("VisibleString(");
                                            strD = ((x0) c0Var).d();
                                        } else if (c0Var instanceof gm.c) {
                                            sb2 = new StringBuilder();
                                            sb2.append(str);
                                            sb2.append("BMPString(");
                                            strD = ((gm.c) c0Var).d();
                                        } else if (c0Var instanceof l0) {
                                            sb2 = new StringBuilder();
                                            sb2.append(str);
                                            sb2.append("T61String(");
                                            strD = ((l0) c0Var).d();
                                        } else if (c0Var instanceof q) {
                                            sb2 = new StringBuilder();
                                            sb2.append(str);
                                            sb2.append("GraphicString(");
                                            strD = ((q) c0Var).d();
                                        } else if (c0Var instanceof w0) {
                                            sb2 = new StringBuilder();
                                            sb2.append(str);
                                            sb2.append("VideotexString(");
                                            strD = ((w0) c0Var).d();
                                        } else if (c0Var instanceof q0) {
                                            sb2 = new StringBuilder();
                                            sb2.append(str);
                                            sb2.append("UTCTime(");
                                            strD = ((q0) c0Var).M();
                                        } else if (c0Var instanceof o) {
                                            sb2 = new StringBuilder();
                                            sb2.append(str);
                                            sb2.append("GeneralizedTime(");
                                            strD = ((o) c0Var).N();
                                        } else if (c0Var instanceof k) {
                                            sb2 = new StringBuilder();
                                            sb2.append(str);
                                            sb2.append("DER Enumerated(");
                                            bigIntegerJ = ((k) c0Var).J();
                                        } else {
                                            if (!(c0Var instanceof x)) {
                                                if (!(c0Var instanceof l)) {
                                                    sb2 = new StringBuilder();
                                                    sb2.append(str);
                                                    sb2.append(c0Var.toString());
                                                    sb2.append(strE2);
                                                    strE = sb2.toString();
                                                    stringBuffer.append(strE);
                                                    return;
                                                }
                                                l lVar = (l) c0Var;
                                                stringBuffer.append(str + "External " + strE2);
                                                StringBuilder sb5 = new StringBuilder();
                                                sb5.append(str);
                                                sb5.append(f54751a);
                                                String string = sb5.toString();
                                                if (lVar.K() != null) {
                                                    stringBuffer.append(string + "Direct Reference: " + lVar.K().L() + strE2);
                                                }
                                                if (lVar.O() != null) {
                                                    stringBuffer.append(string + "Indirect Reference: " + lVar.O().toString() + strE2);
                                                }
                                                if (lVar.J() != null) {
                                                    a(string, z10, lVar.J(), stringBuffer);
                                                }
                                                stringBuffer.append(string + "Encoding: " + lVar.L() + strE2);
                                                a(string, z10, lVar.M(), stringBuffer);
                                                return;
                                            }
                                            sb2 = new StringBuilder();
                                            sb2.append(str);
                                            sb2.append("ObjectDescriptor(");
                                            strD = ((x) c0Var).H().d();
                                        }
                                        sb2.append(strD);
                                        sb2.append(") ");
                                        sb2.append(strE2);
                                        strE = sb2.toString();
                                        stringBuffer.append(strE);
                                        return;
                                    }
                                    d dVar = (d) c0Var;
                                    byte[] bArrH = dVar.H();
                                    int iM = dVar.m();
                                    if (dVar instanceof u1) {
                                        sb3 = new StringBuilder();
                                        sb3.append(str);
                                        str2 = "DER Bit String[";
                                    } else if (dVar instanceof u2) {
                                        sb3 = new StringBuilder();
                                        sb3.append(str);
                                        str2 = "DL Bit String[";
                                    } else {
                                        sb3 = new StringBuilder();
                                        sb3.append(str);
                                        str2 = "BER Bit String[";
                                    }
                                    sb3.append(str2);
                                    sb3.append(bArrH.length);
                                    sb3.append(", ");
                                    sb3.append(iM);
                                    sb3.append("] ");
                                    stringBuffer.append(sb3.toString());
                                    if (z10) {
                                        strE = e(str, bArrH);
                                        stringBuffer.append(strE);
                                        return;
                                    }
                                }
                                sb2.append(bigIntegerJ);
                            }
                            sb2.append(ee.a.f26979d);
                            sb2.append(strE2);
                            strE = sb2.toString();
                            stringBuffer.append(strE);
                            return;
                        }
                        sb2 = new StringBuilder();
                        sb2.append(str);
                        sb2.append("RelativeOID(");
                        strL = ((e0) c0Var).L();
                    }
                    sb2.append(strL);
                    sb2.append(ee.a.f26979d);
                    sb2.append(strE2);
                    strE = sb2.toString();
                    stringBuffer.append(strE);
                    return;
                }
                z zVar = (z) c0Var;
                if (c0Var instanceof e1) {
                    sb4 = new StringBuilder();
                    sb4.append(str);
                    sb4.append("BER Constructed Octet String[");
                    length = zVar.J().length;
                } else {
                    sb4 = new StringBuilder();
                    sb4.append(str);
                    sb4.append("DER Octet String[");
                    length = zVar.J().length;
                }
                sb4.append(length);
                sb4.append("] ");
                stringBuffer.append(sb4.toString());
                if (z10) {
                    strE = e(str, zVar.J());
                    stringBuffer.append(strE);
                    return;
                }
            }
            a(str, z10, c0VarB, stringBuffer);
            return;
        }
        stringBuffer.append(str);
        stringBuffer.append("NULL");
        stringBuffer.append(strE2);
    }

    public static String b(byte[] bArr, int i10, int i11) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i12 = i10; i12 != i10 + i11; i12++) {
            if (bArr[i12] >= 32 && bArr[i12] <= 126) {
                stringBuffer.append((char) bArr[i12]);
            }
        }
        return stringBuffer.toString();
    }

    public static String c(Object obj) {
        return d(obj, false);
    }

    public static String d(Object obj, boolean z10) {
        c0 c0VarB;
        if (obj instanceof c0) {
            c0VarB = (c0) obj;
        } else {
            if (!(obj instanceof h)) {
                return "unknown object type " + obj.toString();
            }
            c0VarB = ((h) obj).b();
        }
        StringBuffer stringBuffer = new StringBuffer();
        a("", z10, c0VarB, stringBuffer);
        return stringBuffer.toString();
    }

    public static String e(String str, byte[] bArr) {
        String strB;
        String strE = Strings.e();
        StringBuffer stringBuffer = new StringBuffer();
        String str2 = str + f54751a;
        stringBuffer.append(strE);
        for (int i10 = 0; i10 < bArr.length; i10 += 32) {
            int length = bArr.length - i10;
            stringBuffer.append(str2);
            if (length > 32) {
                stringBuffer.append(Strings.c(jt.h.i(bArr, i10, 32)));
                stringBuffer.append(f54751a);
                strB = b(bArr, i10, 32);
            } else {
                stringBuffer.append(Strings.c(jt.h.i(bArr, i10, bArr.length - i10)));
                for (int length2 = bArr.length - i10; length2 != 32; length2++) {
                    stringBuffer.append(GlideException.a.f12263d);
                }
                stringBuffer.append(f54751a);
                strB = b(bArr, i10, bArr.length - i10);
            }
            stringBuffer.append(strB);
            stringBuffer.append(strE);
        }
        return stringBuffer.toString();
    }
}
