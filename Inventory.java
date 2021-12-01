import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {
    public HashMap<InstrumentSpec, ArrayList<StringInstrument>> specMap = new HashMap<>();
    public ArrayList<StringInstrument> list = new ArrayList<>();
    public Data d = new Data(this);

    public void main(String[] args){
    	d.readFile();

    }

    public boolean addInstrument(String type, int serialNumber, double price, InstrumentSpec spec){
        //TODO: check if spec exists in map. if so, add the instrument to the corresponding list. if not, create an entry
        //use boolean to show if addition was successful or not
    	StringInstrument s;
    	if(type.equals("Violin")) {
    		s = new Violin(serialNumber, price, spec);
    	} else if(type.equals("Guitar")) {
    		s = new Guitar(serialNumber, price, spec);
    	} else {
    		s = new Mandolin(serialNumber, price, spec);
    	}
		for(InstrumentSpec i : this.specMap.keySet()) {
			if(i.compareSpec(spec)) {
				ArrayList<StringInstrument> list = this.specMap.get(i);
				list.add(s);
				this.specMap.put(i, list);
				this.list.add(s);
				this.d.writeFile(s);
				return true;
			}
		}
		ArrayList<StringInstrument> list = new ArrayList<>();
		this.specMap.put(spec, list);
		this.list.add(s);
		this.d.writeFile(s);
        return true;
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
    	for(InstrumentSpec i : this.specMap.keySet()) {
			if(i.compareSpec(spec)) {
				ArrayList<StringInstrument> list = this.specMap.get(i);
				return list.size();
			}
		}
        return -1;
    }

	public void addInstrumentFromFile(StringInstrument si) {
		// TODO Auto-generated method stub
		InstrumentSpec is = si.getInstrumentSpec();
		for(InstrumentSpec i : this.specMap.keySet()) {
			if(i.compareSpec(is)) {
				ArrayList<StringInstrument> list = this.specMap.get(i);
				list.add(si);
				this.specMap.put(i, list);
				this.list.add(si);
				return;
			}
		}
		ArrayList<StringInstrument> list = new ArrayList<>();
		this.specMap.put(si.getInstrumentSpec(), list);
		this.list.add(si);
		
	}

}
