package moe.shizuku.manager.adb;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
public final class g {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @k
    public static final a f41513h = new a(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f41514i = 24;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f41515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f41516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f41517c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f41518d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f41519e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f41520f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @l
    public final byte[] f41521g;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        public final int b(byte[] bArr) {
            if (bArr == 0) {
                return 0;
            }
            int i10 = 0;
            for (int i11 : bArr) {
                if (i11 < 0) {
                    i11 += 256;
                }
                i10 += i11;
            }
            return i10;
        }
    }

    public g(int i10, int i11, int i12, int i13, int i14, int i15, @l byte[] bArr) {
        this.f41515a = i10;
        this.f41516b = i11;
        this.f41517c = i12;
        this.f41518d = i13;
        this.f41519e = i14;
        this.f41520f = i15;
        this.f41521g = bArr;
    }

    public final int a() {
        return this.f41516b;
    }

    public final int b() {
        return this.f41517c;
    }

    public final int c() {
        return this.f41515a;
    }

    @l
    public final byte[] d() {
        return this.f41521g;
    }

    public final int e() {
        return this.f41519e;
    }

    public boolean equals(@l Object obj) {
        if (this == obj) {
            return true;
        }
        if (!f0.g(g.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        f0.n(obj, "null cannot be cast to non-null type moe.shizuku.manager.adb.AdbMessage");
        g gVar = (g) obj;
        if (this.f41515a != gVar.f41515a || this.f41516b != gVar.f41516b || this.f41517c != gVar.f41517c || this.f41518d != gVar.f41518d || this.f41519e != gVar.f41519e || this.f41520f != gVar.f41520f) {
            return false;
        }
        byte[] bArr = this.f41521g;
        if (bArr != null) {
            byte[] bArr2 = gVar.f41521g;
            if (bArr2 == null || !Arrays.equals(bArr, bArr2)) {
                return false;
            }
        } else if (gVar.f41521g != null) {
            return false;
        }
        return true;
    }

    public final int f() {
        return this.f41518d;
    }

    public final int g() {
        return this.f41520f;
    }

    @k
    public final byte[] h() {
        byte[] bArr = this.f41521g;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((bArr != null ? bArr.length : 0) + 24);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        byteBufferAllocate.putInt(this.f41515a);
        byteBufferAllocate.putInt(this.f41516b);
        byteBufferAllocate.putInt(this.f41517c);
        byteBufferAllocate.putInt(this.f41518d);
        byteBufferAllocate.putInt(this.f41519e);
        byteBufferAllocate.putInt(this.f41520f);
        byte[] bArr2 = this.f41521g;
        if (bArr2 != null) {
            byteBufferAllocate.put(bArr2);
        }
        byte[] bArrArray = byteBufferAllocate.array();
        f0.o(bArrArray, "allocate(length).apply {…      }\n        }.array()");
        return bArrArray;
    }

    public int hashCode() {
        int i10 = ((((((((((this.f41515a * 31) + this.f41516b) * 31) + this.f41517c) * 31) + this.f41518d) * 31) + this.f41519e) * 31) + this.f41520f) * 31;
        byte[] bArr = this.f41521g;
        return i10 + (bArr != null ? Arrays.hashCode(bArr) : 0);
    }

    @k
    public final String i() {
        String strValueOf;
        String string;
        int i10 = this.f41515a;
        switch (i10) {
            case 1129208147:
                strValueOf = "A_SYNC";
                break;
            case 1163086915:
                strValueOf = "A_CLSE";
                break;
            case 1163154007:
                strValueOf = "A_WRTE";
                break;
            case 1213486401:
                strValueOf = "A_AUTH";
                break;
            case 1313165391:
                strValueOf = "A_OPEN";
                break;
            case 1314410051:
                strValueOf = "A_CNXN";
                break;
            case i.f41539i /* 1397511251 */:
                strValueOf = "A_STLS";
                break;
            case 1497451343:
                strValueOf = "A_OKAY";
                break;
            default:
                strValueOf = String.valueOf(i10);
                break;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("command=");
        sb2.append(strValueOf);
        sb2.append(", arg0=");
        sb2.append(this.f41516b);
        sb2.append(", arg1=");
        sb2.append(this.f41517c);
        sb2.append(", data_length=");
        sb2.append(this.f41518d);
        sb2.append(", data_crc32=");
        sb2.append(this.f41519e);
        sb2.append(", magic=");
        sb2.append(this.f41520f);
        sb2.append(", data=");
        byte[] bArr = this.f41521g;
        if (bArr != null) {
            string = Arrays.toString(bArr);
            f0.o(string, "toString(this)");
        } else {
            string = null;
        }
        sb2.append(string);
        return sb2.toString();
    }

    public final boolean j() {
        if (this.f41515a != (~this.f41520f)) {
            return false;
        }
        return this.f41518d == 0 || f41513h.b(this.f41521g) == this.f41519e;
    }

    public final void k() {
        if (j()) {
            return;
        }
        throw new IllegalArgumentException("bad message " + i());
    }

    @k
    public String toString() {
        return "AdbMessage(" + i() + ')';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public g(int i10, int i11, int i12, @k String data) {
        f0.p(data, "data");
        byte[] bytes = (data + (char) 0).getBytes(kotlin.text.d.f38161b);
        f0.o(bytes, "this as java.lang.String).getBytes(charset)");
        this(i10, i11, i12, bytes);
    }

    public g(int i10, int i11, int i12, @l byte[] bArr) {
        this(i10, i11, i12, bArr != null ? bArr.length : 0, f41513h.b(bArr), (int) (((long) i10) ^ 4294967295L), bArr);
    }
}
