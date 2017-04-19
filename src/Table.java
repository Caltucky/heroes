/**
 * Created by myron on 3/23/2017.
 */
public class Table {

    private final Integer rID;
    private final String rNAME;
    private final String rTITLE;
    private final String rROLE_1;
    private final String rROLE_2;
    private final Float rHEALTH;
    private final Float rHEALTH_REGEN;
    private final Float rMANA;
    private final Float rMANA_REGEN;
    private final Float rMOVEMENT_SPEED;
    private final Float rATTACK_DAMAGE;
    private final Float rATTACK_SPEED;
    private final Float rATTACK_RANGE;
    private final Float rARMOR;
    private final Float rMAGIC_RESIST;

    public Table() {
        this.rID = null;
        this.rNAME = null;
        this.rTITLE = null;
        this.rROLE_1 = null;
        this.rROLE_2 = null;
        this.rHEALTH = null;
        this.rHEALTH_REGEN = null;
        this.rMANA = null;
        this.rMANA_REGEN = null;
        this.rMOVEMENT_SPEED = null;
        this.rATTACK_DAMAGE = null;
        this.rATTACK_SPEED = null;
        this.rATTACK_RANGE = null;
        this.rARMOR = null;
        this.rMAGIC_RESIST = null;
    }

    public Table(Integer sID, String sName, String sTitle, String sRole_1,
                 String
            sRole_2, Float sHealth, Float sHEALTH_REGEN, Float sMANA, Float
            sMANA_REGEN, Float sMOVEMENT_SPEED, Float sATTACK_DAMAGE, Float
            sATTACK_SPEED, Float sATTACK_RANGE, Float sARMOR, Float
            sMAGIC_RESIST) {

        this.rID = sID;
        this.rNAME = sName;
        this.rTITLE = sTitle;
        this.rROLE_1 = sRole_1;
        this.rROLE_2 = sRole_2;
        this.rHEALTH = sHealth;
        this.rHEALTH_REGEN = sHEALTH_REGEN;
        this.rMANA = sMANA;
        this.rMANA_REGEN = sMANA_REGEN;
        this.rMOVEMENT_SPEED = sMOVEMENT_SPEED;
        this.rATTACK_DAMAGE = sATTACK_DAMAGE;
        this.rATTACK_SPEED = sATTACK_SPEED;
        this.rATTACK_RANGE = sATTACK_RANGE;
        this.rARMOR = sARMOR;
        this.rMAGIC_RESIST = sMAGIC_RESIST;
    }

    public Integer getRID() {
        return rID;
    }

    public String getRNAME() {
        return rNAME;
    }

    public String getRTITLE() {
        return rTITLE;
    }

    public String getRROLE_1() {
        return rROLE_1;
    }

    public String getRROLE_2() {
        return rROLE_2;
    }

    public Float getRHEALTH() {
        return rHEALTH;
    }

    public Float getRHEALTH_REGEN() {
        return rHEALTH_REGEN;
    }

    public Float getRMANA() {
        return rMANA;
    }

    public Float getRMANA_REGEN() { return rMANA_REGEN; }

    public Float getRMOVEMENT_SPEED() {
        return rMOVEMENT_SPEED;
    }

    public Float getRATTACK_DAMAGE() {
        return rATTACK_DAMAGE;
    }

    public Float getRATTACK_SPEED() {
        return rATTACK_SPEED;
    }

    public Float getRATTACK_RANGE() {
        return rATTACK_RANGE;
    }

    public Float getRARMOR() {
        return rARMOR;
    }

    public Float getRMAGIC_RESIST() {
        return rMAGIC_RESIST;
    }
}
