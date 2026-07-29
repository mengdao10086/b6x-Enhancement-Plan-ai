package org.bouncycastle.pqc.crypto.xmss;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public class k0 {

    public static class a extends ObjectInputStream {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Set f45918c;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class f45919a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f45920b;

        static {
            HashSet hashSet = new HashSet();
            f45918c = hashSet;
            hashSet.add("java.util.TreeMap");
            hashSet.add("java.lang.Integer");
            hashSet.add("java.lang.Number");
            hashSet.add("org.bouncycastle.pqc.crypto.xmss.BDS");
            hashSet.add("java.util.ArrayList");
            hashSet.add("org.bouncycastle.pqc.crypto.xmss.XMSSNode");
            hashSet.add("[B");
            hashSet.add("java.util.LinkedList");
            hashSet.add("java.util.Stack");
            hashSet.add("java.util.Vector");
            hashSet.add("[Ljava.lang.Object;");
            hashSet.add("org.bouncycastle.pqc.crypto.xmss.BDSTreeHash");
        }

        public a(Class cls, InputStream inputStream) throws IOException {
            super(inputStream);
            this.f45920b = false;
            this.f45919a = cls;
        }

        @Override // java.io.ObjectInputStream
        public Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
            if (this.f45920b) {
                if (!f45918c.contains(objectStreamClass.getName())) {
                    throw new InvalidClassException("unexpected class: ", objectStreamClass.getName());
                }
            } else {
                if (!objectStreamClass.getName().equals(this.f45919a.getName())) {
                    throw new InvalidClassException("unexpected class: ", objectStreamClass.getName());
                }
                this.f45920b = true;
            }
            return super.resolveClass(objectStreamClass);
        }
    }

    public static boolean a(byte[][] bArr, byte[][] bArr2) {
        if (m(bArr) || m(bArr2)) {
            throw new NullPointerException("a or b == null");
        }
        for (int i10 = 0; i10 < bArr.length; i10++) {
            if (!org.bouncycastle.util.a.g(bArr[i10], bArr2[i10])) {
                return false;
            }
        }
        return true;
    }

    public static long b(byte[] bArr, int i10, int i11) {
        Objects.requireNonNull(bArr, "in == null");
        long j10 = 0;
        for (int i12 = i10; i12 < i10 + i11; i12++) {
            j10 = (j10 << 8) | ((long) (bArr[i12] & 255));
        }
        return j10;
    }

    public static int c(int i10, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            if (((i10 >> i12) & 1) == 0) {
                return i12;
            }
        }
        return 0;
    }

    public static byte[] d(byte[] bArr) {
        Objects.requireNonNull(bArr, "in == null");
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public static byte[][] e(byte[][] bArr) {
        if (m(bArr)) {
            throw new NullPointerException("in has null pointers");
        }
        byte[][] bArr2 = new byte[bArr.length][];
        for (int i10 = 0; i10 < bArr.length; i10++) {
            bArr2[i10] = new byte[bArr[i10].length];
            System.arraycopy(bArr[i10], 0, bArr2[i10], 0, bArr[i10].length);
        }
        return bArr2;
    }

    public static void f(byte[] bArr, byte[] bArr2, int i10) {
        Objects.requireNonNull(bArr, "dst == null");
        Objects.requireNonNull(bArr2, "src == null");
        if (i10 < 0) {
            throw new IllegalArgumentException("offset hast to be >= 0");
        }
        if (bArr2.length + i10 > bArr.length) {
            throw new IllegalArgumentException("src length + offset must not be greater than size of destination");
        }
        for (int i11 = 0; i11 < bArr2.length; i11++) {
            bArr[i10 + i11] = bArr2[i11];
        }
    }

    public static Object g(byte[] bArr, Class cls) throws ClassNotFoundException, IOException {
        a aVar = new a(cls, new ByteArrayInputStream(bArr));
        Object object = aVar.readObject();
        if (aVar.available() != 0) {
            throw new IOException("unexpected data found at end of ObjectInputStream");
        }
        if (cls.isInstance(object)) {
            return object;
        }
        throw new IOException("unexpected class found in ObjectInputStream");
    }

    public static void h(byte[][] bArr) {
        if (m(bArr)) {
            throw new NullPointerException("x has null pointers");
        }
        for (byte[] bArr2 : bArr) {
            System.out.println(jt.h.j(bArr2));
        }
    }

    public static byte[] i(byte[] bArr, int i10, int i11) {
        Objects.requireNonNull(bArr, "src == null");
        if (i10 < 0) {
            throw new IllegalArgumentException("offset hast to be >= 0");
        }
        if (i11 < 0) {
            throw new IllegalArgumentException("length hast to be >= 0");
        }
        if (i10 + i11 > bArr.length) {
            throw new IllegalArgumentException("offset + length must not be greater then size of source array");
        }
        byte[] bArr2 = new byte[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            bArr2[i12] = bArr[i10 + i12];
        }
        return bArr2;
    }

    public static int j(org.bouncycastle.crypto.s sVar) {
        Objects.requireNonNull(sVar, "digest == null");
        String strB = sVar.b();
        if (strB.equals("SHAKE128")) {
            return 32;
        }
        if (strB.equals("SHAKE256")) {
            return 64;
        }
        return sVar.h();
    }

    public static int k(long j10, int i10) {
        return (int) (j10 & ((1 << i10) - 1));
    }

    public static long l(long j10, int i10) {
        return j10 >> i10;
    }

    public static boolean m(byte[][] bArr) {
        if (bArr == null) {
            return true;
        }
        for (byte[] bArr2 : bArr) {
            if (bArr2 == null) {
                return true;
            }
        }
        return false;
    }

    public static boolean n(int i10, long j10) {
        if (j10 >= 0) {
            return j10 < (1 << i10);
        }
        throw new IllegalStateException("index must not be negative");
    }

    public static boolean o(long j10, int i10, int i11) {
        return j10 != 0 && (j10 + 1) % ((long) Math.pow((double) (1 << i10), (double) i11)) == 0;
    }

    public static boolean p(long j10, int i10, int i11) {
        return j10 != 0 && j10 % ((long) Math.pow((double) (1 << i10), (double) (i11 + 1))) == 0;
    }

    public static int q(int i10) {
        int i11 = 0;
        while (true) {
            i10 >>= 1;
            if (i10 == 0) {
                return i11;
            }
            i11++;
        }
    }

    public static void r(long j10, byte[] bArr, int i10) {
        Objects.requireNonNull(bArr, "in == null");
        if (bArr.length - i10 < 8) {
            throw new IllegalArgumentException("not enough space in array");
        }
        bArr[i10] = (byte) ((j10 >> 56) & 255);
        bArr[i10 + 1] = (byte) ((j10 >> 48) & 255);
        bArr[i10 + 2] = (byte) ((j10 >> 40) & 255);
        bArr[i10 + 3] = (byte) ((j10 >> 32) & 255);
        bArr[i10 + 4] = (byte) ((j10 >> 24) & 255);
        bArr[i10 + 5] = (byte) ((j10 >> 16) & 255);
        bArr[i10 + 6] = (byte) ((j10 >> 8) & 255);
        bArr[i10 + 7] = (byte) (j10 & 255);
    }

    public static byte[] s(Object obj) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(obj);
        objectOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] t(long j10, int i10) {
        byte[] bArr = new byte[i10];
        for (int i11 = i10 - 1; i11 >= 0; i11--) {
            bArr[i11] = (byte) j10;
            j10 >>>= 8;
        }
        return bArr;
    }
}
