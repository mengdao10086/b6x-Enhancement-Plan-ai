package hb;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import hd.u0;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class w {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f30920c = "com.apple.iTunes";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f30921d = "iTunSMPB";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Pattern f30922e = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f30923a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f30924b = -1;

    public boolean a() {
        return (this.f30923a == -1 || this.f30924b == -1) ? false : true;
    }

    public final boolean b(String str) {
        Matcher matcher = f30922e.matcher(str);
        if (!matcher.find()) {
            return false;
        }
        try {
            int i10 = Integer.parseInt((String) u0.k(matcher.group(1)), 16);
            int i11 = Integer.parseInt((String) u0.k(matcher.group(2)), 16);
            if (i10 <= 0 && i11 <= 0) {
                return false;
            }
            this.f30923a = i10;
            this.f30924b = i11;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public boolean c(Metadata metadata) {
        for (int i10 = 0; i10 < metadata.g(); i10++) {
            Metadata.Entry entryE = metadata.e(i10);
            if (entryE instanceof CommentFrame) {
                CommentFrame commentFrame = (CommentFrame) entryE;
                if (f30921d.equals(commentFrame.f17297c) && b(commentFrame.f17298d)) {
                    return true;
                }
            } else if (entryE instanceof InternalFrame) {
                InternalFrame internalFrame = (InternalFrame) entryE;
                if (f30920c.equals(internalFrame.f17306b) && f30921d.equals(internalFrame.f17307c) && b(internalFrame.f17308d)) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    public boolean d(int i10) {
        int i11 = i10 >> 12;
        int i12 = i10 & 4095;
        if (i11 <= 0 && i12 <= 0) {
            return false;
        }
        this.f30923a = i11;
        this.f30924b = i12;
        return true;
    }
}
