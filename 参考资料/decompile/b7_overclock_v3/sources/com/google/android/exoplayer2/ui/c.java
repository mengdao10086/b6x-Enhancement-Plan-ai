package com.google.android.exoplayer2.ui;

import android.content.res.Resources;
import android.text.TextUtils;
import cd.k0;
import com.google.android.exoplayer2.Format;
import hd.u0;
import hd.w;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class c implements k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Resources f18728a;

    public c(Resources resources) {
        this.f18728a = (Resources) hd.a.g(resources);
    }

    public static int i(Format format) {
        int iL = w.l(format.f16699l);
        if (iL != -1) {
            return iL;
        }
        if (w.o(format.f16695i) != null) {
            return 2;
        }
        if (w.c(format.f16695i) != null) {
            return 1;
        }
        if (format.f16704q == -1 && format.f16705r == -1) {
            return (format.f16712y == -1 && format.f16713z == -1) ? -1 : 1;
        }
        return 2;
    }

    @Override // cd.k0
    public String a(Format format) {
        int i10 = i(format);
        String strJ = i10 == 2 ? j(h(format), g(format), c(format)) : i10 == 1 ? j(e(format), b(format), c(format)) : e(format);
        return strJ.length() == 0 ? this.f18728a.getString(R.string.exo_track_unknown) : strJ;
    }

    public final String b(Format format) {
        int i10 = format.f16712y;
        return (i10 == -1 || i10 < 1) ? "" : i10 != 1 ? i10 != 2 ? (i10 == 6 || i10 == 7) ? this.f18728a.getString(R.string.exo_track_surround_5_point_1) : i10 != 8 ? this.f18728a.getString(R.string.exo_track_surround) : this.f18728a.getString(R.string.exo_track_surround_7_point_1) : this.f18728a.getString(R.string.exo_track_stereo) : this.f18728a.getString(R.string.exo_track_mono);
    }

    public final String c(Format format) {
        int i10 = format.f16694h;
        return i10 == -1 ? "" : this.f18728a.getString(R.string.exo_track_bitrate, Float.valueOf(i10 / 1000000.0f));
    }

    public final String d(Format format) {
        return TextUtils.isEmpty(format.f16688b) ? "" : format.f16688b;
    }

    public final String e(Format format) {
        String strJ = j(f(format), h(format));
        return TextUtils.isEmpty(strJ) ? d(format) : strJ;
    }

    public final String f(Format format) {
        String str = format.f16689c;
        if (TextUtils.isEmpty(str) || "und".equals(str)) {
            return "";
        }
        return (u0.f31154a >= 21 ? Locale.forLanguageTag(str) : new Locale(str)).getDisplayName();
    }

    public final String g(Format format) {
        int i10 = format.f16704q;
        int i11 = format.f16705r;
        return (i10 == -1 || i11 == -1) ? "" : this.f18728a.getString(R.string.exo_track_resolution, Integer.valueOf(i10), Integer.valueOf(i11));
    }

    public final String h(Format format) {
        String string = (format.f16691e & 2) != 0 ? this.f18728a.getString(R.string.exo_track_role_alternate) : "";
        if ((format.f16691e & 4) != 0) {
            string = j(string, this.f18728a.getString(R.string.exo_track_role_supplementary));
        }
        if ((format.f16691e & 8) != 0) {
            string = j(string, this.f18728a.getString(R.string.exo_track_role_commentary));
        }
        return (format.f16691e & rs.d.f49161j) != 0 ? j(string, this.f18728a.getString(R.string.exo_track_role_closed_captions)) : string;
    }

    public final String j(String... strArr) {
        String string = "";
        for (String str : strArr) {
            if (str.length() > 0) {
                string = TextUtils.isEmpty(string) ? str : this.f18728a.getString(R.string.exo_item_list, string, str);
            }
        }
        return string;
    }
}
