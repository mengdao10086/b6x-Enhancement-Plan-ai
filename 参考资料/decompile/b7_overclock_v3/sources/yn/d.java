package yn;

import com.bumptech.glide.load.engine.GlideException;
import gm.c0;
import gm.h;
import gm.j;
import gm.k0;
import gm.s0;
import gm.y;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes5.dex */
public class d {
    public static void a(StringBuffer stringBuffer, xn.c cVar, Hashtable hashtable) {
        if (!cVar.C()) {
            if (cVar.z() != null) {
                b(stringBuffer, cVar.z(), hashtable);
                return;
            }
            return;
        }
        xn.a[] aVarArrB = cVar.B();
        boolean z10 = true;
        for (int i10 = 0; i10 != aVarArrB.length; i10++) {
            if (z10) {
                z10 = false;
            } else {
                stringBuffer.append('+');
            }
            b(stringBuffer, aVarArrB[i10], hashtable);
        }
    }

    public static void b(StringBuffer stringBuffer, xn.a aVar, Hashtable hashtable) {
        String strL = (String) hashtable.get(aVar.y());
        if (strL == null) {
            strL = aVar.y().L();
        }
        stringBuffer.append(strL);
        stringBuffer.append('=');
        stringBuffer.append(r(aVar.z()));
    }

    public static boolean c(xn.a aVar, xn.a aVar2) {
        if (aVar == aVar2) {
            return true;
        }
        return aVar != null && aVar2 != null && aVar.y().C(aVar2.y()) && d(aVar.z()).equals(d(aVar2.z()));
    }

    public static String d(h hVar) {
        return e(r(hVar));
    }

    public static String e(String str) {
        int i10 = 0;
        if (str.length() > 0 && str.charAt(0) == '#') {
            h hVarH = h(str);
            if (hVarH instanceof k0) {
                str = ((k0) hVarH).d();
            }
        }
        String strK = Strings.k(str);
        int length = strK.length();
        if (length < 2) {
            return strK;
        }
        int i11 = length - 1;
        while (i10 < i11 && strK.charAt(i10) == '\\' && strK.charAt(i10 + 1) == ' ') {
            i10 += 2;
        }
        int i12 = i10 + 1;
        int i13 = i11;
        while (i13 > i12 && strK.charAt(i13 - 1) == '\\' && strK.charAt(i13) == ' ') {
            i13 -= 2;
        }
        if (i10 > 0 || i13 < i11) {
            strK = strK.substring(i10, i13 + 1);
        }
        return m(strK);
    }

    public static int f(char c10) {
        if ('0' > c10 || c10 > '9') {
            return (('a' > c10 || c10 > 'f') ? c10 - 'A' : c10 - 'a') + 10;
        }
        return c10 - '0';
    }

    public static y g(String str, Hashtable hashtable) {
        if (Strings.o(str).startsWith("OID.")) {
            return new y(str.substring(4));
        }
        if (str.charAt(0) >= '0' && str.charAt(0) <= '9') {
            return new y(str);
        }
        y yVar = (y) hashtable.get(Strings.k(str));
        if (yVar != null) {
            return yVar;
        }
        throw new IllegalArgumentException("Unknown object id - " + str + " - passed to distinguished name");
    }

    public static c0 h(String str) {
        try {
            return c0.D(jt.h.e(str, 1, str.length() - 1));
        } catch (IOException e10) {
            throw new IllegalStateException("unknown encoding in name: " + e10);
        }
    }

    public static String[] i(y yVar, Hashtable hashtable) {
        Enumeration enumerationElements = hashtable.elements();
        int i10 = 0;
        int i11 = 0;
        while (enumerationElements.hasMoreElements()) {
            if (yVar.equals(enumerationElements.nextElement())) {
                i11++;
            }
        }
        String[] strArr = new String[i11];
        Enumeration enumerationKeys = hashtable.keys();
        while (enumerationKeys.hasMoreElements()) {
            String str = (String) enumerationKeys.nextElement();
            if (yVar.equals(hashtable.get(str))) {
                strArr[i10] = str;
                i10++;
            }
        }
        return strArr;
    }

    public static boolean j(char c10) {
        return ('0' <= c10 && c10 <= '9') || ('a' <= c10 && c10 <= 'f') || ('A' <= c10 && c10 <= 'F');
    }

    public static boolean k(xn.c cVar, xn.c cVar2) {
        if (cVar.size() != cVar2.size()) {
            return false;
        }
        xn.a[] aVarArrB = cVar.B();
        xn.a[] aVarArrB2 = cVar2.B();
        if (aVarArrB.length != aVarArrB2.length) {
            return false;
        }
        for (int i10 = 0; i10 != aVarArrB.length; i10++) {
            if (!c(aVarArrB[i10], aVarArrB2[i10])) {
                return false;
            }
        }
        return true;
    }

    public static xn.c[] l(String str, xn.f fVar) {
        f fVar2 = new f(str);
        xn.e eVar = new xn.e(fVar);
        while (fVar2.a()) {
            String strB = fVar2.b();
            if (strB.indexOf(43) > 0) {
                f fVar3 = new f(strB, '+');
                f fVar4 = new f(fVar3.b(), '=');
                String strB2 = fVar4.b();
                if (!fVar4.a()) {
                    throw new IllegalArgumentException("badly formatted directory string");
                }
                String strB3 = fVar4.b();
                y yVarE = fVar.e(strB2.trim());
                if (fVar3.a()) {
                    Vector vector = new Vector();
                    Vector vector2 = new Vector();
                    while (true) {
                        vector.addElement(yVarE);
                        vector2.addElement(p(strB3));
                        if (!fVar3.a()) {
                            eVar.b(n(vector), o(vector2));
                            break;
                        }
                        f fVar5 = new f(fVar3.b(), '=');
                        String strB4 = fVar5.b();
                        if (!fVar5.a()) {
                            throw new IllegalArgumentException("badly formatted directory string");
                        }
                        strB3 = fVar5.b();
                        yVarE = fVar.e(strB4.trim());
                    }
                } else {
                    eVar.e(yVarE, p(strB3));
                }
            } else {
                f fVar6 = new f(strB, '=');
                String strB5 = fVar6.b();
                if (!fVar6.a()) {
                    throw new IllegalArgumentException("badly formatted directory string");
                }
                eVar.e(fVar.e(strB5.trim()), p(fVar6.b()));
            }
        }
        return eVar.g().C();
    }

