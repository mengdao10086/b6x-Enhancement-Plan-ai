package ob;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry;
import com.google.common.net.HttpHeaders;
import g.i1;
import g.p0;
import hd.c0;
import hd.t;
import hd.w;

/* JADX INFO: loaded from: classes3.dex */
public final class h {
    public static final int A = 1885823344;
    public static final int B = 1936683886;
    public static final int C = 1953919848;
    public static final int D = 757935405;
    public static final int E = 3;

    @i1
    public static final String[] F = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", HttpHeaders.TRAILER, "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Afro-Punk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop", "Abstract", "Art Rock", "Baroque", "Bhangra", "Big beat", "Breakbeat", "Chillout", "Downtempo", "Dub", "EBM", "Eclectic", "Electro", "Electroclash", "Emo", "Experimental", "Garage", "Global", "IDM", "Illbient", "Industro-Goth", "Jam Band", "Krautrock", "Leftfield", "Lounge", "Math Rock", "New Romantic", "Nu-Breakz", "Post-Punk", "Post-Rock", "Psytrance", "Shoegaze", "Space Rock", "Trop Rock", "World Music", "Neoclassical", "Audiobook", "Audio theatre", "Neue Deutsche Welle", "Podcast", "Indie-Rock", "G-Funk", "Dubstep", "Garage Rock", "Psybient"};
    public static final String G = "und";
    public static final int H = 169;
    public static final int I = 253;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f43188a = "MetadataUtil";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f43189b = 7233901;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f43190c = 7631467;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f43191d = 6516084;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f43192e = 6578553;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f43193f = 4280916;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f43194g = 7630703;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f43195h = 6384738;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f43196i = 6516589;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f43197j = 7828084;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f43198k = 7108978;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f43199l = 6776174;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f43200m = 1668249202;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f43201n = 1735291493;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f43202o = 6779504;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f43203p = 1684632427;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f43204q = 1953655662;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f43205r = 1953329263;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f43206s = 1668311404;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f43207t = 1631670868;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f43208u = 1936682605;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f43209v = 1936679276;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f43210w = 1936679282;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f43211x = 1936679265;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f43212y = 1936679791;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f43213z = 1920233063;

    @p0
    public static CommentFrame a(int i10, c0 c0Var) {
        int iO = c0Var.o();
        if (c0Var.o() == 1684108385) {
            c0Var.T(8);
            String strB = c0Var.B(iO - 16);
            return new CommentFrame("und", strB, strB);
        }
        t.n(f43188a, "Failed to parse comment attribute: " + a.a(i10));
        return null;
    }

    @p0
    public static ApicFrame b(c0 c0Var) {
        int iO = c0Var.o();
        if (c0Var.o() != 1684108385) {
            t.n(f43188a, "Failed to parse cover art attribute");
            return null;
        }
        int iB = a.b(c0Var.o());
        String str = iB == 13 ? w.C0 : iB == 14 ? "image/png" : null;
        if (str == null) {
            t.n(f43188a, "Unrecognized cover art flags: " + iB);
            return null;
        }
        c0Var.T(4);
        int i10 = iO - 16;
        byte[] bArr = new byte[i10];
        c0Var.k(bArr, 0, i10);
        return new ApicFrame(str, null, 3, bArr);
    }

