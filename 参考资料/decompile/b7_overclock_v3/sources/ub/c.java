package ub;

import com.google.android.exoplayer2.Format;
import hd.w;

/* JADX INFO: loaded from: classes3.dex */
public interface c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f51972a = new a();

    public class a implements c {
        @Override // ub.c
        public boolean a(Format format) {
            String str = format.f16699l;
            return w.f31193k0.equals(str) || w.f31219x0.equals(str) || w.f31215v0.equals(str) || w.A0.equals(str) || w.B0.equals(str);
        }

        @Override // ub.c
        public b b(Format format) {
            String str = format.f16699l;
            if (str != null) {
                switch (str) {
                    case "application/vnd.dvb.ait":
                        return new vb.a();
                    case "application/x-icy":
                        return new yb.a();
                    case "application/id3":
                        return new zb.b();
                    case "application/x-emsg":
                        return new wb.a();
                    case "application/x-scte35":
                        return new bc.a();
                }
            }
            throw new IllegalArgumentException("Attempted to create decoder for unsupported MIME type: " + str);
        }
    }

    boolean a(Format format);

    b b(Format format);
}
