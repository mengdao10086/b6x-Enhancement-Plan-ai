package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes5.dex */
public final class f implements kotlin.sequences.m<qk.m> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final CharSequence f38170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f38171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f38172c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final ik.p<CharSequence, Integer, Pair<Integer, Integer>> f38173d;

    public static final class a implements Iterator<qk.m>, jk.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f38174a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f38175b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f38176c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @yt.l
        public qk.m f38177d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f38178e;

        public a() {
            int I = qk.v.I(f.this.f38171b, 0, f.this.f38170a.length());
            this.f38175b = I;
            this.f38176c = I;
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void a() {
            /*
                r6 = this;
                int r0 = r6.f38176c
                r1 = 0
                if (r0 >= 0) goto Lc
                r6.f38174a = r1
                r0 = 0
                r6.f38177d = r0
                goto L9e
            Lc:
                kotlin.text.f r0 = kotlin.text.f.this
                int r0 = kotlin.text.f.e(r0)
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L23
                int r0 = r6.f38178e
                int r0 = r0 + r3
                r6.f38178e = r0
                kotlin.text.f r4 = kotlin.text.f.this
                int r4 = kotlin.text.f.e(r4)
                if (r0 >= r4) goto L31
            L23:
                int r0 = r6.f38176c
                kotlin.text.f r4 = kotlin.text.f.this
                java.lang.CharSequence r4 = kotlin.text.f.d(r4)
                int r4 = r4.length()
                if (r0 <= r4) goto L47
            L31:
                qk.m r0 = new qk.m
                int r1 = r6.f38175b
                kotlin.text.f r4 = kotlin.text.f.this
                java.lang.CharSequence r4 = kotlin.text.f.d(r4)
                int r4 = kotlin.text.StringsKt__StringsKt.j3(r4)
                r0.<init>(r1, r4)
                r6.f38177d = r0
                r6.f38176c = r2
                goto L9c
            L47:
                kotlin.text.f r0 = kotlin.text.f.this
                ik.p r0 = kotlin.text.f.c(r0)
                kotlin.text.f r4 = kotlin.text.f.this
                java.lang.CharSequence r4 = kotlin.text.f.d(r4)
                int r5 = r6.f38176c
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.r0(r4, r5)
                kotlin.Pair r0 = (kotlin.Pair) r0
                if (r0 != 0) goto L77
                qk.m r0 = new qk.m
                int r1 = r6.f38175b
                kotlin.text.f r4 = kotlin.text.f.this
                java.lang.CharSequence r4 = kotlin.text.f.d(r4)
                int r4 = kotlin.text.StringsKt__StringsKt.j3(r4)
                r0.<init>(r1, r4)
                r6.f38177d = r0
                r6.f38176c = r2
                goto L9c
            L77:
                java.lang.Object r2 = r0.a()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.b()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.f38175b
                qk.m r4 = qk.v.W1(r4, r2)
                r6.f38177d = r4
                int r2 = r2 + r0
                r6.f38175b = r2
                if (r0 != 0) goto L99
                r1 = 1
            L99:
                int r2 = r2 + r1
                r6.f38176c = r2
            L9c:
                r6.f38174a = r3
            L9e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.text.f.a.a():void");
        }

        public final int b() {
            return this.f38178e;
        }

        public final int d() {
            return this.f38175b;
        }

        @yt.l
        public final qk.m e() {
            return this.f38177d;
        }

        public final int g() {
            return this.f38176c;
        }

        public final int h() {
            return this.f38174a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f38174a == -1) {
                a();
            }
            return this.f38174a == 1;
        }

        @Override // java.util.Iterator
        @yt.k
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public qk.m next() {
            if (this.f38174a == -1) {
                a();
            }
            if (this.f38174a == 0) {
                throw new NoSuchElementException();
            }
            qk.m mVar = this.f38177d;
            f0.n(mVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.f38177d = null;
            this.f38174a = -1;
            return mVar;
        }

        public final void k(int i10) {
            this.f38178e = i10;
        }

        public final void l(int i10) {
            this.f38175b = i10;
        }

        public final void m(@yt.l qk.m mVar) {
            this.f38177d = mVar;
        }

        public final void n(int i10) {
            this.f38176c = i10;
        }

        public final void o(int i10) {
            this.f38174a = i10;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(@yt.k CharSequence input, int i10, int i11, @yt.k ik.p<? super CharSequence, ? super Integer, Pair<Integer, Integer>> getNextMatch) {
        f0.p(input, "input");
        f0.p(getNextMatch, "getNextMatch");
        this.f38170a = input;
        this.f38171b = i10;
        this.f38172c = i11;
        this.f38173d = getNextMatch;
    }

    @Override // kotlin.sequences.m
    @yt.k
    public Iterator<qk.m> iterator() {
        return new a();
    }
}