    @p0
    public static Metadata.Entry c(c0 c0Var) {
        int iE = c0Var.e() + c0Var.o();
        int iO = c0Var.o();
        int i10 = (iO >> 24) & 255;
        try {
            if (i10 == 169 || i10 == 253) {
                int i11 = 16777215 & iO;
                if (i11 == 6516084) {
                    return a(iO, c0Var);
                }
                if (i11 == 7233901 || i11 == 7631467) {
                    return h(iO, "TIT2", c0Var);
                }
                if (i11 == 6516589 || i11 == 7828084) {
                    return h(iO, "TCOM", c0Var);
                }
                if (i11 == 6578553) {
                    return h(iO, "TDRC", c0Var);
                }
                if (i11 == 4280916) {
                    return h(iO, "TPE1", c0Var);
                }
                if (i11 == 7630703) {
                    return h(iO, "TSSE", c0Var);
                }
                if (i11 == 6384738) {
                    return h(iO, "TALB", c0Var);
                }
                if (i11 == 7108978) {
                    return h(iO, "USLT", c0Var);
                }
                if (i11 == 6776174) {
                    return h(iO, "TCON", c0Var);
                }
                if (i11 == 6779504) {
                    return h(iO, "TIT1", c0Var);
                }
            } else {
                if (iO == 1735291493) {
                    return g(c0Var);
                }
                if (iO == 1684632427) {
                    return d(iO, "TPOS", c0Var);
                }
                if (iO == 1953655662) {
                    return d(iO, "TRCK", c0Var);
                }
                if (iO == 1953329263) {
                    return i(iO, "TBPM", c0Var, true, false);
                }
                if (iO == 1668311404) {
                    return i(iO, "TCMP", c0Var, true, true);
                }
                if (iO == 1668249202) {
                    return b(c0Var);
                }
                if (iO == 1631670868) {
                    return h(iO, "TPE2", c0Var);
                }
                if (iO == 1936682605) {
                    return h(iO, "TSOT", c0Var);
                }
                if (iO == 1936679276) {
                    return h(iO, "TSO2", c0Var);
                }
                if (iO == 1936679282) {
                    return h(iO, "TSOA", c0Var);
                }
                if (iO == 1936679265) {
                    return h(iO, "TSOP", c0Var);
                }
                if (iO == 1936679791) {
                    return h(iO, "TSOC", c0Var);
                }
                if (iO == 1920233063) {
                    return i(iO, "ITUNESADVISORY", c0Var, false, false);
                }
                if (iO == 1885823344) {
                    return i(iO, "ITUNESGAPLESS", c0Var, false, true);
                }
                if (iO == 1936683886) {
                    return h(iO, "TVSHOWSORT", c0Var);
                }
                if (iO == 1953919848) {
                    return h(iO, "TVSHOW", c0Var);
                }
                if (iO == 757935405) {
                    return e(c0Var, iE);
                }
            }
            t.b(f43188a, "Skipped unknown metadata entry: " + a.a(iO));
            return null;
        } finally {
            c0Var.S(iE);
        }
    }

    @p0
    public static TextInformationFrame d(int i10, String str, c0 c0Var) {
        int iO = c0Var.o();
        if (c0Var.o() == 1684108385 && iO >= 22) {
            c0Var.T(10);
            int iM = c0Var.M();
            if (iM > 0) {
                String str2 = "" + iM;
                int iM2 = c0Var.M();
                if (iM2 > 0) {
                    str2 = str2 + fh.a.f28350w + iM2;
                }
                return new TextInformationFrame(str, null, str2);
            }
        }
        t.n(f43188a, "Failed to parse index/count attribute: " + a.a(i10));
        return null;
    }

    @p0
    public static Id3Frame e(c0 c0Var, int i10) {
        String strB = null;
        String strB2 = null;
        int i11 = -1;
        int i12 = -1;
        while (c0Var.e() < i10) {
            int iE = c0Var.e();
            int iO = c0Var.o();
            int iO2 = c0Var.o();
            c0Var.T(4);
            if (iO2 == 1835360622) {
                strB = c0Var.B(iO - 12);
            } else if (iO2 == 1851878757) {
                strB2 = c0Var.B(iO - 12);
            } else {
                if (iO2 == 1684108385) {
                    i11 = iE;
                    i12 = iO;
                }
                c0Var.T(iO - 12);
            }
        }
        if (strB == null || strB2 == null || i11 == -1) {
            return null;
        }
        c0Var.S(i11);
        c0Var.T(16);
        return new InternalFrame(strB, strB2, c0Var.B(i12 - 16));
    }

