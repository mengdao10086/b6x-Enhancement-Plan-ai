package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ByteBuffer f5503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5504c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5505d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Utf8 f5506e = Utf8.d();

    public class a implements Comparator<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ByteBuffer f5507a;

        public a(ByteBuffer byteBuffer) {
            this.f5507a = byteBuffer;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Integer num, Integer num2) {
            return u.this.s(num, num2, this.f5507a);
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

    public static u k(u uVar, int i10, ByteBuffer byteBuffer) {
        uVar.g(c(i10, byteBuffer), byteBuffer);
        return uVar;
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
        return i10 + this.f5503b.getInt(i10);
    }

    public int d(int i10) {
        if (i10 < this.f5505d) {
            return this.f5503b.getShort(this.f5504c + i10);
        }
        return 0;
    }

    public void f() {
        g(0, null);
    }

    public void g(int i10, ByteBuffer byteBuffer) {
        this.f5503b = byteBuffer;
        if (byteBuffer == null) {
            this.f5502a = 0;
            this.f5504c = 0;
            this.f5505d = 0;
        } else {
            this.f5502a = i10;
            int i11 = i10 - byteBuffer.getInt(i10);
            this.f5504c = i11;
            this.f5505d = this.f5503b.getShort(i11);
        }
    }

    public String h(int i10) {
        return i(i10, this.f5503b, this.f5506e);
    }

    public u j(u uVar, int i10) {
        return k(uVar, i10, this.f5503b);
    }

    public int l(int i10) {
        int i11 = i10 + this.f5502a;
        return i11 + this.f5503b.getInt(i11) + 4;
    }

    public ByteBuffer m(int i10, int i11) {
        int iD = d(i10);
        if (iD == 0) {
            return null;
        }
        ByteBuffer byteBufferOrder = this.f5503b.duplicate().order(ByteOrder.LITTLE_ENDIAN);
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
        int i11 = i10 + this.f5502a;
        return this.f5503b.getInt(i11 + this.f5503b.getInt(i11));
    }

    public ByteBuffer r() {
        return this.f5503b;
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
