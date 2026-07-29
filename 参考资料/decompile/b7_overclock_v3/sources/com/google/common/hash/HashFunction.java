package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.Immutable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes7.dex */
@Immutable
@Beta
public interface HashFunction {
    int bits();

    HashCode hashBytes(ByteBuffer byteBuffer);

    HashCode hashBytes(byte[] bArr);

    HashCode hashBytes(byte[] bArr, int i10, int i11);

    HashCode hashInt(int i10);

    HashCode hashLong(long j10);

    <T> HashCode hashObject(T t10, Funnel<? super T> funnel);

    HashCode hashString(CharSequence charSequence, Charset charset);

    HashCode hashUnencodedChars(CharSequence charSequence);

    Hasher newHasher();

    Hasher newHasher(int i10);
}
