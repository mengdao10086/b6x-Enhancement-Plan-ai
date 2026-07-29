package com.google.common.io;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import ee.a;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.math.RoundingMode;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
@GwtCompatible(emulated = true)
public abstract class BaseEncoding {
    private static final BaseEncoding BASE64 = new Base64Encoding("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", '=');
    private static final BaseEncoding BASE64_URL = new Base64Encoding("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", '=');
    private static final BaseEncoding BASE32 = new StandardBaseEncoding("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", '=');
    private static final BaseEncoding BASE32_HEX = new StandardBaseEncoding("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", '=');
    private static final BaseEncoding BASE16 = new Base16Encoding("base16()", "0123456789ABCDEF");

    public static final class Alphabet {
        public final int bitsPerChar;
        public final int bytesPerChunk;
        private final char[] chars;
        public final int charsPerChunk;
        private final byte[] decodabet;
        public final int mask;
        private final String name;
        private final boolean[] validPadding;

        public Alphabet(String str, char[] cArr) {
            this.name = (String) Preconditions.checkNotNull(str);
            this.chars = (char[]) Preconditions.checkNotNull(cArr);
            try {
                int iLog2 = IntMath.log2(cArr.length, RoundingMode.UNNECESSARY);
                this.bitsPerChar = iLog2;
                int iMin = Math.min(8, Integer.lowestOneBit(iLog2));
                try {
                    this.charsPerChunk = 8 / iMin;
                    this.bytesPerChunk = iLog2 / iMin;
                    this.mask = cArr.length - 1;
                    byte[] bArr = new byte[128];
                    Arrays.fill(bArr, (byte) -1);
                    for (int i10 = 0; i10 < cArr.length; i10++) {
                        char c10 = cArr[i10];
                        Preconditions.checkArgument(c10 < 128, "Non-ASCII character: %s", c10);
                        Preconditions.checkArgument(bArr[c10] == -1, "Duplicate character: %s", c10);
                        bArr[c10] = (byte) i10;
                    }
                    this.decodabet = bArr;
                    boolean[] zArr = new boolean[this.charsPerChunk];
                    for (int i11 = 0; i11 < this.bytesPerChunk; i11++) {
                        zArr[IntMath.divide(i11 * 8, this.bitsPerChar, RoundingMode.CEILING)] = true;
                    }
                    this.validPadding = zArr;
                } catch (ArithmeticException e10) {
                    throw new IllegalArgumentException("Illegal alphabet " + new String(cArr), e10);
                }
            } catch (ArithmeticException e11) {
                throw new IllegalArgumentException("Illegal alphabet length " + cArr.length, e11);
            }
        }

        private boolean hasLowerCase() {
            for (char c10 : this.chars) {
                if (Ascii.isLowerCase(c10)) {
                    return true;
                }
            }
            return false;
        }

        private boolean hasUpperCase() {
            for (char c10 : this.chars) {
                if (Ascii.isUpperCase(c10)) {
                    return true;
                }
            }
            return false;
        }

        public boolean canDecode(char c10) {
            return c10 <= 127 && this.decodabet[c10] != -1;
        }

        public int decode(char c10) throws DecodingException {
            if (c10 > 127) {
                throw new DecodingException("Unrecognized character: 0x" + Integer.toHexString(c10));
            }
            byte b10 = this.decodabet[c10];
            if (b10 != -1) {
                return b10;
            }
            if (c10 <= ' ' || c10 == 127) {
                throw new DecodingException("Unrecognized character: 0x" + Integer.toHexString(c10));
            }
            throw new DecodingException("Unrecognized character: " + c10);
        }

        public char encode(int i10) {
            return this.chars[i10];
        }

        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof Alphabet) {
                return Arrays.equals(this.chars, ((Alphabet) obj).chars);
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(this.chars);
        }

        public boolean isValidPaddingStartPosition(int i10) {
            return this.validPadding[i10 % this.charsPerChunk];
        }

        public Alphabet lowerCase() {
            if (!hasUpperCase()) {
                return this;
            }
            Preconditions.checkState(!hasLowerCase(), "Cannot call lowerCase() on a mixed-case alphabet");
            char[] cArr = new char[this.chars.length];
            int i10 = 0;
            while (true) {
                char[] cArr2 = this.chars;
                if (i10 >= cArr2.length) {
                    return new Alphabet(this.name + ".lowerCase()", cArr);
                }
                cArr[i10] = Ascii.toLowerCase(cArr2[i10]);
                i10++;
            }
        }

        public boolean matches(char c10) {
            byte[] bArr = this.decodabet;
            return c10 < bArr.length && bArr[c10] != -1;
        }

