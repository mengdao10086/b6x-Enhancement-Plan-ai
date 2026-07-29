package af;

import com.google.zxing.common.CharacterSetECI;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public final class g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<CharsetEncoder> f602c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ boolean f603d = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharsetEncoder[] f604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f605b;

    static {
        String[] strArr = {"IBM437", "ISO-8859-2", "ISO-8859-3", "ISO-8859-4", "ISO-8859-5", "ISO-8859-6", "ISO-8859-7", "ISO-8859-8", "ISO-8859-9", "ISO-8859-10", "ISO-8859-11", "ISO-8859-13", "ISO-8859-14", "ISO-8859-15", "ISO-8859-16", "windows-1250", "windows-1251", "windows-1252", "windows-1256", "Shift_JIS"};
        for (int i10 = 0; i10 < 20; i10++) {
            String str = strArr[i10];
            if (CharacterSetECI.getCharacterSetECIByName(str) != null) {
                try {
                    f602c.add(Charset.forName(str).newEncoder());
                } catch (UnsupportedCharsetException unused) {
                }
            }
        }
    }

    public g(String str, Charset charset, int i10) {
        boolean z10;
        ArrayList<CharsetEncoder> arrayList = new ArrayList();
        arrayList.add(StandardCharsets.ISO_8859_1.newEncoder());
        int i11 = 0;
        boolean z11 = charset != null && charset.name().startsWith("UTF");
        for (int i12 = 0; i12 < str.length(); i12++) {
            for (CharsetEncoder charsetEncoder : arrayList) {
                char cCharAt = str.charAt(i12);
                if (cCharAt == i10 || charsetEncoder.canEncode(cCharAt)) {
                    z10 = true;
                    break;
                }
            }
            z10 = false;
            if (!z10) {
                Iterator<CharsetEncoder> it2 = f602c.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    CharsetEncoder next = it2.next();
                    if (next.canEncode(str.charAt(i12))) {
                        arrayList.add(next);
                        z10 = true;
                        break;
                    }
                }
            }
            if (!z10) {
                z11 = true;
            }
        }
        if (arrayList.size() != 1 || z11) {
            this.f604a = new CharsetEncoder[arrayList.size() + 2];
            Iterator it3 = arrayList.iterator();
            int i13 = 0;
            while (it3.hasNext()) {
                this.f604a[i13] = (CharsetEncoder) it3.next();
                i13++;
            }
            this.f604a[i13] = StandardCharsets.UTF_8.newEncoder();
            this.f604a[i13 + 1] = StandardCharsets.UTF_16BE.newEncoder();
        } else {
            this.f604a = new CharsetEncoder[]{(CharsetEncoder) arrayList.get(0)};
        }
        int i14 = -1;
        if (charset != null) {
            while (true) {
                CharsetEncoder[] charsetEncoderArr = this.f604a;
                if (i11 >= charsetEncoderArr.length) {
                    break;
                }
                if (charsetEncoderArr[i11] != null && charset.name().equals(this.f604a[i11].charset().name())) {
                    i14 = i11;
                    break;
                }
                i11++;
            }
        }
        this.f605b = i14;
    }

    public boolean a(char c10, int i10) {
        return this.f604a[i10].canEncode("" + c10);
    }

    public byte[] b(char c10, int i10) {
        return ("" + c10).getBytes(this.f604a[i10].charset());
    }

    public byte[] c(String str, int i10) {
        return str.getBytes(this.f604a[i10].charset());
    }

    public Charset d(int i10) {
        return this.f604a[i10].charset();
    }

    public String e(int i10) {
        return this.f604a[i10].charset().name();
    }

    public int f(int i10) {
        return CharacterSetECI.getCharacterSetECI(this.f604a[i10].charset()).getValue();
    }

    public int g() {
        return this.f605b;
    }

    public int h() {
        return this.f604a.length;
    }
}
