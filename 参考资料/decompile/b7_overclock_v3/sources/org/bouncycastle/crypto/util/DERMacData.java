package org.bouncycastle.crypto.util;

import gm.n2;
import gm.z;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes5.dex */
public final class DERMacData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f44708a;

    public enum Type {
        UNILATERALU("KC_1_U"),
        UNILATERALV("KC_1_V"),
        BILATERALU("KC_2_U"),
        BILATERALV("KC_2_V");

        private final String enc;

        Type(String str) {
            this.enc = str;
        }

        public byte[] getHeader() {
            return Strings.i(this.enc);
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f44709a;

        static {
            int[] iArr = new int[Type.values().length];
            f44709a = iArr;
            try {
                iArr[Type.UNILATERALU.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f44709a[Type.BILATERALU.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f44709a[Type.UNILATERALV.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f44709a[Type.BILATERALV.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Type f44710a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public z f44711b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public z f44712c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public z f44713d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public z f44714e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public byte[] f44715f;

        public b(Type type, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
            this.f44710a = type;
            this.f44711b = DerUtil.a(bArr);
            this.f44712c = DerUtil.a(bArr2);
            this.f44713d = DerUtil.a(bArr3);
            this.f44714e = DerUtil.a(bArr4);
        }

        public DERMacData a() {
            int i10 = a.f44709a[this.f44710a.ordinal()];
            a aVar = null;
            if (i10 == 1 || i10 == 2) {
                return new DERMacData(b(this.f44710a.getHeader(), DerUtil.b(this.f44711b), DerUtil.b(this.f44712c), DerUtil.b(this.f44713d), DerUtil.b(this.f44714e), this.f44715f), aVar);
            }
            if (i10 == 3 || i10 == 4) {
                return new DERMacData(b(this.f44710a.getHeader(), DerUtil.b(this.f44712c), DerUtil.b(this.f44711b), DerUtil.b(this.f44714e), DerUtil.b(this.f44713d), this.f44715f), aVar);
            }
            throw new IllegalStateException("Unknown type encountered in build");
        }

        public final byte[] b(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6) {
            return org.bouncycastle.util.a.B(org.bouncycastle.util.a.C(bArr, bArr2, bArr3), org.bouncycastle.util.a.C(bArr4, bArr5, bArr6));
        }

        public b c(byte[] bArr) {
            this.f44715f = DerUtil.b(new n2(false, 0, (gm.h) DerUtil.a(bArr)));
            return this;
        }
    }

    public DERMacData(byte[] bArr) {
        this.f44708a = bArr;
    }

    public /* synthetic */ DERMacData(byte[] bArr, a aVar) {
        this(bArr);
    }

    public byte[] a() {
        return org.bouncycastle.util.a.p(this.f44708a);
    }
}
