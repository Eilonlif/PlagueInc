import java.util.ArrayList;
import java.util.List;

public class Continent {
    public String Name;
    public int level;
    public Continent (String ContinentName){
        this.Name = ContinentName;
    }

    public List<Country> Countrys = new ArrayList<>();

    public int SumContinentPop(){
        int sum = 0;
        for (Country c : this.Countrys) {
            sum += c.PopulationSize;
        }
        return sum;
    }
}
