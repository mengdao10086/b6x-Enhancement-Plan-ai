package qc;

import com.google.android.exoplayer2.Format;
import hd.w;

/* JADX INFO: loaded from: classes3.dex */
public interface h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f47267a = new a();

    public class a implements h {
        @Override // qc.h
        public boolean a(Format format) {
            String str = format.f16699l;
            return w.f31177c0.equals(str) || w.f31179d0.equals(str) || w.f31201o0.equals(str) || w.f31205q0.equals(str) || w.f31199n0.equals(str) || w.f31203p0.equals(str) || w.f31195l0.equals(str) || w.f31207r0.equals(str) || w.f31197m0.equals(str) || w.f31221y0.equals(str) || w.f31213u0.equals(str);
        }

        @Override // qc.h
        public g b(Format format) {
            String str = format.f16699l;
            if (str != null) {
                switch (str) {
                    case "application/dvbsubs":
                        return new sc.a(format.f16701n);
                    case "application/pgs":
                        return new tc.a();
                    case "application/x-mp4-vtt":
                        return new zc.b();
                    case "text/vtt":
                        return new zc.h();
                    case "application/x-quicktime-tx3g":
                        return new yc.a(format.f16701n);
                    case "text/x-ssa":
                        return new vc.a(format.f16701n);
                    case "application/x-mp4-cea-608":
                    case "application/cea-608":
                        return new rc.a(str, format.D, rc.a.A);
                    case "application/cea-708":
                        return new rc.c(format.D, format.f16701n);
                    case "application/x-subrip":
                        return new wc.a();
                    case "application/ttml+xml":
                        return new xc.c();
                }
            }
            throw new IllegalArgumentException("Attempted to create decoder for unsupported MIME type: " + str);
        }
    }

    boolean a(Format format);

    g b(Format format);
}
