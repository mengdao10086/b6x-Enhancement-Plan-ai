package kotlin.text;

import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlin.text.Regex$splitToSequence$1", f = "Regex.kt", i = {1, 1, 1}, l = {276, 284, 288}, m = "invokeSuspend", n = {"$this$sequence", "matcher", "splitCount"}, s = {"L$0", "L$1", "I$0"})
public final class Regex$splitToSequence$1 extends RestrictedSuspendLambda implements ik.p<kotlin.sequences.o<? super String>, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ CharSequence $input;
    public final /* synthetic */ int $limit;
    public int I$0;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public int label;
    public final /* synthetic */ Regex this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Regex$splitToSequence$1(Regex regex, CharSequence charSequence, int i10, kotlin.coroutines.c<? super Regex$splitToSequence$1> cVar) {
        super(2, cVar);
        this.this$0 = regex;
        this.$input = charSequence;
        this.$limit = i10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        Regex$splitToSequence$1 regex$splitToSequence$1 = new Regex$splitToSequence$1(this.this$0, this.$input, this.$limit, cVar);
        regex$splitToSequence$1.L$0 = obj;
        return regex$splitToSequence$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0072 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009e A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0070 -> B:21:0x0073). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object q0(@yt.k java.lang.Object r11) throws java.lang.Throwable {
        /*
            r10 = this;
            java.lang.Object r0 = yj.b.h()
            int r1 = r10.label
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L35
            if (r1 == r5) goto L30
            if (r1 == r4) goto L1f
            if (r1 != r3) goto L17
            kotlin.u0.n(r11)
            goto L9f
        L17:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L1f:
            int r1 = r10.I$0
            java.lang.Object r2 = r10.L$1
            java.util.regex.Matcher r2 = (java.util.regex.Matcher) r2
            java.lang.Object r6 = r10.L$0
            kotlin.sequences.o r6 = (kotlin.sequences.o) r6
            kotlin.u0.n(r11)
            r7 = r10
            r11 = r1
            r1 = r2
            goto L73
        L30:
            kotlin.u0.n(r11)
            goto Lb1
        L35:
            kotlin.u0.n(r11)
            java.lang.Object r11 = r10.L$0
            kotlin.sequences.o r11 = (kotlin.sequences.o) r11
            kotlin.text.Regex r1 = r10.this$0
            java.util.regex.Pattern r1 = kotlin.text.Regex.a(r1)
            java.lang.CharSequence r6 = r10.$input
            java.util.regex.Matcher r1 = r1.matcher(r6)
            int r6 = r10.$limit
            if (r6 == r5) goto La2
            boolean r6 = r1.find()
            if (r6 != 0) goto L53
            goto La2
        L53:
            r7 = r10
            r6 = r11
            r11 = 0
        L56:
            java.lang.CharSequence r8 = r7.$input
            int r9 = r1.start()
            java.lang.CharSequence r2 = r8.subSequence(r2, r9)
            java.lang.String r2 = r2.toString()
            r7.L$0 = r6
            r7.L$1 = r1
            r7.I$0 = r11
            r7.label = r4
            java.lang.Object r2 = r6.a(r2, r7)
            if (r2 != r0) goto L73
            return r0
        L73:
            int r2 = r1.end()
            int r11 = r11 + r5
            int r8 = r7.$limit
            int r8 = r8 - r5
            if (r11 == r8) goto L83
            boolean r8 = r1.find()
            if (r8 != 0) goto L56
        L83:
            java.lang.CharSequence r11 = r7.$input
            int r1 = r11.length()
            java.lang.CharSequence r11 = r11.subSequence(r2, r1)
            java.lang.String r11 = r11.toString()
            r1 = 0
            r7.L$0 = r1
            r7.L$1 = r1
            r7.label = r3
            java.lang.Object r11 = r6.a(r11, r7)
            if (r11 != r0) goto L9f
            return r0
        L9f:
            kotlin.z1 r11 = kotlin.z1.f38230a
            return r11
        La2:
            java.lang.CharSequence r1 = r10.$input
            java.lang.String r1 = r1.toString()
            r10.label = r5
            java.lang.Object r11 = r11.a(r1, r10)
            if (r11 != r0) goto Lb1
            return r0
        Lb1:
            kotlin.z1 r11 = kotlin.z1.f38230a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex$splitToSequence$1.q0(java.lang.Object):java.lang.Object");
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: v0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k kotlin.sequences.o<? super String> oVar, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        return ((Regex$splitToSequence$1) M(oVar, cVar)).q0(z1.f38230a);
    }
}
