package model;

public class Monomial{

	private double coeficient;
	private int exponent;
	boolean parcurs;

	public Monomial(double coeficient, int exponent )
	{

		this.coeficient = coeficient;
		this.exponent = exponent;
	}


	public void setCoeficient(double coeficient )
	{
		this.coeficient = coeficient;
	}

	public double getCoeficient( )
	{
		return coeficient;
	}
	//---------------------------------------------Exponent
	public void setExponent( int exponent )
	{
		this.exponent = exponent;
	}

	protected int getExponent( )
	{
		return exponent;
	}

	public String toString( )
	{
		if( coeficient == 0 && exponent == 0 )
			return "";

		if( coeficient == 0 )
			return "";

		if( exponent == 0 && coeficient > 0 )
			return "+" + coeficient ;

		if( exponent == 0 && coeficient < 0 )
			return  coeficient + "";

		if( coeficient == 1 && exponent == 1 )
			return "+X";

		if( coeficient == -1 && exponent == 1 )
			return "-X";

		if( exponent > 0 && coeficient > 0 )
			return "+" + coeficient + "X^" + exponent;
		else
			return coeficient + "X^" + exponent;
	}

	public void setParcurs( boolean parcurs )
	{
		this.parcurs = parcurs;
	}
	// s-a gasit sau nu un monom de acelasi grad
	public boolean getParcurs( )
	{
		return parcurs;
	}
}

















