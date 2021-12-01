abstract class StringInstrument {

    public abstract int getSerialNumber();

    public abstract double getPrice();

    public abstract void setPrice(double price);

    public abstract void editInstrumentSpec(InstrumentSpec spec);

	protected abstract InstrumentSpec getInstrumentSpec();
}