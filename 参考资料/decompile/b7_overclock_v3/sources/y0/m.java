package y0;

import java.nio.CharBuffer;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f56204a = new e(null, false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l f56205b = new e(null, true);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final l f56206c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final l f56207d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final l f56208e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final l f56209f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f56210g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f56211h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f56212i = 2;

    public static class a implements c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f56213b = new a(true);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f56214a;

        public a(boolean z10) {
            this.f56214a = z10;
        }

        @Override // y0.m.c
        public int a(CharSequence charSequence, int i10, int i11) {
            int i12 = i11 + i10;
            boolean z10 = false;
            while (i10 < i12) {
                int iA = m.a(Character.getDirectionality(charSequence.charAt(i10)));
                if (iA != 0) {
                    if (iA != 1) {
                        continue;
                        i10++;
                    } else if (!this.f56214a) {
                        return 1;
                    }
                } else if (this.f56214a) {
                    return 0;
                }
                z10 = true;
                i10++;
            }
            if (z10) {
                return this.f56214a ? 1 : 0;
            }
            return 2;
        }
    }

    public static class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f56215a = new b();

        @Override // y0.m.c
        public int a(CharSequence charSequence, int i10, int i11) {
            int i12 = i11 + i10;
            int iB = 2;
            while (i10 < i12 && iB == 2) {
                iB = m.b(Character.getDirectionality(charSequence.charAt(i10)));
                i10++;
            }
            return iB;
        }
    }

    public interface c {
        int a(CharSequence charSequence, int i10, int i11);
    }

    public static abstract class d implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f56216a;

        public d(c cVar) {
            this.f56216a = cVar;
        }

        @Override // y0.l
        public boolean a(char[] cArr, int i10, int i11) {
            return b(CharBuffer.wrap(cArr), i10, i11);
        }

        @Override // y0.l
        public boolean b(CharSequence charSequence, int i10, int i11) {
            if (charSequence == null || i10 < 0 || i11 < 0 || charSequence.length() - i11 < i10) {
                throw new IllegalArgumentException();
            }
            return this.f56216a == null ? c() : d(charSequence, i10, i11);
        }

        public abstract boolean c();

        public final boolean d(CharSequence charSequence, int i10, int i11) {
            int iA = this.f56216a.a(charSequence, i10, i11);
            if (iA == 0) {
                return true;
            }
            if (iA != 1) {
                return c();
            }
            return false;
        }
    }

    public static class e extends d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f56217b;

        public e(c cVar, boolean z10) {
            super(cVar);
            this.f56217b = z10;
        }

        @Override // y0.m.d
        public boolean c() {
            return this.f56217b;
        }
    }

    public static class f extends d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final f f56218b = new f();

        public f() {
            super(null);
        }

        @Override // y0.m.d
        public boolean c() {
            return n.b(Locale.getDefault()) == 1;
        }
    }

    static {
        b bVar = b.f56215a;
        f56206c = new e(bVar, false);
        f56207d = new e(bVar, true);
        f56208e = new e(a.f56213b, false);
        f56209f = f.f56218b;
    }

    public static int a(int i10) {
        if (i10 != 0) {
            return (i10 == 1 || i10 == 2) ? 0 : 2;
        }
        return 1;
    }

    public static int b(int i10) {
        if (i10 != 0) {
            if (i10 == 1 || i10 == 2) {
                return 0;
            }
            switch (i10) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }
}
