package androidx.profileinstaller;

import g.n0;
import g.p0;
import g.v0;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
@v0(19)
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f6493a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f6494b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f6495c = 4;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f6496d = 6;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f6497e = 7;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final byte[] f6498f = {pq.b.f46994k, 114, pq.b.f46991h, 0};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final byte[] f6499g = {pq.b.f46994k, 114, 109, 0};

    public static void A(@n0 InputStream inputStream) throws IOException {
        e.h(inputStream);
        int iJ = e.j(inputStream);
        if (iJ == 6 || iJ == 7) {
            return;
        }
        while (iJ > 0) {
            e.j(inputStream);
            for (int iJ2 = e.j(inputStream); iJ2 > 0; iJ2--) {
                e.h(inputStream);
            }
            iJ--;
        }
    }

    public static boolean B(@n0 OutputStream outputStream, @n0 byte[] bArr, @n0 d[] dVarArr) throws IOException {
        if (Arrays.equals(bArr, p.f6525a)) {
            N(outputStream, dVarArr);
            return true;
        }
        if (Arrays.equals(bArr, p.f6526b)) {
            M(outputStream, dVarArr);
            return true;
        }
        if (Arrays.equals(bArr, p.f6528d)) {
            K(outputStream, dVarArr);
            return true;
        }
        if (Arrays.equals(bArr, p.f6527c)) {
            L(outputStream, dVarArr);
            return true;
        }
        if (!Arrays.equals(bArr, p.f6529e)) {
            return false;
        }
        J(outputStream, dVarArr);
        return true;
    }

    public static void C(@n0 OutputStream outputStream, @n0 d dVar) throws IOException {
        int iIntValue = 0;
        for (int i10 : dVar.f6448h) {
            Integer numValueOf = Integer.valueOf(i10);
            e.p(outputStream, numValueOf.intValue() - iIntValue);
            iIntValue = numValueOf.intValue();
        }
    }

    public static q D(@n0 d[] dVarArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            e.p(byteArrayOutputStream, dVarArr.length);
            int i10 = 2;
            for (d dVar : dVarArr) {
                e.q(byteArrayOutputStream, dVar.f6443c);
                e.q(byteArrayOutputStream, dVar.f6444d);
                e.q(byteArrayOutputStream, dVar.f6447g);
                String strJ = j(dVar.f6441a, dVar.f6442b, p.f6525a);
                int iK = e.k(strJ);
                e.p(byteArrayOutputStream, iK);
                i10 = i10 + 4 + 4 + 4 + 2 + (iK * 1);
                e.n(byteArrayOutputStream, strJ);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (i10 == byteArray.length) {
                q qVar = new q(FileSectionType.DEX_FILES, i10, byteArray, false);
                byteArrayOutputStream.close();
                return qVar;
            }
            throw e.c("Expected size " + i10 + ", does not match actual size " + byteArray.length);
        } catch (Throwable th2) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    public static void E(@n0 OutputStream outputStream, byte[] bArr) throws IOException {
        outputStream.write(f6498f);
        outputStream.write(bArr);
    }

    public static void F(@n0 OutputStream outputStream, @n0 d dVar) throws IOException {
        I(outputStream, dVar);
        C(outputStream, dVar);
        H(outputStream, dVar);
    }

    public static void G(@n0 OutputStream outputStream, @n0 d dVar, @n0 String str) throws IOException {
        e.p(outputStream, e.k(str));
        e.p(outputStream, dVar.f6445e);
        e.q(outputStream, dVar.f6446f);
        e.q(outputStream, dVar.f6443c);
        e.q(outputStream, dVar.f6447g);
        e.n(outputStream, str);
    }

    public static void H(@n0 OutputStream outputStream, @n0 d dVar) throws IOException {
        byte[] bArr = new byte[k(dVar.f6447g)];
        for (Map.Entry<Integer, Integer> entry : dVar.f6449i.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            int iIntValue2 = entry.getValue().intValue();
            if ((iIntValue2 & 2) != 0) {
                z(bArr, 2, iIntValue, dVar);
            }
            if ((iIntValue2 & 4) != 0) {
                z(bArr, 4, iIntValue, dVar);
            }
        }
        outputStream.write(bArr);
    }

    public static void I(@n0 OutputStream outputStream, @n0 d dVar) throws IOException {
        int i10 = 0;
        for (Map.Entry<Integer, Integer> entry : dVar.f6449i.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            if ((entry.getValue().intValue() & 1) != 0) {
                e.p(outputStream, iIntValue - i10);
                e.p(outputStream, 0);
                i10 = iIntValue;
            }
        }
    }

    public static void J(@n0 OutputStream outputStream, @n0 d[] dVarArr) throws IOException {
        e.p(outputStream, dVarArr.length);
        for (d dVar : dVarArr) {
            String strJ = j(dVar.f6441a, dVar.f6442b, p.f6529e);
            e.p(outputStream, e.k(strJ));
            e.p(outputStream, dVar.f6449i.size());
            e.p(outputStream, dVar.f6448h.length);
            e.q(outputStream, dVar.f6443c);
            e.n(outputStream, strJ);
            Iterator<Integer> it2 = dVar.f6449i.keySet().iterator();
            while (it2.hasNext()) {
                e.p(outputStream, it2.next().intValue());
            }
            for (int i10 : dVar.f6448h) {
                e.p(outputStream, i10);
            }
        }
    }

    public static void K(@n0 OutputStream outputStream, @n0 d[] dVarArr) throws IOException {
        e.r(outputStream, dVarArr.length);
        for (d dVar : dVarArr) {
            int size = dVar.f6449i.size() * 4;
            String strJ = j(dVar.f6441a, dVar.f6442b, p.f6528d);
            e.p(outputStream, e.k(strJ));
            e.p(outputStream, dVar.f6448h.length);
            e.q(outputStream, size);
            e.q(outputStream, dVar.f6443c);
            e.n(outputStream, strJ);
            Iterator<Integer> it2 = dVar.f6449i.keySet().iterator();
            while (it2.hasNext()) {
                e.p(outputStream, it2.next().intValue());
                e.p(outputStream, 0);
            }
            for (int i10 : dVar.f6448h) {
                e.p(outputStream, i10);
            }
        }
    }

    public static void L(@n0 OutputStream outputStream, @n0 d[] dVarArr) throws IOException {
        byte[] bArrB = b(dVarArr, p.f6527c);
        e.r(outputStream, dVarArr.length);
        e.m(outputStream, bArrB);
    }

    public static void M(@n0 OutputStream outputStream, @n0 d[] dVarArr) throws IOException {
        byte[] bArrB = b(dVarArr, p.f6526b);
        e.r(outputStream, dVarArr.length);
        e.m(outputStream, bArrB);
    }

    public static void N(@n0 OutputStream outputStream, @n0 d[] dVarArr) throws IOException {
        O(outputStream, dVarArr);
    }

    public static void O(@n0 OutputStream outputStream, @n0 d[] dVarArr) throws IOException {
        int length;
        ArrayList arrayList = new ArrayList(3);
        ArrayList arrayList2 = new ArrayList(3);
        arrayList.add(D(dVarArr));
        arrayList.add(c(dVarArr));
        arrayList.add(d(dVarArr));
        long length2 = ((long) p.f6525a.length) + ((long) f6498f.length) + 4 + ((long) (arrayList.size() * 16));
        e.q(outputStream, arrayList.size());
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            q qVar = (q) arrayList.get(i10);
            e.q(outputStream, qVar.f6534a.getValue());
            e.q(outputStream, length2);
            if (qVar.f6537d) {
                byte[] bArr = qVar.f6536c;
                long length3 = bArr.length;
                byte[] bArrB = e.b(bArr);
                arrayList2.add(bArrB);
                e.q(outputStream, bArrB.length);
                e.q(outputStream, length3);
                length = bArrB.length;
            } else {
                arrayList2.add(qVar.f6536c);
                e.q(outputStream, qVar.f6536c.length);
                e.q(outputStream, 0L);
                length = qVar.f6536c.length;
            }
            length2 += (long) length;
        }
        for (int i11 = 0; i11 < arrayList2.size(); i11++) {
            outputStream.write((byte[]) arrayList2.get(i11));
        }
    }

    public static int a(@n0 d dVar) {
        Iterator<Map.Entry<Integer, Integer>> it2 = dVar.f6449i.entrySet().iterator();
        int iIntValue = 0;
        while (it2.hasNext()) {
            iIntValue |= it2.next().getValue().intValue();
        }
        return iIntValue;
    }

    @n0
    public static byte[] b(@n0 d[] dVarArr, @n0 byte[] bArr) throws IOException {
        int i10 = 0;
        int iK = 0;
        for (d dVar : dVarArr) {
            iK += e.k(j(dVar.f6441a, dVar.f6442b, bArr)) + 16 + (dVar.f6445e * 2) + dVar.f6446f + k(dVar.f6447g);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(iK);
        if (Arrays.equals(bArr, p.f6527c)) {
            int length = dVarArr.length;
            while (i10 < length) {
                d dVar2 = dVarArr[i10];
                G(byteArrayOutputStream, dVar2, j(dVar2.f6441a, dVar2.f6442b, bArr));
                F(byteArrayOutputStream, dVar2);
                i10++;
            }
        } else {
            for (d dVar3 : dVarArr) {
                G(byteArrayOutputStream, dVar3, j(dVar3.f6441a, dVar3.f6442b, bArr));
            }
            int length2 = dVarArr.length;
            while (i10 < length2) {
                F(byteArrayOutputStream, dVarArr[i10]);
                i10++;
            }
        }
        if (byteArrayOutputStream.size() == iK) {
            return byteArrayOutputStream.toByteArray();
        }
        throw e.c("The bytes saved do not match expectation. actual=" + byteArrayOutputStream.size() + " expected=" + iK);
    }

    public static q c(@n0 d[] dVarArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i10 = 0;
        for (int i11 = 0; i11 < dVarArr.length; i11++) {
            try {
                d dVar = dVarArr[i11];
                e.p(byteArrayOutputStream, i11);
                e.p(byteArrayOutputStream, dVar.f6445e);
                i10 = i10 + 2 + 2 + (dVar.f6445e * 2);
                C(byteArrayOutputStream, dVar);
            } catch (Throwable th2) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i10 == byteArray.length) {
            q qVar = new q(FileSectionType.CLASSES, i10, byteArray, true);
            byteArrayOutputStream.close();
            return qVar;
        }
        throw e.c("Expected size " + i10 + ", does not match actual size " + byteArray.length);
    }

    public static q d(@n0 d[] dVarArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i10 = 0;
        for (int i11 = 0; i11 < dVarArr.length; i11++) {
            try {
                d dVar = dVarArr[i11];
                int iA = a(dVar);
                byte[] bArrE = e(dVar);
                byte[] bArrF = f(dVar);
                e.p(byteArrayOutputStream, i11);
                int length = bArrE.length + 2 + bArrF.length;
                e.q(byteArrayOutputStream, length);
                e.p(byteArrayOutputStream, iA);
                byteArrayOutputStream.write(bArrE);
                byteArrayOutputStream.write(bArrF);
                i10 = i10 + 2 + 4 + length;
            } catch (Throwable th2) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i10 == byteArray.length) {
            q qVar = new q(FileSectionType.METHODS, i10, byteArray, true);
            byteArrayOutputStream.close();
            return qVar;
        }
        throw e.c("Expected size " + i10 + ", does not match actual size " + byteArray.length);
    }

    public static byte[] e(@n0 d dVar) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            H(byteArrayOutputStream, dVar);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th2) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    public static byte[] f(@n0 d dVar) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            I(byteArrayOutputStream, dVar);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th2) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    @n0
    public static String g(@n0 String str, @n0 String str2) {
        return "!".equals(str2) ? str.replace(":", "!") : ":".equals(str2) ? str.replace("!", ":") : str;
    }

    @n0
    public static String h(@n0 String str) {
        int iIndexOf = str.indexOf("!");
        if (iIndexOf < 0) {
            iIndexOf = str.indexOf(":");
        }
        return iIndexOf > 0 ? str.substring(iIndexOf + 1) : str;
    }

    @p0
    public static d i(@n0 d[] dVarArr, @n0 String str) {
        if (dVarArr.length <= 0) {
            return null;
        }
        String strH = h(str);
        for (int i10 = 0; i10 < dVarArr.length; i10++) {
            if (dVarArr[i10].f6442b.equals(strH)) {
                return dVarArr[i10];
            }
        }
        return null;
    }

    @n0
    public static String j(@n0 String str, @n0 String str2, @n0 byte[] bArr) {
        String strA = p.a(bArr);
        if (str.length() <= 0) {
            return g(str2, strA);
        }
        if (str2.equals("classes.dex")) {
            return str;
        }
        if (str2.contains("!") || str2.contains(":")) {
            return g(str2, strA);
        }
        if (str2.endsWith(".apk")) {
            return str2;
        }
        return str + p.a(bArr) + str2;
    }

    public static int k(int i10) {
        return y(i10 * 2) / 8;
    }

    public static int l(int i10, int i11, int i12) {
        if (i10 == 1) {
            throw e.c("HOT methods are not stored in the bitmap");
        }
        if (i10 == 2) {
            return i11;
        }
        if (i10 == 4) {
            return i11 + i12;
        }
        throw e.c("Unexpected flag: " + i10);
    }

    public static int[] m(@n0 InputStream inputStream, int i10) throws IOException {
        int[] iArr = new int[i10];
        int iH = 0;
        for (int i11 = 0; i11 < i10; i11++) {
            iH += e.h(inputStream);
            iArr[i11] = iH;
        }
        return iArr;
    }

    public static int n(@n0 BitSet bitSet, int i10, int i11) {
        int i12 = bitSet.get(l(2, i10, i11)) ? 2 : 0;
        return bitSet.get(l(4, i10, i11)) ? i12 | 4 : i12;
    }

    public static byte[] o(@n0 InputStream inputStream, @n0 byte[] bArr) throws IOException {
        if (Arrays.equals(bArr, e.d(inputStream, bArr.length))) {
            return e.d(inputStream, p.f6526b.length);
        }
        throw e.c("Invalid magic");
    }

    public static void p(@n0 InputStream inputStream, @n0 d dVar) throws IOException {
        int iAvailable = inputStream.available() - dVar.f6446f;
        int iH = 0;
        while (inputStream.available() > iAvailable) {
            iH += e.h(inputStream);
            dVar.f6449i.put(Integer.valueOf(iH), 1);
            for (int iH2 = e.h(inputStream); iH2 > 0; iH2--) {
                A(inputStream);
            }
        }
        if (inputStream.available() != iAvailable) {
            throw e.c("Read too much data during profile line parse");
        }
    }

    @n0
    public static d[] q(@n0 InputStream inputStream, @n0 byte[] bArr, @n0 byte[] bArr2, d[] dVarArr) throws IOException {
        if (Arrays.equals(bArr, p.f6530f)) {
            if (Arrays.equals(p.f6525a, bArr2)) {
                throw e.c("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
            }
            return r(inputStream, bArr, dVarArr);
        }
        if (Arrays.equals(bArr, p.f6531g)) {
            return t(inputStream, bArr2, dVarArr);
        }
        throw e.c("Unsupported meta version");
    }

    @n0
    public static d[] r(@n0 InputStream inputStream, @n0 byte[] bArr, d[] dVarArr) throws IOException {
        if (!Arrays.equals(bArr, p.f6530f)) {
            throw e.c("Unsupported meta version");
        }
        int iJ = e.j(inputStream);
        byte[] bArrE = e.e(inputStream, (int) e.i(inputStream), (int) e.i(inputStream));
        if (inputStream.read() > 0) {
            throw e.c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrE);
        try {
            d[] dVarArrS = s(byteArrayInputStream, iJ, dVarArr);
            byteArrayInputStream.close();
            return dVarArrS;
        } catch (Throwable th2) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    @n0
    public static d[] s(@n0 InputStream inputStream, int i10, d[] dVarArr) throws IOException {
        if (inputStream.available() == 0) {
            return new d[0];
        }
        if (i10 != dVarArr.length) {
            throw e.c("Mismatched number of dex files found in metadata");
        }
        String[] strArr = new String[i10];
        int[] iArr = new int[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            int iH = e.h(inputStream);
            iArr[i11] = e.h(inputStream);
            strArr[i11] = e.f(inputStream, iH);
        }
        for (int i12 = 0; i12 < i10; i12++) {
            d dVar = dVarArr[i12];
            if (!dVar.f6442b.equals(strArr[i12])) {
                throw e.c("Order of dexfiles in metadata did not match baseline");
            }
            int i13 = iArr[i12];
            dVar.f6445e = i13;
            dVar.f6448h = m(inputStream, i13);
        }
        return dVarArr;
    }

    @n0
    public static d[] t(@n0 InputStream inputStream, @n0 byte[] bArr, d[] dVarArr) throws IOException {
        int iH = e.h(inputStream);
        byte[] bArrE = e.e(inputStream, (int) e.i(inputStream), (int) e.i(inputStream));
        if (inputStream.read() > 0) {
            throw e.c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrE);
        try {
            d[] dVarArrU = u(byteArrayInputStream, bArr, iH, dVarArr);
            byteArrayInputStream.close();
            return dVarArrU;
        } catch (Throwable th2) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    @n0
    public static d[] u(@n0 InputStream inputStream, @n0 byte[] bArr, int i10, d[] dVarArr) throws IOException {
        if (inputStream.available() == 0) {
            return new d[0];
        }
        if (i10 != dVarArr.length) {
            throw e.c("Mismatched number of dex files found in metadata");
        }
        for (int i11 = 0; i11 < i10; i11++) {
            e.h(inputStream);
            String strF = e.f(inputStream, e.h(inputStream));
            long jI = e.i(inputStream);
            int iH = e.h(inputStream);
            d dVarI = i(dVarArr, strF);
            if (dVarI == null) {
                throw e.c("Missing profile key: " + strF);
            }
            dVarI.f6444d = jI;
            int[] iArrM = m(inputStream, iH);
            if (Arrays.equals(bArr, p.f6529e)) {
                dVarI.f6445e = iH;
                dVarI.f6448h = iArrM;
            }
        }
        return dVarArr;
    }

    public static void v(@n0 InputStream inputStream, @n0 d dVar) throws IOException {
        BitSet bitSetValueOf = BitSet.valueOf(e.d(inputStream, e.a(dVar.f6447g * 2)));
        int i10 = 0;
        while (true) {
            int i11 = dVar.f6447g;
            if (i10 >= i11) {
                return;
            }
            int iN = n(bitSetValueOf, i10, i11);
            if (iN != 0) {
                Integer num = dVar.f6449i.get(Integer.valueOf(i10));
                if (num == null) {
                    num = 0;
                }
                dVar.f6449i.put(Integer.valueOf(i10), Integer.valueOf(iN | num.intValue()));
            }
            i10++;
        }
    }

    @n0
    public static d[] w(@n0 InputStream inputStream, @n0 byte[] bArr, @n0 String str) throws IOException {
        if (!Arrays.equals(bArr, p.f6526b)) {
            throw e.c("Unsupported version");
        }
        int iJ = e.j(inputStream);
        byte[] bArrE = e.e(inputStream, (int) e.i(inputStream), (int) e.i(inputStream));
        if (inputStream.read() > 0) {
            throw e.c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrE);
        try {
            d[] dVarArrX = x(byteArrayInputStream, str, iJ);
            byteArrayInputStream.close();
            return dVarArrX;
        } catch (Throwable th2) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    @n0
    public static d[] x(@n0 InputStream inputStream, @n0 String str, int i10) throws IOException {
        if (inputStream.available() == 0) {
            return new d[0];
        }
        d[] dVarArr = new d[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            int iH = e.h(inputStream);
            int iH2 = e.h(inputStream);
            long jI = e.i(inputStream);
            dVarArr[i11] = new d(str, e.f(inputStream, iH), e.i(inputStream), 0L, iH2, (int) jI, (int) e.i(inputStream), new int[iH2], new TreeMap());
        }
        for (int i12 = 0; i12 < i10; i12++) {
            d dVar = dVarArr[i12];
            p(inputStream, dVar);
            dVar.f6448h = m(inputStream, dVar.f6445e);
            v(inputStream, dVar);
        }
        return dVarArr;
    }

    public static int y(int i10) {
        return ((i10 + 8) - 1) & (-8);
    }

    public static void z(@n0 byte[] bArr, int i10, int i11, @n0 d dVar) {
        int iL = l(i10, i11, dVar.f6447g);
        int i12 = iL / 8;
        bArr[i12] = (byte) ((1 << (iL % 8)) | bArr[i12]);
    }
}
