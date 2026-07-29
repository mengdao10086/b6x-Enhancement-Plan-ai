package vd;

import android.content.Context;
import android.util.Pair;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final short f52986a = 2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final short f52987b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final short f52988c = 512;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final short f52989d = 513;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final short f52990e = 514;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final byte f52991f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final byte f52992g = 127;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f52993h = "color";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static byte f52994i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final C0618d f52995j = new C0618d(1, l4.f.f39447b);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Comparator<b> f52996k = new a();

    public class a implements Comparator<b> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(b bVar, b bVar2) {
            return bVar.f52999c - bVar2.f52999c;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte f52997a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte f52998b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final short f52999c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f53000d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @g.l
        public final int f53001e;

        public b(int i10, String str, int i11) {
            this.f53000d = str;
            this.f53001e = i11;
            this.f52999c = (short) (65535 & i10);
            this.f52998b = (byte) ((i10 >> 16) & 255);
            this.f52997a = (byte) ((i10 >> 24) & 255);
        }
    }

    public static class c {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final short f53002f = 288;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f53003g = 128;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f53004a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C0618d f53005b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final h f53006c = new h(false, "?1", "?2", "?3", "?4", "?5", "color");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final h f53007d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final k f53008e;

        public c(C0618d c0618d, List<b> list) {
            this.f53005b = c0618d;
            String[] strArr = new String[list.size()];
            for (int i10 = 0; i10 < list.size(); i10++) {
                strArr[i10] = list.get(i10).f53000d;
            }
            this.f53007d = new h(true, strArr);
            this.f53008e = new k(list);
            this.f53004a = new e(d.f52988c, f53002f, a());
        }

        public int a() {
            return this.f53006c.a() + 288 + this.f53007d.a() + this.f53008e.b();
        }

        public void b(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
            this.f53004a.a(byteArrayOutputStream);
            byteArrayOutputStream.write(d.j(this.f53005b.f53009a));
            char[] charArray = this.f53005b.f53010b.toCharArray();
            for (int i10 = 0; i10 < 128; i10++) {
                if (i10 < charArray.length) {
                    byteArrayOutputStream.write(d.h(charArray[i10]));
                } else {
                    byteArrayOutputStream.write(d.h((char) 0));
                }
            }
            byteArrayOutputStream.write(d.j(288));
            byteArrayOutputStream.write(d.j(0));
            byteArrayOutputStream.write(d.j(this.f53006c.a() + 288));
            byteArrayOutputStream.write(d.j(0));
            byteArrayOutputStream.write(d.j(0));
            this.f53006c.c(byteArrayOutputStream);
            this.f53007d.c(byteArrayOutputStream);
            this.f53008e.c(byteArrayOutputStream);
        }
    }

    /* JADX INFO: renamed from: vd.d$d, reason: collision with other inner class name */
    public static class C0618d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f53009a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f53010b;

        public C0618d(int i10, String str) {
            this.f53009a = i10;
            this.f53010b = str;
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final short f53011a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final short f53012b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f53013c;

        public e(short s10, short s11, int i10) {
            this.f53011a = s10;
            this.f53012b = s11;
            this.f53013c = i10;
        }

        public void a(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
            byteArrayOutputStream.write(d.k(this.f53011a));
            byteArrayOutputStream.write(d.k(this.f53012b));
            byteArrayOutputStream.write(d.j(this.f53013c));
        }
    }

    public static class f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final short f53014c = 8;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final short f53015d = 2;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final short f53016e = 8;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final byte f53017f = 28;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f53018g = 16;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f53019a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f53020b;

        public f(int i10, @g.l int i11) {
            this.f53019a = i10;
            this.f53020b = i11;
        }

        public void a(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
            byteArrayOutputStream.write(d.k((short) 8));
            byteArrayOutputStream.write(d.k((short) 2));
            byteArrayOutputStream.write(d.j(this.f53019a));
            byteArrayOutputStream.write(d.k((short) 8));
            byteArrayOutputStream.write(new byte[]{0, 28});
            byteArrayOutputStream.write(d.j(this.f53020b));
        }
    }

    public static class g {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final short f53021e = 12;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f53022a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f53023b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<c> f53025d = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final h f53024c = new h(new String[0]);

        public g(Map<C0618d, List<b>> map) {
            this.f53023b = map.size();
            for (Map.Entry<C0618d, List<b>> entry : map.entrySet()) {
                List<b> value = entry.getValue();
                Collections.sort(value, d.f52996k);
                this.f53025d.add(new c(entry.getKey(), value));
            }
            this.f53022a = new e((short) 2, (short) 12, a());
        }

        public final int a() {
            Iterator<c> it2 = this.f53025d.iterator();
            int iA = 0;
            while (it2.hasNext()) {
                iA += it2.next().a();
            }
            return this.f53024c.a() + 12 + iA;
        }

        public void b(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
            this.f53022a.a(byteArrayOutputStream);
            byteArrayOutputStream.write(d.j(this.f53023b));
            this.f53024c.c(byteArrayOutputStream);
            Iterator<c> it2 = this.f53025d.iterator();
            while (it2.hasNext()) {
                it2.next().b(byteArrayOutputStream);
            }
        }
    }

    public static class h {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final short f53026m = 28;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final int f53027n = 256;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final int f53028o = -1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f53029a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f53030b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f53031c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f53032d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f53033e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final List<Integer> f53034f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final List<Integer> f53035g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final List<byte[]> f53036h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final List<List<i>> f53037i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final boolean f53038j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f53039k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final int f53040l;

        public h(String... strArr) {
            this(false, strArr);
        }

        public int a() {
            return this.f53040l;
        }

        public final Pair<byte[], List<i>> b(String str) {
            return new Pair<>(this.f53038j ? d.m(str) : d.l(str), Collections.emptyList());
        }

        public void c(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
            this.f53029a.a(byteArrayOutputStream);
            byteArrayOutputStream.write(d.j(this.f53030b));
            byteArrayOutputStream.write(d.j(this.f53031c));
            byteArrayOutputStream.write(d.j(this.f53038j ? 256 : 0));
            byteArrayOutputStream.write(d.j(this.f53032d));
            byteArrayOutputStream.write(d.j(this.f53033e));
            Iterator<Integer> it2 = this.f53034f.iterator();
            while (it2.hasNext()) {
                byteArrayOutputStream.write(d.j(it2.next().intValue()));
            }
            Iterator<Integer> it3 = this.f53035g.iterator();
            while (it3.hasNext()) {
                byteArrayOutputStream.write(d.j(it3.next().intValue()));
            }
            Iterator<byte[]> it4 = this.f53036h.iterator();
            while (it4.hasNext()) {
                byteArrayOutputStream.write(it4.next());
            }
            int i10 = this.f53039k;
            if (i10 > 0) {
                byteArrayOutputStream.write(new byte[i10]);
            }
            Iterator<List<i>> it5 = this.f53037i.iterator();
            while (it5.hasNext()) {
                Iterator<i> it6 = it5.next().iterator();
                while (it6.hasNext()) {
                    it6.next().b(byteArrayOutputStream);
                }
                byteArrayOutputStream.write(d.j(-1));
            }
        }

        public h(boolean z10, String... strArr) {
            this.f53034f = new ArrayList();
            this.f53035g = new ArrayList();
            this.f53036h = new ArrayList();
            this.f53037i = new ArrayList();
            this.f53038j = z10;
            int length = 0;
            for (String str : strArr) {
                Pair<byte[], List<i>> pairB = b(str);
                this.f53034f.add(Integer.valueOf(length));
                Object obj = pairB.first;
                length += ((byte[]) obj).length;
                this.f53036h.add((byte[]) obj);
                this.f53037i.add((List) pairB.second);
            }
            int size = 0;
            for (List<i> list : this.f53037i) {
                for (i iVar : list) {
                    this.f53034f.add(Integer.valueOf(length));
                    length += iVar.f53041a.length;
                    this.f53036h.add(iVar.f53041a);
                }
                this.f53035g.add(Integer.valueOf(size));
                size += (list.size() * 12) + 4;
            }
            int i10 = length % 4;
            int i11 = i10 == 0 ? 0 : 4 - i10;
            this.f53039k = i11;
            int size2 = this.f53036h.size();
            this.f53030b = size2;
            this.f53031c = this.f53036h.size() - strArr.length;
            boolean z11 = this.f53036h.size() - strArr.length > 0;
            if (!z11) {
                this.f53035g.clear();
                this.f53037i.clear();
            }
            int size3 = (size2 * 4) + 28 + (this.f53035g.size() * 4);
            this.f53032d = size3;
            int i12 = length + i11;
            this.f53033e = z11 ? size3 + i12 : 0;
            int i13 = size3 + i12 + (z11 ? size : 0);
            this.f53040l = i13;
            this.f53029a = new e((short) 1, (short) 28, i13);
        }
    }

    public static class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f53041a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f53042b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f53043c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f53044d;

        public void b(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
            byteArrayOutputStream.write(d.j(this.f53042b));
            byteArrayOutputStream.write(d.j(this.f53043c));
            byteArrayOutputStream.write(d.j(this.f53044d));
        }
    }

    public static class j {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f53045f = -1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final short f53046g = 84;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final byte f53047h = 64;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f53048a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f53049b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f53050c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int[] f53051d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final f[] f53052e;

        public j(List<b> list, Set<Short> set, int i10) {
            byte[] bArr = new byte[64];
            this.f53050c = bArr;
            this.f53049b = i10;
            bArr[0] = 64;
            this.f53052e = new f[list.size()];
            for (int i11 = 0; i11 < list.size(); i11++) {
                this.f53052e[i11] = new f(i11, list.get(i11).f53001e);
            }
            this.f53051d = new int[i10];
            int i12 = 0;
            for (short s10 = 0; s10 < i10; s10 = (short) (s10 + 1)) {
                if (set.contains(Short.valueOf(s10))) {
                    this.f53051d[s10] = i12;
                    i12 += 16;
                } else {
                    this.f53051d[s10] = -1;
                }
            }
            this.f53048a = new e(d.f52989d, (short) 84, a());
        }

        public int a() {
            return b() + (this.f53052e.length * 16);
        }

        public final int b() {
            return c() + 84;
        }

        public final int c() {
            return this.f53051d.length * 4;
        }

        public void d(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
            this.f53048a.a(byteArrayOutputStream);
            byteArrayOutputStream.write(new byte[]{d.f52994i, 0, 0, 0});
            byteArrayOutputStream.write(d.j(this.f53049b));
            byteArrayOutputStream.write(d.j(b()));
            byteArrayOutputStream.write(this.f53050c);
            for (int i10 : this.f53051d) {
                byteArrayOutputStream.write(d.j(i10));
            }
            for (f fVar : this.f53052e) {
                fVar.a(byteArrayOutputStream);
            }
        }
    }

    public static class k {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final short f53053e = 16;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f53054f = 1073741824;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f53055a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f53056b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int[] f53057c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final j f53058d;

        public k(List<b> list) {
            this.f53056b = list.get(list.size() - 1).f52999c + 1;
            HashSet hashSet = new HashSet();
            Iterator<b> it2 = list.iterator();
            while (it2.hasNext()) {
                hashSet.add(Short.valueOf(it2.next().f52999c));
            }
            this.f53057c = new int[this.f53056b];
            for (short s10 = 0; s10 < this.f53056b; s10 = (short) (s10 + 1)) {
                if (hashSet.contains(Short.valueOf(s10))) {
                    this.f53057c[s10] = 1073741824;
                }
            }
            this.f53055a = new e(d.f52990e, (short) 16, a());
            this.f53058d = new j(list, hashSet, this.f53056b);
        }

        public final int a() {
            return (this.f53056b * 4) + 16;
        }

        public int b() {
            return a() + this.f53058d.a();
        }

        public void c(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
            this.f53055a.a(byteArrayOutputStream);
            byteArrayOutputStream.write(new byte[]{d.f52994i, 0, 0, 0});
            byteArrayOutputStream.write(d.j(this.f53056b));
            for (int i10 : this.f53057c) {
                byteArrayOutputStream.write(d.j(i10));
            }
            this.f53058d.d(byteArrayOutputStream);
        }
    }

    public static byte[] h(char c10) {
        return new byte[]{(byte) (c10 & 255), (byte) ((c10 >> '\b') & 255)};
    }

    public static byte[] i(Context context, Map<Integer, Integer> map) throws IOException {
        C0618d c0618d;
        if (map.entrySet().isEmpty()) {
            throw new IllegalArgumentException("No color resources provided for harmonization.");
        }
        C0618d c0618d2 = new C0618d(127, context.getPackageName());
        HashMap map2 = new HashMap();
        b bVar = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            b bVar2 = new b(entry.getKey().intValue(), context.getResources().getResourceName(entry.getKey().intValue()), entry.getValue().intValue());
            if (!context.getResources().getResourceTypeName(entry.getKey().intValue()).equals("color")) {
                throw new IllegalArgumentException("Non color resource found: name=" + bVar2.f53000d + ", typeId=" + Integer.toHexString(bVar2.f52998b & 255));
            }
            if (bVar2.f52997a == 1) {
                c0618d = f52995j;
            } else {
                if (bVar2.f52997a != 127) {
                    throw new IllegalArgumentException("Not supported with unknown package id: " + ((int) bVar2.f52997a));
                }
                c0618d = c0618d2;
            }
            if (!map2.containsKey(c0618d)) {
                map2.put(c0618d, new ArrayList());
            }
            ((List) map2.get(c0618d)).add(bVar2);
            bVar = bVar2;
        }
        byte b10 = bVar.f52998b;
        f52994i = b10;
        if (b10 == 0) {
            throw new IllegalArgumentException("No color resources found for harmonization.");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new g(map2).b(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] j(int i10) {
        return new byte[]{(byte) (i10 & 255), (byte) ((i10 >> 8) & 255), (byte) ((i10 >> 16) & 255), (byte) ((i10 >> 24) & 255)};
    }

    public static byte[] k(short s10) {
        return new byte[]{(byte) (s10 & 255), (byte) ((s10 >> 8) & 255)};
    }

    public static byte[] l(String str) {
        char[] charArray = str.toCharArray();
        int length = (charArray.length * 2) + 4;
        byte[] bArr = new byte[length];
        byte[] bArrK = k((short) charArray.length);
        bArr[0] = bArrK[0];
        bArr[1] = bArrK[1];
        for (int i10 = 0; i10 < charArray.length; i10++) {
            byte[] bArrH = h(charArray[i10]);
            int i11 = i10 * 2;
            bArr[i11 + 2] = bArrH[0];
            bArr[i11 + 3] = bArrH[1];
        }
        bArr[length - 2] = 0;
        bArr[length - 1] = 0;
        return bArr;
    }

    public static byte[] m(String str) {
        byte[] bytes = str.getBytes(Charset.forName("UTF-8"));
        byte length = (byte) bytes.length;
        int length2 = bytes.length + 3;
        byte[] bArr = new byte[length2];
        System.arraycopy(bytes, 0, bArr, 2, length);
        bArr[1] = length;
        bArr[0] = length;
        bArr[length2 - 1] = 0;
        return bArr;
    }
}
