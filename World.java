import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class World {
    public List<Continent> world = new ArrayList<>();
    public String[] ContinentsNames = new String[]{"Europe", "North America", "South America", "Africa", "Australia", "Asia", "Antarctica"};

    public void InitWorld() {
        for (String name : this.ContinentsNames) {
            this.world.add(new Continent(name));
        }

        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();

        try (
                BufferedReader br = new BufferedReader(new FileReader(s + "/src/countries/CName.txt"))) {
            for (String line; (line = br.readLine()) != null; ) {
                int index = (int) (Math.random() * 7);
                int size = 100 + (int)(Math.random() * ((1000000 - 100) + 1));

                for (Continent c : this.world) {
                    if (c.Name.equals(ContinentsNames[index])) {
                        this.world.get(this.world.indexOf(c)).Countrys.add(new Country(line, size));
                    }
                }
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public void Print(){
        for (Continent c : this.world) {
            System.out.println("\nContinent: " + c.Name);
            for (Country coun : c.Countrys) {
                System.out.print("     " + coun.Name);
                for (int i = 0; i < "Latin America  the Caribbean IDA  IBRD countries ".length() - coun.Name.length(); i++){
                    System.out.print(' ');
                }
                System.out.println("Population Size:: " + coun.PopulationSize);
            }
        }
    }

    public int SumWorldPop(){
        int sum = 0;
        for (Continent c : this.world) {
            sum += c.SumContinentPop();
        }
        return sum;
    }
}
