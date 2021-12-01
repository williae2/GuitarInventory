
public class MandolinSpec extends InstrumentSpec {
	public Builder builder;
	public Type type;
	public Wood topWood;
	public Wood backWood;
	public String model;
	public int numStrings;
	
	public MandolinSpec(Builder b, Type t, Wood tw, Wood bw, String model, int numStrings) {
		this.builder = b;
		this.type = t;
		this.topWood = tw;
		this.backWood = bw;
		this.numStrings = numStrings;
		this.model = model;
	}

	@Override
	Builder getBuilder() {
		// TODO Auto-generated method stub
		return builder;
	}

	@Override
	Type getType() {
		// TODO Auto-generated method stub
		return type;
	}

	@Override
	String getModel() {
		// TODO Auto-generated method stub
		return model;
	}

	@Override
	Wood getTopWood() {
		// TODO Auto-generated method stub
		return topWood;
	}

	@Override
	Wood getBackWood() {
		// TODO Auto-generated method stub
		return backWood;
	}

	@Override
	boolean compareSpec(InstrumentSpec spec) {
		// TODO Auto-generated method stub
		if(builder != spec.getBuilder()) return false;
		if(type != spec.getType()) return false;
		if(model!=null && !model.equals("") &&
				model.equals(spec.getModel())) return false;
		if(topWood != spec.getTopWood()) return false;
		if(backWood != spec.getBackWood()) return false;
		if(numStrings != spec.getNumStrings()) return false;
		return true;
	}

	@Override
	int getNumStrings() {
		// TODO Auto-generated method stub
		return numStrings;
	}

}
