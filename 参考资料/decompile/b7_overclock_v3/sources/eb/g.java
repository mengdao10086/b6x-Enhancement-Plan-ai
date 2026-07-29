package eb;

import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import eb.f;
import g.p0;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes3.dex */
public abstract class g<I extends DecoderInputBuffer, O extends f, E extends DecoderException> implements c<I, O, E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Thread f26795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f26796b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayDeque<I> f26797c = new ArrayDeque<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayDeque<O> f26798d = new ArrayDeque<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final I[] f26799e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final O[] f26800f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f26801g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f26802h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public I f26803i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public E f26804j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f26805k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f26806l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f26807m;

    public class a extends Thread {
        public a(String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            g.this.t();
        }
    }

    public g(I[] iArr, O[] oArr) {
        this.f26799e = iArr;
        this.f26801g = iArr.length;
        for (int i10 = 0; i10 < this.f26801g; i10++) {
            ((I[]) this.f26799e)[i10] = g();
        }
        this.f26800f = oArr;
        this.f26802h = oArr.length;
        for (int i11 = 0; i11 < this.f26802h; i11++) {
            ((O[]) this.f26800f)[i11] = h();
        }
        a aVar = new a("ExoPlayer:SimpleDecoder");
        this.f26795a = aVar;
        aVar.start();
    }

    public final boolean f() {
        return !this.f26797c.isEmpty() && this.f26802h > 0;
    }

    @Override // eb.c
    public final void flush() {
        synchronized (this.f26796b) {
            this.f26805k = true;
            this.f26807m = 0;
            I i10 = this.f26803i;
            if (i10 != null) {
                q(i10);
                this.f26803i = null;
            }
            while (!this.f26797c.isEmpty()) {
                q(this.f26797c.removeFirst());
            }
            while (!this.f26798d.isEmpty()) {
                this.f26798d.removeFirst().p();
            }
        }
    }

    public abstract I g();

    public abstract O h();

    public abstract E i(Throwable th2);

    @p0
    public abstract E j(I i10, O o10, boolean z10);

    public final boolean k() throws InterruptedException {
        E e10;
        synchronized (this.f26796b) {
            while (!this.f26806l && !f()) {
                this.f26796b.wait();
            }
            if (this.f26806l) {
                return false;
            }
            I iRemoveFirst = this.f26797c.removeFirst();
            O[] oArr = this.f26800f;
            int i10 = this.f26802h - 1;
            this.f26802h = i10;
            O o10 = oArr[i10];
            boolean z10 = this.f26805k;
            this.f26805k = false;
            if (iRemoveFirst.m()) {
                o10.g(4);
            } else {
                if (iRemoveFirst.l()) {
                    o10.g(Integer.MIN_VALUE);
                }
                try {
                    e10 = (E) j(iRemoveFirst, o10, z10);
                } catch (OutOfMemoryError e11) {
                    e10 = (E) i(e11);
                } catch (RuntimeException e12) {
                    e10 = (E) i(e12);
                }
                if (e10 != null) {
                    synchronized (this.f26796b) {
                        this.f26804j = e10;
                    }
                    return false;
                }
            }
            synchronized (this.f26796b) {
                if (this.f26805k) {
                    o10.p();
                } else if (o10.l()) {
                    this.f26807m++;
                    o10.p();
                } else {
                    o10.f26794c = this.f26807m;
                    this.f26807m = 0;
                    this.f26798d.addLast(o10);
                }
                q(iRemoveFirst);
            }
            return true;
        }
    }

    @Override // eb.c
    @p0
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public final I c() throws DecoderException {
        I i10;
        synchronized (this.f26796b) {
            o();
            hd.a.i(this.f26803i == null);
            int i11 = this.f26801g;
            if (i11 == 0) {
                i10 = null;
            } else {
                I[] iArr = this.f26799e;
                int i12 = i11 - 1;
                this.f26801g = i12;
                i10 = iArr[i12];
            }
            this.f26803i = i10;
        }
        return i10;
    }

    @Override // eb.c
    @p0
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public final O b() throws DecoderException {
        synchronized (this.f26796b) {
            o();
            if (this.f26798d.isEmpty()) {
                return null;
            }
            return this.f26798d.removeFirst();
        }
    }

    public final void n() {
        if (f()) {
            this.f26796b.notify();
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: E extends com.google.android.exoplayer2.decoder.DecoderException */
    public final void o() throws E, DecoderException {
        E e10 = this.f26804j;
        if (e10 != null) {
            throw e10;
        }
    }

    @Override // eb.c
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public final void d(I i10) throws DecoderException {
        synchronized (this.f26796b) {
            o();
            hd.a.a(i10 == this.f26803i);
            this.f26797c.addLast(i10);
            n();
            this.f26803i = null;
        }
    }

    public final void q(I i10) {
        i10.h();
        I[] iArr = this.f26799e;
        int i11 = this.f26801g;
        this.f26801g = i11 + 1;
        iArr[i11] = i10;
    }

    @g.i
    public void r(O o10) {
        synchronized (this.f26796b) {
            s(o10);
            n();
        }
    }

    @Override // eb.c
    @g.i
    public void release() {
        synchronized (this.f26796b) {
            this.f26806l = true;
            this.f26796b.notify();
        }
        try {
            this.f26795a.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    public final void s(O o10) {
        o10.h();
        O[] oArr = this.f26800f;
        int i10 = this.f26802h;
        this.f26802h = i10 + 1;
        oArr[i10] = o10;
    }

    public final void t() {
        do {
            try {
            } catch (InterruptedException e10) {
                throw new IllegalStateException(e10);
            }
        } while (k());
    }

    public final void u(int i10) {
        hd.a.i(this.f26801g == this.f26799e.length);
        for (I i11 : this.f26799e) {
            i11.q(i10);
        }
    }
}
