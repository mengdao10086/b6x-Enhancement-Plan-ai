package androidx.constraintlayout.core.parser;

import com.blankj.utilcode.util.i0;

/* JADX INFO: loaded from: classes2.dex */
public class CLToken extends c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3047h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Type f3048i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public char[] f3049j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public char[] f3050k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public char[] f3051l;

    public enum Type {
        UNKNOWN,
        TRUE,
        FALSE,
        NULL
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3052a;

        static {
            int[] iArr = new int[Type.values().length];
            f3052a = iArr;
            try {
                iArr[Type.TRUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3052a[Type.FALSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3052a[Type.NULL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3052a[Type.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public CLToken(char[] cArr) {
        super(cArr);
        this.f3047h = 0;
        this.f3048i = Type.UNKNOWN;
        this.f3049j = "true".toCharArray();
        this.f3050k = "false".toCharArray();
        this.f3051l = i0.f11859x.toCharArray();
    }

    public static c x(char[] cArr) {
        return new CLToken(cArr);
    }

    public boolean A() throws CLParsingException {
        if (this.f3048i == Type.NULL) {
            return true;
        }
        throw new CLParsingException("this token is not a null: <" + b() + ">", this);
    }

    public boolean B(char c10, long j10) {
        int i10 = a.f3052a[this.f3048i.ordinal()];
        if (i10 == 1) {
            char[] cArr = this.f3049j;
            int i11 = this.f3047h;
            z = cArr[i11] == c10;
            if (z && i11 + 1 == cArr.length) {
                s(j10);
            }
        } else if (i10 == 2) {
            char[] cArr2 = this.f3050k;
            int i12 = this.f3047h;
            z = cArr2[i12] == c10;
            if (z && i12 + 1 == cArr2.length) {
                s(j10);
            }
        } else if (i10 == 3) {
            char[] cArr3 = this.f3051l;
            int i13 = this.f3047h;
            z = cArr3[i13] == c10;
            if (z && i13 + 1 == cArr3.length) {
                s(j10);
            }
        } else if (i10 == 4) {
            char[] cArr4 = this.f3049j;
            int i14 = this.f3047h;
            if (cArr4[i14] == c10) {
                this.f3048i = Type.TRUE;
            } else if (this.f3050k[i14] == c10) {
                this.f3048i = Type.FALSE;
            } else if (this.f3051l[i14] == c10) {
                this.f3048i = Type.NULL;
            }
            z = true;
        }
        this.f3047h++;
        return z;
    }

    @Override // androidx.constraintlayout.core.parser.c
    public String v(int i10, int i11) {
        StringBuilder sb2 = new StringBuilder();
        a(sb2, i10);
        sb2.append(b());
        return sb2.toString();
    }

    @Override // androidx.constraintlayout.core.parser.c
    public String w() {
        if (!CLParser.f3042d) {
            return b();
        }
        return "<" + b() + ">";
    }

    public boolean y() throws CLParsingException {
        Type type = this.f3048i;
        if (type == Type.TRUE) {
            return true;
        }
        if (type == Type.FALSE) {
            return false;
        }
        throw new CLParsingException("this token is not a boolean: <" + b() + ">", this);
    }

    public Type z() {
        return this.f3048i;
    }
}
