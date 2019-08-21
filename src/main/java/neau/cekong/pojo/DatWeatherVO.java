package neau.cekong.pojo;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

public class DatWeatherVO {

    private String retime;

    private BigDecimal TA;

    private BigDecimal RH;

    private BigDecimal PPM;

    private BigDecimal WD;

    private BigDecimal PRESS;

    private BigDecimal DEPTH;

    private BigDecimal PAR;

    private BigDecimal RA;

    private BigDecimal UV3;

    private BigDecimal NET_R;

    private BigDecimal TS1;

    private BigDecimal TS2;

    private BigDecimal TS3;

    private BigDecimal TS4;

    private BigDecimal TS5;

    private BigDecimal MS1;

    private BigDecimal MS2;

    private BigDecimal MS3;

    private BigDecimal MS4;

    private BigDecimal MS5;

    private BigDecimal WS;

    private BigDecimal RAIN;

    private static DateTimeFormatter df0 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public DatWeatherVO(DatWeather datWeather) {
        this.retime = datWeather.getRetime().format(df0);

        this.setTA(datWeather.getTA());

        this.setRH(datWeather.getRH());

        this.setPPM(datWeather.getPPM());

        this.setWD(datWeather.getWD());

        this.setPRESS(datWeather.getPRESS());

        this.setDEPTH(datWeather.getDEPTH());

        this.setPAR(datWeather.getPAR());

        this.setRA(datWeather.getRA());

        this.setUV3(datWeather.getUV3());

        this.setNET_R(datWeather.getNET_R());

        this.setTS1(datWeather.getTS1());

        this.setTS2(datWeather.getTS2());

        this.setTS3(datWeather.getTS3());

        this.setTS4(datWeather.getTS4());

        this.setTS5(datWeather.getTS5());

        this.setMS1(datWeather.getMS1());

        this.setMS2(datWeather.getMS2());

        this.setMS3(datWeather.getMS3());

        this.setMS4(datWeather.getMS4());

        this.setMS5(datWeather.getMS5());

        this.setWS(datWeather.getWS());

        this.setRAIN(datWeather.getRAIN());

    }

    public String getRetime() {
        return retime;
    }

    public void setRetime(String retime) {
        this.retime = retime;
    }

    public BigDecimal getTA() {
        return TA;
    }

    public void setTA(BigDecimal TA) {
        this.TA = TA;
    }

    public BigDecimal getRH() {
        return RH;
    }

    public void setRH(BigDecimal RH) {
        this.RH = RH;
    }

    public BigDecimal getPPM() {
        return PPM;
    }

    public void setPPM(BigDecimal PPM) {
        this.PPM = PPM;
    }

    public BigDecimal getWD() {
        return WD;
    }

    public void setWD(BigDecimal WD) {
        this.WD = WD;
    }

    public BigDecimal getPRESS() {
        return PRESS;
    }

    public void setPRESS(BigDecimal PRESS) {
        this.PRESS = PRESS;
    }

    public BigDecimal getDEPTH() {
        return DEPTH;
    }

    public void setDEPTH(BigDecimal DEPTH) {
        this.DEPTH = DEPTH;
    }

    public BigDecimal getPAR() {
        return PAR;
    }

    public void setPAR(BigDecimal PAR) {
        this.PAR = PAR;
    }

    public BigDecimal getRA() {
        return RA;
    }

    public void setRA(BigDecimal RA) {
        this.RA = RA;
    }

    public BigDecimal getUV3() {
        return UV3;
    }

    public void setUV3(BigDecimal UV3) {
        this.UV3 = UV3;
    }

    public BigDecimal getNET_R() {
        return NET_R;
    }

    public void setNET_R(BigDecimal NET_R) {
        this.NET_R = NET_R;
    }

    public BigDecimal getTS1() {
        return TS1;
    }

    public void setTS1(BigDecimal TS1) {
        this.TS1 = TS1;
    }

    public BigDecimal getTS2() {
        return TS2;
    }

    public void setTS2(BigDecimal TS2) {
        this.TS2 = TS2;
    }

    public BigDecimal getTS3() {
        return TS3;
    }

    public void setTS3(BigDecimal TS3) {
        this.TS3 = TS3;
    }

    public BigDecimal getTS4() {
        return TS4;
    }

    public void setTS4(BigDecimal TS4) {
        this.TS4 = TS4;
    }

    public BigDecimal getTS5() {
        return TS5;
    }

    public void setTS5(BigDecimal TS5) {
        this.TS5 = TS5;
    }

    public BigDecimal getMS1() {
        return MS1;
    }

    public void setMS1(BigDecimal MS1) {
        this.MS1 = MS1;
    }

    public BigDecimal getMS2() {
        return MS2;
    }

    public void setMS2(BigDecimal MS2) {
        this.MS2 = MS2;
    }

    public BigDecimal getMS3() {
        return MS3;
    }

    public void setMS3(BigDecimal MS3) {
        this.MS3 = MS3;
    }

    public BigDecimal getMS4() {
        return MS4;
    }

    public void setMS4(BigDecimal MS4) {
        this.MS4 = MS4;
    }

    public BigDecimal getMS5() {
        return MS5;
    }

    public void setMS5(BigDecimal MS5) {
        this.MS5 = MS5;
    }

    public BigDecimal getWS() {
        return WS;
    }

    public void setWS(BigDecimal WS) {
        this.WS = WS;
    }

    public BigDecimal getRAIN() {
        return RAIN;
    }

    public void setRAIN(BigDecimal RAIN) {
        this.RAIN = RAIN;
    }
}
