package androidx.constraintlayout.motion.widget;

/* JADX INFO: loaded from: classes2.dex */
public interface v {
    long a();

    int b(int cmd, String type, Object viewObject, float[] in2, int inLength, float[] out, int outLength);

    boolean c(Object view, int position, int type, float x10, float y10);

    void d(float position);

    Boolean e(Object keyFrame, Object view, float x10, float y10, String[] attribute, float[] value);

    void f(Object view, int position, String name, Object value);

    void g(int dpi, String constraintSetId, Object opaqueView, Object opaqueAttributes);

    float h(Object view, int type, float x10, float y10);

    Object i(Object viewObject, float x10, float y10);
}
