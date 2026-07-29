package io.objectbox.flatbuffers;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes5.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f32762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ByteBuffer f32763b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f32764c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f32765d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Utf8 f32766e = Utf8.e();

    public class a implements Comparator<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ByteBuffer f32767a;

        public a(ByteBuffer byteBuffer) {
            this.f32767a = byteBuffer;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Integer num, Integer num2) {
            return s.this.s(num, num2, this.f32767a);
        }
    }

    public static boolean a(ByteBuffer byteBuffer, String str) {
        if (str.length() != 4) {
            throw new AssertionError("FlatBuffers: file identifier must be length 4");
        }
        for (int i10 = 0; i10 < 4; i10++) {
            if (str.charAt(i10) != ((char) byteBuffer.get(byteBuffer.position() + 4 + i10))) {
                return false;
            }
        }
        return true;
    }

    public static int c(int i10, ByteBuffer byteBuffer) {
        return i10 + byteBuffer.getInt(i10);
    }

    public static int e(int i10, int i11, ByteBuffer byteBuffer) {
        int iCapacity = byteBuffer.capacity() - i11;
        return byteBuffer.getShort((i10 + iCapacity) - byteBuffer.getInt(iCapacity)) + iCapacity;
    }

    public static String i(int i10, ByteBuffer byteBuffer, Utf8 utf8) {
        int i11 = i10 + byteBuffer.getInt(i10);
        return utf8.a(byteBuffer, i11 + 4, byteBuffer.getInt(i11));
    }

    public static s k(s sVar, int i10, ByteBuffer byteBuffer) {
        sVar.g(c(i10, byteBuffer), byteBuffer);
        return sVar;
    }

    public static int p(int i10, int i11, ByteBuffer byteBuffer) {
        int i12 = i10 + byteBuffer.getInt(i10);
        int i13 = i11 + byteBuffer.getInt(i11);
        int i14 = byteBuffer.getInt(i12);
        int i15 = byteBuffer.getInt(i13);
        int i16 = i12 + 4;
        int i17 = i13 + 4;
        int iMin = Math.min(i14, i15);
        for (int i18 = 0; i18 < iMin; i18++) {
            int i19 = i18 + i16;
            int i20 = i18 + i17;
            if (byteBuffer.get(i19) != byteBuffer.get(i20)) {
                return byteBuffer.get(i19) - byteBuffer.get(i20);
            }
        }
        return i14 - i15;
    }

    public static int q(int i10, byte[] bArr, ByteBuffer byteBuffer) {
        int i11 = i10 + byteBuffer.getInt(i10);
        int i12 = byteBuffer.getInt(i11);
        int length = bArr.length;
        int i13 = i11 + 4;
        int iMin = Math.min(i12, length);
        for (int i14 = 0; i14 < iMin; i14++) {
            int i15 = i14 + i13;
            if (byteBuffer.get(i15) != bArr[i14]) {
                return byteBuffer.get(i15) - bArr[i14];
            }
        }
        return i12 - length;
    }

    public int b(int i10) {
        return i10 + this.f32763b.getInt(i10);
    }

    public int d(int i10) {
        if (i10 < this.f32765d) {
            return this.f32763b.getShort(this.f32764c + i10);
        }
        return 0;
    }

    public void f() {
        g(0, null);
    }

    public void g(int i10, ByteBuffer byteBuffer) {
        this.f32763b = byteBuffer;
        if (byteBuffer == null) {
            this.f32762a = 0;
            this.f32764c = 0;
            this.f32765d = 0;
        } else {
            this.f32762a = i10;
            int i11 = i10 - byteBuffer.getInt(i10);
            this.f32764c = i11;
            this.f32765d = this.f32763b.getShort(i11);
        }
    }

    public String h(int i10) {
        return i(i10, this.f32763b, this.f32766e);
    }

    public s j(s sVar, int i10) {
        return k(sVar, i10, this.f32763b);
    }

    public int l(int i10) {
        int i11 = i10 + this.f32762a;
        return i11 + this.f32763b.getInt(i11) + 4;
    }

    public ByteBuffer m(int i10, int i11) {
        int iD = d(i10);
        if (iD == 0) {
            return null;
        }
        ByteBuffer byteBufferOrder = this.f32763b.duplicate().order(ByteOrder.LITTLE_ENDIAN);
        int iL = l(iD);
        byteBufferOrder.position(iL);
        byteBufferOrder.limit(iL + (o(iD) * i11));
        return byteBufferOrder;
    }

    public ByteBuffer n(ByteBuffer byteBuffer, int i10, int i11) {
        int iD = d(i10);
        if (iD == 0) {
            return null;
        }
        int iL = l(iD);
        byteBuffer.rewind();
        byteBuffer.limit((o(iD) * i11) + iL);
        byteBuffer.position(iL);
        return byteBuffer;
    }

    public int o(int i10) {
        int i11 = i10 + this.f32762a;
        return this.f32763b.getInt(i11 + this.f32763b.getInt(i11));
    }

    public ByteBuffer r() {
        return this.f32763b;
    }

    public int s(Integer num, Integer num2, ByteBuffer byteBuffer) {
        return 0;
    }

    public void t(int[] iArr, ByteBuffer byteBuffer) {
        Integer[] numArr = new Integer[iArr.length];
        for (int i10 = 0; i10 < iArr.length; i10++) {
            numArr[i10] = Integer.valueOf(iArr[i10]);
        }
        Arrays.sort(numArr, new a(byteBuffer));
        for (int i11 = 0; i11 < iArr.length; i11++) {
            iArr[i11] = numArr[i11].intValue();
        }
    }
}
