package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.StandardCharsets;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
public class x extends Utf8 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadLocal<a> f5510b = ThreadLocal.withInitial(new Supplier() { // from class: androidx.emoji2.text.flatbuffer.w
        @Override // java.util.function.Supplier
        public final Object get() {
            return x.g();
        }
    });

    public static class a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public CharSequence f5513c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ByteBuffer f5514d = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CharsetEncoder f5511a = StandardCharsets.UTF_8.newEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CharsetDecoder f5512b = StandardCharsets.UTF_8.newDecoder();
    }

    public static /* synthetic */ a g() {
        return new a();
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public String a(ByteBuffer byteBuffer, int i10, int i11) {
        CharsetDecoder charsetDecoder = f5510b.get().f5512b;
        charsetDecoder.reset();
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.position(i10);
        byteBufferDuplicate.limit(i10 + i11);
        try {
            return charsetDecoder.decode(byteBufferDuplicate).toString();
        } catch (CharacterCodingException e10) {
            throw new IllegalArgumentException("Bad encoding", e10);
        }
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public void b(CharSequence charSequence, ByteBuffer byteBuffer) {
        a aVar = f5510b.get();
        if (aVar.f5513c != charSequence) {
            c(charSequence);
        }
        byteBuffer.put(aVar.f5514d);
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public int c(CharSequence charSequence) {
        a aVar = f5510b.get();
        int length = (int) (charSequence.length() * aVar.f5511a.maxBytesPerChar());
        ByteBuffer byteBuffer = aVar.f5514d;
        if (byteBuffer == null || byteBuffer.capacity() < length) {
            aVar.f5514d = ByteBuffer.allocate(Math.max(128, length));
        }
        aVar.f5514d.clear();
        aVar.f5513c = charSequence;
        CoderResult coderResultEncode = aVar.f5511a.encode(charSequence instanceof CharBuffer ? (CharBuffer) charSequence : CharBuffer.wrap(charSequence), aVar.f5514d, true);
        if (coderResultEncode.isError()) {
            try {
                coderResultEncode.throwException();
            } catch (CharacterCodingException e10) {
                throw new IllegalArgumentException("bad character encoding", e10);
            }
        }
        aVar.f5514d.flip();
        return aVar.f5514d.remaining();
    }
}
