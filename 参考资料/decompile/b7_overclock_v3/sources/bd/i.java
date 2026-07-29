package bd;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.SlowMotionData;
import com.google.android.exoplayer2.metadata.mp4.SmtaMetadataEntry;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSortedMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes3.dex */
public class i implements j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f9326c = 30;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImmutableSortedMap<Long, Float> f9327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f9328b;

    public i(Format format) {
        float fD = d(format);
        float f10 = fD == -3.4028235E38f ? 1.0f : fD / 30.0f;
        this.f9328b = f10;
        this.f9327a = b(format, f10);
    }

    public static ImmutableSortedMap<Long, Float> b(Format format, float f10) {
        ImmutableList<SlowMotionData.Segment> immutableListC = c(format);
        if (immutableListC.isEmpty()) {
            return ImmutableSortedMap.of();
        }
        TreeMap treeMap = new TreeMap();
        for (int i10 = 0; i10 < immutableListC.size(); i10++) {
            treeMap.put(Long.valueOf(ya.g.c(immutableListC.get(i10).f17334a)), Float.valueOf(f10 / r3.f17336c));
        }
        for (int i11 = 0; i11 < immutableListC.size(); i11++) {
            SlowMotionData.Segment segment = immutableListC.get(i11);
            if (!treeMap.containsKey(Long.valueOf(ya.g.c(segment.f17335b)))) {
                treeMap.put(Long.valueOf(ya.g.c(segment.f17335b)), Float.valueOf(f10));
            }
        }
        return ImmutableSortedMap.copyOf((Map) treeMap);
    }

    public static ImmutableList<SlowMotionData.Segment> c(Format format) {
        ArrayList arrayList = new ArrayList();
        Metadata metadata = format.f16696j;
        if (metadata != null) {
            for (int i10 = 0; i10 < metadata.g(); i10++) {
                Metadata.Entry entryE = metadata.e(i10);
                if (entryE instanceof SlowMotionData) {
                    arrayList.addAll(((SlowMotionData) entryE).f17332a);
                }
            }
        }
        return ImmutableList.sortedCopyOf(SlowMotionData.Segment.f17333d, arrayList);
    }

    public static float d(Format format) {
        Metadata metadata = format.f16696j;
        if (metadata == null) {
            return -3.4028235E38f;
        }
        for (int i10 = 0; i10 < metadata.g(); i10++) {
            Metadata.Entry entryE = metadata.e(i10);
            if (entryE instanceof SmtaMetadataEntry) {
                return ((SmtaMetadataEntry) entryE).f17337a;
            }
        }
        return -3.4028235E38f;
    }

    @Override // bd.j
    public float a(long j10) {
        hd.a.a(j10 >= 0);
        Map.Entry<Long, Float> entryFloorEntry = this.f9327a.floorEntry(Long.valueOf(j10));
        return entryFloorEntry != null ? entryFloorEntry.getValue().floatValue() : this.f9328b;
    }
}
