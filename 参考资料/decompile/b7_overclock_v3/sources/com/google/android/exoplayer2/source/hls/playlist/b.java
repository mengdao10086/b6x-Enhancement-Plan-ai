package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.offline.StreamKey;
import g.p0;
import hd.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lc.e;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends e {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final b f18000n = new b("", Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), null, Collections.emptyList(), false, Collections.emptyMap(), Collections.emptyList());

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f18001o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f18002p = 1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f18003q = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Uri> f18004d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<C0188b> f18005e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<a> f18006f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<a> f18007g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<a> f18008h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<a> f18009i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @p0
    public final Format f18010j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @p0
    public final List<Format> f18011k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map<String, String> f18012l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<DrmInitData> f18013m;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @p0
        public final Uri f18014a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Format f18015b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f18016c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f18017d;

        public a(@p0 Uri uri, Format format, String str, String str2) {
            this.f18014a = uri;
            this.f18015b = format;
            this.f18016c = str;
            this.f18017d = str2;
        }
    }

    /* JADX INFO: renamed from: com.google.android.exoplayer2.source.hls.playlist.b$b, reason: collision with other inner class name */
    public static final class C0188b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f18018a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Format f18019b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @p0
        public final String f18020c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @p0
        public final String f18021d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @p0
        public final String f18022e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @p0
        public final String f18023f;

        public C0188b(Uri uri, Format format, @p0 String str, @p0 String str2, @p0 String str3, @p0 String str4) {
            this.f18018a = uri;
            this.f18019b = format;
            this.f18020c = str;
            this.f18021d = str2;
            this.f18022e = str3;
            this.f18023f = str4;
        }

        public static C0188b b(Uri uri) {
            return new C0188b(uri, new Format.b().S("0").K(w.f31189i0).E(), null, null, null, null);
        }

        public C0188b a(Format format) {
            return new C0188b(this.f18018a, format, this.f18020c, this.f18021d, this.f18022e, this.f18023f);
        }
    }

    public b(String str, List<String> list, List<C0188b> list2, List<a> list3, List<a> list4, List<a> list5, List<a> list6, @p0 Format format, @p0 List<Format> list7, boolean z10, Map<String, String> map, List<DrmInitData> list8) {
        super(str, list, z10);
        this.f18004d = Collections.unmodifiableList(f(list2, list3, list4, list5, list6));
        this.f18005e = Collections.unmodifiableList(list2);
        this.f18006f = Collections.unmodifiableList(list3);
        this.f18007g = Collections.unmodifiableList(list4);
        this.f18008h = Collections.unmodifiableList(list5);
        this.f18009i = Collections.unmodifiableList(list6);
        this.f18010j = format;
        this.f18011k = list7 != null ? Collections.unmodifiableList(list7) : null;
        this.f18012l = Collections.unmodifiableMap(map);
        this.f18013m = Collections.unmodifiableList(list8);
    }

    public static void b(List<a> list, List<Uri> list2) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            Uri uri = list.get(i10).f18014a;
            if (uri != null && !list2.contains(uri)) {
                list2.add(uri);
            }
        }
    }

    public static <T> List<T> d(List<T> list, int i10, List<StreamKey> list2) {
        ArrayList arrayList = new ArrayList(list2.size());
        for (int i11 = 0; i11 < list.size(); i11++) {
            T t10 = list.get(i11);
            int i12 = 0;
            while (true) {
                if (i12 < list2.size()) {
                    StreamKey streamKey = list2.get(i12);
                    if (streamKey.f17422b == i10 && streamKey.f17423c == i11) {
                        arrayList.add(t10);
                        break;
                    }
                    i12++;
                }
            }
        }
        return arrayList;
    }

    public static b e(String str) {
        return new b("", Collections.emptyList(), Collections.singletonList(C0188b.b(Uri.parse(str))), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), null, null, false, Collections.emptyMap(), Collections.emptyList());
    }

    public static List<Uri> f(List<C0188b> list, List<a> list2, List<a> list3, List<a> list4, List<a> list5) {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < list.size(); i10++) {
            Uri uri = list.get(i10).f18018a;
            if (!arrayList.contains(uri)) {
                arrayList.add(uri);
            }
        }
        b(list2, arrayList);
        b(list3, arrayList);
        b(list4, arrayList);
        b(list5, arrayList);
        return arrayList;
    }

    @Override // cc.y
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public b a(List<StreamKey> list) {
        return new b(this.f39566a, this.f39567b, d(this.f18005e, 0, list), Collections.emptyList(), d(this.f18007g, 1, list), d(this.f18008h, 2, list), Collections.emptyList(), this.f18010j, this.f18011k, this.f39568c, this.f18012l, this.f18013m);
    }
}
