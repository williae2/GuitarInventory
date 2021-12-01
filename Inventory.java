import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {
    public HashMap<InstrumentSpec, ArrayList<StringInstrument>> specMap;

    public static void main(String[] args){

    }

    public boolean addInstrument(int serialNumber, double price, InstrumentSpec spec){
        //TODO: check if spec exists in map. if so, add the instrument to the corresponding list. if not, create an entry
        //use boolean to show if addition was successful or not

        return false;
    }

    public boolean removeInstrument(StringInstrument instrument){
        //TODO: remove specified instrument. use boolean to show if removal was successful or not.

        return false;
    }

    public StringInstrument getInstrument(String searchString){
        //TODO: figure out what we are doing here.
        return null;
    }

    public ArrayList<StringInstrument> search(InstrumentSpec spec){
        //TODO: use attributes in spec and find all specs that match what is in the param.

        return null;
    }

    public int getQuantity(InstrumentSpec spec){
        //TODO: find length of list corresponding spec. -1 if the spec does not exist.

        return -1;
    }

}
