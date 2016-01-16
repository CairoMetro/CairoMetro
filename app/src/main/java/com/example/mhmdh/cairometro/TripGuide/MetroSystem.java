package com.example.mhmdh.cairometro.TripGuide;

import android.location.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mhmdh on 1/16/2016.
 */
public class MetroSystem {
    private static MetroSystem instance;
    public static ConverterStation AL_SADAT1 = new ConverterStation("السادات", 30.044774, 31.235601);
    public static ConverterStation AL_SADAT = new ConverterStation("السادات", 30.044774, 31.235601);
    public static ConverterStation AL_SHOHADA = new ConverterStation("الشهداء", 30.061071, 31.246051);
    public static ConverterStation AL_SHOHADA1 = new ConverterStation("الشهداء", 30.061071, 31.246051);
    public static ConverterStation AL_ATBA = new ConverterStation("العتبة", 30.05498, 31.2470050);
    public static ConverterStation AL_ATBA1 = new ConverterStation("العتبة", 30.05498, 31.2470050);

    public static Station[] MARG_HELWAN_ARR = {new Station("حلوان", 29.848982, 31.334231),
            new Station("عين حلوان", 29.862609, 31.324875),
            new Station("جامعة حلوان", 29.869475, 31.320058),
            new Station("وادي حوف", 29.879021, 31.313433),
            new Station("حدائق حلوان", 29.897141, 31.304002),
            new Station("المعصرة", 29.906344, 31.299555),
            new Station("طرة الأسمنت", 29.925965, 31.287544),
            new Station("كوتسيكا", 29.936421, 31.281402),
            new Station("طرةال بلد", 29.946763, 31.272980),
            new Station("ثكنات المعادي", 29.953322, 31.262970),
            new Station("المعادي", 29.960289, 31.257729),
            new Station("حدائق المعادي", 29.969797, 31.250862),
            new Station("دار السلام", 29.981991, 31.242054),
            new Station("الزهراء", 29.995483, 31.231159),
            new Station("مارجرجس", 30.006192, 31.229485),
            new Station("الملك الصالح", 30.017744, 31.231068),
            new Station("السيدة زينب", 30.029295, 31.235322),
            new Station("سعد زغلول", 30.035690, 31.237607),
            AL_SADAT,
            new Station("جمال عبد الناصر", 30.053424, 31.238723),
            new Station("أحمد عرابي", 30.056976, 31.242371),
            AL_SHOHADA,
            new Station("غمرة", 30.069029, 31.264617),
            new Station("الدمرداش", 30.077264, 31.277786),
            new Station("منشية الصدر", 30.082032, 31.287480),
            new Station("كوبري القبة", 30.087212, 31.294127),
            new Station("حمامات القبة", 30.091255, 31.298901),
            new Station("سراي القبة", 30.097715, 31.304480),
            new Station("حدائق الزيتون", 30.105930, 31.310450),
            new Station("حلمية الزيتون", 30.113262, 31.313953),
            new Station("المطرية", 30.120909, 31.313712),
            new Station("عين شمس", 30.131056, 31.318991),
            new Station("عزبة النخل", 30.139393, 31.324344),
            new Station("المرج", 30.152146, 31.335561),
            new Station("المرج الجديدة", 30.163686, 31.338340)};

    public static Station[] SHOBRA_GIZA_STATIONS = {
            new Station("المنيب", 0, 0),
            new Station("ساقية مكي", 29.995576, 31.208510),
            new Station("ضواحي الجيزة", 30.005495, 31.207829),
            new Station("محطة الجيزة", 30.010628, 31.207051),
            new Station("فيصل", 30.017438, 31.203758),
            new Station("جامعة القاهرة", 30.026077, 31.200952),
            new Station("البحوث", 30.035867, 31.200131),
            new Station("الدقي", 30.038440, 31.212228),
            new Station("الأوبرا", 30.041857, 31.225070),
            AL_SADAT1,
            new Station("محمد نجيب", 30.045322, 31.244162),
            AL_ATBA,
            AL_SHOHADA1,
            new Station("مسرة", 30.070895, 31.245101),
            new Station("روض الفرج", 30.080588, 31.245407),
            new Station("سانت تريزا", 30.087959, 31.245503),
            new Station("الخلفاوي", 30.097836, 31.245010),
            new Station("المظلات", 30.104064, 31.245589),
            new Station("كلية الزراعة", 30.113666, 31.248754),
            new Station("شبرا الخيمة", 30.122510, 31.244693)
    };

    public static Station[] THIRD_LINE_STATIONS = {
            new Station("الأهرام", 30.073848, 31.325111),
            new Station("كلية البنات", 30.067423, 31.325026),
            new Station("الأستاد", 30.068537, 31.311893),
            new Station("أرض المعارض", 30.073314, 31.301486),
            new Station("العباسية ", 30.07771, 31.283226),
            new Station("عبده باشا", 30.06954, 31.27533),
            new Station("الجيش", 30.065826, 31.26709),
            new Station("باب الشعرية", 30.058694, 31.25679),
            AL_ATBA1
    };

