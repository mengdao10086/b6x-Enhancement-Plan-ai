package org.bouncycastle.crypto.util;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class b implements org.bouncycastle.crypto.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Character, Integer> f44727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<Integer, Character> f44728b;

    public b(String str) {
        this(str.toCharArray());
    }

    public b(char[] cArr) {
        this.f44727a = new HashMap();
        this.f44728b = new HashMap();
        for (int i10 = 0; i10 != cArr.length; i10++) {
            if (this.f44727a.containsKey(Character.valueOf(cArr[i10]))) {
                throw new IllegalArgumentException("duplicate key detected in alphabet: " + cArr[i10]);
            }
            this.f44727a.put(Character.valueOf(cArr[i10]), Integer.valueOf(i10));
            this.f44728b.put(Integer.valueOf(i10), Character.valueOf(cArr[i10]));
        }
    }

    @Override // org.bouncycastle.crypto.a
    public byte[] a(char[] cArr) {
        byte[] bArr;
        int i10 = 0;
        if (this.f44727a.size() <= 256) {
            bArr = new byte[cArr.length];
            while (i10 != cArr.length) {
                bArr[i10] = this.f44727a.get(Character.valueOf(cArr[i10])).byteValue();
                i10++;
            }
        } else {
            bArr = new byte[cArr.length * 2];
            while (i10 != cArr.length) {
                int iIntValue = this.f44727a.get(Character.valueOf(cArr[i10])).intValue();
                int i11 = i10 * 2;
                bArr[i11] = (byte) ((iIntValue >> 8) & 255);
                bArr[i11 + 1] = (byte) (iIntValue & 255);
                i10++;
            }
        }
        return bArr;
    }

    @Override // org.bouncycastle.crypto.a
    public char[] b(byte[] bArr) {
        char[] cArr;
        int i10 = 0;
        if (this.f44728b.size() <= 256) {
            cArr = new char[bArr.length];
            while (i10 != bArr.length) {
                cArr[i10] = this.f44728b.get(Integer.valueOf(bArr[i10] & 255)).charValue();
                i10++;
            }
        } else {
            if ((bArr.length & 1) != 0) {
                throw new IllegalArgumentException("two byte radix and input string odd length");
            }
            cArr = new char[bArr.length / 2];
            while (i10 != bArr.length) {
                cArr[i10 / 2] = this.f44728b.get(Integer.valueOf(((bArr[i10] << 8) & 65280) | (bArr[i10 + 1] & 255))).charValue();
                i10 += 2;
            }
        }
        return cArr;
    }

    @Override // org.bouncycastle.crypto.a
    public int c() {
        return this.f44727a.size();
    }
}
