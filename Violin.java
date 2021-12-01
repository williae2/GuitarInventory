public class Violin extends StringInstrument{

    public int serialNumber;
    public double price;
    public InstrumentSpec spec;

    public Violin(int serialNumber, double price, InstrumentSpec spec){
        this.serialNumber = serialNumber;
        this.price = price;
        this.spec = spec;
    }

    @Override
    public int getSerialNumber() {
        return this.serialNumber;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void editInstrumentSpec(InstrumentSpec spec) {
        this.spec = spec;
    }

	@Override
	protected InstrumentSpec getInstrumentSpec() {
		// TODO Auto-generated method stub
		return this.spec;
	}
}
