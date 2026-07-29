package na;

import la.m;

/* JADX INFO: loaded from: classes3.dex */
public class c implements f {
    @Override // na.f
    public float a(qa.f fVar, pa.g gVar) {
        float yChartMax = gVar.getYChartMax();
        float yChartMin = gVar.getYChartMin();
        m lineData = gVar.getLineData();
        if (fVar.q() > 0.0f && fVar.L() < 0.0f) {
            return 0.0f;
        }
        if (lineData.z() > 0.0f) {
            yChartMax = 0.0f;
        }
        if (lineData.B() < 0.0f) {
            yChartMin = 0.0f;
        }
        return fVar.L() >= 0.0f ? yChartMin : yChartMax;
    }
}
