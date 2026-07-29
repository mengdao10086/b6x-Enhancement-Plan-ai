package kotlin.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes5.dex */
public final class m implements kotlin.sequences.m<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final BufferedReader f37822a;

    public static final class a implements Iterator<String>, jk.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.l
        public String f37823a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f37824b;

        public a() {
        }

        @Override // java.util.Iterator
        @yt.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            String str = this.f37823a;
            this.f37823a = null;
            f0.m(str);
            return str;
        }

        @Override // java.util.Iterator
        public boolean hasNext() throws IOException {
            if (this.f37823a == null && !this.f37824b) {
                String line = m.this.f37822a.readLine();
                this.f37823a = line;
                if (line == null) {
                    this.f37824b = true;
                }
            }
            return this.f37823a != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public m(@yt.k BufferedReader reader) {
        f0.p(reader, "reader");
        this.f37822a = reader;
    }

    @Override // kotlin.sequences.m
    @yt.k
    public Iterator<String> iterator() {
        return new a();
    }
}
