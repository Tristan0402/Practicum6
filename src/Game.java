import java.time.LocalDate;

public class Game {
    private String naam;
    private int releaseJaar;
    private double nieuwprijs;

    public Game(String nm, int rJ, double nwpr){
        this.naam = nm;
        this.releaseJaar = rJ;
        this.nieuwprijs = nwpr;
    }

    public String getNaam(){
        return naam;
    }

    public double huidigeWaarde(){
        int Jaar = LocalDate.now().getYear();
        return (Math.pow(Jaar - releaseJaar, 0.3)) * nieuwprijs;
   }
    @Override
    public boolean equals(Object andereObject){
        boolean gelijkeObjecten = false;
        if(andereObject instanceof Game){
            Game andereGame = (Game) andereObject;
            if (this.naam.equals(andereGame.naam) && this.releaseJaar == andereGame.releaseJaar){
                gelijkeObjecten = true;
            }
        }
        return gelijkeObjecten;
    }

    public String toString() {
        return this.naam + ", uitgegeven in " + this.releaseJaar + "; nieuwprijs: €" + String.format("%.2f", this.nieuwprijs) + " nu voor: €" + String.format("%.2f", this.huidigeWaarde());
    }
}
