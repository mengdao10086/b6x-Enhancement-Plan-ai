package okio;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000:\n\u0002\u0010\u0012\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0000*\u00020\u0001H\u0000\u001a/\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0080\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\n*\n\u0010\f\"\u00020\u000b2\u00020\u000b*\n\u0010\u000e\"\u00020\r2\u00020\r*\n\u0010\u0010\"\u00020\u000f2\u00020\u000f*\n\u0010\u0012\"\u00020\u00112\u00020\u0011*\n\u0010\u0014\"\u00020\u00132\u00020\u0013\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0015"}, d2 = {"", "", "c", "a", "R", "", "lock", "Lkotlin/Function0;", "block", "b", "(Ljava/lang/Object;Lik/a;)Ljava/lang/Object;", "Ljava/lang/ArrayIndexOutOfBoundsException;", "ArrayIndexOutOfBoundsException", "Ljava/io/Closeable;", "Closeable", "Ljava/io/EOFException;", "EOFException", "Ljava/io/FileNotFoundException;", "FileNotFoundException", "Ljava/io/IOException;", "IOException", "okio"}, k = 2, mv = {1, 5, 1})
public final class z0 {
    @yt.k
    public static final byte[] a(@yt.k String str) {
        kotlin.jvm.internal.f0.p(str, "<this>");
        byte[] bytes = str.getBytes(kotlin.text.d.f38161b);
        kotlin.jvm.internal.f0.o(bytes, "(this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    public static final <R> R b(@yt.k Object lock, @yt.k ik.a<? extends R> block) {
        R rO;
        kotlin.jvm.internal.f0.p(lock, "lock");
        kotlin.jvm.internal.f0.p(block, "block");
        synchronized (lock) {
            try {
                rO = block.o();
                kotlin.jvm.internal.c0.d(1);
            } catch (Throwable th2) {
                kotlin.jvm.internal.c0.d(1);
                kotlin.jvm.internal.c0.c(1);
                throw th2;
            }
        }
        kotlin.jvm.internal.c0.c(1);
        return rO;
    }

    @yt.k
    public static final String c(@yt.k byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        return new String(bArr, kotlin.text.d.f38161b);
    }
}
