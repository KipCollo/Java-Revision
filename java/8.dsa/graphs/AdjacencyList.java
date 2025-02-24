
import java.util.ArrayList;

public class AdjacencyList {

    private String name;
    private int index;

    private ArrayList<AdjacencyList> neighbors= new ArrayList<>();

    public AdjacencyList(int index, String name) {
        this.index = index;
        this.name = name;
    }

    

}
