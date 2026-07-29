package yb;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.icy.IcyInfo;
import com.google.common.base.Charsets;
import g.p0;
import hd.u0;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ub.d;
import ub.f;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f57282c = Pattern.compile("(.+?)='(.*?)';", 32);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f57283d = "streamtitle";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f57284e = "streamurl";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharsetDecoder f57285a = Charsets.UTF_8.newDecoder();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharsetDecoder f57286b = Charsets.ISO_8859_1.newDecoder();

    @Override // ub.f
    public Metadata b(d dVar, ByteBuffer byteBuffer) {
        String strC = c(byteBuffer);
        byte[] bArr = new byte[byteBuffer.limit()];
        byteBuffer.get(bArr);
        String str = null;
        if (strC == null) {
            return new Metadata(new IcyInfo(bArr, null, null));
        }
        Matcher matcher = f57282c.matcher(strC);
        String str2 = null;
        for (int iEnd = 0; matcher.find(iEnd); iEnd = matcher.end()) {
            String strW1 = u0.w1(matcher.group(1));
            String strGroup = matcher.group(2);
            if (strW1 != null) {
                if (strW1.equals(f57284e)) {
                    str2 = strGroup;
                } else if (strW1.equals(f57283d)) {
                    str = strGroup;
                }
            }
        }
        return new Metadata(new IcyInfo(bArr, str, str2));
    }

    @p0
    public final String c(ByteBuffer byteBuffer) {
        try {
            return this.f57285a.decode(byteBuffer).toString();
        } catch (CharacterCodingException unused) {
            try {
                return this.f57286b.decode(byteBuffer).toString();
            } catch (CharacterCodingException unused2) {
                return null;
            } finally {
                this.f57286b.reset();
                byteBuffer.rewind();
            }
        } finally {
            this.f57285a.reset();
            byteBuffer.rewind();
        }
    }
}