    public static String m(String str) {
        if (str.indexOf(GlideException.a.f12263d) < 0) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer();
        char cCharAt = str.charAt(0);
        stringBuffer.append(cCharAt);
        for (int i10 = 1; i10 < str.length(); i10++) {
            char cCharAt2 = str.charAt(i10);
            if (cCharAt != ' ' || cCharAt2 != ' ') {
                stringBuffer.append(cCharAt2);
                cCharAt = cCharAt2;
            }
        }
        return stringBuffer.toString();
    }

    public static y[] n(Vector vector) {
        int size = vector.size();
        y[] yVarArr = new y[size];
        for (int i10 = 0; i10 != size; i10++) {
            yVarArr[i10] = (y) vector.elementAt(i10);
        }
        return yVarArr;
    }

    public static String[] o(Vector vector) {
        int size = vector.size();
        String[] strArr = new String[size];
        for (int i10 = 0; i10 != size; i10++) {
            strArr[i10] = (String) vector.elementAt(i10);
        }
        return strArr;
    }

    public static String p(String str) {
        int i10;
        if (str.length() == 0 || (str.indexOf(92) < 0 && str.indexOf(34) < 0)) {
            return str.trim();
        }
        char[] charArray = str.toCharArray();
        StringBuffer stringBuffer = new StringBuffer(str.length());
        if (charArray[0] == '\\' && charArray[1] == '#') {
            i10 = 2;
            stringBuffer.append("\\#");
        } else {
            i10 = 0;
        }
        boolean z10 = false;
        int length = 0;
        boolean z11 = false;
        boolean z12 = false;
        char c10 = 0;
        while (i10 != charArray.length) {
            char c11 = charArray[i10];
            if (c11 != ' ') {
                z12 = true;
            }
            if (c11 == '\"') {
                if (!z10) {
                    z11 = !z11;
                }
                z10 = false;
                i10++;
            } else {
                if (c11 == '\\' && !z10 && !z11) {
                    length = stringBuffer.length();
                    z10 = true;
                } else if (c11 != ' ' || z10 || z12) {
                    if (z10 && j(c11)) {
                        if (c10 != 0) {
                            stringBuffer.append((char) ((f(c10) * 16) + f(c11)));
                            z10 = false;
                            c10 = 0;
                        } else {
                            c10 = c11;
                        }
                    }
                }
                i10++;
            }
            stringBuffer.append(c11);
            z10 = false;
            i10++;
        }
        if (stringBuffer.length() > 0) {
            while (stringBuffer.charAt(stringBuffer.length() - 1) == ' ' && length != stringBuffer.length() - 1) {
                stringBuffer.setLength(stringBuffer.length() - 1);
            }
        }
        return stringBuffer.toString();
    }

    public static h q(String str, int i10) throws IOException {
        int length = (str.length() - i10) / 2;
        byte[] bArr = new byte[length];
        for (int i11 = 0; i11 != length; i11++) {
            int i12 = (i11 * 2) + i10;
            char cCharAt = str.charAt(i12);
            char cCharAt2 = str.charAt(i12 + 1);
            bArr[i11] = (byte) (f(cCharAt2) | (f(cCharAt) << 4));
        }
        return c0.D(bArr);
    }

    public static String r(h hVar) {
        StringBuffer stringBuffer = new StringBuffer();
        if (!(hVar instanceof k0) || (hVar instanceof s0)) {
            try {
                stringBuffer.append('#');
                stringBuffer.append(jt.h.j(hVar.b().v(j.f29713a)));
            } catch (IOException unused) {
                throw new IllegalArgumentException("Other value has no encoded form");
            }
        } else {
            String strD = ((k0) hVar).d();
            if (strD.length() > 0 && strD.charAt(0) == '#') {
                stringBuffer.append('\\');
            }
            stringBuffer.append(strD);
        }
        int length = stringBuffer.length();
        int i10 = (stringBuffer.length() >= 2 && stringBuffer.charAt(0) == '\\' && stringBuffer.charAt(1) == '#') ? 2 : 0;
        while (i10 != length) {
            char cCharAt = stringBuffer.charAt(i10);
            if (cCharAt != '\"' && cCharAt != '\\' && cCharAt != '+' && cCharAt != ',') {
                switch (cCharAt) {
                    case ';':
                    case '<':
                    case '=':
                    case '>':
                        break;
                    default:
                        i10++;
                        break;
                }
            }
            stringBuffer.insert(i10, "\\");
            i10 += 2;
            length++;
        }
        if (stringBuffer.length() > 0) {
            for (int i11 = 0; stringBuffer.length() > i11 && stringBuffer.charAt(i11) == ' '; i11 += 2) {
                stringBuffer.insert(i11, "\\");
            }
        }
        for (int length2 = stringBuffer.length() - 1; length2 >= 0 && stringBuffer.charAt(length2) == ' '; length2--) {
            stringBuffer.insert(length2, '\\');
        }
        return stringBuffer.toString();
    }
}
