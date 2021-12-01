abstract class InstrumentSpec {

    public abstract Builder getBuilder();

    public abstract String getModel();

    public abstract Type getType();

    public abstract Wood getBackWood();

    public abstract Wood getTopWood();

    public abstract boolean compareSpec(InstrumentSpec spec);

	public abstract int getNumStrings();

}
