package neau.cekong.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * tb_weather
 * @author 
 */
public class TbWeather implements Serializable {
    private LocalDateTime retime;

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

    private static final long serialVersionUID = 1L;

    public LocalDateTime getRetime() {
        return retime;
    }

    public void setRetime(LocalDateTime retime) {
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

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TbWeather other = (TbWeather) that;
        return (this.getRetime() == null ? other.getRetime() == null : this.getRetime().equals(other.getRetime()))
            && (this.getTA() == null ? other.getTA() == null : this.getTA().equals(other.getTA()))
            && (this.getRH() == null ? other.getRH() == null : this.getRH().equals(other.getRH()))
            && (this.getPPM() == null ? other.getPPM() == null : this.getPPM().equals(other.getPPM()))
            && (this.getWD() == null ? other.getWD() == null : this.getWD().equals(other.getWD()))
            && (this.getPRESS() == null ? other.getPRESS() == null : this.getPRESS().equals(other.getPRESS()))
            && (this.getDEPTH() == null ? other.getDEPTH() == null : this.getDEPTH().equals(other.getDEPTH()))
            && (this.getPAR() == null ? other.getPAR() == null : this.getPAR().equals(other.getPAR()))
            && (this.getRA() == null ? other.getRA() == null : this.getRA().equals(other.getRA()))
            && (this.getUV3() == null ? other.getUV3() == null : this.getUV3().equals(other.getUV3()))
            && (this.getNET_R() == null ? other.getNET_R() == null : this.getNET_R().equals(other.getNET_R()))
            && (this.getTS1() == null ? other.getTS1() == null : this.getTS1().equals(other.getTS1()))
            && (this.getTS2() == null ? other.getTS2() == null : this.getTS2().equals(other.getTS2()))
            && (this.getTS3() == null ? other.getTS3() == null : this.getTS3().equals(other.getTS3()))
            && (this.getTS4() == null ? other.getTS4() == null : this.getTS4().equals(other.getTS4()))
            && (this.getTS5() == null ? other.getTS5() == null : this.getTS5().equals(other.getTS5()))
            && (this.getMS1() == null ? other.getMS1() == null : this.getMS1().equals(other.getMS1()))
            && (this.getMS2() == null ? other.getMS2() == null : this.getMS2().equals(other.getMS2()))
            && (this.getMS3() == null ? other.getMS3() == null : this.getMS3().equals(other.getMS3()))
            && (this.getMS4() == null ? other.getMS4() == null : this.getMS4().equals(other.getMS4()))
            && (this.getMS5() == null ? other.getMS5() == null : this.getMS5().equals(other.getMS5()))
            && (this.getWS() == null ? other.getWS() == null : this.getWS().equals(other.getWS()))
            && (this.getRAIN() == null ? other.getRAIN() == null : this.getRAIN().equals(other.getRAIN()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRetime() == null) ? 0 : getRetime().hashCode());
        result = prime * result + ((getTA() == null) ? 0 : getTA().hashCode());
        result = prime * result + ((getRH() == null) ? 0 : getRH().hashCode());
        result = prime * result + ((getPPM() == null) ? 0 : getPPM().hashCode());
        result = prime * result + ((getWD() == null) ? 0 : getWD().hashCode());
        result = prime * result + ((getPRESS() == null) ? 0 : getPRESS().hashCode());
        result = prime * result + ((getDEPTH() == null) ? 0 : getDEPTH().hashCode());
        result = prime * result + ((getPAR() == null) ? 0 : getPAR().hashCode());
        result = prime * result + ((getRA() == null) ? 0 : getRA().hashCode());
        result = prime * result + ((getUV3() == null) ? 0 : getUV3().hashCode());
        result = prime * result + ((getNET_R() == null) ? 0 : getNET_R().hashCode());
        result = prime * result + ((getTS1() == null) ? 0 : getTS1().hashCode());
        result = prime * result + ((getTS2() == null) ? 0 : getTS2().hashCode());
        result = prime * result + ((getTS3() == null) ? 0 : getTS3().hashCode());
        result = prime * result + ((getTS4() == null) ? 0 : getTS4().hashCode());
        result = prime * result + ((getTS5() == null) ? 0 : getTS5().hashCode());
        result = prime * result + ((getMS1() == null) ? 0 : getMS1().hashCode());
        result = prime * result + ((getMS2() == null) ? 0 : getMS2().hashCode());
        result = prime * result + ((getMS3() == null) ? 0 : getMS3().hashCode());
        result = prime * result + ((getMS4() == null) ? 0 : getMS4().hashCode());
        result = prime * result + ((getMS5() == null) ? 0 : getMS5().hashCode());
        result = prime * result + ((getWS() == null) ? 0 : getWS().hashCode());
        result = prime * result + ((getRAIN() == null) ? 0 : getRAIN().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", retime=").append(retime);
        sb.append(", TA=").append(TA);
        sb.append(", RH=").append(RH);
        sb.append(", PPM=").append(PPM);
        sb.append(", WD=").append(WD);
        sb.append(", PRESS=").append(PRESS);
        sb.append(", DEPTH=").append(DEPTH);
        sb.append(", PAR=").append(PAR);
        sb.append(", RA=").append(RA);
        sb.append(", UV3=").append(UV3);
        sb.append(", NET_R=").append(NET_R);
        sb.append(", TS1=").append(TS1);
        sb.append(", TS2=").append(TS2);
        sb.append(", TS3=").append(TS3);
        sb.append(", TS4=").append(TS4);
        sb.append(", TS5=").append(TS5);
        sb.append(", MS1=").append(MS1);
        sb.append(", MS2=").append(MS2);
        sb.append(", MS3=").append(MS3);
        sb.append(", MS4=").append(MS4);
        sb.append(", MS5=").append(MS5);
        sb.append(", WS=").append(WS);
        sb.append(", RAIN=").append(RAIN);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}