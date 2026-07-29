package i1;

import android.annotation.SuppressLint;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.system.OsConstants;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.RestrictTo;
import com.google.android.material.datepicker.r;
import g.n0;
import g.p0;
import i1.b;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import jt.l;
import no.nordicsemi.android.dfu.DfuBaseService;
import w.w;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static final String A = "Compression";
    public static final String A0 = "OECF";
    public static final String A1 = "GPSLongitudeRef";
    public static final String A2 = "CameraSettingsIFDPointer";
    public static final short A3 = 9;
    public static final short A4 = 2;
    public static final int A5 = 0;
    public static final int A6 = 9;
    public static final byte A7 = -49;
    public static final String B = "PhotometricInterpretation";
    public static final String B0 = "SensitivityType";
    public static final String B1 = "GPSLongitude";
    public static final String B2 = "ImageProcessingIFDPointer";
    public static final short B3 = 10;
    public static final short B4 = 3;
    public static final int B5 = 1;
    public static final int B6 = 10;
    public static final byte B7 = -38;
    public static final String C = "Orientation";
    public static final String C0 = "StandardOutputSensitivity";
    public static final String C1 = "GPSAltitudeRef";
    public static final int C2 = 512;
    public static final short C3 = 11;
    public static final short C4 = 4;
    public static final int C5 = 5000;
    public static final int C6 = 11;
    public static final byte C7 = -31;
    public static final String D = "SamplesPerPixel";
    public static final String D0 = "RecommendedExposureIndex";
    public static final String D1 = "GPSAltitude";
    public static final int D2 = 0;
    public static final short D3 = 12;
    public static final short D4 = 0;
    public static final int D6 = 12;
    public static final byte D7 = -2;
    public static final String E = "PlanarConfiguration";
    public static final String E0 = "ISOSpeed";
    public static final String E1 = "GPSTimeStamp";
    public static final int E2 = 1;
    public static final short E3 = 13;
    public static final short E4 = 1;
    public static final String E5 = "FUJIFILMCCD-RAW";
    public static final int E6 = 13;
    public static final byte E7 = -39;
    public static final String F = "YCbCrSubSampling";
    public static final String F0 = "ISOSpeedLatitudeyyy";
    public static final String F1 = "GPSSatellites";
    public static final int F2 = 2;
    public static final short F3 = 14;
    public static final short F4 = 2;
    public static final int F5 = 84;
    public static final int F6 = 8192;
    public static final int F7 = 0;
    public static final String G = "YCbCrPositioning";
    public static final String G0 = "ISOSpeedLatitudezzz";
    public static final String G1 = "GPSStatus";
    public static final int G2 = 3;
    public static final short G3 = 15;
    public static final short G4 = 0;
    public static final int G7 = 1;
    public static final String H = "XResolution";
    public static final String H0 = "ShutterSpeedValue";
    public static final String H1 = "GPSMeasureMode";
    public static final int H2 = 4;
    public static final short H3 = 16;
    public static final short H4 = 0;
    public static final int H7 = 2;
    public static final String I = "YResolution";
    public static final String I0 = "ApertureValue";
    public static final String I1 = "GPSDOP";
    public static final int I2 = 5;
    public static final short I3 = 17;
    public static final short I4 = 0;
    public static final int I7 = 3;
    public static final String J = "ResolutionUnit";
    public static final String J0 = "BrightnessValue";
    public static final String J1 = "GPSSpeedRef";
    public static final int J2 = 6;
    public static final short J3 = 18;
    public static final short J4 = 0;
    public static final short J5 = 20306;
    public static final f[] J6;
    public static final int J7 = 4;
    public static final String K = "StripOffsets";
    public static final String K0 = "ExposureBiasValue";
    public static final String K1 = "GPSSpeed";
    public static final int K2 = 7;
    public static final short K3 = 19;
    public static final short K4 = 1;
    public static final short K5 = 21330;
    public static final f[] K6;
    public static final int K7 = 5;
    public static final String L = "RowsPerStrip";
    public static final String L0 = "MaxApertureValue";
    public static final String L1 = "GPSTrackRef";
    public static final int L2 = 8;
    public static final short L3 = 20;
    public static final short L4 = 2;
    public static final f[] L6;
    public static final int L7 = 6;
    public static final String M = "StripByteCounts";
    public static final String M0 = "SubjectDistance";
    public static final String M1 = "GPSTrack";
    public static final short M3 = 21;
    public static final short M4 = 0;
    public static final f[] M6;
    public static final int M7 = 7;
    public static final String N = "JPEGInterchangeFormat";
    public static final String N0 = "MeteringMode";
    public static final String N1 = "GPSImgDirectionRef";
    public static final short N3 = 22;
    public static final short N4 = 1;
    public static final int N5 = 8;
    public static final f[] N6;
    public static final int N7 = 8;
    public static final String O = "JPEGInterchangeFormatLength";
    public static final String O0 = "LightSource";
    public static final String O1 = "GPSImgDirection";
    public static final short O2 = 1;
    public static final short O3 = 23;
    public static final short O4 = 2;
    public static final int O5 = 12;
    public static final f O6;
    public static final int O7 = 9;
    public static final String P = "TransferFunction";
    public static final String P0 = "Flash";
    public static final String P1 = "GPSMapDatum";
    public static final short P2 = 2;
    public static final short P3 = 24;
    public static final short P4 = 3;
    public static final short P5 = 85;
    public static final f[] P6;
    public static final int P7 = 10;
    public static final String Q = "WhitePoint";
    public static final String Q0 = "SubjectArea";
    public static final String Q1 = "GPSDestLatitudeRef";
    public static final short Q2 = 1;
    public static final short Q3 = 255;
    public static final String Q4 = "N";
    public static final String Q5 = "PENTAX";
    public static final f[] Q6;
    public static final int Q7 = 11;
    public static final String R = "PrimaryChromaticities";
    public static final String R0 = "FocalLength";
    public static final String R1 = "GPSDestLatitude";
    public static final short R2 = 2;
    public static final short R3 = 1;
    public static final String R4 = "S";
    public static final int R5 = 6;
    public static final f[] R6;
    public static final int R7 = 12;
    public static final String S = "YCbCrCoefficients";
    public static final String S0 = "FlashEnergy";
    public static final String S1 = "GPSDestLongitudeRef";
    public static final short S2 = 2;
    public static final short S3 = 4;
    public static final String S4 = "E";
    public static final f[] S6;
    public static final int S7 = 13;
    public static final String T = "ReferenceBlackWhite";
    public static final String T0 = "SpatialFrequencyResponse";
    public static final String T1 = "GPSDestLongitude";
    public static final short T2 = 3;
    public static final short T3 = 6;
    public static final String T4 = "W";
    public static final int T6 = 0;
    public static final int T7 = 14;
    public static final String U = "DateTime";
    public static final String U0 = "FocalPlaneXResolution";
    public static final String U1 = "GPSDestBearingRef";
    public static final int U2 = 1;
    public static final short U3 = 8;
    public static final short U4 = 0;
    public static final int U6 = 1;
    public static final Pattern U7;
    public static final String V = "ImageDescription";
    public static final String V0 = "FocalPlaneYResolution";
    public static final String V1 = "GPSDestBearing";
    public static final int V2 = 65535;
    public static final short V3 = 16;
    public static final short V4 = 1;
    public static final int V6 = 2;
    public static final Pattern V7;
    public static final String W = "Make";
    public static final String W0 = "FocalPlaneResolutionUnit";
    public static final String W1 = "GPSDestDistanceRef";
    public static final short W2 = 0;
    public static final short W3 = 24;
    public static final String W4 = "A";
    public static final int W5 = 4;
    public static final int W6 = 3;
    public static final Pattern W7;
    public static final String X = "Model";
    public static final String X0 = "SubjectLocation";
    public static final String X1 = "GPSDestDistance";
    public static final short X2 = 1;
    public static final short X3 = 32;
    public static final String X4 = "V";
    public static final int X5 = 4;
    public static final int X6 = 4;
    public static final Pattern X7;
    public static final String Y = "Software";
    public static final String Y0 = "ExposureIndex";
    public static final String Y1 = "GPSProcessingMethod";
    public static final short Y2 = 2;
    public static final short Y3 = 64;
    public static final String Y4 = "2";
    public static final int Y6 = 5;
    public static final int Y7 = 19;
    public static final String Z = "Artist";
    public static final String Z0 = "SensingMethod";
    public static final String Z1 = "GPSAreaInformation";
    public static final short Z2 = 3;
    public static final short Z3 = 1;
    public static final String Z4 = "3";
    public static final int Z6 = 6;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final String f31548a0 = "Copyright";

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    public static final String f31549a1 = "FileSource";

    /* JADX INFO: renamed from: a2, reason: collision with root package name */
    public static final String f31550a2 = "GPSDateStamp";

    /* JADX INFO: renamed from: a3, reason: collision with root package name */
    public static final short f31551a3 = 4;

    /* JADX INFO: renamed from: a4, reason: collision with root package name */
    public static final short f31552a4 = 2;

    /* JADX INFO: renamed from: a5, reason: collision with root package name */
    public static final String f31553a5 = "K";

    /* JADX INFO: renamed from: a6, reason: collision with root package name */
    public static final int f31554a6 = 4;

    /* JADX INFO: renamed from: a7, reason: collision with root package name */
    public static final int f31555a7 = 7;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final String f31556b0 = "ExifVersion";

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public static final String f31557b1 = "SceneType";

    /* JADX INFO: renamed from: b2, reason: collision with root package name */
    public static final String f31558b2 = "GPSDifferential";

    /* JADX INFO: renamed from: b3, reason: collision with root package name */
    public static final short f31559b3 = 5;

    /* JADX INFO: renamed from: b4, reason: collision with root package name */
    public static final short f31560b4 = 3;

    /* JADX INFO: renamed from: b5, reason: collision with root package name */
    public static final String f31561b5 = "M";

    /* JADX INFO: renamed from: b7, reason: collision with root package name */
    public static final int f31563b7 = 8;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final String f31564c0 = "FlashpixVersion";

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    public static final String f31565c1 = "CFAPattern";

    /* JADX INFO: renamed from: c2, reason: collision with root package name */
    public static final String f31566c2 = "GPSHPositioningError";

    /* JADX INFO: renamed from: c3, reason: collision with root package name */
    public static final short f31567c3 = 6;

    /* JADX INFO: renamed from: c4, reason: collision with root package name */
    public static final short f31568c4 = 4;

    /* JADX INFO: renamed from: c5, reason: collision with root package name */
    public static final String f31569c5 = "N";

    /* JADX INFO: renamed from: c7, reason: collision with root package name */
    public static final int f31571c7 = 9;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final String f31572d0 = "ColorSpace";

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    public static final String f31573d1 = "CustomRendered";

    /* JADX INFO: renamed from: d2, reason: collision with root package name */
    public static final String f31574d2 = "InteroperabilityIndex";

    /* JADX INFO: renamed from: d3, reason: collision with root package name */
    public static final short f31575d3 = 7;

    /* JADX INFO: renamed from: d4, reason: collision with root package name */
    public static final short f31576d4 = 5;

    /* JADX INFO: renamed from: d5, reason: collision with root package name */
    public static final String f31577d5 = "T";

    /* JADX INFO: renamed from: d6, reason: collision with root package name */
    public static final byte f31578d6 = 47;

    /* JADX INFO: renamed from: d7, reason: collision with root package name */
    public static final f[][] f31579d7;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final String f31580e0 = "Gamma";

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    public static final String f31581e1 = "ExposureMode";

    /* JADX INFO: renamed from: e2, reason: collision with root package name */
    public static final String f31582e2 = "ThumbnailImageLength";

    /* JADX INFO: renamed from: e3, reason: collision with root package name */
    public static final short f31583e3 = 8;

    /* JADX INFO: renamed from: e4, reason: collision with root package name */
    public static final short f31584e4 = 7;

    /* JADX INFO: renamed from: e5, reason: collision with root package name */
    public static final String f31585e5 = "M";

    /* JADX INFO: renamed from: e7, reason: collision with root package name */
    public static final f[] f31587e7;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final String f31588f0 = "PixelXDimension";

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    public static final String f31589f1 = "WhiteBalance";

    /* JADX INFO: renamed from: f2, reason: collision with root package name */
    public static final String f31590f2 = "ThumbnailImageWidth";

    /* JADX INFO: renamed from: f3, reason: collision with root package name */
    public static final short f31591f3 = 0;

    /* JADX INFO: renamed from: f4, reason: collision with root package name */
    public static final short f31592f4 = 8;

    /* JADX INFO: renamed from: f5, reason: collision with root package name */
    public static final String f31593f5 = "K";

    /* JADX INFO: renamed from: f7, reason: collision with root package name */
    public static final HashMap<Integer, f>[] f31595f7;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final String f31596g0 = "PixelYDimension";

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public static final String f31597g1 = "DigitalZoomRatio";

    /* JADX INFO: renamed from: g2, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String f31598g2 = "ThumbnailOrientation";

    /* JADX INFO: renamed from: g3, reason: collision with root package name */
    public static final short f31599g3 = 1;

    /* JADX INFO: renamed from: g4, reason: collision with root package name */
    public static final short f31600g4 = 0;

    /* JADX INFO: renamed from: g5, reason: collision with root package name */
    public static final String f31601g5 = "M";

    /* JADX INFO: renamed from: g7, reason: collision with root package name */
    public static final HashMap<String, f>[] f31603g7;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final String f31604h0 = "ComponentsConfiguration";

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public static final String f31605h1 = "FocalLengthIn35mmFilm";

    /* JADX INFO: renamed from: h2, reason: collision with root package name */
    public static final String f31606h2 = "DNGVersion";

    /* JADX INFO: renamed from: h3, reason: collision with root package name */
    public static final short f31607h3 = 2;

    /* JADX INFO: renamed from: h4, reason: collision with root package name */
    public static final short f31608h4 = 1;

    /* JADX INFO: renamed from: h5, reason: collision with root package name */
    public static final String f31609h5 = "N";

    /* JADX INFO: renamed from: h7, reason: collision with root package name */
    public static final HashSet<String> f31611h7;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final String f31612i0 = "CompressedBitsPerPixel";

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    public static final String f31613i1 = "SceneCaptureType";

    /* JADX INFO: renamed from: i2, reason: collision with root package name */
    public static final String f31614i2 = "DefaultCropSize";

    /* JADX INFO: renamed from: i3, reason: collision with root package name */
    public static final short f31615i3 = 3;

    /* JADX INFO: renamed from: i4, reason: collision with root package name */
    public static final short f31616i4 = 2;

    /* JADX INFO: renamed from: i5, reason: collision with root package name */
    public static final short f31617i5 = 0;

    /* JADX INFO: renamed from: i7, reason: collision with root package name */
    public static final HashMap<Integer, Integer> f31619i7;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final String f31620j0 = "MakerNote";

    /* JADX INFO: renamed from: j1, reason: collision with root package name */
    public static final String f31621j1 = "GainControl";

    /* JADX INFO: renamed from: j2, reason: collision with root package name */
    public static final String f31622j2 = "ThumbnailImage";

    /* JADX INFO: renamed from: j3, reason: collision with root package name */
    public static final short f31623j3 = 4;

    /* JADX INFO: renamed from: j4, reason: collision with root package name */
    public static final short f31624j4 = 3;

    /* JADX INFO: renamed from: j5, reason: collision with root package name */
    public static final short f31625j5 = 1;

    /* JADX INFO: renamed from: j6, reason: collision with root package name */
    public static final int f31626j6 = 10;

    /* JADX INFO: renamed from: j7, reason: collision with root package name */
    public static final Charset f31627j7;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final String f31628k0 = "UserComment";

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static final String f31629k1 = "Contrast";

    /* JADX INFO: renamed from: k2, reason: collision with root package name */
    public static final String f31630k2 = "PreviewImageStart";

    /* JADX INFO: renamed from: k3, reason: collision with root package name */
    public static final short f31631k3 = 5;

    /* JADX INFO: renamed from: k4, reason: collision with root package name */
    public static final short f31632k4 = 1;

    /* JADX INFO: renamed from: k5, reason: collision with root package name */
    public static final int f31633k5 = 1;

    /* JADX INFO: renamed from: k6, reason: collision with root package name */
    public static final int f31634k6 = 4;

    /* JADX INFO: renamed from: k7, reason: collision with root package name */
    public static final byte[] f31635k7;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final String f31636l0 = "RelatedSoundFile";

    /* JADX INFO: renamed from: l1, reason: collision with root package name */
    public static final String f31637l1 = "Saturation";

    /* JADX INFO: renamed from: l2, reason: collision with root package name */
    public static final String f31638l2 = "PreviewImageLength";

    /* JADX INFO: renamed from: l3, reason: collision with root package name */
    public static final short f31639l3 = 6;

    /* JADX INFO: renamed from: l4, reason: collision with root package name */
    public static final short f31640l4 = 0;

    /* JADX INFO: renamed from: l5, reason: collision with root package name */
    public static final int f31641l5 = 2;

    /* JADX INFO: renamed from: l6, reason: collision with root package name */
    public static final int f31642l6 = 4;

    /* JADX INFO: renamed from: l7, reason: collision with root package name */
    public static final byte[] f31643l7;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final String f31644m0 = "DateTimeOriginal";

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    public static final String f31645m1 = "Sharpness";

    /* JADX INFO: renamed from: m2, reason: collision with root package name */
    public static final String f31646m2 = "AspectFrame";

    /* JADX INFO: renamed from: m3, reason: collision with root package name */
    public static final short f31647m3 = 7;

    /* JADX INFO: renamed from: m4, reason: collision with root package name */
    public static final short f31648m4 = 1;

    /* JADX INFO: renamed from: m5, reason: collision with root package name */
    public static final int f31649m5 = 6;

    /* JADX INFO: renamed from: m6, reason: collision with root package name */
    public static SimpleDateFormat f31650m6 = null;

    /* JADX INFO: renamed from: m7, reason: collision with root package name */
    public static final byte f31651m7 = -1;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final String f31652n0 = "DateTimeDigitized";

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    public static final String f31653n1 = "DeviceSettingDescription";

    /* JADX INFO: renamed from: n2, reason: collision with root package name */
    public static final String f31654n2 = "SensorBottomBorder";

    /* JADX INFO: renamed from: n3, reason: collision with root package name */
    public static final short f31655n3 = 0;

    /* JADX INFO: renamed from: n4, reason: collision with root package name */
    public static final short f31656n4 = 0;

    /* JADX INFO: renamed from: n5, reason: collision with root package name */
    public static final int f31657n5 = 7;

    /* JADX INFO: renamed from: n6, reason: collision with root package name */
    public static SimpleDateFormat f31658n6 = null;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static final String f31660o0 = "OffsetTime";

    /* JADX INFO: renamed from: o1, reason: collision with root package name */
    public static final String f31661o1 = "SubjectDistanceRange";

    /* JADX INFO: renamed from: o2, reason: collision with root package name */
    public static final String f31662o2 = "SensorLeftBorder";

    /* JADX INFO: renamed from: o3, reason: collision with root package name */
    public static final short f31663o3 = 1;

    /* JADX INFO: renamed from: o4, reason: collision with root package name */
    public static final short f31664o4 = 1;

    /* JADX INFO: renamed from: o5, reason: collision with root package name */
    public static final int f31665o5 = 8;

    /* JADX INFO: renamed from: o6, reason: collision with root package name */
    public static final short f31666o6 = 18761;

    /* JADX INFO: renamed from: o7, reason: collision with root package name */
    public static final byte f31667o7 = -64;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final String f31668p0 = "OffsetTimeOriginal";

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public static final String f31669p1 = "ImageUniqueID";

    /* JADX INFO: renamed from: p2, reason: collision with root package name */
    public static final String f31670p2 = "SensorRightBorder";

    /* JADX INFO: renamed from: p3, reason: collision with root package name */
    public static final short f31671p3 = 2;

    /* JADX INFO: renamed from: p4, reason: collision with root package name */
    public static final short f31672p4 = 2;

    /* JADX INFO: renamed from: p5, reason: collision with root package name */
    public static final int f31673p5 = 32773;

    /* JADX INFO: renamed from: p6, reason: collision with root package name */
    public static final short f31674p6 = 19789;

    /* JADX INFO: renamed from: p7, reason: collision with root package name */
    public static final byte f31675p7 = -63;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static final String f31676q0 = "OffsetTimeDigitized";

    /* JADX INFO: renamed from: q1, reason: collision with root package name */
    @Deprecated
    public static final String f31677q1 = "CameraOwnerName";

    /* JADX INFO: renamed from: q2, reason: collision with root package name */
    public static final String f31678q2 = "SensorTopBorder";

    /* JADX INFO: renamed from: q3, reason: collision with root package name */
    public static final short f31679q3 = 3;

    /* JADX INFO: renamed from: q4, reason: collision with root package name */
    @Deprecated
    public static final int f31680q4 = 0;

    /* JADX INFO: renamed from: q5, reason: collision with root package name */
    public static final int f31681q5 = 34892;

    /* JADX INFO: renamed from: q6, reason: collision with root package name */
    public static final byte f31682q6 = 42;

    /* JADX INFO: renamed from: q7, reason: collision with root package name */
    public static final byte f31683q7 = -62;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public static final String f31684r0 = "SubSecTime";

    /* JADX INFO: renamed from: r1, reason: collision with root package name */
    public static final String f31685r1 = "CameraOwnerName";

    /* JADX INFO: renamed from: r2, reason: collision with root package name */
    public static final String f31686r2 = "ISO";

    /* JADX INFO: renamed from: r3, reason: collision with root package name */
    public static final short f31687r3 = 4;

    /* JADX INFO: renamed from: r4, reason: collision with root package name */
    @Deprecated
    public static final int f31688r4 = 1;

    /* JADX INFO: renamed from: r6, reason: collision with root package name */
    public static final int f31690r6 = 8;

    /* JADX INFO: renamed from: r7, reason: collision with root package name */
    public static final byte f31691r7 = -61;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static final String f31692s0 = "SubSecTimeOriginal";

    /* JADX INFO: renamed from: s1, reason: collision with root package name */
    public static final String f31693s1 = "BodySerialNumber";

    /* JADX INFO: renamed from: s2, reason: collision with root package name */
    public static final String f31694s2 = "JpgFromRaw";

    /* JADX INFO: renamed from: s3, reason: collision with root package name */
    public static final short f31695s3 = 5;

    /* JADX INFO: renamed from: s4, reason: collision with root package name */
    public static final short f31696s4 = 0;

    /* JADX INFO: renamed from: s6, reason: collision with root package name */
    public static final int f31698s6 = 1;

    /* JADX INFO: renamed from: s7, reason: collision with root package name */
    public static final byte f31699s7 = -59;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final String f31700t0 = "SubSecTimeDigitized";

    /* JADX INFO: renamed from: t1, reason: collision with root package name */
    public static final String f31701t1 = "LensSpecification";

    /* JADX INFO: renamed from: t2, reason: collision with root package name */
    public static final String f31702t2 = "Xmp";

    /* JADX INFO: renamed from: t3, reason: collision with root package name */
    public static final short f31703t3 = 6;

    /* JADX INFO: renamed from: t4, reason: collision with root package name */
    public static final short f31704t4 = 1;

    /* JADX INFO: renamed from: t6, reason: collision with root package name */
    public static final int f31706t6 = 2;

    /* JADX INFO: renamed from: t7, reason: collision with root package name */
    public static final byte f31707t7 = -58;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static final String f31708u0 = "ExposureTime";

    /* JADX INFO: renamed from: u1, reason: collision with root package name */
    public static final String f31709u1 = "LensMake";

    /* JADX INFO: renamed from: u2, reason: collision with root package name */
    public static final String f31710u2 = "NewSubfileType";

    /* JADX INFO: renamed from: u3, reason: collision with root package name */
    public static final short f31711u3 = 255;

    /* JADX INFO: renamed from: u4, reason: collision with root package name */
    public static final short f31712u4 = 0;

    /* JADX INFO: renamed from: u5, reason: collision with root package name */
    public static final int f31713u5 = 0;
    public static final int u6 = 3;

    /* JADX INFO: renamed from: u7, reason: collision with root package name */
    public static final byte f31714u7 = -57;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public static final String f31716v0 = "FNumber";

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public static final String f31717v1 = "LensModel";

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public static final String f31718v2 = "SubfileType";

    /* JADX INFO: renamed from: v3, reason: collision with root package name */
    public static final short f31719v3 = 0;

    /* JADX INFO: renamed from: v4, reason: collision with root package name */
    public static final short f31720v4 = 1;

    /* JADX INFO: renamed from: v5, reason: collision with root package name */
    public static final int f31721v5 = 1;

    /* JADX INFO: renamed from: v6, reason: collision with root package name */
    public static final int f31722v6 = 4;

    /* JADX INFO: renamed from: v7, reason: collision with root package name */
    public static final byte f31723v7 = -55;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public static final String f31725w0 = "ExposureProgram";

    /* JADX INFO: renamed from: w1, reason: collision with root package name */
    public static final String f31726w1 = "LensSerialNumber";

    /* JADX INFO: renamed from: w2, reason: collision with root package name */
    public static final String f31727w2 = "ExifIFDPointer";

    /* JADX INFO: renamed from: w3, reason: collision with root package name */
    public static final short f31728w3 = 1;

    /* JADX INFO: renamed from: w4, reason: collision with root package name */
    public static final short f31729w4 = 2;

    /* JADX INFO: renamed from: w5, reason: collision with root package name */
    public static final int f31730w5 = 2;

    /* JADX INFO: renamed from: w6, reason: collision with root package name */
    public static final int f31731w6 = 5;

    /* JADX INFO: renamed from: w7, reason: collision with root package name */
    public static final byte f31732w7 = -54;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f31733x = "ImageWidth";

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public static final String f31734x0 = "SpectralSensitivity";

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public static final String f31735x1 = "GPSVersionID";

    /* JADX INFO: renamed from: x2, reason: collision with root package name */
    public static final String f31736x2 = "GPSInfoIFDPointer";

    /* JADX INFO: renamed from: x3, reason: collision with root package name */
    public static final short f31737x3 = 2;

    /* JADX INFO: renamed from: x4, reason: collision with root package name */
    public static final short f31738x4 = 3;

    /* JADX INFO: renamed from: x5, reason: collision with root package name */
    public static final int f31739x5 = 6;

    /* JADX INFO: renamed from: x6, reason: collision with root package name */
    public static final int f31740x6 = 6;

    /* JADX INFO: renamed from: x7, reason: collision with root package name */
    public static final byte f31741x7 = -53;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f31742y = "ImageLength";

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    @Deprecated
    public static final String f31743y0 = "ISOSpeedRatings";

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public static final String f31744y1 = "GPSLatitudeRef";

    /* JADX INFO: renamed from: y2, reason: collision with root package name */
    public static final String f31745y2 = "InteroperabilityIFDPointer";

    /* JADX INFO: renamed from: y3, reason: collision with root package name */
    public static final short f31746y3 = 3;

    /* JADX INFO: renamed from: y4, reason: collision with root package name */
    public static final short f31747y4 = 0;

    /* JADX INFO: renamed from: y5, reason: collision with root package name */
    public static final int f31748y5 = 0;

    /* JADX INFO: renamed from: y6, reason: collision with root package name */
    public static final int f31749y6 = 7;

    /* JADX INFO: renamed from: y7, reason: collision with root package name */
    public static final byte f31750y7 = -51;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f31751z = "BitsPerSample";

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public static final String f31752z0 = "PhotographicSensitivity";

    /* JADX INFO: renamed from: z1, reason: collision with root package name */
    public static final String f31753z1 = "GPSLatitude";

    /* JADX INFO: renamed from: z2, reason: collision with root package name */
    public static final String f31754z2 = "SubIFDPointer";

    /* JADX INFO: renamed from: z3, reason: collision with root package name */
    public static final short f31755z3 = 4;

    /* JADX INFO: renamed from: z4, reason: collision with root package name */
    public static final short f31756z4 = 1;

    /* JADX INFO: renamed from: z5, reason: collision with root package name */
    public static final int f31757z5 = 1;

    /* JADX INFO: renamed from: z6, reason: collision with root package name */
    public static final int f31758z6 = 8;

    /* JADX INFO: renamed from: z7, reason: collision with root package name */
    public static final byte f31759z7 = -50;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f31760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FileDescriptor f31761b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AssetManager.AssetInputStream f31762c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f31763d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f31764e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap<String, d>[] f31765f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Set<Integer> f31766g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ByteOrder f31767h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f31768i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f31769j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f31770k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f31771l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f31772m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public byte[] f31773n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f31774o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f31775p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f31776q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f31777r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f31778s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f31779t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f31780u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f31715v = "ExifInterface";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final boolean f31724w = Log.isLoggable(f31715v, 3);
    public static final List<Integer> M2 = Arrays.asList(1, 6, 3, 8);
    public static final List<Integer> N2 = Arrays.asList(2, 7, 4, 5);

    /* JADX INFO: renamed from: r5, reason: collision with root package name */
    public static final int[] f31689r5 = {8, 8, 8};

    /* JADX INFO: renamed from: s5, reason: collision with root package name */
    public static final int[] f31697s5 = {4};

    /* JADX INFO: renamed from: t5, reason: collision with root package name */
    public static final int[] f31705t5 = {8};

    /* JADX INFO: renamed from: n7, reason: collision with root package name */
    public static final byte f31659n7 = -40;
    public static final byte[] D5 = {-1, f31659n7, -1};
    public static final byte[] G5 = {102, 116, 121, pq.b.f46994k};
    public static final byte[] H5 = {109, 105, 102, 49};
    public static final byte[] I5 = {104, 101, 105, 99};
    public static final byte[] L5 = {79, 76, 89, 77, l.f36951s, 0};
    public static final byte[] M5 = {79, 76, 89, 77, l.f36951s, 85, 83, 0, 73, 73};
    public static final byte[] S5 = {-119, l.f36951s, 78, 71, 13, 10, 26, 10};
    public static final byte[] T5 = {101, o5.b.f42741j, 73, 102};
    public static final byte[] U5 = {73, 72, 68, 82};
    public static final byte[] V5 = {73, 69, 78, 68};
    public static final byte[] Y5 = {82, 73, 70, 70};
    public static final byte[] Z5 = {87, 69, 66, l.f36951s};

    /* JADX INFO: renamed from: b6, reason: collision with root package name */
    public static final byte[] f31562b6 = {69, o5.b.f42741j, 73, 70};

    /* JADX INFO: renamed from: c6, reason: collision with root package name */
    public static final byte[] f31570c6 = {-99, 1, 42};

    /* JADX INFO: renamed from: e6, reason: collision with root package name */
    public static final byte[] f31586e6 = "VP8X".getBytes(Charset.defaultCharset());

    /* JADX INFO: renamed from: f6, reason: collision with root package name */
    public static final byte[] f31594f6 = "VP8L".getBytes(Charset.defaultCharset());

    /* JADX INFO: renamed from: g6, reason: collision with root package name */
    public static final byte[] f31602g6 = "VP8 ".getBytes(Charset.defaultCharset());

    /* JADX INFO: renamed from: h6, reason: collision with root package name */
    public static final byte[] f31610h6 = "ANIM".getBytes(Charset.defaultCharset());

    /* JADX INFO: renamed from: i6, reason: collision with root package name */
    public static final byte[] f31618i6 = "ANMF".getBytes(Charset.defaultCharset());
    public static final String[] G6 = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
    public static final int[] H6 = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    public static final byte[] I6 = {65, 83, 67, 73, 73, 0, 0, 0};

    /* JADX INFO: renamed from: i1.a$a, reason: collision with other inner class name */
    public class C0375a extends MediaDataSource {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f31781a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i f31782b;

        public C0375a(i iVar) {
            this.f31782b = iVar;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // android.media.MediaDataSource
        public long getSize() throws IOException {
            return -1L;
        }

        @Override // android.media.MediaDataSource
        public int readAt(long j10, byte[] bArr, int i10, int i11) throws IOException {
            if (i11 == 0) {
                return 0;
            }
            if (j10 < 0) {
                return -1;
            }
            try {
                long j11 = this.f31781a;
                if (j11 != j10) {
                    if (j11 >= 0 && j10 >= j11 + ((long) this.f31782b.available())) {
                        return -1;
                    }
                    this.f31782b.h(j10);
                    this.f31781a = j10;
                }
                if (i11 > this.f31782b.available()) {
                    i11 = this.f31782b.available();
                }
                int i12 = this.f31782b.read(bArr, i10, i11);
                if (i12 >= 0) {
                    this.f31781a += (long) i12;
                    return i12;
                }
            } catch (IOException unused) {
            }
            this.f31781a = -1L;
            return -1;
        }
    }

    public static class b extends InputStream implements DataInput {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final ByteOrder f31784e = ByteOrder.LITTLE_ENDIAN;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final ByteOrder f31785f = ByteOrder.BIG_ENDIAN;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DataInputStream f31786a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ByteOrder f31787b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f31788c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public byte[] f31789d;

        public b(byte[] bArr) throws IOException {
            this(new ByteArrayInputStream(bArr), ByteOrder.BIG_ENDIAN);
        }

        public int a() {
            return this.f31788c;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return this.f31786a.available();
        }

        public long c() throws IOException {
            return ((long) readInt()) & 4294967295L;
        }

        public void d(ByteOrder byteOrder) {
            this.f31787b = byteOrder;
        }

        public void f(int i10) throws IOException {
            int i11 = 0;
            while (i11 < i10) {
                int i12 = i10 - i11;
                int iSkip = (int) this.f31786a.skip(i12);
                if (iSkip <= 0) {
                    if (this.f31789d == null) {
                        this.f31789d = new byte[8192];
                    }
                    iSkip = this.f31786a.read(this.f31789d, 0, Math.min(8192, i12));
                    if (iSkip == -1) {
                        throw new EOFException("Reached EOF while skipping " + i10 + " bytes.");
                    }
                }
                i11 += iSkip;
            }
            this.f31788c += i11;
        }

        @Override // java.io.InputStream
        public void mark(int i10) {
            throw new UnsupportedOperationException("Mark is currently unsupported");
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            this.f31788c++;
            return this.f31786a.read();
        }

        @Override // java.io.DataInput
        public boolean readBoolean() throws IOException {
            this.f31788c++;
            return this.f31786a.readBoolean();
        }

        @Override // java.io.DataInput
        public byte readByte() throws IOException {
            this.f31788c++;
            int i10 = this.f31786a.read();
            if (i10 >= 0) {
                return (byte) i10;
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public char readChar() throws IOException {
            this.f31788c += 2;
            return this.f31786a.readChar();
        }

        @Override // java.io.DataInput
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readLong());
        }

        @Override // java.io.DataInput
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readInt());
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr, int i10, int i11) throws IOException {
            this.f31788c += i11;
            this.f31786a.readFully(bArr, i10, i11);
        }

        @Override // java.io.DataInput
        public int readInt() throws IOException {
            this.f31788c += 4;
            int i10 = this.f31786a.read();
            int i11 = this.f31786a.read();
            int i12 = this.f31786a.read();
            int i13 = this.f31786a.read();
            if ((i10 | i11 | i12 | i13) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f31787b;
            if (byteOrder == f31784e) {
                return (i13 << 24) + (i12 << 16) + (i11 << 8) + i10;
            }
            if (byteOrder == f31785f) {
                return (i10 << 24) + (i11 << 16) + (i12 << 8) + i13;
            }
            throw new IOException("Invalid byte order: " + this.f31787b);
        }

        @Override // java.io.DataInput
        public String readLine() throws IOException {
            return null;
        }

        @Override // java.io.DataInput
        public long readLong() throws IOException {
            this.f31788c += 8;
            int i10 = this.f31786a.read();
            int i11 = this.f31786a.read();
            int i12 = this.f31786a.read();
            int i13 = this.f31786a.read();
            int i14 = this.f31786a.read();
            int i15 = this.f31786a.read();
            int i16 = this.f31786a.read();
            int i17 = this.f31786a.read();
            if ((i10 | i11 | i12 | i13 | i14 | i15 | i16 | i17) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f31787b;
            if (byteOrder == f31784e) {
                return (((long) i17) << 56) + (((long) i16) << 48) + (((long) i15) << 40) + (((long) i14) << 32) + (((long) i13) << 24) + (((long) i12) << 16) + (((long) i11) << 8) + ((long) i10);
            }
            if (byteOrder == f31785f) {
                return (((long) i10) << 56) + (((long) i11) << 48) + (((long) i12) << 40) + (((long) i13) << 32) + (((long) i14) << 24) + (((long) i15) << 16) + (((long) i16) << 8) + ((long) i17);
            }
            throw new IOException("Invalid byte order: " + this.f31787b);
        }

        @Override // java.io.DataInput
        public short readShort() throws IOException {
            this.f31788c += 2;
            int i10 = this.f31786a.read();
            int i11 = this.f31786a.read();
            if ((i10 | i11) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f31787b;
            if (byteOrder == f31784e) {
                return (short) ((i11 << 8) + i10);
            }
            if (byteOrder == f31785f) {
                return (short) ((i10 << 8) + i11);
            }
            throw new IOException("Invalid byte order: " + this.f31787b);
        }

        @Override // java.io.DataInput
        public String readUTF() throws IOException {
            this.f31788c += 2;
            return this.f31786a.readUTF();
        }

        @Override // java.io.DataInput
        public int readUnsignedByte() throws IOException {
            this.f31788c++;
            return this.f31786a.readUnsignedByte();
        }

        @Override // java.io.DataInput
        public int readUnsignedShort() throws IOException {
            this.f31788c += 2;
            int i10 = this.f31786a.read();
            int i11 = this.f31786a.read();
            if ((i10 | i11) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f31787b;
            if (byteOrder == f31784e) {
                return (i11 << 8) + i10;
            }
            if (byteOrder == f31785f) {
                return (i10 << 8) + i11;
            }
            throw new IOException("Invalid byte order: " + this.f31787b);
        }

        @Override // java.io.InputStream
        public void reset() {
            throw new UnsupportedOperationException("Reset is currently unsupported");
        }

        @Override // java.io.DataInput
        public int skipBytes(int i10) throws IOException {
            throw new UnsupportedOperationException("skipBytes is currently unsupported");
        }

        public b(InputStream inputStream) throws IOException {
            this(inputStream, ByteOrder.BIG_ENDIAN);
        }

        public b(InputStream inputStream, ByteOrder byteOrder) throws IOException {
            this.f31787b = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.f31786a = dataInputStream;
            dataInputStream.mark(0);
            this.f31788c = 0;
            this.f31787b = byteOrder;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) throws IOException {
            int i12 = this.f31786a.read(bArr, i10, i11);
            this.f31788c += i12;
            return i12;
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr) throws IOException {
            this.f31788c += bArr.length;
            this.f31786a.readFully(bArr);
        }
    }

    public static class c extends FilterOutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final OutputStream f31790a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ByteOrder f31791b;

        public c(OutputStream outputStream, ByteOrder byteOrder) {
            super(outputStream);
            this.f31790a = outputStream;
            this.f31791b = byteOrder;
        }

        public void a(ByteOrder byteOrder) {
            this.f31791b = byteOrder;
        }

        public void c(int i10) throws IOException {
            this.f31790a.write(i10);
        }

        public void d(int i10) throws IOException {
            ByteOrder byteOrder = this.f31791b;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.f31790a.write((i10 >>> 0) & 255);
                this.f31790a.write((i10 >>> 8) & 255);
                this.f31790a.write((i10 >>> 16) & 255);
                this.f31790a.write((i10 >>> 24) & 255);
                return;
            }
            if (byteOrder == ByteOrder.BIG_ENDIAN) {
                this.f31790a.write((i10 >>> 24) & 255);
                this.f31790a.write((i10 >>> 16) & 255);
                this.f31790a.write((i10 >>> 8) & 255);
                this.f31790a.write((i10 >>> 0) & 255);
            }
        }

        public void f(short s10) throws IOException {
            ByteOrder byteOrder = this.f31791b;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.f31790a.write((s10 >>> 0) & 255);
                this.f31790a.write((s10 >>> 8) & 255);
            } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
                this.f31790a.write((s10 >>> 8) & 255);
                this.f31790a.write((s10 >>> 0) & 255);
            }
        }

        public void h(long j10) throws IOException {
            d((int) j10);
        }

        public void i(int i10) throws IOException {
            f((short) i10);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.f31790a.write(bArr);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i10, int i11) throws IOException {
            this.f31790a.write(bArr, i10, i11);
        }
    }

    public static class d {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final long f31792e = -1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f31793a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f31794b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f31795c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final byte[] f31796d;

        public d(int i10, int i11, byte[] bArr) {
            this(i10, i11, -1L, bArr);
        }

        public static d a(String str) {
            if (str.length() == 1 && str.charAt(0) >= '0' && str.charAt(0) <= '1') {
                return new d(1, 1, new byte[]{(byte) (str.charAt(0) - '0')});
            }
            byte[] bytes = str.getBytes(a.f31627j7);
            return new d(1, bytes.length, bytes);
        }

        public static d b(double d10, ByteOrder byteOrder) {
            return c(new double[]{d10}, byteOrder);
        }

        public static d c(double[] dArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[a.H6[12] * dArr.length]);
            byteBufferWrap.order(byteOrder);
            for (double d10 : dArr) {
                byteBufferWrap.putDouble(d10);
            }
            return new d(12, dArr.length, byteBufferWrap.array());
        }

        public static d d(int i10, ByteOrder byteOrder) {
            return e(new int[]{i10}, byteOrder);
        }

        public static d e(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[a.H6[9] * iArr.length]);
            byteBufferWrap.order(byteOrder);
            for (int i10 : iArr) {
                byteBufferWrap.putInt(i10);
            }
            return new d(9, iArr.length, byteBufferWrap.array());
        }

        public static d f(h hVar, ByteOrder byteOrder) {
            return g(new h[]{hVar}, byteOrder);
        }

        public static d g(h[] hVarArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[a.H6[10] * hVarArr.length]);
            byteBufferWrap.order(byteOrder);
            for (h hVar : hVarArr) {
                byteBufferWrap.putInt((int) hVar.f31801a);
                byteBufferWrap.putInt((int) hVar.f31802b);
            }
            return new d(10, hVarArr.length, byteBufferWrap.array());
        }

        public static d h(String str) {
            byte[] bytes = (str + (char) 0).getBytes(a.f31627j7);
            return new d(2, bytes.length, bytes);
        }

        public static d i(long j10, ByteOrder byteOrder) {
            return j(new long[]{j10}, byteOrder);
        }

        public static d j(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[a.H6[4] * jArr.length]);
            byteBufferWrap.order(byteOrder);
            for (long j10 : jArr) {
                byteBufferWrap.putInt((int) j10);
            }
            return new d(4, jArr.length, byteBufferWrap.array());
        }

        public static d k(h hVar, ByteOrder byteOrder) {
            return l(new h[]{hVar}, byteOrder);
        }

        public static d l(h[] hVarArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[a.H6[5] * hVarArr.length]);
            byteBufferWrap.order(byteOrder);
            for (h hVar : hVarArr) {
                byteBufferWrap.putInt((int) hVar.f31801a);
                byteBufferWrap.putInt((int) hVar.f31802b);
            }
            return new d(5, hVarArr.length, byteBufferWrap.array());
        }

        public static d m(int i10, ByteOrder byteOrder) {
            return n(new int[]{i10}, byteOrder);
        }

        public static d n(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[a.H6[3] * iArr.length]);
            byteBufferWrap.order(byteOrder);
            for (int i10 : iArr) {
                byteBufferWrap.putShort((short) i10);
            }
            return new d(3, iArr.length, byteBufferWrap.array());
        }

        public double o(ByteOrder byteOrder) throws Throwable {
            Object objR = r(byteOrder);
            if (objR == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            }
            if (objR instanceof String) {
                return Double.parseDouble((String) objR);
            }
            if (objR instanceof long[]) {
                if (((long[]) objR).length == 1) {
                    return r5[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (objR instanceof int[]) {
                if (((int[]) objR).length == 1) {
                    return r5[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (objR instanceof double[]) {
                double[] dArr = (double[]) objR;
                if (dArr.length == 1) {
                    return dArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (!(objR instanceof h[])) {
                throw new NumberFormatException("Couldn't find a double value");
            }
            h[] hVarArr = (h[]) objR;
            if (hVarArr.length == 1) {
                return hVarArr[0].a();
            }
            throw new NumberFormatException("There are more than one component");
        }

        public int p(ByteOrder byteOrder) throws Throwable {
            Object objR = r(byteOrder);
            if (objR == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            }
            if (objR instanceof String) {
                return Integer.parseInt((String) objR);
            }
            if (objR instanceof long[]) {
                long[] jArr = (long[]) objR;
                if (jArr.length == 1) {
                    return (int) jArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (!(objR instanceof int[])) {
                throw new NumberFormatException("Couldn't find a integer value");
            }
            int[] iArr = (int[]) objR;
            if (iArr.length == 1) {
                return iArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }

        public String q(ByteOrder byteOrder) throws Throwable {
            Object objR = r(byteOrder);
            if (objR == null) {
                return null;
            }
            if (objR instanceof String) {
                return (String) objR;
            }
            StringBuilder sb2 = new StringBuilder();
            int i10 = 0;
            if (objR instanceof long[]) {
                long[] jArr = (long[]) objR;
                while (i10 < jArr.length) {
                    sb2.append(jArr[i10]);
                    i10++;
                    if (i10 != jArr.length) {
                        sb2.append(ag.c.f654g);
                    }
                }
                return sb2.toString();
            }
            if (objR instanceof int[]) {
                int[] iArr = (int[]) objR;
                while (i10 < iArr.length) {
                    sb2.append(iArr[i10]);
                    i10++;
                    if (i10 != iArr.length) {
                        sb2.append(ag.c.f654g);
                    }
                }
                return sb2.toString();
            }
            if (objR instanceof double[]) {
                double[] dArr = (double[]) objR;
                while (i10 < dArr.length) {
                    sb2.append(dArr[i10]);
                    i10++;
                    if (i10 != dArr.length) {
                        sb2.append(ag.c.f654g);
                    }
                }
                return sb2.toString();
            }
            if (!(objR instanceof h[])) {
                return null;
            }
            h[] hVarArr = (h[]) objR;
            while (i10 < hVarArr.length) {
                sb2.append(hVarArr[i10].f31801a);
                sb2.append(zc.f.f58380j);
                sb2.append(hVarArr[i10].f31802b);
                i10++;
                if (i10 != hVarArr.length) {
                    sb2.append(ag.c.f654g);
                }
            }
            return sb2.toString();
        }

        public Object r(ByteOrder byteOrder) throws Throwable {
            b bVar;
            byte b10;
            byte[] bArr;
            b bVar2 = null;
            try {
                bVar = new b(this.f31796d);
                try {
                    bVar.d(byteOrder);
                    boolean z10 = true;
                    int length = 0;
                    switch (this.f31793a) {
                        case 1:
                        case 6:
                            byte[] bArr2 = this.f31796d;
                            if (bArr2.length != 1 || bArr2[0] < 0 || bArr2[0] > 1) {
                                String str = new String(bArr2, a.f31627j7);
                                try {
                                    bVar.close();
                                    break;
                                } catch (IOException unused) {
                                }
                                return str;
                            }
                            String str2 = new String(new char[]{(char) (bArr2[0] + l.f36949q)});
                            try {
                                bVar.close();
                                break;
                            } catch (IOException unused2) {
                            }
                            return str2;
                        case 2:
                        case 7:
                            if (this.f31794b >= a.I6.length) {
                                int i10 = 0;
                                while (true) {
                                    bArr = a.I6;
                                    if (i10 < bArr.length) {
                                        if (this.f31796d[i10] != bArr[i10]) {
                                            z10 = false;
                                        } else {
                                            i10++;
                                        }
                                    }
                                }
                                if (z10) {
                                    length = bArr.length;
                                }
                            }
                            StringBuilder sb2 = new StringBuilder();
                            while (length < this.f31794b && (b10 = this.f31796d[length]) != 0) {
                                if (b10 >= 32) {
                                    sb2.append((char) b10);
                                } else {
                                    sb2.append('?');
                                }
                                length++;
                            }
                            String string = sb2.toString();
                            try {
                                bVar.close();
                                break;
                            } catch (IOException unused3) {
                            }
                            return string;
                        case 3:
                            int[] iArr = new int[this.f31794b];
                            while (length < this.f31794b) {
                                iArr[length] = bVar.readUnsignedShort();
                                length++;
                            }
                            try {
                                bVar.close();
                                break;
                            } catch (IOException unused4) {
                            }
                            return iArr;
                        case 4:
                            long[] jArr = new long[this.f31794b];
                            while (length < this.f31794b) {
                                jArr[length] = bVar.c();
                                length++;
                            }
                            try {
                                bVar.close();
                                break;
                            } catch (IOException unused5) {
                            }
                            return jArr;
                        case 5:
                            h[] hVarArr = new h[this.f31794b];
                            while (length < this.f31794b) {
                                hVarArr[length] = new h(bVar.c(), bVar.c());
                                length++;
                            }
                            try {
                                bVar.close();
                                break;
                            } catch (IOException unused6) {
                            }
                            return hVarArr;
                        case 8:
                            int[] iArr2 = new int[this.f31794b];
                            while (length < this.f31794b) {
                                iArr2[length] = bVar.readShort();
                                length++;
                            }
                            try {
                                bVar.close();
                                break;
                            } catch (IOException unused7) {
                            }
                            return iArr2;
                        case 9:
                            int[] iArr3 = new int[this.f31794b];
                            while (length < this.f31794b) {
                                iArr3[length] = bVar.readInt();
                                length++;
                            }
                            try {
                                bVar.close();
                                break;
                            } catch (IOException unused8) {
                            }
                            return iArr3;
                        case 10:
                            h[] hVarArr2 = new h[this.f31794b];
                            while (length < this.f31794b) {
                                hVarArr2[length] = new h(bVar.readInt(), bVar.readInt());
                                length++;
                            }
                            try {
                                bVar.close();
                                break;
                            } catch (IOException unused9) {
                            }
                            return hVarArr2;
                        case 11:
                            double[] dArr = new double[this.f31794b];
                            while (length < this.f31794b) {
                                dArr[length] = bVar.readFloat();
                                length++;
                            }
                            try {
                                bVar.close();
                                break;
                            } catch (IOException unused10) {
                            }
                            return dArr;
                        case 12:
                            double[] dArr2 = new double[this.f31794b];
                            while (length < this.f31794b) {
                                dArr2[length] = bVar.readDouble();
                                length++;
                            }
                            try {
                                bVar.close();
                                break;
                            } catch (IOException unused11) {
                            }
                            return dArr2;
                        default:
                            try {
                                bVar.close();
                                break;
                            } catch (IOException unused12) {
                            }
                            return null;
                    }
                } catch (IOException unused13) {
                    if (bVar != null) {
                        try {
                            bVar.close();
                        } catch (IOException unused14) {
                        }
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    bVar2 = bVar;
                    if (bVar2 != null) {
                        try {
                            bVar2.close();
                        } catch (IOException unused15) {
                        }
                    }
                    throw th;
                }
            } catch (IOException unused16) {
                bVar = null;
            } catch (Throwable th3) {
                th = th3;
            }
        }

        public int s() {
            return a.H6[this.f31793a] * this.f31794b;
        }

        public String toString() {
            return ee.a.f26978c + a.G6[this.f31793a] + ", data length:" + this.f31796d.length + ee.a.f26979d;
        }

        public d(int i10, int i11, long j10, byte[] bArr) {
            this.f31793a = i10;
            this.f31794b = i11;
            this.f31795c = j10;
            this.f31796d = bArr;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface e {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface g {
    }

    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f31801a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f31802b;

        public h(double d10) {
            this((long) (d10 * 10000.0d), 10000L);
        }

        public double a() {
            return this.f31801a / this.f31802b;
        }

        public String toString() {
            return this.f31801a + fh.a.f28350w + this.f31802b;
        }

        public h(long j10, long j11) {
            if (j11 == 0) {
                this.f31801a = 0L;
                this.f31802b = 1L;
            } else {
                this.f31801a = j10;
                this.f31802b = j11;
            }
        }
    }

    static {
        f[] fVarArr = {new f(f31710u2, 254, 4), new f(f31718v2, 255, 4), new f(f31733x, 256, 3, 4), new f(f31742y, 257, 3, 4), new f(f31751z, gg.b.f29449j, 3), new f(A, gg.b.f29457l, 3), new f(B, gg.b.f29481r, 3), new f(V, 270, 2), new f(W, 271, 2), new f(X, gg.b.J, 2), new f(K, 273, 3, 4), new f(C, 274, 3), new f(D, 277, 3), new f(L, gg.b.P, 3, 4), new f(M, 279, 3, 4), new f(H, 282, 5), new f(I, DfuBaseService.NOTIFICATION_ID, 5), new f(E, 284, 3), new f(J, 296, 3), new f(P, 301, 3), new f(Y, 305, 2), new f(U, 306, 2), new f(Z, 315, 2), new f(Q, w.a.f53657s, 5), new f(R, 319, 5), new f(f31754z2, 330, 4), new f(N, 513, 4), new f(O, gg.b.W, 4), new f(S, gg.b.f29486s0, 5), new f(F, gg.b.f29490t0, 3), new f(G, gg.b.f29498v0, 3), new f(T, gg.b.f29502w0, 5), new f(f31548a0, 33432, 2), new f(f31727w2, 34665, 4), new f(f31736x2, 34853, 4), new f(f31678q2, 4, 4), new f(f31662o2, 5, 4), new f(f31654n2, 6, 4), new f(f31670p2, 7, 4), new f(f31686r2, 23, 3), new f(f31694s2, 46, 7), new f(f31702t2, 700, 1)};
        J6 = fVarArr;
        f[] fVarArr2 = {new f(f31708u0, 33434, 5), new f(f31716v0, 33437, 5), new f(f31725w0, 34850, 3), new f(f31734x0, 34852, 2), new f(f31752z0, 34855, 3), new f(A0, 34856, 7), new f(B0, 34864, 3), new f(C0, 34865, 4), new f(D0, 34866, 4), new f(E0, 34867, 4), new f(F0, 34868, 4), new f(G0, 34869, 4), new f(f31556b0, 36864, 2), new f(f31644m0, 36867, 2), new f(f31652n0, 36868, 2), new f(f31660o0, 36880, 2), new f(f31668p0, 36881, 2), new f(f31676q0, 36882, 2), new f(f31604h0, 37121, 7), new f(f31612i0, 37122, 5), new f(H0, 37377, 10), new f(I0, 37378, 5), new f(J0, 37379, 10), new f(K0, 37380, 10), new f(L0, 37381, 5), new f(M0, 37382, 5), new f(N0, 37383, 3), new f(O0, 37384, 3), new f(P0, 37385, 3), new f(R0, 37386, 5), new f(Q0, 37396, 3), new f(f31620j0, 37500, 7), new f(f31628k0, 37510, 7), new f(f31684r0, 37520, 2), new f(f31692s0, 37521, 2), new f(f31700t0, 37522, 2), new f(f31564c0, 40960, 7), new f(f31572d0, 40961, 3), new f(f31588f0, 40962, 3, 4), new f(f31596g0, 40963, 3, 4), new f(f31636l0, 40964, 2), new f(f31745y2, 40965, 4), new f(S0, 41483, 5), new f(T0, 41484, 7), new f(U0, 41486, 5), new f(V0, 41487, 5), new f(W0, 41488, 3), new f(X0, 41492, 3), new f(Y0, 41493, 5), new f(Z0, 41495, 3), new f(f31549a1, 41728, 7), new f(f31557b1, 41729, 7), new f(f31565c1, 41730, 7), new f(f31573d1, 41985, 3), new f(f31581e1, 41986, 3), new f(f31589f1, 41987, 3), new f(f31597g1, 41988, 5), new f(f31605h1, 41989, 3), new f(f31613i1, 41990, 3), new f(f31621j1, 41991, 3), new f(f31629k1, 41992, 3), new f(f31637l1, 41993, 3), new f(f31645m1, 41994, 3), new f(f31653n1, 41995, 7), new f(f31661o1, 41996, 3), new f(f31669p1, 42016, 2), new f("CameraOwnerName", 42032, 2), new f(f31693s1, 42033, 2), new f(f31701t1, 42034, 5), new f(f31709u1, 42035, 2), new f(f31717v1, 42036, 2), new f(f31580e0, 42240, 5), new f(f31606h2, 50706, 1), new f(f31614i2, 50720, 3, 4)};
        K6 = fVarArr2;
        f[] fVarArr3 = {new f(f31735x1, 0, 1), new f(f31744y1, 1, 2), new f(f31753z1, 2, 5, 10), new f(A1, 3, 2), new f(B1, 4, 5, 10), new f(C1, 5, 1), new f(D1, 6, 5), new f(E1, 7, 5), new f(F1, 8, 2), new f(G1, 9, 2), new f(H1, 10, 2), new f(I1, 11, 5), new f(J1, 12, 2), new f(K1, 13, 5), new f(L1, 14, 2), new f(M1, 15, 5), new f(N1, 16, 2), new f(O1, 17, 5), new f(P1, 18, 2), new f(Q1, 19, 2), new f(R1, 20, 5), new f(S1, 21, 2), new f(T1, 22, 5), new f(U1, 23, 2), new f(V1, 24, 5), new f(W1, 25, 2), new f(X1, 26, 5), new f(Y1, 27, 7), new f(Z1, 28, 7), new f(f31550a2, 29, 2), new f(f31558b2, 30, 3), new f(f31566c2, 31, 5)};
        L6 = fVarArr3;
        f[] fVarArr4 = {new f(f31574d2, 1, 2)};
        M6 = fVarArr4;
        f[] fVarArr5 = {new f(f31710u2, 254, 4), new f(f31718v2, 255, 4), new f(f31590f2, 256, 3, 4), new f(f31582e2, 257, 3, 4), new f(f31751z, gg.b.f29449j, 3), new f(A, gg.b.f29457l, 3), new f(B, gg.b.f29481r, 3), new f(V, 270, 2), new f(W, 271, 2), new f(X, gg.b.J, 2), new f(K, 273, 3, 4), new f(f31598g2, 274, 3), new f(D, 277, 3), new f(L, gg.b.P, 3, 4), new f(M, 279, 3, 4), new f(H, 282, 5), new f(I, DfuBaseService.NOTIFICATION_ID, 5), new f(E, 284, 3), new f(J, 296, 3), new f(P, 301, 3), new f(Y, 305, 2), new f(U, 306, 2), new f(Z, 315, 2), new f(Q, w.a.f53657s, 5), new f(R, 319, 5), new f(f31754z2, 330, 4), new f(N, 513, 4), new f(O, gg.b.W, 4), new f(S, gg.b.f29486s0, 5), new f(F, gg.b.f29490t0, 3), new f(G, gg.b.f29498v0, 3), new f(T, gg.b.f29502w0, 5), new f(f31702t2, 700, 1), new f(f31548a0, 33432, 2), new f(f31727w2, 34665, 4), new f(f31736x2, 34853, 4), new f(f31606h2, 50706, 1), new f(f31614i2, 50720, 3, 4)};
        N6 = fVarArr5;
        O6 = new f(K, 273, 3);
        f[] fVarArr6 = {new f(f31622j2, 256, 7), new f(A2, 8224, 4), new f(B2, 8256, 4)};
        P6 = fVarArr6;
        f[] fVarArr7 = {new f(f31630k2, 257, 4), new f(f31638l2, gg.b.f29449j, 4)};
        Q6 = fVarArr7;
        f[] fVarArr8 = {new f(f31646m2, 4371, 3)};
        R6 = fVarArr8;
        f[] fVarArr9 = {new f(f31572d0, 55, 3)};
        S6 = fVarArr9;
        f[][] fVarArr10 = {fVarArr, fVarArr2, fVarArr3, fVarArr4, fVarArr5, fVarArr, fVarArr6, fVarArr7, fVarArr8, fVarArr9};
        f31579d7 = fVarArr10;
        f31587e7 = new f[]{new f(f31754z2, 330, 4), new f(f31727w2, 34665, 4), new f(f31736x2, 34853, 4), new f(f31745y2, 40965, 4), new f(A2, 8224, 1), new f(B2, 8256, 1)};
        f31595f7 = new HashMap[fVarArr10.length];
        f31603g7 = new HashMap[fVarArr10.length];
        f31611h7 = new HashSet<>(Arrays.asList(f31716v0, f31597g1, f31708u0, M0, E1));
        f31619i7 = new HashMap<>();
        Charset charsetForName = Charset.forName(ya.g.f56707m);
        f31627j7 = charsetForName;
        f31635k7 = "Exif\u0000\u0000".getBytes(charsetForName);
        f31643l7 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(charsetForName);
        Locale locale = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale);
        f31650m6 = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(r.f20160a));
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale);
        f31658n6 = simpleDateFormat2;
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone(r.f20160a));
        int i10 = 0;
        while (true) {
            f[][] fVarArr11 = f31579d7;
            if (i10 >= fVarArr11.length) {
                HashMap<Integer, Integer> map = f31619i7;
                f[] fVarArr12 = f31587e7;
                map.put(Integer.valueOf(fVarArr12[0].f31797a), 5);
                map.put(Integer.valueOf(fVarArr12[1].f31797a), 1);
                map.put(Integer.valueOf(fVarArr12[2].f31797a), 2);
                map.put(Integer.valueOf(fVarArr12[3].f31797a), 3);
                map.put(Integer.valueOf(fVarArr12[4].f31797a), 7);
                map.put(Integer.valueOf(fVarArr12[5].f31797a), 8);
                U7 = Pattern.compile(".*[1-9].*");
                V7 = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
                W7 = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                X7 = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                return;
            }
            f31595f7[i10] = new HashMap<>();
            f31603g7[i10] = new HashMap<>();
            for (f fVar : fVarArr11[i10]) {
                f31595f7[i10].put(Integer.valueOf(fVar.f31797a), fVar);
                f31603g7[i10].put(fVar.f31798b, fVar);
            }
            i10++;
        }
    }

    public a(@n0 File file) throws Throwable {
        f[][] fVarArr = f31579d7;
        this.f31765f = new HashMap[fVarArr.length];
        this.f31766g = new HashSet(fVarArr.length);
        this.f31767h = ByteOrder.BIG_ENDIAN;
        Objects.requireNonNull(file, "file cannot be null");
        O(file.getAbsolutePath());
    }

    public static boolean A0(int i10) {
        return (i10 == 4 || i10 == 9 || i10 == 13 || i10 == 14) ? false : true;
    }

    public static Pair<Integer, Integer> J(String str) {
        if (str.contains(ag.c.f654g)) {
            String[] strArrSplit = str.split(ag.c.f654g, -1);
            Pair<Integer, Integer> pairJ = J(strArrSplit[0]);
            if (((Integer) pairJ.first).intValue() == 2) {
                return pairJ;
            }
            for (int i10 = 1; i10 < strArrSplit.length; i10++) {
                Pair<Integer, Integer> pairJ2 = J(strArrSplit[i10]);
                int iIntValue = (((Integer) pairJ2.first).equals(pairJ.first) || ((Integer) pairJ2.second).equals(pairJ.first)) ? ((Integer) pairJ.first).intValue() : -1;
                int iIntValue2 = (((Integer) pairJ.second).intValue() == -1 || !(((Integer) pairJ2.first).equals(pairJ.second) || ((Integer) pairJ2.second).equals(pairJ.second))) ? -1 : ((Integer) pairJ.second).intValue();
                if (iIntValue == -1 && iIntValue2 == -1) {
                    return new Pair<>(2, -1);
                }
                if (iIntValue == -1) {
                    pairJ = new Pair<>(Integer.valueOf(iIntValue2), -1);
                } else if (iIntValue2 == -1) {
                    pairJ = new Pair<>(Integer.valueOf(iIntValue), -1);
                }
            }
            return pairJ;
        }
        if (!str.contains(fh.a.f28350w)) {
            try {
                try {
                    Long lValueOf = Long.valueOf(Long.parseLong(str));
                    return (lValueOf.longValue() < 0 || lValueOf.longValue() > dm.g.f26388t) ? lValueOf.longValue() < 0 ? new Pair<>(9, -1) : new Pair<>(4, -1) : new Pair<>(3, 4);
                } catch (NumberFormatException unused) {
                    return new Pair<>(2, -1);
                }
            } catch (NumberFormatException unused2) {
                Double.parseDouble(str);
                return new Pair<>(12, -1);
            }
        }
        String[] strArrSplit2 = str.split(fh.a.f28350w, -1);
        if (strArrSplit2.length == 2) {
            try {
                long j10 = (long) Double.parseDouble(strArrSplit2[0]);
                long j11 = (long) Double.parseDouble(strArrSplit2[1]);
                if (j10 >= 0 && j11 >= 0) {
                    if (j10 <= 2147483647L && j11 <= 2147483647L) {
                        return new Pair<>(10, 5);
                    }
                    return new Pair<>(5, -1);
                }
                return new Pair<>(10, -1);
            } catch (NumberFormatException unused3) {
            }
        }
        return new Pair<>(2, -1);
    }

    public static boolean P(BufferedInputStream bufferedInputStream) throws IOException {
        byte[] bArr = f31635k7;
        bufferedInputStream.mark(bArr.length);
        byte[] bArr2 = new byte[bArr.length];
        bufferedInputStream.read(bArr2);
        bufferedInputStream.reset();
        int i10 = 0;
        while (true) {
            byte[] bArr3 = f31635k7;
            if (i10 >= bArr3.length) {
                return true;
            }
            if (bArr2[i10] != bArr3[i10]) {
                return false;
            }
            i10++;
        }
    }

    public static boolean S(byte[] bArr) throws IOException {
        int i10 = 0;
        while (true) {
            byte[] bArr2 = D5;
            if (i10 >= bArr2.length) {
                return true;
            }
            if (bArr[i10] != bArr2[i10]) {
                return false;
            }
            i10++;
        }
    }

    public static boolean X(FileDescriptor fileDescriptor) {
        try {
            b.a.c(fileDescriptor, 0L, OsConstants.SEEK_CUR);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean Z(int i10) {
        return i10 == 4 || i10 == 13 || i10 == 14 || i10 == 3 || i10 == 0;
    }

    public static boolean a0(@n0 String str) {
        Objects.requireNonNull(str, "mimeType shouldn't be null");
        String lowerCase = str.toLowerCase(Locale.ROOT);
        lowerCase.hashCode();
        switch (lowerCase) {
            case "image/x-fuji-raf":
            case "image/x-samsung-srw":
            case "image/x-sony-arw":
            case "image/heic":
            case "image/heif":
            case "image/jpeg":
            case "image/webp":
            case "image/x-adobe-dng":
            case "image/x-panasonic-rw2":
            case "image/png":
            case "image/x-pentax-pef":
            case "image/x-olympus-orf":
            case "image/x-nikon-nef":
            case "image/x-nikon-nrw":
            case "image/x-canon-cr2":
                return true;
            default:
                return false;
        }
    }

    public static double c(String str, String str2) {
        try {
            String[] strArrSplit = str.split(ag.c.f654g, -1);
            String[] strArrSplit2 = strArrSplit[0].split(fh.a.f28350w, -1);
            double d10 = Double.parseDouble(strArrSplit2[0].trim()) / Double.parseDouble(strArrSplit2[1].trim());
            String[] strArrSplit3 = strArrSplit[1].split(fh.a.f28350w, -1);
            double d11 = Double.parseDouble(strArrSplit3[0].trim()) / Double.parseDouble(strArrSplit3[1].trim());
            String[] strArrSplit4 = strArrSplit[2].split(fh.a.f28350w, -1);
            double d12 = d10 + (d11 / 60.0d) + ((Double.parseDouble(strArrSplit4[0].trim()) / Double.parseDouble(strArrSplit4[1].trim())) / 3600.0d);
            if (!str2.equals(R4) && !str2.equals(T4)) {
                if (!str2.equals("N") && !str2.equals(S4)) {
                    throw new IllegalArgumentException();
                }
                return d12;
            }
            return -d12;
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException unused) {
            throw new IllegalArgumentException();
        }
    }

    public static Long f0(@p0 String str, @p0 String str2, @p0 String str3) {
        if (str != null && U7.matcher(str).matches()) {
            ParsePosition parsePosition = new ParsePosition(0);
            try {
                Date date = f31650m6.parse(str, parsePosition);
                if (date == null && (date = f31658n6.parse(str, parsePosition)) == null) {
                    return null;
                }
                long time = date.getTime();
                if (str3 != null) {
                    int i10 = 1;
                    String strSubstring = str3.substring(0, 1);
                    int i11 = Integer.parseInt(str3.substring(1, 3));
                    int i12 = Integer.parseInt(str3.substring(4, 6));
                    if ((com.google.android.material.badge.a.f19590u.equals(strSubstring) || "-".equals(strSubstring)) && ":".equals(str3.substring(3, 4)) && i11 <= 14) {
                        int i13 = ((i11 * 60) + i12) * 60 * 1000;
                        if (!"-".equals(strSubstring)) {
                            i10 = -1;
                        }
                        time += (long) (i13 * i10);
                    }
                }
                if (str2 != null) {
                    time += i1.b.g(str2);
                }
                return Long.valueOf(time);
            } catch (IllegalArgumentException unused) {
            }
        }
        return null;
    }

    public final void A(i iVar) throws Throwable {
        d dVar;
        g0(iVar);
        k0(iVar, 0);
        C0(iVar, 0);
        C0(iVar, 5);
        C0(iVar, 4);
        D0();
        if (this.f31763d != 8 || (dVar = this.f31765f[1].get(f31620j0)) == null) {
            return;
        }
        i iVar2 = new i(dVar.f31796d);
        iVar2.d(this.f31767h);
        iVar2.f(6);
        k0(iVar2, 9);
        d dVar2 = this.f31765f[9].get(f31572d0);
        if (dVar2 != null) {
            this.f31765f[1].put(f31572d0, dVar2);
        }
    }

    public int B() {
        switch (l(C, 1)) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 8:
                return 270;
            case 6:
            case 7:
                return 90;
            default:
                return 0;
        }
    }

    public final void B0(int i10, int i11) throws Throwable {
        if (this.f31765f[i10].isEmpty() || this.f31765f[i11].isEmpty()) {
            return;
        }
        d dVar = this.f31765f[i10].get(f31742y);
        d dVar2 = this.f31765f[i10].get(f31733x);
        d dVar3 = this.f31765f[i11].get(f31742y);
        d dVar4 = this.f31765f[i11].get(f31733x);
        if (dVar == null || dVar2 == null || dVar3 == null || dVar4 == null) {
            return;
        }
        int iP = dVar.p(this.f31767h);
        int iP2 = dVar2.p(this.f31767h);
        int iP3 = dVar3.p(this.f31767h);
        int iP4 = dVar4.p(this.f31767h);
        if (iP >= iP3 || iP2 >= iP4) {
            return;
        }
        HashMap<String, d>[] mapArr = this.f31765f;
        HashMap<String, d> map = mapArr[i10];
        mapArr[i10] = mapArr[i11];
        mapArr[i11] = map;
    }

    public final void C(i iVar) throws Throwable {
        if (f31724w) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getRw2Attributes starting with: ");
            sb2.append(iVar);
        }
        A(iVar);
        d dVar = this.f31765f[0].get(f31694s2);
        if (dVar != null) {
            t(new b(dVar.f31796d), (int) dVar.f31795c, 5);
        }
        d dVar2 = this.f31765f[0].get(f31686r2);
        d dVar3 = this.f31765f[1].get(f31752z0);
        if (dVar2 == null || dVar3 != null) {
            return;
        }
        this.f31765f[1].put(f31752z0, dVar2);
    }

    public final void C0(i iVar, int i10) throws Throwable {
        d dVarM;
        d dVarM2;
        d dVar = this.f31765f[i10].get(f31614i2);
        d dVar2 = this.f31765f[i10].get(f31678q2);
        d dVar3 = this.f31765f[i10].get(f31662o2);
        d dVar4 = this.f31765f[i10].get(f31654n2);
        d dVar5 = this.f31765f[i10].get(f31670p2);
        if (dVar == null) {
            if (dVar2 == null || dVar3 == null || dVar4 == null || dVar5 == null) {
                o0(iVar, i10);
                return;
            }
            int iP = dVar2.p(this.f31767h);
            int iP2 = dVar4.p(this.f31767h);
            int iP3 = dVar5.p(this.f31767h);
            int iP4 = dVar3.p(this.f31767h);
            if (iP2 <= iP || iP3 <= iP4) {
                return;
            }
            d dVarM3 = d.m(iP2 - iP, this.f31767h);
            d dVarM4 = d.m(iP3 - iP4, this.f31767h);
            this.f31765f[i10].put(f31742y, dVarM3);
            this.f31765f[i10].put(f31733x, dVarM4);
            return;
        }
        if (dVar.f31793a == 5) {
            h[] hVarArr = (h[]) dVar.r(this.f31767h);
            if (hVarArr == null || hVarArr.length != 2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Invalid crop size values. cropSize=");
                sb2.append(Arrays.toString(hVarArr));
                return;
            }
            dVarM = d.k(hVarArr[0], this.f31767h);
            dVarM2 = d.k(hVarArr[1], this.f31767h);
        } else {
            int[] iArr = (int[]) dVar.r(this.f31767h);
            if (iArr == null || iArr.length != 2) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Invalid crop size values. cropSize=");
                sb3.append(Arrays.toString(iArr));
                return;
            }
            dVarM = d.m(iArr[0], this.f31767h);
            dVarM2 = d.m(iArr[1], this.f31767h);
        }
        this.f31765f[i10].put(f31733x, dVarM);
        this.f31765f[i10].put(f31742y, dVarM2);
    }

    public final void D(i iVar) throws IOException {
        byte[] bArr = f31635k7;
        iVar.f(bArr.length);
        byte[] bArr2 = new byte[iVar.available()];
        iVar.readFully(bArr2);
        this.f31775p = bArr.length;
        j0(bArr2, 0);
    }

    public final void D0() throws Throwable {
        B0(0, 5);
        B0(0, 4);
        B0(5, 4);
        d dVar = this.f31765f[1].get(f31588f0);
        d dVar2 = this.f31765f[1].get(f31596g0);
        if (dVar != null && dVar2 != null) {
            this.f31765f[0].put(f31733x, dVar);
            this.f31765f[0].put(f31742y, dVar2);
        }
        if (this.f31765f[4].isEmpty() && b0(this.f31765f[5])) {
            HashMap<String, d>[] mapArr = this.f31765f;
            mapArr[4] = mapArr[5];
            mapArr[5] = new HashMap<>();
        }
        b0(this.f31765f[4]);
        m0(0, f31598g2, C);
        m0(0, f31582e2, f31742y);
        m0(0, f31590f2, f31733x);
        m0(5, f31598g2, C);
        m0(5, f31582e2, f31742y);
        m0(5, f31590f2, f31733x);
        m0(4, C, f31598g2);
        m0(4, f31742y, f31582e2);
        m0(4, f31733x, f31590f2);
    }

    @p0
    public byte[] E() {
        int i10 = this.f31774o;
        if (i10 == 6 || i10 == 7) {
            return G();
        }
        return null;
    }

    public final int E0(c cVar) throws IOException {
        f[][] fVarArr = f31579d7;
        int[] iArr = new int[fVarArr.length];
        int[] iArr2 = new int[fVarArr.length];
        for (f fVar : f31587e7) {
            l0(fVar.f31798b);
        }
        if (this.f31768i) {
            if (this.f31769j) {
                l0(K);
                l0(M);
            } else {
                l0(N);
                l0(O);
            }
        }
        for (int i10 = 0; i10 < f31579d7.length; i10++) {
            for (Object obj : this.f31765f[i10].entrySet().toArray()) {
                Map.Entry entry = (Map.Entry) obj;
                if (entry.getValue() == null) {
                    this.f31765f[i10].remove(entry.getKey());
                }
            }
        }
        if (!this.f31765f[1].isEmpty()) {
            this.f31765f[0].put(f31587e7[1].f31798b, d.i(0L, this.f31767h));
        }
        if (!this.f31765f[2].isEmpty()) {
            this.f31765f[0].put(f31587e7[2].f31798b, d.i(0L, this.f31767h));
        }
        if (!this.f31765f[3].isEmpty()) {
            this.f31765f[1].put(f31587e7[3].f31798b, d.i(0L, this.f31767h));
        }
        if (this.f31768i) {
            if (this.f31769j) {
                this.f31765f[4].put(K, d.m(0, this.f31767h));
                this.f31765f[4].put(M, d.m(this.f31772m, this.f31767h));
            } else {
                this.f31765f[4].put(N, d.i(0L, this.f31767h));
                this.f31765f[4].put(O, d.i(this.f31772m, this.f31767h));
            }
        }
        for (int i11 = 0; i11 < f31579d7.length; i11++) {
            Iterator<Map.Entry<String, d>> it2 = this.f31765f[i11].entrySet().iterator();
            int i12 = 0;
            while (it2.hasNext()) {
                int iS = it2.next().getValue().s();
                if (iS > 4) {
                    i12 += iS;
                }
            }
            iArr2[i11] = iArr2[i11] + i12;
        }
        int size = 8;
        for (int i13 = 0; i13 < f31579d7.length; i13++) {
            if (!this.f31765f[i13].isEmpty()) {
                iArr[i13] = size;
                size += (this.f31765f[i13].size() * 12) + 2 + 4 + iArr2[i13];
            }
        }
        if (this.f31768i) {
            if (this.f31769j) {
                this.f31765f[4].put(K, d.m(size, this.f31767h));
            } else {
                this.f31765f[4].put(N, d.i(size, this.f31767h));
            }
            this.f31771l = size;
            size += this.f31772m;
        }
        if (this.f31763d == 4) {
            size += 8;
        }
        if (f31724w) {
            for (int i14 = 0; i14 < f31579d7.length; i14++) {
                String.format("index: %d, offsets: %d, tag count: %d, data sizes: %d, total size: %d", Integer.valueOf(i14), Integer.valueOf(iArr[i14]), Integer.valueOf(this.f31765f[i14].size()), Integer.valueOf(iArr2[i14]), Integer.valueOf(size));
            }
        }
        if (!this.f31765f[1].isEmpty()) {
            this.f31765f[0].put(f31587e7[1].f31798b, d.i(iArr[1], this.f31767h));
        }
        if (!this.f31765f[2].isEmpty()) {
            this.f31765f[0].put(f31587e7[2].f31798b, d.i(iArr[2], this.f31767h));
        }
        if (!this.f31765f[3].isEmpty()) {
            this.f31765f[1].put(f31587e7[3].f31798b, d.i(iArr[3], this.f31767h));
        }
        int i15 = this.f31763d;
        if (i15 == 4) {
            cVar.i(size);
            cVar.write(f31635k7);
        } else if (i15 == 13) {
            cVar.d(size);
            cVar.write(T5);
        } else if (i15 == 14) {
            cVar.write(f31562b6);
            cVar.d(size);
        }
        cVar.f(this.f31767h == ByteOrder.BIG_ENDIAN ? f31674p6 : f31666o6);
        cVar.a(this.f31767h);
        cVar.i(42);
        cVar.h(8L);
        for (int i16 = 0; i16 < f31579d7.length; i16++) {
            if (!this.f31765f[i16].isEmpty()) {
                cVar.i(this.f31765f[i16].size());
                int size2 = iArr[i16] + 2 + (this.f31765f[i16].size() * 12) + 4;
                for (Map.Entry<String, d> entry2 : this.f31765f[i16].entrySet()) {
                    int i17 = f31603g7[i16].get(entry2.getKey()).f31797a;
                    d value = entry2.getValue();
                    int iS2 = value.s();
                    cVar.i(i17);
                    cVar.i(value.f31793a);
                    cVar.d(value.f31794b);
                    if (iS2 > 4) {
                        cVar.h(size2);
                        size2 += iS2;
                    } else {
                        cVar.write(value.f31796d);
                        if (iS2 < 4) {
                            while (iS2 < 4) {
                                cVar.c(0);
                                iS2++;
                            }
                        }
                    }
                }
                if (i16 != 0 || this.f31765f[4].isEmpty()) {
                    cVar.h(0L);
                } else {
                    cVar.h(iArr[4]);
                }
                Iterator<Map.Entry<String, d>> it3 = this.f31765f[i16].entrySet().iterator();
                while (it3.hasNext()) {
                    byte[] bArr = it3.next().getValue().f31796d;
                    if (bArr.length > 4) {
                        cVar.write(bArr, 0, bArr.length);
                    }
                }
            }
        }
        if (this.f31768i) {
            cVar.write(G());
        }
        if (this.f31763d == 14 && size % 2 == 1) {
            cVar.c(0);
        }
        cVar.a(ByteOrder.BIG_ENDIAN);
        return size;
    }

    @p0
    public Bitmap F() throws Throwable {
        if (!this.f31768i) {
            return null;
        }
        if (this.f31773n == null) {
            this.f31773n = G();
        }
        int i10 = this.f31774o;
        if (i10 == 6 || i10 == 7) {
            return BitmapFactory.decodeByteArray(this.f31773n, 0, this.f31772m);
        }
        if (i10 == 1) {
            int length = this.f31773n.length / 3;
            int[] iArr = new int[length];
            for (int i11 = 0; i11 < length; i11++) {
                byte[] bArr = this.f31773n;
                int i12 = i11 * 3;
                iArr[i11] = (bArr[i12] << 16) + 0 + (bArr[i12 + 1] << 8) + bArr[i12 + 2];
            }
            d dVar = this.f31765f[4].get(f31582e2);
            d dVar2 = this.f31765f[4].get(f31590f2);
            if (dVar != null && dVar2 != null) {
                return Bitmap.createBitmap(iArr, dVar2.p(this.f31767h), dVar.p(this.f31767h), Bitmap.Config.ARGB_8888);
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[SYNTHETIC] */
    @g.p0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public byte[] G() throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r10.f31768i
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            byte[] r0 = r10.f31773n
            if (r0 == 0) goto Lb
            return r0
        Lb:
            android.content.res.AssetManager$AssetInputStream r0 = r10.f31762c     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L9a
            if (r0 == 0) goto L28
            boolean r2 = r0.markSupported()     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L25
            if (r2 == 0) goto L1a
            r0.reset()     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L25
        L18:
            r2 = r1
            goto L49
        L1a:
            i1.b.c(r0)
            return r1
        L1e:
            r2 = move-exception
            r9 = r1
            r1 = r0
            r0 = r2
            r2 = r9
            goto L91
        L25:
            r2 = r1
            goto L9c
        L28:
            java.lang.String r0 = r10.f31760a     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L9a
            if (r0 == 0) goto L34
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L9a
            java.lang.String r2 = r10.f31760a     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L9a
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L9a
            goto L18
        L34:
            java.io.FileDescriptor r0 = r10.f31761b     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L9a
            java.io.FileDescriptor r0 = i1.b.a.b(r0)     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L9a
            r2 = 0
            int r4 = android.system.OsConstants.SEEK_SET     // Catch: java.lang.Throwable -> L87 java.lang.Exception -> L8b
            i1.b.a.c(r0, r2, r4)     // Catch: java.lang.Throwable -> L87 java.lang.Exception -> L8b
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L87 java.lang.Exception -> L8b
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L87 java.lang.Exception -> L8b
            r9 = r2
            r2 = r0
            r0 = r9
        L49:
            int r3 = r10.f31771l     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L9c
            int r4 = r10.f31775p     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L9c
            int r3 = r3 + r4
            long r3 = (long) r3     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L9c
            long r3 = r0.skip(r3)     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L9c
            int r5 = r10.f31771l     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L9c
            int r6 = r10.f31775p     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L9c
            int r5 = r5 + r6
            long r5 = (long) r5
            java.lang.String r7 = "Corrupted image"
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 != 0) goto L7c
            int r3 = r10.f31772m     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L9c
            byte[] r3 = new byte[r3]     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L9c
            int r4 = r0.read(r3)     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L9c
            int r5 = r10.f31772m     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L9c
            if (r4 != r5) goto L76
            r10.f31773n = r3     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L9c
            i1.b.c(r0)
            if (r2 == 0) goto L75
            i1.b.b(r2)
        L75:
            return r3
        L76:
            java.io.IOException r3 = new java.io.IOException     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L9c
            r3.<init>(r7)     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L9c
            throw r3     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L9c
        L7c:
            java.io.IOException r3 = new java.io.IOException     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L9c
            r3.<init>(r7)     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L9c
            throw r3     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L9c
        L82:
            r1 = move-exception
            r9 = r1
            r1 = r0
        L85:
            r0 = r9
            goto L91
        L87:
            r2 = move-exception
            r9 = r2
            r2 = r0
            goto L85
        L8b:
            r2 = r0
            r0 = r1
            goto L9c
        L8e:
            r2 = move-exception
            r0 = r2
            r2 = r1
        L91:
            i1.b.c(r1)
            if (r2 == 0) goto L99
            i1.b.b(r2)
        L99:
            throw r0
        L9a:
            r0 = r1
            r2 = r0
        L9c:
            i1.b.c(r0)
            if (r2 == 0) goto La4
            i1.b.b(r2)
        La4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: i1.a.G():byte[]");
    }

    @p0
    public long[] H() {
        if (this.f31779t) {
            throw new IllegalStateException("The underlying file has been modified since being parsed");
        }
        if (!this.f31768i) {
            return null;
        }
        if (!this.f31769j || this.f31770k) {
            return new long[]{this.f31771l + this.f31775p, this.f31772m};
        }
        return null;
    }

    public final void I(b bVar) throws Throwable {
        if (f31724w) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getWebpAttributes starting with: ");
            sb2.append(bVar);
        }
        bVar.d(ByteOrder.LITTLE_ENDIAN);
        bVar.f(Y5.length);
        int i10 = bVar.readInt() + 8;
        byte[] bArr = Z5;
        bVar.f(bArr.length);
        int length = bArr.length + 8;
        while (true) {
            try {
                byte[] bArr2 = new byte[4];
                if (bVar.read(bArr2) != 4) {
                    throw new IOException("Encountered invalid length while parsing WebP chunktype");
                }
                int i11 = bVar.readInt();
                int i12 = length + 4 + 4;
                if (Arrays.equals(f31562b6, bArr2)) {
                    byte[] bArr3 = new byte[i11];
                    if (bVar.read(bArr3) == i11) {
                        this.f31775p = i12;
                        j0(bArr3, 0);
                        z0(new b(bArr3));
                        return;
                    } else {
                        throw new IOException("Failed to read given length for given PNG chunk type: " + i1.b.a(bArr2));
                    }
                }
                if (i11 % 2 == 1) {
                    i11++;
                }
                length = i12 + i11;
                if (length == i10) {
                    return;
                }
                if (length > i10) {
                    throw new IOException("Encountered WebP file with invalid chunk size");
                }
                bVar.f(i11);
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt WebP file.");
            }
        }
    }

    public final void K(b bVar, HashMap map) throws Throwable {
        d dVar = (d) map.get(N);
        d dVar2 = (d) map.get(O);
        if (dVar == null || dVar2 == null) {
            return;
        }
        int iP = dVar.p(this.f31767h);
        int iP2 = dVar2.p(this.f31767h);
        if (this.f31763d == 7) {
            iP += this.f31776q;
        }
        if (iP > 0 && iP2 > 0) {
            this.f31768i = true;
            if (this.f31760a == null && this.f31762c == null && this.f31761b == null) {
                byte[] bArr = new byte[iP2];
                bVar.skip(iP);
                bVar.read(bArr);
                this.f31773n = bArr;
            }
            this.f31771l = iP;
            this.f31772m = iP2;
        }
        if (f31724w) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Setting thumbnail attributes with offset: ");
            sb2.append(iP);
            sb2.append(", length: ");
            sb2.append(iP2);
        }
    }

    public final void L(b bVar, HashMap map) throws IOException {
        d dVar = (d) map.get(K);
        d dVar2 = (d) map.get(M);
        if (dVar == null || dVar2 == null) {
            return;
        }
        long[] jArrD = i1.b.d(dVar.r(this.f31767h));
        long[] jArrD2 = i1.b.d(dVar2.r(this.f31767h));
        if (jArrD == null || jArrD.length == 0 || jArrD2 == null || jArrD2.length == 0 || jArrD.length != jArrD2.length) {
            return;
        }
        long j10 = 0;
        for (long j11 : jArrD2) {
            j10 += j11;
        }
        int i10 = (int) j10;
        byte[] bArr = new byte[i10];
        int i11 = 1;
        this.f31770k = true;
        this.f31769j = true;
        this.f31768i = true;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i12 < jArrD.length) {
            int i15 = (int) jArrD[i12];
            int i16 = (int) jArrD2[i12];
            if (i12 < jArrD.length - i11 && i15 + i16 != jArrD[i12 + 1]) {
                this.f31770k = false;
            }
            int i17 = i15 - i13;
            if (i17 < 0) {
                return;
            }
            long j12 = i17;
            if (bVar.skip(j12) != j12) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Failed to skip ");
                sb2.append(i17);
                sb2.append(" bytes.");
                return;
            }
            int i18 = i13 + i17;
            byte[] bArr2 = new byte[i16];
            if (bVar.read(bArr2) != i16) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Failed to read ");
                sb3.append(i16);
                sb3.append(" bytes.");
                return;
            }
            i13 = i18 + i16;
            System.arraycopy(bArr2, 0, bArr, i14, i16);
            i14 += i16;
            i12++;
            i11 = 1;
        }
        this.f31773n = bArr;
        if (this.f31770k) {
            this.f31771l = (int) jArrD[0];
            this.f31772m = i10;
        }
    }

    public boolean M(@n0 String str) {
        return q(str) != null;
    }

    public boolean N() {
        return this.f31768i;
    }

    public final void O(String str) throws Throwable {
        Objects.requireNonNull(str, "filename cannot be null");
        FileInputStream fileInputStream = null;
        this.f31762c = null;
        this.f31760a = str;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                if (X(fileInputStream2.getFD())) {
                    this.f31761b = fileInputStream2.getFD();
                } else {
                    this.f31761b = null;
                }
                e0(fileInputStream2);
                i1.b.c(fileInputStream2);
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                i1.b.c(fileInputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public boolean Q() {
        int iL = l(C, 1);
        return iL == 2 || iL == 7 || iL == 4 || iL == 5;
    }

    public final boolean R(byte[] bArr) throws Throwable {
        b bVar;
        b bVar2 = null;
        try {
            try {
                bVar = new b(bArr);
            } catch (Exception unused) {
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            long length = bVar.readInt();
            byte[] bArr2 = new byte[4];
            bVar.read(bArr2);
            if (!Arrays.equals(bArr2, G5)) {
                bVar.close();
                return false;
            }
            long j10 = 16;
            if (length == 1) {
                length = bVar.readLong();
                if (length < 16) {
                    bVar.close();
                    return false;
                }
            } else {
                j10 = 8;
            }
            if (length > bArr.length) {
                length = bArr.length;
            }
            long j11 = length - j10;
            if (j11 < 8) {
                bVar.close();
                return false;
            }
            byte[] bArr3 = new byte[4];
            boolean z10 = false;
            boolean z11 = false;
            for (long j12 = 0; j12 < j11 / 4; j12++) {
                if (bVar.read(bArr3) != 4) {
                    bVar.close();
                    return false;
                }
                if (j12 != 1) {
                    if (Arrays.equals(bArr3, H5)) {
                        z10 = true;
                    } else if (Arrays.equals(bArr3, I5)) {
                        z11 = true;
                    }
                    if (z10 && z11) {
                        bVar.close();
                        return true;
                    }
                }
            }
            bVar.close();
        } catch (Exception unused2) {
            bVar2 = bVar;
            boolean z12 = f31724w;
            if (bVar2 != null) {
                bVar2.close();
            }
        } catch (Throwable th3) {
            th = th3;
            bVar2 = bVar;
            if (bVar2 != null) {
                bVar2.close();
            }
            throw th;
        }
        return false;
    }

    public final boolean T(byte[] bArr) throws Throwable {
        b bVar = null;
        try {
            b bVar2 = new b(bArr);
            try {
                ByteOrder byteOrderI0 = i0(bVar2);
                this.f31767h = byteOrderI0;
                bVar2.d(byteOrderI0);
                short s10 = bVar2.readShort();
                boolean z10 = s10 == 20306 || s10 == 21330;
                bVar2.close();
                return z10;
            } catch (Exception unused) {
                bVar = bVar2;
                if (bVar != null) {
                    bVar.close();
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                bVar = bVar2;
                if (bVar != null) {
                    bVar.close();
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public final boolean U(byte[] bArr) throws IOException {
        int i10 = 0;
        while (true) {
            byte[] bArr2 = S5;
            if (i10 >= bArr2.length) {
                return true;
            }
            if (bArr[i10] != bArr2[i10]) {
                return false;
            }
            i10++;
        }
    }

    public final boolean V(byte[] bArr) throws IOException {
        byte[] bytes = E5.getBytes(Charset.defaultCharset());
        for (int i10 = 0; i10 < bytes.length; i10++) {
            if (bArr[i10] != bytes[i10]) {
                return false;
            }
        }
        return true;
    }

    public final boolean W(byte[] bArr) throws Throwable {
        b bVar = null;
        try {
            b bVar2 = new b(bArr);
            try {
                ByteOrder byteOrderI0 = i0(bVar2);
                this.f31767h = byteOrderI0;
                bVar2.d(byteOrderI0);
                boolean z10 = bVar2.readShort() == 85;
                bVar2.close();
                return z10;
            } catch (Exception unused) {
                bVar = bVar2;
                if (bVar != null) {
                    bVar.close();
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                bVar = bVar2;
                if (bVar != null) {
                    bVar.close();
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public final boolean Y(HashMap map) throws Throwable {
        d dVar;
        d dVar2 = (d) map.get(f31751z);
        if (dVar2 == null) {
            return false;
        }
        int[] iArr = (int[]) dVar2.r(this.f31767h);
        int[] iArr2 = f31689r5;
        if (Arrays.equals(iArr2, iArr)) {
            return true;
        }
        if (this.f31763d != 3 || (dVar = (d) map.get(B)) == null) {
            return false;
        }
        int iP = dVar.p(this.f31767h);
        return (iP == 1 && Arrays.equals(iArr, f31705t5)) || (iP == 6 && Arrays.equals(iArr, iArr2));
    }

    public final void a() {
        String strI = i(f31644m0);
        if (strI != null && i(U) == null) {
            this.f31765f[0].put(U, d.h(strI));
        }
        if (i(f31733x) == null) {
            this.f31765f[0].put(f31733x, d.i(0L, this.f31767h));
        }
        if (i(f31742y) == null) {
            this.f31765f[0].put(f31742y, d.i(0L, this.f31767h));
        }
        if (i(C) == null) {
            this.f31765f[0].put(C, d.i(0L, this.f31767h));
        }
        if (i(O0) == null) {
            this.f31765f[1].put(O0, d.i(0L, this.f31767h));
        }
    }

    public final String b(double d10) {
        long j10 = (long) d10;
        double d11 = d10 - j10;
        long j11 = (long) (d11 * 60.0d);
        return j10 + "/1," + j11 + "/1," + Math.round((d11 - (j11 / 60.0d)) * 3600.0d * 1.0E7d) + "/10000000";
    }

    public final boolean b0(HashMap map) throws IOException {
        d dVar = (d) map.get(f31742y);
        d dVar2 = (d) map.get(f31733x);
        if (dVar == null || dVar2 == null) {
            return false;
        }
        return dVar.p(this.f31767h) <= 512 && dVar2.p(this.f31767h) <= 512;
    }

    public boolean c0() {
        if (!this.f31768i) {
            return false;
        }
        int i10 = this.f31774o;
        return i10 == 6 || i10 == 7;
    }

    public final void d(b bVar, c cVar, byte[] bArr, byte[] bArr2) throws IOException {
        String str;
        while (true) {
            byte[] bArr3 = new byte[4];
            if (bVar.read(bArr3) != 4) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Encountered invalid length while copying WebP chunks up tochunk type ");
                Charset charset = f31627j7;
                sb2.append(new String(bArr, charset));
                if (bArr2 == null) {
                    str = "";
                } else {
                    str = " or " + new String(bArr2, charset);
                }
                sb2.append(str);
                throw new IOException(sb2.toString());
            }
            e(bVar, cVar, bArr3);
            if (Arrays.equals(bArr3, bArr)) {
                return;
            }
            if (bArr2 != null && Arrays.equals(bArr3, bArr2)) {
                return;
            }
        }
    }

    public final boolean d0(byte[] bArr) throws IOException {
        int i10 = 0;
        while (true) {
            byte[] bArr2 = Y5;
            if (i10 >= bArr2.length) {
                int i11 = 0;
                while (true) {
                    byte[] bArr3 = Z5;
                    if (i11 >= bArr3.length) {
                        return true;
                    }
                    if (bArr[Y5.length + i11 + 4] != bArr3[i11]) {
                        return false;
                    }
                    i11++;
                }
            } else {
                if (bArr[i10] != bArr2[i10]) {
                    return false;
                }
                i10++;
            }
        }
    }

    public final void e(b bVar, c cVar, byte[] bArr) throws IOException {
        int i10 = bVar.readInt();
        cVar.write(bArr);
        cVar.d(i10);
        if (i10 % 2 == 1) {
            i10++;
        }
        i1.b.f(bVar, cVar, i10);
    }

    public final void e0(@n0 InputStream inputStream) {
        Objects.requireNonNull(inputStream, "inputstream shouldn't be null");
        for (int i10 = 0; i10 < f31579d7.length; i10++) {
            try {
                try {
                    this.f31765f[i10] = new HashMap<>();
                } catch (IOException | UnsupportedOperationException unused) {
                    boolean z10 = f31724w;
                    a();
                    if (!z10) {
                        return;
                    }
                }
            } finally {
                a();
                if (f31724w) {
                    h0();
                }
            }
        }
        if (!this.f31764e) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
            this.f31763d = w(bufferedInputStream);
            inputStream = bufferedInputStream;
        }
        if (A0(this.f31763d)) {
            i iVar = new i(inputStream);
            if (this.f31764e) {
                D(iVar);
            } else {
                int i11 = this.f31763d;
                if (i11 == 12) {
                    s(iVar);
                } else if (i11 == 7) {
                    x(iVar);
                } else if (i11 == 10) {
                    C(iVar);
                } else {
                    A(iVar);
                }
            }
            iVar.h(this.f31775p);
            z0(iVar);
        } else {
            b bVar = new b(inputStream);
            int i12 = this.f31763d;
            if (i12 == 4) {
                t(bVar, 0, 0);
            } else if (i12 == 13) {
                y(bVar);
            } else if (i12 == 9) {
                z(bVar);
            } else if (i12 == 14) {
                I(bVar);
            }
        }
    }

    public void f() {
        int i10 = 1;
        switch (l(C, 1)) {
            case 1:
                i10 = 2;
                break;
            case 2:
                break;
            case 3:
                i10 = 4;
                break;
            case 4:
                i10 = 3;
                break;
            case 5:
                i10 = 6;
                break;
            case 6:
                i10 = 5;
                break;
            case 7:
                i10 = 8;
                break;
            case 8:
                i10 = 7;
                break;
            default:
                i10 = 0;
                break;
        }
        v0(C, Integer.toString(i10));
    }

    public void g() {
        int i10 = 1;
        switch (l(C, 1)) {
            case 1:
                i10 = 4;
                break;
            case 2:
                i10 = 3;
                break;
            case 3:
                i10 = 2;
                break;
            case 4:
                break;
            case 5:
                i10 = 8;
                break;
            case 6:
                i10 = 7;
                break;
            case 7:
                i10 = 6;
                break;
            case 8:
                i10 = 5;
                break;
            default:
                i10 = 0;
                break;
        }
        v0(C, Integer.toString(i10));
    }

    public final void g0(b bVar) throws IOException {
        ByteOrder byteOrderI0 = i0(bVar);
        this.f31767h = byteOrderI0;
        bVar.d(byteOrderI0);
        int unsignedShort = bVar.readUnsignedShort();
        int i10 = this.f31763d;
        if (i10 != 7 && i10 != 10 && unsignedShort != 42) {
            throw new IOException("Invalid start code: " + Integer.toHexString(unsignedShort));
        }
        int i11 = bVar.readInt();
        if (i11 < 8) {
            throw new IOException("Invalid first Ifd offset: " + i11);
        }
        int i12 = i11 - 8;
        if (i12 > 0) {
            bVar.f(i12);
        }
    }

    public double h(double d10) {
        double dK = k(D1, -1.0d);
        int iL = l(C1, -1);
        if (dK < 0.0d || iL < 0) {
            return d10;
        }
        return dK * ((double) (iL != 1 ? 1 : -1));
    }

    public final void h0() {
        for (int i10 = 0; i10 < this.f31765f.length; i10++) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("The size of tag group[");
            sb2.append(i10);
            sb2.append("]: ");
            sb2.append(this.f31765f[i10].size());
            for (Map.Entry<String, d> entry : this.f31765f[i10].entrySet()) {
                d value = entry.getValue();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("tagName: ");
                sb3.append(entry.getKey());
                sb3.append(", tagType: ");
                sb3.append(value.toString());
                sb3.append(", tagValue: '");
                sb3.append(value.q(this.f31767h));
                sb3.append("'");
            }
        }
    }

    @p0
    public String i(@n0 String str) {
        Objects.requireNonNull(str, "tag shouldn't be null");
        d dVarQ = q(str);
        if (dVarQ != null) {
            if (!f31611h7.contains(str)) {
                return dVarQ.q(this.f31767h);
            }
            if (str.equals(E1)) {
                int i10 = dVarQ.f31793a;
                if (i10 != 5 && i10 != 10) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("GPS Timestamp format is not rational. format=");
                    sb2.append(dVarQ.f31793a);
                    return null;
                }
                h[] hVarArr = (h[]) dVarQ.r(this.f31767h);
                if (hVarArr != null && hVarArr.length == 3) {
                    return String.format("%02d:%02d:%02d", Integer.valueOf((int) (hVarArr[0].f31801a / hVarArr[0].f31802b)), Integer.valueOf((int) (hVarArr[1].f31801a / hVarArr[1].f31802b)), Integer.valueOf((int) (hVarArr[2].f31801a / hVarArr[2].f31802b)));
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Invalid GPS Timestamp array. array=");
                sb3.append(Arrays.toString(hVarArr));
                return null;
            }
            try {
                return Double.toString(dVarQ.o(this.f31767h));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public final ByteOrder i0(b bVar) throws IOException {
        short s10 = bVar.readShort();
        if (s10 == 18761) {
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (s10 == 19789) {
            return ByteOrder.BIG_ENDIAN;
        }
        throw new IOException("Invalid byte order: " + Integer.toHexString(s10));
    }

    @p0
    public byte[] j(@n0 String str) {
        Objects.requireNonNull(str, "tag shouldn't be null");
        d dVarQ = q(str);
        if (dVarQ != null) {
            return dVarQ.f31796d;
        }
        return null;
    }

    public final void j0(byte[] bArr, int i10) throws IOException {
        i iVar = new i(bArr);
        g0(iVar);
        k0(iVar, i10);
    }

    public double k(@n0 String str, double d10) {
        Objects.requireNonNull(str, "tag shouldn't be null");
        d dVarQ = q(str);
        if (dVarQ == null) {
            return d10;
        }
        try {
            return dVarQ.o(this.f31767h);
        } catch (NumberFormatException unused) {
            return d10;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0243  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k0(i1.a.i r24, int r25) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 834
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i1.a.k0(i1.a$i, int):void");
    }

    public int l(@n0 String str, int i10) {
        Objects.requireNonNull(str, "tag shouldn't be null");
        d dVarQ = q(str);
        if (dVarQ == null) {
            return i10;
        }
        try {
            return dVarQ.p(this.f31767h);
        } catch (NumberFormatException unused) {
            return i10;
        }
    }

    public final void l0(String str) {
        for (int i10 = 0; i10 < f31579d7.length; i10++) {
            this.f31765f[i10].remove(str);
        }
    }

    @p0
    public long[] m(@n0 String str) {
        Objects.requireNonNull(str, "tag shouldn't be null");
        if (this.f31779t) {
            throw new IllegalStateException("The underlying file has been modified since being parsed");
        }
        d dVarQ = q(str);
        if (dVarQ != null) {
            return new long[]{dVarQ.f31795c, dVarQ.f31796d.length};
        }
        return null;
    }

    public final void m0(int i10, String str, String str2) {
        if (this.f31765f[i10].isEmpty() || this.f31765f[i10].get(str) == null) {
            return;
        }
        HashMap[] mapArr = this.f31765f;
        mapArr[i10].put(str2, mapArr[i10].get(str));
        this.f31765f[i10].remove(str);
    }

    @p0
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Long n() {
        return f0(i(U), i(f31684r0), i(f31660o0));
    }

    public void n0() {
        v0(C, Integer.toString(1));
    }

    @p0
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Long o() {
        return f0(i(f31652n0), i(f31700t0), i(f31676q0));
    }

    public final void o0(i iVar, int i10) throws Throwable {
        d dVar = this.f31765f[i10].get(f31742y);
        d dVar2 = this.f31765f[i10].get(f31733x);
        if (dVar == null || dVar2 == null) {
            d dVar3 = this.f31765f[i10].get(N);
            d dVar4 = this.f31765f[i10].get(O);
            if (dVar3 == null || dVar4 == null) {
                return;
            }
            int iP = dVar3.p(this.f31767h);
            int iP2 = dVar3.p(this.f31767h);
            iVar.h(iP);
            byte[] bArr = new byte[iP2];
            iVar.read(bArr);
            t(new b(bArr), iP, i10);
        }
    }

    @p0
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Long p() {
        return f0(i(f31644m0), i(f31692s0), i(f31668p0));
    }

    public void p0(int i10) {
        if (i10 % 90 != 0) {
            throw new IllegalArgumentException("degree should be a multiple of 90");
        }
        int iL = l(C, 1);
        List<Integer> list = M2;
        if (list.contains(Integer.valueOf(iL))) {
            int iIndexOf = (list.indexOf(Integer.valueOf(iL)) + (i10 / 90)) % 4;
            iIntValue = list.get(iIndexOf + (iIndexOf < 0 ? 4 : 0)).intValue();
        } else {
            List<Integer> list2 = N2;
            if (list2.contains(Integer.valueOf(iL))) {
                int iIndexOf2 = (list2.indexOf(Integer.valueOf(iL)) + (i10 / 90)) % 4;
                iIntValue = list2.get(iIndexOf2 + (iIndexOf2 < 0 ? 4 : 0)).intValue();
            }
        }
        v0(C, Integer.toString(iIntValue));
    }

    @p0
    public final d q(@n0 String str) {
        Objects.requireNonNull(str, "tag shouldn't be null");
        if (f31743y0.equals(str)) {
            str = f31752z0;
        }
        for (int i10 = 0; i10 < f31579d7.length; i10++) {
            d dVar = this.f31765f[i10].get(str);
            if (dVar != null) {
                return dVar;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x00f4 A[Catch: all -> 0x011c, Exception -> 0x011f, TryCatch #17 {Exception -> 0x011f, all -> 0x011c, blocks: (B:66:0x00f0, B:68:0x00f4, B:70:0x010a, B:69:0x0103), top: B:130:0x00f0 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0103 A[Catch: all -> 0x011c, Exception -> 0x011f, TryCatch #17 {Exception -> 0x011f, all -> 0x011c, blocks: (B:66:0x00f0, B:68:0x00f4, B:70:0x010a, B:69:0x0103), top: B:130:0x00f0 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0156  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void q0() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 387
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i1.a.q0():void");
    }

    @p0
    @SuppressLint({"AutoBoxing"})
    public Long r() {
        String strI = i(f31550a2);
        String strI2 = i(E1);
        if (strI != null && strI2 != null) {
            Pattern pattern = U7;
            if (pattern.matcher(strI).matches() || pattern.matcher(strI2).matches()) {
                String str = strI + zc.f.f58383m + strI2;
                ParsePosition parsePosition = new ParsePosition(0);
                try {
                    Date date = f31650m6.parse(str, parsePosition);
                    if (date == null && (date = f31658n6.parse(str, parsePosition)) == null) {
                        return null;
                    }
                    return Long.valueOf(date.getTime());
                } catch (IllegalArgumentException unused) {
                }
            }
        }
        return null;
    }

    public final void r0(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (f31724w) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("saveJpegAttributes starting with (inputStream: ");
            sb2.append(inputStream);
            sb2.append(", outputStream: ");
            sb2.append(outputStream);
            sb2.append(ee.a.f26979d);
        }
        b bVar = new b(inputStream);
        c cVar = new c(outputStream, ByteOrder.BIG_ENDIAN);
        if (bVar.readByte() != -1) {
            throw new IOException("Invalid marker");
        }
        cVar.c(-1);
        if (bVar.readByte() != -40) {
            throw new IOException("Invalid marker");
        }
        cVar.c(-40);
        d dVarRemove = null;
        if (i(f31702t2) != null && this.f31780u) {
            dVarRemove = this.f31765f[0].remove(f31702t2);
        }
        cVar.c(-1);
        cVar.c(-31);
        E0(cVar);
        if (dVarRemove != null) {
            this.f31765f[0].put(f31702t2, dVarRemove);
        }
        byte[] bArr = new byte[4096];
        while (bVar.readByte() == -1) {
            byte b10 = bVar.readByte();
            if (b10 == -39 || b10 == -38) {
                cVar.c(-1);
                cVar.c(b10);
                i1.b.e(bVar, cVar);
                return;
            }
            if (b10 != -31) {
                cVar.c(-1);
                cVar.c(b10);
                int unsignedShort = bVar.readUnsignedShort();
                cVar.i(unsignedShort);
                int i10 = unsignedShort - 2;
                if (i10 < 0) {
                    throw new IOException("Invalid length");
                }
                while (i10 > 0) {
                    int i11 = bVar.read(bArr, 0, Math.min(i10, 4096));
                    if (i11 >= 0) {
                        cVar.write(bArr, 0, i11);
                        i10 -= i11;
                    }
                }
            } else {
                int unsignedShort2 = bVar.readUnsignedShort() - 2;
                if (unsignedShort2 < 0) {
                    throw new IOException("Invalid length");
                }
                byte[] bArr2 = new byte[6];
                if (unsignedShort2 >= 6) {
                    if (bVar.read(bArr2) != 6) {
                        throw new IOException("Invalid exif");
                    }
                    if (Arrays.equals(bArr2, f31635k7)) {
                        bVar.f(unsignedShort2 - 6);
                    }
                }
                cVar.c(-1);
                cVar.c(b10);
                cVar.i(unsignedShort2 + 2);
                if (unsignedShort2 >= 6) {
                    unsignedShort2 -= 6;
                    cVar.write(bArr2);
                }
                while (unsignedShort2 > 0) {
                    int i12 = bVar.read(bArr, 0, Math.min(unsignedShort2, 4096));
                    if (i12 >= 0) {
                        cVar.write(bArr, 0, i12);
                        unsignedShort2 -= i12;
                    }
                }
            }
        }
        throw new IOException("Invalid marker");
    }

    public final void s(i iVar) throws IOException {
        String strExtractMetadata;
        String strExtractMetadata2;
        if (Build.VERSION.SDK_INT < 28) {
            throw new UnsupportedOperationException("Reading EXIF from HEIF files is supported from SDK 28 and above");
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                b.C0376b.a(mediaMetadataRetriever, new C0375a(iVar));
                String strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(33);
                String strExtractMetadata4 = mediaMetadataRetriever.extractMetadata(34);
                String strExtractMetadata5 = mediaMetadataRetriever.extractMetadata(26);
                String strExtractMetadata6 = mediaMetadataRetriever.extractMetadata(17);
                String strExtractMetadata7 = null;
                if ("yes".equals(strExtractMetadata5)) {
                    strExtractMetadata7 = mediaMetadataRetriever.extractMetadata(29);
                    strExtractMetadata = mediaMetadataRetriever.extractMetadata(30);
                    strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(31);
                } else if ("yes".equals(strExtractMetadata6)) {
                    strExtractMetadata7 = mediaMetadataRetriever.extractMetadata(18);
                    strExtractMetadata = mediaMetadataRetriever.extractMetadata(19);
                    strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(24);
                } else {
                    strExtractMetadata = null;
                    strExtractMetadata2 = null;
                }
                if (strExtractMetadata7 != null) {
                    this.f31765f[0].put(f31733x, d.m(Integer.parseInt(strExtractMetadata7), this.f31767h));
                }
                if (strExtractMetadata != null) {
                    this.f31765f[0].put(f31742y, d.m(Integer.parseInt(strExtractMetadata), this.f31767h));
                }
                if (strExtractMetadata2 != null) {
                    int i10 = 1;
                    int i11 = Integer.parseInt(strExtractMetadata2);
                    if (i11 == 90) {
                        i10 = 6;
                    } else if (i11 == 180) {
                        i10 = 3;
                    } else if (i11 == 270) {
                        i10 = 8;
                    }
                    this.f31765f[0].put(C, d.m(i10, this.f31767h));
                }
                if (strExtractMetadata3 != null && strExtractMetadata4 != null) {
                    int i12 = Integer.parseInt(strExtractMetadata3);
                    int i13 = Integer.parseInt(strExtractMetadata4);
                    if (i13 <= 6) {
                        throw new IOException("Invalid exif length");
                    }
                    iVar.h(i12);
                    byte[] bArr = new byte[6];
                    if (iVar.read(bArr) != 6) {
                        throw new IOException("Can't read identifier");
                    }
                    int i14 = i12 + 6;
                    int i15 = i13 - 6;
                    if (!Arrays.equals(bArr, f31635k7)) {
                        throw new IOException("Invalid identifier");
                    }
                    byte[] bArr2 = new byte[i15];
                    if (iVar.read(bArr2) != i15) {
                        throw new IOException("Can't read exif");
                    }
                    this.f31775p = i14;
                    j0(bArr2, 0);
                }
                if (f31724w) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Heif meta: ");
                    sb2.append(strExtractMetadata7);
                    sb2.append("x");
                    sb2.append(strExtractMetadata);
                    sb2.append(", rotation ");
                    sb2.append(strExtractMetadata2);
                }
            } catch (RuntimeException unused) {
                throw new UnsupportedOperationException("Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported.");
            }
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    public final void s0(InputStream inputStream, OutputStream outputStream) throws Throwable {
        if (f31724w) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("savePngAttributes starting with (inputStream: ");
            sb2.append(inputStream);
            sb2.append(", outputStream: ");
            sb2.append(outputStream);
            sb2.append(ee.a.f26979d);
        }
        b bVar = new b(inputStream);
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        c cVar = new c(outputStream, byteOrder);
        byte[] bArr = S5;
        i1.b.f(bVar, cVar, bArr.length);
        int i10 = this.f31775p;
        if (i10 == 0) {
            int i11 = bVar.readInt();
            cVar.d(i11);
            i1.b.f(bVar, cVar, i11 + 4 + 4);
        } else {
            i1.b.f(bVar, cVar, ((i10 - bArr.length) - 4) - 4);
            bVar.f(bVar.readInt() + 4 + 4);
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                c cVar2 = new c(byteArrayOutputStream2, byteOrder);
                E0(cVar2);
                byte[] byteArray = ((ByteArrayOutputStream) cVar2.f31790a).toByteArray();
                cVar.write(byteArray);
                CRC32 crc32 = new CRC32();
                crc32.update(byteArray, 4, byteArray.length - 4);
                cVar.d((int) crc32.getValue());
                i1.b.c(byteArrayOutputStream2);
                i1.b.e(bVar, cVar);
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = byteArrayOutputStream2;
                i1.b.c(byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00a1 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0162 A[LOOP:0: B:10:0x002f->B:61:0x0162, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x016a A[SYNTHETIC] */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1092)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t(i1.a.b r20, int r21, int r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 506
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i1.a.t(i1.a$b, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x01a2 A[Catch: all -> 0x01e4, Exception -> 0x01e7, TryCatch #4 {Exception -> 0x01e7, all -> 0x01e4, blocks: (B:7:0x0044, B:9:0x004d, B:63:0x01c4, B:10:0x0066, B:12:0x006e, B:14:0x007a, B:16:0x0082, B:18:0x0086, B:22:0x0099, B:24:0x00a4, B:25:0x00a9, B:27:0x00b6, B:28:0x00bb, B:29:0x00bf, B:30:0x00cb, B:32:0x00d3, B:34:0x00db, B:36:0x00e3, B:38:0x00e7, B:40:0x00f2, B:42:0x00fd, B:44:0x0105, B:56:0x0150, B:58:0x01a2, B:62:0x01be, B:59:0x01ae, B:61:0x01b6, B:45:0x0114, B:46:0x011b, B:47:0x011c, B:49:0x0124, B:51:0x012a, B:52:0x0143, B:53:0x014a, B:66:0x01dc, B:67:0x01e3), top: B:82:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01ae A[Catch: all -> 0x01e4, Exception -> 0x01e7, TryCatch #4 {Exception -> 0x01e7, all -> 0x01e4, blocks: (B:7:0x0044, B:9:0x004d, B:63:0x01c4, B:10:0x0066, B:12:0x006e, B:14:0x007a, B:16:0x0082, B:18:0x0086, B:22:0x0099, B:24:0x00a4, B:25:0x00a9, B:27:0x00b6, B:28:0x00bb, B:29:0x00bf, B:30:0x00cb, B:32:0x00d3, B:34:0x00db, B:36:0x00e3, B:38:0x00e7, B:40:0x00f2, B:42:0x00fd, B:44:0x0105, B:56:0x0150, B:58:0x01a2, B:62:0x01be, B:59:0x01ae, B:61:0x01b6, B:45:0x0114, B:46:0x011b, B:47:0x011c, B:49:0x0124, B:51:0x012a, B:52:0x0143, B:53:0x014a, B:66:0x01dc, B:67:0x01e3), top: B:82:0x0044 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t0(java.io.InputStream r21, java.io.OutputStream r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 505
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i1.a.t0(java.io.InputStream, java.io.OutputStream):void");
    }

    @Deprecated
    public boolean u(float[] fArr) {
        double[] dArrV = v();
        if (dArrV == null) {
            return false;
        }
        fArr[0] = (float) dArrV[0];
        fArr[1] = (float) dArrV[1];
        return true;
    }

    public void u0(double d10) {
        String str = d10 >= 0.0d ? "0" : "1";
        v0(D1, new h(Math.abs(d10)).toString());
        v0(C1, str);
    }

    @p0
    public double[] v() {
        String strI = i(f31753z1);
        String strI2 = i(f31744y1);
        String strI3 = i(B1);
        String strI4 = i(A1);
        if (strI == null || strI2 == null || strI3 == null || strI4 == null) {
            return null;
        }
        try {
            return new double[]{c(strI, strI2), c(strI3, strI4)};
        } catch (IllegalArgumentException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Latitude/longitude values are not parsable. ");
            sb2.append(String.format("latValue=%s, latRef=%s, lngValue=%s, lngRef=%s", strI, strI2, strI3, strI4));
            return null;
        }
    }

    public void v0(@n0 String str, @p0 String str2) {
        f fVar;
        int i10;
        String str3 = str;
        String strReplaceAll = str2;
        Objects.requireNonNull(str3, "tag shouldn't be null");
        if ((U.equals(str3) || f31644m0.equals(str3) || f31652n0.equals(str3)) && strReplaceAll != null) {
            boolean zFind = W7.matcher(strReplaceAll).find();
            boolean zFind2 = X7.matcher(strReplaceAll).find();
            if (str2.length() != 19 || (!zFind && !zFind2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Invalid value for ");
                sb2.append(str3);
                sb2.append(" : ");
                sb2.append(strReplaceAll);
                return;
            }
            if (zFind2) {
                strReplaceAll = strReplaceAll.replaceAll("-", ":");
            }
        }
        if (f31743y0.equals(str3)) {
            str3 = f31752z0;
        }
        int i11 = 2;
        int i12 = 1;
        if (strReplaceAll != null && f31611h7.contains(str3)) {
            if (str3.equals(E1)) {
                Matcher matcher = V7.matcher(strReplaceAll);
                if (!matcher.find()) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Invalid value for ");
                    sb3.append(str3);
                    sb3.append(" : ");
                    sb3.append(strReplaceAll);
                    return;
                }
                strReplaceAll = Integer.parseInt(matcher.group(1)) + "/1," + Integer.parseInt(matcher.group(2)) + "/1," + Integer.parseInt(matcher.group(3)) + "/1";
            } else {
                try {
                    strReplaceAll = new h(Double.parseDouble(strReplaceAll)).toString();
                } catch (NumberFormatException unused) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Invalid value for ");
                    sb4.append(str3);
                    sb4.append(" : ");
                    sb4.append(strReplaceAll);
                    return;
                }
            }
        }
        char c10 = 0;
        int i13 = 0;
        while (i13 < f31579d7.length) {
            if ((i13 != 4 || this.f31768i) && (fVar = f31603g7[i13].get(str3)) != null) {
                if (strReplaceAll != null) {
                    Pair<Integer, Integer> pairJ = J(strReplaceAll);
                    if (fVar.f31799c == ((Integer) pairJ.first).intValue() || fVar.f31799c == ((Integer) pairJ.second).intValue()) {
                        i10 = fVar.f31799c;
                    } else {
                        int i14 = fVar.f31800d;
                        if (i14 == -1 || !(i14 == ((Integer) pairJ.first).intValue() || fVar.f31800d == ((Integer) pairJ.second).intValue())) {
                            int i15 = fVar.f31799c;
                            if (i15 == i12 || i15 == 7 || i15 == i11) {
                                i10 = i15;
                            } else if (f31724w) {
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("Given tag (");
                                sb5.append(str3);
                                sb5.append(") value didn't match with one of expected formats: ");
                                String[] strArr = G6;
                                sb5.append(strArr[fVar.f31799c]);
                                sb5.append(fVar.f31800d == -1 ? "" : ", " + strArr[fVar.f31800d]);
                                sb5.append(" (guess: ");
                                sb5.append(strArr[((Integer) pairJ.first).intValue()]);
                                sb5.append(((Integer) pairJ.second).intValue() != -1 ? ", " + strArr[((Integer) pairJ.second).intValue()] : "");
                                sb5.append(ee.a.f26979d);
                            }
                        } else {
                            i10 = fVar.f31800d;
                        }
                    }
                    switch (i10) {
                        case 1:
                            this.f31765f[i13].put(str3, d.a(strReplaceAll));
                            continue;
                        case 2:
                        case 7:
                            this.f31765f[i13].put(str3, d.h(strReplaceAll));
                            continue;
                        case 3:
                            String[] strArrSplit = strReplaceAll.split(ag.c.f654g, -1);
                            int[] iArr = new int[strArrSplit.length];
                            for (int i16 = 0; i16 < strArrSplit.length; i16++) {
                                iArr[i16] = Integer.parseInt(strArrSplit[i16]);
                            }
                            this.f31765f[i13].put(str3, d.n(iArr, this.f31767h));
                            continue;
                        case 4:
                            String[] strArrSplit2 = strReplaceAll.split(ag.c.f654g, -1);
                            long[] jArr = new long[strArrSplit2.length];
                            for (int i17 = 0; i17 < strArrSplit2.length; i17++) {
                                jArr[i17] = Long.parseLong(strArrSplit2[i17]);
                            }
                            this.f31765f[i13].put(str3, d.j(jArr, this.f31767h));
                            continue;
                        case 5:
                            String[] strArrSplit3 = strReplaceAll.split(ag.c.f654g, -1);
                            h[] hVarArr = new h[strArrSplit3.length];
                            int i18 = 0;
                            while (i18 < strArrSplit3.length) {
                                String[] strArrSplit4 = strArrSplit3[i18].split(fh.a.f28350w, -1);
                                hVarArr[i18] = new h((long) Double.parseDouble(strArrSplit4[c10]), (long) Double.parseDouble(strArrSplit4[1]));
                                i18++;
                                c10 = 0;
                            }
                            this.f31765f[i13].put(str3, d.l(hVarArr, this.f31767h));
                            continue;
                        case 6:
                        case 8:
                        case 11:
                        default:
                            if (f31724w) {
                                StringBuilder sb6 = new StringBuilder();
                                sb6.append("Data format isn't one of expected formats: ");
                                sb6.append(i10);
                            } else {
                                continue;
                            }
                            break;
                        case 9:
                            String[] strArrSplit5 = strReplaceAll.split(ag.c.f654g, -1);
                            int[] iArr2 = new int[strArrSplit5.length];
                            for (int i19 = 0; i19 < strArrSplit5.length; i19++) {
                                iArr2[i19] = Integer.parseInt(strArrSplit5[i19]);
                            }
                            this.f31765f[i13].put(str3, d.e(iArr2, this.f31767h));
                            break;
                        case 10:
                            String[] strArrSplit6 = strReplaceAll.split(ag.c.f654g, -1);
                            h[] hVarArr2 = new h[strArrSplit6.length];
                            int i20 = 0;
                            while (i20 < strArrSplit6.length) {
                                String[] strArrSplit7 = strArrSplit6[i20].split(fh.a.f28350w, -1);
                                hVarArr2[i20] = new h((long) Double.parseDouble(strArrSplit7[c10]), (long) Double.parseDouble(strArrSplit7[i12]));
                                i20++;
                                strArrSplit6 = strArrSplit6;
                                i12 = 1;
                            }
                            this.f31765f[i13].put(str3, d.g(hVarArr2, this.f31767h));
                            break;
                        case 12:
                            String[] strArrSplit8 = strReplaceAll.split(ag.c.f654g, -1);
                            double[] dArr = new double[strArrSplit8.length];
                            for (int i21 = 0; i21 < strArrSplit8.length; i21++) {
                                dArr[i21] = Double.parseDouble(strArrSplit8[i21]);
                            }
                            this.f31765f[i13].put(str3, d.c(dArr, this.f31767h));
                            break;
                    }
                } else {
                    this.f31765f[i13].remove(str3);
                }
            }
            i13++;
            i11 = 2;
            c10 = 0;
            i12 = 1;
        }
    }

    public final int w(BufferedInputStream bufferedInputStream) throws IOException {
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        if (S(bArr)) {
            return 4;
        }
        if (V(bArr)) {
            return 9;
        }
        if (R(bArr)) {
            return 12;
        }
        if (T(bArr)) {
            return 7;
        }
        if (W(bArr)) {
            return 10;
        }
        if (U(bArr)) {
            return 13;
        }
        return d0(bArr) ? 14 : 0;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void w0(@n0 Long l10) {
        Objects.requireNonNull(l10, "Timestamp should not be null.");
        if (l10.longValue() < 0) {
            throw new IllegalArgumentException("Timestamp should a positive value.");
        }
        String string = Long.toString(l10.longValue() % 1000);
        for (int length = string.length(); length < 3; length++) {
            string = "0" + string;
        }
        v0(U, f31650m6.format(new Date(l10.longValue())));
        v0(f31684r0, string);
    }

    public final void x(i iVar) throws Throwable {
        A(iVar);
        d dVar = this.f31765f[1].get(f31620j0);
        if (dVar != null) {
            i iVar2 = new i(dVar.f31796d);
            iVar2.d(this.f31767h);
            byte[] bArr = L5;
            byte[] bArr2 = new byte[bArr.length];
            iVar2.readFully(bArr2);
            iVar2.h(0L);
            byte[] bArr3 = M5;
            byte[] bArr4 = new byte[bArr3.length];
            iVar2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                iVar2.h(8L);
            } else if (Arrays.equals(bArr4, bArr3)) {
                iVar2.h(12L);
            }
            k0(iVar2, 6);
            d dVar2 = this.f31765f[7].get(f31630k2);
            d dVar3 = this.f31765f[7].get(f31638l2);
            if (dVar2 != null && dVar3 != null) {
                this.f31765f[5].put(N, dVar2);
                this.f31765f[5].put(O, dVar3);
            }
            d dVar4 = this.f31765f[8].get(f31646m2);
            if (dVar4 != null) {
                int[] iArr = (int[]) dVar4.r(this.f31767h);
                if (iArr == null || iArr.length != 4) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Invalid aspect frame values. frame=");
                    sb2.append(Arrays.toString(iArr));
                } else {
                    if (iArr[2] <= iArr[0] || iArr[3] <= iArr[1]) {
                        return;
                    }
                    int i10 = (iArr[2] - iArr[0]) + 1;
                    int i11 = (iArr[3] - iArr[1]) + 1;
                    if (i10 < i11) {
                        int i12 = i10 + i11;
                        i11 = i12 - i11;
                        i10 = i12 - i11;
                    }
                    d dVarM = d.m(i10, this.f31767h);
                    d dVarM2 = d.m(i11, this.f31767h);
                    this.f31765f[0].put(f31733x, dVarM);
                    this.f31765f[0].put(f31742y, dVarM2);
                }
            }
        }
    }

    public void x0(Location location) {
        if (location == null) {
            return;
        }
        v0(Y1, location.getProvider());
        y0(location.getLatitude(), location.getLongitude());
        u0(location.getAltitude());
        v0(J1, "K");
        v0(K1, new h((location.getSpeed() * TimeUnit.HOURS.toSeconds(1L)) / 1000.0f).toString());
        String[] strArrSplit = f31650m6.format(new Date(location.getTime())).split("\\s+", -1);
        v0(f31550a2, strArrSplit[0]);
        v0(E1, strArrSplit[1]);
    }

    public final void y(b bVar) throws Throwable {
        if (f31724w) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getPngAttributes starting with: ");
            sb2.append(bVar);
        }
        bVar.d(ByteOrder.BIG_ENDIAN);
        byte[] bArr = S5;
        bVar.f(bArr.length);
        int length = bArr.length + 0;
        while (true) {
            try {
                int i10 = bVar.readInt();
                int i11 = length + 4;
                byte[] bArr2 = new byte[4];
                if (bVar.read(bArr2) != 4) {
                    throw new IOException("Encountered invalid length while parsing PNG chunktype");
                }
                int i12 = i11 + 4;
                if (i12 == 16 && !Arrays.equals(bArr2, U5)) {
                    throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                }
                if (Arrays.equals(bArr2, V5)) {
                    return;
                }
                if (Arrays.equals(bArr2, T5)) {
                    byte[] bArr3 = new byte[i10];
                    if (bVar.read(bArr3) != i10) {
                        throw new IOException("Failed to read given length for given PNG chunk type: " + i1.b.a(bArr2));
                    }
                    int i13 = bVar.readInt();
                    CRC32 crc32 = new CRC32();
                    crc32.update(bArr2);
                    crc32.update(bArr3);
                    if (((int) crc32.getValue()) == i13) {
                        this.f31775p = i12;
                        j0(bArr3, 0);
                        D0();
                        z0(new b(bArr3));
                        return;
                    }
                    throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + i13 + ", calculated CRC value: " + crc32.getValue());
                }
                int i14 = i10 + 4;
                bVar.f(i14);
                length = i12 + i14;
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt PNG file.");
            }
        }
    }

    public void y0(double d10, double d11) {
        if (d10 < -90.0d || d10 > 90.0d || Double.isNaN(d10)) {
            throw new IllegalArgumentException("Latitude value " + d10 + " is not valid.");
        }
        if (d11 < -180.0d || d11 > 180.0d || Double.isNaN(d11)) {
            throw new IllegalArgumentException("Longitude value " + d11 + " is not valid.");
        }
        v0(f31744y1, d10 >= 0.0d ? "N" : R4);
        v0(f31753z1, b(Math.abs(d10)));
        v0(A1, d11 >= 0.0d ? S4 : T4);
        v0(B1, b(Math.abs(d11)));
    }

    public final void z(b bVar) throws Throwable {
        boolean z10 = f31724w;
        if (z10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getRafAttributes starting with: ");
            sb2.append(bVar);
        }
        bVar.f(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        bVar.read(bArr);
        bVar.read(bArr2);
        bVar.read(bArr3);
        int i10 = ByteBuffer.wrap(bArr).getInt();
        int i11 = ByteBuffer.wrap(bArr2).getInt();
        int i12 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i11];
        bVar.f(i10 - bVar.a());
        bVar.read(bArr4);
        t(new b(bArr4), i10, 5);
        bVar.f(i12 - bVar.a());
        bVar.d(ByteOrder.BIG_ENDIAN);
        int i13 = bVar.readInt();
        if (z10) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("numberOfDirectoryEntry: ");
            sb3.append(i13);
        }
        for (int i14 = 0; i14 < i13; i14++) {
            int unsignedShort = bVar.readUnsignedShort();
            int unsignedShort2 = bVar.readUnsignedShort();
            if (unsignedShort == O6.f31797a) {
                short s10 = bVar.readShort();
                short s11 = bVar.readShort();
                d dVarM = d.m(s10, this.f31767h);
                d dVarM2 = d.m(s11, this.f31767h);
                this.f31765f[0].put(f31742y, dVarM);
                this.f31765f[0].put(f31733x, dVarM2);
                if (f31724w) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Updated to length: ");
                    sb4.append((int) s10);
                    sb4.append(", width: ");
                    sb4.append((int) s11);
                    return;
                }
                return;
            }
            bVar.f(unsignedShort2);
        }
    }

    public final void z0(b bVar) throws Throwable {
        HashMap<String, d> map = this.f31765f[4];
        d dVar = map.get(A);
        if (dVar == null) {
            this.f31774o = 6;
            K(bVar, map);
            return;
        }
        int iP = dVar.p(this.f31767h);
        this.f31774o = iP;
        if (iP != 1) {
            if (iP == 6) {
                K(bVar, map);
                return;
            } else if (iP != 7) {
                return;
            }
        }
        if (Y(map)) {
            L(bVar, map);
        }
    }

    public static class i extends b {
        public i(byte[] bArr) throws IOException {
            super(bArr);
            this.f31786a.mark(Integer.MAX_VALUE);
        }

        public void h(long j10) throws IOException {
            int i10 = this.f31788c;
            if (i10 > j10) {
                this.f31788c = 0;
                this.f31786a.reset();
            } else {
                j10 -= (long) i10;
            }
            f((int) j10);
        }

        public i(InputStream inputStream) throws IOException {
            super(inputStream);
            if (inputStream.markSupported()) {
                this.f31786a.mark(Integer.MAX_VALUE);
                return;
            }
            throw new IllegalArgumentException("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f31797a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f31798b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f31799c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f31800d;

        public f(String str, int i10, int i11) {
            this.f31798b = str;
            this.f31797a = i10;
            this.f31799c = i11;
            this.f31800d = -1;
        }

        public boolean a(int i10) {
            int i11;
            int i12 = this.f31799c;
            if (i12 == 7 || i10 == 7 || i12 == i10 || (i11 = this.f31800d) == i10) {
                return true;
            }
            if ((i12 == 4 || i11 == 4) && i10 == 3) {
                return true;
            }
            if ((i12 == 9 || i11 == 9) && i10 == 8) {
                return true;
            }
            return (i12 == 12 || i11 == 12) && i10 == 11;
        }

        public f(String str, int i10, int i11, int i12) {
            this.f31798b = str;
            this.f31797a = i10;
            this.f31799c = i11;
            this.f31800d = i12;
        }
    }

    public a(@n0 String str) throws Throwable {
        f[][] fVarArr = f31579d7;
        this.f31765f = new HashMap[fVarArr.length];
        this.f31766g = new HashSet(fVarArr.length);
        this.f31767h = ByteOrder.BIG_ENDIAN;
        Objects.requireNonNull(str, "filename cannot be null");
        O(str);
    }

    public a(@n0 FileDescriptor fileDescriptor) throws Throwable {
        FileInputStream fileInputStream;
        Throwable th2;
        f[][] fVarArr = f31579d7;
        this.f31765f = new HashMap[fVarArr.length];
        this.f31766g = new HashSet(fVarArr.length);
        this.f31767h = ByteOrder.BIG_ENDIAN;
        Objects.requireNonNull(fileDescriptor, "fileDescriptor cannot be null");
        this.f31762c = null;
        this.f31760a = null;
        boolean z10 = false;
        if (X(fileDescriptor)) {
            this.f31761b = fileDescriptor;
            try {
                fileDescriptor = b.a.b(fileDescriptor);
                z10 = true;
            } catch (Exception e10) {
                throw new IOException("Failed to duplicate file descriptor", e10);
            }
        } else {
            this.f31761b = null;
        }
        try {
            fileInputStream = new FileInputStream(fileDescriptor);
            try {
                e0(fileInputStream);
                i1.b.c(fileInputStream);
                if (z10) {
                    i1.b.b(fileDescriptor);
                }
            } catch (Throwable th3) {
                th2 = th3;
                i1.b.c(fileInputStream);
                if (z10) {
                    i1.b.b(fileDescriptor);
                }
                throw th2;
            }
        } catch (Throwable th4) {
            fileInputStream = null;
            th2 = th4;
        }
    }

    public a(@n0 InputStream inputStream) throws IOException {
        this(inputStream, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public a(@g.n0 java.io.InputStream r4, int r5) throws java.io.IOException {
        /*
            r3 = this;
            r3.<init>()
            i1.a$f[][] r0 = i1.a.f31579d7
            int r1 = r0.length
            java.util.HashMap[] r1 = new java.util.HashMap[r1]
            r3.f31765f = r1
            java.util.HashSet r1 = new java.util.HashSet
            int r0 = r0.length
            r1.<init>(r0)
            r3.f31766g = r1
            java.nio.ByteOrder r0 = java.nio.ByteOrder.BIG_ENDIAN
            r3.f31767h = r0
            java.lang.String r0 = "inputStream cannot be null"
            java.util.Objects.requireNonNull(r4, r0)
            r0 = 0
            r3.f31760a = r0
            r1 = 1
            if (r5 != r1) goto L23
            r5 = 1
            goto L24
        L23:
            r5 = 0
        L24:
            if (r5 == 0) goto L3d
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream
            byte[] r2 = i1.a.f31635k7
            int r2 = r2.length
            r5.<init>(r4, r2)
            boolean r4 = P(r5)
            if (r4 != 0) goto L35
            return
        L35:
            r3.f31764e = r1
            r3.f31762c = r0
            r3.f31761b = r0
            r4 = r5
            goto L67
        L3d:
            boolean r5 = r4 instanceof android.content.res.AssetManager.AssetInputStream
            if (r5 == 0) goto L49
            r5 = r4
            android.content.res.AssetManager$AssetInputStream r5 = (android.content.res.AssetManager.AssetInputStream) r5
            r3.f31762c = r5
            r3.f31761b = r0
            goto L67
        L49:
            boolean r5 = r4 instanceof java.io.FileInputStream
            if (r5 == 0) goto L63
            r5 = r4
            java.io.FileInputStream r5 = (java.io.FileInputStream) r5
            java.io.FileDescriptor r1 = r5.getFD()
            boolean r1 = X(r1)
            if (r1 == 0) goto L63
            r3.f31762c = r0
            java.io.FileDescriptor r5 = r5.getFD()
            r3.f31761b = r5
            goto L67
        L63:
            r3.f31762c = r0
            r3.f31761b = r0
        L67:
            r3.e0(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i1.a.<init>(java.io.InputStream, int):void");
    }
}
