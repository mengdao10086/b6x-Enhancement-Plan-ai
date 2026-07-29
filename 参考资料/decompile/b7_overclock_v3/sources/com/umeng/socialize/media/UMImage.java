package com.umeng.socialize.media;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import com.blankj.utilcode.util.i0;
import com.umeng.social.tool.UMImageMark;
import com.umeng.socialize.c.a.a;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.umeng.socialize.utils.ContextUtil;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.SocializeUtils;
import com.umeng.socialize.utils.UmengText;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class UMImage extends BaseMediaObject {
    public static int BINARY_IMAGE = 5;
    public static int BITMAP_IMAGE = 4;
    public static int FILE_IMAGE = 1;
    public static int MAX_HEIGHT = 1024;
    public static int MAX_WIDTH = 768;
    public static int RES_IMAGE = 3;
    public static int URL_IMAGE = 2;
    public Bitmap.CompressFormat compressFormat;
    public CompressStyle compressStyle;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ConfiguredConvertor f24670f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private UMImage f24671g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private UMImageMark f24672h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f24673i;
    public boolean isLoadImgByCompress;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f24674j;

    public class BinaryConvertor extends ConfiguredConvertor {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private byte[] f24676b;

        public BinaryConvertor(byte[] bArr) {
            this.f24676b = bArr;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public byte[] asBinary() {
            return this.f24676b;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public Bitmap asBitmap() {
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return a.a(asBinary());
            }
            return null;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public File asFile() {
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return a.b(asBinary());
            }
            return null;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public String asUrl() {
            return null;
        }
    }

    public class BitmapConvertor extends ConfiguredConvertor {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Bitmap f24678b;

        public BitmapConvertor(Bitmap bitmap) {
            this.f24678b = bitmap;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public byte[] asBinary() {
            return a.a(this.f24678b, UMImage.this.compressFormat);
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public Bitmap asBitmap() {
            return this.f24678b;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public File asFile() {
            byte[] bArrA = a.a(this.f24678b, UMImage.this.compressFormat);
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return a.b(bArrA);
            }
            return null;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public String asUrl() {
            return null;
        }
    }

    public enum CompressStyle {
        SCALE,
        QUALITY
    }

    public static abstract class ConfiguredConvertor implements IImageConvertor {
    }

    public class FileConvertor extends ConfiguredConvertor {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private File f24681b;

        public FileConvertor(File file) {
            this.f24681b = file;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public byte[] asBinary() {
            return a.a(this.f24681b, UMImage.this.compressFormat);
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public Bitmap asBitmap() {
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return a.a(UMImage.this.asBinImage());
            }
            return null;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public File asFile() {
            return this.f24681b;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public String asUrl() {
            return null;
        }
    }

    public interface IImageConvertor {
        byte[] asBinary();

        Bitmap asBitmap();

        File asFile();

        String asUrl();
    }

    public class ResConvertor extends ConfiguredConvertor {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Context f24683b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f24684c;

        public ResConvertor(Context context, int i10) {
            this.f24683b = context;
            this.f24684c = i10;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public byte[] asBinary() {
            Context context = this.f24683b;
            int i10 = this.f24684c;
            UMImage uMImage = UMImage.this;
            return a.a(context, i10, uMImage.isLoadImgByCompress, uMImage.compressFormat);
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public Bitmap asBitmap() {
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return a.a(asBinary());
            }
            return null;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public File asFile() {
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return a.b(asBinary());
            }
            return null;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public String asUrl() {
            return null;
        }
    }

    public class UrlConvertor extends ConfiguredConvertor {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f24686b;

        public UrlConvertor(String str) {
            this.f24686b = str;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public byte[] asBinary() {
            return a.a(this.f24686b);
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public Bitmap asBitmap() {
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return a.a(asBinary());
            }
            return null;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public File asFile() {
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return a.b(asBinary());
            }
            return null;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public String asUrl() {
            return this.f24686b;
        }
    }

    public UMImage(Context context, File file) {
        this.f24670f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f24673i = 0;
        a(context, file);
    }

    private float a(float f10, float f11, float f12, float f13) {
        if (f10 <= f13 && f11 <= f13) {
            return -1.0f;
        }
        float f14 = f10 / f12;
        float f15 = f11 / f13;
        return f14 > f15 ? f14 : f15;
    }

    private void a(Context context, Object obj) {
        a(context, obj, null);
    }

    private void b(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                if (bitmap.isRecycled()) {
                    return;
                }
                bitmap.recycle();
            } catch (Exception e10) {
                SLog.error(e10);
            }
        }
    }

    public byte[] asBinImage() {
        ConfiguredConvertor configuredConvertor = this.f24670f;
        if (configuredConvertor == null) {
            return null;
        }
        return configuredConvertor.asBinary();
    }

    public Bitmap asBitmap() {
        ConfiguredConvertor configuredConvertor = this.f24670f;
        if (configuredConvertor == null) {
            return null;
        }
        return configuredConvertor.asBitmap();
    }

    public File asFileImage() {
        ConfiguredConvertor configuredConvertor = this.f24670f;
        if (configuredConvertor == null) {
            return null;
        }
        return configuredConvertor.asFile();
    }

    public String asUrlImage() {
        ConfiguredConvertor configuredConvertor = this.f24670f;
        if (configuredConvertor == null) {
            return null;
        }
        return configuredConvertor.asUrl();
    }

    public int getImageStyle() {
        return this.f24673i;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public UMediaObject.MediaType getMediaType() {
        return UMediaObject.MediaType.IMAGE;
    }

    @Override // com.umeng.socialize.media.BaseMediaObject
    public UMImage getThumbImage() {
        return this.f24671g;
    }

    public boolean isHasWaterMark() {
        return this.f24674j;
    }

    @Override // com.umeng.socialize.media.BaseMediaObject
    public void setThumb(UMImage uMImage) {
        this.f24671g = uMImage;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public byte[] toByte() {
        return asBinImage();
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public final Map<String, Object> toUrlExtraParams() {
        HashMap map = new HashMap();
        if (isUrlMedia()) {
            map.put(SocializeProtocolConstants.PROTOCOL_KEY_FURL, this.f24649a);
            map.put(SocializeProtocolConstants.PROTOCOL_KEY_FTYPE, getMediaType());
        }
        return map;
    }

    private void a(Context context, Object obj, UMImageMark uMImageMark) {
        Bitmap bitmapA;
        if (uMImageMark != null) {
            this.f24674j = true;
            this.f24672h = uMImageMark;
            uMImageMark.setContext(context);
        }
        if (ContextUtil.getContext() == null) {
            ContextUtil.setContext(context.getApplicationContext());
        }
        if (obj instanceof File) {
            this.f24673i = FILE_IMAGE;
            this.f24670f = new FileConvertor((File) obj);
            return;
        }
        if (obj instanceof String) {
            this.f24673i = URL_IMAGE;
            this.f24670f = new UrlConvertor((String) obj);
            return;
        }
        if (obj instanceof Integer) {
            this.f24673i = RES_IMAGE;
            bitmapA = isHasWaterMark() ? a(context, ((Integer) obj).intValue()) : null;
            if (bitmapA != null) {
                this.f24670f = new BitmapConvertor(bitmapA);
                return;
            } else {
                this.f24670f = new ResConvertor(context.getApplicationContext(), ((Integer) obj).intValue());
                return;
            }
        }
        if (obj instanceof byte[]) {
            this.f24673i = BINARY_IMAGE;
            bitmapA = isHasWaterMark() ? a((byte[]) obj) : null;
            if (bitmapA != null) {
                this.f24670f = new BitmapConvertor(bitmapA);
                return;
            } else {
                this.f24670f = new BinaryConvertor((byte[]) obj);
                return;
            }
        }
        if (obj instanceof Bitmap) {
            this.f24673i = BITMAP_IMAGE;
            bitmapA = isHasWaterMark() ? a((Bitmap) obj, true) : null;
            if (bitmapA == null) {
                bitmapA = (Bitmap) obj;
            }
            this.f24670f = new BitmapConvertor(bitmapA);
            return;
        }
        if (obj != null) {
            SLog.E(UmengText.IMAGE.UNKNOW_UMIMAGE + obj.getClass().getSimpleName());
            return;
        }
        SLog.E(UmengText.IMAGE.UNKNOW_UMIMAGE + i0.f11859x);
    }

    public UMImage(Context context, String str) {
        super(str);
        this.f24670f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f24673i = 0;
        a((Context) new WeakReference(context).get(), str);
    }

    public UMImage(Context context, int i10) {
        this.f24670f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f24673i = 0;
        a(context, Integer.valueOf(i10));
    }

    public UMImage(Context context, byte[] bArr) {
        this.f24670f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f24673i = 0;
        a(context, bArr);
    }

    public UMImage(Context context, Bitmap bitmap) {
        this.f24670f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f24673i = 0;
        a(context, bitmap);
    }

    private Bitmap a(Bitmap bitmap, boolean z10) {
        if (this.f24672h == null) {
            return bitmap;
        }
        if (bitmap == null) {
            return null;
        }
        if (z10) {
            try {
                bitmap = a(bitmap);
            } catch (Exception e10) {
                SLog.error(e10);
                return null;
            }
        }
        return this.f24672h.compound(bitmap);
    }

    public UMImage(Context context, Bitmap bitmap, UMImageMark uMImageMark) {
        this.f24670f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f24673i = 0;
        a(context, bitmap, uMImageMark);
    }

    private Bitmap a(Context context, int i10) throws Throwable {
        InputStream inputStreamOpenRawResource;
        InputStream inputStream = null;
        if (i10 == 0 || context == null || this.f24672h == null) {
            return null;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            inputStreamOpenRawResource = context.getResources().openRawResource(i10);
            try {
                try {
                    BitmapFactory.decodeStream(inputStreamOpenRawResource, null, options);
                    a(inputStreamOpenRawResource);
                    int iA = (int) a(options.outWidth, options.outHeight, MAX_WIDTH, MAX_HEIGHT);
                    if (iA > 0) {
                        options.inSampleSize = iA;
                    }
                    options.inJustDecodeBounds = false;
                    inputStreamOpenRawResource = context.getResources().openRawResource(i10);
                    Bitmap bitmapA = a(BitmapFactory.decodeStream(inputStreamOpenRawResource, null, options), false);
                    a(inputStreamOpenRawResource);
                    return bitmapA;
                } catch (Exception e10) {
                    e = e10;
                    SLog.error(e);
                    a(inputStreamOpenRawResource);
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                inputStream = inputStreamOpenRawResource;
                a(inputStream);
                throw th;
            }
        } catch (Exception e11) {
            e = e11;
            inputStreamOpenRawResource = null;
        } catch (Throwable th3) {
            th = th3;
            a(inputStream);
            throw th;
        }
    }

    public UMImage(Context context, int i10, UMImageMark uMImageMark) {
        this.f24670f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f24673i = 0;
        a(context, Integer.valueOf(i10), uMImageMark);
    }

    public UMImage(Context context, byte[] bArr, UMImageMark uMImageMark) {
        this.f24670f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f24673i = 0;
        a(context, bArr, uMImageMark);
    }

    private void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e10) {
                SLog.error(e10);
            }
        }
    }

    private Bitmap a(byte[] bArr) {
        if (bArr != null && this.f24672h != null) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                int iA = (int) a(options.outWidth, options.outHeight, MAX_WIDTH, MAX_HEIGHT);
                if (iA > 0) {
                    options.inSampleSize = iA;
                }
                options.inJustDecodeBounds = false;
                return a(BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options), false);
            } catch (Exception e10) {
                SLog.error(e10);
            }
        }
        return null;
    }

    private Bitmap a(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float fA = a(width, height, MAX_WIDTH, MAX_HEIGHT);
        if (fA < 0.0f) {
            return bitmap;
        }
        float f10 = 1.0f / fA;
        Matrix matrix = new Matrix();
        matrix.postScale(f10, f10);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        b(bitmap);
        return bitmapCreateBitmap;
    }
}
