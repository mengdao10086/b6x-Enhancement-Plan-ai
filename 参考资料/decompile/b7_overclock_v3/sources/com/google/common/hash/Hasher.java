package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes7.dex */
@CanIgnoreReturnValue
@Beta
public interface Hasher extends PrimitiveSink {
    HashCode hash();

    @Deprecated
    int hashCode();

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putBoolean(boolean z10);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putByte(byte b10);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putBytes(ByteBuffer byteBuffer);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putBytes(byte[] bArr);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putBytes(byte[] bArr, int i10, int i11);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putChar(char c10);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putDouble(double d10);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putFloat(float f10);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putInt(int i10);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putLong(long j10);

    <T> Hasher putObject(T t10, Funnel<? super T> funnel);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putShort(short s10);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putString(CharSequence charSequence, Charset charset);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putUnencodedChars(CharSequence charSequence);
}
