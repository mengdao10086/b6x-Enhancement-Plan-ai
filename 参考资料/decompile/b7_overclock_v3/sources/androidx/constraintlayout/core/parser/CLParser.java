package androidx.constraintlayout.core.parser;

/* JADX INFO: loaded from: classes2.dex */
public class CLParser {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f3042d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f3043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3044b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3045c;

    public enum TYPE {
        UNKNOWN,
        OBJECT,
        ARRAY,
        NUMBER,
        STRING,
        KEY,
        TOKEN
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3046a;

        static {
            int[] iArr = new int[TYPE.values().length];
            f3046a = iArr;
            try {
                iArr[TYPE.OBJECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3046a[TYPE.ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3046a[TYPE.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3046a[TYPE.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3046a[TYPE.KEY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3046a[TYPE.TOKEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public CLParser(String str) {
        this.f3043a = str;
    }

    public static f d(String str) throws CLParsingException {
        return new CLParser(str).c();
    }

    public final c a(c cVar, int i10, TYPE type, boolean z10, char[] cArr) {
        c cVarZ;
        if (f3042d) {
            System.out.println("CREATE " + type + " at " + cArr[i10]);
        }
        switch (a.f3046a[type.ordinal()]) {
            case 1:
                cVarZ = f.Z(cArr);
                i10++;
                break;
            case 2:
                cVarZ = androidx.constraintlayout.core.parser.a.y(cArr);
                i10++;
                break;
            case 3:
                cVarZ = g.x(cArr);
                break;
            case 4:
                cVarZ = e.x(cArr);
                break;
            case 5:
                cVarZ = d.y(cArr);
                break;
            case 6:
                cVarZ = CLToken.x(cArr);
                break;
            default:
                cVarZ = null;
                break;
        }
        if (cVarZ == null) {
            return null;
        }
        cVarZ.t(this.f3045c);
        if (z10) {
            cVarZ.u(i10);
        }
        if (cVar instanceof b) {
            cVarZ.r((b) cVar);
        }
        return cVarZ;
    }

    public final c b(int i10, char c10, c cVar, char[] cArr) throws CLParsingException {
        if (c10 == '\t' || c10 == '\n' || c10 == '\r' || c10 == ' ') {
            return cVar;
        }
        if (c10 == '\"' || c10 == '\'') {
            return cVar instanceof f ? a(cVar, i10, TYPE.KEY, true, cArr) : a(cVar, i10, TYPE.STRING, true, cArr);
        }
        if (c10 == '[') {
            return a(cVar, i10, TYPE.ARRAY, true, cArr);
        }
        if (c10 != ']') {
            if (c10 == '{') {
                return a(cVar, i10, TYPE.OBJECT, true, cArr);
            }
            if (c10 != '}') {
                switch (c10) {
                    case '+':
                    case '-':
                    case '.':
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                        return a(cVar, i10, TYPE.NUMBER, true, cArr);
                    case ',':
                    case ':':
                        return cVar;
                    case '/':
                        int i11 = i10 + 1;
                        if (i11 >= cArr.length || cArr[i11] != '/') {
                            return cVar;
                        }
                        this.f3044b = true;
                        return cVar;
                    default:
                        if (!(cVar instanceof b) || (cVar instanceof f)) {
                            return a(cVar, i10, TYPE.KEY, true, cArr);
                        }
                        c cVarA = a(cVar, i10, TYPE.TOKEN, true, cArr);
                        CLToken cLToken = (CLToken) cVarA;
                        if (cLToken.B(c10, i10)) {
                            return cVarA;
                        }
                        throw new CLParsingException("incorrect token <" + c10 + "> at line " + this.f3045c, cLToken);
                }
            }
        }
        cVar.s(i10 - 1);
        c cVarD = cVar.d();
        cVarD.s(i10);
        return cVarD;
    }

    public f c() throws CLParsingException {
        char[] charArray = this.f3043a.toCharArray();
        int length = charArray.length;
        int i10 = 1;
        this.f3045c = 1;
        boolean z10 = false;
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                i11 = -1;
                break;
            }
            char c10 = charArray[i11];
            if (c10 == '{') {
                break;
            }
            if (c10 == '\n') {
                this.f3045c++;
            }
            i11++;
        }
        if (i11 == -1) {
            throw new CLParsingException("invalid json content", null);
        }
        f fVarZ = f.Z(charArray);
        fVarZ.t(this.f3045c);
        fVarZ.u(i11);
        int i12 = i11 + 1;
        c cVarD = fVarZ;
        while (i12 < length) {
            char c11 = charArray[i12];
            if (c11 == '\n') {
                this.f3045c += i10;
            }
            if (this.f3044b) {
                if (c11 == '\n') {
                    this.f3044b = z10;
                } else {
                    continue;
                    i12++;
                    i10 = 1;
                    z10 = false;
                }
            }
            if (cVarD == null) {
                break;
            }
            if (cVarD.o()) {
                cVarD = b(i12, c11, cVarD, charArray);
            } else if (cVarD instanceof f) {
                if (c11 == '}') {
                    cVarD.s(i12 - 1);
                } else {
                    cVarD = b(i12, c11, cVarD, charArray);
                }
            } else if (!(cVarD instanceof androidx.constraintlayout.core.parser.a)) {
                boolean z11 = cVarD instanceof g;
                if (z11) {
                    long j10 = cVarD.f3057b;
                    if (charArray[(int) j10] == c11) {
                        cVarD.u(j10 + 1);
                        cVarD.s(i12 - 1);
                    }
                } else {
                    if (cVarD instanceof CLToken) {
                        CLToken cLToken = (CLToken) cVarD;
                        if (!cLToken.B(c11, i12)) {
                            throw new CLParsingException("parsing incorrect token " + cLToken.b() + " at line " + this.f3045c, cLToken);
                        }
                    }
                    if ((cVarD instanceof d) || z11) {
                        long j11 = cVarD.f3057b;
                        char c12 = charArray[(int) j11];
                        if ((c12 == '\'' || c12 == '\"') && c12 == c11) {
                            cVarD.u(j11 + 1);
                            cVarD.s(i12 - 1);
                        }
                    }
                    if (!cVarD.o() && (c11 == '}' || c11 == ']' || c11 == ',' || c11 == ' ' || c11 == '\t' || c11 == '\r' || c11 == '\n' || c11 == ':')) {
                        long j12 = i12 - 1;
                        cVarD.s(j12);
                        if (c11 == '}' || c11 == ']') {
                            cVarD = cVarD.d();
                            cVarD.s(j12);
                            if (cVarD instanceof d) {
                                cVarD = cVarD.d();
                                cVarD.s(j12);
                            }
                        }
                    }
                }
            } else if (c11 == ']') {
                cVarD.s(i12 - 1);
            } else {
                cVarD = b(i12, c11, cVarD, charArray);
            }
            if (cVarD.o() && (!(cVarD instanceof d) || ((d) cVarD).f3053h.size() > 0)) {
                cVarD = cVarD.d();
            }
            i12++;
            i10 = 1;
            z10 = false;
        }
        while (cVarD != null && !cVarD.o()) {
            if (cVarD instanceof g) {
                cVarD.u(((int) cVarD.f3057b) + 1);
            }
            cVarD.s(length - 1);
            cVarD = cVarD.d();
        }
        if (f3042d) {
            System.out.println("Root: " + fVarZ.w());
        }
        return fVarZ;
    }
}
