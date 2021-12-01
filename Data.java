import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Data{
	Inventory i;
	public Data(Inventory i) {
		this.i = i;
	}
	public void readFile(){
		ArrayList<StringInstrument> toReturn = new ArrayList<>();
		try {
		      File myObj = new File("inventory.txt");
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
		        	case "Any":
		        		b = Builder.ANY;
		        		break;
		        	case "Fender":
		        		b = Builder.FENDER;
		        		break;
		        	case "Martin":
		        		b = Builder.MARTIN;
		        		break;
		        	case "Gibson":
		        		b = Builder.GIBSON;
		        		break;
		        	case "Collings":
		        		b = Builder.COLLINGS;
		        		break;
		        	case "Olson":
		        		b = Builder.OLSON;
		        		break;
		        	case "Ryan":
		        		b = Builder.RYAN;
		        		break;
		        	case "Prs":
		        		b = Builder.PRS;
		        		break;
		        	default:
		        		b = Builder.ANY;
		        }
		        switch(split[4]) {
		        	case "Electric":
		        		t = Type.ELECTRIC;
		        		break;
		        	case "Acoustic":
		        		t = Type.ACOUSTIC;
		        		break;
		        	default:
		        		t = null;
		        }
		        switch(split[6]) {
		        	case "Indian_Rosewood":
		        		tw = Wood.INDIAN_ROSEWOOD;
		        		break;
		        	case "Brazillian_Rosewood":
		        		tw = Wood.BRAZILLIAN_ROSEWOOD;
		        		break;
		        	case "Mahogany":
		        		tw = Wood.MAHOGANY;
		        		break;
		        	case "Maple":
		        		tw = Wood.MAPLE;
		        		break;
		        	case "Cocobolo":
		        		tw = Wood.COCOBOLO;
		        		break;
		        	case "Cedar":
		        		tw = Wood.CEDAR;
		        		break;
		        	case "Adirondack":
		        		tw = Wood.ADIRONDACK;
		        		break;
		        	case "Alder":
		        		tw = Wood.ALDER;
		        		break;
		        	case "Sitka":
		        		tw = Wood.SITKA;
		        		break;
		        	default:
		        		tw = null;
		        }
		        switch(split[7]) {
		        case "Indian_Rosewood":
	        		bw = Wood.INDIAN_ROSEWOOD;
	        		break;
	        	case "Brazillian_Rosewood":
	        		bw = Wood.BRAZILLIAN_ROSEWOOD;
	        		break;
	        	case "Mahogany":
	        		bw = Wood.MAHOGANY;
	        		break;
	        	case "Maple":
	        		bw = Wood.MAPLE;
	        		break;
	        	case "Cocobolo":
	        		bw = Wood.COCOBOLO;
	        		break;
	        	case "Cedar":
	        		bw = Wood.CEDAR;
	        		break;
	        	case "Adirondack":
	        		bw = Wood.ADIRONDACK;
	        		break;
	        	case "Alder":
	        		bw = Wood.ALDER;
	        		break;
	        	case "Sitka":
	        		bw = Wood.SITKA;
	        		break;
	        	default:
	        		bw = null;
	        }
		        
		        if(split[0].equals("Violin")) {
		        	is = new ViolinSpec(b, t, tw, bw, split[5], Integer.parseInt(split[8]));
		        	si = new Violin(split[1], Double.parseDouble(split[2]), is);
		        } else if(split[0].equals("Mandolin")) {
		        	is = new MandolinSpec(b, t, tw, bw, split[5], Integer.parseInt(split[8]));
		        	si = new Mandolin(split[1], Double.parseDouble(split[2]), is);
		        } else {
		        	is = new GuitarSpec(b, t, tw, bw, split[5], Integer.parseInt(split[8]));
		        	si = new Guitar(split[1], Double.parseDouble(split[2]), is);
		        }
		        i.addInstrumentFromFile(si);
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
		      FileWriter myWriter = new FileWriter("inventory.txt");
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