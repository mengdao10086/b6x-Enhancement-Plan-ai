package io.objectbox.flatbuffers;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.StandardCharsets;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes5.dex */
public class v extends Utf8 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ThreadLocal<a> f32770c = ThreadLocal.withInitial(new Supplier() { // from class: io.objectbox.flatbuffers.u
        @Override // java.util.function.Supplier
        public final Object get() {
            return v.h();
        }
    });

    public static class a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public CharSequence f32773c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ByteBuffer f32774d = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CharsetEncoder f32771a = StandardCharsets.UTF_8.newEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CharsetDecoder f32772b = StandardCharsets.UTF_8.newDecoder();
    }

    public static /* synthetic */ a h() {
        return new a();
    }

    @Override // io.objectbox.flatbuffers.Utf8
    public String a(ByteBuffer byteBuffer, int i10, int i11) {
        CharsetDecoder charsetDecoder = f32770c.get().f32772b;
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

    @Override // io.objectbox.flatbuffers.Utf8
    public void b(CharSequence charSequence, ByteBuffer byteBuffer) {
        a aVar = f32770c.get();
        if (aVar.f32773c != charSequence) {
            d(charSequence);
        }
        byteBuffer.put(aVar.f32774d);
    }

    @Override // io.objectbox.flatbuffers.Utf8
    public int d(CharSequence charSequence) {
        a aVar = f32770c.get();
        int length = (int) (charSequence.length() * aVar.f32771a.maxBytesPerChar());
        ByteBuffer byteBuffer = aVar.f32774d;
        if (byteBuffer == null || byteBuffer.capacity() < length) {
            aVar.f32774d = ByteBuffer.allocate(Math.max(128, length));
        }
        aVar.f32774d.clear();
        aVar.f32773c = charSequence;
        CoderResult coderResultEncode = aVar.f32771a.encode(charSequence instanceof CharBuffer ? (CharBuffer) charSequence : CharBuffer.wrap(charSequence), aVar.f32774d, true);
        if (coderResultEncode.isError()) {
            try {
                coderResultEncode.throwException();
            } catch (CharacterCodingException e10) {
                throw new IllegalArgumentException("bad character encoding", e10);
            }
        }
        aVar.f32774d.flip();
        return aVar.f32774d.remaining();
    }
}
