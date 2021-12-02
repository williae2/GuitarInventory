import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Inventory {
    public static HashMap<InstrumentSpec, ArrayList<StringInstrument>> specMap = new HashMap<>();
    public static ArrayList<StringInstrument> list = new ArrayList<>();
    public static Data d = new Data();

    public static void main(String[] args){
    	d.readFile(specMap, list);
		System.out.println("Hello! Please type in what you would like to do (REMOVE, ADD, or SEARCH)");
		System.out.print("> ");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		String name1 = name.toLowerCase();
		if(name1.equals("remove")) {

		} else if(name1.equals("add")) {
			System.out.println("State the Instrument(Violin, Mandolin, Guitar), Serial Number, Price, Model, Type, Builder, Top wood, Back wood, and number of strings to add a new instrument");
			System.out.println("> ");
			name = sc.nextLine();
			name1 = name.toLowerCase();
			System.out.println(name1);
			String[] strip = name1.split(" ");


		} else if(name1.equals("search")) {

		} else {
			System.out.println("You did not choose a valid action.");
		}
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
		InstrumentSpec spec = instrument.getInstrumentSpec();
		return specMap.get(spec).remove(instrument);
    }

    public ArrayList<StringInstrument> search(InstrumentSpec spec){
        //TODO: use attributes in spec and find all specs that match what is in the param.
		ArrayList<StringInstrument> res = specMap.get(spec);
		if(res==null){
			return new ArrayList<StringInstrument>();
		}
		return specMap.get(spec);
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
