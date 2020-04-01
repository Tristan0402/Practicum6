

import java.util.ArrayList;

public class Persoon {
        private ArrayList<Game> mijnGames = new ArrayList<>();
        private String naam;
        private double budget;

        public Persoon(String nm, double bud){
            this.naam = nm;
            this.budget = bud;
        }

        public double getBudget(){
            return budget;
        }

        public boolean koop(Game g){
            for (Game item: mijnGames) {
                if (item.toString().equals(g.toString())) {
                    return false;
                }
            }
            if (this.budget < g.huidigeWaarde()) {
                return false;
            }else{
                mijnGames.add(g);
                this.budget -= g.huidigeWaarde();
                return true;
            }
        }

        public boolean verkoop(Game g, Persoon koper){
            for (Game item : koper.mijnGames) {
                if (item.toString().equals(g.toString())){
                    return false;
                }
            }
            for (Game item : mijnGames) {
                if (item.toString().equals(g.toString()) && koper.budget >= g.huidigeWaarde()){
                    mijnGames.remove(item);
                    this.budget += g.huidigeWaarde();
                    koper.budget -= g.huidigeWaarde();
                    koper.mijnGames.add(g);
                    return true;
                }
            }
            return false;
        }

    public ArrayList<Game> bepaalGamesNietInBezit(ArrayList<Game> a) {
            ArrayList<Game> aap = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            for (Game item : this.mijnGames) {
                if (item.equals(a.get(i))) {
                } else {
                    aap.add(a.get(i));
                }
            }
        }
        return aap;
    }

        public String toString(){
            String output = this.naam + " heeft een budget van €" + String.format("%.2f", this.budget) + " en bezit de volgende games:";
            for (Game item : mijnGames) {
                output += "\n" + item.toString();
            }
            return output;
        }
}