    @p0
    public static MdtaMetadataEntry f(c0 c0Var, int i10, String str) {
        while (true) {
            int iE = c0Var.e();
            if (iE >= i10) {
                return null;
            }
            int iO = c0Var.o();
            if (c0Var.o() == 1684108385) {
                int iO2 = c0Var.o();
                int iO3 = c0Var.o();
                int i11 = iO - 16;
                byte[] bArr = new byte[i11];
                c0Var.k(bArr, 0, i11);
                return new MdtaMetadataEntry(str, bArr, iO3, iO2);
            }
            c0Var.S(iE + iO);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0011  */
    @g.p0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.exoplayer2.metadata.id3.TextInformationFrame g(hd.c0 r3) {
        /*
            int r3 = j(r3)
            r0 = 0
            if (r3 <= 0) goto L11
            java.lang.String[] r1 = ob.h.F
            int r2 = r1.length
            if (r3 > r2) goto L11
            int r3 = r3 + (-1)
            r3 = r1[r3]
            goto L12
        L11:
            r3 = r0
        L12:
            if (r3 == 0) goto L1c
            com.google.android.exoplayer2.metadata.id3.TextInformationFrame r1 = new com.google.android.exoplayer2.metadata.id3.TextInformationFrame
            java.lang.String r2 = "TCON"
            r1.<init>(r2, r0, r3)
            return r1
        L1c:
            java.lang.String r3 = "MetadataUtil"
            java.lang.String r1 = "Failed to parse standard genre code"
            hd.t.n(r3, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ob.h.g(hd.c0):com.google.android.exoplayer2.metadata.id3.TextInformationFrame");
    }

    @p0
    public static TextInformationFrame h(int i10, String str, c0 c0Var) {
        int iO = c0Var.o();
        if (c0Var.o() == 1684108385) {
            c0Var.T(8);
            return new TextInformationFrame(str, null, c0Var.B(iO - 16));
        }
        t.n(f43188a, "Failed to parse text attribute: " + a.a(i10));
        return null;
    }

    @p0
    public static Id3Frame i(int i10, String str, c0 c0Var, boolean z10, boolean z11) {
        int iJ = j(c0Var);
        if (z11) {
            iJ = Math.min(1, iJ);
        }
        if (iJ >= 0) {
            return z10 ? new TextInformationFrame(str, null, Integer.toString(iJ)) : new CommentFrame("und", str, Integer.toString(iJ));
        }
        t.n(f43188a, "Failed to parse uint8 attribute: " + a.a(i10));
        return null;
    }

    public static int j(c0 c0Var) {
        c0Var.T(4);
        if (c0Var.o() == 1684108385) {
            c0Var.T(8);
            return c0Var.G();
        }
        t.n(f43188a, "Failed to parse uint8 attribute value");
        return -1;
    }

    public static void k(int i10, hb.w wVar, Format.b bVar) {
        if (i10 == 1 && wVar.a()) {
            bVar.M(wVar.f30923a).N(wVar.f30924b);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void l(int r5, @g.p0 com.google.android.exoplayer2.metadata.Metadata r6, @g.p0 com.google.android.exoplayer2.metadata.Metadata r7, com.google.android.exoplayer2.Format.b r8, com.google.android.exoplayer2.metadata.Metadata... r9) {
        /*
            com.google.android.exoplayer2.metadata.Metadata r0 = new com.google.android.exoplayer2.metadata.Metadata
            r1 = 0
            com.google.android.exoplayer2.metadata.Metadata$Entry[] r2 = new com.google.android.exoplayer2.metadata.Metadata.Entry[r1]
            r0.<init>(r2)
            r2 = 1
            if (r5 != r2) goto Le
            if (r6 == 0) goto L3c
            goto L3d
        Le:
            r6 = 2
            if (r5 != r6) goto L3c
            if (r7 == 0) goto L3c
            r5 = 0
        L14:
            int r6 = r7.g()
            if (r5 >= r6) goto L3c
            com.google.android.exoplayer2.metadata.Metadata$Entry r6 = r7.e(r5)
            boolean r3 = r6 instanceof com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry
            if (r3 == 0) goto L39
            com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry r6 = (com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry) r6
            java.lang.String r3 = r6.f17323a
            java.lang.String r4 = "com.android.capture.fps"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L39
            com.google.android.exoplayer2.metadata.Metadata r5 = new com.google.android.exoplayer2.metadata.Metadata
            com.google.android.exoplayer2.metadata.Metadata$Entry[] r7 = new com.google.android.exoplayer2.metadata.Metadata.Entry[r2]
            r7[r1] = r6
            r5.<init>(r7)
            r6 = r5
            goto L3d
        L39:
            int r5 = r5 + 1
            goto L14
        L3c:
            r6 = r0
        L3d:
            int r5 = r9.length
        L3e:
            if (r1 >= r5) goto L49
            r7 = r9[r1]
            com.google.android.exoplayer2.metadata.Metadata r6 = r6.b(r7)
            int r1 = r1 + 1
            goto L3e
        L49:
            int r5 = r6.g()
            if (r5 <= 0) goto L52
            r8.X(r6)
        L52:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ob.h.l(int, com.google.android.exoplayer2.metadata.Metadata, com.google.android.exoplayer2.metadata.Metadata, com.google.android.exoplayer2.Format$b, com.google.android.exoplayer2.metadata.Metadata[]):void");
    }
}
