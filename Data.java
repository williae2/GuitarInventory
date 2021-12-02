import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Data{
	public void readFile(HashMap<InstrumentSpec, ArrayList<StringInstrument>> specMap, ArrayList<StringInstrument> list){
		try {
			File myObj = new File("Inventory.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String[] split = data.split(" ");
				StringInstrument si;
				InstrumentSpec is;
				Type t;
				Wood tw;
				Wood bw;
				Builder b;
				switch(split[3]) {
					case "FENDER":
						b = Builder.FENDER;
						break;
					case "MARTIN":
						b = Builder.MARTIN;
						break;
					case "GIBSON":
						b = Builder.GIBSON;
						break;
					case "PRS":
						b = Builder.PRS;
						break;
					case "GUILD":
						b = Builder.GUILD;
						break;
					case "SEAGULL":
						b = Builder.SEAGULL;
						break;
					case "YAMAHA":
						b = Builder.YAMAHA;
						break;
					case "OVATION":
						b = Builder.OVATION;
						break;
					case "WASHBURN":
						b = Builder.WASHBURN;
						break;
					case "EPIPHONE":
						b = Builder.EPIPHONE;
						break;
					case "ESP":
						b = Builder.ESP;
						break;
					case "GRETSCH":
						b = Builder.GRETSCH;
						break;
					case "IBANEZ":
						b = Builder.IBANEZ;
						break;
					case "TAYLOR":
						b = Builder.TAYLOR;
						break;
					case "RICKENBACKER":
						b = Builder.RICKENBACKER;
						break;
					default:
						b = Builder.GIBSON;
				}
				switch(split[4]) {
					case "ELECTRIC":
						t = Type.ELECTRIC;
						break;
					case "ACOUSTIC":
						t = Type.ACOUSTIC;
						break;
					case "ELECTROACOUSTIC":
						t = Type.ELECTROACOUSTIC;
						break;
					case "BASS":
						t = Type.BASS;
						break;
					default:
						t = Type.OTHER;
				}
				switch(split[6]) {
					case "BASSWOOD":
						tw = Wood.BASSWOOD;
						break;
					case "WALNUT":
						tw = Wood.WALNUT;
						break;
					case "ROSEWOOD":
						tw = Wood.ROSEWOOD;
						break;
					case "EBONY":
						tw = Wood.EBONY;
						break;
					case "WENGE":
						tw = Wood.WENGE;
						break;
					case "MAHOGANY":
						tw = Wood.MAHOGANY;
						break;
					case "MAPLE":
						tw = Wood.MAPLE;
						break;
					case "ALDER":
						tw = Wood.ALDER;
						break;
					default:
						tw = null;
				}
				switch(split[7]) {
					case "BASSWOOD":
						bw = Wood.BASSWOOD;
						break;
					case "WALNUT":
						bw = Wood.WALNUT;
						break;
					case "ROSEWOOD":
						bw = Wood.ROSEWOOD;
						break;
					case "EBONY":
						bw = Wood.EBONY;
						break;
					case "WENGE":
						bw = Wood.WENGE;
						break;
					case "MAHOGANY":
						bw = Wood.MAHOGANY;
						break;
					case "MAPLE":
						bw = Wood.MAPLE;
						break;
					case "ALDER":
						bw = Wood.ALDER;
						break;
					default:
						bw = null;
				}

				if(split[0].equals("Violin")) {
					is = new ViolinSpec(b, t, tw, bw, split[5], Integer.parseInt(split[8]));
					si = new Violin(Integer.parseInt(split[1]), Double.parseDouble(split[2]), is);
				} else if(split[0].equals("Mandolin")) {
					is = new MandolinSpec(b, t, tw, bw, split[5], Integer.parseInt(split[8]));
					si = new Mandolin(Integer.parseInt(split[1]), Double.parseDouble(split[2]), is);
				} else {
					is = new GuitarSpec(b, t, tw, bw, split[5], Integer.parseInt(split[8]));
					si = new Guitar(Integer.parseInt(split[1]), Double.parseDouble(split[2]), is);
				}
				boolean barf = false;
				for(InstrumentSpec i : specMap.keySet()) {
					if(i.compareSpec(is)) {
						ArrayList<StringInstrument> ls = specMap.get(i);
						list.add(si);
						specMap.put(i, list);
						list.add(si);
						barf = true;

					}
				}
				if(!barf) {
					ArrayList<StringInstrument> lst = new ArrayList<>();
					specMap.put(si.getInstrumentSpec(), lst);
					list.add(si);
				}

			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}


	}

	public void writeFile(StringInstrument instrument) {
		try {
			InstrumentSpec s = instrument.getInstrumentSpec();
			FileWriter myWriter = new FileWriter("Inventory.txt");
			myWriter.write(instrument.getClass() +" "+instrument.getSerialNumber()
					+" "+ instrument.getPrice()+" "+s.getBuilder()
					+" "+ s.getType() +" "+ s.getModel()
					+" "+ s.getTopWood()+" "+ s.getBackWood()
					+" "+ s.getNumStrings());
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}