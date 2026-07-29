package bd;

import android.media.MediaCodec;
import android.media.MediaFormat;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.mediacodec.e;
import com.google.common.collect.ImmutableList;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import g.p0;
import hd.w;
import java.nio.ByteBuffer;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f9286i = 2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.android.exoplayer2.mediacodec.b f9288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Format f9289c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @p0
    public ByteBuffer f9290d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f9293g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f9294h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MediaCodec.BufferInfo f9287a = new MediaCodec.BufferInfo();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f9291e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f9292f = -1;

    public c(com.google.android.exoplayer2.mediacodec.b bVar) {
        this.f9288b = bVar;
    }

    public static c a(Format format) throws Exception {
        MediaCodec mediaCodecCreateDecoderByType;
        Exception e10;
        com.google.android.exoplayer2.mediacodec.b bVarA;
        MediaFormat mediaFormatCreateAudioFormat;
        try {
            mediaCodecCreateDecoderByType = MediaCodec.createDecoderByType((String) hd.a.g(format.f16699l));
            try {
                mediaFormatCreateAudioFormat = MediaFormat.createAudioFormat(format.f16699l, format.f16713z, format.f16712y);
                tb.o.d(mediaFormatCreateAudioFormat, "max-input-size", format.f16700m);
                tb.o.e(mediaFormatCreateAudioFormat, format.f16701n);
                bVarA = new e.b().a(mediaCodecCreateDecoderByType);
            } catch (Exception e11) {
                e10 = e11;
                bVarA = null;
            }
        } catch (Exception e12) {
            mediaCodecCreateDecoderByType = null;
            e10 = e12;
            bVarA = null;
        }
        try {
            bVarA.b(mediaFormatCreateAudioFormat, null, null, 0);
            bVarA.start();
            return new c(bVarA);
        } catch (Exception e13) {
            e10 = e13;
            if (bVarA != null) {
                bVarA.release();
            } else if (mediaCodecCreateDecoderByType != null) {
                mediaCodecCreateDecoderByType.release();
            }
            throw e10;
        }
    }

    public static c b(Format format) throws Exception {
        MediaCodec mediaCodecCreateEncoderByType;
        Exception e10;
        com.google.android.exoplayer2.mediacodec.b bVarA;
        MediaFormat mediaFormatCreateAudioFormat;
        try {
            mediaCodecCreateEncoderByType = MediaCodec.createEncoderByType((String) hd.a.g(format.f16699l));
            try {
                mediaFormatCreateAudioFormat = MediaFormat.createAudioFormat(format.f16699l, format.f16713z, format.f16712y);
                mediaFormatCreateAudioFormat.setInteger("bitrate", format.f16694h);
                bVarA = new e.b().a(mediaCodecCreateEncoderByType);
            } catch (Exception e11) {
                e10 = e11;
                bVarA = null;
            }
        } catch (Exception e12) {
            mediaCodecCreateEncoderByType = null;
            e10 = e12;
            bVarA = null;
        }
        try {
            bVarA.b(mediaFormatCreateAudioFormat, null, null, 1);
            bVarA.start();
            return new c(bVarA);
        } catch (Exception e13) {
            e10 = e13;
            if (bVarA != null) {
                bVarA.release();
            } else if (mediaCodecCreateEncoderByType != null) {
                mediaCodecCreateEncoderByType.release();
            }
            throw e10;
        }
    }

    public static Format c(MediaFormat mediaFormat) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        int i10 = 0;
        while (true) {
            ByteBuffer byteBuffer = mediaFormat.getByteBuffer("csd-" + i10);
            if (byteBuffer == null) {
                break;
            }
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            builder.add(bArr);
            i10++;
        }
        String string = mediaFormat.getString("mime");
        Format.b bVarT = new Format.b().e0(mediaFormat.getString("mime")).T(builder.build());
        if (w.s(string)) {
            bVarT.j0(mediaFormat.getInteger(SocializeProtocolConstants.WIDTH)).Q(mediaFormat.getInteger(SocializeProtocolConstants.HEIGHT));
        } else if (w.p(string)) {
            bVarT.H(mediaFormat.getInteger("channel-count")).f0(mediaFormat.getInteger("sample-rate")).Y(2);
        }
        return bVarT.E();
    }

    @p0
    public ByteBuffer d() {
        if (i()) {
            return this.f9290d;
        }
        return null;
    }

    @p0
    public MediaCodec.BufferInfo e() {
        if (i()) {
            return this.f9287a;
        }
        return null;
    }

    @p0
    public Format f() {
        i();
        return this.f9289c;
    }

    public boolean g() {
        return this.f9294h && this.f9292f == -1;
    }

    @EnsuresNonNullIf(expression = {"#1.data"}, result = true)
    public boolean h(DecoderInputBuffer decoderInputBuffer) {
        if (this.f9293g) {
            return false;
        }
        if (this.f9291e < 0) {
            int iF = this.f9288b.f();
            this.f9291e = iF;
            if (iF < 0) {
                return false;
            }
            decoderInputBuffer.f16960c = this.f9288b.j(iF);
            decoderInputBuffer.h();
        }
        hd.a.g(decoderInputBuffer.f16960c);
        return true;
    }

    public final boolean i() {
        if (this.f9292f >= 0) {
            return true;
        }
        if (this.f9294h) {
            return false;
        }
        int iG = this.f9288b.g(this.f9287a);
        this.f9292f = iG;
        if (iG < 0) {
            if (iG == -2) {
                this.f9289c = c(this.f9288b.c());
            }
            return false;
        }
        MediaCodec.BufferInfo bufferInfo = this.f9287a;
        int i10 = bufferInfo.flags;
        if ((i10 & 4) != 0) {
            this.f9294h = true;
            if (bufferInfo.size == 0) {
                l();
                return false;
            }
        }
        if ((i10 & 2) != 0) {
            l();
            return false;
        }
        ByteBuffer byteBuffer = (ByteBuffer) hd.a.g(this.f9288b.m(iG));
        this.f9290d = byteBuffer;
        byteBuffer.position(this.f9287a.offset);
        ByteBuffer byteBuffer2 = this.f9290d;
        MediaCodec.BufferInfo bufferInfo2 = this.f9287a;
        byteBuffer2.limit(bufferInfo2.offset + bufferInfo2.size);
        return true;
    }

    public void j(DecoderInputBuffer decoderInputBuffer) {
        int iPosition;
        int iRemaining;
        int i10;
        hd.a.j(!this.f9293g, "Input buffer can not be queued after the input stream has ended.");
        ByteBuffer byteBuffer = decoderInputBuffer.f16960c;
        if (byteBuffer == null || !byteBuffer.hasRemaining()) {
            iPosition = 0;
            iRemaining = 0;
        } else {
            iPosition = decoderInputBuffer.f16960c.position();
            iRemaining = decoderInputBuffer.f16960c.remaining();
        }
        if (decoderInputBuffer.m()) {
            this.f9293g = true;
            i10 = 4;
        } else {
            i10 = 0;
        }
        this.f9288b.l(this.f9291e, iPosition, iRemaining, decoderInputBuffer.f16962e, i10);
        this.f9291e = -1;
        decoderInputBuffer.f16960c = null;
    }

    public void k() {
        this.f9290d = null;
        this.f9288b.release();
    }

    public void l() {
        this.f9290d = null;
        this.f9288b.i(this.f9292f, false);
        this.f9292f = -1;
    }
}
