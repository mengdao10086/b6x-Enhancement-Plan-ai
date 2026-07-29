package gc;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
public interface n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f29217a = new a();

    public class a implements n {
        @Override // gc.n
        public long a() {
            throw new NoSuchElementException();
        }

        @Override // gc.n
        public boolean b() {
            return true;
        }

        @Override // gc.n
        public com.google.android.exoplayer2.upstream.b c() {
            throw new NoSuchElementException();
        }

        @Override // gc.n
        public long d() {
            throw new NoSuchElementException();
        }

        @Override // gc.n
        public boolean next() {
            return false;
        }

        @Override // gc.n
        public void reset() {
        }
    }

    long a();

    boolean b();

    com.google.android.exoplayer2.upstream.b c();

    long d();

    boolean next();

    void reset();
}
