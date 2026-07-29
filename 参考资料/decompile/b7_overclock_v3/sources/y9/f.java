package y9;

import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.v1;
import y9.c;

/* JADX INFO: loaded from: classes3.dex */
public class f implements Closeable, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f56550a = 1179403647;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FileChannel f56551b;

    public f(final File file) throws FileNotFoundException {
        if (file == null || !file.exists()) {
            throw new IllegalArgumentException("File is null or does not exist");
        }
        this.f56551b = new FileInputStream(file).getChannel();
    }

    public final long a(final c.b header, final long numEntries, final long vma) throws IOException {
        for (long j10 = 0; j10 < numEntries; j10++) {
            c.AbstractC0667c abstractC0667cB = header.b(j10);
            if (abstractC0667cB.f56543a == 1) {
                long j11 = abstractC0667cB.f56545c;
                if (j11 <= vma && vma <= abstractC0667cB.f56546d + j11) {
                    return (vma - j11) + abstractC0667cB.f56544b;
                }
            }
        }
        throw new IllegalStateException("Could not map vma to file offset!");
    }

    public c.b c() throws IOException {
        this.f56551b.position(0L);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        if (m(byteBufferAllocate, 0L) != 1179403647) {
            throw new IllegalArgumentException("Invalid ELF Magic!");
        }
        short sH = h(byteBufferAllocate, 4L);
        boolean z10 = h(byteBufferAllocate, 5L) == 2;
        if (sH == 1) {
            return new d(z10, this);
        }
        if (sH == 2) {
            return new e(z10, this);
        }
        throw new IllegalStateException("Invalid class type!");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f56551b.close();
    }

    public List<String> d() throws IOException {
        long j10;
        this.f56551b.position(0L);
        ArrayList arrayList = new ArrayList();
        c.b bVarC = c();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(bVarC.f56532a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j11 = bVarC.f56537f;
        int i10 = 0;
        if (j11 == dm.g.f26388t) {
            j11 = bVarC.c(0).f56547a;
        }
        long j12 = 0;
        while (true) {
            if (j12 >= j11) {
                j10 = 0;
                break;
            }
            c.AbstractC0667c abstractC0667cB = bVarC.b(j12);
            if (abstractC0667cB.f56543a == 2) {
                j10 = abstractC0667cB.f56544b;
                break;
            }
            j12++;
        }
        if (j10 == 0) {
            return Collections.unmodifiableList(arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        long j13 = 0;
        while (true) {
            c.a aVarA = bVarC.a(j10, i10);
            long j14 = j10;
            long j15 = aVarA.f56527a;
            if (j15 == 1) {
                arrayList2.add(Long.valueOf(aVarA.f56528b));
            } else if (j15 == 5) {
                j13 = aVarA.f56528b;
            }
            i10++;
            if (aVarA.f56527a == 0) {
                break;
            }
            j10 = j14;
        }
        if (j13 == 0) {
            throw new IllegalStateException("String table offset not found!");
        }
        long jA = a(bVarC, j11, j13);
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            arrayList.add(l(byteBufferAllocate, ((Long) it2.next()).longValue() + jA));
        }
        return arrayList;
    }

    public void f(final ByteBuffer buffer, long offset, final int length) throws IOException {
        buffer.position(0);
        buffer.limit(length);
        long j10 = 0;
        while (j10 < length) {
            int i10 = this.f56551b.read(buffer, offset + j10);
            if (i10 == -1) {
                throw new EOFException();
            }
            j10 += (long) i10;
        }
        buffer.position(0);
    }

    public short h(final ByteBuffer buffer, final long offset) throws IOException {
        f(buffer, offset, 1);
        return (short) (buffer.get() & 255);
    }

    public int i(final ByteBuffer buffer, final long offset) throws IOException {
        f(buffer, offset, 2);
        return buffer.getShort() & v1.f38215d;
    }

    public long k(final ByteBuffer buffer, final long offset) throws IOException {
        f(buffer, offset, 8);
        return buffer.getLong();
    }

    public String l(final ByteBuffer buffer, long offset) throws IOException {
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            long j10 = 1 + offset;
            short sH = h(buffer, offset);
            if (sH == 0) {
                return sb2.toString();
            }
            sb2.append((char) sH);
            offset = j10;
        }
    }

    public long m(final ByteBuffer buffer, final long offset) throws IOException {
        f(buffer, offset, 4);
        return ((long) buffer.getInt()) & 4294967295L;
    }
}
