package com.tencent.open.log;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public class f implements Iterable<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ConcurrentLinkedQueue<String> f22781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AtomicInteger f22782b;

    public f() {
        this.f22781a = null;
        this.f22782b = null;
        this.f22781a = new ConcurrentLinkedQueue<>();
        this.f22782b = new AtomicInteger(0);
    }

    public int a(String str) {
        int length = str.length();
        this.f22781a.add(str);
        return this.f22782b.addAndGet(length);
    }

    public void b() {
        this.f22781a.clear();
        this.f22782b.set(0);
    }

    @Override // java.lang.Iterable
    public Iterator<String> iterator() {
        return this.f22781a.iterator();
    }

    public void a(Writer[] writerArr, char[] cArr) throws IOException {
        if (writerArr == null || cArr == null || cArr.length == 0 || writerArr.length < 2) {
            return;
        }
        Writer writer = writerArr[0];
        Writer writer2 = writerArr[1];
        int length = cArr.length;
        int i10 = length;
        int i11 = 0;
        for (String str : this) {
            int length2 = str.length();
            int i12 = 0;
            while (length2 > 0) {
                int i13 = i10 > length2 ? length2 : i10;
                int i14 = i12 + i13;
                str.getChars(i12, i14, cArr, i11);
                i10 -= i13;
                i11 += i13;
                length2 -= i13;
                if (i10 == 0) {
                    if (writer != null) {
                        try {
                            writer.write(cArr, 0, length);
                        } catch (Exception unused) {
                        }
                    }
                    if (writer2 != null) {
                        try {
                            writer2.write(cArr, 0, length);
                        } catch (Exception unused2) {
                        }
                    }
                    i10 = length;
                    i12 = i14;
                    i11 = 0;
                } else {
                    i12 = i14;
                }
            }
        }
        if (i11 > 0) {
            if (writer != null) {
                try {
                    writer.write(cArr, 0, i11);
                } catch (Exception unused3) {
                }
            }
            if (writer2 != null) {
                try {
                    writer2.write(cArr, 0, i11);
                } catch (Exception unused4) {
                }
            }
        }
        if (writer != null) {
            try {
                writer.flush();
            } catch (Exception unused5) {
            }
        }
        if (writer2 != null) {
            try {
                writer2.flush();
            } catch (Exception unused6) {
            }
        }
    }

    public int a() {
        return this.f22782b.get();
    }
}