    static int[] marg = {18, 21};
    static int[] shobra = {9, 11, 12};
    static int[] embaba = {8};
    public static MetroLine[] metroLines = {new MetroLine(MARG_HELWAN_ARR, marg),
            new MetroLine(SHOBRA_GIZA_STATIONS, shobra),
            new MetroLine(THIRD_LINE_STATIONS, embaba)};

    private MetroSystem() {


        AL_SADAT.otherLine = metroLines[1];
        AL_SADAT1.otherLine = metroLines[0];
        AL_SHOHADA.otherLine = metroLines[1];
        AL_SHOHADA1.otherLine = metroLines[0];
        AL_ATBA.otherLine = metroLines[2];
        AL_ATBA1.otherLine = metroLines[1];
        for (int i = 0; i < metroLines.length; i++) {
            for (int j = 0; j < metroLines[i].stations.length; j++)
                metroLines[i].stations[j].index = j;
        }

    }

    public static MetroSystem getInstance() {
        if (instance == null) instance = new MetroSystem();
        return instance;
    }

    List<Station[]> getShorter(List<Station[]> s1, List<Station[]> s2, int toS1, int toS2) {
        if (s1 == null)
            return s2;
        if (s2 == null)
            return s1;
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < s1.size(); i++) {
            if (s1.get(i) == null)
                return s2;
            if (s2.get(i) == null)
                return s1;

            sum1 += s1.get(i).length;
            sum2 += s2.get(i).length;
        }
        if (sum1 + toS1 < sum2 + toS2)
            return s1;
        else return s2;
    }

    public List<Station[]> metroPath(String srcName, String desName) {
        Station src = null;//, des = null;
        MetroLine srcLine = null;//, desLine = null;
        String srcFiltered = filter(srcName);
        String desFiltered = filter(desName);

        for (int i = 0; i < metroLines.length; i++) {
            for (int j = 0; j < metroLines[i].stations.length; j++) {
                if (filter(metroLines[i].stations[j].name).equals(srcFiltered)) {
                    src = metroLines[i].stations[j];
                    srcLine = metroLines[i];
                }
            }
        }

        return getPath(src, srcLine, srcLine, desFiltered);
    }

    List<Station[]> getPath(Station curStation, MetroLine virtualCurML, MetroLine curML, String desStation) {
        List<Station[]> s = null;
        Station des = virtualCurML.getStation(desStation);
        if (des != null) {
            Station[] stationsInThisLine = getStationsInLine(curStation, des, virtualCurML);

            s = new ArrayList<>();
            s.add(stationsInThisLine);
            return s;
        }
        //List<Station[]> s=null;
        ConverterStation curCS = null;
        for (int i = 0; i < virtualCurML.converters.length; i++) {
            ConverterStation cs = (ConverterStation) virtualCurML.stations[virtualCurML.converters[i]];
            if (cs.otherLine != curML) {
                if (s == null) {
                    s = getPath(cs.otherLine.getStation(filter(cs.name)), cs.otherLine, curML, desStation);
                    curCS = cs;
                } else {

                    List<Station[]> s1 = getShorter(s, getPath(cs.otherLine.getStation(filter(cs.name)),
                                    cs.otherLine, curML, desStation), Math.abs(curCS.index - curStation.index),
                            Math.abs(cs.index - curStation.index));

                    if (s1 != s) {
                        curCS = cs;
                        s = s1;
                    }
                }
            }
        }
        if (s == null)
            return null;
        if (curCS != null)
            s.add(getStationsInLine(curStation, (Station) curCS, virtualCurML));
        else s.add(null);
        return s;
    }

    public Station[] getStationsInLine(Station cur, Station des, MetroLine ml) {
        Station[] stationsInThisLine = new Station[Math.abs(cur.index - des.index) + 1];
        int count;
        if (cur.index > des.index)
            count = -1;
        else count = 1;
        for (int i = 0, j = 0; i < stationsInThisLine.length; i++, j += count) {
            stationsInThisLine[i] = ml.stations[cur.index + j];
            //System.out.println(ml.stations.Length +"   "+(cur.index + j));
        }

        return stationsInThisLine;
    }

    static public String filter(String name) {
        String filteredName = "";
        for (int i = 0; i < name.length() - 1; i++) {
            if (name.charAt(i) == ' ' && name.charAt(i + 1) == ' ') continue;
            filteredName += name.charAt(i);
        }
        return filteredName;
    }

    public Station getNearestStation(Location location) {
        Station nearest = MARG_HELWAN_ARR[0];
        double lowestDes = Double.MAX_VALUE;

        for (int i = 0; i < metroLines.length; i++) {
            for (int j = 0; j < metroLines[i].stations.length; j++) {
                double des = getDest(location, metroLines[i].stations[j].latitude, metroLines[i].stations[j].longitude);
                if (des < lowestDes) {
                    lowestDes = des;
                    nearest = metroLines[i].stations[j];
                }
            }
        }

        return nearest;
    }

    double getDest(Location location, double lat, double lng) {
        double latDef = location.getLatitude() - lat;
        double lngDef = location.getLongitude() - lng;

        return (latDef * latDef + lngDef * lngDef);
    }
}
