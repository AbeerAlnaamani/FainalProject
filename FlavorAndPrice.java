import java.util.Objects;

/**
 * Created by DELL on 26/10/2022.
 */
public class FlavorAndPrice {

   private int idF;
    private String lavorss;
    private double price;
    public static int counter1=0;
    
//    private double cakebyCarmel=1500;
//    double cakeLotus=1500;
//   double FourSeasons=1800;
//    double cheesecakeAoryou=1000;
//    double cheesecakAupra=2200;


    //    public FlavorAndPrice(){}
//    public FlavorAndPrice( double cakeC,double cakeL,double FourS,double cheesecakeAo,double  cheesecakAu){
//
//       cakeC= cakebyCarmel;
//       cakeL= cakeLotus=1500;
//       FourS= FourSeasons=1800;
//       cheesecakeAo= cheesecakeAoryou=1000;
//       cheesecakAu= cheesecakAupra=2200;
//
//    }


    public FlavorAndPrice(int idF, String lavorss, double price) {
        this.idF = idF;
        this.lavorss = lavorss;
        this.price = price;
    }

    public int getidF() {
        return idF;
    }

    public void setidF(int idF) {
        this.idF = idF;
    }

    public String getLavorss() {
        return lavorss;
    }

    public void setLavorss(String lavorss) {
        this.lavorss = lavorss;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return
                 idF +"\t"+ lavorss  +"\t"+
                 price +"\n"
                ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlavorAndPrice that = (FlavorAndPrice) o;
        return idF == that.idF && Double.compare(that.price, price) == 0 && lavorss.equals(that.lavorss);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idF, lavorss, price);
    }
    //    @Override
//    public String toString() {
//        return "FlavorAndPrice{" +
//                "cakebyCarmel=" + cakebyCarmel +
//                ", cakeLotus=" + cakeLotus +
//                ", FourSeasons=" + FourSeasons +
//                ", cheesecakeAoryou=" + cheesecakeAoryou +
//                ", cheesecakAupra=" + cheesecakAupra +
//                '}';
//    }
//
//    public double getCakebyCarmel() {
//        return cakebyCarmel;
//    }
//
//    public void setCakebyCarmel(double cakebyCarmel) {
//        this.cakebyCarmel = cakebyCarmel;
//    }
//
//    public double getCakeLotus() {
//        return cakeLotus;
//    }
//
//    public void setCakeLotus(double cakeLotus) {
//        this.cakeLotus = cakeLotus;
//    }
//
//    public double getFourSeasons() {
//        return FourSeasons;
//    }
//
//    public void setFourSeasons(double fourSeasons) {
//        FourSeasons = fourSeasons;
//    }
//
//    public double getCheesecakeAoryou() {
//        return cheesecakeAoryou;
//    }
//
//    public void setCheesecakeAoryou(double cheesecakeAoryou) {
//        this.cheesecakeAoryou = cheesecakeAoryou;
//    }
//
//    public double getCheesecakAupra() {
//        return cheesecakAupra;
//    }
//
//    public void setCheesecakAupra(double cheesecakAupra) {
//        this.cheesecakAupra = cheesecakAupra;
//    }
//}
//

}
