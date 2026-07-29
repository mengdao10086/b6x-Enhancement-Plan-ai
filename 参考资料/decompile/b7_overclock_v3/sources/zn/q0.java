package zn;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.asn1.x509.NameConstraintValidatorException;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes5.dex */
public class q0 implements l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Set f58906a = new HashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Set f58907b = new HashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Set f58908c = new HashSet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Set f58909d = new HashSet();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Set f58910e = new HashSet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Set f58911f = new HashSet();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Set f58912g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Set f58913h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Set f58914i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Set f58915j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Set f58916k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Set f58917l;

    public static byte[] Q(byte[] bArr, byte[] bArr2) {
        for (int i10 = 0; i10 < bArr.length; i10++) {
            if ((bArr[i10] & 65535) > (65535 & bArr2[i10])) {
                return bArr;
            }
        }
        return bArr2;
    }

    public static byte[] R(byte[] bArr, byte[] bArr2) {
        for (int i10 = 0; i10 < bArr.length; i10++) {
            if ((bArr[i10] & 65535) < (65535 & bArr2[i10])) {
                return bArr;
            }
        }
        return bArr2;
    }

    public static byte[] T(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length];
        for (int i10 = 0; i10 < bArr.length; i10++) {
            bArr3[i10] = (byte) (bArr[i10] | bArr2[i10]);
        }
        return bArr3;
    }

    public static boolean h0(gm.f0 f0Var, gm.f0 f0Var2) {
        if (f0Var2.size() < 1 || f0Var2.size() > f0Var.size()) {
            return false;
        }
        xn.c cVarA = xn.c.A(f0Var2.K(0));
        int i10 = 0;
        int i11 = 0;
        while (true) {
            if (i10 >= f0Var.size()) {
                i10 = i11;
                break;
            }
            if (yn.d.k(cVarA, xn.c.A(f0Var.K(i10)))) {
                break;
            }
            i11 = i10;
            i10++;
        }
        if (f0Var2.size() > f0Var.size() - i10) {
            return false;
        }
        for (int i12 = 0; i12 < f0Var2.size(); i12++) {
            xn.c cVarA2 = xn.c.A(f0Var2.K(i12));
            xn.c cVarA3 = xn.c.A(f0Var.K(i10 + i12));
            if (cVarA2.size() != cVarA3.size() || !cVarA2.z().y().C(cVarA3.z().y())) {
                return false;
            }
            if (cVarA2.size() == 1 && cVarA2.z().y().C(yn.e.G)) {
                if (!cVarA3.z().z().toString().startsWith(cVarA2.z().z().toString())) {
                    return false;
                }
            } else if (!yn.d.k(cVarA2, cVarA3)) {
                return false;
            }
        }
        return true;
    }

    public static int w(byte[] bArr, byte[] bArr2) {
        if (org.bouncycastle.util.a.g(bArr, bArr2)) {
            return 0;
        }
        return org.bouncycastle.util.a.g(Q(bArr, bArr2), bArr) ? 1 : -1;
    }

    public static String z(String str) {
        String strSubstring = str.substring(str.indexOf(58) + 1);
        if (strSubstring.indexOf("//") != -1) {
            strSubstring = strSubstring.substring(strSubstring.indexOf("//") + 2);
        }
        if (strSubstring.lastIndexOf(58) != -1) {
            strSubstring = strSubstring.substring(0, strSubstring.lastIndexOf(58));
        }
        String strSubstring2 = strSubstring.substring(strSubstring.indexOf(58) + 1);
        String strSubstring3 = strSubstring2.substring(strSubstring2.indexOf(64) + 1);
        return strSubstring3.indexOf(47) != -1 ? strSubstring3.substring(0, strSubstring3.indexOf(47)) : strSubstring3;
    }

    public final byte[][] A(byte[] bArr, byte[] bArr2) {
        int length = bArr.length / 2;
        byte[] bArr3 = new byte[length];
        byte[] bArr4 = new byte[length];
        System.arraycopy(bArr, 0, bArr3, 0, length);
        System.arraycopy(bArr, length, bArr4, 0, length);
        byte[] bArr5 = new byte[length];
        byte[] bArr6 = new byte[length];
        System.arraycopy(bArr2, 0, bArr5, 0, length);
        System.arraycopy(bArr2, length, bArr6, 0, length);
        return new byte[][]{bArr3, bArr4, bArr5, bArr6};
    }

    public final String B(b0 b0Var) {
        return gm.r.I(b0Var.A()).d();
    }

    public final int C(Collection collection) {
        int iS0 = 0;
        if (collection == null) {
            return 0;
        }
        for (Object obj : collection) {
            iS0 += obj instanceof byte[] ? org.bouncycastle.util.a.s0((byte[]) obj) : obj.hashCode();
        }
        return iS0;
    }

    public final Set D(Set set, Set set2) {
        HashSet hashSet = new HashSet();
        Iterator it2 = set2.iterator();
        while (it2.hasNext()) {
            gm.f0 f0VarJ = gm.f0.J(((e0) it2.next()).x().A().b());
            if (set != null) {
                Iterator it3 = set.iterator();
                while (it3.hasNext()) {
                    gm.f0 f0Var = (gm.f0) it3.next();
                    if (h0(f0VarJ, f0Var)) {
                        hashSet.add(f0VarJ);
                    } else if (h0(f0Var, f0VarJ)) {
                        hashSet.add(f0Var);
                    }
                }
            } else if (f0VarJ != null) {
                hashSet.add(f0VarJ);
            }
        }
        return hashSet;
    }

    public final Set E(Set set, Set set2) {
        HashSet hashSet = new HashSet();
        Iterator it2 = set2.iterator();
        while (it2.hasNext()) {
            String strB = B(((e0) it2.next()).x());
            if (set != null) {
                Iterator it3 = set.iterator();
                while (it3.hasNext()) {
                    String str = (String) it3.next();
                    if (i0(str, strB)) {
                        hashSet.add(str);
                    } else if (i0(strB, str)) {
                        hashSet.add(strB);
                    }
                }
            } else if (strB != null) {
                hashSet.add(strB);
            }
        }
        return hashSet;
    }

    public final Set F(Set set, Set set2) {
        HashSet hashSet = new HashSet();
        Iterator it2 = set2.iterator();
        while (it2.hasNext()) {
            String strB = B(((e0) it2.next()).x());
            if (set != null) {
                Iterator it3 = set.iterator();
                while (it3.hasNext()) {
                    G(strB, (String) it3.next(), hashSet);
                }
            } else if (strB != null) {
                hashSet.add(strB);
            }
        }
        return hashSet;
    }

    public final void G(String str, String str2, Set set) {
        if (str.indexOf(64) != -1) {
            String strSubstring = str.substring(str.indexOf(64) + 1);
            if (str2.indexOf(64) != -1) {
                if (!str.equalsIgnoreCase(str2)) {
                    return;
                }
            } else if (str2.startsWith(j3.b.f36044h)) {
                if (!i0(strSubstring, str2)) {
                    return;
                }
            } else if (!strSubstring.equalsIgnoreCase(str2)) {
                return;
            }
        } else {
            if (str.startsWith(j3.b.f36044h)) {
                if (str2.indexOf(64) != -1) {
                    if (!i0(str2.substring(str.indexOf(64) + 1), str)) {
                        return;
                    }
                } else if (str2.startsWith(j3.b.f36044h)) {
                    if (!i0(str, str2) && !str.equalsIgnoreCase(str2)) {
                        if (!i0(str2, str)) {
                            return;
                        }
                    }
                } else if (!i0(str2, str)) {
                    return;
                }
                set.add(str2);
                return;
            }
            if (str2.indexOf(64) != -1) {
                if (!str2.substring(str2.indexOf(64) + 1).equalsIgnoreCase(str)) {
                    return;
                }
                set.add(str2);
                return;
            } else if (str2.startsWith(j3.b.f36044h)) {
                if (!i0(str, str2)) {
                    return;
                }
            } else if (!str.equalsIgnoreCase(str2)) {
                return;
            }
        }
        set.add(str);
    }

    public final Set H(Set set, Set set2) {
        HashSet hashSet = new HashSet();
        Iterator it2 = set2.iterator();
        while (it2.hasNext()) {
            byte[] bArrJ = gm.z.I(((e0) it2.next()).x().A()).J();
            if (set != null) {
                Iterator it3 = set.iterator();
                while (it3.hasNext()) {
                    hashSet.addAll(I((byte[]) it3.next(), bArrJ));
                }
            } else if (bArrJ != null) {
                hashSet.add(bArrJ);
            }
        }
        return hashSet;
    }

    public final Set I(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return Collections.EMPTY_SET;
        }
        byte[][] bArrA = A(bArr, bArr2);
        byte[] bArr3 = bArrA[0];
        byte[] bArr4 = bArrA[1];
        byte[] bArr5 = bArrA[2];
        byte[] bArr6 = bArrA[3];
        byte[][] bArrS = S(bArr3, bArr4, bArr5, bArr6);
        return w(Q(bArrS[0], bArrS[2]), R(bArrS[1], bArrS[3])) == 1 ? Collections.EMPTY_SET : Collections.singleton(N(T(bArrS[0], bArrS[2]), T(bArr4, bArr6)));
    }

    public final Set J(Set set, Set set2) {
        HashSet hashSet = new HashSet();
        Iterator it2 = set2.iterator();
        while (it2.hasNext()) {
            p0 p0VarX = p0.x(((e0) it2.next()).x().A());
            if (set != null) {
                Iterator it3 = set.iterator();
                while (it3.hasNext()) {
                    K(p0VarX, p0.x(it3.next()), hashSet);
                }
            } else if (p0VarX != null) {
                hashSet.add(p0VarX);
            }
        }
        return hashSet;
    }

    public final void K(p0 p0Var, p0 p0Var2, Set set) {
        if (p0Var.equals(p0Var2)) {
            set.add(p0Var);
        }
    }

    public final Set L(Set set, Set set2) {
        HashSet hashSet = new HashSet();
        Iterator it2 = set2.iterator();
        while (it2.hasNext()) {
            String strB = B(((e0) it2.next()).x());
            if (set != null) {
                Iterator it3 = set.iterator();
                while (it3.hasNext()) {
                    M((String) it3.next(), strB, hashSet);
                }
            } else if (strB != null) {
                hashSet.add(strB);
            }
        }
        return hashSet;
    }

    public final void M(String str, String str2, Set set) {
        if (str.indexOf(64) != -1) {
            String strSubstring = str.substring(str.indexOf(64) + 1);
            if (str2.indexOf(64) != -1) {
                if (!str.equalsIgnoreCase(str2)) {
                    return;
                }
            } else if (str2.startsWith(j3.b.f36044h)) {
                if (!i0(strSubstring, str2)) {
                    return;
                }
            } else if (!strSubstring.equalsIgnoreCase(str2)) {
                return;
            }
        } else {
            if (str.startsWith(j3.b.f36044h)) {
                if (str2.indexOf(64) != -1) {
                    if (!i0(str2.substring(str.indexOf(64) + 1), str)) {
                        return;
                    }
                } else if (str2.startsWith(j3.b.f36044h)) {
                    if (!i0(str, str2) && !str.equalsIgnoreCase(str2)) {
                        if (!i0(str2, str)) {
                            return;
                        }
                    }
                } else if (!i0(str2, str)) {
                    return;
                }
                set.add(str2);
                return;
            }
            if (str2.indexOf(64) != -1) {
                if (!str2.substring(str2.indexOf(64) + 1).equalsIgnoreCase(str)) {
                    return;
                }
                set.add(str2);
                return;
            } else if (str2.startsWith(j3.b.f36044h)) {
                if (!i0(str, str2)) {
                    return;
                }
            } else if (!str.equalsIgnoreCase(str2)) {
                return;
            }
        }
        set.add(str);
    }

    public final byte[] N(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = new byte[length * 2];
        System.arraycopy(bArr, 0, bArr3, 0, length);
        System.arraycopy(bArr2, 0, bArr3, length, length);
        return bArr3;
    }

    public final boolean O(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        if (length != bArr2.length / 2) {
            return false;
        }
        byte[] bArr3 = new byte[length];
        System.arraycopy(bArr2, length, bArr3, 0, length);
        byte[] bArr4 = new byte[length];
        byte[] bArr5 = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            bArr4[i10] = (byte) (bArr2[i10] & bArr3[i10]);
            bArr5[i10] = (byte) (bArr[i10] & bArr3[i10]);
        }
        return org.bouncycastle.util.a.g(bArr4, bArr5);
    }

    public final boolean P(String str, String str2) {
        String strZ = z(str);
        return !str2.startsWith(j3.b.f36044h) ? strZ.equalsIgnoreCase(str2) : i0(strZ, str2);
    }

    public final byte[][] S(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        int length = bArr.length;
        byte[] bArr5 = new byte[length];
        byte[] bArr6 = new byte[length];
        byte[] bArr7 = new byte[length];
        byte[] bArr8 = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            bArr5[i10] = (byte) (bArr[i10] & bArr2[i10]);
            bArr6[i10] = (byte) ((bArr[i10] & bArr2[i10]) | (~bArr2[i10]));
            bArr7[i10] = (byte) (bArr3[i10] & bArr4[i10]);
            bArr8[i10] = (byte) ((bArr3[i10] & bArr4[i10]) | (~bArr4[i10]));
        }
        return new byte[][]{bArr5, bArr6, bArr7, bArr8};
    }

    public final boolean U(p0 p0Var, p0 p0Var2) {
        return p0Var2.equals(p0Var);
    }

    public final String V(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < bArr.length / 2; i10++) {
            if (sb2.length() > 0) {
                sb2.append(j3.b.f36044h);
            }
            sb2.append(Integer.toString(bArr[i10] & 255));
        }
        sb2.append(fh.a.f28350w);
        boolean z10 = true;
        for (int length = bArr.length / 2; length < bArr.length; length++) {
            if (z10) {
                z10 = false;
            } else {
                sb2.append(j3.b.f36044h);
            }
            sb2.append(Integer.toString(bArr[length] & 255));
        }
        return sb2.toString();
    }

    public final String W(Set set) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            if (sb2.length() > 1) {
                sb2.append(ag.c.f654g);
            }
            sb2.append(V((byte[]) it2.next()));
        }
        sb2.append("]");
        return sb2.toString();
    }

    public final String X(Set set) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            if (sb2.length() > 1) {
                sb2.append(ag.c.f654g);
            }
            p0 p0VarX = p0.x(it2.next());
            sb2.append(p0VarX.y().L());
            sb2.append(":");
            try {
                sb2.append(jt.h.j(p0VarX.z().b().getEncoded()));
            } catch (IOException e10) {
                sb2.append(e10.toString());
            }
        }
        sb2.append("]");
        return sb2.toString();
    }

    public final Set Y(Set set, gm.f0 f0Var) {
        if (set.isEmpty()) {
            if (f0Var == null) {
                return set;
            }
            set.add(f0Var);
            return set;
        }
        HashSet hashSet = new HashSet();
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            gm.f0 f0VarJ = gm.f0.J(it2.next());
            if (h0(f0Var, f0VarJ)) {
                hashSet.add(f0VarJ);
            } else {
                if (!h0(f0VarJ, f0Var)) {
                    hashSet.add(f0VarJ);
                }
                hashSet.add(f0Var);
            }
        }
        return hashSet;
    }

    public final Set Z(Set set, String str) {
        if (set.isEmpty()) {
            if (str == null) {
                return set;
            }
            set.add(str);
            return set;
        }
        HashSet hashSet = new HashSet();
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            String str2 = (String) it2.next();
            if (!i0(str2, str)) {
                boolean zI0 = i0(str, str2);
                hashSet.add(str2);
                if (zI0) {
                }
            }
            hashSet.add(str);
        }
        return hashSet;
    }

    @Override // zn.l0
    public void a(b0 b0Var) throws NameConstraintValidatorException {
        int iQ = b0Var.q();
        if (iQ == 0) {
            m(this.f58911f, p0.x(b0Var.A()));
            return;
        }
        if (iQ == 1) {
            k(this.f58908c, B(b0Var));
            return;
        }
        if (iQ == 2) {
            j(this.f58907b, B(b0Var));
            return;
        }
        if (iQ == 4) {
            i(xn.d.A(b0Var.A()));
        } else if (iQ == 6) {
            n(this.f58909d, B(b0Var));
        } else {
            if (iQ != 7) {
                return;
            }
            l(this.f58910e, gm.z.I(b0Var.A()).J());
        }
    }

    public final Set a0(Set set, String str) {
        if (set.isEmpty()) {
            if (str == null) {
                return set;
            }
            set.add(str);
            return set;
        }
        HashSet hashSet = new HashSet();
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            b0((String) it2.next(), str, hashSet);
        }
        return hashSet;
    }

    @Override // zn.l0
    public void b(e0 e0Var) {
        f(new e0[]{e0Var});
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0052, code lost:
    
        if (i0(r6.substring(r5.indexOf(64) + 1), r5) != false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006c, code lost:
    
        if (i0(r6, r5) != false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0073, code lost:
    
        if (i0(r6, r5) != false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008a, code lost:
    
        if (r6.substring(r5.indexOf(64) + 1).equalsIgnoreCase(r5) != false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x009e, code lost:
    
        if (r5.equalsIgnoreCase(r6) != false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a0, code lost:
    
        r7.add(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001f, code lost:
    
        if (r5.equalsIgnoreCase(r6) != false) goto L49;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b0(java.lang.String r5, java.lang.String r6, java.util.Set r7) {
        /*
            r4 = this;
            r0 = 64
            int r1 = r5.indexOf(r0)
            java.lang.String r2 = "."
            r3 = -1
            if (r1 == r3) goto L38
            int r1 = r5.indexOf(r0)
            int r1 = r1 + 1
            java.lang.String r1 = r5.substring(r1)
            int r0 = r6.indexOf(r0)
            if (r0 == r3) goto L23
            boolean r0 = r5.equalsIgnoreCase(r6)
            if (r0 == 0) goto La4
            goto La0
        L23:
            boolean r0 = r6.startsWith(r2)
            if (r0 == 0) goto L31
            boolean r0 = r4.i0(r1, r6)
            if (r0 == 0) goto La4
            goto L99
        L31:
            boolean r0 = r1.equalsIgnoreCase(r6)
            if (r0 == 0) goto La4
            goto L99
        L38:
            boolean r1 = r5.startsWith(r2)
            if (r1 == 0) goto L76
            int r1 = r6.indexOf(r0)
            if (r1 == r3) goto L55
            int r0 = r5.indexOf(r0)
            int r0 = r0 + 1
            java.lang.String r0 = r6.substring(r0)
            boolean r0 = r4.i0(r0, r5)
            if (r0 == 0) goto La4
            goto La0
        L55:
            boolean r0 = r6.startsWith(r2)
            if (r0 == 0) goto L6f
            boolean r0 = r4.i0(r5, r6)
            if (r0 != 0) goto La7
            boolean r0 = r5.equalsIgnoreCase(r6)
            if (r0 == 0) goto L68
            goto La7
        L68:
            boolean r0 = r4.i0(r6, r5)
            if (r0 == 0) goto La4
            goto La0
        L6f:
            boolean r0 = r4.i0(r6, r5)
            if (r0 == 0) goto La4
            goto La0
        L76:
            int r1 = r6.indexOf(r0)
            if (r1 == r3) goto L8d
            int r0 = r5.indexOf(r0)
            int r0 = r0 + 1
            java.lang.String r0 = r6.substring(r0)
            boolean r0 = r0.equalsIgnoreCase(r5)
            if (r0 == 0) goto La4
            goto La0
        L8d:
            boolean r0 = r6.startsWith(r2)
            if (r0 == 0) goto L9a
            boolean r0 = r4.i0(r5, r6)
            if (r0 == 0) goto La4
        L99:
            goto La7
        L9a:
            boolean r0 = r5.equalsIgnoreCase(r6)
            if (r0 == 0) goto La4
        La0:
            r7.add(r5)
            goto Laa
        La4:
            r7.add(r5)
        La7:
            r7.add(r6)
        Laa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: zn.q0.b0(java.lang.String, java.lang.String, java.util.Set):void");
    }

    @Override // zn.l0
    public void c(int i10) {
        if (i10 == 0) {
            this.f58917l = new HashSet();
            return;
        }
        if (i10 == 1) {
            this.f58914i = new HashSet();
            return;
        }
        if (i10 == 2) {
            this.f58913h = new HashSet();
            return;
        }
        if (i10 == 4) {
            this.f58912g = new HashSet();
            return;
        }
        if (i10 == 6) {
            this.f58915j = new HashSet();
        } else {
            if (i10 == 7) {
                this.f58916k = new HashSet();
                return;
            }
            throw new IllegalStateException("Unknown tag encountered: " + i10);
        }
    }

    public final Set c0(Set set, byte[] bArr) {
        if (set.isEmpty()) {
            if (bArr == null) {
                return set;
            }
            set.add(bArr);
            return set;
        }
        HashSet hashSet = new HashSet();
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            hashSet.addAll(d0((byte[]) it2.next(), bArr));
        }
        return hashSet;
    }

    @Override // zn.l0
    public void d(e0 e0Var) {
        b0 b0VarX = e0Var.x();
        int iQ = b0VarX.q();
        if (iQ == 0) {
            this.f58911f = e0(this.f58911f, p0.x(b0VarX.A()));
            return;
        }
        if (iQ == 1) {
            this.f58908c = a0(this.f58908c, B(b0VarX));
            return;
        }
        if (iQ == 2) {
            this.f58907b = Z(this.f58907b, B(b0VarX));
            return;
        }
        if (iQ == 4) {
            this.f58906a = Y(this.f58906a, (gm.f0) b0VarX.A().b());
            return;
        }
        if (iQ == 6) {
            this.f58909d = f0(this.f58909d, B(b0VarX));
        } else {
            if (iQ == 7) {
                this.f58910e = c0(this.f58910e, gm.z.I(b0VarX.A()).J());
                return;
            }
            throw new IllegalStateException("Unknown tag encountered: " + b0VarX.q());
        }
    }

    public final Set d0(byte[] bArr, byte[] bArr2) {
        HashSet hashSet = new HashSet();
        boolean zG = org.bouncycastle.util.a.g(bArr, bArr2);
        hashSet.add(bArr);
        if (!zG) {
            hashSet.add(bArr2);
        }
        return hashSet;
    }

    @Override // zn.l0
    public void e(b0 b0Var) throws NameConstraintValidatorException {
        int iQ = b0Var.q();
        if (iQ == 0) {
            t(this.f58917l, p0.x(b0Var.A()));
            return;
        }
        if (iQ == 1) {
            r(this.f58914i, B(b0Var));
            return;
        }
        if (iQ == 2) {
            q(this.f58913h, B(b0Var));
            return;
        }
        if (iQ == 4) {
            p(xn.d.A(b0Var.A()));
        } else if (iQ == 6) {
            u(this.f58915j, B(b0Var));
        } else {
            if (iQ != 7) {
                return;
            }
            s(this.f58916k, gm.z.I(b0Var.A()).J());
        }
    }

    public final Set e0(Set set, p0 p0Var) {
        HashSet hashSet = set != null ? new HashSet(set) : new HashSet();
        hashSet.add(p0Var);
        return hashSet;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof q0)) {
            return false;
        }
        q0 q0Var = (q0) obj;
        return v(q0Var.f58906a, this.f58906a) && v(q0Var.f58907b, this.f58907b) && v(q0Var.f58908c, this.f58908c) && v(q0Var.f58910e, this.f58910e) && v(q0Var.f58909d, this.f58909d) && v(q0Var.f58911f, this.f58911f) && v(q0Var.f58912g, this.f58912g) && v(q0Var.f58913h, this.f58913h) && v(q0Var.f58914i, this.f58914i) && v(q0Var.f58916k, this.f58916k) && v(q0Var.f58915j, this.f58915j) && v(q0Var.f58917l, this.f58917l);
    }

    @Override // zn.l0
    public void f(e0[] e0VarArr) {
        HashMap map = new HashMap();
        for (int i10 = 0; i10 != e0VarArr.length; i10++) {
            e0 e0Var = e0VarArr[i10];
            Integer numG = org.bouncycastle.util.j.g(e0Var.x().q());
            if (map.get(numG) == null) {
                map.put(numG, new HashSet());
            }
            ((Set) map.get(numG)).add(e0Var);
        }
        for (Map.Entry entry : map.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            if (iIntValue == 0) {
                this.f58917l = J(this.f58917l, (Set) entry.getValue());
            } else if (iIntValue == 1) {
                this.f58914i = F(this.f58914i, (Set) entry.getValue());
            } else if (iIntValue == 2) {
                this.f58913h = E(this.f58913h, (Set) entry.getValue());
            } else if (iIntValue == 4) {
                this.f58912g = D(this.f58912g, (Set) entry.getValue());
            } else if (iIntValue == 6) {
                this.f58915j = L(this.f58915j, (Set) entry.getValue());
            } else {
                if (iIntValue != 7) {
                    throw new IllegalStateException("Unknown tag encountered: " + iIntValue);
                }
                this.f58916k = H(this.f58916k, (Set) entry.getValue());
            }
        }
    }

    public final Set f0(Set set, String str) {
        if (set.isEmpty()) {
            if (str == null) {
                return set;
            }
            set.add(str);
            return set;
        }
        HashSet hashSet = new HashSet();
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            g0((String) it2.next(), str, hashSet);
        }
        return hashSet;
    }

    public final void g(StringBuilder sb2, String str) {
        sb2.append(str);
        sb2.append(Strings.e());
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0052, code lost:
    
        if (i0(r6.substring(r5.indexOf(64) + 1), r5) != false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006c, code lost:
    
        if (i0(r6, r5) != false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0073, code lost:
    
        if (i0(r6, r5) != false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008a, code lost:
    
        if (r6.substring(r5.indexOf(64) + 1).equalsIgnoreCase(r5) != false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x009e, code lost:
    
        if (r5.equalsIgnoreCase(r6) != false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a0, code lost:
    
        r7.add(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001f, code lost:
    
        if (r5.equalsIgnoreCase(r6) != false) goto L49;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g0(java.lang.String r5, java.lang.String r6, java.util.Set r7) {
        /*
            r4 = this;
            r0 = 64
            int r1 = r5.indexOf(r0)
            java.lang.String r2 = "."
            r3 = -1
            if (r1 == r3) goto L38
            int r1 = r5.indexOf(r0)
            int r1 = r1 + 1
            java.lang.String r1 = r5.substring(r1)
            int r0 = r6.indexOf(r0)
            if (r0 == r3) goto L23
            boolean r0 = r5.equalsIgnoreCase(r6)
            if (r0 == 0) goto La4
            goto La0
        L23:
            boolean r0 = r6.startsWith(r2)
            if (r0 == 0) goto L31
            boolean r0 = r4.i0(r1, r6)
            if (r0 == 0) goto La4
            goto L99
        L31:
            boolean r0 = r1.equalsIgnoreCase(r6)
            if (r0 == 0) goto La4
            goto L99
        L38:
            boolean r1 = r5.startsWith(r2)
            if (r1 == 0) goto L76
            int r1 = r6.indexOf(r0)
            if (r1 == r3) goto L55
            int r0 = r5.indexOf(r0)
            int r0 = r0 + 1
            java.lang.String r0 = r6.substring(r0)
            boolean r0 = r4.i0(r0, r5)
            if (r0 == 0) goto La4
            goto La0
        L55:
            boolean r0 = r6.startsWith(r2)
            if (r0 == 0) goto L6f
            boolean r0 = r4.i0(r5, r6)
            if (r0 != 0) goto La7
            boolean r0 = r5.equalsIgnoreCase(r6)
            if (r0 == 0) goto L68
            goto La7
        L68:
            boolean r0 = r4.i0(r6, r5)
            if (r0 == 0) goto La4
            goto La0
        L6f:
            boolean r0 = r4.i0(r6, r5)
            if (r0 == 0) goto La4
            goto La0
        L76:
            int r1 = r6.indexOf(r0)
            if (r1 == r3) goto L8d
            int r0 = r5.indexOf(r0)
            int r0 = r0 + 1
            java.lang.String r0 = r6.substring(r0)
            boolean r0 = r0.equalsIgnoreCase(r5)
            if (r0 == 0) goto La4
            goto La0
        L8d:
            boolean r0 = r6.startsWith(r2)
            if (r0 == 0) goto L9a
            boolean r0 = r4.i0(r5, r6)
            if (r0 == 0) goto La4
        L99:
            goto La7
        L9a:
            boolean r0 = r5.equalsIgnoreCase(r6)
            if (r0 == 0) goto La4
        La0:
            r7.add(r5)
            goto Laa
        La4:
            r7.add(r5)
        La7:
            r7.add(r6)
        Laa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: zn.q0.g0(java.lang.String, java.lang.String, java.util.Set):void");
    }

    public final void h(Set set, gm.f0 f0Var) throws NameConstraintValidatorException {
        if (set.isEmpty()) {
            return;
        }
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            if (h0(f0Var, (gm.f0) it2.next())) {
                throw new NameConstraintValidatorException("Subject distinguished name is from an excluded subtree");
            }
        }
    }

    public int hashCode() {
        return C(this.f58906a) + C(this.f58907b) + C(this.f58908c) + C(this.f58910e) + C(this.f58909d) + C(this.f58911f) + C(this.f58912g) + C(this.f58913h) + C(this.f58914i) + C(this.f58916k) + C(this.f58915j) + C(this.f58917l);
    }

    public void i(xn.d dVar) throws NameConstraintValidatorException {
        h(this.f58906a, gm.f0.J(dVar));
    }

    public final boolean i0(String str, String str2) {
        if (str2.startsWith(j3.b.f36044h)) {
            str2 = str2.substring(1);
        }
        String[] strArrG = Strings.g(str2, '.');
        String[] strArrG2 = Strings.g(str, '.');
        if (strArrG2.length <= strArrG.length) {
            return false;
        }
        int length = strArrG2.length - strArrG.length;
        for (int i10 = -1; i10 < strArrG.length; i10++) {
            if (i10 == -1) {
                if (strArrG2[i10 + length].equals("")) {
                    return false;
                }
            } else if (!strArrG[i10].equalsIgnoreCase(strArrG2[i10 + length])) {
                return false;
            }
        }
        return true;
    }

    public final void j(Set set, String str) throws NameConstraintValidatorException {
        if (set.isEmpty()) {
            return;
        }
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            String str2 = (String) it2.next();
            if (i0(str, str2) || str.equalsIgnoreCase(str2)) {
                throw new NameConstraintValidatorException("DNS is from an excluded subtree.");
            }
        }
    }

    public final void k(Set set, String str) throws NameConstraintValidatorException {
        if (set.isEmpty()) {
            return;
        }
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            if (x(str, (String) it2.next())) {
                throw new NameConstraintValidatorException("Email address is from an excluded subtree.");
            }
        }
    }

    public final void l(Set set, byte[] bArr) throws NameConstraintValidatorException {
        if (set.isEmpty()) {
            return;
        }
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            if (O(bArr, (byte[]) it2.next())) {
                throw new NameConstraintValidatorException("IP is from an excluded subtree.");
            }
        }
    }

    public final void m(Set set, p0 p0Var) throws NameConstraintValidatorException {
        if (set.isEmpty()) {
            return;
        }
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            if (U(p0Var, p0.x(it2.next()))) {
                throw new NameConstraintValidatorException("OtherName is from an excluded subtree.");
            }
        }
    }

    public final void n(Set set, String str) throws NameConstraintValidatorException {
        if (set.isEmpty()) {
            return;
        }
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            if (P(str, (String) it2.next())) {
                throw new NameConstraintValidatorException("URI is from an excluded subtree.");
            }
        }
    }

    public final void o(Set set, gm.f0 f0Var) throws NameConstraintValidatorException {
        if (set == null) {
            return;
        }
        if (set.isEmpty() && f0Var.size() == 0) {
            return;
        }
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            if (h0(f0Var, (gm.f0) it2.next())) {
                return;
            }
        }
        throw new NameConstraintValidatorException("Subject distinguished name is not from a permitted subtree");
    }

    public void p(xn.d dVar) throws NameConstraintValidatorException {
        o(this.f58912g, gm.f0.J(dVar.b()));
    }

    public final void q(Set set, String str) throws NameConstraintValidatorException {
        if (set == null) {
            return;
        }
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            String str2 = (String) it2.next();
            if (i0(str, str2) || str.equalsIgnoreCase(str2)) {
                return;
            }
        }
        if (str.length() != 0 || set.size() != 0) {
            throw new NameConstraintValidatorException("DNS is not from a permitted subtree.");
        }
    }

    public final void r(Set set, String str) throws NameConstraintValidatorException {
        if (set == null) {
            return;
        }
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            if (x(str, (String) it2.next())) {
                return;
            }
        }
        if (str.length() != 0 || set.size() != 0) {
            throw new NameConstraintValidatorException("Subject email address is not from a permitted subtree.");
        }
    }

    public final void s(Set set, byte[] bArr) throws NameConstraintValidatorException {
        if (set == null) {
            return;
        }
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            if (O(bArr, (byte[]) it2.next())) {
                return;
            }
        }
        if (bArr.length != 0 || set.size() != 0) {
            throw new NameConstraintValidatorException("IP is not from a permitted subtree.");
        }
    }

    public final void t(Set set, p0 p0Var) throws NameConstraintValidatorException {
        if (set == null) {
            return;
        }
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            if (U(p0Var, p0.x(it2.next()))) {
                return;
            }
        }
        throw new NameConstraintValidatorException("Subject OtherName is not from a permitted subtree.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        g(sb2, "permitted:");
        if (this.f58912g != null) {
            g(sb2, "DN:");
            g(sb2, this.f58912g.toString());
        }
        if (this.f58913h != null) {
            g(sb2, "DNS:");
            g(sb2, this.f58913h.toString());
        }
        if (this.f58914i != null) {
            g(sb2, "Email:");
            g(sb2, this.f58914i.toString());
        }
        if (this.f58915j != null) {
            g(sb2, "URI:");
            g(sb2, this.f58915j.toString());
        }
        if (this.f58916k != null) {
            g(sb2, "IP:");
            g(sb2, W(this.f58916k));
        }
        if (this.f58917l != null) {
            g(sb2, "OtherName:");
            g(sb2, X(this.f58917l));
        }
        g(sb2, "excluded:");
        if (!this.f58906a.isEmpty()) {
            g(sb2, "DN:");
            g(sb2, this.f58906a.toString());
        }
        if (!this.f58907b.isEmpty()) {
            g(sb2, "DNS:");
            g(sb2, this.f58907b.toString());
        }
        if (!this.f58908c.isEmpty()) {
            g(sb2, "Email:");
            g(sb2, this.f58908c.toString());
        }
        if (!this.f58909d.isEmpty()) {
            g(sb2, "URI:");
            g(sb2, this.f58909d.toString());
        }
        if (!this.f58910e.isEmpty()) {
            g(sb2, "IP:");
            g(sb2, W(this.f58910e));
        }
        if (!this.f58911f.isEmpty()) {
            g(sb2, "OtherName:");
            g(sb2, X(this.f58911f));
        }
        return sb2.toString();
    }

    public final void u(Set set, String str) throws NameConstraintValidatorException {
        if (set == null) {
            return;
        }
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            if (P(str, (String) it2.next())) {
                return;
            }
        }
        if (str.length() != 0 || set.size() != 0) {
            throw new NameConstraintValidatorException("URI is not from a permitted subtree.");
        }
    }

    public final boolean v(Collection collection, Collection collection2) {
        boolean z10;
        if (collection == collection2) {
            return true;
        }
        if (collection == null || collection2 == null || collection.size() != collection2.size()) {
            return false;
        }
        for (Object obj : collection) {
            Iterator it2 = collection2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z10 = false;
                    break;
                }
                if (y(obj, it2.next())) {
                    z10 = true;
                    break;
                }
            }
            if (!z10) {
                return false;
            }
        }
        return true;
    }

    public final boolean x(String str, String str2) {
        String strSubstring = str.substring(str.indexOf(64) + 1);
        if (str2.indexOf(64) != -1) {
            if (str.equalsIgnoreCase(str2) || strSubstring.equalsIgnoreCase(str2.substring(1))) {
                return true;
            }
        } else if (str2.charAt(0) != '.') {
            if (strSubstring.equalsIgnoreCase(str2)) {
                return true;
            }
        } else if (i0(strSubstring, str2)) {
            return true;
        }
        return false;
    }

    public final boolean y(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return ((obj instanceof byte[]) && (obj2 instanceof byte[])) ? org.bouncycastle.util.a.g((byte[]) obj, (byte[]) obj2) : obj.equals(obj2);
    }
}