        public String toString() {
            return this.name;
        }

        public Alphabet upperCase() {
            if (!hasLowerCase()) {
                return this;
            }
            Preconditions.checkState(!hasUpperCase(), "Cannot call upperCase() on a mixed-case alphabet");
            char[] cArr = new char[this.chars.length];
            int i10 = 0;
            while (true) {
                char[] cArr2 = this.chars;
                if (i10 >= cArr2.length) {
                    return new Alphabet(this.name + ".upperCase()", cArr);
                }
                cArr[i10] = Ascii.toUpperCase(cArr2[i10]);
                i10++;
            }
        }
    }

    public static final class Base16Encoding extends StandardBaseEncoding {
        public final char[] encoding;

        public Base16Encoding(String str, String str2) {
            this(new Alphabet(str, str2.toCharArray()));
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding, com.google.common.io.BaseEncoding
        public int decodeTo(byte[] bArr, CharSequence charSequence) throws DecodingException {
            Preconditions.checkNotNull(bArr);
            if (charSequence.length() % 2 == 1) {
                throw new DecodingException("Invalid input length " + charSequence.length());
            }
            int i10 = 0;
            int i11 = 0;
            while (i10 < charSequence.length()) {
                bArr[i11] = (byte) ((this.alphabet.decode(charSequence.charAt(i10)) << 4) | this.alphabet.decode(charSequence.charAt(i10 + 1)));
                i10 += 2;
                i11++;
            }
            return i11;
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding, com.google.common.io.BaseEncoding
        public void encodeTo(Appendable appendable, byte[] bArr, int i10, int i11) throws IOException {
            Preconditions.checkNotNull(appendable);
            Preconditions.checkPositionIndexes(i10, i10 + i11, bArr.length);
            for (int i12 = 0; i12 < i11; i12++) {
                int i13 = bArr[i10 + i12] & 255;
                appendable.append(this.encoding[i13]);
                appendable.append(this.encoding[i13 | 256]);
            }
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding
        public BaseEncoding newInstance(Alphabet alphabet, @NullableDecl Character ch2) {
            return new Base16Encoding(alphabet);
        }

        private Base16Encoding(Alphabet alphabet) {
            super(alphabet, null);
            this.encoding = new char[512];
            Preconditions.checkArgument(alphabet.chars.length == 16);
            for (int i10 = 0; i10 < 256; i10++) {
                this.encoding[i10] = alphabet.encode(i10 >>> 4);
                this.encoding[i10 | 256] = alphabet.encode(i10 & 15);
            }
        }
    }

    public static final class Base64Encoding extends StandardBaseEncoding {
        public Base64Encoding(String str, String str2, @NullableDecl Character ch2) {
            this(new Alphabet(str, str2.toCharArray()), ch2);
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding, com.google.common.io.BaseEncoding
        public int decodeTo(byte[] bArr, CharSequence charSequence) throws DecodingException {
            Preconditions.checkNotNull(bArr);
            CharSequence charSequenceTrimTrailingPadding = trimTrailingPadding(charSequence);
            if (!this.alphabet.isValidPaddingStartPosition(charSequenceTrimTrailingPadding.length())) {
                throw new DecodingException("Invalid input length " + charSequenceTrimTrailingPadding.length());
            }
            int i10 = 0;
            int i11 = 0;
            while (i10 < charSequenceTrimTrailingPadding.length()) {
                int i12 = i10 + 1;
                int i13 = i12 + 1;
                int iDecode = (this.alphabet.decode(charSequenceTrimTrailingPadding.charAt(i10)) << 18) | (this.alphabet.decode(charSequenceTrimTrailingPadding.charAt(i12)) << 12);
                int i14 = i11 + 1;
                bArr[i11] = (byte) (iDecode >>> 16);
                if (i13 < charSequenceTrimTrailingPadding.length()) {
                    int i15 = i13 + 1;
                    int iDecode2 = iDecode | (this.alphabet.decode(charSequenceTrimTrailingPadding.charAt(i13)) << 6);
                    i11 = i14 + 1;
                    bArr[i14] = (byte) ((iDecode2 >>> 8) & 255);
                    if (i15 < charSequenceTrimTrailingPadding.length()) {
                        i13 = i15 + 1;
                        i14 = i11 + 1;
                        bArr[i11] = (byte) ((iDecode2 | this.alphabet.decode(charSequenceTrimTrailingPadding.charAt(i15))) & 255);
                    } else {
                        i10 = i15;
                    }
                }
                i11 = i14;
                i10 = i13;
            }
            return i11;
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding, com.google.common.io.BaseEncoding
        public void encodeTo(Appendable appendable, byte[] bArr, int i10, int i11) throws IOException {
            Preconditions.checkNotNull(appendable);
            int i12 = i10 + i11;
            Preconditions.checkPositionIndexes(i10, i12, bArr.length);
            while (i11 >= 3) {
                int i13 = i10 + 1;
                int i14 = i13 + 1;
                int i15 = ((bArr[i10] & 255) << 16) | ((bArr[i13] & 255) << 8) | (bArr[i14] & 255);
                appendable.append(this.alphabet.encode(i15 >>> 18));
                appendable.append(this.alphabet.encode((i15 >>> 12) & 63));
                appendable.append(this.alphabet.encode((i15 >>> 6) & 63));
                appendable.append(this.alphabet.encode(i15 & 63));
                i11 -= 3;
                i10 = i14 + 1;
            }
            if (i10 < i12) {
                encodeChunkTo(appendable, bArr, i10, i12 - i10);
            }
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding
        public BaseEncoding newInstance(Alphabet alphabet, @NullableDecl Character ch2) {
            return new Base64Encoding(alphabet, ch2);
        }

        private Base64Encoding(Alphabet alphabet, @NullableDecl Character ch2) {
            super(alphabet, ch2);
            Preconditions.checkArgument(alphabet.chars.length == 64);
        }
    }

    public static final class DecodingException extends IOException {
        public DecodingException(String str) {
            super(str);
        }

        public DecodingException(Throwable th2) {
            super(th2);
        }
    }

    public static final class SeparatedBaseEncoding extends BaseEncoding {
        private final int afterEveryChars;
        private final BaseEncoding delegate;
        private final String separator;

        public SeparatedBaseEncoding(BaseEncoding baseEncoding, String str, int i10) {
            this.delegate = (BaseEncoding) Preconditions.checkNotNull(baseEncoding);
            this.separator = (String) Preconditions.checkNotNull(str);
            this.afterEveryChars = i10;
            Preconditions.checkArgument(i10 > 0, "Cannot add a separator after every %s chars", i10);
        }

        @Override // com.google.common.io.BaseEncoding
        public boolean canDecode(CharSequence charSequence) {
            StringBuilder sb2 = new StringBuilder();
            for (int i10 = 0; i10 < charSequence.length(); i10++) {
                char cCharAt = charSequence.charAt(i10);
                if (this.separator.indexOf(cCharAt) < 0) {
                    sb2.append(cCharAt);
                }
            }
            return this.delegate.canDecode(sb2);
        }

        @Override // com.google.common.io.BaseEncoding
        public int decodeTo(byte[] bArr, CharSequence charSequence) throws DecodingException {
            StringBuilder sb2 = new StringBuilder(charSequence.length());
            for (int i10 = 0; i10 < charSequence.length(); i10++) {
                char cCharAt = charSequence.charAt(i10);
                if (this.separator.indexOf(cCharAt) < 0) {
                    sb2.append(cCharAt);
                }
            }
            return this.delegate.decodeTo(bArr, sb2);
        }

        @Override // com.google.common.io.BaseEncoding
        @GwtIncompatible
        public InputStream decodingStream(Reader reader) {
            return this.delegate.decodingStream(BaseEncoding.ignoringReader(reader, this.separator));
        }

        @Override // com.google.common.io.BaseEncoding
        public void encodeTo(Appendable appendable, byte[] bArr, int i10, int i11) throws IOException {
            this.delegate.encodeTo(BaseEncoding.separatingAppendable(appendable, this.separator, this.afterEveryChars), bArr, i10, i11);
        }

        @Override // com.google.common.io.BaseEncoding
        @GwtIncompatible
        public OutputStream encodingStream(Writer writer) {
            return this.delegate.encodingStream(BaseEncoding.separatingWriter(writer, this.separator, this.afterEveryChars));
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding lowerCase() {
            return this.delegate.lowerCase().withSeparator(this.separator, this.afterEveryChars);
        }

        @Override // com.google.common.io.BaseEncoding
        public int maxDecodedSize(int i10) {
            return this.delegate.maxDecodedSize(i10);
        }

        @Override // com.google.common.io.BaseEncoding
        public int maxEncodedSize(int i10) {
            int iMaxEncodedSize = this.delegate.maxEncodedSize(i10);
            return iMaxEncodedSize + (this.separator.length() * IntMath.divide(Math.max(0, iMaxEncodedSize - 1), this.afterEveryChars, RoundingMode.FLOOR));
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding omitPadding() {
            return this.delegate.omitPadding().withSeparator(this.separator, this.afterEveryChars);
        }

        public String toString() {
            return this.delegate + ".withSeparator(\"" + this.separator + "\", " + this.afterEveryChars + a.f26979d;
        }

        @Override // com.google.common.io.BaseEncoding
        public CharSequence trimTrailingPadding(CharSequence charSequence) {
            return this.delegate.trimTrailingPadding(charSequence);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding upperCase() {
            return this.delegate.upperCase().withSeparator(this.separator, this.afterEveryChars);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding withPadChar(char c10) {
            return this.delegate.withPadChar(c10).withSeparator(this.separator, this.afterEveryChars);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding withSeparator(String str, int i10) {
            throw new UnsupportedOperationException("Already have a separator");
        }
    }

    public static class StandardBaseEncoding extends BaseEncoding {
        public final Alphabet alphabet;

        @MonotonicNonNullDecl
        private transient BaseEncoding lowerCase;

        @NullableDecl
        public final Character paddingChar;

        @MonotonicNonNullDecl
        private transient BaseEncoding upperCase;

        public StandardBaseEncoding(String str, String str2, @NullableDecl Character ch2) {
            this(new Alphabet(str, str2.toCharArray()), ch2);
        }

        @Override // com.google.common.io.BaseEncoding
        public boolean canDecode(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            CharSequence charSequenceTrimTrailingPadding = trimTrailingPadding(charSequence);
            if (!this.alphabet.isValidPaddingStartPosition(charSequenceTrimTrailingPadding.length())) {
                return false;
            }
            for (int i10 = 0; i10 < charSequenceTrimTrailingPadding.length(); i10++) {
                if (!this.alphabet.canDecode(charSequenceTrimTrailingPadding.charAt(i10))) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.io.BaseEncoding
        public int decodeTo(byte[] bArr, CharSequence charSequence) throws DecodingException {
            Alphabet alphabet;
            Preconditions.checkNotNull(bArr);
            CharSequence charSequenceTrimTrailingPadding = trimTrailingPadding(charSequence);
            if (!this.alphabet.isValidPaddingStartPosition(charSequenceTrimTrailingPadding.length())) {
                throw new DecodingException("Invalid input length " + charSequenceTrimTrailingPadding.length());
            }
            int i10 = 0;
            int i11 = 0;
            while (i10 < charSequenceTrimTrailingPadding.length()) {
                long jDecode = 0;
                int i12 = 0;
                int i13 = 0;
                while (true) {
                    alphabet = this.alphabet;
                    if (i12 >= alphabet.charsPerChunk) {
                        break;
                    }
                    jDecode <<= alphabet.bitsPerChar;
                    if (i10 + i12 < charSequenceTrimTrailingPadding.length()) {
                        jDecode |= (long) this.alphabet.decode(charSequenceTrimTrailingPadding.charAt(i13 + i10));
                        i13++;
                    }
                    i12++;
                }
                int i14 = alphabet.bytesPerChunk;
                int i15 = (i14 * 8) - (i13 * alphabet.bitsPerChar);
                int i16 = (i14 - 1) * 8;
                while (i16 >= i15) {
                    bArr[i11] = (byte) ((jDecode >>> i16) & 255);
                    i16 -= 8;
                    i11++;
                }
                i10 += this.alphabet.charsPerChunk;
            }
            return i11;
        }

        @Override // com.google.common.io.BaseEncoding
        @GwtIncompatible
        public InputStream decodingStream(final Reader reader) {
            Preconditions.checkNotNull(reader);
            return new InputStream() { // from class: com.google.common.io.BaseEncoding.StandardBaseEncoding.2
                public int bitBuffer = 0;
                public int bitBufferLength = 0;
                public int readChars = 0;
                public boolean hitPadding = false;

                @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    reader.close();
                }

                /* JADX WARN: Code restructure failed: missing block: B:24:0x0074, code lost:
                
                    throw new com.google.common.io.BaseEncoding.DecodingException("Padding cannot start at index " + r4.readChars);
                 */
                @Override // java.io.InputStream
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public int read() throws java.io.IOException {
                    /*
                        r4 = this;
                    L0:
                        java.io.Reader r0 = r2
                        int r0 = r0.read()
                        r1 = -1
                        if (r0 != r1) goto L34
                        boolean r0 = r4.hitPadding
                        if (r0 != 0) goto L33
                        com.google.common.io.BaseEncoding$StandardBaseEncoding r0 = com.google.common.io.BaseEncoding.StandardBaseEncoding.this
                        com.google.common.io.BaseEncoding$Alphabet r0 = r0.alphabet
                        int r2 = r4.readChars
                        boolean r0 = r0.isValidPaddingStartPosition(r2)
                        if (r0 == 0) goto L1a
                        goto L33
                    L1a:
                        com.google.common.io.BaseEncoding$DecodingException r0 = new com.google.common.io.BaseEncoding$DecodingException
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder
                        r1.<init>()
                        java.lang.String r2 = "Invalid input length "
                        r1.append(r2)
                        int r2 = r4.readChars
                        r1.append(r2)
                        java.lang.String r1 = r1.toString()
                        r0.<init>(r1)
                        throw r0
                    L33:
                        return r1
                    L34:
                        int r1 = r4.readChars
                        r2 = 1
                        int r1 = r1 + r2
                        r4.readChars = r1
                        char r0 = (char) r0
                        com.google.common.io.BaseEncoding$StandardBaseEncoding r1 = com.google.common.io.BaseEncoding.StandardBaseEncoding.this
                        java.lang.Character r1 = r1.paddingChar
                        if (r1 == 0) goto L78
                        char r1 = r1.charValue()
                        if (r1 != r0) goto L78
                        boolean r0 = r4.hitPadding
                        if (r0 != 0) goto L75
                        int r0 = r4.readChars
                        if (r0 == r2) goto L5c
                        com.google.common.io.BaseEncoding$StandardBaseEncoding r1 = com.google.common.io.BaseEncoding.StandardBaseEncoding.this
                        com.google.common.io.BaseEncoding$Alphabet r1 = r1.alphabet
                        int r0 = r0 + (-1)
                        boolean r0 = r1.isValidPaddingStartPosition(r0)
                        if (r0 == 0) goto L5c
                        goto L75
                    L5c:
                        com.google.common.io.BaseEncoding$DecodingException r0 = new com.google.common.io.BaseEncoding$DecodingException
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder
                        r1.<init>()
                        java.lang.String r2 = "Padding cannot start at index "
                        r1.append(r2)
                        int r2 = r4.readChars
                        r1.append(r2)
                        java.lang.String r1 = r1.toString()
                        r0.<init>(r1)
                        throw r0
                    L75:
                        r4.hitPadding = r2
                        goto L0
                    L78:
                        boolean r1 = r4.hitPadding
                        if (r1 != 0) goto La4
                        int r1 = r4.bitBuffer
                        com.google.common.io.BaseEncoding$StandardBaseEncoding r2 = com.google.common.io.BaseEncoding.StandardBaseEncoding.this
                        com.google.common.io.BaseEncoding$Alphabet r2 = r2.alphabet
                        int r3 = r2.bitsPerChar
                        int r1 = r1 << r3
                        r4.bitBuffer = r1
                        int r0 = r2.decode(r0)
                        r0 = r0 | r1
                        r4.bitBuffer = r0
                        int r1 = r4.bitBufferLength
                        com.google.common.io.BaseEncoding$StandardBaseEncoding r2 = com.google.common.io.BaseEncoding.StandardBaseEncoding.this
                        com.google.common.io.BaseEncoding$Alphabet r2 = r2.alphabet
                        int r2 = r2.bitsPerChar
                        int r1 = r1 + r2
                        r4.bitBufferLength = r1
                        r2 = 8
                        if (r1 < r2) goto L0
                        int r1 = r1 - r2
                        r4.bitBufferLength = r1
                        int r0 = r0 >> r1
                        r0 = r0 & 255(0xff, float:3.57E-43)
                        return r0
                    La4:
                        com.google.common.io.BaseEncoding$DecodingException r1 = new com.google.common.io.BaseEncoding$DecodingException
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder
                        r2.<init>()
                        java.lang.String r3 = "Expected padding character but found '"
                        r2.append(r3)
                        r2.append(r0)
                        java.lang.String r0 = "' at index "
                        r2.append(r0)
                        int r0 = r4.readChars
                        r2.append(r0)
                        java.lang.String r0 = r2.toString()
                        r1.<init>(r0)
                        throw r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.common.io.BaseEncoding.StandardBaseEncoding.AnonymousClass2.read():int");
                }
            };
        }

        public void encodeChunkTo(Appendable appendable, byte[] bArr, int i10, int i11) throws IOException {
            Preconditions.checkNotNull(appendable);
            Preconditions.checkPositionIndexes(i10, i10 + i11, bArr.length);
            int i12 = 0;
            Preconditions.checkArgument(i11 <= this.alphabet.bytesPerChunk);
            long j10 = 0;
            for (int i13 = 0; i13 < i11; i13++) {
                j10 = (j10 | ((long) (bArr[i10 + i13] & 255))) << 8;
            }
            int i14 = ((i11 + 1) * 8) - this.alphabet.bitsPerChar;
            while (i12 < i11 * 8) {
                Alphabet alphabet = this.alphabet;
                appendable.append(alphabet.encode(((int) (j10 >>> (i14 - i12))) & alphabet.mask));
                i12 += this.alphabet.bitsPerChar;
            }
            if (this.paddingChar != null) {
                while (i12 < this.alphabet.bytesPerChunk * 8) {
                    appendable.append(this.paddingChar.charValue());
                    i12 += this.alphabet.bitsPerChar;
                }
            }
        }

        @Override // com.google.common.io.BaseEncoding
        public void encodeTo(Appendable appendable, byte[] bArr, int i10, int i11) throws IOException {
            Preconditions.checkNotNull(appendable);
            Preconditions.checkPositionIndexes(i10, i10 + i11, bArr.length);
            int i12 = 0;
            while (i12 < i11) {
                encodeChunkTo(appendable, bArr, i10 + i12, Math.min(this.alphabet.bytesPerChunk, i11 - i12));
                i12 += this.alphabet.bytesPerChunk;
            }
        }

        @Override // com.google.common.io.BaseEncoding
        @GwtIncompatible
        public OutputStream encodingStream(final Writer writer) {
            Preconditions.checkNotNull(writer);
            return new OutputStream() { // from class: com.google.common.io.BaseEncoding.StandardBaseEncoding.1
                public int bitBuffer = 0;
                public int bitBufferLength = 0;
                public int writtenChars = 0;

                @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    int i10 = this.bitBufferLength;
                    if (i10 > 0) {
                        int i11 = this.bitBuffer;
                        Alphabet alphabet = StandardBaseEncoding.this.alphabet;
                        writer.write(alphabet.encode((i11 << (alphabet.bitsPerChar - i10)) & alphabet.mask));
                        this.writtenChars++;
                        if (StandardBaseEncoding.this.paddingChar != null) {
                            while (true) {
                                int i12 = this.writtenChars;
                                StandardBaseEncoding standardBaseEncoding = StandardBaseEncoding.this;
                                if (i12 % standardBaseEncoding.alphabet.charsPerChunk == 0) {
                                    break;
                                }
                                writer.write(standardBaseEncoding.paddingChar.charValue());
                                this.writtenChars++;
                            }
                        }
                    }
                    writer.close();
                }

                @Override // java.io.OutputStream, java.io.Flushable
                public void flush() throws IOException {
                    writer.flush();
                }

                @Override // java.io.OutputStream
                public void write(int i10) throws IOException {
                    this.bitBuffer = (i10 & 255) | (this.bitBuffer << 8);
                    this.bitBufferLength += 8;
                    while (true) {
                        int i11 = this.bitBufferLength;
                        Alphabet alphabet = StandardBaseEncoding.this.alphabet;
                        int i12 = alphabet.bitsPerChar;
                        if (i11 < i12) {
                            return;
                        }
                        writer.write(alphabet.encode((this.bitBuffer >> (i11 - i12)) & alphabet.mask));
                        this.writtenChars++;
                        this.bitBufferLength -= StandardBaseEncoding.this.alphabet.bitsPerChar;
                    }
                }
            };
        }

        public boolean equals(@NullableDecl Object obj) {
            if (!(obj instanceof StandardBaseEncoding)) {
                return false;
            }
            StandardBaseEncoding standardBaseEncoding = (StandardBaseEncoding) obj;
            return this.alphabet.equals(standardBaseEncoding.alphabet) && Objects.equal(this.paddingChar, standardBaseEncoding.paddingChar);
        }

        public int hashCode() {
            return this.alphabet.hashCode() ^ Objects.hashCode(this.paddingChar);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding lowerCase() {
            BaseEncoding baseEncodingNewInstance = this.lowerCase;
            if (baseEncodingNewInstance == null) {
                Alphabet alphabetLowerCase = this.alphabet.lowerCase();
                baseEncodingNewInstance = alphabetLowerCase == this.alphabet ? this : newInstance(alphabetLowerCase, this.paddingChar);
                this.lowerCase = baseEncodingNewInstance;
            }
            return baseEncodingNewInstance;
        }

        @Override // com.google.common.io.BaseEncoding
        public int maxDecodedSize(int i10) {
            return (int) (((((long) this.alphabet.bitsPerChar) * ((long) i10)) + 7) / 8);
        }

        @Override // com.google.common.io.BaseEncoding
        public int maxEncodedSize(int i10) {
            Alphabet alphabet = this.alphabet;
            return alphabet.charsPerChunk * IntMath.divide(i10, alphabet.bytesPerChunk, RoundingMode.CEILING);
        }

        public BaseEncoding newInstance(Alphabet alphabet, @NullableDecl Character ch2) {
            return new StandardBaseEncoding(alphabet, ch2);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding omitPadding() {
            return this.paddingChar == null ? this : newInstance(this.alphabet, null);
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("BaseEncoding.");
            sb2.append(this.alphabet.toString());
            if (8 % this.alphabet.bitsPerChar != 0) {
                if (this.paddingChar == null) {
                    sb2.append(".omitPadding()");
                } else {
                    sb2.append(".withPadChar('");
                    sb2.append(this.paddingChar);
                    sb2.append("')");
                }
            }
            return sb2.toString();
        }

        @Override // com.google.common.io.BaseEncoding
        public CharSequence trimTrailingPadding(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            Character ch2 = this.paddingChar;
            if (ch2 == null) {
                return charSequence;
            }
            char cCharValue = ch2.charValue();
            int length = charSequence.length() - 1;
            while (length >= 0 && charSequence.charAt(length) == cCharValue) {
                length--;
            }
            return charSequence.subSequence(0, length + 1);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding upperCase() {
            BaseEncoding baseEncodingNewInstance = this.upperCase;
            if (baseEncodingNewInstance == null) {
                Alphabet alphabetUpperCase = this.alphabet.upperCase();
                baseEncodingNewInstance = alphabetUpperCase == this.alphabet ? this : newInstance(alphabetUpperCase, this.paddingChar);
                this.upperCase = baseEncodingNewInstance;
            }
            return baseEncodingNewInstance;
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding withPadChar(char c10) {
            Character ch2;
            return (8 % this.alphabet.bitsPerChar == 0 || ((ch2 = this.paddingChar) != null && ch2.charValue() == c10)) ? this : newInstance(this.alphabet, Character.valueOf(c10));
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding withSeparator(String str, int i10) {
            for (int i11 = 0; i11 < str.length(); i11++) {
                Preconditions.checkArgument(!this.alphabet.matches(str.charAt(i11)), "Separator (%s) cannot contain alphabet characters", str);
            }
            Character ch2 = this.paddingChar;
            if (ch2 != null) {
                Preconditions.checkArgument(str.indexOf(ch2.charValue()) < 0, "Separator (%s) cannot contain padding character", str);
            }
            return new SeparatedBaseEncoding(this, str, i10);
        }

        public StandardBaseEncoding(Alphabet alphabet, @NullableDecl Character ch2) {
            this.alphabet = (Alphabet) Preconditions.checkNotNull(alphabet);
            Preconditions.checkArgument(ch2 == null || !alphabet.matches(ch2.charValue()), "Padding character %s was already in alphabet", ch2);
            this.paddingChar = ch2;
        }
    }

    public static BaseEncoding base16() {
        return BASE16;
    }

    public static BaseEncoding base32() {
        return BASE32;
    }

    public static BaseEncoding base32Hex() {
        return BASE32_HEX;
    }

    public static BaseEncoding base64() {
        return BASE64;
    }

    public static BaseEncoding base64Url() {
        return BASE64_URL;
    }

    private static byte[] extract(byte[] bArr, int i10) {
        if (i10 == bArr.length) {
            return bArr;
        }
        byte[] bArr2 = new byte[i10];
        System.arraycopy(bArr, 0, bArr2, 0, i10);
        return bArr2;
    }

    @GwtIncompatible
    public static Reader ignoringReader(final Reader reader, final String str) {
        Preconditions.checkNotNull(reader);
        Preconditions.checkNotNull(str);
        return new Reader() { // from class: com.google.common.io.BaseEncoding.3
            @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                reader.close();
            }

            @Override // java.io.Reader
            public int read() throws IOException {
                int i10;
                do {
                    i10 = reader.read();
                    if (i10 == -1) {
                        break;
                    }
                } while (str.indexOf((char) i10) >= 0);
                return i10;
            }

            @Override // java.io.Reader
            public int read(char[] cArr, int i10, int i11) throws IOException {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static Appendable separatingAppendable(Appendable appendable, String str, int i10) {
        Preconditions.checkNotNull(appendable);
        Preconditions.checkNotNull(str);
        Preconditions.checkArgument(i10 > 0);
        return new Appendable(i10, appendable, str) { // from class: com.google.common.io.BaseEncoding.4
            public int charsUntilSeparator;
            public final /* synthetic */ int val$afterEveryChars;
            public final /* synthetic */ Appendable val$delegate;
            public final /* synthetic */ String val$separator;

            {
                this.val$afterEveryChars = i10;
                this.val$delegate = appendable;
                this.val$separator = str;
                this.charsUntilSeparator = i10;
            }

            @Override // java.lang.Appendable
            public Appendable append(char c10) throws IOException {
                if (this.charsUntilSeparator == 0) {
                    this.val$delegate.append(this.val$separator);
                    this.charsUntilSeparator = this.val$afterEveryChars;
                }
                this.val$delegate.append(c10);
                this.charsUntilSeparator--;
                return this;
            }

            @Override // java.lang.Appendable
            public Appendable append(@NullableDecl CharSequence charSequence, int i11, int i12) throws IOException {
                throw new UnsupportedOperationException();
            }

            @Override // java.lang.Appendable
            public Appendable append(@NullableDecl CharSequence charSequence) throws IOException {
                throw new UnsupportedOperationException();
            }
        };
    }

    @GwtIncompatible
    public static Writer separatingWriter(final Writer writer, String str, int i10) {
        final Appendable appendableSeparatingAppendable = separatingAppendable(writer, str, i10);
        return new Writer() { // from class: com.google.common.io.BaseEncoding.5
            @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                writer.close();
            }

            @Override // java.io.Writer, java.io.Flushable
            public void flush() throws IOException {
                writer.flush();
            }

            @Override // java.io.Writer
            public void write(int i11) throws IOException {
                appendableSeparatingAppendable.append((char) i11);
            }

            @Override // java.io.Writer
            public void write(char[] cArr, int i11, int i12) throws IOException {
                throw new UnsupportedOperationException();
            }
        };
    }

    public abstract boolean canDecode(CharSequence charSequence);

    public final byte[] decode(CharSequence charSequence) {
        try {
            return decodeChecked(charSequence);
        } catch (DecodingException e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public final byte[] decodeChecked(CharSequence charSequence) throws DecodingException {
        CharSequence charSequenceTrimTrailingPadding = trimTrailingPadding(charSequence);
        byte[] bArr = new byte[maxDecodedSize(charSequenceTrimTrailingPadding.length())];
        return extract(bArr, decodeTo(bArr, charSequenceTrimTrailingPadding));
    }

    public abstract int decodeTo(byte[] bArr, CharSequence charSequence) throws DecodingException;

    @GwtIncompatible
    public final ByteSource decodingSource(final CharSource charSource) {
        Preconditions.checkNotNull(charSource);
        return new ByteSource() { // from class: com.google.common.io.BaseEncoding.2
            @Override // com.google.common.io.ByteSource
            public InputStream openStream() throws IOException {
                return BaseEncoding.this.decodingStream(charSource.openStream());
            }
        };
    }

    @GwtIncompatible
    public abstract InputStream decodingStream(Reader reader);

    public String encode(byte[] bArr) {
        return encode(bArr, 0, bArr.length);
    }

    public abstract void encodeTo(Appendable appendable, byte[] bArr, int i10, int i11) throws IOException;

    @GwtIncompatible
    public final ByteSink encodingSink(final CharSink charSink) {
        Preconditions.checkNotNull(charSink);
        return new ByteSink() { // from class: com.google.common.io.BaseEncoding.1
            @Override // com.google.common.io.ByteSink
            public OutputStream openStream() throws IOException {
                return BaseEncoding.this.encodingStream(charSink.openStream());
            }
        };
    }

    @GwtIncompatible
    public abstract OutputStream encodingStream(Writer writer);

    public abstract BaseEncoding lowerCase();

    public abstract int maxDecodedSize(int i10);

    public abstract int maxEncodedSize(int i10);

    public abstract BaseEncoding omitPadding();

    public CharSequence trimTrailingPadding(CharSequence charSequence) {
        return (CharSequence) Preconditions.checkNotNull(charSequence);
    }

    public abstract BaseEncoding upperCase();

    public abstract BaseEncoding withPadChar(char c10);

    public abstract BaseEncoding withSeparator(String str, int i10);

    public final String encode(byte[] bArr, int i10, int i11) {
        Preconditions.checkPositionIndexes(i10, i10 + i11, bArr.length);
        StringBuilder sb2 = new StringBuilder(maxEncodedSize(i11));
        try {
            encodeTo(sb2, bArr, i10, i11);
            return sb2.toString();
        } catch (IOException e10) {
            throw new AssertionError(e10);
        }
    }
}
